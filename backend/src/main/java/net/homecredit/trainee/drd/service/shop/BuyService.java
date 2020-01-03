package net.homecredit.trainee.drd.service.shop;


import net.homecredit.trainee.drd.entity.blueprint.item.*;
import net.homecredit.trainee.drd.entity.character.Character;
import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.entity.inventory.armor.Armor;
import net.homecredit.trainee.drd.entity.inventory.weapon.Weapon;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.entity.shop.ShopItem;
import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.item.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class BuyService {
    private InventoryService inventoryService;
    private StorageService storageService;
    private ArmorService armorService;
    private ArmorBlueprintService armorBlueprintService;
    private GoodsService goodsService;
    private GoodsBlueprintService goodsBlueprintService;
    private TreasureService treasureService;
    private TreasureBlueprintService treasureBlueprintService;
    private WeaponService weaponService;
    private WeaponBlueprintService weaponBlueprintService;

    public BuyService(InventoryService inventoryService, StorageService storageService, ArmorService armorService, ArmorBlueprintService armorBlueprintService, GoodsService goodsService, GoodsBlueprintService goodsBlueprintService, TreasureService treasureService, TreasureBlueprintService treasureBlueprintService, WeaponService weaponService, WeaponBlueprintService weaponBlueprintService) {
        this.inventoryService = inventoryService;
        this.storageService = storageService;
        this.armorService = armorService;
        this.armorBlueprintService = armorBlueprintService;
        this.goodsService = goodsService;
        this.goodsBlueprintService = goodsBlueprintService;
        this.treasureService = treasureService;
        this.treasureBlueprintService = treasureBlueprintService;
        this.weaponService = weaponService;
        this.weaponBlueprintService = weaponBlueprintService;
    }

    public boolean buyItem(UUID blueprintId, ItemType itemType, Character character, double price, boolean coinPouch) {
        Inventory inventory = character.getInventory();
        StorageUnit storageUnit = inventoryService.getDefaultStorageUnit(inventory);
        switch (itemType) {
            case ARMOR: return buyArmor(inventory, storageUnit, blueprintId, price, coinPouch);
            case WEAPONS:
                return buyWeapon(inventory, storageUnit, blueprintId, price, coinPouch);

            case TREASURE: return buyTreasure(inventory, storageUnit, blueprintId, price, coinPouch);
            default: return buyGoods(inventory, storageUnit, blueprintId, price, coinPouch);
        }
    }

    private boolean buyGoods(Inventory inventory, StorageUnit storageUnit, UUID blueprintId, double price, boolean coinPouch){
        GoodsBlueprint goodsBlueprint = goodsBlueprintService.findBlueprint(blueprintId);
        Equipment goods = goodsService.forgeGoods(goodsBlueprint);
        if(inventoryService.addEquipment(inventory, storageUnit, goods)){
            inventoryService.payMoney(inventory, price, coinPouch);
        }
        return false;
    }

    private boolean buyTreasure(Inventory inventory, StorageUnit storageUnit, UUID blueprintId, double price, boolean coinPouch) {
        TreasureBlueprint treasureBlueprint = treasureBlueprintService.findBlueprint(blueprintId);
        Equipment treasure = treasureService.forgeTreasure(treasureBlueprint);
        if(inventoryService.addEquipment(inventory, storageUnit, treasure)){
            return inventoryService.payMoney(inventory, price, coinPouch);
        }
        return false;

    }

    private boolean buyWeapon(Inventory inventory, StorageUnit storageUnit, UUID blueprintId, double price, boolean coinPouch) {
        WeaponBlueprint weaponBlueprint = weaponBlueprintService.findBlueprint(blueprintId);
        Weapon weapon = weaponService.forgeWeapon(weaponBlueprint);
        if(inventoryService.addEquipment(inventory, storageUnit, weapon)){
            return inventoryService.payMoney(inventory, price, coinPouch);
        }
        return false;
    }

    private boolean buyArmor(Inventory inventory, StorageUnit storageUnit, UUID blueprintId, double price, boolean coinPouch) {
        ArmorBlueprint armorBlueprint = armorBlueprintService.findBlueprint(blueprintId);
        Armor armor = armorService.forgeArmor(armorBlueprint);
        if(inventoryService.addEquipment(inventory, storageUnit, armor)){
            return inventoryService.payMoney(inventory, price, coinPouch);
        }
        return false;
    }
}
package net.homecredit.trainee.drd.service.item;

import net.homecredit.trainee.drd.entity.blueprint.item.ItemBlueprint;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.entity.inventory.armor.Armor;
import net.homecredit.trainee.drd.entity.inventory.weapon.Weapon;
import net.homecredit.trainee.drd.repository.inventory.InventoryRepository;
import net.homecredit.trainee.drd.util.StorageEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class InventoryService implements ApplicationListener<StorageEvent> {
    private static final int CAPACITY_BASE = 360;
    private static final int CAPACITY_INCREMENT = 30;
    private static final int CAPACITY_STEPS = 4;

    private InventoryRepository inventoryRepository;
    private StorageService storageService;

    public InventoryService(InventoryRepository inventoryRepository, StorageService storageService) {
        this.inventoryRepository = inventoryRepository;
        this.storageService = storageService;
    }

    //creates Inventory with default Storage Unit
    public Inventory createInventory(AbilityScore strength) {
        int maximumCapacity = (CAPACITY_BASE + strength.getAbilityBonusValue() * CAPACITY_INCREMENT) * CAPACITY_STEPS;
        Collection<StorageUnit> initialStorage = new ArrayList<>();
        //value of coin pouch should be zero, just for testing it is 10
        Inventory initialInventory = new Inventory(maximumCapacity, 0, 10, 0, initialStorage);

        StorageUnit initialStorageUnit = storageService.createDefaultStorage(initialInventory);
        initialInventory.getStorageUnits().add(initialStorageUnit);

        inventoryRepository.saveInventory(initialInventory);

        return initialInventory;
    }

    public Inventory copyBlueprintInventory(Inventory templateInventory) {
        return new Inventory();
    }

    public StorageUnit findInitialStorage(Inventory inventory) {
        for (StorageUnit su : inventory.getStorageUnits()) {
            if (su.getWeight() == 0) {
                return su;
            }
        }
        throw new NullPointerException("Inventory has no initial storage!");
    }

    public StorageUnit getDefaultStorageUnit(Inventory inventory) {
        for(StorageUnit st : inventory.getStorageUnits()){
            if(st.isDefaultStorage()){
                return st;
            }
        }
        throw new RuntimeException("Default Storage Unit not found");
    }

    public Weapon getActiveWeapon(Inventory inventory) {
        return new Weapon();
    }

    public List<Armor> getEquippedArmor(Inventory inventory) {
        List<Armor> equippedArmor = new ArrayList<>();
        return equippedArmor;
    }

    public StorageUnit createBlueprintStorage() {
        return new StorageUnit();
    }

//    public Inventory addStorageUnitToInventory(Inventory targetInventory, StorageUnit newStorageUnit) {
//        targetInventory.getInventory().add(newStorageUnit);
//        return targetInventory;
//    }

    public boolean moveEquipment(Equipment equipment) {
        return true;
    }

    public void clearInventory() {

    }

    public void deleteAll() {
        inventoryRepository.deleteAll();
    }

    public void deletedStorageUnit() {

    }

    public void deleteEquipment() {

    }

//    public double usedCapacity(StorageUnit storageUnit) {
//
//    }

    private void addWeaponToArsenal(Weapon weapon) {

    }

    private void addArmorToArsenal(Armor armor) {

    }

    private void adjustBaseStorage() {

    }

    public void increaseContentWeight(Inventory inventory, int weight) {
        if (inventory.getFreeSpace() >= weight) {
            inventory.setContentWeight(inventory.getContentWeight() + weight);
        }
        inventoryRepository.updateInventory(inventory);
    }

    public boolean payMoney(Inventory inventory, double price, boolean coinPouch) {
        if (coinPouch) {
            if(inventory.getCoinPouch() >= price){
                inventory.setCoinPouch(inventory.getCoinPouch() - price);
                inventoryRepository.updateInventory(inventory);
                return true;
            }
        } else{
            if(inventory.getBankVault() >= price){
                inventory.setBankVault(inventory.getBankVault() - price);
                inventoryRepository.updateInventory(inventory);
                return true;
            }
        }
        throw new RuntimeException("You don't have enough money");
    }

    @Override
    public void onApplicationEvent(StorageEvent event) {
        Inventory inventory = event.getStorageUnit().getInventory();
        increaseContentWeight(inventory, event.getWeight());
    }

    public boolean addEquipment(Inventory inventory, StorageUnit storageUnit, Equipment equipment){
        if (inventory.getFreeSpace() >= equipment.getWeight()) {
            return storageService.addEquipmentToStorageUnit(storageUnit, equipment);
        }
        throw new RuntimeException("You don't have enough space in the inventory");
    }
}

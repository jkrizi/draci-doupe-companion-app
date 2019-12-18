package net.homecredit.trainee.drd.service.item;

import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import net.homecredit.trainee.drd.entity.inventory.StorageUnit;
import net.homecredit.trainee.drd.entity.inventory.armor.Armor;
import net.homecredit.trainee.drd.entity.inventory.weapon.Weapon;
import net.homecredit.trainee.drd.repository.inventory.InventoryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
public class InventoryService {
    private static final int CAPACITY_BASE = 360;
    private static final int CAPACITY_INCREMENT = 30;
    private static final int CAPACITY_STEPS = 4;

    private InventoryRepository inventoryRepository;
    private StorageService storageService;

    public InventoryService(InventoryRepository inventoryRepository, StorageService storageService) {
        this.inventoryRepository = inventoryRepository;
        this.storageService = storageService;
    }

    public Inventory createInventory(AbilityScore strength) {
        int maximumCapacity = (CAPACITY_BASE + strength.getAbilityBonusValue() * CAPACITY_INCREMENT) * CAPACITY_STEPS;
        Collection<StorageUnit> initialStorage = new ArrayList<>();
        Inventory initialInventory = new Inventory(maximumCapacity, 0, 0, 0,initialStorage);

        StorageUnit initialStorageUnit = storageService.createDefaultStorage(initialInventory);
        initialInventory.getStorageUnits().add(initialStorageUnit);

        inventoryRepository.saveInventory(initialInventory);

        return initialInventory;
    }

    public Inventory copyBlueprintInventory(Inventory templateInventory) {
        return new Inventory();
    }

    public StorageUnit findInitialStorage(Inventory inventory) {
        for(StorageUnit su: inventory.getStorageUnits()) {
            if(su.getWeight() == 0) {
                return su;
            }
        }
        throw new NullPointerException("Inventory has no initial storage!");
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

    public StorageUnit addEquipmentToStorageUnit(StorageUnit targetUnit, Equipment storedItem) {
        return targetUnit;
    }

    public boolean moveEquipment(Equipment equipment) {
        return true;
    }

    public void clearInventory() {

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
}

package net.homecredit.trainee.drd.configuration;

import net.homecredit.trainee.drd.controller.dto.*;
import net.homecredit.trainee.drd.repository.blueprint.*;
import net.homecredit.trainee.drd.repository.character.BeastRepository;
import net.homecredit.trainee.drd.repository.character.RaceRepository;
import net.homecredit.trainee.drd.repository.character.SpellRepository;
import net.homecredit.trainee.drd.repository.character.SwordMoveRepository;
import net.homecredit.trainee.drd.repository.inventory.*;
import net.homecredit.trainee.drd.repository.shop.ShopRepository;
import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.character.BeastService;
import net.homecredit.trainee.drd.service.character.CombatService;
import net.homecredit.trainee.drd.service.character.RaceService;
import net.homecredit.trainee.drd.service.character.profession.SpellService;
import net.homecredit.trainee.drd.service.character.profession.SwordMoveService;
import net.homecredit.trainee.drd.service.item.*;
import net.homecredit.trainee.drd.service.shop.BuyService;
import net.homecredit.trainee.drd.service.shop.ShopService;
import net.homecredit.trainee.drd.util.Dice;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ServiceConfiguration {

    @Bean
    public SwordMoveService swordMoveService(SwordMoveRepository swordMoveRepository) {return new SwordMoveService(swordMoveRepository); }

    @Bean
    public SpellService spellService(SpellRepository spellRepository) {return new SpellService(spellRepository); }

    @Bean
    public BeastBlueprintService beastBlueprintService(BeastBlueprintRepository beastBlueprintRepository, InventoryService inventoryService, CombatService combatService) {
        return new BeastBlueprintService(beastBlueprintRepository, inventoryService, combatService);
    }

    @Bean
    public BeastService beastService(BeastRepository beastRepository, net.homecredit.trainee.drd.util.Dice dice, CombatService combatService, InventoryService inventoryService) {
        return new BeastService(beastRepository, dice, combatService, inventoryService);
    }

    @Bean
    public CombatService combatService(InventoryService inventoryService) {
        return new CombatService(inventoryService);
    }

    @Bean
    public WeaponBlueprintService weaponBlueprintService(WeaponBlueprintRepository weaponBlueprintRepository, ShopService shopService) {
        return new WeaponBlueprintService(weaponBlueprintRepository, shopService);
    }

    @Bean
    public ArmorBlueprintService armorBlueprintService(ArmorBlueprintRepository armorBlueprintRepository, ShopService shopService) {
        return new ArmorBlueprintService(armorBlueprintRepository, shopService);
    }

    @Bean
    public GoodsBlueprintService goodsBlueprintService(GoodsBlueprintRepository goodsBlueprintRepository, ShopService shopService) {
        return new GoodsBlueprintService(goodsBlueprintRepository, shopService);
    }

    @Bean
    public TreasureBlueprintService treasureBlueprintService(TreasureBlueprintRepository treasureBlueprintRepository, GemstoneBlueprintRepository gemStoneBlueprintRepository, ShopService shopService) {
        return new TreasureBlueprintService(treasureBlueprintRepository, gemStoneBlueprintRepository, shopService);
    }

    @Bean
    public EquipmentService equipmentService() {
        return new EquipmentService();
    }

    @Bean
    public InventoryService inventoryService(InventoryRepository inventoryRepository, StorageService storageService) {
        return new InventoryService(inventoryRepository, storageService);
    }

    @Bean
    public StorageService storageService(StorageRepository storageRepository, ApplicationEventPublisher applicationEventPublisher) {
        return new StorageService(storageRepository, applicationEventPublisher);
    }

    @Bean
    public WeaponService weaponService(WeaponRepository weaponRepository) {
        return new WeaponService(weaponRepository);
    }

    @Bean
    public ArmorService armorService(ArmorRepository armorRepository) {
        return new ArmorService(armorRepository);
    }

    @Bean
    public GoodsService goodsService(EquipmentRepository equipmentRepository) {
        return new GoodsService(equipmentRepository);
    }

    @Bean
    public TreasureService treasureService(EquipmentRepository equipmentRepository) {
        return new TreasureService(equipmentRepository);
    }

    @Bean
    public ShopService shopService(ShopRepository shopRepository) {
        return new ShopService(shopRepository);
    }

    @Bean
    public BuyService buyService(InventoryService inventoryService, ArmorService armorService, ArmorBlueprintService armorBlueprintService, GoodsService goodsService, GoodsBlueprintService goodsBlueprintService, TreasureService treasureService, TreasureBlueprintService treasureBlueprintService, WeaponService weaponService, WeaponBlueprintService weaponBlueprintService) {
        return new BuyService(inventoryService, armorService, armorBlueprintService, goodsService, goodsBlueprintService, treasureService, treasureBlueprintService, weaponService, weaponBlueprintService);
    }

    @Bean
    public Dice dice(Random random) {
        return new Dice(random);
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public WeaponBlueprintDtoConverter weaponBlueprintDtoConverter(){
        return new WeaponBlueprintDtoConverter();
    }

    @Bean
    public BeastBlueprintDtoConverter beastBlueprintDtoConverter(){
        return new BeastBlueprintDtoConverter();
    }

    @Bean
    public ArmorBlueprintDtoConverter armorBlueprintDtoConverter(){
        return new ArmorBlueprintDtoConverter();
    }

    @Bean
    public GoodsBlueprintDtoConverter goodsBlueprintDtoConverter(){
        return new GoodsBlueprintDtoConverter();
    }
}

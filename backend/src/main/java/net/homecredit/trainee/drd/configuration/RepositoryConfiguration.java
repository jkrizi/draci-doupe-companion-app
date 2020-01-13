package net.homecredit.trainee.drd.configuration;

import net.homecredit.trainee.drd.repository.blueprint.*;
import net.homecredit.trainee.drd.repository.character.BeastRepository;
import net.homecredit.trainee.drd.repository.character.KnowHowRepository;
import net.homecredit.trainee.drd.repository.character.RaceRepository;
import net.homecredit.trainee.drd.repository.inventory.*;
import net.homecredit.trainee.drd.repository.shop.ShopRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public RaceRepository raceRepository(EntityManager em) {
        return new RaceRepository(em);
    }

    @Bean
    public KnowHowRepository knowHowRepository(EntityManager em) {
        return new KnowHowRepository(em);
    }

    @Bean
    public ArmorRepository armorRepository(EntityManager em) {
        return new ArmorRepository(em);
    }

    @Bean
    public EquipmentRepository equipmentRepository(EntityManager em) {
        return new EquipmentRepository(em);
    }

    @Bean
    public BeastBlueprintRepository beastBlueprintRepository(EntityManager em) {
        return new BeastBlueprintRepository(em);
    }

    @Bean
    public BeastRepository beastRepository(EntityManager em) {
        return new BeastRepository(em);
    }

    @Bean
    public WeaponBlueprintRepository weaponBlueprintRepository(EntityManager em) {
        return new WeaponBlueprintRepository(em);
    }

    @Bean
    public ArmorBlueprintRepository armorBlueprintRepository(EntityManager em) {
        return new ArmorBlueprintRepository(em);
    }

    @Bean
    public GoodsBlueprintRepository goodsBlueprintRepository(EntityManager em) {
        return new GoodsBlueprintRepository(em);
    }

    @Bean
    public TreasureBlueprintRepository treasureBlueprintRepository(EntityManager em) {
        return new TreasureBlueprintRepository(em);
    }

    @Bean
    public InventoryRepository inventoryRepository(EntityManager em) {
        return new InventoryRepository(em);
    }

    @Bean
    public StorageRepository storageRepository(EntityManager em) {
        return new StorageRepository(em);
    }

    @Bean
    public WeaponRepository weaponRepository(EntityManager em) {
        return new WeaponRepository(em);
    }

    @Bean
    public ShopRepository shopRepository(EntityManager em) {
        return new ShopRepository(em);
    }
}

package net.homecredit.trainee;

import net.homecredit.trainee.repository.blueprint.*;
import net.homecredit.trainee.repository.character.BeastRepository;
import net.homecredit.trainee.repository.character.KnowHowRepository;
import net.homecredit.trainee.repository.inventory.InventoryRepository;
import net.homecredit.trainee.repository.inventory.StorageRepository;
import net.homecredit.trainee.repository.inventory.WeaponRepository;
import net.homecredit.trainee.repository.shop.ShopRepository;
import net.homecredit.trainee.service.blueprint.*;
import net.homecredit.trainee.service.character.BeastService;
import net.homecredit.trainee.service.character.CombatService;
import net.homecredit.trainee.service.item.InventoryService;
import net.homecredit.trainee.service.item.StorageService;
import net.homecredit.trainee.service.item.WeaponService;
import net.homecredit.trainee.service.shop.ShopService;
import net.homecredit.trainee.util.Dice;
import oracle.jdbc.datasource.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@EnableTransactionManagement
@Configuration
public class AppConfig {

    @Bean
    public KnowHowRepository knowHowRepository(EntityManager em) {
        return new KnowHowRepository(em);
    }

    @Bean
    public BeastBlueprintService beastBlueprintService(BeastBlueprintRepository beastBlueprintRepository, InventoryService inventoryService, CombatService combatService) {
        return new BeastBlueprintService(beastBlueprintRepository, inventoryService, combatService);
    }

    @Bean
    public BeastService beastService(BeastRepository beastRepository, Dice dice, CombatService combatService, InventoryService inventoryService) {
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
    public ArmorBlueprintService armorBlueprintService(ArmorBlueprintRepository armorBlueprintRepository, ShopService shopService){
        return new ArmorBlueprintService(armorBlueprintRepository, shopService);
    }

    @Bean
    public GoodsBlueprintService goodsBlueprintService(GoodsBlueprintRepository goodsBlueprintRepository, ShopService shopService){
        return new GoodsBlueprintService(goodsBlueprintRepository, shopService);
    }

    @Bean
    public TreasureBlueprintService treasureBlueprintService(TreasureBlueprintRepository treasureBlueprintRepository, ShopService shopService){
        return new TreasureBlueprintService(treasureBlueprintRepository, shopService);
    }

    @Bean
    public InventoryService inventoryService(InventoryRepository inventoryRepository, StorageService storageService) {
        return new InventoryService(inventoryRepository, storageService);
    }

    @Bean
    public StorageService storageService(StorageRepository storageRepository) {
        return new StorageService(storageRepository);
    }

    @Bean
    public WeaponService weaponService(WeaponRepository weaponRepository) {
        return new WeaponService(weaponRepository);
    }

    @Bean
    public ShopService shopService(ShopRepository shopRepository) {
        return new ShopService(shopRepository);
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
    public BeastBlueprintRepository beastBlueprintRepository(EntityManager em) {
        return new BeastBlueprintRepository(em);
    }

    @Bean
    public BeastRepository beastRepository(EntityManager em) { return new BeastRepository(em); }

    @Bean
    public WeaponBlueprintRepository weaponBlueprintRepository(EntityManager em) { return new WeaponBlueprintRepository(em);}

    @Bean
    public ArmorBlueprintRepository armorBlueprintRepository(EntityManager em){ return new ArmorBlueprintRepository(em);}

    @Bean
    public GoodsBlueprintRepository goodsBlueprintRepository(EntityManager em){ return new GoodsBlueprintRepository(em);}

    @Bean
    public TreasureBlueprintRepository treasureBlueprintRepository(EntityManager em){ return new TreasureBlueprintRepository(em);}

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
    public ShopRepository shopRepository(EntityManager em) {return new ShopRepository(em); }

    @Bean
    public SharedEntityManagerBean containerManagedEntityManager(EntityManagerFactory emf) {
        SharedEntityManagerBean entityManagerBean = new SharedEntityManagerBean();
        entityManagerBean.setEntityManagerFactory(emf);
        return entityManagerBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource ds) {
        Map<String, Object> props = new HashMap<>();
        props.put("javax.persistence.nonJtaDataSource", ds);
        return Persistence.createEntityManagerFactory("PersistenceUnit", props);
    }

    @Bean
    public DataSource dataSource() throws SQLException {
         OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
         ds.setURL("jdbc:oracle:thin:@localhost:1521:XE");
         ds.setUser("c##dracidoupe");
         ds.setPassword("JavaTrainee");
         return ds;
    }
}

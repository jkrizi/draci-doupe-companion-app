package net.homecredit.trainee.drd;

import net.homecredit.trainee.drd.configuration.RepositoryConfiguration;
import net.homecredit.trainee.drd.configuration.ServiceConfiguration;
import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.character.BeastService;
import net.homecredit.trainee.drd.service.item.*;
import net.homecredit.trainee.drd.service.shop.BuyService;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@Import({RepositoryConfiguration.class, ServiceConfiguration.class})
public class BackEndApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BackEndApplication.class, args);
        Demo2 demo2 = new Demo2();
        ArmorService armorService = applicationContext.getBean(ArmorService.class);
        GoodsService goodsService = applicationContext.getBean(GoodsService.class);
        TreasureService treasureService = applicationContext.getBean(TreasureService.class);
        InventoryService inventoryService = applicationContext.getBean(InventoryService.class);
        BeastBlueprintService beastBlueprintService = applicationContext.getBean(BeastBlueprintService.class);
        BeastService beastService = applicationContext.getBean(BeastService.class);
        StorageService storageService = applicationContext.getBean(StorageService.class);
        WeaponService weaponService = applicationContext.getBean(WeaponService.class);

        WeaponBlueprintService weaponBlueprintService = applicationContext.getBean(WeaponBlueprintService.class);
        TreasureBlueprintService treasureBlueprintService = applicationContext.getBean(TreasureBlueprintService.class);
        ArmorBlueprintService armorBlueprintService = applicationContext.getBean(ArmorBlueprintService.class);
        GoodsBlueprintService goodsBlueprintService = applicationContext.getBean(GoodsBlueprintService.class);

        //creates items blueprints and shopitems in the database
//		demo2.setBroadSwordBlueprint(weaponBlueprintService);
//		demo2.setTestTreasureBlueprint(treasureBlueprintService);
//		demo2.setTestArmorBlueprint(armorBlueprintService);
//		demo2.setTestGoodsBlueprint(goodsBlueprintService);

        ShopService shopService = applicationContext.getBean(ShopService.class);
        BuyService buyService = applicationContext.getBean(BuyService.class);

//		demo2.createMeSomeBeasts(beastBlueprintService, beastService);
//        demo2.tryBuyingWithBeast(buyService, beastService, shopService);
//		demo2.deleteAllData(beastBlueprintService, beastService, armorBlueprintService, armorService,  goodsBlueprintService, goodsService, treasureBlueprintService, treasureService, weaponBlueprintService, weaponService, inventoryService, storageService, shopService);

		/*boolean delete = false;

		if(delete) {
			beastBlueprintService.deleteAll();
		} else {
			*//**
			 * CREATING GOBLIN IDEAL (BACKPACK INCLUDED)!!!
			 *//*
			Map<Ability, AbilityScore> abilityScores = new HashMap<>();
			abilityScores.put(Ability.STRENGTH, new AbilityScore(Ability.STRENGTH, 8, -1));
			abilityScores.put(Ability.DEXTERITY, new AbilityScore(Ability.DEXTERITY, 8, -1));
			abilityScores.put(Ability.RESISTANCE, new AbilityScore(Ability.RESISTANCE, 8, -1));
			abilityScores.put(Ability.CHARISMA, new AbilityScore(Ability.CHARISMA, 4, -3));
			abilityScores.put(Ability.INTELLIGENCE, new AbilityScore(Ability.INTELLIGENCE, 3, -4));

			EnumSet<CharacterSize> sizes = EnumSet.noneOf(CharacterSize.class);
			EnumSet<Vulnerability> vulnerabilities = EnumSet.noneOf(Vulnerability.class);
			BeastBlueprint goblinIdeal = beastBlueprintService.drawBlueprint(
					"Drd pravidla pro zacatecniky",
					"Skreti valecnik",
					"Skret",
					"No comment",
					1,
					0,
					0,
					abilityScores,
					7,
					0,
					sizes,
					vulnerabilities,
					10,
					8,
					-1,
					true
			);

			sizes.add(CharacterSize.A);

			vulnerabilities.addAll(EnumSet.complementOf(EnumSet.of(Vulnerability.E, Vulnerability.F, Vulnerability.N, Vulnerability.P)));

			beastBlueprintService.saveBeastBlueprint(goblinIdeal);


			*//**
			 * CREATING GOGO THE FIRST OF GOBLINS
			 *//*
			beastService.spawnBeasts(
					2,
					goblinIdeal,
					"GoGo",
					"GoGo je prosty skret, ktery rad vysiva",
					CharacterSize.A
			);
		}*/
    }

//	@Bean
//	public SharedEntityManagerBean containerManagedEntityManager(EntityManagerFactory emf) {
//		SharedEntityManagerBean entityManagerBean = new SharedEntityManagerBean();
//		entityManagerBean.setEntityManagerFactory(emf);
//		return entityManagerBean;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//		return new JpaTransactionManager(emf);
//	}
//
//	@Bean
//	public EntityManagerFactory entityManagerFactory(DataSource ds) {
//		Map<String, Object> props = new HashMap<>();
//		props.put("javax.persistence.nonJtaDataSource", ds);
//		return Persistence.createEntityManagerFactory("PersistenceUnit", props);
//	}
}

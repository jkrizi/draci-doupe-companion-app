package net.homecredit.trainee.drd;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.Vulnerability;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.repository.blueprint.*;
import net.homecredit.trainee.drd.repository.character.BeastRepository;
import net.homecredit.trainee.drd.repository.character.KnowHowRepository;
import net.homecredit.trainee.drd.repository.inventory.InventoryRepository;
import net.homecredit.trainee.drd.repository.inventory.StorageRepository;
import net.homecredit.trainee.drd.repository.inventory.WeaponRepository;
import net.homecredit.trainee.drd.repository.shop.ShopRepository;
import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.character.BeastService;
import net.homecredit.trainee.drd.service.character.CombatService;
import net.homecredit.trainee.drd.service.item.InventoryService;
import net.homecredit.trainee.drd.service.item.StorageService;
import net.homecredit.trainee.drd.service.item.WeaponService;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@EnableTransactionManagement
@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(BackEndApplication.class, args);

		BeastBlueprintService beastBlueprintService = applicationContext.getBean(BeastBlueprintService.class);
		BeastService beastService =  applicationContext.getBean(BeastService.class);
		StorageService storageService = applicationContext.getBean(StorageService.class);

//		boolean delete = false;
//
//		if(delete) {
//			beastBlueprintService.deleteAll();
//		} else {
//			/**
//			 * CREATING GOBLIN IDEAL (BACKPACK INCLUDED)!!!
//			 */
//			Map<Ability, AbilityScore> abilityScores = new HashMap<>();
//			abilityScores.put(Ability.STRENGTH, new AbilityScore(Ability.STRENGTH, 8, -1));
//			abilityScores.put(Ability.DEXTERITY, new AbilityScore(Ability.DEXTERITY, 8, -1));
//			abilityScores.put(Ability.RESISTANCE, new AbilityScore(Ability.RESISTANCE, 8, -1));
//			abilityScores.put(Ability.CHARISMA, new AbilityScore(Ability.CHARISMA, 4, -3));
//			abilityScores.put(Ability.INTELLIGENCE, new AbilityScore(Ability.INTELLIGENCE, 3, -4));
//
//			EnumSet<CharacterSize> sizes = EnumSet.noneOf(CharacterSize.class);
//			EnumSet<Vulnerability> vulnerabilities = EnumSet.noneOf(Vulnerability.class);
//			BeastBlueprint goblinIdeal = beastBlueprintService.drawBlueprint(
//					"Drd pravidla pro zacatecniky",
//					"Skreti valecnik",
//					"Skret",
//					"No comment",
//					1,
//					0,
//					0,
//					abilityScores,
//					7,
//					0,
//					sizes,
//					vulnerabilities,
//					10,
//					8,
//					-1,
//					true
//			);
//
//			sizes.add(CharacterSize.A);
//
//			vulnerabilities.addAll(EnumSet.complementOf(EnumSet.of(Vulnerability.E, Vulnerability.F, Vulnerability.N, Vulnerability.P)));
//
//			beastBlueprintService.saveBeastBlueprint(goblinIdeal);
//
//
//			/**
//			 * CREATING GOGO THE FIRST OF GOBLINS
//			 */
//			beastService.spawnBeasts(
//					2,
//					goblinIdeal,
//					"GoGo",
//					"GoGo je prosty skret, ktery rad vysiva",
//					CharacterSize.A
//			);
//		}
	}

	@Bean
	public KnowHowRepository knowHowRepository(EntityManager em) {
		return new KnowHowRepository(em);
	}

	@Bean
	public BeastBlueprintService beastBlueprintService(BeastBlueprintRepository beastBlueprintRepository, InventoryService inventoryService, CombatService combatService) {
		return new BeastBlueprintService(beastBlueprintRepository, inventoryService, combatService);
	}

	@Bean
	public BeastService beastService(BeastRepository beastRepository, net.homecredit.trainee.util.Dice dice, CombatService combatService, InventoryService inventoryService) {
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
	public TreasureBlueprintService treasureBlueprintService(TreasureBlueprintRepository treasureBlueprintRepository, ShopService shopService) {
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
	public net.homecredit.trainee.util.Dice dice(Random random) {
		return new net.homecredit.trainee.util.Dice(random);
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

package net.homecredit.trainee.drd;

import net.homecredit.trainee.drd.configuration.RepositoryConfiguration;
import net.homecredit.trainee.drd.configuration.ServiceConfiguration;
import net.homecredit.trainee.drd.controller.CalculusController;
import net.homecredit.trainee.drd.controller.EnumController;
import net.homecredit.trainee.drd.controller.PersistenceController;
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
@Import({
        RepositoryConfiguration.class,
        ServiceConfiguration.class,
        PersistenceController.class,
        EnumController.class,
        CalculusController.class
})
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
        ShopService shopService = applicationContext.getBean(ShopService.class);
        BuyService buyService = applicationContext.getBean(BuyService.class);

        //creates items blueprints and shopitems in the database
        //trying to create blueprints with small changes and see if it will put it in the database or not
//        demo2.setBroadSwordBlueprint(weaponBlueprintService);
//        demo2.setTestTreasureBlueprint(treasureBlueprintService);
//        demo2.setTestArmorBlueprint(armorBlueprintService);
//        demo2.setTestGoodsBlueprint(goodsBlueprintService);

//		demo2.createMeSomeBeasts(beastBlueprintService, beastService);
//      demo2.tryBuyingWithBeast(buyService, beastService, shopService);
//		demo2.deleteAllData(beastBlueprintService, beastService, armorBlueprintService, armorService,  goodsBlueprintService, goodsService, treasureBlueprintService, treasureService, weaponBlueprintService, weaponService, inventoryService, storageService, shopService);

//       demo2.tryBuyingWithBeast(buyService, beastService, shopService);
//		demo2.deleteAllData(beastBlueprintService, beastService, armorBlueprintService, armorService,  goodsBlueprintService, goodsService, treasureBlueprintService, treasureService, weaponBlueprintService, weaponService, inventoryService, storageService, shopService);
    }
}

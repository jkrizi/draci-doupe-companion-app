package net.homecredit.trainee.drd;

import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.character.BeastService;
import net.homecredit.trainee.drd.service.item.*;
import net.homecredit.trainee.drd.service.shop.BuyService;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
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

        /*Race race = new Race("Race1", CharacterSize.A);
        Race race1 = new Race("Race2", CharacterSize.A0);
        Race race2 = new Race("Race3", CharacterSize.B);
        Race race3 = new Race("Race4", CharacterSize.D);
        Race race4 = new Race("Race5", CharacterSize.E);
        List<Race> raceList = new ArrayList<>();
        raceList.add(race);
        raceList.add(race1);
        raceList.add(race2);
        raceList.add(race3);
        raceList.add(race4);

        RaceConverter raceConverter = new RaceConverter();

        List<RaceDto> raceDtos = raceConverter.convertToEntity(raceList);
        for(RaceDto raceDto : raceDtos){
            System.out.println(raceDto.getName() + "character size list");
            for(String s : raceDto.getSize()){
                System.out.println(s);
            }
        }*/

//		demo2.createMeSomeBeasts(beastBlueprintService, beastService);
//      demo2.tryBuyingWithBeast(buyService, beastService, shopService);
//		demo2.deleteAllData(beastBlueprintService, beastService, armorBlueprintService, armorService,  goodsBlueprintService, goodsService, treasureBlueprintService, treasureService, weaponBlueprintService, weaponService, inventoryService, storageService, shopService);


//       demo2.tryBuyingWithBeast(buyService, beastService, shopService);
//		demo2.deleteAllData(beastBlueprintService, beastService, armorBlueprintService, armorService,  goodsBlueprintService, goodsService, treasureBlueprintService, treasureService, weaponBlueprintService, weaponService, inventoryService, storageService, shopService);
    }
}

package net.homecredit.trainee.drd;

import net.homecredit.trainee.drd.entity.blueprint.item.*;
import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.armor.BodySection;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponType;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.service.blueprint.ArmorBlueprintService;
import net.homecredit.trainee.drd.service.blueprint.GoodsBlueprintService;
import net.homecredit.trainee.drd.service.blueprint.TreasureBlueprintService;
import net.homecredit.trainee.drd.service.blueprint.WeaponBlueprintService;
import net.homecredit.trainee.drd.service.item.StorageService;
import net.homecredit.trainee.drd.service.item.WeaponService;
import net.homecredit.trainee.util.Color;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.EnumSet;
import java.util.Set;

public class Demo2 {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(BackEndApplication.class);
        StorageService storageService = applicationContext.getBean(StorageService.class);

        WeaponBlueprintService weaponBlueprintService = applicationContext.getBean(WeaponBlueprintService.class);
        WeaponService weaponService = applicationContext.getBean(WeaponService.class);
//        setBroadSwordBlueprint(weaponBlueprintService);

        TreasureBlueprintService treasureBlueprintService = applicationContext.getBean(TreasureBlueprintService.class);
//        tryTreasureService(treasureBlueprintService);

        ArmorBlueprintService armorBlueprintService = applicationContext.getBean(ArmorBlueprintService.class);
//        tryArmorService(armorBlueprintService);

        GoodsBlueprintService goodsBlueprintService = applicationContext.getBean(GoodsBlueprintService.class);
        tryGoodsService(goodsBlueprintService);

    }

    private static void setBroadSwordBlueprint(WeaponBlueprintService weaponBlueprintService) {
        Set<WeaponType> weaponType = EnumSet.of(WeaponType.CUTTING, WeaponType.STABBING);
        WeaponBlueprint wb = weaponBlueprintService.drawAndFileBlueprint("Siroky mec", "Mec, ktery se na dne truhly najde v kazde lidske domacnosti", "private description",60, 4, 0, -1, 0, -1, -1, -1, 1, 1, weaponType);
        System.out.println(weaponBlueprintService.findBlueprint(wb.getId()).getPublicDescription());

    }

    private static void tryTreasureService(TreasureBlueprintService treasureBlueprintService){
        GemStone gemStone = new GemStone("gemstoneName", Color.BLACK, 1.5);
        Metal material = Metal.BRONZE;
        SkillKnowledge skill = SkillKnowledge.AVERAGE;

        TreasureBlueprint tb = treasureBlueprintService.drawAndFileBlueprint("Treasure", "Pekny treasure", "private description", gemStone, 1, true,  material, 1, skill, 1.5);
        System.out.println(treasureBlueprintService.findBlueprint(tb.getId()).getPublicDescription());

    }

    private static void tryArmorService(ArmorBlueprintService armorBlueprintService){
        Set<BodySection> coverage = EnumSet.of(BodySection.HEAD);
        ArmorBlueprint ab = armorBlueprintService.drawAndFileBlueprint("armor name", "awesome armor babe", "private description", 1, 1, coverage);
        System.out.println(armorBlueprintService.findBlueprint(ab.getId()).getPublicDescription());

    }

    private static void tryGoodsService(GoodsBlueprintService goodsBlueprintService){
       GoodsBlueprint gb = goodsBlueprintService.drawAndFileBlueprint("Kofola", "Sweet Goods", "private description", 1, ItemType.BEVERAGES);
        System.out.println(goodsBlueprintService.findBlueprint(gb.getId()).getPublicDescription());
    }
}

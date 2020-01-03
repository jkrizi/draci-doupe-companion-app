package net.homecredit.trainee.drd;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.*;
import net.homecredit.trainee.drd.entity.character.Beast;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.Vulnerability;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.entity.inventory.armor.BodySection;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponType;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.entity.shop.ShopItem;
import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.character.BeastService;
import net.homecredit.trainee.drd.service.item.*;
import net.homecredit.trainee.drd.service.shop.BuyService;
import net.homecredit.trainee.drd.service.shop.ShopService;
import net.homecredit.trainee.drd.util.Color;

import java.util.*;

public class Demo2 {

    public void setBroadSwordBlueprint(WeaponBlueprintService weaponBlueprintService) {
        Set<WeaponType> weaponType = EnumSet.of(WeaponType.CUTTING, WeaponType.STABBING);
        WeaponBlueprint wb = weaponBlueprintService.drawAndFileBlueprint("Siroky mec", "Mec, ktery se na dne truhly najde v kazde lidske domacnosti", "private description", 60, 4, 0, -1, 0, -1, -1, -1, 1, 1, weaponType);
        System.out.println(weaponBlueprintService.findBlueprint(wb.getId()).getPublicDescription());
    }

    public void setTestTreasureBlueprint(TreasureBlueprintService treasureBlueprintService) {
        GemStone gemStone = new GemStone("gemstoneName", Color.BLACK, 1.5);
        Metal material = Metal.BRONZE;
        SkillKnowledge skill = SkillKnowledge.AVERAGE;

        TreasureBlueprint tb = treasureBlueprintService.drawAndFileBlueprint("Treasure", "Pekny treasure", "private description", gemStone, 1, true, material, 10, skill, 1.5);
        System.out.println(treasureBlueprintService.findBlueprint(tb.getId()).getPublicDescription());

    }

    public void setTestArmorBlueprint(ArmorBlueprintService armorBlueprintService) {
        Set<BodySection> coverage = EnumSet.of(BodySection.HEAD);
        ArmorBlueprint ab = armorBlueprintService.drawAndFileBlueprint("armor name", "awesome armor babe", "private description", 20, 1, coverage);
        System.out.println(armorBlueprintService.findBlueprint(ab.getId()).getPublicDescription());

    }

    public void setTestGoodsBlueprint(GoodsBlueprintService goodsBlueprintService) {
        GoodsBlueprint gb = goodsBlueprintService.drawAndFileBlueprint("Kofola", "Sweet Goods", "private description", 1000, ItemType.BEVERAGES);
        System.out.println(goodsBlueprintService.findBlueprint(gb.getId()).getPublicDescription());
    }

    public void tryBuyingWithBeast(BuyService buyService, BeastService beastService, ShopService shopService) {
//        System.out.println("Welcome to the Awesome Store\nHere are our items for sale");
//        System.out.println("Do you want to buy an item? Y/N");
//        if (getUserInputYesOrNo().equals("Y")) {
        String shopAgain = "Y";
//            System.out.println("Choose the beast you want to buy it with");
        do{
            listAllShopItems(shopService);
            ShopItem item = chooseItemFromList(shopService);
            Beast beast = chooseBeast(beastService);
            try {
                    if (buyService.buyItem(item.getBlueprintId(), item.getItemType(), beast, 10, true)) {
                        System.out.println("Buy was succesful.");
                        System.out.println("Try again?");
                        if(!getUserInputYesOrNo().equals("Y")){
                            break;
                        }
                    }
                }catch (RuntimeException e){
                    System.out.println(e + " Try again?");
                    if(!getUserInputYesOrNo().equals("Y")){
                        break;
                    }
                }
            }while (true);

//        }
        System.out.println("Goodbye. See you soon!");
    }

    public void createMeSomeBeasts(BeastBlueprintService beastBlueprintService, BeastService beastService) {
        boolean delete = false;

        if (delete) {
            beastBlueprintService.deleteAll();
        } else {
            /**
             * CREATING GOBLIN IDEAL (BACKPACK INCLUDED)!!!
             */
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


            /**
             * CREATING GOGO THE FIRST OF GOBLINS
             */
            beastService.spawnBeasts(
                    1,
                    goblinIdeal,
                    "GoGo",
                    "GoGo je prosty skret, ktery rad vysiva",
                    CharacterSize.A
            );
        }
    }


    public ShopItem chooseItemFromList(ShopService shopService) {
        System.out.println("Type number of Item you want to buy");
        int value = getUserInputInt();
        List<ShopItem> shopItems = shopService.findAll();
        ShopItem item = shopItems.get(value);
        System.out.println("You chose " + item.getName());
        return item;
    }

    public void listAllShopItems(ShopService shopService) {
        List<ShopItem> shopItems = shopService.findAll();
        System.out.println("List of Items: \n");
        int count = 0;
        for (ShopItem shopItem : shopItems) {
            System.out.println(count++ + " Item " + shopItem.getName() + " " + shopItem.getDescription());
        }
    }

    public void listAllBeasts(BeastService beastService) {
        List<Beast> beasts = beastService.findAll();
        System.out.println("List of Beasts: \n");
        int count = 0;
        for (Beast beast : beasts) {
            System.out.println(count++ + " Beast " + beast.getName() + " " + beast.getId());
        }
    }

    public Beast chooseBeast(BeastService beastService) {
        listAllBeasts(beastService);
        int value = getUserInputInt();
        List<Beast> beasts = beastService.findAll();
        Beast beast = beasts.get(value);
        System.out.println("You chose " + beast.getName());
        return beast;
    }

    private int getUserInputInt() {
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        return result;
    }

    private String getUserInputYesOrNo() {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        return result;
    }

    public void deleteAllData(BeastBlueprintService beastBlueprintService,
                              BeastService beastService,
                              ArmorBlueprintService armorBlueprintService,
                              ArmorService armorService,
                              GoodsBlueprintService goodsBlueprintService,
                              GoodsService goodsService,
                              TreasureBlueprintService treasureBlueprintService,
                              TreasureService treasureService,
                              WeaponBlueprintService weaponBlueprintService,
                              WeaponService weaponService,
                              InventoryService inventoryService,
                              StorageService storageService,
                              ShopService shopService) {
//        beastBlueprintService.deleteAll(); //doesn't work, delete Ability score, BeastSize, BeastVulnerabilit and then BeastBlueprint
        beastService.deleteAll();
        armorBlueprintService.deleteAll();
        armorService.deleteAll();
        goodsBlueprintService.deleteAll();
        goodsService.deleteAllGoods();
        treasureBlueprintService.deleteAll();
        treasureService.deleteAll();
        weaponBlueprintService.deleteAll();
        weaponService.deleteAll();

        shopService.deleteAll();
        inventoryService.deleteAll();
    }
}

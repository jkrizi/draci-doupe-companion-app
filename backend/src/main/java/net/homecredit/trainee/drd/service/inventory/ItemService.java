package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.controller.character.CharacterBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.ArmorBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.GoodsBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.TreasureBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.WeaponBlueprintDto;
import net.homecredit.trainee.drd.entity.character.CharacterBlueprint;
import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.person.PersonBlueprint;
import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.util.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ItemService {

    private final WeaponBlueprintService weaponBlueprintService;
    private final ArmorBlueprintService armorBlueprintService;
    private final TreasureBlueprintService treasureBlueprintService;
    private final GoodsBlueprintService goodsBlueprintService;

    public ItemService(WeaponBlueprintService weaponBlueprintService, ArmorBlueprintService armorBlueprintService, TreasureBlueprintService treasureBlueprintService, GoodsBlueprintService goodsBlueprintService) {
        this.weaponBlueprintService = weaponBlueprintService;
        this.armorBlueprintService = armorBlueprintService;
        this.treasureBlueprintService = treasureBlueprintService;
        this.goodsBlueprintService = goodsBlueprintService;
    }

    public void convertItemBlueprintEntities(CharacterBlueprint characterBlueprint, CharacterBlueprintDto characterBlueprintDto) {
        characterBlueprintDto.setArmory(armorBlueprintService.convertArmorBlueprintEntities(new HashSet<>(characterBlueprint.getArmorBlueprintsNewSet())));
        characterBlueprintDto.setGoods(goodsBlueprintService.convertGoodsBlueprintEntities(new HashSet<>(characterBlueprint.getGoodsBlueprintsNewSet())));
        characterBlueprintDto.setTreasury(treasureBlueprintService.convertTreasureBlueprintEntities(new HashSet<>(characterBlueprint.getTreasureBlueprintsNewSet())));
        characterBlueprintDto.setWeaponry(weaponBlueprintService.convertWeaponBlueprintEntities(new HashSet<>(characterBlueprint.getWeaponBlueprintsNewSet())));
    }

    public void convertItemBlueprintDtos(CharacterBlueprint characterBlueprint, CharacterBlueprintDto characterBlueprintDto) {
        characterBlueprintDto.getWeaponry().forEach(weaponBlueprintDto -> addWeaponBlueprint(weaponBlueprintDto, characterBlueprint));
        characterBlueprintDto.getArmory().forEach(armorBlueprintDto -> addArmorBlueprint(armorBlueprintDto, characterBlueprint));
        characterBlueprintDto.getTreasury().forEach(treasureBlueprintDto -> addTreasureBlueprint(treasureBlueprintDto, characterBlueprint));
        characterBlueprintDto.getGoods().forEach(goodsBlueprintDto -> addGoodsBlueprint(goodsBlueprintDto, characterBlueprint));
    }

    private void addGoodsBlueprint(GoodsBlueprintDto goodsBlueprintDto, CharacterBlueprint characterBlueprint) {
        GoodsBlueprint goodsBlueprint = goodsBlueprintService.findById(goodsBlueprintDto.getId());
        if (characterBlueprint instanceof PersonBlueprint) {
            PersonBlueprint personBlueprint = (PersonBlueprint)characterBlueprint;
            personBlueprint.getGoodsBlueprints()
                    .add(new PersonBlueprintGoodsBlueprint(personBlueprint, goodsBlueprint, goodsBlueprintDto.getOwnedPieces()));
        } else {
            BeastBlueprint beastBlueprint = (BeastBlueprint)characterBlueprint;
            beastBlueprint.getGoodsBlueprints()
                    .add(new BeastBlueprintGoodsBlueprint(beastBlueprint, goodsBlueprint, goodsBlueprintDto.getOwnedPieces()));
        }

    }

    private void addTreasureBlueprint(TreasureBlueprintDto treasureBlueprintDto, CharacterBlueprint characterBlueprint) {
        TreasureBlueprint treasureBlueprint = treasureBlueprintService.findById(treasureBlueprintDto.getId());
        if (characterBlueprint instanceof PersonBlueprint) {
            PersonBlueprint personBlueprint =  (PersonBlueprint)characterBlueprint;
            personBlueprint.getTreasureBlueprints()
                    .add(new PersonBlueprintTreasureBlueprint(personBlueprint, treasureBlueprint, treasureBlueprintDto.getOwnedPieces()));
        } else {
            BeastBlueprint beastBlueprint = (BeastBlueprint)characterBlueprint;
            beastBlueprint.getTreasureBlueprints()
                    .add(new BeastBlueprintTreasureBlueprint(beastBlueprint, treasureBlueprint, treasureBlueprintDto.getOwnedPieces()));
        }

    }

    private void addArmorBlueprint(ArmorBlueprintDto armorBlueprintDto, CharacterBlueprint characterBlueprint) {
        ArmorBlueprint armorBlueprint = armorBlueprintService.findById(armorBlueprintDto.getId());
        if (characterBlueprint instanceof PersonBlueprint) {
            PersonBlueprint personBlueprint =  (PersonBlueprint)characterBlueprint;
            personBlueprint.getArmorBlueprints()
                    .add(new PersonBlueprintArmorBlueprint(personBlueprint, armorBlueprint, armorBlueprintDto.getOwnedPieces()));
        } else {
            BeastBlueprint beastBlueprint = (BeastBlueprint)characterBlueprint;
            beastBlueprint.getArmorBlueprints()
                    .add(new BeastBlueprintArmorBlueprint(beastBlueprint, armorBlueprint, armorBlueprintDto.getOwnedPieces()));
        }

    }

    private void addWeaponBlueprint(WeaponBlueprintDto weaponBlueprintDto, CharacterBlueprint characterBlueprint) {
        WeaponBlueprint weaponBlueprint = weaponBlueprintService.findById(weaponBlueprintDto.getId());
        if (characterBlueprint instanceof PersonBlueprint) {
            PersonBlueprint personBlueprint =  (PersonBlueprint)characterBlueprint;
            personBlueprint.getWeaponBlueprints()
                    .add(new PersonBlueprintWeaponBlueprint(personBlueprint, weaponBlueprint, weaponBlueprintDto.getOwnedPieces()));
        } else {
            BeastBlueprint beastBlueprint = (BeastBlueprint)characterBlueprint;
            beastBlueprint.getWeaponBlueprints()
                    .add(new BeastBlueprintWeaponBlueprint(beastBlueprint, weaponBlueprint, weaponBlueprintDto.getOwnedPieces()));
        }
    }
}

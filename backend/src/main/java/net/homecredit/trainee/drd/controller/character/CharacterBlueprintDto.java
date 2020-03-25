package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.controller.inventory.ArmorBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.GoodsBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.TreasureBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.WeaponBlueprintDto;

import java.util.Set;

public interface CharacterBlueprintDto {

    void setArmory(Set<ArmorBlueprintDto> convertArmorBlueprintEntities);

    void setGoods(Set<GoodsBlueprintDto> convertGoodsBlueprintEntities);

    void setTreasury(Set<TreasureBlueprintDto> convertTreasureBlueprintEntities);

    void setWeaponry(Set<WeaponBlueprintDto> convertWeaponBlueprintEntities);

    Set<WeaponBlueprintDto> getWeaponry();

    Set<ArmorBlueprintDto> getArmory();

    Set<TreasureBlueprintDto> getTreasury();

    Set<GoodsBlueprintDto> getGoods();
}

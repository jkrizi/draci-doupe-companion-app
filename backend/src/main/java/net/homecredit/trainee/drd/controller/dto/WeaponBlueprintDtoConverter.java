package net.homecredit.trainee.drd.controller.dto;

import net.homecredit.trainee.drd.entity.blueprint.item.WeaponBlueprint;

import java.util.ArrayList;
import java.util.List;

public class WeaponBlueprintDtoConverter {

    public WeaponBlueprint convert(WeaponBlueprintDto dto) {
        WeaponBlueprint blueprint = new WeaponBlueprint(
                dto.getName(),
                dto.getPublicDescription(),
                dto.getPrivateDescription(),
                dto.getWeight(),
                dto.getAttack(),
                dto.getHurt(),
                dto.getDefense(),
                dto.getInitiativeModifier(),
                dto.getShortRangeLimit(),
                dto.getMidRangeLimit(),
                dto.getLongRangeLimit(),
                dto.getMinReach(),
                dto.getMaxReach(),
                dto.getWeaponFamily()
        );
        blueprint.setId(dto.getId());
        return blueprint;
    }

    public WeaponBlueprintDto convert(WeaponBlueprint blueprint) {
        WeaponBlueprintDto dto = new WeaponBlueprintDto(
                blueprint.getId(),
                blueprint.getName(),
                blueprint.getPrivateDescription(),
                blueprint.getPublicDescription(),
                blueprint.getWeight(),
                blueprint.getAttack(),
                blueprint.getHurt(),
                blueprint.getDefense(),
                blueprint.getInitiativeModifier(),
                blueprint.getShortRangeLimit(),
                blueprint.getMidRangeLimit(),
                blueprint.getLongRangeLimit(),
                blueprint.getMinReach(),
                blueprint.getMaxReach(),
                blueprint.getWeaponFamily()
        );
        return dto;
    }

    public List<WeaponBlueprintDto> convert(List<WeaponBlueprint> all) {
        List<WeaponBlueprintDto> list = new ArrayList<>(all.size());
        for (WeaponBlueprint blueprint : all) {
            list.add(convert(blueprint));
        }
        return list;
    }
}

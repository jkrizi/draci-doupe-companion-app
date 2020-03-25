package net.homecredit.trainee.drd.controller.inventory;

import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.inventory.armor.BodySection;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ArmorBlueprintDtoConverter {

    public ArmorBlueprint convert(ArmorBlueprintDto dto) {
        Set<BodySection> coverage = convertCoverage(dto.getCoverage());
        CharacterSize armorSize = CharacterSize.E;
        ArmorBlueprint blueprint = new ArmorBlueprint(
                //String name, String publicDescription, String privateDescription, CharacterSize armorSize, int weight, int defense, Set<BodySection> coverage
                dto.getName(),
                dto.getPublicDescription(),
                dto.getPrivateDescription(),
                armorSize,
                dto.getWeight(),
                dto.getDefense(),
                coverage
        );
        blueprint.setId(dto.getId());
        return blueprint;
    }

    public ArmorBlueprintDto convert(ArmorBlueprint blueprint) {
        List<String> coverage = convertCoverage(blueprint.getCoverage());
        ArmorBlueprintDto dto = new ArmorBlueprintDto(
                blueprint.getId(),
                blueprint.getName(),
                blueprint.getPublicDescription(),
                blueprint.getPrivateDescription(),
                blueprint.getWeight(),
                blueprint.getDefense(),
                coverage
        );
        return dto;
    }

    //todo: doesn't do shit, gonna have to fix it
    private List<String> convertCoverage(Set<BodySection> coverage) {
        return new ArrayList<String>(coverage.size());
    }

    //todo: doesn't work yet obviously
    private Set<BodySection> convertCoverage(List<String> coverage) {
        return EnumSet.of(BodySection.LEGS, BodySection.HEAD);
    }

    public List<ArmorBlueprintDto> convert(List<ArmorBlueprint> all) {
        List<ArmorBlueprintDto> list = new ArrayList<>(all.size());
        for (ArmorBlueprint blueprint : all) {
            list.add(convert(blueprint));
        }
        return list;
    }
}

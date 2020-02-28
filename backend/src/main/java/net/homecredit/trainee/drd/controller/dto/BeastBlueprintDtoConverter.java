package net.homecredit.trainee.drd.controller.dto;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.Vulnerability;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class BeastBlueprintDtoConverter {

    public BeastBlueprint convert(BeastBlueprintsDto dto) {
        EnumSet<CharacterSize> sizes = (EnumSet<CharacterSize>) dto.getSizes();
        EnumSet<Vulnerability> vulnerabilities = (EnumSet<Vulnerability>) dto.getVulnerabilities();
        BeastBlueprint blueprint = new BeastBlueprint(
                dto.getOrigin(),
                dto.getName(),
                dto.getSpecies(),
                dto.getDescription(),
                dto.getViability(),
                dto.getViabilityBonus(),
                dto.getManna(),
                dto.getAbilityMap(),
                dto.getMobility(),
                sizes,
                vulnerabilities,
                dto.getInventory(),
                dto.getCombatValues(),
                dto.getPugnacity(),
                dto.getPersistence(),
                dto.getDomestication(),
                dto.isSchooled()
        );
        return blueprint;
    }

    public BeastBlueprintsDto convert(BeastBlueprint blueprint) {
        BeastBlueprintsDto dto = new BeastBlueprintsDto(
                blueprint.getId(),
                blueprint.getOrigin(),
                blueprint.getName(),
                blueprint.getSpecies(),
                blueprint.getDescription(),
                blueprint.getViability(),
                blueprint.getViabilityBonus(),
                blueprint.getManna(),
                blueprint.getMobility(),
                blueprint.getAbilityMap(),
                blueprint.getSizes(),
                blueprint.getVulnerabilities(),
                blueprint.getBeasts(),
                blueprint.getInventory(),
                blueprint.getCombatValues(),
                blueprint.getPugnacity(),
                blueprint.getPersistence(),
                blueprint.getDomestication(),
                blueprint.isSchooled()
        );
        return dto;
    }

    public List<BeastBlueprintsDto> convert(List<BeastBlueprint> all) {
        List<BeastBlueprintsDto> list = new ArrayList<>(all.size());
        for (BeastBlueprint blueprint : all) {
            list.add(convert(blueprint));
        }
        return list;
    }
}

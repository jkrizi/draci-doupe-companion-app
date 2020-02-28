package net.homecredit.trainee.drd.controller.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import net.homecredit.trainee.drd.entity.blueprint.item.GemstoneBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.GemStone;
import net.homecredit.trainee.drd.service.blueprint.TreasureBlueprintService;
import net.homecredit.trainee.drd.util.Material;

public class TreasureBlueprintDtoConverter {
    private TreasureBlueprintService treasureBlueprintService;

    public TreasureBlueprintDtoConverter(TreasureBlueprintService treasureBlueprintService) {
        this.treasureBlueprintService = treasureBlueprintService;
    }

    public TreasureBlueprint convert(TreasureBlueprintDto dto) {
        HashSet<GemStone> gemStones = new HashSet<>();
        for(GemStoneDto gemStone : dto.getGemStones()){
            int count = Integer.parseInt(gemStone.getCount());
            for(int i = 0; i < count; i++){
                GemstoneBlueprint gemstoneBlueprint = treasureBlueprintService.findGemstoneBlueprint(gemStone.getId());
                gemStones.add(new GemStone(Integer.parseInt(gemStone.getWeight()), gemStone.isPolished(), gemstoneBlueprint.getUnitPrice(), gemstoneBlueprint));
            }
        }
        TreasureBlueprint treasureBlueprint = new TreasureBlueprint(
                dto.getName(),
                dto.getPublicDescription(),
                dto.getPrivateDescription(),
                gemStones,
                Material.valueOf(dto.getMaterial().getType()),
                Integer.parseInt(dto.getMaterial().getWeight()),
                SkillKnowledge.valueOf(dto.getMaterial().getQuality()),
                Double.parseDouble(dto.getGoldCoins()),
                Double.parseDouble(dto.getSilverCoins()),
                Double.parseDouble(dto.getCopperCoins())
        );
        treasureBlueprint.setId(dto.getId());
        return treasureBlueprint;
    }



    public TreasureBlueprintDto convert(TreasureBlueprint blueprint) {
        Collection<GemStoneDto> gemStoneDtos = new HashSet<>();
        for(GemStone gemStone : blueprint.getGemStones()){
            gemStoneDtos.add(new GemStoneDto(gemStone.getGemStoneBlueprint().getId(), String.valueOf(gemStone.getStoneWeight()), gemStone.isPolished(), String.valueOf(gemStone.getStonePrice())));
        }
        MaterialDto materialDto = new MaterialDto(
                blueprint.getMaterial().toString(),
                blueprint.getProductQuality().toString(),
                String.valueOf(blueprint.getMaterialWeight())
                );
        TreasureBlueprintDto dto = new TreasureBlueprintDto(
                blueprint.getId(),
                blueprint.getName(),
                blueprint.getPublicDescription(),
                blueprint.getPrivateDescription(),
                gemStoneDtos,
                materialDto,
                String.valueOf(blueprint.getGoldValue()),
                String.valueOf(blueprint.getSilverValue()),
                String.valueOf(blueprint.getCopperValue())
        );
        return dto;
    }

    public List<TreasureBlueprintDto> convert(List<TreasureBlueprint> all) {
        List<TreasureBlueprintDto> list = new ArrayList<>(all.size());
        for (TreasureBlueprint blueprint : all) {
            list.add(convert(blueprint));
        }
        return list;
    }
}

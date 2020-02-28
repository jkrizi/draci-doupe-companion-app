package net.homecredit.trainee.drd.controller.dto;

import net.homecredit.trainee.drd.entity.blueprint.item.GoodsBlueprint;

import java.util.ArrayList;
import java.util.List;

public class GoodsBlueprintDtoConverter {

    public GoodsBlueprint convert(GoodsBlueprintDto dto) {
        GoodsBlueprint blueprint = new GoodsBlueprint(
                dto.getName(),
                dto.getPublicDescription(),
                dto.getPrivateDescription(),
                dto.getWeight(),
                dto.getItemType()
        );
        blueprint.setId(dto.getId());
        return blueprint;
    }

    public GoodsBlueprintDto convert(GoodsBlueprint blueprint) {
        GoodsBlueprintDto dto = new GoodsBlueprintDto(
                blueprint.getId(),
                blueprint.getName(),
                blueprint.getPublicDescription(),
                blueprint.getPrivateDescription(),
                blueprint.getWeight(),
                blueprint.getItemType()
        );
        return dto;
    }

    public List<GoodsBlueprintDto> convert(List<GoodsBlueprint> all) {
        List<GoodsBlueprintDto> list = new ArrayList<>(all.size());
        for (GoodsBlueprint blueprint : all) {
            list.add(convert(blueprint));
        }
        return list;
    }
}

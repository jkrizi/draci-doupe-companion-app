package net.homecredit.trainee.service.blueprint;

import net.homecredit.trainee.entity.blueprint.item.GemStone;
import net.homecredit.trainee.entity.blueprint.item.Metal;
import net.homecredit.trainee.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.entity.shop.ItemType;
import net.homecredit.trainee.repository.blueprint.TreasureBlueprintRepository;
import net.homecredit.trainee.service.shop.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class TreasureBlueprintService {

    private TreasureBlueprintRepository treasureBlueprintRepository;
    private ShopService shopService;

    public TreasureBlueprintService(TreasureBlueprintRepository treasureBlueprintRepository, ShopService shopService) {
        this.treasureBlueprintRepository = treasureBlueprintRepository;
        this.shopService = shopService;
    }

    public TreasureBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, GemStone gemStone, int stoneWeight, boolean polished, Metal material, int materialWeight, SkillKnowledge productQuality, double treasureValue){
        TreasureBlueprint treasureBlueprint = new TreasureBlueprint(name, publicDescription, privateDescription, gemStone, stoneWeight, polished, material, materialWeight, productQuality, treasureValue);
        treasureBlueprintRepository.save(treasureBlueprint);
        shopService.createPriceTag(treasureBlueprint, ItemType.TREASURE);
        return treasureBlueprint;
    }

    public TreasureBlueprint findBlueprint(UUID id){
        return treasureBlueprintRepository.find(id);
    }
}

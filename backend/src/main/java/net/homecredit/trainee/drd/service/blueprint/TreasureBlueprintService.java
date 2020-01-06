package net.homecredit.trainee.drd.service.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.Metal;
import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.GemStone;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.blueprint.TreasureBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
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

    public TreasureBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, Collection<GemStone> gemStones, Metal material, int materialWeight, SkillKnowledge productQuality, double treasureValue) {
        TreasureBlueprint treasureBlueprint = new TreasureBlueprint(name, publicDescription, privateDescription, gemStones, material, materialWeight, productQuality, treasureValue);
        treasureBlueprintRepository.save(treasureBlueprint);
        shopService.createPriceTag(treasureBlueprint, ItemType.TREASURE);
        return treasureBlueprint;
    }

    public TreasureBlueprint findBlueprint(UUID id) {
        return treasureBlueprintRepository.find(id);
    }

    public void deleteAll() {
        treasureBlueprintRepository.deleteAll();
    }
}

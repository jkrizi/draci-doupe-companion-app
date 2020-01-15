package net.homecredit.trainee.drd.service.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.GemStoneBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.Metal;
import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.GemStone;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.blueprint.GemStoneBlueprintRepository;
import net.homecredit.trainee.drd.repository.blueprint.TreasureBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import net.homecredit.trainee.drd.util.Color;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TreasureBlueprintService {

    private TreasureBlueprintRepository treasureBlueprintRepository;
    private GemStoneBlueprintRepository gemStoneBlueprintRepository;
    private ShopService shopService;

    public TreasureBlueprintService(TreasureBlueprintRepository treasureBlueprintRepository, GemStoneBlueprintRepository gemStoneBlueprintRepository, ShopService shopService) {
        this.treasureBlueprintRepository = treasureBlueprintRepository;
        this.gemStoneBlueprintRepository = gemStoneBlueprintRepository;
        this.shopService = shopService;
    }

    public TreasureBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, Collection<GemStone> gemStones, Metal material, int materialWeight, SkillKnowledge productQuality, double treasureValue) {
        TreasureBlueprint treasureBlueprint = new TreasureBlueprint(name, publicDescription, privateDescription, gemStones, material, materialWeight, productQuality, treasureValue);
        if(treasureBlueprintRepository.containsBlueprint(treasureBlueprint)){
            throw new RuntimeException("Treasure blueprint already exists");
        }
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

    public GemStoneBlueprint saveGemStoneBlueprint(String name, Color color, double price){
        GemStoneBlueprint gemStoneBlueprint = new GemStoneBlueprint(name, color, price);
        if(gemStoneBlueprintRepository.containsBlueprint(gemStoneBlueprint)){
            throw new RuntimeException("GemStone blueprint already exists");
        }
        gemStoneBlueprintRepository.save(gemStoneBlueprint);
        return gemStoneBlueprint;
    }

    public void addTreasureBlueprintToGemstone(TreasureBlueprint treasureBlueprint, GemStone gemStone){
        gemStone.setTreasureBlueprint(treasureBlueprint);
        treasureBlueprintRepository.updateGemStone(gemStone);
    }

    public List<GemStoneBlueprint> findGemStonesBlueprints() {
        return gemStoneBlueprintRepository.findAll();
    }
}

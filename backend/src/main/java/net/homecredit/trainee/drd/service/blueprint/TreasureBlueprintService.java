package net.homecredit.trainee.drd.service.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.GemstoneBlueprint;
import net.homecredit.trainee.drd.util.Material;
import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.GemStone;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.blueprint.GemstoneBlueprintRepository;
import net.homecredit.trainee.drd.repository.blueprint.TreasureBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TreasureBlueprintService {

    private TreasureBlueprintRepository treasureBlueprintRepository;
    private GemstoneBlueprintRepository gemStoneBlueprintRepository;
    private ShopService shopService;

    public TreasureBlueprintService(TreasureBlueprintRepository treasureBlueprintRepository, GemstoneBlueprintRepository gemStoneBlueprintRepository, ShopService shopService) {
        this.treasureBlueprintRepository = treasureBlueprintRepository;
        this.gemStoneBlueprintRepository = gemStoneBlueprintRepository;
        this.shopService = shopService;
    }

    public TreasureBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, Collection<GemStone> gemStones, Material material, int materialWeight, SkillKnowledge productQuality, double treasureValue) {
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

    public void saveGemstoneBlueprint(GemstoneBlueprint newGemstoneBlueprint){
        if(gemStoneBlueprintRepository.containsBlueprint(newGemstoneBlueprint)){
            throw new RuntimeException("GemStone blueprint already exists");
        }
        gemStoneBlueprintRepository.save(newGemstoneBlueprint);
    }

    public void addTreasureBlueprintToGemstone(TreasureBlueprint treasureBlueprint, GemStone gemStone){
        gemStone.setTreasureBlueprint(treasureBlueprint);
        treasureBlueprintRepository.updateGemStone(gemStone);
    }

    public List<GemstoneBlueprint> findAllGemstoneBlueprints() {
        return gemStoneBlueprintRepository.findAll();
    }
}

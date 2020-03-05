package net.homecredit.trainee.drd.service.blueprint;

import java.util.List;
import java.util.UUID;

import net.homecredit.trainee.drd.entity.blueprint.item.GemstoneBlueprint;
import net.homecredit.trainee.drd.entity.blueprint.item.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.Gemstone;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.blueprint.GemstoneBlueprintRepository;
import net.homecredit.trainee.drd.repository.blueprint.TreasureBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //I dont think we will need this method for anything in the future
   /* public TreasureBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, Collection<Gemstone> gemStones, Material material, int materialWeight, SkillKnowledge productQuality, double goldValue, double silverValue, double copperValue) {
        TreasureBlueprint treasureBlueprint = new TreasureBlueprint(name, publicDescription, privateDescription, gemStones, material, materialWeight, productQuality, goldValue, silverValue, copperValue);

        save(treasureBlueprint);
        return treasureBlueprint;
    }*/

    public TreasureBlueprint findBlueprint(UUID id) {
        return treasureBlueprintRepository.find(id);
    }

    public void deleteAll() {
        treasureBlueprintRepository.deleteAll();
    }

    public void saveGemstoneBlueprint(GemstoneBlueprint newGemstoneBlueprint){
        if(gemStoneBlueprintRepository.containsBlueprint(newGemstoneBlueprint)){
            throw new RuntimeException("Gemstone blueprint already exists");
        }
        gemStoneBlueprintRepository.save(newGemstoneBlueprint);
    }



    public List<GemstoneBlueprint> findAllGemstoneBlueprints() {
        return gemStoneBlueprintRepository.findAll();
    }

    public TreasureBlueprint save(TreasureBlueprint treasureBlueprint){
        for(Gemstone ge : treasureBlueprint.getGemstones()){
            ge.setTreasureBlueprint(treasureBlueprint);
        }
        if(treasureBlueprintRepository.containsBlueprint(treasureBlueprint)){
            throw new RuntimeException("Treasure blueprint already exists");
        }
        treasureBlueprintRepository.save(treasureBlueprint);
        shopService.createPriceTag(treasureBlueprint, ItemType.TREASURE);
        return treasureBlueprint;
    }

    public List<TreasureBlueprint> findAll() {
        return treasureBlueprintRepository.findAll();
    }

    public void update(TreasureBlueprint treasureBlueprint) {
        treasureBlueprintRepository.update(treasureBlueprint);
    }

    public void delete(UUID id) {
        treasureBlueprintRepository.delete(id);
    }

    public GemstoneBlueprint findGemstoneBlueprint(UUID id) {
        return gemStoneBlueprintRepository.find(id);
    }

    public double calculateGemstonePrice(int weight, boolean polished, double unitPrice) {
        return 0;
    }
}

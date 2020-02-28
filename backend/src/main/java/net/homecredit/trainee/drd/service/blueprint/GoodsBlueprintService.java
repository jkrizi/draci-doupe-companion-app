package net.homecredit.trainee.drd.service.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.GoodsBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.blueprint.GoodsBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GoodsBlueprintService {

    private GoodsBlueprintRepository goodsBlueprintRepository;
    private ShopService shopService;

    public GoodsBlueprintService(GoodsBlueprintRepository goodsBlueprintRepository, ShopService shopService) {
        this.goodsBlueprintRepository = goodsBlueprintRepository;
        this.shopService = shopService;
    }

    public GoodsBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, int weight, ItemType itemType) {
        GoodsBlueprint goodsBlueprint = new GoodsBlueprint(name, publicDescription, privateDescription, weight, itemType);
        return goodsBlueprint;
    }

    public GoodsBlueprint findBlueprint(UUID id) {
        return goodsBlueprintRepository.find(id);
    }

    public void deleteAll() {
        goodsBlueprintRepository.deleteAll();
    }

    public List<GoodsBlueprint> findAll() {
        return goodsBlueprintRepository.findAll();
    }

    public void save(GoodsBlueprint newGoodsBlueprint) {
        if(goodsBlueprintRepository.containsBlueprint(newGoodsBlueprint)){
            throw new RuntimeException("Goods blueprint already exists");
        }
        goodsBlueprintRepository.save(newGoodsBlueprint);
        shopService.createPriceTag(newGoodsBlueprint, newGoodsBlueprint.getItemType());
        goodsBlueprintRepository.save(newGoodsBlueprint);
    }

    public void update(GoodsBlueprint existingGoodsBlueprint) {
        goodsBlueprintRepository.update(existingGoodsBlueprint);
    }

    public void delete(UUID id) {
        goodsBlueprintRepository.delete(id);
    }
}

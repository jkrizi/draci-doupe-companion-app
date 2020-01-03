package net.homecredit.trainee.drd.service.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.GoodsBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.blueprint.GoodsBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        goodsBlueprintRepository.save(goodsBlueprint);
        shopService.createPriceTag(goodsBlueprint, itemType);
        return goodsBlueprint;
    }

    public GoodsBlueprint findBlueprint(UUID id) {
        return goodsBlueprintRepository.find(id);
    }

    public void deleteAll() {
        goodsBlueprintRepository.deleteAll();
    }
}

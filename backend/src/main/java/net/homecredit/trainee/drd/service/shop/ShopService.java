package net.homecredit.trainee.drd.service.shop;

import net.homecredit.trainee.drd.entity.blueprint.item.ItemBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.entity.shop.LocalPrice;
import net.homecredit.trainee.drd.entity.shop.ShopItem;
import net.homecredit.trainee.drd.repository.shop.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShopService {

    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void createPriceTag(ItemBlueprint itemBlueprint, ItemType itemType) {
        List<LocalPrice> priceList = new ArrayList<>();
        ShopItem shopItem =  new ShopItem(itemBlueprint.getName(), itemBlueprint.toString(), itemType, priceList, itemBlueprint.getId());
        shopRepository.save(shopItem);
    }
}

package net.homecredit.trainee.drd.service.shop;

import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.entity.shop.LocalPrice;
import net.homecredit.trainee.drd.entity.shop.ShopItem;
import net.homecredit.trainee.drd.repository.shop.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ShopService {

    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void createPriceTag(ItemBlueprint itemBlueprint, ItemType itemType) {
        List<LocalPrice> priceList = new ArrayList<>();
        ShopItem shopItem = new ShopItem(itemBlueprint.getName(), itemBlueprint.getPublicDescription(), itemType, priceList, itemBlueprint.getId());
        shopRepository.save(shopItem);
    }

    public ShopItem findItem(UUID id) {
        return shopRepository.find(id);
    }

    public void deleteAll() {
        shopRepository.deleteAll();
    }

    public List<ShopItem> findAll() {
        return shopRepository.findAll();
    }
}

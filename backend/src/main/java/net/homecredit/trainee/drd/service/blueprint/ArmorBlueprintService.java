package net.homecredit.trainee.drd.service.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.inventory.armor.BodySection;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.blueprint.ArmorBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class ArmorBlueprintService {

    private ArmorBlueprintRepository armorBlueprintRepository;
    private ShopService shopService;

    public ArmorBlueprintService(ArmorBlueprintRepository armorBlueprintRepository, ShopService shopService) {
        this.armorBlueprintRepository = armorBlueprintRepository;
        this.shopService = shopService;
    }

    public ArmorBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, int weight, int defense, Set<BodySection> coverage) {
        ArmorBlueprint armorBlueprint = new ArmorBlueprint(name, publicDescription, privateDescription, weight, defense, coverage);
        armorBlueprintRepository.save(armorBlueprint);
        shopService.createPriceTag(armorBlueprint, ItemType.ARMOR);
        return armorBlueprint;
    }

    public ArmorBlueprint findBlueprint(UUID id) {
        return armorBlueprintRepository.find(id);
    }

    public void deleteAll() {
        armorBlueprintRepository.deleteAll();
    }
}

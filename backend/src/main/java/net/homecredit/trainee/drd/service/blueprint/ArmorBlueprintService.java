package net.homecredit.trainee.service.blueprint;

import net.homecredit.trainee.entity.blueprint.item.ArmorBlueprint;
import net.homecredit.trainee.entity.inventory.armor.BodySection;
import net.homecredit.trainee.entity.shop.ItemType;
import net.homecredit.trainee.repository.blueprint.ArmorBlueprintRepository;
import net.homecredit.trainee.service.shop.ShopService;
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

    public ArmorBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, int weight, int defense, Set<BodySection> coverage){
        ArmorBlueprint armorBlueprint = new ArmorBlueprint(name, publicDescription, privateDescription, weight, defense, coverage);
        armorBlueprintRepository.save(armorBlueprint);
        shopService.createPriceTag(armorBlueprint, ItemType.ARMOR);
        return armorBlueprint;
    }

    public ArmorBlueprint findBlueprint(UUID id){
        return armorBlueprintRepository.find(id);
    }


}

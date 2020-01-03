package net.homecredit.trainee.drd.service.blueprint;

import net.homecredit.trainee.drd.entity.blueprint.item.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponType;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.blueprint.WeaponBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class WeaponBlueprintService {

    private WeaponBlueprintRepository weaponBlueprintRepository;
    private ShopService shopService;

    public WeaponBlueprintService(WeaponBlueprintRepository weaponBlueprintRepository, ShopService shopService) {
        this.weaponBlueprintRepository = weaponBlueprintRepository;
        this.shopService = shopService;
    }

    public WeaponBlueprint drawAndFileBlueprint(String name, String publicDescription, String privateDescription, int weight, int attack, int hurt, int defense, int initiativeModifier, int shortRangeLimit, int midRangeLimit, int longRangeLimit, int minReach, int maxReach, Set<WeaponType> type) {
        WeaponBlueprint weaponBlueprint = new WeaponBlueprint(name, publicDescription, privateDescription, weight, attack, hurt, defense, initiativeModifier, shortRangeLimit, midRangeLimit, longRangeLimit, minReach, maxReach, type);
        this.weaponBlueprintRepository.save(weaponBlueprint);
        this.shopService.createPriceTag(weaponBlueprint, ItemType.WEAPONS);
        return weaponBlueprint;
    }

    public WeaponBlueprint findBlueprint(UUID id) {
        return weaponBlueprintRepository.find(id);
    }

    public void deleteAll() {
        weaponBlueprintRepository.deleteAll();
    }
}

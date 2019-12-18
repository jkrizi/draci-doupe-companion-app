package net.homecredit.trainee.service.blueprint;

import net.homecredit.trainee.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.entity.character.CharacterSize;
import net.homecredit.trainee.entity.character.Vulnerability;
import net.homecredit.trainee.entity.character.ability.Ability;
import net.homecredit.trainee.entity.character.ability.AbilityScore;
import net.homecredit.trainee.entity.character.combat.CombatValues;
import net.homecredit.trainee.entity.inventory.Inventory;
import net.homecredit.trainee.repository.blueprint.BeastBlueprintRepository;
import net.homecredit.trainee.service.character.CombatService;
import net.homecredit.trainee.service.item.InventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;
import java.util.Map;

@Service
@Transactional
public class BeastBlueprintService {

    private BeastBlueprintRepository beastBlueprintRepository;
    private InventoryService inventoryService;
    private CombatService combatService;

    public BeastBlueprintService(BeastBlueprintRepository beastBlueprintRepository, InventoryService inventoryService, CombatService combatService) {
        this.beastBlueprintRepository = beastBlueprintRepository;
        this.inventoryService = inventoryService;
        this.combatService = combatService;
    }

    public BeastBlueprint drawBlueprint(
            String source,
            String name,
            String species,
            String description,
            int viability,
            int viabilityBonus,
            int manna,
            Map<Ability, AbilityScore> abilityScoreMap,
            int mobility,
            int initiativeBase,
            EnumSet<CharacterSize> size,
            EnumSet<Vulnerability> vulnerability,
            int pugnacity,
            int persistence,
            int tameAbility,
            boolean trained
    ) {
        Inventory inventory = inventoryService.createInventory(abilityScoreMap.get(Ability.STRENGTH));
        CombatValues combatValues = combatService.newCombatValues(abilityScoreMap, inventory, initiativeBase);

        return new BeastBlueprint(source,name,species,description,viability,viabilityBonus,manna,abilityScoreMap,mobility,size,vulnerability,inventory,combatValues,pugnacity,persistence,tameAbility,trained);
    }

    public void saveBeastBlueprint(BeastBlueprint blueprint) {
        for(AbilityScore a: blueprint.getAbilityMap().values()) {
            a.setBeastBlueprint(blueprint);
        }
        beastBlueprintRepository.saveBlueprint(blueprint);
    }

    public void deleteAll() {
        for(BeastBlueprint cb: beastBlueprintRepository.findAllBluePrints()) {
            beastBlueprintRepository.deleteBlueprint(cb);
        }
    }
}

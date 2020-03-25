package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.beast.Vulnerability;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.character.combat.CombatValues;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import net.homecredit.trainee.drd.repository.inventory.BeastBlueprintRepository;
import net.homecredit.trainee.drd.service.character.CombatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

        return new BeastBlueprint(source, name, species, description, viability, viabilityBonus, manna, abilityScoreMap, mobility, size, vulnerability, inventory, combatValues, pugnacity, persistence, tameAbility, trained);
    }

    public void deleteAll() {
        beastBlueprintRepository.deleteAll();
    }

    public List<BeastBlueprint> findAll() {
        return beastBlueprintRepository.findAll();
    }

    public void save(BeastBlueprint blueprint) {
        for (AbilityScore a : blueprint.getAbilityMap().values()) {
            a.setBeastBlueprint(blueprint);
        }
        if(beastBlueprintRepository.containsBlueprint(blueprint)){
            throw new RuntimeException("Beast blueprint already exists");
        }
        beastBlueprintRepository.saveBlueprint(blueprint);
    }

    public void update(BeastBlueprint beastBlueprint) {
        beastBlueprintRepository.update(beastBlueprint);
    }

    public void delete(UUID id) {
        beastBlueprintRepository.delete(id);
    }
}

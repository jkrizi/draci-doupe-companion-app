package net.homecredit.trainee.service.character;

import net.homecredit.trainee.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.entity.character.Beast;
import net.homecredit.trainee.entity.character.CharacterSize;
import net.homecredit.trainee.entity.character.ability.Ability;
import net.homecredit.trainee.entity.character.combat.CombatValues;
import net.homecredit.trainee.entity.inventory.Inventory;
import net.homecredit.trainee.repository.character.BeastRepository;
import net.homecredit.trainee.service.item.InventoryService;
import net.homecredit.trainee.util.Dice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BeastService {

    private Dice dice;
    private BeastRepository beastRepository;
    private CombatService combatService;
    private InventoryService inventoryService;

    public BeastService(BeastRepository beastRepository, Dice dice, CombatService combatService, InventoryService inventoryService) {
        this.dice = dice;
        this.combatService = combatService;
        this.beastRepository = beastRepository;
        this.inventoryService = inventoryService;
    }

    public void spawnBeasts(int numberOfBeasts, BeastBlueprint generals, String name, String description, CharacterSize characterSize) {

        for(int i = 0; i < numberOfBeasts; i++) {
            int life = calculateLife(generals);
            Inventory inventory = inventoryService.createInventory(generals.getAbilityMap().get(Ability.STRENGTH));
            CombatValues combatValues = combatService.newCombatValues(generals.getAbilityMap(),inventory,generals.getCombatValues().getInitiativeBase());
            beastRepository.save(new Beast(generals, name, description, life, characterSize, inventory, combatValues));
        }
    }

    private int calculateLife(BeastBlueprint generals) {
        int life = generals.getViabilityBonus();
        for(int i = 0; i < generals.getViability(); i++) {
            life += dice.roll(8);
        }
        return life;
    }
}

package net.homecredit.trainee.drd.service.character;

import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.beast.Beast;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.combat.CombatValues;
import net.homecredit.trainee.drd.entity.inventory.Inventory;
import net.homecredit.trainee.drd.repository.character.BeastRepository;
import net.homecredit.trainee.drd.service.inventory.InventoryService;
import net.homecredit.trainee.drd.util.Dice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    public void deleteAll() {
        beastRepository.deleteAll();
    }

    public void spawnBeasts(int numberOfBeasts, BeastBlueprint generals, String name, String description, CharacterSize characterSize) {

        for (int i = 0; i < numberOfBeasts; i++) {
            int life = calculateLife(generals);
            Inventory inventory = inventoryService.createInventory(generals.getAbilityMap().get(Ability.STRENGTH));
            CombatValues combatValues = combatService.newCombatValues(generals.getAbilityMap(), inventory, generals.getCombatValues().getInitiativeBase());
            beastRepository.save(new Beast(generals, name, description, life, characterSize, inventory, combatValues));
        }
    }

    private int calculateLife(BeastBlueprint generals) {
        int life = generals.getViabilityBonus();
        for (int i = 0; i < generals.getViability(); i++) {
            life += dice.roll(8);
        }
        return life;
    }

    public Beast findBeast(UUID id) {
        return beastRepository.find(id);
    }

    public List<Beast> findAll() {
        return beastRepository.findAll();
    }
}

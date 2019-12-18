package net.homecredit.trainee.service.character;

import net.homecredit.trainee.entity.character.Character;
import net.homecredit.trainee.entity.character.ability.Ability;
import net.homecredit.trainee.entity.character.ability.AbilityScore;
import net.homecredit.trainee.entity.character.combat.CombatModifier;
import net.homecredit.trainee.entity.character.combat.CombatValues;
import net.homecredit.trainee.entity.inventory.Inventory;
import net.homecredit.trainee.entity.inventory.armor.Armor;
import net.homecredit.trainee.entity.inventory.weapon.Weapon;
import net.homecredit.trainee.service.item.InventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CombatService {

    private static final int BARE_HANDS_DEFENSE = -3;
    private InventoryService inventoryService;

    public CombatService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public CombatValues newCombatValues(Map<Ability,AbilityScore> abilityScoreMap, Inventory inventory, int initiativeBase) {
        return newCombatValues(abilityScoreMap, inventory, initiativeBase, new CombatModifier(0,0, 0));
    }

    public CombatValues newCombatValues(Map<Ability,AbilityScore> abilityScoreMap, Inventory inventory, int initiativeBase, CombatModifier combatModifier) {

        int strength = abilityScoreMap.get(Ability.STRENGTH).getAbilityBonusValue();
        int dexterity = abilityScoreMap.get(Ability.DEXTERITY).getAbilityBonusValue();

        Weapon activeWeapon = inventoryService.getActiveWeapon(inventory);
        List<Armor> equippedArmor = inventoryService.getEquippedArmor(inventory);

        int attack = calculateAttack(strength, activeWeapon, combatModifier);
        int hurt = calculateHurt(activeWeapon, combatModifier);
        int weaponDefense = calculateDefense(dexterity, equippedArmor, activeWeapon.getDefense(), combatModifier);
        int passiveDefense = calculateDefense(dexterity, equippedArmor, BARE_HANDS_DEFENSE, combatModifier);

        return new CombatValues(attack, hurt, weaponDefense, passiveDefense, initiativeBase);
    }

    //TODO - MISSING METHOD LOGIC
    public CombatValues refreshCombatValues(CombatValues combatValues, Character character) {
        return combatValues;
    }

    private int calculateAttack(int strength, Weapon activeWeapon, CombatModifier combatModifier) {
        return strength + activeWeapon.getAttack() + combatModifier.getAttackModifier();
    }

    private int calculateHurt(Weapon activeWeapon, CombatModifier combatModifier) {
        return activeWeapon.getHurt() + combatModifier.getHurtModifier();
    }

    private int calculateDefense(int dexterity, List<Armor> equippedArmor, int weaponDefense, CombatModifier combatModifier) {
        int defense = dexterity + weaponDefense + combatModifier.getDefenseModifier();
        for(Armor a: equippedArmor) {
            defense += a.getDefense();
        }
        return defense;
    }
}

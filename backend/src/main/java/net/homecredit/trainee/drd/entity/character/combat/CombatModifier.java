package net.homecredit.trainee.drd.entity.character.combat;

public class CombatModifier {

    private int attack;
    private int hurt;
    private int defense;


    public CombatModifier(int attack, int hurt, int defense) {
        this.attack = attack;
        this.hurt = hurt;
        this.defense = defense;
    }

    public int getAttackModifier() {
        return attack;
    }

    public int getHurtModifier() {
        return hurt;
    }

    public int getDefenseModifier() {
        return defense;
    }

}

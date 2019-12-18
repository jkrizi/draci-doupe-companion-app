package net.homecredit.trainee.drd.entity.character.combat;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CombatValues {

    private int attack;
    private int hurt;
    @Column(name = "active_defense")
    private int activeDefense;
    @Column(name = "passive_defense")
    private int passiveDefense;

    @Column(name = "initiative_base")
    private int initiativeBase;

    public CombatValues() {
    }

    public CombatValues(int attack, int hurt, int activeDefense, int passiveDefense, int initiativeBase) {
        this.attack = attack;
        this.hurt = hurt;
        this.activeDefense = activeDefense;
        this.passiveDefense = passiveDefense;
        this.initiativeBase = initiativeBase;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public int getActiveDefense() {
        return activeDefense;
    }

    public void setActiveDefense(int activeDefense) {
        this.activeDefense = activeDefense;
    }

    public int getPassiveDefense() {
        return passiveDefense;
    }

    public void setPassiveDefense(int passiveDefense) {
        this.passiveDefense = passiveDefense;
    }

    public int getInitiativeBase() {
        return initiativeBase;
    }

    public void setInitiativeBase(int initiativeBase) {
        this.initiativeBase = initiativeBase;
    }
}

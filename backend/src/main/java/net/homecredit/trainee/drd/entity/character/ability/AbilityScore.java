package net.homecredit.trainee.drd.entity.character.ability;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ability_score")
public class AbilityScore {

    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Ability ability;
    @Column(name = "value")
    private int abilityValue;
    @Column(name = "bonus")
    private int abilityBonusValue;

    public AbilityScore() {}

    public AbilityScore(Ability ability, int abilityValue, int abilityBonus) {
        this.ability = ability;
        this.abilityValue= abilityValue;
        this.abilityBonusValue = abilityBonus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public int getAbilityValue() {
        return abilityValue;
    }

    public void setAbilityValue(int abilityValue) {
        this.abilityValue = abilityValue;
    }

    public int getAbilityBonusValue() {
        return abilityBonusValue;
    }

    public void setAbilityBonusValue(int abilityBonusValue) {
        this.abilityBonusValue = abilityBonusValue;
    }

    @Override
    public String toString() {
        return ability.toString() + " " + getAbilityValue() + "/" + getAbilityBonusValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbilityScore)) return false;
        AbilityScore that = (AbilityScore) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package net.homecredit.trainee.drd.entity.character.ability;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.Person;

import javax.persistence.*;
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
    @ManyToOne
    private BeastBlueprint beastBlueprint;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public AbilityScore() {}

    public AbilityScore(Ability ability, int abilityValue, int abilityBonusValue) {
        this.id = UUID.randomUUID();
        this.ability = ability;
        this.abilityValue = abilityValue;
        this.abilityBonusValue = abilityBonusValue;
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

    public BeastBlueprint getBeastBlueprint() {
        return beastBlueprint;
    }

    public void setBeastBlueprint(BeastBlueprint beastBlueprint) {
        this.beastBlueprint = beastBlueprint;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString(){
        return ability.toString() + " " + getAbilityValue() + "/" + getAbilityBonusValue();
    }
}

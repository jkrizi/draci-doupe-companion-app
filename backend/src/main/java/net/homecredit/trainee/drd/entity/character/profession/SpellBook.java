package net.homecredit.trainee.drd.entity.character.profession;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class SpellBook {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "WIZARD_KNOWHOW_ID")
    private WizardKnowHow wizardKnowHow;
    @ManyToOne
    private Spell spell;

    public SpellBook() {
    }

    public SpellBook(WizardKnowHow wizardKnowHow, Spell spell) {
        this.id = UUID.randomUUID();
        this.wizardKnowHow = wizardKnowHow;
        this.spell = spell;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public WizardKnowHow getWizardKnowHow() {
        return wizardKnowHow;
    }

    public void setWizardKnowHow(WizardKnowHow wizardKnowHow) {
        this.wizardKnowHow = wizardKnowHow;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }
}

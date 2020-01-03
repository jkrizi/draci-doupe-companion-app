package net.homecredit.trainee.drd.entity.character.profession;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class WizardKnowHow extends ProfessionKnowHow {

    @OneToMany(mappedBy = "wizardKnowHow", orphanRemoval = true)
    private Collection<SpellBook> spellBook;

    public WizardKnowHow() {
    }

    public WizardKnowHow(Profession profession, Collection<SpellBook> spellBook) {
        super(profession);
        this.spellBook = spellBook;
    }

    public Collection<SpellBook> getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(Collection<SpellBook> spellBook) {
        this.spellBook = spellBook;
    }
}

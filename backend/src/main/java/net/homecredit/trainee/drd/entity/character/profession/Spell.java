package net.homecredit.trainee.drd.entity.character.profession;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.UUID;

@Entity
public class Spell {

    @Id
    private UUID id;
    private String name;
    private String description;

    private int mannaCost;

    @Column(name = "RANGE_OR_DIAMETER")
    private int rangeOrDiameter;
    private int conjuring;
    private int duration;

    @OneToMany(mappedBy = "spell")
    private Collection<SpellBook> spellBook;

    public Spell() {
    }

    public Spell(UUID id, String name, String description, int mannaCost, int rangeOrDiameter, int conjuring, int duration, Collection<SpellBook> spellBook) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.mannaCost = mannaCost;
        this.rangeOrDiameter = rangeOrDiameter;
        this.conjuring = conjuring;
        this.duration = duration;
        this.spellBook = spellBook;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMannaCost() {
        return mannaCost;
    }

    public void setMannaCost(int mannaCost) {
        this.mannaCost = mannaCost;
    }

    public int getRangeOrDiameter() {
        return rangeOrDiameter;
    }

    public void setRangeOrDiameter(int rangeOrDiameter) {
        this.rangeOrDiameter = rangeOrDiameter;
    }

    public int getConjuring() {
        return conjuring;
    }

    public void setConjuring(int conjuring) {
        this.conjuring = conjuring;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Collection<SpellBook> getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(Collection<SpellBook> spellBook) {
        this.spellBook = spellBook;
    }
}

package net.homecredit.trainee.drd.entity.character.profession;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Spell {

    @Id
    private UUID id;
    private String name;
    private String description;

    private int manna;

    private int range;
    private int conjuring;
    private int duration;

    public Spell() {
    }

    public Spell(Spell spell) {
        this(spell.name, spell.description, spell.manna, spell.range, spell.conjuring, spell.duration);
    }

    public Spell(String name, String description, int manna, int range, int conjuring, int duration) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.manna = manna;
        this.range = range;
        this.conjuring = conjuring;
        this.duration = duration;
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

    public int getManna() {
        return manna;
    }

    public void setManna(int mannaCost) {
        this.manna = mannaCost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int rangeOrDiameter) {
        this.range = rangeOrDiameter;
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

    @Override
    public String toString() {
        return "Spell{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mannaCost=" + manna +
                ", rangeOrDiameter=" + range +
                ", conjuring=" + conjuring +
                ", duration=" + duration +
                '}';
    }
}

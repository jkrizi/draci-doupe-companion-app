package net.homecredit.trainee.drd.controller.dto;

import java.util.UUID;

public class SpellDto {

    private UUID id;
    private String name;
    private String description;
    private int manna;
    private int range;
    private int conjuring;
    private int duration;

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

    public void setManna(int manna) {
        this.manna = manna;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
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
}

package net.homecredit.trainee.drd.controller.dto;

import java.util.UUID;

public class GemStoneDto {
    private UUID id;
    private String weight;
    private boolean polished;
    private String count;

    public GemStoneDto(UUID id, String weight, boolean polished, String count) {
        this.id = id;
        this.weight = weight;
        this.polished = polished;
        this.count = count;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isPolished() {
        return polished;
    }

    public void setPolished(boolean polished) {
        this.polished = polished;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GemStoneDto{" +
                "id=" + id +
                ", weight='" + weight + '\'' +
                ", polished=" + polished +
                '}';
    }
}

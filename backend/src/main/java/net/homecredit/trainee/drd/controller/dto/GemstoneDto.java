package net.homecredit.trainee.drd.controller.dto;

import net.homecredit.trainee.drd.util.Color;

import java.util.UUID;

public class GemstoneDto {
    private UUID id;
    private String stone;
    private Color stoneColor;
    private int stoneWeight;
    private int stoneCount;
    private boolean stonePolished;
    private UUID blueprintId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStone() {
        return stone;
    }

    public void setStone(String stone) {
        this.stone = stone;
    }

    public Color getStoneColor() {
        return stoneColor;
    }

    public void setStoneColor(Color stoneColor) {
        this.stoneColor = stoneColor;
    }

    public int getStoneWeight() {
        return stoneWeight;
    }

    public void setStoneWeight(int stoneWeight) {
        this.stoneWeight = stoneWeight;
    }

    public int getStoneCount() {
        return stoneCount;
    }

    public void setStoneCount(int stoneCount) {
        this.stoneCount = stoneCount;
    }

    public boolean isStonePolished() {
        return stonePolished;
    }

    public void setStonePolished(boolean stonePolished) {
        this.stonePolished = stonePolished;
    }

    public UUID getBlueprintId() {
        return blueprintId;
    }

    public void setBlueprintId(UUID blueprintId) {
        this.blueprintId = blueprintId;
    }

    @Override
    public String toString() {
        return "GemstoneDto{" +
                "id=" + id +
                ", stone='" + stone + '\'' +
                ", stoneColor=" + stoneColor +
                ", stoneWeight=" + stoneWeight +
                ", stoneCount=" + stoneCount +
                ", stonePolished=" + stonePolished +
                ", blueprintId=" + blueprintId +
                '}';
    }
}

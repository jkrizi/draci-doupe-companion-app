package net.homecredit.trainee.drd.controller.dto;

public class MaterialDto {
    private String type;
    private String quality;
    private String weight;

    public MaterialDto(String type, String quality, String weight) {
        this.type = type;
        this.quality = quality;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "MaterialDto{" +
                "type='" + type + '\'' +
                ", quality='" + quality + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}

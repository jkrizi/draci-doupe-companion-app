package net.homecredit.trainee.drd.controller.dto;

import java.util.List;
import java.util.UUID;

public class ArmorBlueprintDto {

    private UUID id;
    private String name;
    private String publicDescription;
    private String privateDescription;
    private int weight;
    private int defense;
    private List<String> coverage;

    public ArmorBlueprintDto(UUID id, String name, String publicDescription, String privateDescription, int weight, int defense, List<String> coverage) {
        this.id = id;
        this.name = name;
        this.publicDescription = publicDescription;
        this.privateDescription = privateDescription;
        this.weight = weight;
        this.defense = defense;
        this.coverage = coverage;
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

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public String getPrivateDescription() {
        return privateDescription;
    }

    public void setPrivateDescription(String privateDescription) {
        this.privateDescription = privateDescription;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public List<String> getCoverage() {
        return coverage;
    }

    public void setCoverage(List<String> coverage) {
        this.coverage = coverage;
    }
}

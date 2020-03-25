package net.homecredit.trainee.drd.controller.inventory;

import java.util.List;
import java.util.UUID;

public class ArmorBlueprintDto {

    private UUID id;
    private String name;
    private String publicDescription;
    private String privateDescription;
    private String armorSize;
    private int weight;
    private int defense;
    private List<String> coverage;
    private int ownedPieces;

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

    public int getOwnedPieces() {
        return ownedPieces;
    }

    public void setOwnedPieces(int ownedPieces) {
        this.ownedPieces = ownedPieces;
    }

    public String getArmorSize() {
        return armorSize;
    }

    public void setArmorSize(String armorSize) {
        this.armorSize = armorSize;
    }
}

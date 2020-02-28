package net.homecredit.trainee.drd.controller.dto;

import net.homecredit.trainee.drd.entity.character.Beast;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.Vulnerability;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.character.combat.CombatValues;
import net.homecredit.trainee.drd.entity.inventory.Inventory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BeastBlueprintsDto {

    private UUID id;
    private String origin;
    private String name;
    private String species;
    private String description;
    private int viability;
    private int viabilityBonus;
    private int manna;
    private int mobility;
    private Map<Ability, AbilityScore> abilityMap;
    private Set<CharacterSize> sizes;
    private Set<Vulnerability> vulnerabilities;
    private Collection<Beast> beasts;
    private Inventory inventory;
    private CombatValues combatValues;
    private int pugnacity;
    private int persistence;
    private int domestication;
    private boolean schooled;

    public BeastBlueprintsDto(UUID id, String origin, String name, String species, String description, int viability, int viabilityBonus, int manna, int mobility, Map<Ability, AbilityScore> abilityMap, Set<CharacterSize> sizes, Set<Vulnerability> vulnerabilities, Collection<Beast> beasts, Inventory inventory, CombatValues combatValues, int pugnacity, int persistence, int domestication, boolean schooled) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.species = species;
        this.description = description;
        this.viability = viability;
        this.viabilityBonus = viabilityBonus;
        this.manna = manna;
        this.mobility = mobility;
        this.abilityMap = abilityMap;
        this.sizes = sizes;
        this.vulnerabilities = vulnerabilities;
        this.beasts = beasts;
        this.inventory = inventory;
        this.combatValues = combatValues;
        this.pugnacity = pugnacity;
        this.persistence = persistence;
        this.domestication = domestication;
        this.schooled = schooled;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViability() {
        return viability;
    }

    public void setViability(int viability) {
        this.viability = viability;
    }

    public int getViabilityBonus() {
        return viabilityBonus;
    }

    public void setViabilityBonus(int viabilityBonus) {
        this.viabilityBonus = viabilityBonus;
    }

    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
    }

    public int getMobility() {
        return mobility;
    }

    public void setMobility(int mobility) {
        this.mobility = mobility;
    }

    public Map<Ability, AbilityScore> getAbilityMap() {
        return abilityMap;
    }

    public void setAbilityMap(Map<Ability, AbilityScore> abilityMap) {
        this.abilityMap = abilityMap;
    }

    public Set<CharacterSize> getSizes() {
        return sizes;
    }

    public void setSizes(Set<CharacterSize> sizes) {
        this.sizes = sizes;
    }

    public Set<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Set<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public Collection<Beast> getBeasts() {
        return beasts;
    }

    public void setBeasts(Collection<Beast> beasts) {
        this.beasts = beasts;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public CombatValues getCombatValues() {
        return combatValues;
    }

    public void setCombatValues(CombatValues combatValues) {
        this.combatValues = combatValues;
    }

    public int getPugnacity() {
        return pugnacity;
    }

    public void setPugnacity(int pugnacity) {
        this.pugnacity = pugnacity;
    }

    public int getPersistence() {
        return persistence;
    }

    public void setPersistence(int persistence) {
        this.persistence = persistence;
    }

    public int getDomestication() {
        return domestication;
    }

    public void setDomestication(int domestication) {
        this.domestication = domestication;
    }

    public boolean isSchooled() {
        return schooled;
    }

    public void setSchooled(boolean schooled) {
        this.schooled = schooled;
    }
}

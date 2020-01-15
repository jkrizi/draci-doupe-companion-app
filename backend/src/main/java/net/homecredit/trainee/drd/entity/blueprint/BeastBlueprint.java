package net.homecredit.trainee.drd.entity.blueprint;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.homecredit.trainee.drd.entity.character.Beast;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.Vulnerability;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.entity.character.combat.CombatValues;
import net.homecredit.trainee.drd.entity.inventory.Inventory;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BEAST_BLUEPRINT")
public class BeastBlueprint {

    @Id
    private UUID id;
    private String origin;
    private String name;
    private String species;
    private String description;
    private int viability;
    private int viabilityBonus;
    private int manna;
    private int mobility;

    @OneToMany(mappedBy = "beastBlueprint", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "ability")
    @MapKeyEnumerated
    private Map<Ability, AbilityScore> abilityMap;

    @ElementCollection
    @CollectionTable(name = "BEAST_SIZE", joinColumns = @JoinColumn(name = "BEAST_BLUEPRINT_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "CHARACTER_SIZE")
    private Set<CharacterSize> sizes;

    @ElementCollection
    @CollectionTable(name = "BEAST_VULNERABILITY", joinColumns = @JoinColumn(name = "BEAST_BLUEPRINT_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "VULNERABILITY")
    private Set<Vulnerability> vulnerabilities;

    @JsonManagedReference
    @OneToMany(mappedBy = "beastBlueprint", cascade = CascadeType.ALL)
    private Collection<Beast> beasts;

    @OneToOne(fetch = FetchType.LAZY)
    private Inventory inventory;

    private CombatValues combatValues;

    private int pugnacity;
    private int persistence;
    private int domestication;

    private boolean schooled;

    public BeastBlueprint() {
    }

    public BeastBlueprint(String origin, String name, String species, String description, int viability, int viabilityBonus, int manna, Map<Ability, AbilityScore> abilityMap, int mobility, EnumSet<CharacterSize> sizes, EnumSet<Vulnerability> vulnerabilities, Inventory inventory, CombatValues combatValues, int pugnacity, int persistence, int domestication, boolean schooled) {
        this.id = UUID.randomUUID();
        this.origin = origin;
        this.name = name;
        this.species = species;
        this.description = description;
        this.viability = viability;
        this.viabilityBonus = viabilityBonus;
        this.manna = manna;
        this.abilityMap = abilityMap;
        this.mobility = mobility;
        this.sizes = sizes;
        this.vulnerabilities = vulnerabilities;
        this.inventory = inventory;
        this.pugnacity = pugnacity;
        this.persistence = persistence;
        this.domestication = domestication;
        this.schooled = schooled;
        this.combatValues = combatValues;
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

    public void setSizes(EnumSet<CharacterSize> sizes) {
        this.sizes = sizes;
    }

    public Set<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(EnumSet<Vulnerability> vulnerabilities) {
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

    public void setDomestication(int tameAbility) {
        this.domestication = tameAbility;
    }

    public boolean isSchooled() {
        return schooled;
    }

    public void setSchooled(boolean schooled) {
        this.schooled = schooled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeastBlueprint)) return false;
        BeastBlueprint that = (BeastBlueprint) o;
        return viability == that.viability &&
                viabilityBonus == that.viabilityBonus &&
                manna == that.manna &&
                mobility == that.mobility &&
                pugnacity == that.pugnacity &&
                persistence == that.persistence &&
                domestication == that.domestication &&
                trained == that.trained &&
                beastOrigin.equals(that.beastOrigin) &&
                name.equals(that.name) &&
                species.equals(that.species) &&
                description.equals(that.description) &&
                abilityMap.equals(that.abilityMap) &&
                size.equals(that.size) &&
                vulnerabilities.equals(that.vulnerabilities) &&
                beasts.equals(that.beasts) &&
                inventory.equals(that.inventory) &&
                combatValues.equals(that.combatValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beastOrigin, name, species, description, viability, viabilityBonus, manna, mobility, abilityMap, size, vulnerabilities, beasts, inventory, combatValues, pugnacity, persistence, domestication, trained);
    }

    @Override
    public String toString() {
        return "BeastBlueprint{" +
                "id=" + id +
                ", beastOrigin='" + beastOrigin + '\'' +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", description='" + description + '\'' +
                ", viability=" + viability +
                ", viabilityBonus=" + viabilityBonus +
                ", manna=" + manna +
                ", mobility=" + mobility +
                ", abilityMap=" + abilityMap +
                ", size=" + size +
                ", vulnerabilities=" + vulnerabilities +
                ", beasts=" + beasts +
                ", inventory=" + inventory +
                ", combatValues=" + combatValues +
                ", pugnacity=" + pugnacity +
                ", persistence=" + persistence +
                ", domestication=" + domestication +
                ", trained=" + trained +
                '}';
    }
}

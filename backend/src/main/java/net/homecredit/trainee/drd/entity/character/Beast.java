package net.homecredit.trainee.drd.entity.character;

import net.homecredit.trainee.drd.entity.blueprint.BeastBlueprint;
import net.homecredit.trainee.drd.entity.character.combat.CombatValues;
import net.homecredit.trainee.drd.entity.inventory.Inventory;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Beast implements Character {

    @Id
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private BeastBlueprint beastBlueprint;
    private String name;
    private String description;
    private int life;
    @Enumerated(EnumType.STRING)
    @Column(name = "BEAST_SIZE")
    private CharacterSize size;
    @OneToOne
    private Inventory inventory;
    private CombatValues combatValues;

    public Beast() {
    }

    public Beast(BeastBlueprint beastBlueprint, String name, String description, int life, CharacterSize size, Inventory inventory, CombatValues combatValues) {
        this.id = UUID.randomUUID();
        this.beastBlueprint = beastBlueprint;
        this.name = name;
        this.description = description;
        this.life = life;
        this.size = size;
        this.inventory = inventory;
        this.combatValues = combatValues;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BeastBlueprint getBeastBlueprint() {
        return beastBlueprint;
    }

    public void setBeastBlueprint(BeastBlueprint generals) {
        this.beastBlueprint = generals;
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public CharacterSize getSize() {
        return size;
    }

    public void setSize(CharacterSize characterSize) {
        this.size = characterSize;
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
}

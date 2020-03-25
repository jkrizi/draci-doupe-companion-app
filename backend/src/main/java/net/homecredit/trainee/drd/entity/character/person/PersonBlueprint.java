package net.homecredit.trainee.drd.entity.character.person;

import net.homecredit.trainee.drd.entity.character.person.profession.Profession;
import net.homecredit.trainee.drd.entity.character.person.race.Race;
import net.homecredit.trainee.drd.entity.inventory.Inventory;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "person_blueprint")
public class PersonBlueprint {

    @Id
    private UUID id;
    private String name;
    private String description;

    @Column(name = "person_level")
    private int level;

    @ManyToOne(fetch = FetchType.LAZY)
    private Race race;
    @Enumerated(EnumType.STRING)
    private Profession profession;

    @OneToOne(fetch = FetchType.LAZY)
    private Inventory inventory;
    @OneToMany(mappedBy = "personBlueprint")
    private Collection<Person> people;

    public PersonBlueprint() {
    }

    public PersonBlueprint(String name, String description, int level, Race race, Profession profession, Inventory inventory, Collection<Person> people) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.level = level;
        this.race = race;
        this.profession = profession;
        this.inventory = inventory;
        this.people = people;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Collection<Person> getPeople() {
        return people;
    }

    public void setPeople(Collection<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "PersonBlueprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", race=" + race +
                ", profession=" + profession +
                ", inventory=" + inventory +
                ", people=" + people +
                '}';
    }
}

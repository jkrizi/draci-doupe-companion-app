package net.homecredit.trainee.drd.entity.inventory.weapon;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class WeaponFamily {

    @Id
    private UUID id;
    private String name;
    private WeaponType weaponType;

    public WeaponFamily() {}

    public WeaponFamily(UUID id, String name, WeaponType weaponType) {
        this.id = id;
        this.name = name;
        this.weaponType = weaponType;
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

    public void setName(String weaponFamilyName) {
        this.name = weaponFamilyName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return "WeaponFamily{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weaponType=" + weaponType +
                '}';
    }
}

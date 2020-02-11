package net.homecredit.trainee.drd.entity.inventory.weapon;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class WeaponFamily {

    @Id
    private UUID id;
    private String weaponFamilyName;
    private WeaponType weaponType;

    public WeaponFamily() {}

    public WeaponFamily(UUID id, String weaponFamilyName, WeaponType weaponType) {
        this.id = id;
        this.weaponFamilyName = weaponFamilyName;
        this.weaponType = weaponType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWeaponFamilyName() {
        return weaponFamilyName;
    }

    public void setWeaponFamilyName(String weaponFamilyName) {
        this.weaponFamilyName = weaponFamilyName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}

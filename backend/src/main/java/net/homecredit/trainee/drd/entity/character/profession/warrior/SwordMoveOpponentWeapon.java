package net.homecredit.trainee.drd.entity.character.profession.warrior;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponFamily;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class SwordMoveOpponentWeapon {

    @Id
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private SwordMove swordMove;
    @ManyToOne(fetch = FetchType.LAZY)
    private WeaponFamily weaponFamily;
}

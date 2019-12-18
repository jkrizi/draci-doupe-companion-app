package net.homecredit.trainee.drd.entity.character.profession;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class SwordPlayMove {

    @Id
    private UUID id;
    private String name;
    private String description;
}

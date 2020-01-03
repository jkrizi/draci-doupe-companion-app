package net.homecredit.trainee.drd.entity.blueprint.item;

import net.homecredit.trainee.drd.util.Color;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "GEMSTONE")
public class GemStone {

    @Id
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Column(name = "UNIT_PRICE")
    private double unitPrice;

    public GemStone() {
    }

    public GemStone(String name, Color color, double unitPrice) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.color = color;
        this.unitPrice = unitPrice;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}

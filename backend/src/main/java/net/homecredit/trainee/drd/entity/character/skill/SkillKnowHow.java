package net.homecredit.trainee.drd.entity.character.skill;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "skill_knowhow")
public class SkillKnowHow {

    @Id
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Skill skill;
    @Column(name = "points_total")
    private int pointsTotal;
    @Column(name = "points_for_next_level")
    private int pointForNextLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_knowledge")
    private SkillKnowledge skillKnowledge;

    public SkillKnowHow() {
    }

    public SkillKnowHow(Skill skill, int pointsTotal, int pointForNextLevel, SkillKnowledge skillKnowledge) {
        this.id = UUID.randomUUID();
        this.skill = skill;
        this.pointsTotal = pointsTotal;
        this.pointForNextLevel = pointForNextLevel;
        this.skillKnowledge = skillKnowledge;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public int getPointForNextLevel() {
        return pointForNextLevel;
    }

    public void setPointForNextLevel(int pointForNextLevel) {
        this.pointForNextLevel = pointForNextLevel;
    }

    public SkillKnowledge getSkillKnowledge() {
        return skillKnowledge;
    }

    public void setSkillKnowledge(SkillKnowledge skillKnowledge) {
        this.skillKnowledge = skillKnowledge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillKnowHow)) return false;
        SkillKnowHow that = (SkillKnowHow) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SkillKnowHow{" +
                "id=" + id +
                ", skill=" + skill +
                ", pointsTotal=" + pointsTotal +
                ", pointForNextLevel=" + pointForNextLevel +
                ", skillKnowledge=" + skillKnowledge +
                '}';
    }
}

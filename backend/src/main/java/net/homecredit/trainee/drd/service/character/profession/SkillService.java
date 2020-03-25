package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.entity.character.person.skill.Skill;
import net.homecredit.trainee.drd.repository.character.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public void update(Skill existingSkill) {
        skillRepository.update(existingSkill);
    }

    public void delete(UUID id) {
        skillRepository.delete(id);
    }

    public void save(Skill newSkill) {
        skillRepository.save(newSkill);
    }
}

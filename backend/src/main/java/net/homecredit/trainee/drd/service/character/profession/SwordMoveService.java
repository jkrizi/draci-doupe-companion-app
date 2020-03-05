package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.entity.character.person.profession.warrior.SwordMove;
import net.homecredit.trainee.drd.repository.character.SwordMoveRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class SwordMoveService {

    private SwordMoveRepository swordMoveRepository;

    public SwordMoveService(SwordMoveRepository swordMoveRepository) {
        this.swordMoveRepository = swordMoveRepository;
    }

    public List<SwordMove> findAll() {
        return swordMoveRepository.findAll();
    }

    public void save(SwordMove newSwordMove) {
        swordMoveRepository.save(newSwordMove);
    }

    public void delete(UUID id) {
        swordMoveRepository.delete(id);
    }

    public void update(SwordMove existingSwordMove) {
        swordMoveRepository.update(existingSwordMove);
    }
}

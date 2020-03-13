package net.homecredit.trainee.drd.service.character.profession;

import net.homecredit.trainee.drd.controller.character.SwordMoveDto;
import net.homecredit.trainee.drd.entity.character.person.profession.warrior.SwordMove;
import net.homecredit.trainee.drd.repository.character.SwordMoveRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class SwordMoveService {

    private final SwordMoveRepository swordMoveRepository;
    private final ModelMapper modelMapper;

    public SwordMoveService(SwordMoveRepository swordMoveRepository, ModelMapper modelMapper) {
        this.swordMoveRepository = swordMoveRepository;
        this.modelMapper = modelMapper;
    }

    public List<SwordMoveDto> findAll() {
        List<SwordMoveDto> swordMoveDtoList = new ArrayList<>();
        swordMoveRepository.findAll().forEach(swordMove -> swordMoveDtoList.add(convertSwordMove(swordMove)));
        return swordMoveDtoList;
    }

    public void save(SwordMoveDto newSwordMove) {
        System.out.println(newSwordMove);
        System.out.println(convertSwordMoveDto(newSwordMove));
        swordMoveRepository.save(convertSwordMoveDto(newSwordMove));
    }

    public void delete(UUID id) {
        swordMoveRepository.delete(id);
    }

    public void update(SwordMoveDto existingSwordMove) {
        swordMoveRepository.update(convertSwordMoveDto(existingSwordMove));
    }

    private SwordMoveDto convertSwordMove(SwordMove swordMove) {
        return modelMapper.map(swordMove, SwordMoveDto.class);
    }

    private SwordMove convertSwordMoveDto(SwordMoveDto swordMoveDto) {
        return modelMapper.map(swordMoveDto, SwordMove.class);
    }
}

package net.homecredit.trainee.drd.service.character;

import net.homecredit.trainee.drd.controller.character.AbilityScoreDto;
import net.homecredit.trainee.drd.entity.character.ability.AbilityScore;
import net.homecredit.trainee.drd.repository.character.AbilityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AbilityService {

    private final ModelMapper modelMapper;
    private final AbilityRepository abilityRepository;

    public AbilityService(ModelMapper modelMapper, AbilityRepository abilityRepository) {
        this.modelMapper = modelMapper;
        this.abilityRepository = abilityRepository;
    }

    public void save(AbilityScore abilityScore) {
        abilityRepository.save(abilityScore);
    }

    public AbilityScore convert(AbilityScoreDto abilityScoreDto) {
        return modelMapper.map(abilityScoreDto, AbilityScore.class);
    }

    public AbilityScoreDto convert(AbilityScore abilityScore) {
        return modelMapper.map(abilityScore, AbilityScoreDto.class);
    }
}

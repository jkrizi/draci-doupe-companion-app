package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.entity.character.person.skill.Skill;
import net.homecredit.trainee.drd.service.character.profession.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SkillController {

    private final SkillService skillService;
    private final ModelMapper modelMapper;

    public SkillController(SkillService skillService, ModelMapper modelMapper) {
        this.skillService = skillService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAllSkills.json")
    public List<SkillDto> listSkills() {
        List<SkillDto> skillDtoList = new ArrayList<>();
        skillService.findAll().forEach( skill -> skillDtoList.add(convertSkill(skill)));
        return skillDtoList;
    }

    @PostMapping("/saveSkill.json")
    public void saveSkill(@RequestBody SkillDto newSkill) {
        skillService.save(convertSkillDto(newSkill));
    }

    @PostMapping("/updateSkill.json")
    public void updateSkill(@RequestBody SkillDto existingSkill) {
        Skill skill = convertSkillDto(existingSkill);
        skillService.update(skill);
    }

    @DeleteMapping("/deleteSkill.json")
    public void deleteRace(@RequestParam UUID id) {
        skillService.delete(id);
    }

    private Skill convertSkillDto(SkillDto skillDto) {
        return modelMapper.map(skillDto, Skill.class);
    }

    private SkillDto convertSkill(Skill skill) {
        return modelMapper.map(skill, SkillDto.class);
    }
}


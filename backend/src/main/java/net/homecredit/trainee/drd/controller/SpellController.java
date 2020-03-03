package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.controller.dto.SpellDto;
import net.homecredit.trainee.drd.entity.character.profession.wizard.Spell;
import net.homecredit.trainee.drd.service.character.profession.SpellService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SpellController {

    private final SpellService spellService;
    private final ModelMapper modelMapper;

    public SpellController(SpellService spellService, ModelMapper modelMapper) {
        this.spellService = spellService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAllSpells.json")
    public List<SpellDto> listSpells() {
        List<SpellDto> spells = new ArrayList<>();
        spellService.findAll().forEach(spell -> spells.add(convert(spell)));
        return spells;
    }

    @PostMapping("/saveSpell.json")
    public void saveSpell(@RequestBody SpellDto newSpell) {
        spellService.save(convert(newSpell));
    }

    @PostMapping("/updateSpell.json")
    public void updateSpell(@RequestBody SpellDto existingSpell) {
        spellService.update(convert(existingSpell));
    }

    @DeleteMapping("/deleteSpell.json")
    public void deleteSpell(@RequestParam UUID id) {
        spellService.delete(id);
    }

    private Spell convert(SpellDto spellDto) {
        return modelMapper.map(spellDto, Spell.class);
    }

    private SpellDto convert(Spell spell) {
        return modelMapper.map(spell, SpellDto.class);
    }
}

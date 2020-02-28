package net.homecredit.trainee.drd.controller.dto;

import java.util.ArrayList;
import java.util.List;

import net.homecredit.trainee.drd.entity.character.profession.wizard.Spell;

public class SpellDtoConverter {

    public Spell convert(SpellDto dto) {
        Spell spell = new Spell(
                dto.getName(),
                dto.getDescription(),
                dto.getManna(),
                dto.getRange(),
                dto.getConjuring(),
                dto.getDuration()
        );
        spell.setId(dto.getId());
        return spell;
    }

    public SpellDto convert(Spell spell) {
        SpellDto dto = new SpellDto(
                spell.getId(),
                spell.getName(),
                spell.getDescription(),
                spell.getManna(),
                spell.getRange(),
                spell.getConjuring(),
                spell.getDuration()
        );
        return dto;
    }

    public List<SpellDto> convert(List<Spell> all) {
        if(all.size() == 0){
            return new ArrayList<>();
        }
        List<SpellDto> list = new ArrayList<>(all.size());
        for (Spell spell : all) {
            list.add(convert(spell));
        }
        return list;
    }
}

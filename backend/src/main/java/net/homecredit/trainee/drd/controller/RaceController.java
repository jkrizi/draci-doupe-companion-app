package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.controller.dto.RaceDto;
import net.homecredit.trainee.drd.entity.character.race.Race;
import net.homecredit.trainee.drd.service.character.RaceService;
import net.homecredit.trainee.drd.service.item.WeaponFamilyService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RaceController {

    private final RaceService raceService;
    private final ModelMapper modelMapper;
    private final WeaponFamilyService weaponFamilyService;

    public RaceController(RaceService raceService, ModelMapper modelMapper, WeaponFamilyService weaponFamilyService) {
        this.raceService = raceService;
        this.modelMapper = modelMapper;
        this.weaponFamilyService = weaponFamilyService;
    }

    @GetMapping("/getAllRaces.json")
    public List<RaceDto> listRaces() {
        List<Race> races = raceService.findAll();
        List<RaceDto> raceDtoList = new ArrayList<>();
        for(Race r: races) {
            raceDtoList.add(convertToDto(r));
        }
        return raceDtoList;
    }

    @PostMapping("/saveRace.json")
    public void saveRace(@RequestBody RaceDto newRace) {
        raceService.save(convertToEntity(newRace));
    }

    @PostMapping("/updateRace.json")
    public void updateRace(@RequestBody RaceDto existingRace) {
        Race entity = convertToEntity(existingRace);
        raceService.update(entity);
    }

    @DeleteMapping("/deleteRace.json")
    public void deleteRace(@RequestParam UUID id) {
        raceService.delete(id);
    }

    private Race convertToEntity(RaceDto dto) {
        System.out.println(dto);
        Race entity = modelMapper.map(dto, Race.class);
        entity.setWeapon(weaponFamilyService.findById(dto.getWeaponFamilyId()));
        System.out.println(entity);
        return entity;
    }

    private RaceDto convertToDto(Race entity) {
        RaceDto dto = modelMapper.map(entity, RaceDto.class);
        dto.setWeaponFamilyId(entity.getWeapon().getId());
        return dto;
    }
}

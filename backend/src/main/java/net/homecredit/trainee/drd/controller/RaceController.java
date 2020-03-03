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
        List<RaceDto> races = new ArrayList<>();
        raceService.findAll().forEach( race -> races.add(convert(race)));
        return races;
    }

    @PostMapping("/saveRace.json")
    public void saveRace(@RequestBody RaceDto newRace) {
        raceService.save(convert(newRace));
    }

    @PostMapping("/updateRace.json")
    public void updateRace(@RequestBody RaceDto existingRace) {
        Race entity = convert(existingRace);
        raceService.update(entity);
    }

    @DeleteMapping("/deleteRace.json")
    public void deleteRace(@RequestParam UUID id) {
        raceService.delete(id);
    }

    private Race convert(RaceDto raceDto) {
        Race race = modelMapper.map(raceDto, Race.class);
        race.setWeapon(weaponFamilyService.findById(raceDto.getWeaponFamilyId()));
        return race;
    }

    private RaceDto convert(Race race) {
        RaceDto raceDto = modelMapper.map(race, RaceDto.class);
        raceDto.setWeaponFamilyId(race.getWeapon().getId());
        return raceDto;
    }
}

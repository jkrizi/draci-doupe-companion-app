package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.service.character.PersonBlueprintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PersonBlueprintController {

    private final PersonBlueprintService personBlueprintService;

    public PersonBlueprintController(PersonBlueprintService personBlueprintService) {
        this.personBlueprintService = personBlueprintService;
    }

    @GetMapping(value = "/getAllPersonBlueprints.json")
    public List<PersonBlueprintDto> listPersonBlueprints() {
        return personBlueprintService.findAll();
    }

    @PostMapping("/savePersonBlueprint.json")
    public void savePersonBlueprint(@RequestBody PersonBlueprintDto newPersonBlueprint) {
        personBlueprintService.save(newPersonBlueprint);
    }

    @PostMapping("/updatePersonBlueprint.json")
    public void updatePersonBlueprint(@RequestBody PersonBlueprintDto existingPersonBlueprint) {
        personBlueprintService.update(existingPersonBlueprint);
    }

    @DeleteMapping("/deletePersonBlueprint.json")
    public void deletePersonBlueprint(@RequestParam UUID id) {
        personBlueprintService.delete(id);
    }
}

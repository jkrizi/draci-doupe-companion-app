package net.homecredit.trainee.drd.controller.character;

import net.homecredit.trainee.drd.entity.character.person.profession.warrior.SwordMove;
import net.homecredit.trainee.drd.service.character.profession.SwordMoveService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SwordMoveController {

    private SwordMoveService swordMoveService;

    public SwordMoveController(SwordMoveService swordMoveService) {
        this.swordMoveService = swordMoveService;
    }

    @GetMapping(value = "/getAllSwordMoves.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SwordMove> listSwordMoves() {
        return swordMoveService.findAll();
    }

    @PostMapping("/saveSwordMove.json")
    public void saveSwordMove(@RequestBody SwordMove newSwordMove) {
        swordMoveService.save(newSwordMove);
    }

    @PostMapping("/updateSwordMove.json")
    public void updateSwordMove(@RequestBody SwordMove existingSwordMove) {
        swordMoveService.update(existingSwordMove);
    }

    @DeleteMapping("/deleteSwordMove.json")
    public void deleteSwordMove(@RequestParam UUID id) {
        swordMoveService.delete(id);
    }
}

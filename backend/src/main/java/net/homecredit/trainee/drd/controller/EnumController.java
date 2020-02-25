package net.homecredit.trainee.drd.controller;

import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponDamageType;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeightCategory;
import net.homecredit.trainee.drd.util.Color;
import net.homecredit.trainee.drd.util.Material;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.Vulnerability;
import net.homecredit.trainee.drd.entity.character.ability.Ability;
import net.homecredit.trainee.drd.entity.character.profession.Profession;
import net.homecredit.trainee.drd.entity.character.skill.SkillDifficulty;
import net.homecredit.trainee.drd.entity.character.skill.SkillKnowledge;
import net.homecredit.trainee.drd.entity.inventory.armor.BodySection;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnumController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterSizes.json")
    public @ResponseBody
    CharacterSize[] sendCharacterSizes() {
        return CharacterSize.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/vulnerabilities.json")
    public @ResponseBody
    Vulnerability[] sendVulnerability() {
        return Vulnerability.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/materials.json")
    public @ResponseBody
    Material[] sendMaterials() {
        return Material.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/qualityLevels.json")
    public @ResponseBody
    SkillKnowledge[] sendSkillKnowledge() {
        return SkillKnowledge.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/difficulties.json")
    public @ResponseBody
    SkillDifficulty[] sendSkillDifficulties() {
        return SkillDifficulty.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/professions.json")
    public @ResponseBody
    Profession[] sendProfessions() {
        return Profession.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/abilities.json")
    public @ResponseBody
    Ability[] sendAbilities() {
        return Ability.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/bodySections.json")
    public @ResponseBody
    BodySection[] sendBodySections() {
        return BodySection.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/itemTypes.json")
    public @ResponseBody
    ItemType[] sendItemTypes() {
        return ItemType.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/colors.json")
    public @ResponseBody
    Color[] sendColors() {
        return Color.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/weightCategories.json")
    public @ResponseBody
    WeightCategory[] sendWeightCategories() {
        return WeightCategory.values();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/weaponDamageTypes.json")
    public @ResponseBody
    WeaponDamageType[] sendWeaponDamageTypes() { return WeaponDamageType.values(); }
}

package net.homecredit.trainee.drd.controller.dto;

import java.util.ArrayList;
import java.util.List;

import net.homecredit.trainee.drd.entity.blueprint.PersonBlueprint;
import net.homecredit.trainee.drd.entity.character.CharacterSize;
import net.homecredit.trainee.drd.entity.character.race.Race;

public class RaceConverter {

    public Race convert(RaceDto dto) {
        //prepare enum from List<String> charSize from racedto
        CharacterSize characterSize = getSizeEnum(dto.getCharacterSize());

        List<PersonBlueprint> cc = new ArrayList<>();
        Race race = new Race(
                dto.getName(),
                dto.getDescription(),
                dto.getMinWeight(),
                dto.getMaxWeight(),
                dto.getMinHeight(),
                dto.getMaxHeight(),
                characterSize,
                dto.getWeapon(),
                cc,
                dto.getStrengthNrOfThrows(),
                dto.getDexterityNrOfThrows(),
                dto.getResistanceNrOfThrows(),
                dto.getIntelligenceNrOfThrows(),
                dto.getCharismaNrOfThrows(),
                dto.getStrengthAbilityBase(),
                dto.getDexterityAbilityBase(),
                dto.getResistanceAbilityBase(),
                dto.getIntelligenceAbilityBase(),
                dto.getCharismaAbilityBase(),
                dto.getStrengthAbilityCorrection(),
                dto.getDexterityAbilityCorrection(),
                dto.getResistanceAbilityCorrection(),
                dto.getIntelligenceAbilityCorrection(),
                dto.getCharismaAbilityCorrection()
        );
        race.setId(dto.getId());
        return race;
    }

    public RaceDto convert(Race race) {
        RaceDto dto = new RaceDto();
        dto.setName(race.getName());
        dto.setDescription(race.getDescription());
        dto.setMinWeight(race.getMinWeight());
        dto.setMaxWeight(race.getMaxWeight());
        dto.setMinHeight(race.getMinHeight());
        dto.setMaxHeight(race.getMaxHeight());
        dto.setWeapon(race.getWeapon());
        dto.setStrengthNrOfThrows(race.getStrengthNrOfThrows());
        dto.setDexterityNrOfThrows(race.getDexterityNrOfThrows());
        dto.setResistanceNrOfThrows(race.getResistanceNrOfThrows());
        dto.setIntelligenceNrOfThrows(race.getIntelligenceNrOfThrows());
        dto.setCharismaNrOfThrows(race.getCharismaNrOfThrows());
        dto.setStrengthAbilityBase(race.getStrengthAbilityBase());
        dto.setDexterityAbilityBase(race.getDexterityAbilityBase());
        dto.setResistanceAbilityBase(race.getResistanceAbilityBase());
        dto.setIntelligenceAbilityBase(race.getIntelligenceAbilityBase());
        dto.setCharismaAbilityBase(race.getCharismaAbilityBase());
        dto.setStrengthAbilityCorrection(race.getStrengthAbilityCorrection());
        dto.setDexterityAbilityCorrection(race.getDexterityAbilityCorrection());
        dto.setResistanceAbilityCorrection(race.getResistanceAbilityCorrection());
        dto.setIntelligenceAbilityCorrection(race.getIntelligenceAbilityCorrection());
        dto.setCharismaAbilityCorrection(race.getCharismaAbilityCorrection());
        dto.setCharacterSize(prepareSizeList(race.getSize()));
        return dto;
    }

    private List<String> prepareSizeList(CharacterSize characterSizeEnum) {
        String racesSizeEnum = characterSizeEnum.toString();
        List<String> characterSize = new ArrayList<>();
        characterSize.add(CharacterSize.A0.toString());
        characterSize.add("False");
        characterSize.add(CharacterSize.A.toString());
        characterSize.add("False");
        characterSize.add(CharacterSize.B.toString());
        characterSize.add("False");
        characterSize.add(CharacterSize.C.toString());
        characterSize.add("False");
        characterSize.add(CharacterSize.D.toString());
        characterSize.add("False");
        characterSize.add(CharacterSize.E.toString());
        characterSize.add("False");

        for (int i = 0; i < characterSize.size(); i += 2) {
            if (racesSizeEnum.equals(characterSize.get(i))) {
                characterSize.remove(i + 1);
                characterSize.add(i + 1, "True");
                break;
            }
        }
        return characterSize;
    }

    private CharacterSize getSizeEnum(List<String> characterSizeList) {
        for (int i = 0; i < characterSizeList.size(); i++) {
            if (characterSizeList.get(i).equals("True")) {
                String s = characterSizeList.get(i - 1);
                return CharacterSize.valueOf(s);
            }
        }
        throw new RuntimeException("Didn't find any character size");
    }

    public List<RaceDto> convert(List<Race> all) {
        List<RaceDto> list = new ArrayList<>(all.size());
        for (Race race : all) {
            list.add(convert(race));
        }
        return list;
    }
}

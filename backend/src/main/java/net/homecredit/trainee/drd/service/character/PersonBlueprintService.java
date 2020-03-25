package net.homecredit.trainee.drd.service.character;

import net.homecredit.trainee.drd.controller.character.PersonBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.ArmorBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.GoodsBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.TreasureBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.WeaponBlueprintDto;
import net.homecredit.trainee.drd.entity.character.person.PersonBlueprint;
import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintArmorBlueprint;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintGoodsBlueprint;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintTreasureBlueprint;
import net.homecredit.trainee.drd.entity.util.PersonBlueprintWeaponBlueprint;
import net.homecredit.trainee.drd.repository.character.PersonBlueprintRepository;
import net.homecredit.trainee.drd.service.inventory.*;
import net.homecredit.trainee.drd.service.shop.BuyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PersonBlueprintService {

    private final PersonBlueprintRepository personBlueprintRepository;
    private final ItemService itemService;
    private final BuyService buyService;
    private final ModelMapper modelMapper;

    public PersonBlueprintService(PersonBlueprintRepository personBlueprintRepository, ItemService itemService, BuyService buyService, ModelMapper modelMapper) {
        this.personBlueprintRepository = personBlueprintRepository;
        this.itemService = itemService;
        this.buyService = buyService;
        this.modelMapper = modelMapper;
    }

    public List<PersonBlueprintDto> findAll() {
        List<PersonBlueprintDto> personBlueprintDtoList = new ArrayList<>();
        personBlueprintRepository.findAll().forEach(personBlueprint -> personBlueprintDtoList.add(convertPersonBlueprint(personBlueprint)));
        return personBlueprintDtoList;
    }

    public void save(PersonBlueprintDto newPersonBlueprint) {
        personBlueprintRepository.save(convertPersonBlueprintDto(newPersonBlueprint));
    }

    public void update(PersonBlueprintDto existingPersonBlueprint) {
        personBlueprintRepository.update(convertPersonBlueprintDto(existingPersonBlueprint));
    }

    public void delete(UUID id) {
        personBlueprintRepository.delete(id);
    }

    private PersonBlueprintDto convertPersonBlueprint(PersonBlueprint personBlueprint) {
        PersonBlueprintDto personBlueprintDto = modelMapper.map(personBlueprint, PersonBlueprintDto.class);

        personBlueprintDto.setGold(buyService.goldCoins(personBlueprint.getCoinPouch()));
        personBlueprintDto.setSilver(buyService.silverCoins(personBlueprint.getCoinPouch()));
        personBlueprintDto.setCopper(buyService.copperCoins(personBlueprint.getCoinPouch()));

        itemService.convertItemBlueprintEntities(personBlueprint, personBlueprintDto);

        return personBlueprintDto;
    }

    private PersonBlueprint convertPersonBlueprintDto(PersonBlueprintDto personBlueprintDto) {
        PersonBlueprint personBlueprint = modelMapper.map(personBlueprintDto, PersonBlueprint.class);

        personBlueprint.setCoinPouch(buyService.convertCoins(personBlueprintDto.getGold(), personBlueprintDto.getSilver(), personBlueprintDto.getCopper()));

        itemService.convertItemBlueprintDtos(personBlueprint, personBlueprintDto);

        return personBlueprint;
    }
}

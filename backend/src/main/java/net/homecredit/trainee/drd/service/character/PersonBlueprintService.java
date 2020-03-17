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
import net.homecredit.trainee.drd.service.inventory.ArmorBlueprintService;
import net.homecredit.trainee.drd.service.inventory.GoodsBlueprintService;
import net.homecredit.trainee.drd.service.inventory.TreasureBlueprintService;
import net.homecredit.trainee.drd.service.inventory.WeaponBlueprintService;
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
    private final WeaponBlueprintService weaponBlueprintService;
    private final ArmorBlueprintService armorBlueprintService;
    private final TreasureBlueprintService treasureBlueprintService;
    private final GoodsBlueprintService goodsBlueprintService;
    private final BuyService buyService;
    private final ModelMapper modelMapper;

    public PersonBlueprintService(PersonBlueprintRepository personBlueprintRepository, WeaponBlueprintService weaponBlueprintService, ArmorBlueprintService armorBlueprintService, TreasureBlueprintService treasureBlueprintService, GoodsBlueprintService goodsBlueprintService, BuyService buyService, ModelMapper modelMapper) {
        this.personBlueprintRepository = personBlueprintRepository;
        this.weaponBlueprintService = weaponBlueprintService;
        this.armorBlueprintService = armorBlueprintService;
        this.treasureBlueprintService = treasureBlueprintService;
        this.goodsBlueprintService = goodsBlueprintService;
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

        personBlueprint.getWeaponBlueprints().forEach(weaponBlueprint -> personBlueprintDto.getWeaponry().add(weaponBlueprintService.convertWeaponBlueprint(weaponBlueprint.getWeaponBlueprint())));
        personBlueprint.getArmorBlueprints().forEach(armorBlueprint -> personBlueprintDto.getArmory().add(armorBlueprintService.convert(armorBlueprint.getArmorBlueprint())));
        personBlueprint.getTreasureBlueprints().forEach(treasureBlueprint -> personBlueprintDto.getTreasury().add(treasureBlueprintService.convert(treasureBlueprint.getTreasureBlueprint())));
        personBlueprint.getGoodsBlueprints().forEach(goodsBlueprint -> personBlueprintDto.getGoods().add(goodsBlueprintService.convert(goodsBlueprint.getGoodsBlueprint())));

        return personBlueprintDto;
    }

    private PersonBlueprint convertPersonBlueprintDto(PersonBlueprintDto personBlueprintDto) {

        PersonBlueprint newPersonBlueprint = modelMapper.map(personBlueprintDto, PersonBlueprint.class);
        newPersonBlueprint.setCoinPouch(buyService.convertCoins(personBlueprintDto.getGold(), personBlueprintDto.getSilver(), personBlueprintDto.getCopper()));

        personBlueprintDto.getWeaponry().forEach(weaponBlueprintDto -> addWeaponBlueprint(weaponBlueprintDto, newPersonBlueprint));
        personBlueprintDto.getArmory().forEach(armorBlueprintDto -> addArmorBlueprint(armorBlueprintDto, newPersonBlueprint));
        personBlueprintDto.getTreasury().forEach(treasureBlueprintDto -> addTreasureBlueprint(treasureBlueprintDto, newPersonBlueprint));
        personBlueprintDto.getGoods().forEach(goodsBlueprintDto -> addGoodsBlueprint(goodsBlueprintDto, newPersonBlueprint));

        return newPersonBlueprint;
    }

    private void addGoodsBlueprint(GoodsBlueprintDto goodsBlueprintDto, PersonBlueprint newPersonBlueprint) {
        GoodsBlueprint goodsBlueprint = goodsBlueprintService.findById(goodsBlueprintDto.getId());
        newPersonBlueprint.getGoodsBlueprints()
                .add(new PersonBlueprintGoodsBlueprint(newPersonBlueprint, goodsBlueprint, goodsBlueprintDto.getOwnedPieces()));
    }

    private void addTreasureBlueprint(TreasureBlueprintDto treasureBlueprintDto, PersonBlueprint newPersonBlueprint) {
        TreasureBlueprint treasureBlueprint = treasureBlueprintService.findById(treasureBlueprintDto.getId());
        newPersonBlueprint.getTreasureBlueprints()
                .add(new PersonBlueprintTreasureBlueprint(newPersonBlueprint, treasureBlueprint, treasureBlueprintDto.getOwnedPieces()));
    }

    private void addArmorBlueprint(ArmorBlueprintDto armorBlueprintDto, PersonBlueprint newPersonBlueprint) {
        ArmorBlueprint armorBlueprint = armorBlueprintService.findById(armorBlueprintDto.getId());
        newPersonBlueprint.getArmorBlueprints()
                .add(new PersonBlueprintArmorBlueprint(newPersonBlueprint, armorBlueprint, armorBlueprintDto.getOwnedPieces()));
    }

    private void addWeaponBlueprint(WeaponBlueprintDto weaponBlueprintDto, PersonBlueprint newPersonBlueprint) {
        WeaponBlueprint weaponBlueprint = weaponBlueprintService.findById(weaponBlueprintDto.getId());
        newPersonBlueprint.getWeaponBlueprints()
                .add(new PersonBlueprintWeaponBlueprint(newPersonBlueprint, weaponBlueprint, weaponBlueprintDto.getOwnedPieces()));
    }
}

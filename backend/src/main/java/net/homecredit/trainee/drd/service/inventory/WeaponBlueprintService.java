package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.controller.inventory.WeaponBlueprintDto;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.entity.util.CharacterBlueprintItemBlueprint;
import net.homecredit.trainee.drd.repository.inventory.WeaponBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class WeaponBlueprintService {

    private final WeaponBlueprintRepository weaponBlueprintRepository;
    private final ShopService shopService;
    private final ModelMapper modelMapper;

    public WeaponBlueprintService(WeaponBlueprintRepository weaponBlueprintRepository, ShopService shopService, ModelMapper modelMapper) {
        this.weaponBlueprintRepository = weaponBlueprintRepository;
        this.shopService = shopService;
        this.modelMapper = modelMapper;
    }

    public WeaponBlueprint findById(UUID id) {
        return weaponBlueprintRepository.find(id);
    }

    public void deleteAll() {
        weaponBlueprintRepository.deleteAll();
    }

    public List<WeaponBlueprintDto> findAll() {
        List<WeaponBlueprintDto> weaponBlueprintDtoList = new ArrayList<>();
        weaponBlueprintRepository.findAll().forEach(weaponBlueprint ->
            weaponBlueprintDtoList.add(convert(weaponBlueprint))
        );
        return weaponBlueprintDtoList;
    }

    public void save(WeaponBlueprintDto weaponBlueprintDto) {
        WeaponBlueprint newWeaponBlueprint = convert(weaponBlueprintDto);
        if(weaponBlueprintRepository.containsBlueprint(newWeaponBlueprint)){
            throw new RuntimeException("Weapon blueprint already exists");
        }
        weaponBlueprintRepository.save(newWeaponBlueprint);
        shopService.createPriceTag(newWeaponBlueprint, ItemType.WEAPONS);
    }

    public void update(WeaponBlueprintDto weaponBlueprintDto) {
        WeaponBlueprint existingWeaponBlueprint = convert(weaponBlueprintDto);
        weaponBlueprintRepository.update(existingWeaponBlueprint);
    }

    public void delete(UUID id) {
        weaponBlueprintRepository.delete(id);
    }

    private WeaponBlueprint convert(WeaponBlueprintDto weaponBlueprintDto) {
        return modelMapper.map(weaponBlueprintDto, WeaponBlueprint.class);
    }

    private WeaponBlueprintDto convert(ItemBlueprint weaponBlueprint) {
        return modelMapper.map(weaponBlueprint, WeaponBlueprintDto.class);
    }

    public Set<WeaponBlueprintDto> convertWeaponBlueprintEntities(Set<CharacterBlueprintItemBlueprint> weaponBlueprintLinks) {
        Set<WeaponBlueprintDto> weaponBlueprintDtos = new HashSet<>();
        weaponBlueprintLinks.forEach(weaponBlueprintLink -> weaponBlueprintDtos.add(convert(weaponBlueprintLink.getItemBlueprint())));
        return weaponBlueprintDtos;
    }

    public Set<WeaponBlueprint> convertWeaponBlueprintDtos(Set<WeaponBlueprintDto> weaponBlueprintDtos) {
        Set<WeaponBlueprint> weaponBlueprints = new HashSet<>();
        weaponBlueprintDtos.forEach(weaponBlueprintDto -> weaponBlueprints.add(convert(weaponBlueprintDto)));
        return weaponBlueprints;
    }

}

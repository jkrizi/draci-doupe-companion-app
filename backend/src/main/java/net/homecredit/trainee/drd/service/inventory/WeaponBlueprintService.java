package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.controller.inventory.WeaponBlueprintDto;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.inventory.WeaponBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
            weaponBlueprintDtoList.add(convertWeaponBlueprint(weaponBlueprint))
        );
        return weaponBlueprintDtoList;
    }

    public void save(WeaponBlueprintDto weaponBlueprintDto) {
        WeaponBlueprint newWeaponBlueprint = convertWeaponBlueprintDto(weaponBlueprintDto);
        if(weaponBlueprintRepository.containsBlueprint(newWeaponBlueprint)){
            throw new RuntimeException("Weapon blueprint already exists");
        }
        weaponBlueprintRepository.save(newWeaponBlueprint);
        shopService.createPriceTag(newWeaponBlueprint, ItemType.WEAPONS);
    }

    public void update(WeaponBlueprintDto weaponBlueprintDto) {
        WeaponBlueprint existingWeaponBlueprint = convertWeaponBlueprintDto(weaponBlueprintDto);
        weaponBlueprintRepository.update(existingWeaponBlueprint);
    }

    public void delete(UUID id) {
        weaponBlueprintRepository.delete(id);
    }

    public WeaponBlueprint convertWeaponBlueprintDto(WeaponBlueprintDto weaponBlueprintDto) {
        return modelMapper.map(weaponBlueprintDto, WeaponBlueprint.class);
    }

    public WeaponBlueprintDto convertWeaponBlueprint(WeaponBlueprint weaponBlueprint) {
        return modelMapper.map(weaponBlueprint, WeaponBlueprintDto.class);
    }


}

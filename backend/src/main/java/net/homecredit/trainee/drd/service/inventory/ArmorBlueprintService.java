package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.controller.inventory.ArmorBlueprintDto;
import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.repository.inventory.ArmorBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArmorBlueprintService {

    private final ArmorBlueprintRepository armorBlueprintRepository;
    private final ModelMapper modelMapper;
    private final ShopService shopService;

    public ArmorBlueprintService(ArmorBlueprintRepository armorBlueprintRepository, ModelMapper modelMapper, ShopService shopService) {
        this.armorBlueprintRepository = armorBlueprintRepository;
        this.modelMapper = modelMapper;
        this.shopService = shopService;
    }

    public ArmorBlueprint findById(UUID id) {
        return armorBlueprintRepository.findById(id);
    }

    public void deleteAll() {
        armorBlueprintRepository.deleteAll();
    }

    public List<ArmorBlueprintDto> findAll() {
        List<ArmorBlueprintDto> armorBlueprintDtoList = new ArrayList<>();
        armorBlueprintRepository.findAll().forEach(armorBlueprint -> armorBlueprintDtoList.add(convert(armorBlueprint)));
        return armorBlueprintDtoList;
    }

    public void save(ArmorBlueprintDto newArmorBlueprint) {
        ArmorBlueprint armorBlueprint = convert(newArmorBlueprint);
        if(armorBlueprintRepository.containsBlueprint(armorBlueprint)){
            throw new RuntimeException("Armor blueprint already exists");
        }
        armorBlueprintRepository.save(armorBlueprint);
        shopService.createPriceTag(armorBlueprint, ItemType.ARMOR);
        armorBlueprintRepository.save(armorBlueprint);
    }

    public void update(ArmorBlueprintDto existingArmorBlueprint) {
        armorBlueprintRepository.update(convert(existingArmorBlueprint));
    }

    public void delete(UUID id) {
        armorBlueprintRepository.delete(id);
    }

    public ArmorBlueprint convert(ArmorBlueprintDto armorBlueprintDto) {
        return modelMapper.map(armorBlueprintDto, ArmorBlueprint.class);
    }

    public ArmorBlueprintDto convert(ArmorBlueprint armorBlueprint) {
        return modelMapper.map(armorBlueprint, ArmorBlueprintDto.class);
    }
}

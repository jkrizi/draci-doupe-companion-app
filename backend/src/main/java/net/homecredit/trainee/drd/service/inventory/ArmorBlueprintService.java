package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.controller.character.BeastBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.ArmorBlueprintDto;
import net.homecredit.trainee.drd.entity.character.CharacterBlueprint;
import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.entity.util.BeastBlueprintArmorBlueprint;
import net.homecredit.trainee.drd.entity.util.CharacterBlueprintItemBlueprint;
import net.homecredit.trainee.drd.repository.inventory.ArmorBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    private ArmorBlueprint convert(ArmorBlueprintDto armorBlueprintDto) {
        return modelMapper.map(armorBlueprintDto, ArmorBlueprint.class);
    }

    private ArmorBlueprintDto convert(ItemBlueprint armorBlueprint) {
        return modelMapper.map(armorBlueprint, ArmorBlueprintDto.class);
    }

    public Set<ArmorBlueprint> convertArmorBlueprintDtos(Set<ArmorBlueprintDto> armorBlueprintDtos) {
        Set<ArmorBlueprint> armorBlueprints = new HashSet<>();
        armorBlueprintDtos.forEach(armorBlueprintDto -> armorBlueprints.add(convert(armorBlueprintDto)));
        return armorBlueprints;
    }

    public Set<ArmorBlueprintDto> convertArmorBlueprintEntities(Set<CharacterBlueprintItemBlueprint> armorBlueprintLinks) {
        Set<ArmorBlueprintDto> armorBlueprintDtos = new HashSet<>();
        armorBlueprintLinks.forEach(armorBlueprintLink -> armorBlueprintDtos.add(convert(armorBlueprintLink.getItemBlueprint())));
        return armorBlueprintDtos;
    }
}

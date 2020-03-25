package net.homecredit.trainee.drd.service.character;

import net.homecredit.trainee.drd.controller.character.BeastBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.ArmorBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.GoodsBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.TreasureBlueprintDto;
import net.homecredit.trainee.drd.controller.inventory.WeaponBlueprintDto;
import net.homecredit.trainee.drd.entity.character.beast.BeastBlueprint;
import net.homecredit.trainee.drd.entity.inventory.armor.ArmorBlueprint;
import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.weapon.WeaponBlueprint;
import net.homecredit.trainee.drd.entity.util.*;
import net.homecredit.trainee.drd.repository.character.BeastBlueprintRepository;
import net.homecredit.trainee.drd.service.inventory.*;
import net.homecredit.trainee.drd.service.shop.BuyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class BeastBlueprintService {

    private final BeastBlueprintRepository beastBlueprintRepository;
    private final ItemService itemService;
    private final AbilityService abilityService;
    private final BuyService buyService;
    private final ModelMapper modelMapper;

    public BeastBlueprintService(BeastBlueprintRepository beastBlueprintRepository, ItemService itemService, AbilityService abilityService, BuyService buyService, ModelMapper modelMapper) {
        this.beastBlueprintRepository = beastBlueprintRepository;
        this.itemService = itemService;
        this.abilityService = abilityService;
        this.buyService = buyService;
        this.modelMapper = modelMapper;
    }

    public void deleteAll() {
        beastBlueprintRepository.deleteAll();
    }

    public List<BeastBlueprintDto> findAll() {
        List<BeastBlueprintDto> beastBlueprintDtoList = new ArrayList<>();
        beastBlueprintRepository.findAll().forEach(beastBlueprint -> beastBlueprintDtoList.add(convert(beastBlueprint)));
        return beastBlueprintDtoList;
    }

    public void save(BeastBlueprintDto newBeastBlueprint) {
        System.out.println(newBeastBlueprint);
        BeastBlueprint beastBlueprint = convert(newBeastBlueprint);
        if(beastBlueprintRepository.containsBlueprint(beastBlueprint)){
            throw new RuntimeException("Beast blueprint already exists");
        }
        beastBlueprint.getAbilityMap().values().forEach(abilityService::save);
        System.out.println(beastBlueprint);
        beastBlueprintRepository.save(beastBlueprint);
    }

    public void update(BeastBlueprintDto existingBeastBlueprint) {
        beastBlueprintRepository.update(convert(existingBeastBlueprint));
    }

    public void delete(UUID id) {
        beastBlueprintRepository.delete(id);
    }

    private BeastBlueprint convert(BeastBlueprintDto beastBlueprintDto) {
        BeastBlueprint beastBlueprint = modelMapper.map(beastBlueprintDto, BeastBlueprint.class);

        beastBlueprint.setCoinPouch(buyService.convertCoins(beastBlueprintDto.getGold(), beastBlueprintDto.getSilver(), beastBlueprintDto.getCopper()));
        beastBlueprintDto.getAbilityMap().forEach(abilityScoreDto ->
                beastBlueprint
                        .getAbilityMap()
                        .put(abilityScoreDto.getAbility(), abilityService.convert(abilityScoreDto))
        );

        itemService.convertItemBlueprintDtos(beastBlueprint, beastBlueprintDto);

        return beastBlueprint;
    }

    private BeastBlueprintDto convert(BeastBlueprint beastBlueprint) {
        BeastBlueprintDto beastBlueprintDto = modelMapper.map(beastBlueprint, BeastBlueprintDto.class);

        beastBlueprintDto.setGold(buyService.goldCoins(beastBlueprint.getCoinPouch()));
        beastBlueprintDto.setSilver(buyService.silverCoins(beastBlueprint.getCoinPouch()));
        beastBlueprintDto.setCopper(buyService.copperCoins(beastBlueprint.getCoinPouch()));

        beastBlueprint.getAbilityMap().values().forEach(abilityScore -> beastBlueprintDto
                .getAbilityMap()
                .add(abilityService.convert(abilityScore))
        );

        itemService.convertItemBlueprintEntities(beastBlueprint, beastBlueprintDto);

        return beastBlueprintDto;
    }
}

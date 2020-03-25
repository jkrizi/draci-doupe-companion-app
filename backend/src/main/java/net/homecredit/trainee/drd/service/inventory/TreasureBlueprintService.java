package net.homecredit.trainee.drd.service.inventory;

import java.util.*;

import net.homecredit.trainee.drd.controller.inventory.GemstoneDto;
import net.homecredit.trainee.drd.controller.inventory.TreasureBlueprintDto;
import net.homecredit.trainee.drd.entity.inventory.ItemBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.GemstoneBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.TreasureBlueprint;
import net.homecredit.trainee.drd.entity.inventory.treasure.Gemstone;
import net.homecredit.trainee.drd.entity.shop.ItemType;
import net.homecredit.trainee.drd.entity.util.CharacterBlueprintItemBlueprint;
import net.homecredit.trainee.drd.repository.inventory.GemstoneBlueprintRepository;
import net.homecredit.trainee.drd.repository.inventory.TreasureBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TreasureBlueprintService {

    private final TreasureBlueprintRepository treasureBlueprintRepository;
    private final GemstoneBlueprintRepository gemStoneBlueprintRepository;
    private final ModelMapper modelMapper;
    private final ShopService shopService;

    public TreasureBlueprintService(TreasureBlueprintRepository treasureBlueprintRepository, GemstoneBlueprintRepository gemStoneBlueprintRepository, ModelMapper modelMapper, ShopService shopService) {
        this.treasureBlueprintRepository = treasureBlueprintRepository;
        this.gemStoneBlueprintRepository = gemStoneBlueprintRepository;
        this.modelMapper = modelMapper;
        this.shopService = shopService;
    }

    public TreasureBlueprint findById(UUID id) {
        return treasureBlueprintRepository.findById(id);
    }

    public void deleteAll() {
        treasureBlueprintRepository.deleteAll();
    }

    public List<TreasureBlueprintDto> findAll() {
        List<TreasureBlueprintDto> treasureBlueprintDtoList = new ArrayList<>();
        treasureBlueprintRepository.findAll().forEach(treasureBlueprint -> treasureBlueprintDtoList.add(convert(treasureBlueprint)));
        return treasureBlueprintDtoList;
    }

    public TreasureBlueprint save(TreasureBlueprintDto newTreasureBlueprint){
        TreasureBlueprint treasureBlueprint = convert(newTreasureBlueprint);
        if(treasureBlueprintRepository.containsBlueprint(treasureBlueprint)){
            throw new RuntimeException("Treasure blueprint already exists");
        }
        treasureBlueprintRepository.save(treasureBlueprint);
        shopService.createPriceTag(treasureBlueprint, ItemType.TREASURE);
        return treasureBlueprint;
    }

    public void update(TreasureBlueprintDto treasureBlueprint) {
        treasureBlueprintRepository.update(convert(treasureBlueprint));
    }

    public void delete(UUID id) {
        treasureBlueprintRepository.delete(id);
    }

    private TreasureBlueprint convert(TreasureBlueprintDto treasureBlueprintDto) {
        TreasureBlueprint treasureBlueprint = modelMapper.map(treasureBlueprintDto, TreasureBlueprint.class);

        treasureBlueprint.getGemstones().clear();
        treasureBlueprintDto.getGemstones().forEach(gemstoneDto ->
                treasureBlueprint.getGemstones().add(convert(treasureBlueprint, gemstoneDto))
        );

        for(Gemstone ge : treasureBlueprint.getGemstones()){
            ge.setTreasureBlueprint(treasureBlueprint);
        }
        return treasureBlueprint;
    }

    private TreasureBlueprintDto convert(ItemBlueprint treasureBlueprint) {
        TreasureBlueprintDto treasureBlueprintDto = modelMapper.map(treasureBlueprint, TreasureBlueprintDto.class);

        treasureBlueprintDto.getGemstones().clear();
        ((TreasureBlueprint)treasureBlueprint).getGemstones().forEach(gemstone ->
                treasureBlueprintDto.getGemstones().add(convert(gemstone))
        );
        return treasureBlueprintDto;
    }

    public Set<TreasureBlueprintDto> convertTreasureBlueprintEntities(Set<CharacterBlueprintItemBlueprint> treasureBlueprintLinks) {
        Set<TreasureBlueprintDto> treasureBlueprintDtos = new HashSet<>();
        treasureBlueprintLinks.forEach(treasureBlueprintLink -> treasureBlueprintDtos.add(convert(treasureBlueprintLink.getItemBlueprint())));
        return treasureBlueprintDtos;
    }

    public Set<TreasureBlueprint> convertTreasureBlueprintDtos(Set<TreasureBlueprintDto> treasureBlueprintDtos) {
        Set<TreasureBlueprint> treasureBlueprints = new HashSet<>();
        treasureBlueprints.forEach(treasureBlueprintDto -> treasureBlueprintDtos.add(convert(treasureBlueprintDto)));
        return treasureBlueprints;
    }


    // TODO: Gemstones should have probably their own service

    public void saveGemstoneBlueprint(GemstoneBlueprint newGemstoneBlueprint){
        if(gemStoneBlueprintRepository.containsBlueprint(newGemstoneBlueprint)){
            throw new RuntimeException("Gemstone blueprint already exists");
        }
        gemStoneBlueprintRepository.save(newGemstoneBlueprint);
    }

    public List<GemstoneBlueprint> findAllGemstoneBlueprints() {
        return gemStoneBlueprintRepository.findAll();
    }

    public GemstoneBlueprint findGemstoneBlueprint(UUID id) {
        return gemStoneBlueprintRepository.find(id);
    }

    public double calculateGemstonePrice(int weight, boolean polished, double unitPrice) {
        return 0;
    }

    private Gemstone convert(TreasureBlueprint treasureBlueprint, GemstoneDto gemstoneDto) {
        Gemstone gemstone = new Gemstone();
        gemstone.setTreasureBlueprint(treasureBlueprint);
        gemstone.setGemstoneBlueprint(findGemstoneBlueprint(gemstoneDto.getBlueprintId()));
        gemstone.setCount(gemstoneDto.getStoneCount());
        gemstone.setWeight(gemstoneDto.getStoneWeight());
        gemstone.setPolished(gemstoneDto.isStonePolished());
        gemstone.setId(gemstoneDto.getId());
        gemstone.setPrice(
                calculateGemstonePrice(
                        gemstoneDto.getStoneWeight(),
                        gemstoneDto.isStonePolished(),
                        gemstone.getGemstoneBlueprint().getUnitPrice()
                )
        );
        return gemstone;
    }

    private GemstoneDto convert(Gemstone gemstone) {
        GemstoneBlueprint gemstoneBlueprint = gemstone.getGemstoneBlueprint();
        GemstoneDto gemstoneDto = new GemstoneDto();
        gemstoneDto.setStone(gemstoneBlueprint.getName());
        gemstoneDto.setStoneColor(gemstoneBlueprint.getColor());
        gemstoneDto.setStoneWeight(gemstone.getWeight());
        gemstoneDto.setStoneCount(gemstone.getCount());
        gemstoneDto.setStonePolished(gemstone.getPolished());
        gemstoneDto.setBlueprintId(gemstoneBlueprint.getId());
        gemstoneDto.setId(gemstone.getId());
        return gemstoneDto;
    }
}

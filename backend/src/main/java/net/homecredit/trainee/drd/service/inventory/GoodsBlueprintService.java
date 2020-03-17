package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.controller.inventory.GoodsBlueprintDto;
import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;
import net.homecredit.trainee.drd.repository.inventory.GoodsBlueprintRepository;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GoodsBlueprintService {

    private final GoodsBlueprintRepository goodsBlueprintRepository;
    private final ModelMapper modelMapper;
    private final ShopService shopService;

    public GoodsBlueprintService(GoodsBlueprintRepository goodsBlueprintRepository, ModelMapper modelMapper, ShopService shopService) {
        this.goodsBlueprintRepository = goodsBlueprintRepository;
        this.modelMapper = modelMapper;
        this.shopService = shopService;
    }

    public GoodsBlueprint findById(UUID id) {
        return goodsBlueprintRepository.findById(id);
    }

    public void deleteAll() {
        goodsBlueprintRepository.deleteAll();
    }

    public List<GoodsBlueprintDto> findAll() {
        List<GoodsBlueprintDto> goodsBlueprintDtoList = new ArrayList<>();
        goodsBlueprintRepository.findAll().forEach(goodsBlueprint -> goodsBlueprintDtoList.add(convert(goodsBlueprint)));
        return goodsBlueprintDtoList;
    }

    public void save(GoodsBlueprintDto newGoodsBlueprint) {
        GoodsBlueprint goodsBlueprint = convert(newGoodsBlueprint);
        if(goodsBlueprintRepository.containsBlueprint(goodsBlueprint)){
            throw new RuntimeException("Goods blueprint already exists");
        }
        goodsBlueprintRepository.save(goodsBlueprint);
        shopService.createPriceTag(goodsBlueprint, goodsBlueprint.getItemType());
        goodsBlueprintRepository.save(goodsBlueprint);
    }

    public void update(GoodsBlueprintDto existingGoodsBlueprint) {
        goodsBlueprintRepository.update(convert(existingGoodsBlueprint));
    }

    public void delete(UUID id) {
        goodsBlueprintRepository.delete(id);
    }

    public GoodsBlueprint convert(GoodsBlueprintDto goodsBlueprintDto) {
        return modelMapper.map(goodsBlueprintDto, GoodsBlueprint.class);
    }

    public GoodsBlueprintDto convert(GoodsBlueprint goodsBlueprint) {
        return modelMapper.map(goodsBlueprint, GoodsBlueprintDto.class);
    }
}

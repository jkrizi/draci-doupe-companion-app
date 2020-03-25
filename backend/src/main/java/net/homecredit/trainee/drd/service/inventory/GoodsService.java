package net.homecredit.trainee.drd.service.inventory;

import net.homecredit.trainee.drd.entity.inventory.goods.GoodsBlueprint;
import net.homecredit.trainee.drd.entity.inventory.Equipment;
import net.homecredit.trainee.drd.repository.inventory.EquipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsService {

    private EquipmentRepository equipmentRepository;

    public GoodsService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment forgeGoods(GoodsBlueprint goodsBlueprint) {
        Equipment goods = new Equipment(goodsBlueprint, goodsBlueprint.getItemType());
        equipmentRepository.save(goods);
        return goods;
    }

    public void deleteAll() {
        equipmentRepository.deleteAll();
    }

    public void deleteAllGoods() {
        equipmentRepository.deleteAllGoods();
    }
}

package net.homecredit.trainee.drd.configuration;

import net.homecredit.trainee.drd.repository.blueprint.ArmorBlueprintRepository;
import net.homecredit.trainee.drd.repository.blueprint.GoodsBlueprintRepository;
import net.homecredit.trainee.drd.repository.blueprint.TreasureBlueprintRepository;
import net.homecredit.trainee.drd.repository.blueprint.WeaponBlueprintRepository;
import net.homecredit.trainee.drd.repository.inventory.*;
import net.homecredit.trainee.drd.repository.shop.ShopRepository;
import net.homecredit.trainee.drd.service.blueprint.*;
import net.homecredit.trainee.drd.service.item.*;
import net.homecredit.trainee.drd.service.shop.BuyService;
import net.homecredit.trainee.drd.service.shop.ShopService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class ItemModuleConfiguration {
    @Bean
    public InventoryRepository inventoryRepository(EntityManager em) {
        return new InventoryRepository(em);
    }

    @Bean
    public StorageRepository storageRepository(EntityManager em) {
        return new StorageRepository(em);
    }

}


package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.inventory.GemStone;

import java.util.Comparator;

public class GemStoneComparator implements Comparator<GemStone> {

    @Override
    public int compare(GemStone o1, GemStone o2) {
        boolean stoneWeightCompare = o1.getStoneWeight() == o2.getStoneWeight();
        boolean stonePriceCompare = o1.getStonePrice() == o2.getStonePrice();
        boolean gemStoneBlueprintCompare = o1.getGemStoneBlueprint().getId().equals(o2.getGemStoneBlueprint().getId());
        boolean stonesAreSamePolished = (o1.isPolished() == o2.isPolished());

        if(stoneWeightCompare &&
                stonePriceCompare &&
                gemStoneBlueprintCompare &&
                stonesAreSamePolished
        ){
            return 0;
        }else if(o1.getStoneWeight() > o2.getStoneWeight()){
            return 1;
        }else if(o1.getStoneWeight() < o2.getStoneWeight()){
            return -1;
        }else if(o1.getStonePrice() > o2.getStonePrice()){
            return 1;
        }else if(o1.getStonePrice() < o2.getStonePrice()){
            return -1;
        }else if(o1.isPolished() != o2.isPolished() && o1.isPolished()){
            return -1;
        }else if(o1.isPolished() != o2.isPolished() && o2.isPolished()){
            return 1;
        }
        return -1;
    }
}
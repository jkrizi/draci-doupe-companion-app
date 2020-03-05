package net.homecredit.trainee.drd.util.comparator;

import net.homecredit.trainee.drd.entity.inventory.Gemstone;

import java.util.Comparator;

public class GemStoneComparator implements Comparator<Gemstone> {

    @Override
    public int compare(Gemstone o1, Gemstone o2) {
        boolean stoneWeightCompare = o1.getWeight() == o2.getWeight();
        boolean stonePriceCompare = o1.getPrice() == o2.getPrice();
        boolean gemStoneBlueprintCompare = o1.getGemstoneBlueprint().getId().equals(o2.getGemstoneBlueprint().getId());
        boolean stonesAreSamePolished = (o1.getPolished() == o2.getPolished());

        if(stoneWeightCompare &&
                stonePriceCompare &&
                gemStoneBlueprintCompare &&
                stonesAreSamePolished
        ){
            return 0;
        }else if(o1.getWeight() > o2.getWeight()){
            return 1;
        }else if(o1.getWeight() < o2.getWeight()){
            return -1;
        }else if(o1.getPrice() > o2.getPrice()){
            return 1;
        }else if(o1.getPrice() < o2.getPrice()){
            return -1;
        }else if(o1.getPolished() != o2.getPolished() && o1.getPolished()){
            return -1;
        }else if(o1.getPolished() != o2.getPolished() && o2.getPolished()){
            return 1;
        }
        return -1;
    }
}

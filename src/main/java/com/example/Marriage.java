package com.example;

import java.util.HashMap;
import java.util.Map;

public class Marriage {

    private static final int potentialRadius = 30;

    public synchronized static void findClosestPartnerAndMarry(Fish fish){
        HashMap<Integer, Fish> fishList = Aquarium.fishList;

        Fish anotherGenderFish;

        String necessaryGender = ((fish.getGender()).equals("MALE")) ? "FEMALE" : "MALE";

        Fish theClosestFish = null;

        int distanceTillTheClosestFish = potentialRadius;

        if(!(Random.maleIds.isEmpty() || Random.femaleIds.isEmpty())) {//if one of them is empty, it will finish marrying

            for (Map.Entry<Integer, Fish> entry : fishList.entrySet()) {

                anotherGenderFish = entry.getValue();//iterating through hashMap of fish threads

                if (anotherGenderFish == fish) {
                    //if it is the same fish, it will ignore
                    //it and continue to other value
                    continue;
                }
                int distanceBetweenTwoFish = Math.abs(fish.getxPosition() - anotherGenderFish.getxPosition());
                //it will get difference between x positions of two fish

                if (distanceBetweenTwoFish <= potentialRadius
                        && anotherGenderFish.getGender().equals(necessaryGender)) {
                    // if it is inside of given radius and if it is another gender

                    System.out.println
                            ("Distance between " + fish.getFishId() + " and " + anotherGenderFish.getFishId() + " is " + distanceBetweenTwoFish );

                    if (distanceBetweenTwoFish <= distanceTillTheClosestFish) {
                        // if clause is for getting fish with minimum potential radius
                        distanceTillTheClosestFish = distanceBetweenTwoFish;
                        theClosestFish = anotherGenderFish;
                        System.out.println("Another close fish " + theClosestFish.getFishId() + " at " + theClosestFish.getxPosition());
                    }
                }
            }
            if (theClosestFish == null) { // if there is no any fish near to him/her
                System.out.println("There is no close fish to fish " + fish.getFishId());
            } else {
                if(fishList.containsKey(theClosestFish.getFishId()) && fishList.containsKey(fish.getFishId())) {
                    // this clause, which will create new fish between the fish closest to given
                    fishList.remove(theClosestFish.getFishId());
                    fishList.remove(fish.getFishId());
                    //remove from fish list, because both of them already married
                    marryToTheClosestFish(
                            theClosestFish, fish
                    );
                }
            }
        }
    }
    private static void marryToTheClosestFish(Fish theClosestFish, Fish fish){
        System.out.println("The closest fish " + theClosestFish.getFishId() + " with fish " + fish.getFishId());
        Fish childFish = new Fish();
        childFish.start();
    }


}

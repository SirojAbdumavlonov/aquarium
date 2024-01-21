package com.example;

import java.util.*;

public class Aquarium {

    static HashMap<Integer, Fish> fishList = new HashMap<>();
    // hashMap saves id as key and object as Fish class
    static int countOfFish = Random.getRandomNumber(0, 10);
    // will get random number between 0 and 10

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Total = " + countOfFish);

        Fish fish;

        for (int i = 0; i < countOfFish; i++) { // creating threads

            fish = new Fish();

            fishList.put(fish.getFishId(), fish);// adding to hashMap

            fish.start();// starting the thread
        }

        for (Map.Entry<Integer, Fish> entry : fishList.entrySet()) {
            entry.getValue().printFishDetails();// printing every detail of running thread
            // or alive fish
        }

        int femaleCount = Random.getLengthOfFemaleIds();//quantity of female fish
        int maleCount = Random.getLengthOfMaleIds();// quantity of male fish

        System.out.println("Female count = " + femaleCount);
        System.out.println("Male count = " + maleCount);

        if (femaleCount == countOfFish || maleCount == countOfFish) {
            // if there is only male or female, it will finish or exit from marrying
            // and finish the process
            System.exit(0);
        }
        System.out.println("Totally there were " + (Fish.counter - 1));
    }
}
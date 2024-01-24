package com.example;

import java.util.*;

public class Random {
    private static final java.util.Random random = new java.util.Random();
    public static int maleIds = 0;
    // male threads(fish) with their id as key and id as object
    public static int femaleIds = 0;
    // female threads(fish) with their id as key and id as object

    public static String getGender(){ // get random gender
        List<String> genders = Arrays.asList("MALE", "FEMALE");

        return genders.get(random.nextInt(genders.size()));
    }

    public static int getRandomNumber(int minNumber, int maxNumber){ // get random number between minNumber and maxNumber
        return random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }
    public static long getRandomDurationOfFishLife(){ // get default duration between 1 and 10 seconds
        long minDuration = 1_000L;
        long maxDuration = 10_000L;

        return random.nextLong(maxDuration - minDuration + 1) + minDuration;
    }

    public static int getRandomXPosition(){
        int minXPosition = 0;
        int maxXPosition = 200;

        return random.nextInt(maxXPosition - minXPosition + 1) + minXPosition;
    }
    public synchronized static void addToRandom(String gender, int id){
//        // while getting gender, it will add to list of male or female thread
        if (gender.equals("MALE")){
            maleIds++;
        }
        else {
            femaleIds++;
        }
    }

    public static int getLengthOfMaleIds(){
        return maleIds;
    }
    public static int getLengthOfFemaleIds(){
        return femaleIds;
    }
}

package com.example;

import java.util.*;

public class Random {
    private static final java.util.Random random = new java.util.Random();
    public static final HashMap<Integer, Integer> maleIds = new HashMap<>();
    // male threads(fish) with their id as key and id as object
    public static final HashMap<Integer, Integer> femaleIds = new HashMap<>();
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
        // while getting gender, it will add to list of male or female thread
        if (gender.equals("MALE")){
            maleIds.put(id, id);
        }
        else {
            femaleIds.put(id, id);
        }
    }

    public synchronized static void removeFromRandom(String gender, int id){

        if (gender.equals("MALE")){
            maleIds.remove(id);
        }
        else {
            femaleIds.remove(id);
        }
    }
    public static int getLengthOfMaleIds(){
        return maleIds.size();
    }
    public static int getLengthOfFemaleIds(){
        return femaleIds.size();
    }
}

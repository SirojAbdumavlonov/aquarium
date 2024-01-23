package com.example;


import static com.example.Aquarium.fishList;

public class Fish extends Thread {

    public static int counter = 1;
    private volatile int xPosition;
    private volatile String gender;
    private volatile Long duration;
    private volatile int id;
    public Fish(){
        this.gender = Random.getGender();
        this.duration = Random.getRandomDurationOfFishLife();
        this.id = counter++;
        this.xPosition = Random.getRandomXPosition();

    }
    public static int getTotalCount(){
        return counter;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }


    public int getFishId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public void printFishDetails(){
        System.out.println("Gender = " + gender + ", id = " + id + ", life expectancy = " + duration + " in ms, x position = " + xPosition);
    }

    @Override
    public void run(){

        Random.addToRandom(gender, getFishId());

        System.out.println("Fish with " + getFishId() + " id is swimming ...");


        try{
            Marriage.findClosestPartnerAndMarry(this);

            Thread.sleep(duration);

            Random.removeFromRandom(gender, getFishId());//remove fish from randomizer

            fishList.remove(getFishId());//remove dead fish from aquarium

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt(); // Preserve the interrupt status
            return;
        }
        System.out.println(gender + " with " + getFishId() + " fish has died😓... ");
    }
}

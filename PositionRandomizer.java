package com.mycompany.testforfp;

import java.util.Random;

public class PositionRandomizer {
    private Random random = new Random();
    
    private int[] xCoords;
    private int[] yCoords;
    
    public PositionRandomizer(int count){
        xCoords = new int[count];
        yCoords = new int[count];
    }
    
    public int[] randomX(int range){
        for (int i = 0; i < this.xCoords.length; i++){
            this.xCoords[i] = random.nextInt(range);
        }
        return this.xCoords;
    }
    
    public int[] randomY(int range){
        for (int i = 0; i < this.yCoords.length; i++){
            this.yCoords[i] = random.nextInt(range);
        }
        return this.yCoords;
    }
}

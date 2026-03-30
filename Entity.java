package com.mycompany.testforfp;

public class Entity {
    private int x = 0, y = 0;
    
    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}

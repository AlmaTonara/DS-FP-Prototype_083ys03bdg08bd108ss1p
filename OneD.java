package com.mycompany.testforfp;

import java.util.LinkedList;
import java.util.Iterator;

public class OneD {
    private LinkedList<Entity> list = new LinkedList<>();
    private int width;
    private int height;
    private int entityCount;
    
    public OneD(int width, int height){
        this.width = width;
        this.height = height;
        this.entityCount = 0;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getCount(){
        return this.entityCount;
    }
    
    private boolean isValid(int x, int y){
        if (x >= 0 && y >= 0 && x < this.width && y < this.height){
            return true;
        }
        return false;
    }
    
    public boolean isOccupied(int x, int y){
        if (this.isValid(x, y)){
            for (Entity element : this.list){
                if (element.getX() == x && element.getY() == y){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean add(Entity entity){
        int x = entity.getX();
        int y = entity.getY();
        
        if (!this.isValid(x, y) || this.isOccupied(x, y)){
            return false;
        }

        list.add(entity);
        this.entityCount++;
        return true;
    }
    
    public Entity get(int x, int y){
        if (this.isValid(x, y)){
            for (Entity element : this.list){
                if (element.getX() == x && element.getY() == y){
                    return element;
                }
            }
        }
        return null;
    }
    
    public boolean remove(int x, int y){
        Iterator<Entity> it = list.iterator();
        while (it.hasNext()){
            Entity element = it.next();
            if (element.getX() == x && element.getY() == y){
                it.remove();
                entityCount--;
                return true;
            }
        }
        return false;
    }
    
    public boolean move(int oldX, int oldY, int newX, int newY){
        if (!this.isValid(oldX, oldY) || !this.isValid(newX, newY)){
            return false;
        }
        
        if (this.isOccupied(newX, newY)) {
            return false;
        }
        
        for (Entity element : this.list){
            if (element.getX() == oldX && element.getY() == oldY){
                element.setXY(newX, newY);
                return true;
            }
        }
        return false;
    }
}

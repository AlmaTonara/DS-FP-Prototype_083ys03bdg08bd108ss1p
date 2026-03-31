package com.mycompany.testforfp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// add
// remove
// get at xy
// get all between x1-x2, and y1-y2 
// update

public class HashGrid {
    private Map<Long, ArrayList<Entity>> map = new HashMap<Long, ArrayList<Entity>>();
    private int height = 1000000;
    private int width = 1000000;
    private int chunkSize = 256;
    private int entityCount = 0;
    
    public HashGrid(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int getWidth(){
        return this.width * this.chunkSize;
    }
    
    public int getHeight(){
        return this.height * this.chunkSize;
    }
    
    public int getCount(){
        return this.entityCount;
    }
    
    private long convert(long cx, long cy){
        return cx + cy * (long) this.width;
    }
    
    private boolean validate(long cx, long cy){
        if (cx >= 0 && cy >= 0 && cx < this.width && cy < this.height){
            return true;
        }
        return false;
    }
    
    public boolean add(Entity entity){
        int x = entity.getX();
        int y = entity.getY();
        
        long cx = (long) x / this.chunkSize;
        long cy = (long) y / this.chunkSize; 
        
        if (!this.validate(cx, cy)){
            return false; 
        }
        
        long key = this.convert(cx, cy);  
        
        if (!map.containsKey(key)){
            this.map.put(key, new ArrayList<Entity>());
        }
        
        this.map.get(key).add(entity);
        this.entityCount++;
        
        return true;
    }
    
    public boolean remove(int x, int y){
        long cx = (long) x / this.chunkSize;
        long cy = (long) y / this.chunkSize; 
        
        if (!this.validate(cx, cy)){
            return false; 
        }
        
        long key = this.convert(cx, cy);
        
        if (!map.containsKey(key)){
            return false;
        }
        
        ArrayList<Entity> entities = this.map.get(key);
        
        Iterator<Entity> it = entities.iterator();
        
        while (it.hasNext()){
            Entity element = it.next();
            if (element.getX() == x && element.getY() == y){
                it.remove();
                this.entityCount--;
                
                if (entities.isEmpty()){
                    map.remove(key);
                }
                
                return true;
            }
        }

        return false;
    }
    
    public ArrayList<Entity> getRange(int x1, int y1, int x2, int y2){
        ArrayList<Entity> result = new ArrayList<>();

        long cx1 = x1 / chunkSize;
        long cy1 = y1 / chunkSize;
        long cx2 = x2 / chunkSize;
        long cy2 = y2 / chunkSize;

        for (long cx = cx1; cx <= cx2; cx++){
            for (long cy = cy1; cy <= cy2; cy++){
                if (!validate(cx, cy)) continue;

                long key = convert(cx, cy);
                ArrayList<Entity> list = map.get(key);

                if (list != null){
                    result.addAll(list);
                }
            }
        }

        return result;
    }
    
    public boolean move(int oldX, int oldY, int newX, int newY){
        long oldCx = oldX / chunkSize;
        long oldCy = oldY / chunkSize;

        if (!validate(oldCx, oldCy)) return false;

        long oldKey = convert(oldCx, oldCy);

        ArrayList<Entity> oldChunk = map.get(oldKey);

        if (oldChunk == null) return false;

        Iterator<Entity> it = oldChunk.iterator();

        while (it.hasNext()){
            Entity entity = it.next();
            if (entity.getX() == oldX && entity.getY() == oldY){
                it.remove();
                this.entityCount--;

                entity.setXY(newX, newY);

                this.add(entity);

                return true;
            }
        }

        return false;
    }
}

package com.mycompany.testforfp;

public class TwoD {
    private Entity[][] grid;
    private int width;
    private int height;
    private int entityCount = 0;
    
    public TwoD(int width, int height){
        grid = new Entity[width][height];
        this.width = width;
        this.height = height;
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
        if (this.isValid(x, y) && grid[x][y] != null){
            return true;
        }
        return false;
    }
    
    public boolean add(Entity entity){
        int x = entity.getX();
        int y = entity.getY();
        
        if (!this.isValid(x, y) || this.isOccupied(x, y)){
            return false;
        }
        
        grid[x][y] = entity;
        this.entityCount++;
        return true;
    }
    
    public Entity get(int x, int y){
        if (this.isOccupied(x, y)){
            return grid[x][y];
        }
        return null;
    }
    
    public boolean remove(int x, int y){
        if (this.isOccupied(x, y)){
            grid[x][y] = null;
            this.entityCount--;
            return true;
        }
        return false;
    }
    
    public boolean move(int oldX, int oldY, int newX, int newY){
        if (!this.isValid(oldX, oldY) || !this.isValid(newX, newY)){
            return false;
        }

        if (!this.isOccupied(oldX, oldY) || this.isOccupied(newX, newY)){
            return false;
        }

        Entity movingEntity = grid[oldX][oldY];
        grid[oldX][oldY] = null;

        movingEntity.setXY(newX, newY);
        grid[newX][newY] = movingEntity;

        return true;
    }
}

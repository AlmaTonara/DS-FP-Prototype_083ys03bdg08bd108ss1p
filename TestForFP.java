package com.mycompany.testforfp;

public class TestForFP {
    public static long addTest1D(OneD list, int entity_count){
        int mapWidth = list.getWidth();
        int mapHeight = list.getHeight();
        
        PositionRandomizer randomizer = new PositionRandomizer(entity_count);
        
        int[] xCoords = randomizer.randomX(mapWidth);
        int[] yCoords = randomizer.randomY(mapHeight);
        
        long startTime = System.nanoTime();

        for (int i = 0; i < entity_count; i++){
            list.add(new Entity(xCoords[i], yCoords[i]));
        }
        
        long endTime = System.nanoTime();
        
        long durationTime = endTime - startTime;

        return durationTime;
    }
    
    public static long addTest2D(TwoD grid, int entity_count){
        int mapWidth = grid.getWidth();
        int mapHeight = grid.getHeight();
        
        PositionRandomizer randomizer = new PositionRandomizer(entity_count);
        
        int[] xCoords = randomizer.randomX(mapWidth);
        int[] yCoords = randomizer.randomY(mapHeight);
        
        long startTime = System.nanoTime();

        for (int i = 0; i < entity_count; i++){
            grid.add(new Entity(xCoords[i], yCoords[i]));
        }
        
        long endTime = System.nanoTime();
        
        long durationTime = endTime - startTime;

        return durationTime;
    }
    
    public static long getTest2D(TwoD grid, int screenHeight, int screenWidth){
        long startTime = System.nanoTime();

        for (int x = 0; x < screenWidth; x++){
            for (int y = 0; y < screenHeight; y++){
                grid.get(x, y);
            }
        }
        
        long endTime = System.nanoTime();
        
        long durationTime = endTime - startTime;

        return durationTime;
    }
    
    public static long addTestHG(HashGrid grid, int entity_count){
        int mapWidth = grid.getWidth();
        int mapHeight = grid.getHeight();
        
        PositionRandomizer randomizer = new PositionRandomizer(entity_count);
        
        int[] xCoords = randomizer.randomX(mapWidth);
        int[] yCoords = randomizer.randomY(mapHeight);
        
        long startTime = System.nanoTime();

        for (int i = 0; i < entity_count; i++){
            grid.add(new Entity(xCoords[i], yCoords[i]));
        }
        
        long endTime = System.nanoTime();
        
        long durationTime = endTime - startTime;

        return durationTime;
    }
    
    public static long getTestHG(HashGrid grid, int screenHeight, int screenWidth){
        long startTime = System.nanoTime();

        grid.getRange(0, 0, screenWidth, screenHeight);
        
        long endTime = System.nanoTime();
        
        long durationTime = endTime - startTime;

        return durationTime;
    }

    public static void main(String[] args) {
        int mapHeight = 1000;
        int mapWidth = 1000;
        
        int screenHeight = 10000;
        int screenWidth = 10000;
        
        int entity_count = 10000;
        
        for (int i = 0; i < 30; i++){
            OneD test1D = new OneD(mapHeight, mapWidth);
            addTest1D(test1D, entity_count);
        }
        
        System.out.println("1D");
        for (int i = 0; i < 10; i++){
            OneD test1D = new OneD(mapHeight, mapWidth);
            System.out.println(addTest1D(test1D, entity_count));
            System.out.println(addTest1D(test1D, 1));
            System.out.println();
        }
        
        for (int i = 0; i < 30; i++){
            TwoD test2D = new TwoD(mapHeight, mapWidth);
            addTest2D(test2D, entity_count);
            getTest2D(test2D, screenHeight, screenWidth);
        }
        
        System.out.println("2D");
        for (int i = 0; i < 10; i++){
            TwoD test2D = new TwoD(mapHeight, mapWidth);
            System.out.println(addTest2D(test2D, entity_count));
            System.out.println(addTest2D(test2D, 1));
            System.out.println(getTest2D(test2D, screenHeight, screenWidth));
            System.out.println();
        }
        
        for (int i = 0; i < 30; i++){
            HashGrid testHG = new HashGrid();
            addTestHG(testHG, entity_count);
            getTestHG(testHG, screenHeight, screenWidth);
        }
        
        System.out.println("Hash Grid");
        for (int i = 0; i < 10; i++){
            HashGrid testHG = new HashGrid();
            System.out.println(addTestHG(testHG, entity_count));
            System.out.println(addTestHG(testHG, 1));
            System.out.println(getTestHG(testHG, screenHeight, screenWidth));
            System.out.println();
        }
    }
}

package com.mycompany.testforfp;

public class TestForFP {
    public static long test1D_add(OneD grid){
        long startTime = System.nanoTime();
        grid.add(new Entity(grid.getWidth() - 1, grid.getHeight() - 1));
        return System.nanoTime() - startTime;
    }
    public static long test1D_remove(OneD grid){
        long startTime = System.nanoTime();
        grid.remove(grid.getWidth() - 1, grid.getHeight() - 1);
        return System.nanoTime() - startTime;
    }
    public static long test1D_get(OneD grid, int qW, int qH){
        long startTime = System.nanoTime();
        grid.getRange(0, 0, qW, qH);
        return System.nanoTime() - startTime;
    }
    public static long test1D_move(OneD grid){
        long startTime = System.nanoTime();
        grid.move(1, 1, grid.getWidth() - 1, grid.getHeight() - 1);
        return System.nanoTime() - startTime;
    }
    public static void test1D(int mW, int mH, int qW, int qH, int n){
        OneD grid = new OneD(mW, mH);
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++){
            if (x == mW - 1){
                x = 0;
                y++;
            }
            grid.add(new Entity(x, y));
            x++;
        }
        // Warmup
        for (int i = 0; i < 10; i++){
            test1D_add(grid);
            test1D_remove(grid);
            test1D_get(grid, qW, qH);
            test1D_move(grid);
        }
        long addT = 0;
        long remT = 0;
        long getT = 0;
        long movT = 0;
        int time = 10000;
        for (int i = 0; i < time; i++){
            addT += test1D_add(grid);
            remT += test1D_remove(grid);
            getT += test1D_get(grid, qW, qH);
            movT += test1D_move(grid);
        }
        addT /= time;
        remT /= time;
        getT /= time;
        movT /= time;
        System.out.println("1D Grid");
        System.out.println("addT = " + addT);
        System.out.println("remT = " + remT);
        System.out.println("getT = " + getT);
        System.out.println("movT = " + movT);
        System.out.println();
    }
    public static long test2D_add(TwoD grid){
        long startTime = System.nanoTime();
        grid.add(new Entity(1, 1));
        return System.nanoTime() - startTime;
    }
    public static long test2D_remove(TwoD grid){
        long startTime = System.nanoTime();
        grid.remove(1, 1);
        return System.nanoTime() - startTime;
    }
    public static long test2D_get(TwoD grid, int qW, int qH){
        long startTime = System.nanoTime();
        for (int x = 0; x < qW; x++){
            for (int y = 0; y < qH; y++){
                grid.get(x, y);
            }
        }
        return System.nanoTime() - startTime;
    }
    public static long test2D_move(TwoD grid){
        long startTime = System.nanoTime();
        grid.move(1, 1, 2, 2);
        return System.nanoTime() - startTime;
    }
    public static void test2D(int mW, int mH, int qW, int qH, int n){
        TwoD grid = new TwoD(mW, mH);
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++){
            if (x == mW - 1){
                x = 0;
                y++;
            }
            grid.add(new Entity(x, y));
            x++;
        }
        // Warmup
        for (int i = 0; i < 10; i++){
            test2D_add(grid);
            test2D_remove(grid);
            test2D_get(grid, qW, qH);
            test2D_move(grid);
        }
        long addT = 0;
        long remT = 0;
        long getT = 0;
        long movT = 0;
        int time = 100;
        for (int i = 0; i < time; i++){
            addT += test2D_add(grid);
            remT += test2D_remove(grid);
            getT += test2D_get(grid, qW, qH);
            movT += test2D_move(grid);
        }
        addT /= time;
        remT /= time;
        getT /= time;
        movT /= time;
        System.out.println("2D Grid");
        System.out.println("addT = " + addT);
        System.out.println("remT = " + remT);
        System.out.println("getT = " + getT);
        System.out.println("movT = " + movT);
        System.out.println();
    }
    public static long testHG_add(HashGrid grid){
        long startTime = System.nanoTime();
        grid.add(new Entity(1, 1));
        return System.nanoTime() - startTime;
    }
    public static long testHG_remove(HashGrid grid){
        long startTime = System.nanoTime();
        grid.remove(1, 1);
        return System.nanoTime() - startTime;
    }
    public static long testHG_get(HashGrid grid, int qW, int qH){
        long startTime = System.nanoTime();
        grid.getRange(0, 0, qW, qH);
        return System.nanoTime() - startTime;
    }
    public static long testHG_move(HashGrid grid){
        long startTime = System.nanoTime();
        grid.move(1, 1, 2, 2);
        return System.nanoTime() - startTime;
    }
    public static void testHG(int mW, int mH, int qW, int qH, int n){
        HashGrid grid = new HashGrid(mW, mH);
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++){
            if (x == mW - 1){
                x = 0;
                y++;
            }
            grid.add(new Entity(x, y));
            x++;
        }
        // Warmup
        for (int i = 0; i < 10; i++){
            testHG_add(grid);
            testHG_remove(grid);
            testHG_get(grid, qW, qH);
            testHG_move(grid);
        }
        long addT = 0;
        long remT = 0;
        long getT = 0;
        long movT = 0;
        long time = 100;
        for (int i = 0; i < time; i++){
            addT += testHG_add(grid);
            remT += testHG_remove(grid);
            getT += testHG_get(grid, qW, qH);
            movT += testHG_move(grid);
        }
        addT /= time;
        remT /= time;
        getT /= time;
        movT /= time;
        System.out.println("Hash Grid:");
        System.out.println("addT = " + addT);
        System.out.println("remT = " + remT);
        System.out.println("getT = " + getT);
        System.out.println("movT = " + movT);
        System.out.println();
    }
    
    public static void main(String[] args) {
        int mapHeight = 1000;
        int mapWidth = 1000;
        
        int screenHeight = 10000;
        int screenWidth = 10000;
        
        int entity_count = 1000;
        
        testHG(mapWidth, mapHeight, screenWidth, screenHeight, entity_count);
    }
}

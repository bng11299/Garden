
package com.gradescope.garden;
class Garden {
    private Plant[][] plots;
    private int rows;
    private int cols;

    public Garden(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        plots = new Plant[rows][cols];
    }

    public void plant(int row, int col, String plantName) {
        if (!inBounds(row, col)) {
            System.out.println("Can't plant there.");
            return;
        }

        Plant newPlant = PlantBuilder.createPlant(plantName);
        if (newPlant != null) {
            plots[row][col] = newPlant;
        }
    }
    
    
    public void growAll(int times) {
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < cols; j++) {
    			if (plots[i][j] != null) {
                    plots[i][j].grow(times);
                }
    		}
    	}
    }
    
    private boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
    
    public void growAt(int times, int row, int col) {
        if (!inBounds(row, col) || plots[row][col] == null) {
            System.out.println("Can't grow there.");
            System.out.println();
            return;
        }
        plots[row][col].grow(times);
    }
    
    public void growType(int times, String plantName) {
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Plant p = plots[i][j];
                if (p != null && p.getName().equalsIgnoreCase(plantName)) {
                    p.grow(times);
                    found = true;
                }
            }
        }
        // No error message if none found (per spec)
    }
    public void growClass(int times, String plantClass) {
        String target = plantClass.toLowerCase();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Plant p = plots[i][j];
                if (p != null && p.getType().equals(target)) {
                    p.grow(times);
                }
            }
        }
    }

    public void harvest() {// remove vegetables
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Plant p = plots[i][j];
                if (p != null && p.getType().equals("vegetable")) {
                    plots[i][j] = null;
                }
            }
        }
    }
    
    public void harvestAt(int row, int col) {
        if (!inBounds(row, col) || plots[row][col] == null || !plots[row][col].getType().equals("vegetable")) {
            System.out.println("Can't harvest there.");
            System.out.println();
            return;
        }
        plots[row][col] = null;
    }
    
    public void harvestType(String plantName) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Plant p = plots[i][j];
                if (p != null && p.getType().equals("vegetable") && p.getName().equalsIgnoreCase(plantName)) {
                    plots[i][j] = null;
                }
            }
        }
    }
    
    public void pick() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Plant p = plots[i][j];
                if (p != null && p.getType().equals("flower")) {
                    plots[i][j] = null;
                }
            }
        }
    }
    
    public void pickAt(int row, int col) {
        if (!inBounds(row, col) || plots[row][col] == null || !plots[row][col].getType().equals("flower")) {
            System.out.println("Can't pick there.");
            System.out.println();
            return;
        }
        plots[row][col] = null;
    }
    
    public void pickType(String plantName) {
    	for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Plant p = plots[i][j];
                if (p != null && p.getType().equals("flower") && p.getName().equalsIgnoreCase(plantName)) {
                    plots[i][j] = null;
                }
            }
        }
    }
    
    public void cut() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Plant p = plots[i][j];
                if (p != null && p.getType().equals("tree")) {
                    plots[i][j] = null;
                }
            }
        }
    }
    
    public void cutAt(int row, int col) {
        if (!inBounds(row, col) || plots[row][col] == null || !plots[row][col].getType().equals("tree")) {
            System.out.println("Can't cut there.");
            System.out.println();
            return;
        }
        plots[row][col] = null;
    }
    
    public void cutType(String plantName) {
    	for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Plant p = plots[i][j];
                if (p != null && p.getType().equals("tree") && p.getName().equalsIgnoreCase(plantName)) {
                    plots[i][j] = null;
                }
            }
        }
    }
    

    public void printGarden() {
        Screen screen = new Screen(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (plots[i][j] != null)
                    screen.drawPlant(i, j, plots[i][j].getGrid());
            }
        }
        screen.print();
    }
    
    public Plant getPlant(int row, int col) {
        if (inBounds(row, col)) {
            return plots[row][col];
        }
        return null;
    }
}

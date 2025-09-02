package com.gradescope.garden;
class Screen {
    private char[][] grid;
    private int rows;
    private int cols;

    public Screen(int rows, int cols) {
    	this.rows = rows;
    	this.cols = cols;
        grid = new char[rows * 5][cols * 5];
        
        for (int i = 0; i < rows * 5; i++) {
            for (int j = 0; j < cols * 5; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public void drawPlant(int plotRow, int plotCol, char[][] plantGrid) {
        int startRow = plotRow * 5;
        int startCol = plotCol * 5;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[startRow + i][startCol + j] = plantGrid[i][j];
            }
        }
    }
    
    public void print() {
        for (int i = 0; i < rows * 5; i++) {
            for (int j = 0; j < cols * 5; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

}


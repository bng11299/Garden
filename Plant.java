
package com.gradescope.garden;

public abstract class Plant {
    protected String name;
    protected char symbol;
    protected char[][] grid;

    public Plant(String name) {
        this.name = name;
        this.symbol = Character.toLowerCase(name.charAt(0));
        this.grid = new char[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                grid[i][j] = '.';
    }

    public abstract void grow(int times);

    public char[][] getGrid() {
        return grid;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract String getType();
}

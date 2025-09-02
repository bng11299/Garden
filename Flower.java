package com.gradescope.garden;

public abstract class Flower extends Plant {
	protected int radius;

    public Flower(String name) {
        super(name);
        this.radius = 0;
        grid[2][2] = symbol;  //center
    }

    public void grow(int times) {
        for (int t = 0; t < times; t++) {
            if (radius == 4) return; // max radius is 4 (fills entire 5x5)
            radius++;

            switch (radius) {
                case 1:
                    // Cross shape
                    grid[2][2] = symbol;
                    grid[1][2] = symbol;
                    grid[2][1] = symbol;
                    grid[2][3] = symbol;
                    grid[3][2] = symbol;
                    break;

                case 2:
                    // Plus-shaped ring around radius 1
                    grid[0][2] = symbol;
                    grid[2][0] = symbol;
                    grid[4][2] = symbol;
                    grid[2][4] = symbol;

                    grid[1][1] = symbol;
                    grid[1][3] = symbol;
                    grid[3][1] = symbol;
                    grid[3][3] = symbol;
                    break;

                case 3:
                    // Corners and edges (excluding outermost ring)
                    for (int r = 0; r < 5; r++) {
                        for (int c = 0; c < 5; c++) {
                            if ((r == 0 || r == 4 || c == 0 || c == 4) && !(r == 0 && c == 0) && !(r == 0 && c == 4) && !(r == 4 && c == 0) && !(r == 4 && c == 4)) {
                                grid[r][c] = symbol;
                            }
                        }
                    }
                    break;

                case 4:
                    // Fill entire 5x5
                    for (int r = 0; r < 5; r++) {
                        for (int c = 0; c < 5; c++) {
                            grid[r][c] = symbol;
                        }
                    }
                    break;
            }
        }
    }



    public String getType() {
        return "flower";
    }
}

class Iris extends Flower {
	public Iris() {
		super("iris");
	}
}

class Lily extends Flower {
	public Lily() {
		super("lily");
	}
}

class Rose extends Flower {
	public Rose() {
		super("rose");
	}
}

class Daisy extends Flower {
	public Daisy() {
		super("daisy");
	}
}

class Tulip extends Flower {
	public Tulip() {
		super("tulip");
	}
}

class Sunflower extends Flower {
	public Sunflower() {
		super("sunflower");
	}
}

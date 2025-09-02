
package com.gradescope.garden;

public abstract class Tree extends Plant {
	protected int height;
	
	public Tree(String name) {
		super(name);
		this.height = 1;
		grid[4][2] = symbol;//bottom middle
	}

	@Override
	public void grow(int times) {
		for(int i = 0; i < times; i++) {
			if (height == 5) return;
			grid[4-height][2] = symbol;//growing up
			height++;
		}

	}

	@Override
	public String getType() {
		return "tree";
	}

}

class Oak extends Tree {
    public Oak() {
        super("oak");
    }
}

class Willow extends Tree {
    public Willow() {
        super("willow");
    }
}

class Banana extends Tree {
    public Banana() {
        super("banana");
    }
}

class Coconut extends Tree {
    public Coconut() {
        super("coconut");
    }
}

class Pine extends Tree {
    public Pine() {
        super("pine");
    }
}

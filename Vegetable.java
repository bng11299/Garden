
package com.gradescope.garden;
abstract class Vegetable extends Plant {
	protected int length;
	
	public Vegetable(String name) {
		super(name);
		this.length = 1;
		grid[0][2] = symbol;//top middle
	}

	@Override
	public void grow(int times) {
		for(int i = 0; i < times; i++) {
			if(length == 5) return;//max
			grid[length][2] = symbol;
			length++;
		}

	}

	@Override
	public String getType() {
		return "vegetable";
	}

}

class Garlic extends Vegetable {
	public Garlic() {
		super("garlic");
	}
}

class Zucchini extends Vegetable {
	public Zucchini() {
		super("zucchini");
	}
}

class Tomato extends Vegetable {
	public Tomato() {
		super("tomato");
	}
}

class Yam extends Vegetable {
	public Yam() {
		super("yam");
	}
}

class Lettuce extends Vegetable {
	public Lettuce() {
		super("lettuce");
	}
}

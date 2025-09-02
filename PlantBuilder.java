
package com.gradescope.garden;
public class PlantBuilder {
    public static Plant createPlant(String name) {
        switch (name.toLowerCase()) {
        	case "iris": return new Iris();
        	case "lily": return new Lily();
            case "rose": return new Rose();
            case "daisy": return new Daisy();
            case "tulip": return new Tulip();
            case "sunflower": return new Sunflower();
            
            case "oak": return new Oak();
            case "willow": return new Willow();
            case "banana": return new Banana();
            case "coconut": return new Coconut();
            case "pine": return new Pine();
            
            case "garlic": return new Garlic();
            case "zucchini": return new Zucchini();
            case "tomato": return new Tomato();
            case "yam": return new Yam();
            case "lettuce": return new Lettuce();
            
            default:
                System.out.println("Unknown plant type: " + name);
                return null;
        }
    }
}

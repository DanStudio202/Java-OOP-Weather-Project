import java.util.Arrays;
import java.util.List;


public class Clothes {
    private List<String> items;

    public Clothes() {
        this.items = Arrays.asList(

            //AI gen list of clothes. Can modify if needed - Jason S
            "t-shirt", "long sleeve shirt", "tank top", "hoodie", "sweater",
            "jacket", "coat", "raincoat", "windbreaker",
            "jeans", "shorts", "cargo shorts", "sweatpants", "leggings",
            "dress pants", "skirt", "dress",
            "pajamas", "robe",
            "sneakers", "boots", "sandals", "flip flops", "dress shoes",
            "socks", "ankle socks", "crew socks",
            "hat", "beanie", "cap",
            "scarf", "gloves",
            "belt", "tie",
            "sunglasses",
            "underwear", "undershirt",
            "swimsuit", "swim trunks",
            "athletic wear", "gym shorts", "track jacket"
        );
    }

    //Return large list of posible items - Jason S
    public List<String> matchItems(Weather weather) {
        double temp = weather.getTemp();

        if (temp < 40) {
            return Arrays.asList("Boots", "Scarf", "Jacket", "Gloves");
        }
        if (temp > 80) {
            return Arrays.asList("Sunglasses", "Flipflops", "Shorts", "T-shirt");
        }
        else {
            return Arrays.asList("Jeans", "Sneakers", "Hoodie", "Hat");
        }


    }

    //Create specific outfit with 'slots' for shirt, pants, ect - Jason S
    //public List<String> recommendClothes(){

        //List<String> recClothes;
        //return recClothes;
    //}
}

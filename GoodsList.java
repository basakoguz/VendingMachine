import java.util.*;
import java.util.concurrent.TimeUnit;

public class GoodsList {
  HashSet<ColdDrink> coldDrinksList = new HashSet<ColdDrink>();
  HashSet<HotDrink> hotDrinksList = new HashSet<HotDrink>();
  HashSet<JunkFood> junkFoodsList = new HashSet<JunkFood>();

  public GoodsList(){}

  public void addColdDrinkListItem(ColdDrink newColdDrink) {
    this.coldDrinksList.add(newColdDrink);
    System.out.println();
    System.out.println("Cold drink " + newColdDrink.name + " " + newColdDrink.type + " added.");
  }

  public void addHotDrinkListItem(HotDrink newHotDrink) {
    this.hotDrinksList.add(newHotDrink);
    System.out.println();
    System.out.println("Hot drink " + newHotDrink.name + " " + newHotDrink.aroma + " added.");
  }

  public void addJunkFoodListItem(JunkFood newJunkFood) {
    this.junkFoodsList.add(newJunkFood);
    System.out.println();
    System.out.println("Junk food " + newJunkFood.name + " added.");
  }
  public void addDefaultItems() {
    ColdDrink cd1 = new ColdDrink("Cola", "fizzy", 6);
    ColdDrink cd2 = new ColdDrink("Soda", "fizzy", 4);
    ColdDrink cd3 = new ColdDrink("Orange Juice", "unfizzy", 5);
    ColdDrink cd4 = new ColdDrink("Apple Juice", "unfizzy", 5);
    ColdDrink cd5 = new ColdDrink("Water", "unfizzy", 3);
    addColdDrinkListItem(cd1);
    addColdDrinkListItem(cd2);
    addColdDrinkListItem(cd3);
    addColdDrinkListItem(cd4);
    addColdDrinkListItem(cd5);
    HotDrink hd1 = new HotDrink("Coffee", "Colombia", 8);
    HotDrink hd2 = new HotDrink("Coffee", "Turkish", 7);
    HotDrink hd3 = new HotDrink("Coffee", "Brazil", 7);
    HotDrink hd4 = new HotDrink("Tea", "Green", 4);
    HotDrink hd5 = new HotDrink("Tea", "Black", 4);
    addHotDrinkListItem(hd1);
    addHotDrinkListItem(hd2);
    addHotDrinkListItem(hd3);
    addHotDrinkListItem(hd4);
    addHotDrinkListItem(hd5);
    JunkFood jf1 = new JunkFood("Potato Chips", 100, 6);
    JunkFood jf2 = new JunkFood("Potato Chips", 150, 8);
    JunkFood jf3 = new JunkFood("Corn Chips", 90, 7);
    JunkFood jf4 = new JunkFood("Pop Corn", 200, 10);
    JunkFood jf5 = new JunkFood("Chocolate", 120, 4);
    addJunkFoodListItem(jf1);
    addJunkFoodListItem(jf2);
    addJunkFoodListItem(jf3);
    addJunkFoodListItem(jf4);
    addJunkFoodListItem(jf5);
    System.out.println();
    System.out.println("Default inventory added successfully!");
    System.out.println();
    try {
        TimeUnit.SECONDS.sleep(2);
    } catch(Exception e) {}
  }
}

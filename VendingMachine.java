import java.util.*;
import java.util.concurrent.TimeUnit;

public class VendingMachine {

    GoodsList inventory = new GoodsList();

    public VendingMachine(){}

    public static void main(String[] args) {
        VendingMachine vendingMachine1 = new VendingMachine();
        Scanner scan = new Scanner(System.in);
        int balance = 0;
        boolean exit = false;
        while(!exit) {
            System.out.println();
            System.out.println("---------------");
            System.out.println("Vending Machine");
            System.out.println("---------------");
            System.out.println();
            System.out.println("---Main Menu---");
            System.out.println();
            System.out.println("1. Vending Machine");
            System.out.println("2. Inventory Management");
            System.out.println("0. EXIT");
            System.out.println();
            System.out.print("Choice: ");
            String choiceMain = scan.next();
            System.out.println();
            if(choiceMain.equals("1")) { //VENDING MACHINE EXERCISE
                boolean back = false;
                while(!back) {
                    String choiceExit = "";
                    System.out.println();
                    System.out.println("---------------");
                    System.out.println("Vending Machine");
                    System.out.println("---------------");
                    System.out.println();
                    System.out.println("----Welcome----");
                    System.out.println();
                    System.out.println("Press B for back.");
                    System.out.println();
                    System.out.print("Insert Money: ");
                    try {
                        balance = scan.nextInt();
                    }
                    catch(Exception e) {
                        choiceExit = scan.nextLine();
                    }
                    if(choiceExit.equalsIgnoreCase("b")) {
                        break;
                    }
                    if(balance>0 && balance<=50) {
                        boolean back2 = false;
                        while(!back2) {
                          System.out.println();
                            System.out.println("---------------");
                            System.out.println("Vending Machine");
                            System.out.println("---------------");
                            System.out.println();
                            System.out.println("------Menu-----");
                            System.out.println();
                            System.out.println("1. Cold Drinks");
                            System.out.println("2. Hot Drinks");
                            System.out.println("3. Junk Foods");
                            System.out.println("0. Give change");
                            System.out.println();
                            System.out.println("<Credit: " + balance + " TL>");
                            System.out.println();
                            System.out.print("Choice: ");
                            int choiceVending = scan.nextInt();
                            System.out.println();
                            if(choiceVending==1) {
                                boolean back4 = false;
                                while(!back4) {
                                    int i = 1;
                                    System.out.println("---------------");
                                    System.out.println("Vending Machine");
                                    System.out.println("---------------");
                                    System.out.println();
                                    System.out.println("--Cold Drinks--");
                                    System.out.println();
                                    if(vendingMachine1.inventory.coldDrinksList.isEmpty()) {
                                      System.out.println("     EMPTY    ");
                                      System.out.println();
                                    }
                                    for(ColdDrink c : vendingMachine1.inventory.coldDrinksList) {
                                        if (c.availability==true) {
                                            System.out.println(i + ":" + c.name + " " + c.type + " " + "Price: " + c.price + " TL" );
                                            i++;
                                        } else {
                                            System.out.println(i + ":" + c.name + " " + c.type + " " + "Price: <N/A>" );
                                            i++;
                                        }
                                    }
                                    System.out.println("0. Back");
                                    System.out.println();
                                    System.out.println("<Credit: " + balance + " TL>");
                                    System.out.println();
                                    System.out.print("Choice: ");
                                    int choiceColdDrink = scan.nextInt();
                                    System.out.println();
                                    if(choiceColdDrink==0) {
                                        break;
                                    } else if(choiceColdDrink>vendingMachine1.inventory.coldDrinksList.size()) {
                                        System.out.println("Please enter a valid choice.");
                                        System.out.println();
                                        try {
                                            TimeUnit.SECONDS.sleep(1);
                                        } catch(Exception e) {}
                                    }
                                    int count = 1;
                                    for(ColdDrink c : vendingMachine1.inventory.coldDrinksList) {
                                        if(count > choiceColdDrink) {
                                            break;
                                        } else if(count == choiceColdDrink) {
                                            if(balance < c.price) {
                                                System.out.println("Insufficient money! <Credit: " + balance + " TL>");
                                                try {
                                                    TimeUnit.SECONDS.sleep(1);
                                                } catch(Exception e) {}
                                                break;
                                            } else {
                                                if(c.availability==true) {
                                                    System.out.println("Enjoy your cold drink!");
                                                    c.availability = false;
                                                    balance = balance - c.price;
                                                    try {
                                                        TimeUnit.SECONDS.sleep(1);
                                                    } catch(Exception e) {}
                                                    break;
                                                } else {
                                                    System.out.println("Cold drink is not available!");
                                                    try {
                                                        TimeUnit.SECONDS.sleep(1);
                                                    } catch(Exception e) {}
                                                    break;
                                                }
                                            }
                                        } else {
                                          count++;
                                        }
                                    }
                                }
                            }
                            if(choiceVending==2) {
                                  boolean back5 = false;
                                  while(!back5) {
                                      int i = 1;
                                      System.out.println("---------------");
                                      System.out.println("Vending Machine");
                                      System.out.println("---------------");
                                      System.out.println();
                                      System.out.println("---Hot Drinks--");
                                      System.out.println();
                                      if(vendingMachine1.inventory.hotDrinksList.isEmpty()) {
                                        System.out.println("     EMPTY    ");
                                        System.out.println();
                                      }
                                      for(HotDrink h : vendingMachine1.inventory.hotDrinksList) {
                                          if(h.availability==true) {
                                              System.out.println(i + ":" + h.name + " " + h.aroma + " "+ "Price: " + h.price + " TL" );
                                              i++;
                                          } else {
                                              System.out.println(i + ":" + h.name + " " + h.aroma + " "+ "Price: <N/A>" );
                                              i++;
                                          }
                                      }
                                      System.out.println("0. Back");
                                      System.out.println();
                                      System.out.println("<Credit: " + balance + " TL>");
                                      System.out.println();
                                      System.out.print("Choice: ");
                                      int choiceHotDrink = scan.nextInt();
                                      System.out.println();
                                      if(choiceHotDrink==0) {
                                          break;
                                      } else if(choiceHotDrink>vendingMachine1.inventory.hotDrinksList.size()) {
                                          System.out.println("Please enter a valid choice.");
                                          System.out.println();
                                          try {
                                              TimeUnit.SECONDS.sleep(1);
                                          } catch(Exception e) {}
                                      }
                                      int count = 1;
                                      for(HotDrink h : vendingMachine1.inventory.hotDrinksList) {
                                          if(count > choiceHotDrink) {
                                              break;
                                          } else if(count == choiceHotDrink) {
                                              if(balance < h.price) {
                                                  System.out.println("Insufficient money! <Credit: " + balance + " TL>");
                                                  try {
                                                      TimeUnit.SECONDS.sleep(1);
                                                  } catch(Exception e) {}
                                                  break;
                                              } else {
                                                  if(h.availability==true) {
                                                      System.out.println("Enjoy your hot drink!");
                                                      h.availability = false;
                                                      balance = balance - h.price;
                                                      try {
                                                          TimeUnit.SECONDS.sleep(1);
                                                      } catch(Exception e) {}
                                                      break;
                                                  } else {
                                                      System.out.println("Hot drink is not available!");
                                                      try {
                                                          TimeUnit.SECONDS.sleep(1);
                                                      } catch(Exception e) {}
                                                      break;
                                                  }
                                                }
                                          } else {
                                            count++;
                                          }
                                      }
                                  }
                            }
                            if(choiceVending==3) {
                                  boolean back6 = false;
                                  while(!back6) {
                                      int i = 1;
                                      System.out.println("---------------");
                                      System.out.println("Vending Machine");
                                      System.out.println("---------------");
                                      System.out.println();
                                      System.out.println("---Junk Foods--");
                                      System.out.println();
                                      if(vendingMachine1.inventory.junkFoodsList.isEmpty()) {
                                        System.out.println("     EMPTY    ");
                                        System.out.println();
                                      }
                                      for(JunkFood j : vendingMachine1.inventory.junkFoodsList) {
                                          if(j.availability==true) {
                                              System.out.println(i + ":" + j.name + " " + j.calories + " " + "Price: " + j.price + " TL" );
                                              i++;
                                          } else {
                                              System.out.println(i + ":" + j.name + " " + j.calories + " " + "Price: <N/A>" );
                                              i++;
                                          }
                                      }
                                      System.out.println("0. Back");
                                      System.out.println();
                                      System.out.println("<Credit: " + balance + " TL>");
                                      System.out.println();
                                      System.out.print("Choice: ");
                                      int choiceJunkFood= scan.nextInt();
                                      System.out.println();
                                      if(choiceJunkFood==0) {
                                          break;
                                      } else if(choiceJunkFood>vendingMachine1.inventory.junkFoodsList.size()) {
                                          System.out.println("Please enter a valid choice.");
                                          System.out.println();
                                          try {
                                              TimeUnit.SECONDS.sleep(1);
                                          } catch(Exception e) {}
                                      }
                                      int count = 1;
                                      for(JunkFood j : vendingMachine1.inventory.junkFoodsList) {
                                          if(count > choiceJunkFood) {
                                              break;
                                          } else if(count == choiceJunkFood) {
                                              if(balance < j.price) {
                                                  System.out.println("Insufficient money! <Credit: " + balance + " TL>");
                                                  try {
                                                      TimeUnit.SECONDS.sleep(1);
                                                  } catch(Exception e) {}
                                                  break;
                                              } else {
                                                  if(j.availability==true) {
                                                      System.out.println("Enjoy your junk food!");
                                                      j.availability = false;
                                                      balance = balance - j.price;
                                                      try {
                                                          TimeUnit.SECONDS.sleep(1);
                                                      } catch(Exception e) {}
                                                      break;
                                                  } else {
                                                      System.out.println("Junk food is not available!");
                                                      try {
                                                          TimeUnit.SECONDS.sleep(1);
                                                      } catch(Exception e) {}
                                                      break;
                                                  }
                                                }
                                          } else {
                                            count++;
                                          }
                                  }
                              }
                            } else if(choiceVending==0) {
                                int count5 = 0;
                                int count2 = 0;
                                int count1 = 0;
                                while(balance>=5){
                                    balance = balance - 5;
                                    count5++;
                                }
                                while(balance>=2){
                                    balance = balance - 2;
                                    count2++;
                                }
                                while(balance>=1){
                                    balance = balance - 1;
                                    count1++;
                                }
                                System.out.println("---------------");
                                System.out.println("Vending Machine");
                                System.out.println("---------------");
                                System.out.println();
                                System.out.println("-----Change----");
                                System.out.println();
                                System.out.println(" " + count5 + " x 5 TL");
                                System.out.println(" " + count2 + " x 2 TL");
                                System.out.println(" " + count1 + " x 1 TL");
                                System.out.println();
                                System.out.println("Please take your change.");
                                System.out.println();
                                System.out.println("Goodbye!");
                                try {
                                    TimeUnit.SECONDS.sleep(3);
                                } catch(Exception e) {}
                                back2 = true;
                            }
                        }
                    } else {
                        System.out.println();
                        System.out.println("Please insert up to 50 TL");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch(Exception e) {}
                    }
                }
            }
            else if(choiceMain.equals("2")) { //ADDITIONAL FUNCTIONALITY FOR INVENTORY MANAGEMENT
                int password = 0;
                System.out.println("Press B for back.");
                System.out.println();
                System.out.print("Password: ");
                try {
                    password = scan.nextInt();
                } catch(Exception e) {
                    scan.nextLine();
                    System.out.println();
                    System.out.println("Wrong password!");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch(Exception e2) {}
                }
                if(password==12345) {
                      boolean back3 = false;
                      while(!back3) {
                          System.out.println("---------------");
                          System.out.println("Vending Machine");
                          System.out.println("---------------");
                          System.out.println();
                          System.out.println("---Inventory---");
                          System.out.println();
                          System.out.println("1. List all inventory");
                          System.out.println("2. Add new hot drink");
                          System.out.println("3. Add new cold drink");
                          System.out.println("4. Add new junk food");
                          System.out.println("5. Add default inventory");
                          System.out.println("0. Main Menu");
                          System.out.println();
                          System.out.print("Choice: ");
                          String choiceInventory = scan.next();
                          System.out.println();
                          if(choiceInventory.equalsIgnoreCase("1")) {
                              int i = 1;
                              System.out.println("---------------");
                              System.out.println("Vending Machine");
                              System.out.println("---------------");
                              System.out.println();
                              System.out.println("---Hot Drinks--");
                              System.out.println();
                              if(vendingMachine1.inventory.hotDrinksList.isEmpty()) {
                                System.out.println("EMPTY");
                              }
                              for(HotDrink h : vendingMachine1.inventory.hotDrinksList) {
                                  System.out.println(i + ":" + h.name + " " + h.aroma + " "+ "Price:" + h.price + "TL" );
                                  i++;
                              }
                              i=1;
                              System.out.println();
                              System.out.println("--Cold Drinks--");
                              System.out.println();
                              if(vendingMachine1.inventory.coldDrinksList.isEmpty()) {
                                System.out.println("EMPTY");
                              }
                              for(ColdDrink c : vendingMachine1.inventory.coldDrinksList) {
                                  System.out.println(i + ":" + c.name + " " + c.type + " " + "Price:" + c.price + "TL" );
                                  i++;
                              }
                              i=1;
                              System.out.println();
                              System.out.println("---Junk Foods--");
                              System.out.println();
                              if(vendingMachine1.inventory.junkFoodsList.isEmpty()) {
                                System.out.println("EMPTY");
                              }
                              for(JunkFood j : vendingMachine1.inventory.junkFoodsList) {
                                  System.out.println(i + ":" + j.name + " " + j.calories + " " + "Price:" + j.price + "TL" );
                                  i++;
                              }
                              System.out.println();
                              try {
                                  TimeUnit.SECONDS.sleep(3);
                              } catch(Exception e) {}
                          }else if(choiceInventory.equalsIgnoreCase("2")) {
                              String name;
                              String aroma;
                              int price;
                              scan.nextLine();
                              System.out.println("NAME of the new hot drink: ");
                              name = scan.nextLine();
                              System.out.println("AROMA of the new hot drink: ");
                              aroma = scan.nextLine();
                              System.out.println("PRICE of the new hot drink: ");
                              price = scan.nextInt();
                              HotDrink newHotDrink = new HotDrink(name, aroma, price);
                              vendingMachine1.inventory.addHotDrinkListItem(newHotDrink);
                              System.out.println();
                          }else if(choiceInventory.equalsIgnoreCase("3")) {
                              String name;
                              String type;
                              int price;
                              scan.nextLine();
                              System.out.println("NAME of the new cold drink: ");
                              name = scan.nextLine();
                              System.out.println("TYPE of the new cold drink (fizzy/unfizzy): ");
                              type = scan.nextLine();
                              System.out.println("PRICE of the new cold drink: ");
                              price = scan.nextInt();
                              ColdDrink newColdDrink = new ColdDrink(name, type, price);
                              vendingMachine1.inventory.addColdDrinkListItem(newColdDrink);
                              System.out.println();
                          }else if(choiceInventory.equalsIgnoreCase("4")) {
                              String name;
                              int calories;
                              int price;
                              scan.nextLine();
                              System.out.println("NAME of the new junk food: ");
                              name = scan.nextLine();
                              System.out.println("CALORIES of the new junk food: ");
                              calories = scan.nextInt();
                              System.out.println("PRICE of the new junk food: ");
                              price = scan.nextInt();
                              JunkFood newJunkFood = new JunkFood(name, calories, price);
                              vendingMachine1.inventory.addJunkFoodListItem(newJunkFood);
                              System.out.println();
                          }else if(choiceInventory.equalsIgnoreCase("5")) {
                              vendingMachine1.inventory.addDefaultItems();
                          }else if(choiceInventory.equalsIgnoreCase("0")) {
                              back3 = true;
                          }else {
                              System.out.println("Please enter a valid choice.");
                              System.out.println();
                              try {
                                  TimeUnit.SECONDS.sleep(1);
                              } catch(Exception e) {}
                          }
                      }
                  } else {
                      System.out.println();
                      System.out.println("Wrong password!");
                      try {
                          TimeUnit.SECONDS.sleep(1);
                      } catch(Exception e) {}
                  }
              }
            else if(choiceMain.equals("0")) { //EXIT FROM THE PROGRAM (WHILE LOOP ENDS)
              exit = true;
            }else {
              System.out.println("Please enter a valid choice.");
              try {
                  TimeUnit.SECONDS.sleep(1);
              } catch(Exception e) {}
            }
        }
    }
}

package AbheeksRealm;

// Trader Class
// Does trading

/*
-- PUBLIC METHODS --
Trader() returns Trader - constructor
Trader.trade(int[]) returns int[] - begins trade, returns item
Trader.angryTrade() returns int[] - begins angry trade
Trader.disableTrade() - disables the trade
Trader.getTradingStatus() returns boolean - gets trading status
--------------------
*/

//// IMPORTS
import java.util.Scanner;

//// CLASS
class Trader{
  /// VARIABLES/OBJECTS
  // Vars
  private int[] inventory;
  private int invIteration;
  private boolean trading;
  private boolean firstTime;
  private boolean inTrade;
  private String inputItem, tradeItem;
  private String[] resourceTypes;
  private static Scanner sc = new Scanner(System.in);

  /// METHODS
  // Constructor
  public Trader(){
    trading = true;
    firstTime = true;
    invIteration = 1;
    inTrade = true;
    resourceTypes = new String[] {" T1 Wood", " T1 Water", " T1 Leaves", " T2 Scrap Metal", " T2 Electronics", " T2 Slagmud", " T3 Submarine Core", " T3 Fuel"};
  }

  // Get trading status
  public boolean getTradingStatus(){
    return trading;
  }
  
  // trade method
  public int[] trade(int[] r){
    int[] items = r;
    clear();
    // first time trading
    if (firstTime == true){
      firstTime = false;
      typewriter("\033[3m[A bald man with epic facial hair approaches you.]", 0.0125, true);
      wait(2);
      typewriter("\033[0m     \033[1mMr. White\033[0m: \"Oh hey Jacob! Funny seeing you here!\"", 0.0125, true);
      wait(2);
      typewriter("     \033[0m\033[1mMr. White\033[0m: \"Well, I was talking to Frank the other day and he mentioned that he was making a game with Alex in AP Comp Sci.\"", 0.0125, true);
      wait(2);
      typewriter("     \033[0m\033[1mMr. White\033[0m: \"I thought to myself, 'what if I was this nice man that trades with the player?'\"", 0.0125, true);
      wait(2);
      typewriter("\033[3m[You and Mr. White exchange laughs]", 0.0125, true);
      wait(2);
      typewriter("\033[0m     \033[1mMr. White\033[0m: \"Anyway...\"", 0.0125, true);
      wait(1);
    }
    // Trade dialogue
    typewriter("\033[0m     \033[1mMr. White\033[0m: \"You interested to to trade? I got some stuff, but no Diet Coke.\"", 0.0125, true);
    wait(2);
    typewriter("\033[3m[Mr. White explains how 4 Tier 1 items equals 1 Tier 2 item and how 12 Tier 2 items equal 1 Tier 3 item.]\033[0m", 0.0125, true);
    wait(2);
    if (invIteration <= 2){
      inventory = new int[] {8, 10, 3, 0, 0, 0, 0, 0};
    }
    else if (invIteration <= 5){
      inventory = new int[] {12, 15, 17, 5, 1, 2, 0, 1};
    }
    else if (invIteration <= 8){
      inventory = new int[] {29, 20, 26, 0, 0, 0, 2, 2};
    }
    else if (invIteration <= 11){
      inventory = new int[] {32, 32, 32, 3, 3, 3, 3, 3};
    }
    else{
       inventory = new int[] {40, 40, 40, 20, 20, 20, 5, 5};
    }
    invIteration++;
    // Trade loop
    inTrade = true;
    while (inTrade == true){
      print("\n\033[0m-- Mr. White's Inventory --");
      for (int i = 0; i < inventory.length; i++){
        String resourceValue = String.valueOf(inventory[i]);
        print("\u001b[0m> \u001b[32;1m{"+i+"} \u001b[33;1m"+resourceValue+" "+resourceTypes[i]);
        deciWait(0.125);
      }
      print("\n\033[0m-- Mr. J's Inventory --");
      for (int i = 0; i < items.length; i++){
        String resourceValue = String.valueOf(items[i]);
        print("\u001b[0m> \u001b[32;1m{"+i+"} \u001b[33;1m"+resourceValue+" "+resourceTypes[i]);
        deciWait(0.125);
      }
      print("\033[0m\n");
      // Give response box
      print("[Enter \"C\" for either box to cancel!]");
      print("\u001b[0m\n┌─\033[4mTrade what item?\033[0m─┐");
      print("|                  |");
      printStay("└──────────────────┘\033[F\r|         \u001b[34;1m");
      // Take response
      inputItem = sc.nextLine();
      // Give response box
      print("\u001b[0m\n┌─\033[4mFor what item?\033[0m─┐");
      print("|                |");
      printStay("└────────────────┘\033[F\r|        \u001b[34;1m");
      // Take response
      tradeItem = sc.nextLine();
      // Check for cancel
      if ((inputItem.toLowerCase()).equals("c") || (tradeItem.toLowerCase()).equals("c")){
        inTrade = false;
      }
      // Avoid attempt if cancelled
      if (inTrade == true){
        // Check for validity
        try{
          // Check if within range
          if (Integer.parseInt(inputItem) <= 7 && Integer.parseInt(inputItem) >= 0 && Integer.parseInt(tradeItem) <= 7 && Integer.parseInt(tradeItem) >= 0 && (Integer.parseInt(inputItem) != Integer.parseInt(tradeItem))){
            // Check T1 to T2
            if (Integer.parseInt(inputItem) <= 2 && Integer.parseInt(tradeItem) >= 3 && Integer.parseInt(tradeItem) <= 5 && items[Integer.parseInt(inputItem)] >= 4 && inventory[Integer.parseInt(tradeItem)] >= 1){
              items[Integer.parseInt(inputItem)] -= 4;
              items[Integer.parseInt(tradeItem)]++;
              inventory[Integer.parseInt(inputItem)] += 4;
              inventory[Integer.parseInt(tradeItem)]--;
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              print("\u001b[36mTrade successful!!\033[0m");
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              wait(3);
              clear();
            }
            // T2 to T3
            else if (Integer.parseInt(inputItem) >= 3 && Integer.parseInt(inputItem) <= 5 && Integer.parseInt(tradeItem) >= 6 && items[Integer.parseInt(inputItem)] >= 12 && inventory[Integer.parseInt(tradeItem)] >= 1){
              items[Integer.parseInt(inputItem)] -= 12;
              items[Integer.parseInt(tradeItem)]++;
              inventory[Integer.parseInt(inputItem)] += 12;
              inventory[Integer.parseInt(tradeItem)]--;
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              print("\u001b[36mTrade successful!!\033[0m");
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              wait(3);
              clear();
            }
            // Check T2 to T1
            else if (Integer.parseInt(inputItem) >= 3 && Integer.parseInt(inputItem) <= 5 && Integer.parseInt(tradeItem) <= 2 && Integer.parseInt(tradeItem) >= 0 && items[Integer.parseInt(inputItem)] >= 1 && inventory[Integer.parseInt(tradeItem)] >= 4){
              items[Integer.parseInt(inputItem)] --;
              items[Integer.parseInt(tradeItem)] += 4;
              inventory[Integer.parseInt(inputItem)] ++;
              inventory[Integer.parseInt(tradeItem)] -= 4;
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              print("\u001b[36mTrade successful!!\033[0m");
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              wait(3);
              clear();
            }
            // Check T3 
            else if (Integer.parseInt(inputItem) >= 6){
              typewriter("\033[0m\n\n\n\033[3m[You get the sense that Mr. White won't buy this off of you.]\033[0m", 0.0125, true);
              wait(2);
            }
            // Invalid trade
            else {
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              print("\u001b[31mTrade invalid!\033[0m");
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              wait(3);
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              clear();
            }
          }
          // It didn't work
          else {
            typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
            print("\u001b[31mPick valid numbers/valid trades!\033[0m");
            typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
            wait(3);
            typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
            clear();
          }
        }
        // Input wasn't an integer
        catch (Exception e){
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          print("\u001b[31mPick valid numbers!!\033[0m");
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          wait(3);
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          clear();
        }
      }
    }
    // Ended trade
    typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
    wait(2);
    clear();
    typewriter("\033[0m     Mr. White: \"Well that was an interesting trade. Seeeee ya.\"", 0.0125, true);
    wait(2);
    typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
    
    // Return items back
    sc.reset();
    return items;
  }

  // angryTrade method (doesn't need pretext)
  public int[] angryTrade(int[] r){
    int[] items = r;
    clear();
    if (firstTime == true){
      firstTime = false;
      typewriter("\033[3m[A bald man with epic facial hair walks up to you.]", 0.0125, true);
      wait(2);
      typewriter("\033[0m     Mr. White: \"J Money?\"", 0.0125, true);
      wait(2);
      typewriter("     Mr. White: \"So....I was talking to Frank the other day and he mentioned that he was making a game with Alex in AP Comp Sci.\"", 0.0125, true);
      wait(2);
      typewriter("     Mr. White: \"I thought to myself, 'what if I was this nice man that trades with the player?'\"", 0.0125, true);
      wait(2);
      typewriter("\033[3m[Mr. White laughs as you stare at him.]", 0.0125, true);
      wait(2);
      typewriter("\033[0m     Mr. White: \"Anyway...\"", 0.0125, true);
      wait(1);
    }
    typewriter("\033[0m     Mr. White: \"I can trade since I got some stuff, but I don't want any trouble.\"", 0.0125, true);
    wait(2);
    typewriter("\033[3m[Mr. White explains how 6 Tier 1 items equals 1 Tier 2 item and how 16 Tier 2 items equal 1 Tier 3 item.]\033[0m", 0.0125, true);
    wait(2);
    if (invIteration <= 2){
      inventory = new int[] {8, 10, 3, 0, 0, 0, 0, 0};
    }
    else if (invIteration <= 5){
      inventory = new int[] {12, 15, 17, 5, 1, 2, 0, 1};
    }
    else if (invIteration <= 8){
      inventory = new int[] {29, 20, 26, 0, 0, 0, 2, 2};
    }
    else if (invIteration <= 11){
      inventory = new int[] {32, 32, 32, 3, 3, 3, 3, 3};
    }
    else{
       inventory = new int[] {40, 40, 40, 20, 20, 20, 5, 5};
    }
    invIteration++;
    // Trade loop
    while (inTrade == true){
      print("\n\033[0m-- Mr. White's Inventory --");
      for (int i = 0; i < inventory.length; i++){
        String resourceValue = String.valueOf(inventory[i]);
        print("\u001b[0m> \u001b[32;1m{"+i+"} \u001b[33;1m"+resourceValue+" "+resourceTypes[i]);
        deciWait(0.125);
      }
      print("\n\033[0m-- Mr. J's Inventory --");
      for (int i = 0; i < items.length; i++){
        String resourceValue = String.valueOf(items[i]);
        print("\u001b[0m> \u001b[32;1m{"+i+"} \u001b[33;1m"+resourceValue+" "+resourceTypes[i]);
        deciWait(0.125);
      }
      print("\033[0m\n");
      // Give response box
      print("[Enter \"C\" for either box to cancel!]");
      print("\u001b[0m\n┌─\033[4mTrade what item?\033[0m─┐");
      print("|                  |");
      printStay("└──────────────────┘\033[F\r|         \u001b[34;1m");
      // Take response
      inputItem = sc.nextLine();
      // Give response box
      print("\u001b[0m\n┌─\033[4mFor what item?\033[0m─┐");
      print("|                |");
      printStay("└────────────────┘\033[F\r|        \u001b[34;1m");
      // Take response
      tradeItem = sc.nextLine();
      // Check for cancel
      if ((inputItem.toLowerCase()).equals("c") || (tradeItem.toLowerCase()).equals("c")){
        inTrade = false;
      }
      // Avoid attempt if cancelled
      if (inTrade == true){
        // Check for validity
        try{
          // Check if within range
          if (Integer.parseInt(inputItem) <= 7 && Integer.parseInt(inputItem) >= 0 && Integer.parseInt(tradeItem) <= 7 && Integer.parseInt(tradeItem) >= 0 && (Integer.parseInt(inputItem) != Integer.parseInt(tradeItem))){
            // Check T1 to T2
            if (Integer.parseInt(inputItem) <= 2 && Integer.parseInt(tradeItem) >= 3 && Integer.parseInt(tradeItem) <= 5 && items[Integer.parseInt(inputItem)] >= 6 && inventory[Integer.parseInt(tradeItem)] >= 1){
              items[Integer.parseInt(inputItem)] -= 6;
              items[Integer.parseInt(tradeItem)]++;
              inventory[Integer.parseInt(inputItem)] += 6;
              inventory[Integer.parseInt(tradeItem)]--;
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              print("\u001b[36mTrade successful!!\033[0m");
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              wait(3);
              clear();
            }
            // T2 to T3
            else if (Integer.parseInt(inputItem) >= 3 && Integer.parseInt(inputItem) <= 5 && Integer.parseInt(tradeItem) >= 6 && items[Integer.parseInt(inputItem)] >= 16 && inventory[Integer.parseInt(tradeItem) ] >= 1){
              items[Integer.parseInt(inputItem)] -= 16;
              items[Integer.parseInt(tradeItem)]++;
              inventory[Integer.parseInt(inputItem)] += 16;
              inventory[Integer.parseInt(tradeItem)]--;
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              print("\u001b[36mTrade successful!!\033[0m");
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              wait(3);
              clear();
            }
            // Check T2 to T1
            else if (Integer.parseInt(inputItem) >= 3 && Integer.parseInt(inputItem) <= 5 && Integer.parseInt(tradeItem) <= 2 && Integer.parseInt(tradeItem) >= 0 && items[Integer.parseInt(inputItem)] >= 1){
              items[Integer.parseInt(inputItem)] --;
              items[Integer.parseInt(tradeItem)] += 4;
              inventory[Integer.parseInt(inputItem)] ++;
              inventory[Integer.parseInt(tradeItem)] -= 4;
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              print("\u001b[36mTrade successful...kinda?!\033[0m");
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              wait(3);
              clear();
            }
            // Check T3
            else if (Integer.parseInt(inputItem) >= 6){
              typewriter("\033[0m\n\n\n\033[3m[You get the sense that Mr. White won't buy this off of you.]\033[0m", 0.0125, true);
              wait(2);
            }
            // Invalid trade
            else {
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              print("\u001b[31mTrade invalid!\033[0m");
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              wait(3);
              typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
              clear();
            }
          }
          // It didn't work
          else {
            typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
            print("\u001b[31mPick valid numbers/valid trades!\033[0m");
            typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
            wait(3);
            typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
            clear();
          }
        }
        // Input wasn't an integer
        catch (Exception e){
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          print("\u001b[31mPick valid numbers!!\033[0m");
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          wait(3);
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          clear();
        }
      }
    }

    // Ended trade
    typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
    wait(2);
    clear();
    typewriter("\033[0m     Mr. White: \"Well that was an interesting trade. Hope you feel better soon. Seeeee ya.\"", 0.0125, true);
    wait(2);
    typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
    sc.reset();
    // Return items back
    return items;
  }
  
  // disableTrade method (doesn't need pre-text)
  public void disableTrade(boolean attempted){
    if (attempted == false){
      typewriter("\033[3m[You see Mr. White in the distance, but sensing your anger, he keeps his distance.]\033[0m", 0.0125, true);
    } else{
      typewriter("\033[3m[Expecting to see Mr. White, it appeared he has since vanished from your vincinity.]\033[0m", 0.0125, true);
    }
      wait(2);
  }

  /// HELPER METHODS
  // Print method (for printing and then entering a newline)
  private static void print(String i){
    System.out.println(i);
  }
  // printStay method (for printing and remaining on the same line)
  private static void printStay(String i){
    System.out.print(i);
  }
  // Typewriter method (for printing in a typewriter fashion, and then entering a newline)
  private static void typewriter(String text, double delay, boolean random){
    for (char c : text.toCharArray()){
      System.out.print(c);
      if (random == false){
        deciWait(delay);
      }else{
        double randomNum = (Math.random()*(delay*1.25))+delay;
        deciWait(randomNum);
      }
    }
    print("\n");
  }
  // Clear method (for clearing the console screen and moving to top)
  private static void clear(){
    System.out.println("\033[H\033[2J");
  }
  // Wait method (for waiting integer amounts of seconds)
  private static void wait(int c){
    try{
      Thread.sleep(c*1000);
    }catch (Exception e){}
  }
  // deciWait method (for a more precise waiting, allowing doubles)
  private static void deciWait(double x){
    try{
      double waitDuration = x*1000;
      Thread.sleep((int) waitDuration);
    }catch(Exception e){}
  }
}
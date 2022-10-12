package AbheeksRealm;

// Gatherer Class
// Allows for the usage of the Olivia mechanic

/*
-- PUBLIC METHODS --
Gatherer() returners Gather - constructor
Gatherer.getResources() returns int[] - generates resources
Gatherer.getResourcesScared() returns int[] - generates scared resources
Gatherer.runAway() - causes Olivia to run away
Gatherer.voidItems() - causes items to not come
Gatherer.getHelpingStatus() returns boolean - returns helping status
--------------------
*/

//// CLASS
public class Gatherer {
  /// VARIABLES
  private boolean helping, upgradedLoot;
  private int i, amountTotalGet, upgradedLootCount;

  /// METHODS
  // Constructor (for creating the Olivia object)
  public Gatherer(){
    helping = true;
  }

  // Accessor/Mutators
  public boolean getHelpingStatus(){
    return helping;
  }

  public void setHelpingStatus(boolean h){
    helping = h;
  }

  // GetResources method
  public int[] getResources(){
    int[] itemsBrought = {0,0,0,0,0,0,0,0}; // Wood, water, leaves, Scrap metal, electronics, slagmud, core and fuel (not used)
    i = genRandom(100, 1);
    amountTotalGet = genRandom(3,2);
    upgradedLootCount = genRandom(1,1);
    // Check for upgraded loot
    if (i <= 5){
      upgradedLoot = true;
    }else{
      upgradedLoot = false;
    }

    // Get upgraded loot if needed
    if (upgradedLoot == true){
      amountTotalGet -= upgradedLootCount;
      for (i = 0; i < upgradedLootCount; i++){
        int selectedItem = genRandom(3,3);
        itemsBrought[selectedItem] = (int) itemsBrought[selectedItem] + 1;
      }
    }

    // Get regular loot
    for (i = 0; i < amountTotalGet; i++){
      int selectedItem = genRandom(3,0);
      itemsBrought[selectedItem] = (int) itemsBrought[selectedItem] + 1;
    }
    
    return itemsBrought;
  }

  // GetResourcesScared method
  public int[] getResourcesScared(){
    int[] itemsBrought = {0,0,0,0,0,0,0,0}; // Wood, water, leaves, Scrap metal, electronics, slagmud, core and fuel (not used)
    i = genRandom(100, 1);
    amountTotalGet = genRandom(4,3);
    upgradedLootCount = 2;
    // Check for upgraded loot
    if (i <= 8){
      upgradedLoot = true;
    }else{
      upgradedLoot = false;
    }

    // Get upgraded loot if needed
    if (upgradedLoot == true){
      amountTotalGet -= upgradedLootCount;
      for (i = 0; i < upgradedLootCount; i++){
        int selectedItem = genRandom(3,3);
        itemsBrought[selectedItem] = (int) itemsBrought[selectedItem] + 1;
      }
    }

    // Get regular loot
    for (i = 0; i < amountTotalGet; i++){
      int selectedItem = genRandom(3,0);
      itemsBrought[selectedItem] = (int) itemsBrought[selectedItem] + 1;
    }

    // Generate sample text
    return itemsBrought;
  }

  // runAway method
  public void runAway(){
    clear();
    typewriter("\033[0m\033[3m[Olivia punches your angered face, rendering you dazed for a few seconds as she runs over to the tent, never to be seen again.]", 0.0125, true);
    helping = false;
  }

  // voidItems method
  public void voidItems(){
    clear();
    typewriter("\033[0m\033[3m[Olivia caught you angrily shouting at the picture of Abheek and slowly walked backwards into the ocean, leaving no resources for you.]", 0.0125, true);
  }
  
  // Print method (for printing and then entering a newline)
  private static void print(String i){
    System.out.println(i);
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
  // deciWait method (for a more precise waiting, allowing doubles)
  private static void deciWait(double x){
    try{
      double waitDuration = x*1000;
      Thread.sleep((int) waitDuration);
    }catch(Exception e){}
  }
  // RNG machine (for a random number generator)
  private int genRandom(int range, int min){
    int value = (int)(Math.random()*range)+min;
    return value;
  }
}
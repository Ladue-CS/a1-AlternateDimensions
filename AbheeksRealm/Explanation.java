package AbheeksRealm;

// Explanation Class
// Explains the game for the new save

/*
-- PUBLIC METHODS --
Explanation() returns Explanation - Constructor that creates an Explanation class object
Explanation.giveContext() returns int[] - Initiates the context sequence, returns intial items given
--------------------
*/
//// IMPORTS
import java.util.*;

//// CLASS
class Explanation{
  /// Variables
  private static int i;
  private static int[] initialResources;
  
  // Scanner variables
  private static Scanner sc = new Scanner(System.in);
  
  // Looper Variables
  private static boolean finished = false;
  
  // Input Variables
  private static String[] questionOptions;
  private static String[] resourceTypes;
  private static String partialString;
  private static String response;

  // Other Classes
  Gatherer tempOlivia;
  
  /// METHODS
  // Constructor
  public Explanation(){
    questionOptions = new String[] {"\"I don't know...\"", "\"Who am I?\"", "\"Did you put your phone in the slots?\""};
    resourceTypes = new String[] {" Wood", " Water", " Leaves", " Scrap Metal", " Electronics", " Slagmud", "Submarine Core", "Fuel"};
    partialString = "";
  }

  // giveContext method (for starting the context sequence)
  public int[] giveContext(){
    clear();
    typewriter("\033[3m[You wake up to a gentle ocean breeze brushing against your face as you lay flat on the sandy sand.]", 0.0125, true);
    wait(2);
    typewriter("[A familiar voice bellows.]\033[0m", 0.0125, true);
    wait(2);
    typewriter("     \033[0m\033[1m???\033[0m: \"Bwahaha! Welcome to C++ Island, Jacob Matthew Jagodzinski!\"", 0.0125, true);
    wait(2);
    typewriter("\033[3m[The ground trembles beneath you.]", 0.0125, true);
    wait(2);
    typewriter("[A massive figure emerges from the sea...]", 0.0125, true);
    wait(2);
    typewriter("\033[0m\033[1m     Mr. J\033[0m: \"Abheek?!?\"", 0.0125, true);
    wait(1);
    typewriter("\033[0m\033[1m     Abheek\033[0m: \"Correct! It is I, Abheek, the one who Abheek'd you! Don't even try to escape because it's impossible! BWAHAHA\"", 0.0125, true);
    wait(2);
    typewriter("\033[3m[Abheek descends back to depth laughing manically...]", 0.0125, true);
    wait(2);
    typewriter("\033[0m\033[1m     Mr. J\033[0m: \"Huh?\"",0.0125, true);
    wait(2);
    typewriter("\033[3m[Another figure raises from the ocean...]", 0.0125, true);
    wait(2);
    askQuestion(); // moves on to the question loop
    return initialResources;
  }

  // askQuestion method (to enable a question loop)
  private void askQuestion(){
    while (finished == false){
      // Ask Question
      typewriter("     \033[0m\033[1mOlivia\033[0m: \"Oh hey Mr. J, what are you doing on this completely abandoned island in the middle of nowhere?\"", 0.0125, true);
      wait(2);
      // Generate answers
      for (i = 0; i < questionOptions.length; i++){
            String questionOption = questionOptions[i];
            print("\u001b[0m> \u001b[32;1m{"+i+"} \u001b[33m"+questionOption);
            deciWait(0.5);
          }
      // Create response box and get answer
      print("\u001b[0m\n┌─\033[4mEnter Option Number\033[0m─┐");
      print("│                     │");
      printStay("└─────────────────────┘\033[F\r|          \u001b[34m");
      // Check if valid
      response = sc.nextLine();
      finished = finishContext(response);
      if (finished == false){
        typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\u001b[31m", 0.0125, false);
        print("Pick a valid option!"); 
      typewriter("\033[0m\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
        wait(3);
        typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
        wait(1);
        clear();
      }
    }
  }

  // finishContext method (for finishing context)
  private boolean finishContext(String response){
    print("\n\033[0m\033[1m");
    // Check for answer validity and respond no if not
    if (response.equals("0")){
      typewriter("     \033[0m\033[1mOlivia\033[0m: \"Well maybe you should find out.\"", 0.0125, true);
    }
    else if (response.equals("1")) {
      typewriter("     \033[0m\033[1mOlivia\033[0m: \"Who are any of us really?\"", 0.0125, true);
    }
    else if (response.equals("2")){
      typewriter("     \033[0m\033[1mOlivia\033[0m: \"It broke on the way to class...\"", 0.0125, true);
    }
    else {
      return false;
    }
    // if valid, continue and then finish
    wait(2);
    typewriter("     \033[0m\033[1mOlivia\033[0m: \"Well on my way, I saw a SUBMARINE CORE near that Seoul Taco-branded tent, which smells an awful lot like Diet Coke.\"", 0.0125, true); 
    wait(2);
    typewriter("     \033[0m\033[1mOlivia\033[0m: \"Maybe if we had 40 WOOD, WATER, and LEAVES from those trees and 20 SCRAP, ELECTRONICS, and SLAGMUD from a nearby cave, that SUBMARINE CORE, and 2 gallons of FUEL we could get off this island!\"", 0.0125, true);
    wait(2);
    typewriter("     \033[0m\033[1mMr. J\033[0m: \"Ding dang it, you're right. I better hurry back to make sure the admin doesn't fire me!\"", 0.0125, true);
    wait(2);
    typewriter("     \033[0m\033[1mOlivia\033[0m: \"Also, as a fellow inhabitant of this previously uninhabited tropical island, I have taken it upon myself to procure a random assortment of items.\"", 0.0125, true);
    // Generate items
    tempOlivia = new Gatherer();
    initialResources = tempOlivia.getResources();
    for (i=0; i < initialResources.length; i++){
      if (initialResources[i] > 0){
        partialString += (Integer.toString(initialResources[i]) + (resourceTypes[i]) + ", ");      
      }
    }
    // Continue
    typewriter("\033[3m[Olivia hands you "+partialString+"and a fistful of optimism.]", 0.0125, true);
    wait(2);
    typewriter("\033[0m\033[1m     Mr. J\033[0m: \"Thanks?-\"", 0.0125, true);
    typewriter("\033[3m[Olivia walks back into the ocean before you even finished speaking.]", 0.00625, true);
    wait(2);
    typewriter("\033[0m\033[1m     Mr. J\033[0m: \"Hmm. How did she do that?\"", 0.0125, true);
    wait(2);
    return true;
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
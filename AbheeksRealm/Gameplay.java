package AbheeksRealm;

// Gameplay Class
// Implements the Looper for Gameplay

/*
-- PUBLIC METHODS --
Gameplay() returns Gameplay - constructor for the class
Gameplay.executeLoop() returns boolean - actual loop for gameplay. returns the win condition
Gameplay.setTimerSetAnger() - used by activities to change the timer and anger
Gameplay.addResources(int[]) - adds resources
--------------------
*/

//// IMPORTS
import java.util.*;

//// CLASS
class Gameplay{
  /// VARIABLES/OBJECTS
  // Integer/Double
  static private int[] currentResources;
  static private double anger;
  static private double countdownTimer;
  static private double traderTimer, gathererTimer;
  static private double diverCooldown, abheekCooldown;

  // Boolean
  static private boolean timerFinished, inputReceived, inSpecialActivity;
  static private boolean wonGame, attemptedTrade;
  static private boolean coolOff, coolingOff;

  // String
  static private String[] gameplayButtons, resourceTypes;
  static private String[] controlSchemeTree = new String[] {"q", "e"};
  static private String[] controlSchemeDive = new String[] {"^", "<", ">", "v"}; 
  static private String[] controlSchemeAbheek = new String[] {"a"};
  static private String input;

  // Scanner
  private static Scanner sc = new Scanner(System.in);

  // Timer
  private static Timer countdownTimerObject;
  private static TimerTask countdownTask;
  
  // Other Classes
  static private Gatherer olivia = new Gatherer();
  static private Trader gwhite = new Trader();
  static Activity treeHugger = new Activity(controlSchemeTree, 9999, 0, 1);
  static Activity waterDiver = new Activity(controlSchemeDive, 65, 90, 2);
  static Activity iHateAbheek = new Activity(controlSchemeAbheek, 45, 45, 3);
  
  /// METHODS
  // Constructor (for creating object)
  public Gameplay(int[] r, double a){
    currentResources = r;
    anger = a;
    countdownTimer = 1440;
    traderTimer = (double) genRandom(60, 120);
    gathererTimer = (double) genRandom(30, 60);
    diverCooldown = 0;
    abheekCooldown = 0;
    timerFinished = false;
    inputReceived = false;
    wonGame = false;
    attemptedTrade = false;
    coolOff = false;
    gameplayButtons = new String[] {"Praise the great Deku Tree", "Swim with the fishies", "Exercise while swearing at a picture of Abheek and his big *** smile", "Keep inventory of my stuff"};
    resourceTypes = new String[] {" Wood", " Water", " Leaves", " Scrap Metal", " Electronics", " Slagmud", " Submarine Core", " Fuel"};
  }
  
  public Gameplay(){}
  
  // setResources
  private void setResources(int[] r){
    currentResources = r;
  }

  // setTimer
  public void setTimerSetAnger(double t, double a, int l){
    countdownTimer = t;
    anger = a;
    if (l == 2){
      diverCooldown = (double) waterDiver.getCooldown();
    }
    else if (l == 3){
      abheekCooldown = (double) iHateAbheek.getCooldown();      
    }
  }

  // addResources
  public void addResources(int[] r){
    int[] tempVar = new int[currentResources.length];
    for(int i = 0; i < tempVar.length; i++){
      tempVar[i] = currentResources[i] + r[i];
    }
    currentResources = tempVar;

    // check resource limits
    for (int i = 0; i < 7; i++){
        if (i <= 2 && currentResources[i] > 40){
          currentResources[i] = 40;
        }
        else if (i >= 3 && i <= 5 && currentResources[i] > 20){
          currentResources[i] = 20;
        }
        else if (i >= 6 && currentResources[i] > 5){
          currentResources[i] = 5;
        }
      }
  }

  // executeLoop (for actually running the loop)
  public boolean executeLoop(){
    // Create Timer that does a check every 0.1 seconds
    countdownTimerObject = new Timer();
    countdownTask = new TimerTask(){
      @Override
      public void run(){ // check method
          // disables the timer from going into effect if currently dealing with an input
          if (inputReceived == false){
            countdownTimer -= 0.1;
            traderTimer -= 0.1;
            gathererTimer -= 0.1;
            diverCooldown -= 0.1;
            abheekCooldown -= 0.1;
            // Check if the timer has ended.
            if (countdownTimer <= 0.0){
              // End the timer permanently, and then force the ending.
              inputReceived = true;
              inSpecialActivity = true;
              print("\n\n\033[0m\033[3m--[You feel a sense of dread as you know that the time has come.]--\033[0m");
              while (input == null){deciWait(1);}
              ending();
            }
            else if (coolingOff == false){
              // Gatherer check
              if (gathererTimer <= 0.0){
                inputReceived = true;
                inSpecialActivity = true;
                clear();
                print("\033[0m\033[3m--[You get the sense that there is someone wanting to interact with you. Press ENTER to meet with them.]--\033[0m");
                while (input == null){deciWait(1);}
                oliviaMechanic();
                deciWait(2);
                gathererTimer = genRandom(30, 60);
              }
              // Trader check
              if (traderTimer <= 0.0){
                inputReceived = true;
                inSpecialActivity = true;
                clear();
                print("\n\033[0m\033[3m--[You get the sense that there is someone wanting to interact with you. Press ENTER to meet with them.]--\033[0m");
                while (input == null){deciWait(1);}
                traderMechanic();
                deciWait(2);
                traderTimer = genRandom(60, 120);
              }
              inputReceived = false;
              inSpecialActivity = false;
              coolOff = false;
            }
          }
        };
    };

    // Start timer 
    typewriter("\033[0m\033[3m[...]\033[0m", 0.0125, true);
    deciWait(2);
    countdownTimerObject.schedule(countdownTask,00,100); // runs the override task every 0.1 seconds starting immediately
    
    // While timer is not 0
    while (timerFinished == false){
      // Resets the vars
      clear();
      input = null;
      inputReceived = false;
      
      // Cooldown period
      if (coolOff == false){
        coolOff = true;
      }else{
        coolingOff = true;
        print("\033[0m\033[3m[You decide to cool off before attempting any further activity.]\033[0m\n");
        deciWait(5);
        coolingOff = false;
      }
      // Give options
      print("     \033[0m\033[1mMr. J\033[0m: \"Ok. I can either:\"\n");
      for (int i = 0; i < gameplayButtons.length; i++){
        String gameplayOption = gameplayButtons[i];
        print("\u001b[0m> \u001b[32;1m{"+i+"} \u001b[33;1m"+gameplayOption);
        deciWait(0.0125);
      }
      
      // Give response box
      print("\u001b[0m\n┌─\033[4mEnter Option Number\033[0m─┐");
      print("│                     │");
      printStay("└─────────────────────┘\033[F\r|         \u001b[34;1m");
      input = sc.nextLine();

      // Check response if not in another activity
      if (inputReceived != true){
        inputReceived = true;
         // Tree
        if (input.equals("0")){
          inputReceived = true;
          typewriter("\n\n\033[0m\033[3mTree Hugger - \"Thank you, o great Deku Tree\"\n\033[0m[Controls: Q or E]\n", 0.0125, true);
          deciWait(2);
          addResources(treeHugger.executeActivity(countdownTimer, traderTimer, gathererTimer, anger));
        // Ocean
        }else if (input.equals("1")&& diverCooldown <= 0.0){
          inputReceived = true;
          print("\n\n\033[0m\033[3mOcean Diver - \"Oh boy, time to go swimming\"\n\033[0m[Controls: <^v>]");
          deciWait(2);
          addResources(waterDiver.executeActivity(countdownTimer, traderTimer, gathererTimer, anger));
        // Abheek
        }else if (input.equals("2") && abheekCooldown <= 0.0){
          inputReceived = true;
          print("\n\n\033[0m\033[3mAbheek Hater - [Stares angrily at an image of Abheek's big *** smile]]\n\033[0m[Controls: A]");
          deciWait(2);
          addResources(iHateAbheek.executeActivity(countdownTimer, traderTimer, gathererTimer, anger));
        // Inventory
        }else if (input.equals("3")){
          inputReceived = true;
          print("\n\n\033[0m-- Inventory --");
          for (int i = 0; i < currentResources.length; i++){
            String resourceValue = String.valueOf(currentResources[i]);
            print(resourceValue+" "+resourceTypes[i]);
            deciWait(0.5);
          }
          deciWait(3);
          print("\n\n\n--Enter to resume--");
          sc.nextLine();
          coolOff = false;
        }else if (input.equals("c++ sucks") || input.equals("become the subclass") || input.equals("java best bae")){
          wonGame = true;
          countdownTimer = 0.0;
          timerFinished = true;
          inputReceived = false;
        }
        // Wrong input
        else{
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          print("\u001b[31mActivity on cooldown or not found!\033[0m");
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          deciWait(3);
          typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
          deciWait(1);
        }
      }

      // lock into loop if in special activity
      while (inSpecialActivity == true && timerFinished == false){deciWait(0.5);}
      print("end of loop");
    }
    // Return value for the ending
    return wonGame;
  }

  // Ends the gameplay loop
  public void ending(){
    // Disable the activity flow
    inputReceived = true;
    timerFinished = true;
    // check for win conditions
    if ((currentResources[6] >= 1) && (currentResources[7] >= 2) && (currentResources[4] >= 20) && (currentResources[3] >= 20) && (currentResources[2] >= 40) && (currentResources[1] >= 40) && (currentResources[0] >= 40) || wonGame == true){
      wonGame = true;
    }else{
      wonGame = false;
    }
  }

  // Olivia adds to the resources TEST <<
  private void oliviaMechanic(){
    // Check if gathering valid
    boolean helping = olivia.getHelpingStatus();
    // appropriately gather resources
    if (helping == true){
      if (anger < 75){
        print("\033[0m\033[3m[Olivia gets you a few resources. Not much else happened.]\033[0m\n");
        addResources(olivia.getResources());
      } else if (anger >= 75 && anger < 95){
        print("\033[0m\033[3m[Olivia gets you a few resources, albeit she was a little bit freightened. She scurried off after dropping them off.]\033[0m\n");
        addResources(olivia.getResourcesScared());
      } else if (anger >= 95){
        olivia.runAway();
        printStay("\n");
      }
    }
  }

  // traderMechanic handles the trading mechanic TEST <<
  private void traderMechanic(){ 
    // Check if trading valid
    boolean trading = gwhite.getTradingStatus();
    // appropriately enable trading
    if (trading == true){
      if (anger <= 50){
        setResources(gwhite.trade(currentResources));
      } else if (anger > 50 && anger < 90){
        setResources(gwhite.angryTrade(currentResources));
      } else if (anger >= 90){
        gwhite.disableTrade(attemptedTrade);
        if (attemptedTrade == false){
          attemptedTrade = true;
        }
      }
    }
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
      printStay(String.valueOf(c));
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

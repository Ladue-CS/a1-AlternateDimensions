package AbheeksRealm;

// Activity Handler
// Handles Activites

/*
-- PUBLIC METHODS --
Activity(String[], int, int) returns Activity - constructor
Activity.executeActivity(double, double, double, double) - does the activity which gives the resources alongside the new timers.
Activity.returnCooldown() returns double - returns cooldown timer
--------------------
*/

//// IMPORTS
import java.util.*;

//// CLASS
class Activity{
  /// VARS
  private String[] controlScheme;
  private int timeLimit;
  private double endTime, currentTime;
  private int cooldown, activityMode;
  private int[] rewards;
  private double tempRewards, anger;

  // Timer
  private static boolean timeUp = false;
  private static Scanner sc;

  /// METHODS
  // constructor
  public Activity(String[] c, int tl, int cd, int a){
    controlScheme = c;
    timeLimit = tl;
    cooldown = cd;
    activityMode = a;
  }
  
  // activity execute
  public int[] executeActivity(double c, double t, double g, double a){
    timeUp = false;
    currentTime = c;
    Timer activityTimer = new Timer();
    TimerTask activityTask = new TimerTask(){
      @Override
        public void run(){
          if (endTime <= 0.0){
            activityTimer.cancel();
            activityTimer.purge();
            ending();
          }
          else{
            endTime --;
          }
        };
    };
    
    // determine time to end
    double[] possibleTimes = new double[] {timeLimit, t, g};
    endTime = 99999;
    for (int i=0; i < possibleTimes.length; i++){
      if ((double)(possibleTimes[i]) < endTime){
        endTime = (double) possibleTimes[i];
      }
    }

    // Some scanner bs
    Scanner sc = new Scanner(System.in);
  
    // Start activity
    print("\n--Start activity! Start entering your controls!--");
    rewards = new int[] {0,0,0,0,0,0,0,0};
    activityTimer.schedule(activityTask, 0, 1000);

    // 
    while (timeUp == false){
      if (sc.hasNextLine() == true){
        String input = sc.nextLine(); 
        if (Arrays.asList(controlScheme).contains(input)){
          if (activityMode == 1){
            tempRewards += ((double)1/15);
            anger += 0.5;
          } else if (activityMode == 2){
            int getReward = genRandom(2,1);
            if (getReward == 1){
              tempRewards += 0.25;
            }
            anger += 0.5;
          } else {
            anger -= (0.05);
          }
        }
        else if (input.equals("c") || input.equals("C")){
            endTime = 0.0;
        }
      }
    }
    // Calculate rewards and return
    if (activityMode == 1){
      for (int i = 0; i < (int) tempRewards; i++){
        rewards[genRandom(3,0)]++;
      }
    }
    else if (activityMode == 2){
      // T2
      for (int i = 0; i < (int)(0.15*tempRewards); i++){
        rewards[genRandom(3,3)]++;
      }
      // T1
      for (int i = 0; i < (int)(0.85*tempRewards); i++){
        rewards[genRandom(3,0)]++;
      }
    }

    // Return the values
    Gameplay settings = new Gameplay();
    settings.setTimerSetAnger(currentTime-endTime, anger, activityMode);
    return rewards;
    }

  // getCooldown
  public int getCooldown(){
    return cooldown;
  }

  // ending
  static private void ending(){
    timeUp = true;
    clear();
    print("--Time is up/interruption occurred! Press ENTER to continue.--");
    try{sc.reset();}catch(Exception e){}
  }
  
  /// HELPER METHODS
  // Print method (for printing and then entering a newline)
  private static void print(String i){
    System.out.println(i);
  }
  // printStay method (for printing and remaining on the same line)

  // Clear method (for clearing the console screen and moving to top)
  private static void clear(){
    System.out.println("\033[H\033[2J");
  }
  // RNG machine (for a random number generator)
  private int genRandom(int range, int min){
    int value = (int)(Math.random()*range)+min;
    return value;
  }
}

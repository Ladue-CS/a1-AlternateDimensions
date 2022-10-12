package AbheeksRealm;

// End Class
// Produces an ending based on the win condition

/*
-- PUBLIC METHODS --
End() returns End - Constructor that creates an object
End.endGame(boolean w) - Ends the game. Requires win condition to function
--------------------
*/

//// CLASS
class End{
  /// VARIABLES
  static Tutor TeacherMing = new Tutor();
  
  /// METHODS
  // Constructor 
  public End(){}

  // endGame (for ending the game)
  public void endGame(boolean won){
    clear();
    // Checks win condition
    if (won == true){ // Win
      // Dialogue
      typewriter("\033[3m[The Submarine dubbed the SS JAG comes to life with a soft humming.]", 0.0125, true);
      wait(2);
      typewriter("\033[0m\033[1m     Mr. J\033[0m: \"Booya! Finally, I can finally get off this stupid island.\"", 0.0125, true);
      wait(2);
      typewriter("\033[3m[The SS JAG decends into the depths of the ocean]", 0.0125, true);
      wait(2);
      typewriter("[VZW Airwaves starts to play, a screen lights up.]", 0.0125, true);
      wait(2);
      typewriter("\033[0m\033[1m     Mr. J\033[0m: \"Who could...? Mr. Griffith?\"", 0.0125, true);
      deciWait(0.5);
      typewriter("     \033[0m\033[1mMr. Griffith\033[0m: \"Correct. This is Brad Griffith; congratulations you can ke--\"", 0.0125, true);
      typewriter("\033[36;1m*BZZZZ*", 0.0125, true);
      wait(1);
      typewriter("\033[0m\033[3m[Your vision begins to fill with a blindingly bright white light]", 0.0125, true);
      wait(2);
      typewriter("[In the midst of the light, a shadow of a man, a tall man, dressed in black (or so you think), with a perfect buzzcut.]", 0.0125, true);
      wait(2);
      typewriter("\033[0m\033[1m     ???\033[0m: \"Jacob Matthew Jagodzinski, I have an offer...\"", 0.0125, true);
      wait(4);
      TeacherMing.giveTherapyOffer();
      typewriter("\n\n\n\033[0m\033[42;1mTEACHER MING ENDING [Good Ending]\033[0m", 0.125, true);      
    }else{ // Lose
      typewriter("\033[3m[The ground begins to shake.]", 0.025, true);
      wait(3);
      typewriter("[Abheek emerges from the sea.]", 0.025, true);
      wait(3);
      typewriter("\033[0m\033[1m     Abheek\033[0m: \"BWAHAHA, looks like you couldn't make it in time! Let's watch as you lose everything together! BWAHAHA!\"", 0.025, true);
      wait(3);
      typewriter("\033[3m[A massive holoscreen appears before your eyes, showing Mr. Griffith making a speech.]", 0.0125, true);
      wait(3);
      typewriter("\033[0m\033[1m     Mr. Griffith\033[0m: \"Today, we lost a good man. A man once honored and respected.\"", 0.0125, true);
      wait(3);
      typewriter("\033[3m[Griffith takes a shaky breath.]", 0.0125, true);
      wait(3);
      typewriter("\033[0m\033[1m     Mr. Griffith\033[0m: \"After months of searching, the police have called off search and rescue for Mr. White...\"", 0.0125, true); 
      wait(3);
      typewriter("     \033[0m\033[1mMr. Griffith\033[0m: \"Yesterday he was assumed dead. He was one of the best; let him rest in peace...\"", 0.0125, true);
      wait(3);
      typewriter("\033[3m[Griffith break down crying as the broadcast switches to Dr. Wipke...]", 0.0125, true);
      wait(3);
      typewriter("\033[0m\033[1m     Dr. Wipke\033[0m: \"Ahem... This is a tough time for all of us. However, looking on the bright side...\"", 0.0125, true);
      wait(3);
      typewriter("     \033[0m\033[1mDr. Wipke\033[0m: \"Search and Rescue has found Olivia HuNacki, who went missing around the same time as Mr. White, on a Soeul Taco-branded tent that has been fashioned into a makeshift boat.\"", 0.0125, true);
      wait(3);
      typewriter("     \033[0m\033[1mDr. Wipke\033[0m: \"We must unite as a community to get through these tough times. Thanks to everyone who have reached out to give their support over the past couple months.\"", 0.0125, true);
      wait(3);
      typewriter("     \033[0m\033[1mDr. Wipke\033[0m: \"This has certainly been a rough patch for us all, but I am hopeful we can move on with each other's support.\"", 0.0125, true);
      wait(3);
      typewriter("\033[3m[The holoscreen quickly minimizes itself out of existence as Abheek began to walk in circles slowly, grinning sinisterly.]", 0.0125, true);
      wait(3);
      typewriter("\033[0m\033[1m     Abheek\033[0m: \"Oh, He didn't even mention your name? That must sting...\"", 0.0125, true);
      wait(3);
      typewriter("     \033[0m\033[1mAbheek\033[0m: \"Maybe if you were a better teacher, they would have remembered you.\"", 0.0125, true);
      wait(3);
      typewriter("     \033[0m\033[1mAbheek\033[0m: \"Too bad! Looks like you're gonna rot on this island instead. BWHAHAHAHAHAHAHAHA\"", 0.0125, true);
      typewriter("HAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHA!", 0.0125, true);
      wait(3);
      typewriter("     \033[0m\033[1mAbheek\033[0m: \"Aaaaaaaaaanyway, luckily for you, I got you a computer...\"", 0.0125, true);
      wait(2);
      typewriter("     \033[0m\033[1mAbheek\033[0m: \"BUT IT ONLY CAN RUN C++!!!\"", 0.0125, true);
      deciWait(0.25);
      typewriter("     \033[0m\033[1mAbheek\033[0m: \"Enjoy eternity! BWHAHAHAHAHA!\"", 0.0125, true);
      wait(2);
      typewriter("\033[3m[Abheek sinks back into the sea laughing hysterically.]", 0.0125, true);
      wait(2);
      typewriter("[You never see him again.]", 0.0125, true);
      wait(2);
      typewriter("[You don't know how long it's been since then: days, weeks, months, years?]", 0.0125, true);
      wait(2);
      typewriter("[The only thing you do know is that C++ is the one true coding language...]", 0.0125, true);
      wait(3);
      typewriter("\n\n\n\033[0m\033[41;1mCOMATOSE ENDING [Bad Ending]\033[0m", 0.125, true);
    }
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
    private static void wait(int x){
    try{
      int waitDuration = x*1000;
      Thread.sleep((int) waitDuration);
    }catch(Exception e){}
  }
}

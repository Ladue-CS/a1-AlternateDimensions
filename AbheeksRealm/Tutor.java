package AbheeksRealm;

// Tutor Class
// This is the implementation of the tutor, TeacherMing.org

/*
-- PUBLIC METHODS --
Tutor() - Constructor takes no parameters
Tutor.giveTherapyOffer() - Method takes no parameters
--------------------
*/

//// CLASS
class Tutor{  
  /// CONSTRUCTOR
  public Tutor(){}

  /// METHODS
  // Therapy Offer method (dialogue option for Tutor)
  public void giveTherapyOffer(){
    typewriter("     \033[0m\033[1mTeacher Ming\033[0m: \"I can help with all your problems my website is teacherming.org I am best tutor in USA and the World!\"", 0.125, true);
    deciWait(1.5);
    typewriter("     \033[0m\033[1mTeacher Ming\033[0m: \"You look like you need review on 8 laws of health.\"", 0.125, true);
    deciWait(1.5);
    typewriter("     \033[0m\033[1mTeacher Ming\033[0m: \"Remember: NEW START!\"", 0.125, true);
    wait(2);
    typewriter("       Nutrition   \n       Exercise   \n       Water   \n       Sunshine   \n       Temperance   \n       Air   \n       Rest   \n       Trust in God!", 0.075, true);
    wait(3);
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
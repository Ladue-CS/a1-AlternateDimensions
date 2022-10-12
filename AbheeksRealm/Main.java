package AbheeksRealm;
// Main Class
// Heart of the code; runs the game in order

/* 
-- PUBLIC METHODS --
None
--------------------
*/

//// IMPORTS
import java.util.Scanner;

//// CLASS
class Main {  
  /// VARIABLES / OBJECTS
  // Scanner
  static private Scanner sc = new Scanner(System.in);
  static private String EnteredValue;

  // Menu String Variables
  static private String[] menuButtons;

  // Etc. Variables
  static private int[] initialResources;
  static private double anger;
  static private boolean won = false;

  // Looper Variables
  static private boolean inLoop = true;

  // Other Classes
  static private Explanation intro;
  /*static private Gameplay looper;*/
  static private End ending;

  /// METHODS
  // Main method (runs everything)
  public static void main(String[] args){ 
    // Title/menu input loop
    while (inLoop == true){ 
      clear();
      print("\u001b[31m"); // set to red color
      // Print Title
      typewriter("░█▀▀█ █▀▀▄ █░░█ █▀▀ █▀▀ █░█ █ █▀▀ 　 ▒█▀▀█ █▀▀ █▀▀█ █░░ █▀▄▀█\n▒█▄▄█ █▀▀▄ █▀▀█ █▀▀ █▀▀ █▀▄ ░ ▀▀█ 　 ▒█▄▄▀ █▀▀ █▄▄█ █░░ █░▀░█\n▒█░▒█ ▀▀▀░ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ░ ▀▀▀ 　 ▒█░▒█ ▀▀▀ ▀░░▀ ▀▀▀ ▀░░░▀", 0.025, false);
      deciWait(1.2);
      printStay("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGPPGP#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&###BG5YY5PB&&&@@@@@@@@\nGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGB&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@&BGJ!~75P#@@@@@@@@@@@\nGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG5GB5PPGGGGGPGGGGBBBBBBBBBBBBGGBBBBBGGBBB#&#GPPGBBGB#####&&&&&\nGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGBBBGPYJ?7777JY5P5?!!~^~!7?Y5PPGBBBBBBBBBBBBBBGGPBBBBBPPGPGPPPPPPB#G5PPGGGBBBB##\nGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGBGGGBBG5J7~:........:^~^::...:..::^^!YPGBBBBBBBBBBBBGGPBBBBBGPGGGP5YYYYBBG5PGGGBBBB###\nGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGBBBBBBBG57^:.......................:::::::^!7J5GBBBBBBBBBPPBBBBBGPGPGP55YYYBBG5PGGGBBBB###\nBBBBBGGGGGBBBGGBBBGGGGGGBBBBBBBBGBGP?~:................................::::^^!?PGBGGGGGGGBBBBBPPGPGP5YYYYBBG5PGGGBBBB###\nBBBBBBBBBBBBBBGBBBBBBBBBBBBBBBBBG5!:.......................................::^~!??JJJJJJYYJJJJJ?JJJJ?????YJYPPGGGBBB####\nBBBBBBBBBBBBBBBBBBBBBBBBBBBBBGGP7:...........................................:^^!7J55PPPPPPPP55PP5555555YYY5PPGGBBBB####\nBBBBBBBBBBBBBBBBBBBBBBBBBBBG55J~............................................:::::~!?Y5PPPPPPPPPPPPPPPPPPPP555PGGBBBB####\nBBBBBBBBBBBBBBBBBBBBBBBBBBGYJJ~...................:::::::::^^^^^^::.........:::...:^???Y555P55555555555555555PGGBBBB####\nBBBBBBBBBBBBBBBBBBBBBBBBBGJ7!^...............:^^^~~~~~~~~~~~~~~~~~^^::.............:^7?7J5PPPPPPPPPPP5PPPPP55PGGBBBB####\nBBBBBBBBBBBBBBBBBBBBBBBGY7^:...............::^~~~~!~~~~~~~~~~~~~~~~~~^::.............:~?JJ5PPPGGGGGGGPGGGPPGPGGGBBBB####\nBBBBBBB#BBBBBBBBBBBB#B5?!:................:^^^~~~~~~~~~~~~~~~~~~~~~~~^^^::..........:^:^!77J5GPGGGGGGGGGGGGGPGGGBBBB####\nGGGGBBBBBBBBBBBBB##BB5?7:................::^^~~~~~~~~~~~~~~~~~~~~~~~~^^^^^::........:::.^7?!?YPGGGGGGGPGGPGGPGGBBBBB####\nJYY555PPPPGGGGGGBBGBGJ~:.................:^^~~~~~~~~~~~!!!!!!!!!!!!~~~~^^^^:............:~?7??JPGPPPPPPPPPPPPPGBBBBB####\n!!77???JYYY555555PPPY~:............... .:^^^^^^~~~~!!!!!!!!!!!!!!!!~~^^^^^^^:............:~77YYYPPPPPPGPPGGPPPPGBBBB####\n!!77777??JJJJJJJYYY?~:...........  .....:::.......::^^~!!!!!!!!~~^^::......::............:^~!?5JYPGBBBBBBBGBBGPGBBBB####\n!?JJY5PYJJJJJYYYYY?^:............   ..................:::^~~~^::......::::::..............:~77JJJY5GBBB#BBBBBBGGBBBB####\n!JYJ5GG5JJYYYYYYJ!^:.............   ....:^~~~~~~^^::::::::^^^^::::::^^~~~~~~^^............::~7???YJ5GBBBBBBBGBGGBBBB####\n7JYYPBGYJYYYYYY?^:::....... .....  ...:^~~^^^::.::::::^^^^^^^~~^^^:::::::::^^^^:...........::~7??YYJPGBBBBBBGBGGBBB####&\n?JYPG#B5YYYYYJ7^::~:......   ..    ..:^^^:.........:::^^^~~~~~^^^:::.....:..::^::..........::^~!!?J?YGGGGGBBGGGGBBB####&\n7?JY5GPYYYYYJ7~^:~?~.....         ..::^^^^:^^^^:^^^^^^^^^~~!!!~^^^^^^^^^^^^::^^^^:..........::^~!~7??PBBBBBBBBBGGB#####&\n77???JJYYYYJJ~^:^!~:....          ..::^^~~~~~~^^^^^~^^^^~~~!!!~~^^~^^^^^^~~~~~~~^^:...........:^~~!775BBBBBBBB#BBB#####&\n??JJJJYYYYY?~~^::...:...          .:^^~~!!!!!!!!~~~~~~~~~!!!!!!!~~~~~~~~!!!!!!!!~~^........::..:^^~!!JPB#####B#BBB####&&\nJJJJYYYYYYJ!^:..:~77~^...         .:~!!!777777777!!!!~!!!7777777!!~~!!!!7777777!!~^:........:::.:^^~~!JP##B##BBBBB####&&\nJJJYYYYYYYJ~^:.~JJ?!^:...   .     .^~!!77????77777!!!77!!!77777!~!77!!!777???777!~^:.........::..::^^~~?P##BBBBBGB####&&\nJJYYYYYJ?7!::..^~^:....         . .^~!!77????7777!!~~~~~^^~!7!~^^^~!~!!!77777777!~^:.........:.:.:^^^~~^?GBBBBBBBBB###&&\nJYYYYYY?!~:...........          . .^~~!7777777!~~~!!!!~~!!!!!!!!~~~~!!!~~~!!777!~^::............:::::^^^YPPGBB##BBB###&&\nYYYYYYYY7^.....                 ...:~~!!7777!~^~~!!!!!!!!!!!~~~~~~~~~~~~~~~~!!!~^::................::^^^?PPGG########&&&\nYYYYYYYJJ7:.....                ...:~~~!!7!7~^^~!!!!!~!!!!!!!!!~~~~~~~~~~^^~~!!~~^:.................::^^7JPB######BB#&&&\nYYYYYYYJJ7^....                ....:~~!!!!77!~^^:..^~!7!!!!!!!!!!!!~~^.::^~~!!!~~^^:................::^7PPPBB#####BB#&&&\nYYYYYYYYJ7!^..                 .....^~!!!!777!~~~^:^~!?7??JYJJYJ?7!!~^^^~!!!!!!~~~^................::!?G#GGBBB####B##&&&\nYY5555YYJ7!!!^:..               . ..:~!!!!7777!!!!!~~~~~~!!!!!!!!~~~~~!!!!!!!!!~~^:...............:::?GBBB#######BB##&&&\nYY5555YYJ7!!!7!!:......             .:~!!7!7777!!77777!!!!!!77777!!!!!!!!!!!!!!!~^.................:~G######&#########&&\nY555555YJ?!!!!!!^.....               .^~!!!!!!7!!!!!7777777777!77777!777!!!!!!!!~:. ..............:~Y#&#&&&&&&&#######&&\nY5555555Y?!!!77!^...                  .^~!!!!!!7!777777777!!!!!!!777777!!!!!!!~~:.  .............^!J#&&&#&&&&&#&&&####&&\n5555P5555YJJ????7^:..                  .^~~!!!!!!!777777777777777777777!!!!~~~~:.  . ...........:^J#&&&&&&&&&&&&&&####&&\n555PPPPPPP555555YJ7~^.:^^...           .:^^~~!!!!!!777777777?777777777!!~~~~~^:.      .. ......:7^!G&&&&&###&&&&&&####&&\n55PPPPPPPPPPPPPPPP55Y~75J~..           .:^^^~~~~~~!!77777777777?7777!!~~~~^^^^:.      .. ......^7^7B&&####&&&####&####&&\n55PPPPPPPPPPPPGGGGGPGY!55?:.    ...     :~~~~^^~~~~~!!!!!!7777777!!!~~~~^^^^~^:.      .........:::5&&&&&&&&&&#########&&\n5PPPPPGGPPGGGGGGGGGGGG5JYJ~.   ...      :~~!~~~^~~~~~~~~~~~~~~~~~~~~~^^^^^~~~~:.      ..........:J#&&&&&&&&&&&&&&&&&&&&&\nPPPPGGGGGGGGGGGGGGGGGGBGGPJ^....        :~~!!!~~~~~~~~~~~^^^^^^^^^^^^^^~~!!~~~:.   ............!G&&&&&&&&&&&&&&&&&&&&&&&\nPPPGGGGGGGGGGGGGGGGGGGBBBBBP!...        :~!!!!!~~~~~~~~~~~~~~~~~~~~~~~~!!!!!!~:.   ...........:Y#&&&&&&&&&&&&&&&&&&&&&&&\nPPGGGGGGGGGGGGGGGGGBBBBBBB5~..         .:~!!!!!!!!!!!!!!!!777!!!!!!!!!!!7!!!~~^.......::..   .~YPB&&&&&&&&&&&&&&&&&&&&&&\nPPGGGGGGGGGGGGGGGGGBBBBBB7...      ..  :^~!!!777777!!!!!!!!!!!!!!!!!!7777!!!!~^.......:::...^J55PP#&&&&&&&&&&&&&&&&&&&#&\nPPGGGGGGGGGGGGGGGGBBBBBBG~::...    ....:^~!!!77777777!!!!!!!!!!!!!777777!!!!~~:......:...:~JJYYJJ5B&&&&&&&&&&&&&&&&&&###\nPPGGGGGGGGGGGGGGGBBBBBB#G!::......  ...::^~!!!7777777777!77777!!777777777!!!~^:..........:~!!~^^^7P#&&&&&&&&&&&&&&&&&&&&\nPPGGGGGGGGGGGGGBBBBBBB#P!^::............::^~!!!!777777777777777777777777!!~~^:...........:::::...:!B@&&&&&&&&&&&&&&&&&&&\nPPGGGGGGGGGGGBBBBBBBBBY~::::..............:^~~!!!!!7777777777777777777!!!~~^:..................^!JG#&&&&@&&&&&@&&&&&&&&&\nPGGGGGGGGBBBBBBBB####J^::..................::^~~!!!!777777777777777!!!!~~~^:.............:^~!7JYYJJJ5#&&&&&&&&&&&&&&&&&&\nPGGGBBBBBBBBBBBBGP5?7^.......................::^~~~!!!77777777777!!!!!~~^:.............:^~!~~^::.:7Y55555PPPPGGBB##&&&&&\nGBBBGGGGPP5YJ7!^:.......   .....................:^~~!!7777!77777777!~^::..............::::......~?JJJ????????JJJYY55PGGB\nY?!~^^::........................  ................::^!!777!!7777!!^::...:............:........~7??????77777777??JJYYY55P\n.....................................................:^~!!7!!!~^::..........................^7777!77!!!!!!!~~~!!77???JJJ\n........................................................:^~~^:..........:.:...............:~!77!!!!~~~^^^^^^^::^~~~~~!77");
      wait(5);
      print("\n\nThe Movie: The Game: The Netflix Original Adaptation: The Video Game Adaptation: Text Adventure Edition v1.21 The Jaggedinksi/Abique de Mozambique Update\n\n");
      print("Now with 120% more Abreu, 10% more Norris, and 9999% more janky programming");
      print("\n\n\033[38;5;123;1mA Cool AF™ Production \"Flying too close to the sun\"™ - © 2022 All™ Rights™ Reserved™ in cooperation with George Jurgiel Gaming Studios & Ed Stout & Owen Edward Stout\n\n\033[0m");
      // Give options
      menuButtons = new String[]  {"Play", "Continue from Save [Premium]", "Enter Creator Code"};
      for (int i = 0; i < menuButtons.length; i++){
        String menuOption = menuButtons[i];
        print("\u001b[0m> \u001b[32;1m{"+i+"} \u001b[33;1m"+menuOption);
        deciWait(0.5);
      }
      // Give response box
      print("\u001b[0m\n┌─\033[4mEnter Option │                     │");
      printStay("└─────────────────────┘\033[F\r|          \u001b[34;1m");
      // Take response
      EnteredValue = sc.nextLine();
      typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
      // Generate result
      if (EnteredValue.equals("0")){
        // Enter game
        print("\u001b[35;1mLoading...\033[0m");
        inLoop = false;
      }else if (EnteredValue.equals("1")){
        // Continue from save
        print("\u001b[31mOption locked!\033[0m");
        //inLoop = false;
      }else if (EnteredValue.equals("2")){
        // Enter creator code
        print("\u001b[31mOption locked!\033[0m");
        //inLoop = false;
      }else{
        // Invalid option
        print("\u001b[31mPick a valid option!\033[0m");
      }
      typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
      wait(7);
      typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
      print(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::^:^:::::::::::::\n:::::::::::::::::::::^::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::^::::::::^:^:::::::::^::::::::::::::::::\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::^:::::::::::::::::::::::::::::::\n:::::::::^:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n:::::^:::::::::::::^^^^^^^:::^^^^^::^:::::::^^^^^^:^::::^~!7!!!!!!!!!~^^^^^^^::^^::::^^^^^^^:^:::^^::::::::::::::::::::::::::\n^^^^^^^:^^^^::::::::::::::::::::::::::::::::::::::::~!7JY55555555YYYYYJ?7!!~~^:::::::::::::::::::::::::::::::::::::::::::::::\n::::::::::::::::::::::::::::::::::::::::::::::::^!?JY5PPPPPP5P55YYYYJYY5555YY?!~:::::::::::::^:::^^:::^::::::^^:::^:::^^^::::\n:::::^:::::::::::::::::::::::::::::::::::::::^~7Y5555PPPPPPPPPPGGGGGP55555PPP55YJ7~^:::^:::::::::::::::::^::::::^:^:::^^:::::\n:::::::::^::::^:^^:^::::::::::::::::::::::^7J5PPPPPPPPGGPPP555555555555PP55YYYY5555Y7~^:::::::::::::^::::^::::^:::::^::::::::\n^::^::::::::::::::::::::::::::::::::::::^?YPGPPPPPPPGGPPPPPPPPPPP55555YYYY555555YY55PY?^::::::^^:^:^^:::::::::::^::::::::::::\n:^^^::::::::::::::::^^:::::::::::::^:^~J5PPPPPPPGPPPPGGGGGGGGGGGPPPP55555555PPPGGBGGGP?^::::::^^::::^:::^^::::::::^:^::::::::\n:::::::::^:::::::::^:::::^^:^::::::^^JPGPPPPPGGGGGBBBBBBBBBBBBBBBGGGPP55555PPPGBBBBBBY^::::::^:^::^::^::::^^:^:::::::^^:^^::^\n::::^:::::^::::::^:^:^::::::^^::::^:~5GGGGPPGGGGGBBBBBBB#####BBBBGGGP5555P55YYJJJY5GBGJ^:^^::^^^::::::^:^::^::^^^::^^:::::::^\n^::::::^:^^^:^::::^^:::::^^:::::^:^:!GGGGPPPGGGBBBBBB#####BBBBBGGGPP5YJJ?77!!~~!!!7YGBB?^:^^:^^:^::::::^:^^:^^:^^^^:::^:^:^::\n:^:::::^:^^^^:::::^:::^^:::^^^^:::^:5BGGGBGGBGGGGGGGGGGGGGGGGGPP5YJ??7!!!~~~~~~~~~~7YGGP~:^^^^:^^^^^^^^:^^^^^^:^^^^:^^^::^^^:\n:^::::::::::^^^^^^^^::^^^:::^^^^^^^:!PPGBBGGGGG5YYYYYYYY5YYYJJ??777!!!~~~~~~~~~~~~!!?5PP7:^^^^^^:^::^^^:^^^^^^:::^:^:^:^:^:^^\n:::::^^:::::^^^^:^^::^:^^^^^^^^^^^^^^!5PGGPP55Y??????????777777!!!!!!~~~~~~~~!!!!!~~!JY5?^^^^^^^^^^^^^^^^^^^^^^^:^^^^^^^^^:^^\n^^::^::^^:^^::^^^^::^^^^^^^^^^^^^^^^:^YPPP5YJ?7777?777777!!!!!!!!!!!!!!~~~~~~!!!!!!~!??YJ^^^^^^^^^^^^^^^^^^^^^^^^^:^^^:^^^:^:\n^::^:::::::^^^:^^^:^^^^^^^^^^^^^^^^^^^YGPP5J777777777!!77!7777!!!!!!!!!!!~~~~~!!!!!!!JYYY^^^^^^^^^^^^^^^^^^^^^^:^^^^^^^^^^^:^\n::^^::::^:::^:^:::^^^^^^^^^^^^^^^^^^~^JGPP5?7777??JYJJJJ?7777777!!!!!!!!!!!~~~~~~~!!~?YPJ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n:^::::^^^:^^^^^^^^^^^^^^^^^^^^^^^:7J??YPPGP?777Y55PPGGGBGGP5J??777?777777?JJJJ??7!~!~75P~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n::^:^^^^^^^::^::^^^^^^^:^^^^^^^^^^YPY?JYPPP?777??JYY5PPGGGGPYJJ??????JJJYGBBBGGP55J7~YPJ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n:^:^:^^::^^:::^^^^^^^^^^^^^^^^^^^^?PY777?PP7!!77?Y555B##GPGPYJJ???77?Y5PGGGGPPYYJJ?!7P5?!?~^^^^^^^^^^^~^^^^^^^^^^^^^^^^^^^^^^\n:^:^^^^::^^^^^^^^^^^^^^^^^^^^^^^^^^YJ?J57P57!!77???JJ5PP55PPYJJ??7!!7YPBGG##B555Y?!~J5??55^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^^^^^^^^^^^^:^^^^^^^^^:!JPGJ!YJ!!777??????JYY5YYJ???77~!!7J5P5PP5J?77!!!JJ7?P!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^?YYJ!JJ77!77777777?????77?777!~~!!!7JYYJJ?!!!~~~?5Y7!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^7J7?7?Y7!!!7777777777????7777!~~!!!!!!7!!!~~~~~~?JY!^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^:^^^:\n:^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^77777J7!!7777777777??????777!~~!!!!!!!!!!!!~~~!J77~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^:^:^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^~!7?7777!777777777??JJJ?7777!~~~!7!!!!!!!!!!!!7?~!~~~~^~^~^^^^^^^^^^^^~^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^~~~~~~~~~~~~~7777!!777777??JJY???7777!!!!7?7!!!!!!!!!!?7!^^^^^^^^^^^^^^^^^^^^^^^^^^^^:::^:::::::\n^^^^^^^^^:^^^^^^^^::::::::::^^^:^^^^:^^::^7777!!!7777????JJJY5Y?JJJYY?77?7!!!!!!!!!~~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n:::::^^:^^^^^^^^^^^^^^^^^^^^~^^^^^^^^^^^~~7777777777???????JJJJJYYJJ?7!!777!!!~!!!~:^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^~~^^^~^^^~7777777777??????????JJJ?7777!!!!7!!!!!!!GJ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^~^^~~~^^~~~^~77777777777?J5P5YYYYYYYJJJJ????J?77!777!5@@5~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^^^^^^^^^~^^~^~~~^^~~~~~~~~7YJ!77777777??JJ?JYYY5555P5YYYYYPPYJ?77777#@@&Y^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^~^^^^~^^~~~~~~~~~~^~~~~~~~?5PY!77??777????????JJYYYYYJJJJJ??JJJ??????#@@&B7^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^~^^^^^^^~~~~~~~~~~^^~~~~~~!55PB?777????7777?????JY55555YYJ???????????J#@@&#5J7~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^~^~~^~~~~~~~~~~!!!7!!!77JP55#GJ????JJJ?777777???JJYJ?77777777?JJJ??YB&&&&GJYY~~77!~~^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^^^^^^^~^~~^~~~~~~~~!!7??!7?!7!YP55#&PYJJ?JJJYYJ??7????????77!!!77JY5YJJJYP#&&&#PY5PJ!~~~!7!!~^^^^^^^^^^^^^^^^^^~^^^^^^\n^^^^^^~^^~^^~~^~~~~~~~~~~~!7???Y5J^!?5P55B&#G5YYYYYJJYYYYYYYYYYYYJJJJYY55YYJJY5PB###BG5Y5Y~~7!777!!!!!~^^^^^^^^^^^^^^^^^^^^^^\n^^^^^^^~~~~^~~^~~!!77?JY5P5?!^~!!7YB&GPP5G&&#BP555YYYYJJYYYYY5555555P555YYYY5PPGBBGGPPP5P57^::~JP5YJ??7!!!~~~^^^^^^^^^^^^^^^^\n^~~^~~~^~~~~~~~~!!7????7!^^~?Y5GBBPB##GPPP#&&#BGPP5555YY55YYYY555555555555PGGBBBGGGGGPPPGPPP5J!:^^^^^^~~~~~~~~~^^^^^^^^^^^^^^\n~^^^~~~^~~~~~~!!!~~^^~!7JY5G#BPG#BGGPPPGGGGB###BBBGPPP5555P55555555555P5PPGGGGGGGGGGGGG5P5PPPPGP55YYJ7~^::^^^^::::^^^^^^^^^^^\n~^~~~~~~!!!!~~^^~!?Y5PGBGPPBBBGGGPYYYPGBGGGGGBBBBBBGGGGGGPJJPPPPPPPPPY?PPGGGGPPGGGGGGGGY?JYJYPPPPPGBBGP5YJ7!~~~~~~^^^^^^^^^^^\n~^~~~!!!!~^^!?Y5PGBBGGGBGPPP555555PGGGBGBBBBBBGGGGGBBBBBBBJ~JPPPPPPPGJ7GPGGGGPPPGGGGGGPPGPYJ??JJY5GGGGPPPPPPP5J?!~~!!!~^^^^^^\n^~!7!~~~7J5PGGGGGGGGGPP5YYY55PGGGGGGGGGGBBBBBBBBBGGBBBBBB#5~JGGGGGGGGJ!GGGGGGGGGGGBBP5PPPPPP55YJJJJJYY555PPPPPPGGPJ!^^^~!~^^:\n?7~^!?5PPGGGGGPPPP5YYYY5PPPGGGBBGGGGPGGGBBBBGBGBBBBBBBBBBB5~YBBBBGGGGP~PGBBGGGGBBBGPPP5P5PGP55555PPP5YJ???JY5PPGGGPP5J7~^:^~!\n^~?5PPPPPGGP5YJJJY5PGGGGGGGPGGGGGGGGGBBGGGBBGB#BBBBBBBBBBBP^?BBBBBGBBG~PGBBGBBBBBPPPP55PP5PPPPPP5PGGGPP55YYJ???Y555PP555YJ!^:\nY5PPPPP5YYJJJY5PPPGGGGGGGGGGGGGGGGGGGBBGGGGGGG#&#BBBBBBBBBG~~BBBBBGGGP~GGBBBBBGGP5PPP5YPPPPPPP555PGGPPPP5PPPPP5YJJ??JJYYYYYYJ\n5555YJ??JY5PGGGGGPPGGGGGGGGGGGGGGGGGGBBGGGGGPGG####BBBBBBGB!:PGGBBGGB?7BGGBGGGGGPPPPP555PPPP55555PGPPPPPPPPPPPGGGGG5YJ77?JYYY\nPYJ?JY5PGGGGGGGGGPPPGGGGGGGGGGGGGGPGBBGGGGGGPPGGB###BBBBGGB?:YGGGBBBP^5BGGGGBGGPPPPP55555PPPPP5P5PPPPPPGPPPPPPPPGBBGPPPPJ77JY\nJ?YPPPPGGGGGGGGPPPPPGGGGGGGGGGGGGPPGGGGGGGPPPPPGGBB##BBGGGB5:?BGGBBP^?BGGBBGGPPPPPPP55555PPPPP5PPPPPP5PPPPPPP5PPGBBGPPGBBGY77\nJPBGPPPGGGGGGGPPPPPPGGGGGGGGGGGGGPPGGGGGGGPPPPPPPPGGBBBBGGGG~^G###Y^?BBBBGGPPPPPPPP5555555PPPP555PP55555PPPP5PPGGBBGPPBBBGG5\nPGBGPPPGGGGGPPPPPPPPPGGGGGGGGGPPPPPGGGGGPPPPPPPP55PPPGBBBBGBY:?@&J:JBBGGPPPPPPPPPP555555555PPPP555PP55555555PGGGGGBGPPBBBGPP5\nBBBGPPPPGGGPPPPPPPPPPPPPGGGGPPPPPPPPPPPPPPPPPPPP5555PPPGGBBGG!?GG~?BGPPPPPPPPPP5555555555555PPPP55PP555555PPPGPPGGBGPPBBBGGPP\nGBBBPPPPGGGPPGPPPPPPPPPGGGPPPPPPPPPPPPPPPPPPPPPP555555555PPGGPJB57GPPPPPPGPP55555555555555Y55PPPP55PP5555PPPPPPPGGGGPPB##BGPG\nGGBBPPPPGGPPPGPPPPPPPPPGPPPPPPPPPPPPPPPPPPPPPPPPP55555PPP55PGPJB?!GGGGGGPPPPP5555555555555YY5555P55PPP55PPPPPPPPPGGGPGB##BPPB\nBGGGPPPPGGPPPPPPGPPPPPPPPPPPPPPPPPPPPPPP55PPPPPPP555555PPPPPGGB&7!GPGGGGGPGGGPP55555555555YY555YY55PPPP55PGPP55PPGGPPG###GPGB\nBGGGPPPPPPPPPPPGP55PPPPPPPPPPPPPPPPPP5555P5PPPPPPP55555555PPPGGG~~PPPGGBGGGGPPP555Y55555555Y55P55YY55PP5Y5GGPP55PPPPPB#&BGPGB\nBBGGPPPPPPPPPPPP55PPPPPPPPP5PPPPPPPPP5PP55PPPPPPPP55555555PP5P^:.^P5555PPGGGPPP5YYY5J?Y5555YY55555YYY5PPY5PGGPPPPPPPPB&#BGPBB\nBBBBGPPPPGGPPPPP5PPPPPPPPPPPP5PPPPPPPP5Y~:?PPPPPPPPP555555555P~..^PPPP555PPPPPPGPJ?7!JJ5P555Y5555PPP5YY55YPPGGGPPP5PP#&#GBGBB\nB#BBGPPPGGPPGGGP5PPPPPPPPPPPPPPPPPPP5J^:7^.75PPPPPPPP55555555P!.::5P555555PPPPP5YGJ~?YY55555555PPPPGGP555Y5PGGGGPPP5G&&BB#BB#\nBBBBBGPPGPGGBG55PPPPPGPPPPPPPPPPP55?~!7^~!~~?Y5PPPPPPP5555555P7.:.YP555555PPPPPPJ5YY??J?J?YY55YY5555GGP5YY5PGGGGPP55#&#B#BB#&\nGGBBBBPPPGGGP5PPGPPPPGGPPPPPPPPPPY!!7!~!7~!7!~7PPPPPP5PPPP555P7.:.YP555555PPPP5PPJJ?!^!!!!~!!7!!!!!JPGGP5YYPPGGGPP5G&#B#BBB#B\nBBGBB#BPPGGPPGBGPPPPPGGGPPPPPPPPPP555YY55Y55555PPPPPPPPPPPPPPP?.:.JP555555PPPPPPPYJJJ?!?7??7777!7~?YPGGGP5Y5PGGGGPP&&B#BGB#BG\n##BBBB#GPGGBBBGP5PGPPGGGPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP55P55PJ.:.?PPPP5Y5PPPP5PPPP555PJ?JYJYYJJYJ55PGBBBG5Y5GGGGP#&#B#GB#BBB\nBB##BBB#GGBBGP55PGGGGPGGPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP5555PY.:.7GPGGP555PPP55PGGPPPP5555YY5YYY5PP5PPGBBG5YPGBGG&#B#B##BBBB\nBBB#&#BB#GGP5555PGGGGPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP5::.!GPGGPP55PPP55PGGGPPPGGPPPPPPGGGGPPPPPGBBG5YPGP#&#####BB###");
      wait(7);
      // clear screen
      typewriter("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 0.0125, false);
      wait(1);
    }

    // Execute options
    if (EnteredValue.equals("0")){
      sc.reset();
      // Start game with Explanation
      intro = new Explanation();
      initialResources = intro.giveContext();
      // Enter Gameplay Loop with Gameplay
      anger = (double) genRandom(20,45);
      Gameplay looper = new Gameplay(initialResources, anger);
      won = looper.executeLoop();
      // End the game
      ending = new End();
      ending.endGame(won);
    }else if (EnteredValue.equals("1")){
      // save file continue
    }else if (EnteredValue.equals("2")){
      // enter creator codes
    }else{
      print("You should not be seeing this. Please fix ASAP. Frank, get better.");
    }
    // Denote end of cycle
    print("-- End of cycle --");
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
  // RNG machine (for a random number generator)
  private static int genRandom(int range, int min){
    int value = (int)(Math.random()*range)+min;
    return value;
  }
}
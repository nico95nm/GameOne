/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.Scanner;

public class App {
    Scanner scan = new Scanner(System.in);
    Scanner scanOne = new Scanner(System.in);
    String playerName;
    String playerWeapon;
    String potion;
    int playerHP;
    int goblinHP;
    int choice;
    int playerCoin;
    int innkeeperCoin;
    int legendaryRing;

    public static void main(String[] args) {

        App app;
        // With this you can choose what method you will call first or in what order!
        app = new App();
        app.playerInfo();
        app.room();

    }

    public void info() {

    }

    public void playerInfo() {
        // ----------------
        playerHP = 25;
        playerCoin = 10;
        playerWeapon = "Knife";
        innkeeperCoin = 10;
        potion = "";
        goblinHP = 20;
        // ----------------
        // ----------------
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Welcome adventurer to this world please choose a name: ");
        playerName = scan.nextLine();
        System.out.println();

        System.out.println("Player stats:");
        System.out.println("");
        System.out.println("Player Name: " + playerName + "\nPlayer current health " + playerHP
                + "\nPlayer current coin: " + playerCoin
                + "\nPlayer current weapon: " + playerWeapon);
        // ----------------
    }

    public void room() {

        System.out.println(
                "\nYou are located in Inn, in the letter that u received form your brother say that, there is a rumor, that there is one ring that it has Legendary Power, and you need to find it!\n");
        System.out.println(
                playerName
                        + ": Hmmm.... Maybe I should ask Innkeeper if he heard anything about the legendary ring.\n");
        System.out.println("Press 1 to proceed ");
        choice = scan.nextInt();
        if (choice == 1) {
            inn();
        } else {
            room();
        }

    }

    public void inn() {
        System.out.println("\n----------------------------------------------------------------");

        System.out.println("You go to the Innkeeper\n");
        System.out.println("----------------------------------------------------------------\n");
        System.out.println("Innkeeper: Greetings stranger how can I help you today?\n");
        // Player asks about legendary ring (Option 1)
        // Leads to innkeeper revealing information (if chosen) [-]
        System.out.println("1. Can I ask you question about legendary ring?");
        // Innkeeper vendor not ready, tomorrow I need to work in on it! [-]
        System.out.println("2. Can I buy something from you?");
        // Leave option, easy to make so ill implemented after I finish vendor feature!
        // [-]
        System.out.println("3. Leave");
        System.out.println("----------------------------------------------------------------\n");

        choice = scan.nextInt();

        System.out.println("\n----------------------------------------------------------------");
        if (choice == 1) {
            System.out.println(
                    "Sure! So you also heard about that rumor, lets not say out laud!\nIt is located in the crossroad on right road that leads to big forest");
            System.out.println(playerName + ": Ah I see thank you!");
            inn();
            System.out.println("----------------------------------------------------------------");
        } else if (choice == 2) {
            System.out.println("Sure, I have health potion!");
            System.out.println("Innkeeper has " + innkeeperCoin + " coins.");

            System.out.println("1. Health Potion (It can heal you for 5 health.)");
            System.out.println("Health Potion cost 10 coin;");

            System.out.println("2. Leave");
            choice = scan.nextInt();

            if (choice == 1) {
                potion = "Health Potion";
                playerCoin -= 10; // Deduct player's coin
                innkeeperCoin += 10; // Increase innkeeper's coin
                potion = "Health Potion";

                System.out.println("Innkeeper: " + innkeeperCoin);
                System.out.println("Player: " + playerCoin);
                System.out.println("You bought item " + potion);
                inn();
            } else {
                inn();
            }
        } else if (choice == 3) {
            townGate();
        } else {
            inn();
        }

    }

    /*
     * Town gate area that guard giving you direction and reason why you need to
     * find a Legendary ring [-]
     */

    public void townGate() {
        System.out.println(
                "Guard: Hold! Where are you going citizen, roads are dangerous these days? I shall not let you pass you!\n");
        System.out.println(
                playerName
                        + ": I am an adventurer and hearing rumor about Legendary Ring to retrieve it for the king.\nCan you please direct me the location of the Legendary Ring?");
        System.out.println("");
        System.out.println(
                "Guard: I see if that is the case the rumors are true the king lost his Legendary Ring while he was hunting. Some scouts have seen goblin wearing the ring on the neck, king have send some warriors to retrieve it but non returned. I wish you luck retrieving it, you will need it. But go to the Crossway not far from here, and from there and you wanna go to the east, its a big forest\n");
        System.out.println("1. Go to the Crossroad");
        System.out.println("2. Go to the Castle");
        System.out.println("");
        choice = scan.nextInt();
        if (choice == 1) {
            crossRoad();
        } else if (choice == 2) {
            if (legendaryRing == 1) {

                end();
            } else {
                System.out.println("You dont have a ring!");
                System.out.println("\n----------------------------------------------------------------");
                townGate();
            }
        }
    }

    // Crossroad ready, player can choose which why can go[-]
    public void crossRoad() {
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("You are located in the crossroad please choose direction\n");
        System.out.println(
                "There is a sign located on each directions:\n North: River a head\n East: A mysteries cave\n West: Forest\n South: Castle\n");
        System.out.println("1. North");
        System.out.println("2. West");
        System.out.println("3. East");
        System.out.println("4. South");
        System.out.println("");

        choice = scan.nextInt();

        if (choice == 1) {
            System.out.println();
            north();
        } else if (choice == 2) {
            west();
        } else if (choice == 3) {
            east();
        } else if (choice == 4) {
            townGate();
        } else {
            crossRoad();
        }

    }

    /*
     * North path done [-]
     * A feature that player can come here and rest and heal them self without
     * knowing.[-]
     */
    public void north() {
        // River location
        System.out.println("Location: North");
        System.out.println("You see the river and you wanted to have a rest and you feel thirsty.");
        System.out.println(
                "You drank water from the river, and you felt that you instantly get rested and something magical that you cant explain.");
        if (playerHP < 45) {
            playerHP = playerHP + 5;
            System.out.println("You restore your health by 5 points. " + playerHP);
        } else if (playerHP > 45) {
            System.out.println("Your health is maxed. " + playerHP);
        }
        System.out.println("");
        System.out.println("Now that you feel rested, better go back to the crossroad.\n");
        System.out.println("1. Back to crossroad");
        choice = scan.nextInt();
        if (choice == 1) {
            crossRoad();
        } else {
            north();
        }
    }
    // -------------------------------------

    /* Combat I will do the last main feature[-] */
    public void west() {
        // Forest
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("You are in the forest and you see goblin wearing Legendary Ring as an amulet.\n");
        System.out.println("You encounter goblin. Goblin sees you and say.\nGoblin: You no take my loot!\n");

        System.out.println("1. Attack the goblin.");
        System.out.println("2. Run.");
        choice = scan.nextInt();
        if (choice == 1) {
            fight();
        } else if (choice == 2) {
            crossRoad();
        } else {
            west();
        }
    }

    // -------------------------------------
    public void fight() {
        System.out.println("\n-----------------------");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1. Fight.");
        System.out.println("2. Run");
        System.out.println("\n-----------------------");

        choice = scanOne.nextInt();
        if (choice == 1) {
            attack();
        }
        if (choice == 1) {
            crossRoad();
        } else {
            west();
        }
    }

    public void monster() {
    }
    // -------------------------------------

    /* This method is for combat feature [] */
    public void attack() {

        // Creating Integer function with variable playerDamage
        int playerDamage = 0;
        // int weaponDamage;
        if (playerWeapon.equals("Knife")) {
            // weaponDamage = 5;
            playerDamage = new java.util.Random().nextInt(5);
        }
        if (playerWeapon.equals("Excalibur")) {
            // weaponDamage = 8;
            playerDamage = new java.util.Random().nextInt(8);
        }
        // --------------------

        // This function will choose random number between 0 - 9
        // playerDamage = new java.util.Random().nextInt();
        System.out.println("You attacked the goblin and deal " + playerDamage + " amount of damage!");

        goblinHP = goblinHP - playerDamage;
        System.out.println("Goblin HP: " + goblinHP);
        if (goblinHP < 1) {
            win();
        }
        if (goblinHP > 0) {
            int monsterDamage = 0;
            // --------------------
            monsterDamage = new java.util.Random().nextInt(4);
            // monsterDamage = new java.util.Random().nextInt(monsterDamage);
            System.out.println("Goblin attacked you, and deal " + monsterDamage + " amount of damage!");
            // --------------------
            playerHP = playerHP - monsterDamage;

            System.out.println("Player HP: " + playerHP);

            if (playerHP < 1) {
                dead();
            } else if (playerHP > 0) {
                fight();
            }
        }

    }

    public void dead() {
        System.out.println("\n-----------------------");
        System.out.println("\nGAME OVER!");
        System.out.println("\n-----------------------");
        playerInfo();
    }

    public void win() {
        System.out.println("");
        System.out.println(
                "You defeated the goblin! and now you get Legendary Ring from goblin,\ntime to back to the Castle.");

        end();
    }

    /*
     * Cave that have powerful sword
     * Challange is player need to answer the question if he does he will get a
     * powerful sword [-]
     */
    public void east() {
        // Cave
        System.out.println("You are in the mysteries cave, you see sword in the stone.\n");
        System.out.println(
                "You touched the sword, want to pull sword out from the stone, but you hear noise that come from sword. Ah an adventure. I have one challange for you, answer me this and you will be able to pull the sword and wield this Legendary Sword. If you don't answer correctly you wont be able to pull the sword making you unworthy.");
        System.out.println("");
        System.out.println("1. Accept the challange.");
        System.out.println("2. Leave.");
        choice = scan.nextInt();

        if (choice == 1) {
            System.out.println(
                    "Ha, good, good!! So you like some challange. But be wary adventurer, accepting this challange if you fail you may never come to this place again!");
            challange();
            System.out.println("\n----------------------------------------------------------------");
        } else if (choice == 2) {
            crossRoad();
        }
    }

    public void challange() {
        System.out.println(
                "I have a hilt, but no door.\nI have a blade, but cannot soar.\nDragons fear me\nknights hold me dear.\nSpeak my punny name, and I shall appear.\nWhat am I?\n");
        String correctAnswer = "Excalibur";

        // Scanner scanOne = new Scanner(System.in);
        String answer = scanOne.nextLine();
        if (answer.equalsIgnoreCase(correctAnswer)) {
            playerWeapon = "Excalibur";
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("Congratulations! You are worthy to wield " + playerWeapon);
            System.out.println("\n----------------------------------------");
            System.out.println("You may leave the cave now!");
            System.out.println("(Press any button to continue to leave a cave)");
            choice = scan.nextInt();
            if (choice == 1) {
                crossRoad();
            } else {
                crossRoad();
            }
        } else {
            System.out.println("You have failed!");
        }
    }

    public void South() {
    }

    public void end() {
        System.out.println("Good job adventurer for bringing me back my powerful ring!");

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("You defeated the game congratulations!");
        System.out.println("The End");
        System.out.println("\n----------------------------------------------------------------");
    }

}

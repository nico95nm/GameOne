/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.Scanner;

public class App {
    Scanner scan = new Scanner(System.in);
    String playerName;
    String playerWeapon;
    String potion = "";
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
        playerHP = 50;
        playerCoin = 10;
        playerWeapon = "Knife";
        innkeeperCoin = 10;
        potion = "";
        // ----------------

        // ----------------
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Welcome adventurer to this world please choose a name: ");
        playerName = scan.nextLine();
        System.out.println();

        System.out.println("Player stats:");

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

    // Finish this area []
    public void townGate() {
        System.out.println("Guard: Hold! Where are you going citizen, roads are dangerous these days?");
        System.out.println(
                playerName
                        + " I am an adventurer and I want to retrieve legendary ring. Can you please direct me the location of that?");
        System.out.println("2. ");
        System.out.println("");
        System.out.println("");
    }
}

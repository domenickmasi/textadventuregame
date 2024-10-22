import java.util.Scanner;

public class TextAdventure {
    FancyConsole console;
    Scanner inScanner;
    Player ourHero;

    public TextAdventure() {
        console = new FancyConsole("Great Text Adventure!", 600, 600);
        inScanner = new Scanner(System.in);
        ourHero = new Player("Bob", 100, 0); // Starting values for the player
    }

    public void play() {
        console.setImage("distantcity.jpg");

        System.out.println("What is your name?");
        String input = inScanner.nextLine();
        ourHero.changeName(input);

        while (true) {
            System.out.println("You wake up to find yourself on the edge of a shadowy forest with the sun nearly set. "
                + "\nYou see what looks like a city in the distance. "
                + "\nWhat would you like to do? "
                + "\ncity: go towards the city"
                + "\nforest: turn around and re-enter the forest"
                + "\nnap: go back to sleep\n" + ourHero.getName() + ": ");
            
            input = inScanner.nextLine();
            if (input.equalsIgnoreCase("city")) {
                enterCity();
            } else if (input.equalsIgnoreCase("forest")) {
                enterForest();
            } else if (input.equalsIgnoreCase("nap")) {
                endGame();
                return; // End the game when the player chooses to nap
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void enterCity() {
        console.setImage("city.jpg");
        while (true) {
            System.out.println("You've arrived at a bustling city full of life. "
                + "\nYou can explore the city or visit the tavern. "
                + "\nWhat would you like to do? "
                + "\nexplore: explore the city"
                + "\nvisit: go to the tavern"
                + "\nflee: flee back to the start\n" + ourHero.getName() + ": ");
            
            String input = inScanner.nextLine();
            if (input.equalsIgnoreCase("explore")) {
                findTreasure();
            } else if (input.equalsIgnoreCase("visit")) {
                meetStranger();
            } else if (input.equalsIgnoreCase("flee")) {
                return; // Flee back to the start
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void enterForest() {
        console.setImage("forest.png");
        while (true) {
            System.out.println("You are back in the forest. It's dark and eerie. "
                + "\nYou can either go deeper into the forest, enter a cave, or return to the city. "
                + "\nWhat would you like to do? "
                + "\ndeep: go deeper\ncave: enter the cave\nflee: flee back to the start\n" + ourHero.getName() + ": ");
            
            String input = inScanner.nextLine();
            if (input.equalsIgnoreCase("deep")) {
                battleBeast();
            } else if (input.equalsIgnoreCase("cave")) {
                enterCave();
            } else if (input.equalsIgnoreCase("flee")) {
                return; // Flee back to the start
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void findTreasure() {
        console.setImage("treasure.jpg");
        System.out.println("You find a treasure chest! It contains 200 gold!");
        ourHero.setGold(ourHero.getGold() + 200);
        return; // Go back to the previous location (city)
    }

    private void meetStranger() {
        console.setImage("tavern.jpg");
        System.out.println("You meet a mysterious stranger who offers you a quest.");
        // Proceed with quest-related logic...
        return; // Go back to the previous location (city)
    }

    private void battleBeast() {
        console.setImage("forestbattle.jpg");
        System.out.println("You encounter a wild beast! Prepare for battle!");
        ourHero.fightMonster();

        // Check if health is greater than 0
        if (ourHero.getHealth() > 0) {
            System.out.println("You defeated the monster! Total monsters defeated: " + ourHero.getMonstersDefeated());
            return; // Go back to the previous location (forest)
        } else {
            System.out.println("You have died in battle.");
            endGame();
        }
    }

    private void enterCave() {
        console.setImage("cave.jpg");
        System.out.println("You enter the dark cave. It's cold and damp, and you feel a sense of dread. "
            + "\nYou can go deeper into the cave or turn back to the forest. "
            + "\nWhat would you like to do? "
            + "\ndeep: go deeper\nturn: turn back\n" + ourHero.getName() + ": ");
        
        String input = inScanner.nextLine();
        if (input.equalsIgnoreCase("deep")) {
            System.out.println("You venture too deep into the cave and find yourself lost forever...");
            endGame();
        } else if (input.equalsIgnoreCase("turn")) {
            enterForest(); // Return to the forest
        } else {
            System.out.println("Invalid choice. Try again.");
            enterCave(); // Repeat cave options
        }
    }

    private void endGame() {
        System.out.println("Thank you for playing! You finished with " + ourHero.getGold() + " gold and defeated " + ourHero.getMonstersDefeated() + " monsters.");
        inScanner.close();
    }

    public static void main(String[] args) {
        TextAdventure game = new TextAdventure();
        game.play();
    }
}

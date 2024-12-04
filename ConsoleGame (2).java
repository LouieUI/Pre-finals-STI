import java.util.Scanner;


public class ConsoleGame {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Adventure Game!");
            game.chooseCharacter();

            while (true) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Gather Resources");
                System.out.println("2. Check Status");
                System.out.println("3. Progress Story");
                System.out.println("4. Exit Game");
                System.out.print("Choose an option: ");
                
               
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
                int choice = scanner.nextInt();

               
                switch (choice) {
                    case 1: 
                        game.gatherResources();
                        break;
                    case 2: 
                        game.checkStatus();
                        break;
                    case 3: 
                        game.progressStory();
                        break;
                    case 4: 
                        System.out.println("Thanks for playing! Goodbye.");
                        return;
                    default: 
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            
            game.closeScanner();
            scanner.close();
        }
    }
}


interface Character {
    void chooseCharacter();
}


interface Survival {
    void gatherResources();
    void checkStatus();
}


interface Story {
    void progressStory();
}


class Game implements Character, Survival, Story {
    private String characterName;
    private int food = 5;
    private int health = 100;
    private int progress = 0;
    private Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    
    @Override
    public void chooseCharacter() {
        System.out.print("Enter your name: ");
        characterName = scanner.nextLine();
        System.out.println("Welcome! " + characterName + "! Your journey begins now.");
    }

    
    @Override
    public void gatherResources() {
        System.out.println(characterName + " is gathering resources...");
        food += 3;
        health -= 10; 
        
       
        if (health <= 0) {
            System.out.println("Your health has reached 0. Game Over!");
            System.exit(0);
        }

        System.out.println("You collected 3 food! Current food: " + food);
        System.out.println("Your health decreased slightly. Current health: " + health);
    }

    @Override
    public void checkStatus() {
        System.out.println("\n--- Current Status ---");
        System.out.println("Character: " + characterName);
        System.out.println("Health: " + health);
        System.out.println("Food: " + food);
        System.out.println("Progress: " + progress + "%");
        System.out.println("-----------------------\n");
    }

    
    @Override
    public void progressStory() {
        if (food >= 2) {
            System.out.println("You have enough food to continue your journey.");
            food -= 2;
            progress += 25;
            System.out.println("The story progresses... Current progress: " + progress + "%");
        } else {
            System.out.println("Not enough food to proceed. Gather resources first!");
        }

        if (progress >= 100) {
            System.out.println("____________________________________________________");
            System.out.println(" ");
            System.out.println("Congratulations! You have completed your adventure!");
            System.out.println("____________________________________________________");
            System.exit(0);
        }
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
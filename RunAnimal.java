import java.util.Scanner;

public class RunAnimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an animal (b for Bird, c for Cat, d for Dog):");
        String userInput = scanner.nextLine().toLowerCase();
        
        Animal animal = null;
        
        switch (userInput) {
            case "b":
                animal = new Bird();
                break;
            case "c":
                animal = new Cat();
                break;
            case "d":
                animal = new Dog();
                break;
            default:
                System.out.println("Unknown animal.");
                System.exit(0);
        }
        
        String animalName = userInput.equals("b") ? "Bird" : 
                            userInput.equals("c") ? "Cat" : "Dog";
        
        System.out.println("Animal selected: " + animalName);
        animal.eat();
        animal.sleep();
        animal.makeSound();
        
        scanner.close();
    }
}

abstract class Animal {
    abstract void sleep();
    abstract void eat();
    abstract void makeSound();
}

class Bird extends Animal {
    @Override
    void sleep() {
        System.out.println("Birds love to sleep 10-12 hours a day");
    }
    @Override
    void eat() {
        System.out.println("Birds eat seeds");
    }
    @Override
    void makeSound() {
        System.out.println("Chirp Chirp");
    }
}

class Cat extends Animal {
    @Override
    void sleep() {
        System.out.println("Cats love to sleep all day");
    }
    @Override
    void eat() {
        System.out.println("Cats eat fish");
    }
    @Override
    void makeSound() {
        System.out.println("Meow Meow");
    }
}

class Dog extends Animal {
    @Override
    void sleep() {
        System.out.println("Dogs love to sleep 5-6 hours a day");
    }
    @Override
    void eat() {
        System.out.println("Dogs eat meat");
    }
    @Override
    void makeSound() {
        System.out.println("Arf Arf");
    }
}
import java.util.Scanner;


public class RunAnimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an animal (Bird, Cat, Dog):");
        String userInput = scanner.nextLine();

        Animal animal = null;

        if (userInput.equalsIgnoreCase("Bird")) {
            animal = new Bird();
        } else if (userInput.equalsIgnoreCase("Cat")) {
            animal = new Cat();
        } else if (userInput.equalsIgnoreCase("Dog")) {
            animal = new Dog();
        } else {
            System.out.println("Unknown animal.");
            System.exit(0);
        }

        System.out.println("Animal selected: " + userInput);
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

// Superclass
class Animal {
    void makeSound() {
    System.out.println("Some generic sound");
    }
    }

    // Subclass
    class Dog extends Animal {
    //@Override
    void makeSound() {
    System.out.println("Woof! Woof!");
    }
    }

public class superclass {
    public static void main(String[] args)
    {
        Animal animal = new Dog();
        animal.makeSound();
    }
}

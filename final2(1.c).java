// Abstract class
abstract class Animal {
    // Instance variables
    int s;
    int[] sta = new int[5];

    // Constructor
    public Animal() {
        s = 0;
    }

    // Abstract method
    abstract void makeSound();

    // Regular method
    void print() {
      
            System.out.println("This is the popped element " + this.sta[s]);
      
            //System.out.println("No element to pop at index " + (s + 1));
        
    }
}

// Subclass (inherits from Animal)
class Mod extends Animal {
    // Implementing the abstract method
    @Override
    void makeSound() {
        if (s > 0) {
            s--;
        } else {
            System.out.println("Cannot decrement, stack pointer is at zero");
        }
    }

    void makeSound(int n) {
        if (s < sta.length) {
            sta[s] = n;
            System.out.println(sta[s]);
            s++;
        } else {
            System.out.println("Stack overflow, cannot add more elements");
        }
    }
}

public class Hello {
    public static void main(String[] args) {
        // Instantiate subclass
        Mod modInstance = new Mod();

        // Add elements
        modInstance.makeSound(10);
        modInstance.makeSound(20);

        // Print elements
       // modInstance.print();

        // Remove an element
        modInstance.makeSound();

        // Print elements again
        modInstance.print();
    }
}

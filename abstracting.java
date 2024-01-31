// Abstract class
abstract class Shape {
    int x, y;

    // Abstract method
    abstract void draw();

    // Concrete method to move the shape
    void move(int newX, int newY) {
        x = newX;
        y = newY;
        System.out.println("Shape moved to (" + x + ", " + y + ")");
    }
}

// Concrete subclass
class Circle extends Shape {
    int radius;

    // Implementation of the abstract method
    void draw() {
        System.out.println("Drawing a circle at (" + x + ", " + y + ") with radius " + radius);
    }
}


public class abstracting{
    public static void main(String[] args)
    {
        // Create a Circle object
        Circle circle = new Circle();
        
        // Set the position and radius of the circle
        circle.x = 10;
        circle.y = 20;
        circle.radius = 5;
        
        // Draw the circle
        circle.draw();
        
        // Move the circle to a new position
        circle.move(15, 25);
        
        // Draw the circle again after moving
        circle.draw();
    }
    
}

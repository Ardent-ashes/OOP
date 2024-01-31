// Interface
interface Drawable {
    void draw();
    }
    // Concrete class implementing the interface
    class Rectangle implements Drawable {
    int width, height;
    // Implementation of the interface method
    public void draw() {
    System.out.println("Drawing a rectangle with width " + width + " and height " + height);
    }
    }

public class interfacing {
    public static void main(String[] args) {
        // Create a Rectangle object
        Rectangle rectangle = new Rectangle();
        
        // Set the dimensions of the rectangle
        rectangle.width = 10;
        rectangle.height = 5;
        
        
        // Draw the rectangle
        rectangle.draw();
    }
}

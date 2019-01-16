

public class Circle implements Shape {
    private int ID;
    private int radius;
    private String color;

    public Circle() {
        ID = 0;
        radius = 0;
        color = "Null";
    }

    public Circle(int i, int r, String c) {
        ID =  i;
        radius = r;
        color = c;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getArea() {
        return 3.14159 * (radius * radius);
    }

    public double getCircumference() {
        return 2 * 3.14159 * radius;
    }


    public String toString() {
        return String.format("Circle (ID# %d)", this.getID());
    }

    @Override
    public String getKind() {
         return "Circle";
    }

    @Override
    public String getDetailString() {
        return String.format("Circle (ID# %d)\n Color: %s\n Radius: %d\n Area: %f\n Circumference: %f", this.getID(), this.getColor(), this.getRadius(), this.getArea(), this.getCircumference());
    }

    @Override
    public int getID() {
        return ID;
    }
}

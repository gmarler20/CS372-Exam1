

public class Triangle implements Shape {

    public Triangle() {
        ID = 0;
        side1 = 0;
        side2 = 0;
        side3 = 0;
        color = "null";
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getSide3() {
        return side3;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        int s = side1 + side2 + side3;

        return Math.sqrt(s *(s - side1)*(s - side2)*(s - side3));
    }

    public int getPerimeter() {
        return side1 + side2 + side3;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private int ID;
    private int side1;
    private int side2;
    private int side3;
    private String color;

    Triangle(int i, int s1, int s2, int s3, String c) {
        ID = i;
        side1 = s1;
        side2 = s2;
        side3 = s3;
        color = c;
    }

    public String toString() {
        return String.format("Triangle (ID# %d", this.getID());
    }

    @Override
    public String getKind() {
        return "Triangle";
    }

    @Override
    public String getDetailString() {
        return String.format("Triangle (ID# %d)\n Color: %s\n Side1: %d\n Side2: %d\n Side3: %d\n Area: %f\n Perimeter: %d", this.getID(), this.getColor(),
                this.getSide1(), this.getSide2(), this.getSide3(), this.getArea(), this.getPerimeter());
    }

    @Override
    public int getID() {
        return ID;
    }
}

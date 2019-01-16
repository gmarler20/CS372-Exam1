public class Rectangle implements Shape {
    private int ID;
    private int length;
    private int width;
    private String color;

    public Rectangle() {
        ID = 0;
        length = 0;
        width = 0;
        color = "";
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 *(length + width);
    }


    public Rectangle(int i, int l, int w, String c) {
        ID = i;
        length = l;
        width = w;
        color = c;
    }

    public String toString() {
        return String.format("Rectangle (ID# %d)", this.getID());
    }

    @Override
    public String getKind() {
        return "Rectangle";
    }

    @Override
    public String getDetailString() {
        return String.format("Rectangle (ID# %d)\n Color: %s\n Length: %d\n Width: %d\n Area: %d\n Perimeter: %d",
                this.getID(), this.getColor(), this.getLength(), this.getWidth(), this.getArea(), this.getPerimeter());
    }

    @Override
    public int getID() {
        return ID;
    }
}


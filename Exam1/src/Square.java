public class Square implements Shape {

   public Square() {
       ID = 0;
       side = 0;
       color = "null";
   }

    public  void setID(int ID) {
        this.ID = ID;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getArea() {
       return side * side;
    }

    public int getPerimeter() {
       return side * 4;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private int ID;
    private int side;
    private String color;

    public Square(int i, int s, String c) {
        ID = i;
        side = s;
        color = c;
    }

    public String toString() {
        return String.format("Square (ID# %d)", this.getID());
    }

    @Override
    public String getKind() {
        return "Square";
    }

    @Override
    public String getDetailString() {
        return String.format("Square (ID# %d)\n Color: %s\n Side: %d\n Area: %d\n Perimeter: %d", this.getID(), this.getColor(), this.getSide(), this.getArea(), this.getPerimeter());
    }

    @Override
    public int getID() {
        return ID;
    }
}

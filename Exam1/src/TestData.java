// Used to test the GUI. Please run this to test.
public class TestData {
    public static void main(String[] args) {
        ReadData a = new ReadData();
        ShapeGUI G = new ShapeGUI();

        G.Initialize(a.GetMap());

        System.out.println("Testing");
    }
    }


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ShapeGUI {
    private JFrame Frame;
    private JPanel panel1;
    private JPanel ViewPanel;
    private JTextArea ObjectText;
    private ImageIcon ImageSet;
    private HashMap<JButton, Shape> ObjectList = new HashMap<>();
    private ArrayList<Integer> KeyList = new ArrayList<>();
    private static final double BUTTONS_PER_LINE = 1;
    private static final double NUM_BUTTONS_LINES = 96;
    private static final int BUTTON_PADDING = 5;


    public ShapeGUI() {
        // This ShapeGUI is created and initialized in TestData.java

    }

    public void Initialize(HashMap<Integer, Shape> A) {

        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel2 = new JPanel();

        // Credit to the following link for helping me to understand how to correctly
        // use a box layout with buttons.
        // https://examples.javacodegeeks.com/desktop-java/swing/java-swing-boxlayout-example/
        BoxLayout boxlayout = new BoxLayout(panel2, BoxLayout.Y_AXIS);

        // Add the scrollpane to the panel
        JScrollPane scroll = new JScrollPane(panel2);

        panel2.setLayout(boxlayout);


        KeyList.addAll(A.keySet());                             // Take all the key values from the Array that is passed in with all the shapes.
                                                                // This will be used to create a new map called ObjectList which will be used inside our GUI
                                                                // to assign Shape Values to each button. The button will be the key and the object will be
                                                                // the value which will allow for easy click and display of vital information about each shape.
        for(int i = 0; i < A.size(); i++) {
            JButton btn = new JButton();
            ObjectList.put(btn, A.get(KeyList.get(i)));
            btn.setVisible(true);
            btn.setText(A.get(KeyList.get(i)).toString());        // Credit to this link for helping me understand how buttons work in scrollpanes.
            panel2.add(btn);                                     // https://stackoverflow.com/questions/29212703/whats-the-best-way-to-add-a-bunch-of-button-to-a-scrollpane
            btn.addActionListener(new ActionListener() {
                // When a button is clicked,
                // First check what kind and then set the image for the correct shape.
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(ObjectList.get(btn).getKind() == "Circle")
                    {
                        ImageSet = CirclePic();
                    }
                    if(ObjectList.get(btn).getKind() == "Square") {
                        ImageSet = SquarePic();
                    }
                    if(ObjectList.get(btn).getKind() == "Rectangle") {
                        ImageSet = RectanglePic();
                    }
                    if(ObjectList.get(btn).getKind() == "Triangle") {
                        ImageSet = TrianglePic();
                    }
                    // Then, output a JoptionPane with a message popup containing vital information and the correct picture.
                    JOptionPane.showMessageDialog(null, "You have clicked on " + ObjectList.get(btn).getDetailString(), "Shape Information", JOptionPane.INFORMATION_MESSAGE,
                            ImageSet);
                }
            });
        }

                                                        // Another link that was used to help my understanding of scrollpane, panel, and button relation.
        frame.getContentPane().add(scroll);             // http://www.java2s.com/Tutorials/Java/Swing_How_to/JScrollPane/Create_JPanel_filled_with_Buttons_inside_a_JScrollPane.htm
        frame.pack();
        frame.setVisible(true);




        frame.pack();
        frame.setVisible(true);


    }

    public ImageIcon CirclePic() {
        try {
            Toolkit toolkit1 = Toolkit.getDefaultToolkit();
            URL IMG1 = new URL("http://icons.iconarchive.com/icons/custom-icon-design/flatastic-6/256/Circle-icon.png");
            Image img = toolkit1.getImage(IMG1);
            ImageIcon CircleIcon = new ImageIcon(img);
            return CircleIcon;
        }catch(Exception e) {
            System.out.println("error with picture");
            return null;
        }

    }

    public ImageIcon SquarePic() {
        try {
            Toolkit toolkit2 = Toolkit.getDefaultToolkit();
            URL IMG2 = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwW6VWNYShEzdTModdvPnVkxfRIXFwOXDWOADB-_ZbU3e3-X0");
            Image img = toolkit2.getImage(IMG2);
            ImageIcon SquareIcon = new ImageIcon(img);
            return SquareIcon;
        } catch (Exception e) {
            System.out.println("error with picture");
            return null;
        }
    }

    public ImageIcon RectanglePic(){
            try{
                Toolkit toolkit3 = Toolkit.getDefaultToolkit();
                URL IMG3 = new URL("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/shape_rectangle.png");
                Image img = toolkit3.getImage(IMG3);
                ImageIcon RectangleIcon = new ImageIcon(img);
                return RectangleIcon;
            }catch(Exception e) {
                System.out.println("error with picture");
                return null;
            }
        }

     public ImageIcon TrianglePic() {
         try{
             Toolkit toolkit4 = Toolkit.getDefaultToolkit();
             URL IMG4 = new URL("https://d1nhio0ox7pgb.cloudfront.net/_img/i_collection_png/256x256/plain/shape_triangle.png");
             Image img = toolkit4.getImage(IMG4);
             ImageIcon TriangleIcon = new ImageIcon(img);
             return TriangleIcon;
         }catch(Exception e) {
             System.out.println("error with picture");
             return null;
         }
     }
}





// SCRATCH WORK: Other ideas that didn't work but were tried.

 /*
        int x =1;
        int y =96;
        JPanel panel = new JPanel();
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        KeyList.addAll(A.keySet());
        panel.setLayout(new GridLayout(x, y));
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));



        container.add(panel);
        JScrollPane scrollpane = new JScrollPane(container);
        frame.getContentPane().add(scrollpane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);





       /* frame.add(ListPanel);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(BUTTON_PADDING));
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);

        for (int i = 0; i < KeyList.size(); i++) {
                for(int c = 0; c < BUTTONS_PER_LINE; c++) {
                    Button btn = new Button();
                    ObjectList.put(btn, A.get(KeyList.get(i)));                     // https://stackoverflow.com/questions/29212703/whats-the-best-way-to-add-a-bunch-of-button-to-a-scrollpane
                    btn.setVisible(true);
                    btn.setText(A.get(KeyList.get(i)).toString());
                    grid.add(btn, c, i);
                }

        }
ScrollPane scrollpane = new ScrollPane(grid);

        ListPanel.add(scrollpane)
        /*DefaultListModel listModel = new DefaultListModel();





*/


       /*
        KeyList.addAll(A.keySet());


        list1 = new JList(listModel);
    JScrollPane scroll = new JScrollPane(list1);
    ListPanel.setLayout(new GridBagLayout());
    ListPanel.add(scroll);

*/ /* Frame = new JFrame();
        Frame.setResizable(true);
        Frame.setSize(1000, 500);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.add(panel1);
        panel1.setLayout(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(2000, 2000));
        ViewPanel.setLayout(new GridBagLayout());
        ViewPanel.setPreferredSize(new Dimension(500, 500));

        KeyList.addAll(A.keySet());

        for (int i = 0; i < KeyList.size(); i++) {
            JButton btn = new JButton();
            ObjectList.put(btn, A.get(KeyList.get(i)));
            btn.setText(ObjectList.get(btn).toString());
            ViewPanel.add(btn);
        }

        JScrollPane ShapeScroll = new JScrollPane(ViewPanel);
        ShapeScroll.createHorizontalScrollBar();
        ShapeScroll.setHorizontalScrollBar(ShapeScroll.createHorizontalScrollBar());
        ShapeScroll.setVerticalScrollBar(ShapeScroll.createVerticalScrollBar());
        ShapeScroll.setBounds(50, 30, 300, 50);
        panel1.add(ShapeScroll);


        Frame.pack();
        Frame.setVisible(true);
    }

    public void FillObjectSelection(HashMap<Integer, Shape> A) {
*/
//JScrollPane ShapeScroll = new JScrollPane(ViewPanel);


      /*
      for(int i = 0; i < A.size(); i++) {
            JLabel label = new JLabel();


        }
}
}

*/
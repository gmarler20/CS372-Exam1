import java.io.*;
import java.util.HashMap;

// The class Read Data will read in shape files and create correct objects according to shapes.
// This class will be implemented with ShapeGUI and will be tested in TestData.java.

public class ReadData {
    private HashMap<Integer, Shape>  ShapeMap = new HashMap<>(); // Used to store the shapes as they are created from the text file
    Circle C1 = new Circle();
    Square S1 = new Square();
    Rectangle R1 = new Rectangle();
    Triangle T1 = new Triangle();
    boolean isCircle = false;
    boolean isSquare = false;
    boolean isRectangle = false;
    boolean isTriangle = false;
    private static int turntrack = 0;  // Used to track the amount of integer attributes assigned to each objects.
                                       // Circles and Squares will have two ints to assign, rectangles have three ints to assign, and triangles have four ints to assign.


    public ReadData () {
        try (FileInputStream is = new FileInputStream("shapes.csv")) {
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();

            // While there is a line
            while (line != null) {
                // Split it up into parts by each ,
                String[] parts = line.split(",");
                for (String p : parts) {

                        // If it is in the first field, which starts with ""
                    if (p.length() > 0 && p.charAt(0) == '"') {

                        // Then check the first character to get Type
                        // and create the correct shape as well as
                        // set the boolean to true
                        if ((p.charAt(1)) == 'c') {
                            isCircle = true;
                            C1 = new Circle();
                        }
                        if ((p.charAt(1)) == 's') {
                            isSquare = true;
                            S1 = new Square();
                        }
                        if((p.charAt(1) == 'r' )) {
                            isRectangle = true;
                            R1 = new Rectangle();
                        }
                        if((p.charAt(1) == 't')) {
                            isTriangle = true;
                            T1 = new Triangle();
                        }
                    }
                        // If it is the last field, the color field
                        // because char at 0 contains the quote
                    else if(p.length() > 0 && p.charAt(1) == '"') {

                        // Then check which boolean value has been set
                        // and set the color accordingly starting from the
                        // 2nd character
                        if(isCircle == true) {
                            C1.setColor(p.substring(2, p.length() - 1));// Gets color
                        }
                        if(isSquare == true) {
                            S1.setColor(p.substring(2, p.length() - 1));
                        }
                        if(isRectangle == true) {
                            R1.setColor(p.substring(2, p.length() - 1));
                        }
                        if(isTriangle == true) {
                            T1.setColor(p.substring(2, p.length() - 1));
                        }

                    }
                        // Else, we are looking for integers.
                        // Again, check the shape boolean value
                        // and go through to set each integer value.
                        // Uses turn track to make sure each shape
                        // sets the correct amount of variables.
                    else  {
                       if(isCircle == true && turntrack == 0) {


                           C1.setID(Integer.parseInt(p.substring(1)));
                           turntrack++;
                       }
                       else if(isCircle == true) {
                           C1.setRadius(Integer.parseInt(p.substring(1)));
                       }


                       if(isSquare == true && turntrack == 0) {


                            S1.setID(Integer.parseInt(p.substring(1)));
                            turntrack++;         // Gets numbers
                        }
                        else if(isSquare == true) {
                           S1.setSide(Integer.parseInt(p.substring(1)));
                       }



                       if(isRectangle == true && turntrack == 0) {
                           R1.setID(Integer.parseInt(p.substring(1)));
                           turntrack++;
                       }
                       else if(isRectangle == true && turntrack == 1) {
                           R1.setLength(Integer.parseInt(p.substring(1)));
                           turntrack++;
                       }
                       else if(isRectangle == true) {
                           R1.setWidth(Integer.parseInt(p.substring(1)));
                       }



                       if(isTriangle == true && turntrack == 0) {
                           T1.setID((Integer.parseInt(p.substring(1))));
                           turntrack++;
                       }
                       else if(isTriangle == true && turntrack == 1) {
                            T1.setSide1((Integer.parseInt(p.substring(1))));
                            turntrack++;
                        }
                        else if(isTriangle == true && turntrack == 2) {
                           T1.setSide2((Integer.parseInt(p.substring(1))));
                           turntrack++;
                       }
                       else if (isTriangle == true) {
                           T1.setSide3((Integer.parseInt(p.substring(1))));
                       }

                    }

                }

                // Now, go through and check again
                // which boolean value is true. According to which one is true,
                // put it into the Shape map using the objects ID as the key and the
                // object as the value. Then reset the boolean value to false so it
                // can be used again.

                if(isCircle == true) {
                    ShapeMap.put(C1.getID(), C1);
                    isCircle = false;
                }
                if(isSquare == true) {
                    ShapeMap.put(S1.getID(), S1);
                    isSquare = false;
                }
                if(isRectangle == true) {
                    ShapeMap.put(R1.getID(), R1);
                    isRectangle = false;
                }
                if(isTriangle == true) {
                    ShapeMap.put(T1.getID(), T1);
                    isTriangle = false;
                }
                line = rdr.readLine();
                System.out.println();
                // Reset turntrack before it goes through the loop again
                turntrack = 0;
            }
        }
        catch (Exception ex) {
            System.out.printf("failed for %s\n", "shapes.csv");
        }
    }

    // Called in the TestData class so we can pass in the HashMap to the GUI
    public HashMap<Integer, Shape> GetMap() {
        return ShapeMap;
    }

}



// Below are other scratch tactics that I tried to work with.
 /*   private static Scanner x;

    public static void main(String[] args) {
        String filepath = "shapes.txt";
        String searchTerm = "0";

    }

    public static void readRecord(String searchTerm, String filepath) {
        boolean found = false;
        String type;


        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[: \n]");
            while(x.hasNext()) {
                type = x.next();
                if(type == "circle") {
                    System.out.println("circle");

                }
            }
        } catch(Exception e) {

        }
    }
}
*/


        /*try(FileInputStream is = new FileInputStream("shapes.csv")) {
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            while(line!= null) {
            String[] parts = line.split(",");
            for(String p: parts) {
              //  if(p.length() < 0 && p.charAt(0) == '"' || p.charAt(0) >= 48 && p.charAt(0) <= 57) {
                //    System.out.printf("%s\t", p.substring(1, p.length() - 1));
              //  }
              //  else
              //      System.out.printf("%s\t", p);
            }
            line = rdr.readLine();
            System.out.println(line);
            }
        }
        catch (Exception ex) {
            System.out.printf("failed for %s\n", "shapes.csv");
        }
    }
}
*/
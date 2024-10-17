package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
//INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String c1, String c2){ // <--add 2 string parameters to this constructor
        int idxComma = c1.indexOf(",");
        x1 = Integer.parseInt(c1.substring(1, idxComma));
        // TAKING THE FIRST INDEX WHERE THE FIRST X WOULD BE AND THIRD INDEX WHERE THE FIRST Y WOULD BE
        y1 = Integer.parseInt(c1.substring(idxComma + 1, c1.length() - 1));
        // SAME PROCESS FOR SECOND COORDINATE
        idxComma = c2.indexOf(",");
        x2 = Integer.parseInt(c2.substring(1, idxComma));
        // SAME FOR THE Y
        y2 = Integer.parseInt(c2.substring(idxComma + 1,c2.length() - 1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){x1 = newX1;}
    public void setY1(int newY1){y1 = newY1;}
    public void setX2(int newX2){x2 = newX2;}
    public void setY2(int newY2){y2 = newY2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        // DISTANCE FORMULA IS RADICAL CHANGE IN X SQUARED PLUS CHANGE IN Y SQUARED
        double distance = Math.sqrt(Math.pow(Math.abs(x2 - x1),2) + Math.pow(Math.abs(y2 - y1), 2));
        distance = roundedToHundredth(distance);
        return distance;
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        // TO BE UNDEFINED, THE SLOPE WOULD HAVE TO BE UNDEFINED
        if (slope() == -999.99) {
            return -999.99;
        }
        /* USING 2 OF THE POINTS 
        Y1 = SLOPE (X1) + Y-INT
        Y-INT = Y1 - SLOPE(X1)*/ 
        double yInt = y1 - (slope() * x1);
        yInt = roundedToHundredth(yInt);
        return yInt;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        // SLOPE IS CHANGE IN Y OVER CHANGE IN X
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        if (deltaX == 0) {
            return -999.99;
        }
        double slope = (deltaY) / (deltaX);
        // ROUNDING
        slope = roundedToHundredth(slope);
        return slope;   
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        // FOR AN UNDEFINED SLOPE
        if (slope() == -999.99) {
            return "undefined";
        }
        // PIECING THE EQUATION TOGETHER
        // y=slopex+yInt
        // IF THE VALUES R 0
        String equationYInt = "";
        String equationMX = "";
        String operation = "";
        // IF Y INTERCEPT IS 0, DONT SHOW IT
        if (yInt() == 0) {
            equationYInt = "";
        } else {
            equationYInt = "" + yInt();
        }
        // IF SLOPE IS 0, DONT SHOW IT
        if (slope() == 0) {
            equationMX = "";
            operation = "";
        } // OPERATION SIGN
        else {
            equationMX = "" + slope() + "x";
            if (yInt() > 0) {
                operation = "+";
            } else {
                operation = "";
            }
        }
        
        // FINAL PIECE
        String finalEquation = "";
        finalEquation += "y=" + equationMX + operation + equationYInt;
        return finalEquation;
    }

    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double roundedValue = 0;
        // FOR POSITIVE NUMBERS
        if (x > 0) {
            roundedValue = (int) (x * 100.0 + 0.5) / 100.0;   
        } else if (x < 0) {
        // FOR NEGATIVE NUMBERS
            roundedValue = (int) (x * 100.0 - 0.5) / 100.0;
        }
        return roundedValue;
    }


    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        String symmetry = "";
        // if x1 x2 reflect across y
        if (x1 == x2 * -1) {
            // if they also reflect across x
            if (y1 == y2 * -1) {
                symmetry = "Symmetric about the origin";
                return symmetry;
            }
            symmetry = "Symmetric about the y-axis";
            return symmetry;
        // if they just reflect off x and no y
        } if (y1 == y2 * -1) {
            symmetry = "Symmetric about the x-axis";
            return symmetry;
        } else {
        // everything else
            symmetry = "No symmetry";
        }
        return symmetry;
            
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        String midpoint = "(";
        //MP FORMULA (X1+ X2/2, Y1 + Y2/2)
        double mpPointX = roundedToHundredth((x2 + x1) / 2.0);
        double mpPointY = roundedToHundredth((y2 + y1) / 2.0);
        midpoint += mpPointX + "," + mpPointY + ")";
        midpoint = "The midpoint of this line is: " + midpoint;
        return midpoint;
    }

}




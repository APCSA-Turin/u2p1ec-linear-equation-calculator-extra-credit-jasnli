package com.example.project;
public class LinearCalculatorRunner {
    public static void main(String[] args) {
        LinearCalculator c1 = new LinearCalculator("(3,4)" , "(3,-4)");
        int x1 = 3;
        int x2 = -4;
        int y1 = -3;
        int y2 = 4;
        String midpoint = "(";
        //MP FORMULA (X1+ X2/2, Y1 + Y2/2)
        double mpPointX = ((x2 + x1) / 2.0);
        double mpPointY = ((y2 + y1) / 2.0);
        midpoint += mpPointX + "," + mpPointY + ")";
        System.out.println(c1.printInfo());
        System.out.println(c1.Midpoint());
    }
}
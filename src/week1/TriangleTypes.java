package week1;

import java.util.Formatter;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.System;

public class TriangleTypes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double inputA = 6.0;
        //scanner.nextDouble();
        double inputB = 8.0;
        //scanner.nextDouble();
        double inputC = 10.0;
        //scanner.nextDouble();

        double[] arrDouble = new double[] {inputA, inputB, inputC};

        Arrays.sort(arrDouble);

        triangle(arrDouble[2], arrDouble[1], arrDouble[0]);
    }

    static void triangle(double a, double b, double c)
    {
        if (a >= (b + c))
        {
            System.out.println("NAO FORMA TRIANGLO");
        }

        if (Math.pow(a, 2) == (Math.pow(b, 2) + Math.pow(c, 2)))
        {
            System.out.println("TRIANGULO RETANGULO");
        }

        if (Math.pow(a, 2) > (Math.pow(b, 2) + Math.pow(c, 2)))
        {
            System.out.println("TRIANGULO OBTUSANGULO");
        }

        if (Math.pow(a, 2) < (Math.pow(b, 2) + Math.pow(c, 2)))
        {
            System.out.println("TRIANGULO ACUTANGULO");
        }

        if (a == b && b ==c)
        {
            System.out.println("TRIANGULO EQUILATERO");
        }
        else if (a == b || b == c || a ==c)
        {
            System.out.println("TRIANGULO ISOSCELES");
        }
    }
}
package week1;

import java.util.Formatter;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.System;

public class TriangleTypes {
    public static void main(String[] args) {

                double[][] a = new double[12][12];
                Scanner scanner = new Scanner(System.in);

                int n = scanner.nextInt();
                char c = scanner.next().charAt(0);

                double sum = 0;

                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 12; j++) {
                        a[i][j] = scanner.nextDouble();
                        if (j == n) {
                            sum += a[i][j];
                        }
                    }
                }

                if (c == 'S') {
                    System.out.printf("%.1f\n", sum);
                } else if (c == 'M') {
                    System.out.printf("%.1f\n", sum / 12);
                }

                scanner.close();
    }
}
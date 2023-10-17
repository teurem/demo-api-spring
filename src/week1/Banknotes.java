package week1;

import java.util.Formatter;
import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Formatter f = new Formatter();

        int[] arr = new int[] {100, 50, 20, 10, 5, 2, 1};

        int inputNumber = scanner.nextInt();

        for (int i = 0; i < arr.length; i++)
        {
            int number = 0;
            number = inputNumber / arr[i];

            inputNumber = inputNumber - (number * arr[i]);

            float b = arr[i];

            f.format("%d nota(s) de R$ %.2f \n", number, b);
        }
        System.out.println(f);
    }
}
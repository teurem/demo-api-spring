package week1;

import java.util.Formatter;
import java.util.Scanner;

public class BanknotesAndCoins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Formatter f = new Formatter();
        Formatter s = new Formatter();

        int[] arr = new int[] {100, 50, 20, 10, 5, 2};
        double[] arrD = new double[] {0.50, 0.25, 0.10, 0.05, 0.01};

        double inputNumber = scanner.nextDouble();

        int out = (int) inputNumber;
        double out2 = inputNumber - out;

        // notas
        for (int i = 0; i < arr.length; i++)
        {
            int number = 0;
            number = out / arr[i];

            out = out - (number * arr[i]);

            float b = arr[i];

            f.format("%d nota(s) de R$ %.2f \n", number, b);
        }
        System.out.println("NOTAS:");
        System.out.println(f);

        System.out.println("MOEDAS:");
        if (out == 1)
        {
            System.out.println("1 nota(s) de R$ 1.00");
        }
        else {
            System.out.println("0 nota(s) de R$ 1.00");
        }

        int out2Int = (int) (out2 * 100);
        //moedas
        for (int i = 0; i < arrD.length; i++)
        {
            int number = 0;
            int array = (int) (arrD[i] * 100);

            number = out2Int / array;

            out2Int = out2Int - (number * array);

            double b = arrD[i];

            s.format("%d nota(s) de R$ %.2f \n", number, b);
        }
        System.out.println(s);
    }
}

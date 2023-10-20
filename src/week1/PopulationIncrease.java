import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            int years = 0;
            int PA = input.nextInt();
            int PB = input.nextInt();
            double G1 = input.nextDouble();
            double G2 = input.nextDouble();

            G1 /= 100;
            G2 /= 100;

            while (PA <= PB) {
                PA = (int) (PA * (1 + G1));
                PB = (int) (PB * (1 + G2));
                years++;

                if (years > 100) {
                    System.out.println("Mais de 1 seculo");
                    break;
                }
            }

            if (years <= 100) {
                System.out.println(years + " anos");
            }
        }
    }
}

import java.util.Scanner;

public class Grenais {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int interGoals, gremioGoals;
        int grenais = 0, interWins = 0, gremioWins = 0, draws = 0;

        while (true) {
            interGoals = input.nextInt();
            gremioGoals = input.nextInt();

            grenais++;
            if (interGoals > gremioGoals) {
                interWins++;
            } else if (gremioGoals > interGoals) {
                gremioWins++;
            } else {
                draws++;
            }

            System.out.println("Novo grenal (1-sim 2-nao)");
            int choice = input.nextInt();

            if (choice == 2) {
                break;
            }
        }

        System.out.println(grenais + " grenais");
        System.out.println("Inter:" + interWins);
        System.out.println("Gremio:" + gremioWins);
        System.out.println("Empates:" + draws);

        if (interWins > gremioWins) {
            System.out.println("Inter venceu mais");
        } else if (gremioWins > interWins) {
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Nao houve vencedor");
        }
    }
}

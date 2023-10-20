import java.util.Scanner;

public class GameTimeWithMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHour, initialMinute, finalHour, finalMinute;

        initialHour = scanner.nextInt();
        initialMinute = scanner.nextInt();
        finalHour = scanner.nextInt();
        finalMinute = scanner.nextInt();

        int initialTotalMinutes = initialHour * 60 + initialMinute;
        int finalTotalMinutes = finalHour * 60 + finalMinute;

        int durationMinutes;

        if (finalTotalMinutes > initialTotalMinutes) {
            durationMinutes = finalTotalMinutes - initialTotalMinutes;
        } else {
            durationMinutes = 1440 - (initialTotalMinutes - finalTotalMinutes);
        }

        int durationHours = durationMinutes / 60;
        durationMinutes %= 60;

        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", durationHours, durationMinutes);
    }
}

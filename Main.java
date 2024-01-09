package fr.eni.calendrier;

import java.time.LocalDate;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        YearMonth currentMonth = YearMonth.of(2024, 1);
        LocalDate firstOfMonth = currentMonth.atDay(1);
        int firstDay = firstOfMonth.getDayOfWeek().getValue() % 7;
        int daysInMonth = currentMonth.lengthOfMonth();

        System.out.println("Lun Mar Mer Jeu Ven Sam Dim");

        for (int i = 1; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 1) {
                System.out.println();
            }
        }
    }
}

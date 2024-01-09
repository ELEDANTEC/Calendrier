package fr.eni.calendrier;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une date au format dd/mm/yyyy (ex: 09/01/2024): ");
        String inputDate = scanner.nextLine();

        LocalDate date;
        try {
            date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            System.out.println("Le format de la date entrée n'est pas correct. Veuillez ressaisir.");
            return;
        }

        YearMonth yearMonth = YearMonth.from(date);
        int daysInMonth = yearMonth.lengthOfMonth();
        int firstDayOfMonth = yearMonth.atDay(1).getDayOfWeek().getValue();

        System.out.println(date.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRENCH)));
        System.out.println("Lun Mar Mer Jeu Ven Sam Dim");

        for (int i = 1; i < firstDayOfMonth; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDayOfMonth - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }
}

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class BookRent {
    public void hitungTotalDenda(Map<String, Integer> bookData, LocalDate borrowingDate, LocalDate returnDate) {
        int totalFine = 0;

        for (Map.Entry<String, Integer> entry : bookData.entrySet()) {
            int borrowingDays = entry.getValue();
            int fine = hitungDendaPerBuku(borrowingDate, returnDate, borrowingDays);
            totalFine += fine;
        }

        System.out.print("Total Denda: " + totalFine);
    }

    private static int hitungDendaPerBuku(LocalDate borrowingDate, LocalDate returnDate, int borrowingDays) {
        LocalDate dueDate = borrowingDate.plusDays(borrowingDays);
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);

        if (daysLate <= 0) {
            return 0;
        }

        return (int) (daysLate * 100);
    }
}

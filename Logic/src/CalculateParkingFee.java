import java.time.LocalDateTime;
import java.time.Duration;

public class CalculateParkingFee {
    public void calculateParkingFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration parkingDuration = Duration.between(entryTime, exitTime);
        long hours = parkingDuration.toHours();

        Long parkingFee = 0L;

        if (hours <= 8) {
            parkingFee = hours * 1000L;
        } else if (hours <= 24) {
            parkingFee = 8000L;
        } else {
            parkingFee = 15000L + ((hours - 24L) * 1000L);
        }

        System.out.println("Tarif Parkir: " + parkingFee + " Rupiah");
    }
}

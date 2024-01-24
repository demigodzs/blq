import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatWaktu24jam {
    public void convertTo24HourFormat(String waktu12Jam) throws ParseException {
        try {
            SimpleDateFormat format12Jam = new SimpleDateFormat("hh:mm:ss a");
            Date date = format12Jam.parse(waktu12Jam);
            SimpleDateFormat format24Jam = new SimpleDateFormat("HH:mm:ss");
            String result = format24Jam.format(date);

            System.out.print(result);
        } catch (ParseException e) {
            System.out.print("Terjadi kesalahan saat mengonversi format waktu.");
            e.printStackTrace();
        }
    }
}

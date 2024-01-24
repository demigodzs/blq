import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);

        System.out.print("1. Max Purchase, masukan jumlah uang (e.g 1000): ");
        int uang1 = scan.nextInt();
        Map<String, List<Integer>> items1 = new HashMap<>();
        items1.put("Kaca_mata", Arrays.asList(500, 600, 700, 800));
        items1.put("Baju", Arrays.asList(200, 400, 350));
        items1.put("Sepatu", Arrays.asList(400, 350, 200, 300));
        items1.put("Buku", Arrays.asList(100, 50, 150));
        MaxPurchaseCalculator no1 = new MaxPurchaseCalculator();
        no1.calculateMaximumPurchase(items1, uang1);

        System.out.println();

        System.out.print("2. Rent Book, masukan buku-buku dan total hari (e.g A:14,B:3,C:7,D:7): ");
        String mapingBuku2 = scanStr.nextLine();
        String[] pairs2 = mapingBuku2.split(",");
        Map<String, Integer> bookData = new HashMap<>();
        for (int i = 0; i < pairs2.length; i++) {
            String[] pair2 = pairs2[i].split(":");
            int duration2 = Integer.parseInt(pair2[1]);
            bookData.put(pair2[0], duration2);
        }
        System.out.print("Tanggal peminjaman (format yyyy-MM-dd): ");
        String borrowingDateString2 = scanStr.nextLine();
        LocalDate borrowingDate2 = LocalDate.parse(borrowingDateString2);
        System.out.print("Tanggal pengembalian (format yyyy-MM-dd): ");
        String returnDateString2 = scanStr.nextLine();
        LocalDate returnDate2 = LocalDate.parse(returnDateString2);
        BookRent no2 = new BookRent();
        no2.hitungTotalDenda(bookData, borrowingDate2, returnDate2);

        System.out.println();

        System.out.println("3. Menghitung Tarif Parkir");
        System.out.print("Entry Time (e.g 27 Januari 2019 | 05:00:01): ");
        String entryTimeStr3 = scanStr.nextLine();
        System.out.print("Exit Time (e.g 27 Januari 2019 | 17:45:03): ");
        String exitTimeStr3 = scanStr.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy | HH:mm:ss", new Locale("id"));
        LocalDateTime entryTime3 = LocalDateTime.parse(entryTimeStr3, formatter);
        LocalDateTime exitTime3 = LocalDateTime.parse(exitTimeStr3, formatter);
        CalculateParkingFee no3 = new CalculateParkingFee();
        no3.calculateParkingFee(entryTime3, exitTime3);

        System.out.print("4. Bilangan Prima, masukan nilai n (e.g 5): ");
        int n4 = scan.nextInt();
        Prima no4 = new Prima();
        no4.prima(n4);

        System.out.println();

        System.out.print("5. Bilangan Fibonacci, masukan nilai n (e.g 5): ");
        int n5 = scan.nextInt();
        Fibonacci no5 = new Fibonacci();
        no5.fibonacci(n5);

        System.out.println();

        System.out.print("6. Palindrome, masukan kata (e.g Katak): ");
        String kata6 = scanStr.nextLine();
        Palindrome no6 = new Palindrome();
        no6.palindrome(kata6);

        System.out.println();

        System.out.print("7. Mean Median Modus, deret angka di pisahkan dengan spasi (e.g 8 7 0 2 7 1 7 6 3 0 7 1 3 4 6 1 6 4 3): ");
        String deret7 = scanStr.nextLine();
        String[] arrDeret7 = deret7.split(" ");
        int[] arrNumbers7 = new int[arrDeret7.length];
        for(int i=0; i<arrDeret7.length; i++)
        {
            int strToInt = Integer.parseInt(arrDeret7[i]);
            arrNumbers7[i] = strToInt;
        }
        MeanMedianMode no7 = new MeanMedianMode();
        no7.calculateMeanMediaMode(arrNumbers7);

        System.out.println();

        System.out.print("8. Min dan Max penjumlahan 4 komponen, deret angka di pisahkan dengan spasi (e.g 1 2 4 7 8 6 9): ");
        String deret8 = scanStr.nextLine();
        String[] arrDeret8 = deret8.split(" ");
        int[] arrNumbers8 = new int[arrDeret8.length];
        for(int i=0; i<arrDeret8.length; i++)
        {
            int strToInt = Integer.parseInt(arrDeret8[i]);
            arrNumbers8[i] = strToInt;
        }
        MinMax4Component no8 = new MinMax4Component();
        no8.calculateMinMax4Component(arrNumbers8);

        System.out.println();

        System.out.print("9. Pola Aritmatika, masukan nilai n (e.g 3): ");
        int n9 = scan.nextInt();
        PolaAritmatika no9 = new PolaAritmatika();
        no9.polaAritmatika(n9);

        System.out.println();

        System.out.print("10. Hide nama string, masukan nama (e.g Susilo Bambang Yudohyono): ");
        String nama10 = scanStr.nextLine();
        HideCharacter no10 = new HideCharacter();
        no10.hideKarakter(nama10);

        System.out.println();

        System.out.print("11. Bentuk string, masukan string (e.g Afrika): ");
        String str11 = scanStr.nextLine();
        BentukCharacter no11 = new BentukCharacter();
        no11.bentukCharacter(str11);
        
        System.out.print("12. Sort, masukan deret angka dipisahkan dengan spasi (e.g 5 3 1 2): ");
        String inputLine12 = scanStr.nextLine();
        Scanner lineScanner12 = new Scanner(inputLine12);
        String inputWithoutSpaces12 = inputLine12.replaceAll("\\s", "");
        int lengthWithoutSpaces12 = inputWithoutSpaces12.length();
        int[] deret12 = new int[lengthWithoutSpaces12];
        int counter12 = 0;
        while (lineScanner12.hasNext()) {
            if (lineScanner12.hasNextInt()) {
                int num = lineScanner12.nextInt();
                deret12[counter12] = num;
                counter12++;
            } else {
                lineScanner12.next();
            }
        }
        lineScanner12.close();
        ManualSort no12 = new ManualSort();
        no12.sort(deret12);

        System.out.println();

        System.out.print("13. Sudut jam, masukan input jam (e.g 5:30): ");
        String waktu13 = scanStr.nextLine();
        String[] timeComponents = waktu13.split(":");
        int jam13 = Integer.parseInt(timeComponents[0]);
        int menit13 = Integer.parseInt(timeComponents[1]);
        SudutJam no13 = new SudutJam();
        no13.hitungSudut(jam13, menit13);

        System.out.println();

        System.out.print("14. Rotate deret, masukan deret angka dipisahkan dengan spasi (e.g 3 9 0 7 1 2 4): ");
        String inputLine14 = scanStr.nextLine();
        Scanner lineScanner14 = new Scanner(inputLine14);
        String inputWithoutSpaces14 = inputLine14.replaceAll("\\s", "");
        int lengthWithoutSpaces14 = inputWithoutSpaces14.length();
        int[] deret14 = new int[lengthWithoutSpaces14];
        int counter14 = 0;
        while (lineScanner14.hasNext()) {
            if (lineScanner14.hasNextInt()) {
                int num = lineScanner14.nextInt();
                deret14[counter14] = num;
                counter14++;
            } else {
                lineScanner14.next();
            }
        }
        lineScanner14.close();
        System.out.print("Masukan nilai n (e.g 3): ");
        int panjang14 = scan.nextInt();
        RotateDeret no14 = new RotateDeret();
        no14.rotate(deret14, panjang14);

        System.out.println();

        System.out.print("15. Convert Waktu, masukan waktu (e.g 03:40:44 PM): ");
        String waktu15 = scanStr.nextLine();
        FormatWaktu24jam no15 = new FormatWaktu24jam();
        no15.convertTo24HourFormat(waktu15);

        System.out.println();

        System.out.print("16. Split Bill, masukan mapping menu,harga, dan boolean kandungan ikan (e.g Tuna Sandwitch:42:true,Spaghetti Carbonara:50:false,Tea Pitcher:30:false,Pizza:70:false,Salad:30:false): ");
        String mapingBill16 = scanStr.nextLine();
        String[] pairs16 = mapingBill16.split(",");
        String[] menus16 = new String[pairs16.length];
        int[] price16 = new int[pairs16.length];
        Boolean[] isFishy16 = new Boolean[pairs16.length];
        for (int i = 0; i < pairs16.length; i++) {
            String[] pair16 = pairs16[i].split(":");
            int tempPrice16 = Integer.parseInt(pair16[1]);
            Boolean tempBoolean16 = Boolean.parseBoolean(pair16[2]);
            menus16[i] = pair16[0];
            price16[i] = tempPrice16;
            isFishy16[i] = tempBoolean16;
        }
        System.out.print("Masukan jumlah orang yang datang: ");
        int totalOrang16 = scan.nextInt();
        System.out.print("Masukan jumlah orang yang alergi ikan: ");
        int totalOrangAlergiIkan16 = scan.nextInt();
        SplitBill no16 = new SplitBill();
        no16.calculateSplitBill(menus16, price16, isFishy16, totalOrang16, totalOrangAlergiIkan16);

        System.out.println();

        System.out.print("17. Hatori muncak, masukan catatan hatori (e.g N N T N N N T T T T T N T T T N T N): ");
        String deret17 = scanStr.nextLine();
        String[] hatoriNotes17 = deret17.split(" ");
        HatoriNotes no17 = new HatoriNotes();
        no17.calculateHatoriNotes(hatoriNotes17);

        System.out.println();
        
        System.out.print("18. Air yang diperlukan dona saat berolahraga, masukan jam & kalori (e.g 9-30,13-20,15-50,17-80): ");
        String deret18 = scanStr.nextLine();
        String[] pairs18 = deret18.split(",");
        int[] jam18 = new int[pairs18.length];
        int[] kalori18 = new int[pairs18.length];
        for(int i=0; i<pairs18.length; i++){
            String[] pair18 = pairs18[i].split("-");
            int tempJam = Integer.parseInt(pair18[0]);
            int tempKalori = Integer.parseInt(pair18[1]);

            jam18[i] = tempJam;
            kalori18[i] = tempKalori;
        }
        System.out.print("Masukan jam mulai olahraga: ");
        int jamMulai18 = scan.nextInt();
        CalculateWaterNeeds no18 = new CalculateWaterNeeds();
        no18.calculateAsupanAir(jam18, kalori18, jamMulai18);

        System.out.println();

        System.out.print("19. Pangram Words, masukan kalimat (e.g The quick brown fox jumps over the lazy dog): ");
        String words19 = scanStr.nextLine();
        PangramWords no19 = new PangramWords();
        no19.isPangram(words19);

        System.out.println();

        System.out.print("20. Gunting Batu Kertas, masukan jarak awal B di depan A (e.g 2): ");
        int jarakAwal20 = scan.nextInt();
        System.out.print("Masukan suit A (e.g G G G): ");
        String inputanA20 = scanStr.nextLine();
        System.out.print("Masukan suit B (e.g K K B): ");
        String inputanB20 = scanStr.nextLine();
        String[] arrInputA20 = inputanA20.split(" ");
        String[] arrInputB20 = inputanB20.split(" ");
        GuntingBatuKertas no20 = new GuntingBatuKertas();
        no20.calculateWinner(jarakAwal20, arrInputA20, arrInputB20);

        System.out.println();

        System.out.print("21. Manhole Game, masukan track dengan separator spasi (e.g _ _ _ _ _ O _ _ _): ");
        String track21 = scanStr.nextLine();
        String[] arrTrack21 = track21.split(" ");
        ManholeGame no21 = new ManholeGame();
        no21.findMinimumSteps(arrTrack21);

        System.out.println();

        System.out.print("22. Candle, masukan deret lilin (e.g 3 3 9 6 7 8 23): ");
        String deretStr22 = scanStr.nextLine();
        String[] arrDeretStr22 = deretStr22.split(" ");
        int[] deret22 = new int[arrDeretStr22.length];
        for(int i=0; i< arrDeretStr22.length; i++)
        {
            deret22[i] = Integer.parseInt(arrDeretStr22[i]);
        }
        Candle no22 = new Candle();
        no22.getFirstCandle(deret22);

        scan.close();
        scanStr.close();
    }
}

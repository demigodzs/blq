public class SudutJam {
    public void hitungSudut(int jam, int menit) {
        // Menggunakan rumus: Sudut = |30 * Jam - (11/2) * Menit|
        int sudut = Math.abs(30 * jam - (int)(0.5 * (11 * menit)));
        // Pastikan sudut tidak melebihi 180 derajat
        int result = Math.min(sudut, 360 - sudut);

        System.out.print("Jam " + jam + ":" + menit + " -> Sudut: " + result + " derajat");
    }
}

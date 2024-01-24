public class Fibonacci {
    public void fibonacci(int n) {
        int angkaSebelumnya = 0;
        int angkaSaatIni = 1;

        System.out.println("Bilangan Fibonacci:");

        for (int i = 0; i < n; i++) {
            System.out.print(angkaSebelumnya + " ");

            int jumlahSelanjutnya = angkaSebelumnya + angkaSaatIni;
            angkaSebelumnya = angkaSaatIni;
            angkaSaatIni = jumlahSelanjutnya;
        }
    }
}

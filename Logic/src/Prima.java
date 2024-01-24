public class Prima {
    public void prima(int n)
    {
        int jumlahPrima = 0;
        int angka = 2;

        System.out.println("Bilangan Prima:");

        while (jumlahPrima < n) {
            if (isPrime(angka)) {
                System.out.print(angka + " ");
                jumlahPrima++;
            }
            angka++;
        }
    }

    public boolean isPrime(int angka) {
        if (angka <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(angka); i++) {
            if (angka % i == 0) {
                return false;
            }
        }

        return true;
    }
}

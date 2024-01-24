public class Candle {
    public void getFirstCandle(int[] deret)
    {
        int[] arrFibo = fibo(deret.length);
        int[] arrTemporary = new int[deret.length];
        for(int i=0; i<deret.length; i++)
        {
            arrTemporary[i] = deret[i];
        }
        Boolean flagHabis = false;
        int result=0;

        while(flagHabis != true)
        {
            for(int i=0; i<deret.length; i++)
            {
                if(deret[i] <= 0)
                {
                    result = i;
                    flagHabis = true;
                    break;
                }
                deret[i] -= arrFibo[i];
            }
        }

        int finalResult = result+1;

        System.out.println("Lilin yang pertama habis yaitu lilin ke-" + finalResult + " dengan value: " + arrTemporary[result]);
    }
    

    private int[] fibo(int n) {
        int angkaSebelumnya = 1;
        int angkaSaatIni = 1;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = angkaSebelumnya;

            int jumlahSelanjutnya = angkaSebelumnya + angkaSaatIni;
            angkaSebelumnya = angkaSaatIni;
            angkaSaatIni = jumlahSelanjutnya;
        }

        return result;
    }
}

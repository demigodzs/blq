public class CalculateWaterNeeds {
    public void calculateAsupanAir(int[] jam, int[] kalori, int jamOlahraga)
    {
        double totalMenit = 0;
        for(int i=0; i<jam.length; i++)
        {
            int selisihWaktu = jamOlahraga-jam[i];

            double totalPerMakan = 0.1 * selisihWaktu * kalori[i];
            totalMenit+= totalPerMakan;
        }

        double result = (totalMenit/30)*100 + 500;

        System.out.print("Total air yang di minum Dona: " + result + " cc");
    }
}

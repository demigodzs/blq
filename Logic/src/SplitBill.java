public class SplitBill {
    public void calculateSplitBill(String[] menus, int[] prices, Boolean[] isFishy, int persons, int personWithAlergic)
    {
        double taxRate = 0.10;
        double serviceRate = 0.05;
        double totalBill = 0;
        double totalBillFishy = 0;

        for (int i = 0; i < prices.length; i++) {
            if(isFishy[i].equals(true))
            {
                totalBillFishy += prices[i];
            }
            else
            {
                totalBill += prices[i];
            }
        }


        double taxFishy = totalBillFishy * taxRate;
        double serviceFishy = totalBillFishy * serviceRate;
        double totalBillFishyWithTaxAndService = totalBillFishy + taxFishy + serviceFishy;

        double tax = totalBill * taxRate;
        double service = totalBill * serviceRate;
        double totalBillWithTaxAndService = totalBill + tax + service;

        double sharePerFriendWithoutAllergy = (totalBillFishyWithTaxAndService/(persons-personWithAlergic)) + (totalBillWithTaxAndService/persons);
        double sharePerAllergicFriend = totalBillWithTaxAndService/persons;

        System.out.println("Harga total menu yang mengandung ikan: " + totalBillFishy);
        System.out.println("Harga total menu yang tidak mengandung ikan: " + totalBill);
        System.out.println("Harga total menu yang mengandung ikan + tax & service: " + totalBillFishyWithTaxAndService);
        System.out.println("Harga total menu yang tidak mengandung ikan + tax & service: " + totalBillWithTaxAndService);
        System.out.println("Total yang harus di bayarkan per orang tanpa alergi ikan: " + sharePerFriendWithoutAllergy);
        System.out.print("Total yang harus di bayarkan orang dengan alergi ikan: " + sharePerAllergicFriend);
    }
}

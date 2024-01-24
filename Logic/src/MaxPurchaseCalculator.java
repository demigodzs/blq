import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaxPurchaseCalculator {
    public void calculateMaximumPurchase(Map<String, List<Integer>> items, int totalAmount) {
        List<String> itemNames = new ArrayList<>(items.keySet());
        int n = itemNames.size();

        int[][] dp = new int[n + 1][totalAmount + 1];

        for (int i = 1; i <= n; i++) {
            String itemName = itemNames.get(i - 1);
            List<Integer> prices = items.get(itemName);

            for (int j = 0; j <= totalAmount; j++) {
                for (int k = 0; k < prices.size(); k++) {
                    if (j >= prices.get(k)) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - prices.get(k)] + 1);
                    }
                }
            }
        }

        int remainingAmount = totalAmount;
        List<String> itemsBought = new ArrayList<>();

        for (int i = n; i > 0 && remainingAmount > 0; i--) {
            if (dp[i][remainingAmount] != dp[i - 1][remainingAmount]) {
                String itemName = itemNames.get(i - 1);
                List<Integer> prices = items.get(itemName);

                for (int k = 0; k < prices.size(); k++) {
                    if (remainingAmount >= prices.get(k) && dp[i][remainingAmount] == dp[i - 1][remainingAmount - prices.get(k)] + 1) {
                        itemsBought.add(itemName + " " + prices.get(k));
                        remainingAmount -= prices.get(k);
                        break;
                    }
                }
            }
        }

        Result result = new Result(totalAmount - remainingAmount, itemsBought);

        System.out.println("Jumlah uang yang dipakai: " + result.getTotalAmountUsed());
        System.out.println("Jumlah item yang bisa dibeli: " + result.getItemCount());
        System.out.print("Detail item yang dibeli: " + result.getItemsBought());
    }

    class Result {
        private final int totalAmountUsed;
        private final List<String> itemsBought;

        public Result(int totalAmountUsed, List<String> itemsBought) {
            this.totalAmountUsed = totalAmountUsed;
            this.itemsBought = itemsBought;
        }

        public int getTotalAmountUsed() {
            return totalAmountUsed;
        }

        public int getItemCount() {
            return itemsBought.size();
        }

        public List<String> getItemsBought() {
            return itemsBought;
        }
    }
}

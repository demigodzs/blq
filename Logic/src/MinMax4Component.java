public class MinMax4Component {
    public void calculateMinMax4Component(int[] numbers)
    {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= numbers.length - 4; i++) {
            int currentSum = numbers[i] + numbers[i + 1] + numbers[i + 2] + numbers[i + 3];

            minSum = Math.min(minSum, currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Nilai Minimal dari Penjumlahan 4 Komponen: " + minSum);
        System.out.print("Nilai Maksimal dari Penjumlahan 4 Komponen: " + maxSum);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeanMedianMode {
    public void calculateMeanMediaMode(int[] numbers)
    {
        double mean = calculateMean(numbers);
        double median = calculateMedian(numbers);
        int[] modes = calculateMode(numbers);

        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.print("Modus: ");
        for (int mode : modes) {
            System.out.print(mode + " ");
        }
    }

    private double calculateMean(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    private double calculateMedian(int[] numbers) {
        Arrays.sort(numbers);

        int length = numbers.length;
        if (length % 2 == 0) {
            int middle1 = numbers[length / 2 - 1];
            int middle2 = numbers[length / 2];
            return (double) (middle1 + middle2) / 2;
        } else {
            return (double) numbers[length / 2];
        }
    }

    private int[] calculateMode(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        List<Integer> modesList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modesList.add(entry.getKey());
            }
        }

        int[] modesArray = new int[modesList.size()];
        for (int i = 0; i < modesList.size(); i++) {
            modesArray[i] = modesList.get(i);
        }

        return modesArray;
    }
}

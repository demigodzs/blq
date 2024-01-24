public class RotateDeret {
    public void rotate(int[] arr, int N) {
        int length = arr.length;
        int[] rotatedArray = new int[length];

        for (int i = 0; i < length; i++) {
            int newIndex = (i + N) % length;
            rotatedArray[i] = arr[newIndex];
        }

        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
    }
}

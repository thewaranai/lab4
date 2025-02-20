import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int n = 20;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите элемент  " + (i + 1));
            Scanner in = new Scanner(System.in);
            array[i] = in.nextInt();
        }
        System.out.println("Массив до сортировки:");
        printArray(array);

        quickSort(array, 0, array.length -1);

        System.out.println("Массив после сортировки:");
        int newSize = moveZero(array);
        for (int i = 0; i < newSize; i++) {
            System.out.print(array[i] + " ");
        }
       int[] nonZeroArray = delZero(array);
        quickSort(nonZeroArray, 0, nonZeroArray.length -1);

        System.out.println("Массив без нулей:");
        printArray(nonZeroArray);
    }
    public static int moveZero ( int[] array){
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[index] = array[i];
                index++;
            }
        }
        while (index < array.length) {
            array[index] = 0;
            index++;
        }
        return index;
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    public static int[] delZero(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num != 0) {
                count++;
            }
        }
        int[] nonZeroArray = new int[count];
        int index = 0;
        for (int num : array) {
            if (num != 0) {
                nonZeroArray[index++] = num;
            }
        }
        return nonZeroArray;
    }
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
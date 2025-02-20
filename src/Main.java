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

        combSort(array);

        System.out.println("Массив после сортировки:");
        int newSize = moveZero(array);
        for (int i = 0; i < newSize; i++) {
            System.out.print(array[i] + " ");
        }
       int[] nonZeroArray = delZero(array);
        combSort(nonZeroArray);

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
    public static void combSort(int[] values){
        double factor = 1.247;
        int step = values.length - 1;
        while (step >= 1){
            for (int i = 0; i + step < values.length; ++i){
                if (values[i] > values[i + step]){
                    swap (values, i,i + step);
                }
            }
            step /= factor;
        }
    }
    static void swap(int[] SortArr, int i, int j){
        int swap = SortArr[i];
        SortArr[i] = SortArr[j];
        SortArr[j] = swap;
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
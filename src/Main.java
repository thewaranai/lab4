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

        bubbleSort(array);

        System.out.println("Массив после сортировки:");
        printArray(array);

       int[] nonZeroArray = delZero(array);
       bubbleSort(nonZeroArray);

        System.out.println("Массив без нулей:");
        printArray(nonZeroArray);
    }
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
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
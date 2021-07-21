package com.nazaralwi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int pos, start, end, mid, low, high;

    public static void main(String[] args) {
        System.out.println("JAWABAN SOAL #1");
        Random random = new Random();
        int[] data = new int[10];
        int value = 89;

        for (int i = 0; i < 10; i++) {
            data[i] = random.nextInt(100);
        }

        System.out.println("Array: " + Arrays.toString(data));
        System.out.println("Data yang dicari: " + value);

        if (sequentialSearch(data, value) == -1) {
            System.out.println("Data tidak ditemukan");
        } else {
            System.out.println("Data ditemukan");
        }

        System.out.println();

        System.out.println("JAWABAN SOAL #2");
        int[] data2 = { 2, 3, 18, 4, 29, 84, 9, 2, 34, 22 };
        int value2 = 18;

        System.out.println("Array: " + Arrays.toString(data2));
        System.out.println("Data yang dicari: " + value2);

        if (binarySearch(data2, value2) == -1) {
            System.out.println("Data tidak ditemukan");
        } else {
            System.out.println("Data ditemukan");
        }

        System.out.println();

        System.out.println("JAWABAN SOAL #3");
        Scanner scanner = new Scanner(System.in);
        int dataCount;
        int value3;

        System.out.print("Masukkan jumlah data: ");
        dataCount = scanner.nextInt();

        int[] data3 = new int[dataCount];
        for (int i = 0; i < data3.length; i++) {
            System.out.print("Masukkan data ke-" + (i+1) + ": ");
            data3[i] = scanner.nextInt();
        }

        System.out.print("Masukkan data yang ingin dicari: ");
        value3 = scanner.nextInt();

        System.out.println();

        System.out.println("Array: " + Arrays.toString(data3));
        System.out.println("Data yang dicari: " + value3);
        if (interpolationSearch(data3, value3) == -1) {
            System.out.println("Data tidak ditemukan");
        } else {
            System.out.println("Data ditemukan");
        }
    }

    public static int sequentialSearch(int[] data, int cari) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == cari) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] data, int cari) {
        insertionSort(data);
        start = 0;
        end = data.length-1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (data[mid] == cari) {
                return mid;
            } else if (data[mid] < cari) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int interpolationSearch(int data[], int cari) {
        insertionSort(data);
        low = 0;
        high = data.length - 1;
        while (cari >= data[low] && cari <= data[high]) {
            pos = ((cari - data[low]) / (data[high]-data[low])) * (high - low) + low;
            if (data[pos] == cari) {
                return pos;
            }
            if (data[pos] > cari) {
                high = pos - 1;
            } else if (data[pos] < cari) {
                low = pos + 1;
            }
        }
        return -1;
    }

    private static int[] insertionSort(int[] data) {
        int temp, j;
        for (int i = 0; i < data.length; i++) {
            temp = data[i];
            j = i;
            while ((j > 0) && (data[j-1] > temp)) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = temp;
        }
        return data;
    }
}

package com.nazaralwi;

public class Main {
    static int temp, pos, i, j, start, end, mid;

    public static int sequential(int[] data, int cari) {
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
                end = mid + 1;
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

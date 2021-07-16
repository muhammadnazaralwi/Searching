package com.nazaralwi;

public class Main {
    int temp, pos, i, j, start, end, mid;

    public static int sequential(int[] data, int cari) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == cari) {
                return i;
            }
        }
        return -1;
    }
}

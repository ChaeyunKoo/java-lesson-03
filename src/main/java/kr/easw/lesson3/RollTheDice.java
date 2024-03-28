package kr.easw.lesson3;

import java.util.Random;

public class RollTheDice {
    private static int[] frequency = new int[6];

    private static Random RANDOM = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 600; i++) {
            if (RANDOM.nextDouble() < 0.1) {
                fillArray(RANDOM.nextDouble() * 720);
            } else {
                fillArray(RANDOM.nextDouble() * 360);
            }
        }
    }

    private static void fillArray(double result) {
        if (result > 360) {
            frequency = extendArray((int) (result / 60) + 1);
        } else {
            frequency[(int) (result / 60)]++;
        }
    }

    private static int[] extendArray(int next) {
        int[] newArray = new int[next];
        System.arraycopy(frequency, 0, newArray, 0, frequency.length);
        return newArray;
    }
}

package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {5,2,4,6,1,3,2,6};
        sort(a, 0, a.length-1);
    }
    public static void sort(int[] a, int p, int r) {
        if (p<r) {
            int q = (p + r) / 2;
            sort(a, p, q);
            sort(a, q + 1, r);
            //вариант без вывода на экран merge(a, p, q, r)
            //добавила вывод на экран для отслеживания стадий сортировки
            System.out.println(Arrays.toString(merge(a, p, q, r)));
        }
    }

    static int[] merge(int[] a, int p, int q, int r) {
        // длина правой и левой части
        int lengthLeft = q - p + 1;
        int lengthRight = r - q;

        // создание правого и левого массивов
        int[] leftArray = new int [lengthLeft];
        int[] rightArray = new int [lengthRight];

        // копируем массивы
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = a[p + i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = a[q+i+1];

        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray в массив a
        for (int i = p; i < r + 1; i++) {
             if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    a[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    a[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < lengthLeft) {
                a[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < lengthRight) {
                a[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        return a;
    }

}

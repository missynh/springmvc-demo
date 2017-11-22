package com.ynh.myproject.service;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * Created by ynh on 2017/9/20.
 */
public class FindOnceNum {

    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length < 2) {
            return;
        }

        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }

        int indexOf1 = findFirstBitIs(temp);
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

//        System.out.print(num1[0]);
//        System.out.print(num2[0]);
    }

    private int findFirstBitIs(int num) {

        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit) < 8 * 4) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;

    }

    private boolean isBit(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] array = {12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 12, 13, 14, 16, 17, 18, 19, 21, 22};
        int[] num1 = {20};
        int[] num2 = {20};
        FindOnceNum findOnceNum = new FindOnceNum();
        findOnceNum.findNumsAppearOnce(array, num1, num2);
    }

}

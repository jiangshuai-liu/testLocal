package com.work1;

import java.util.Random;

/**
 * @Title Common
 * @Author Administrator
 * @Description
 * @Date 2024/9/24 15:21
 * @Version 1.0
 **/
public class Common {
    static Random r = new Random();

    public static String  getRandomCode(int length) {
        char[]arr = createAlpha();
        int num = createNum();
        String str = createVatifaction(arr,num,length);
        str = toRandom(str);
        return str;
    }
    public static char[] createAlpha(){
        char[] arr = new char[52];
        for (int i = 0; i < arr.length; i++) {
            if(i<26){
                arr[i] = (char)('a' + i);
            }
            else {
                arr[i] = (char)('A'+ i -26);
            }
        }
        return arr;
    }
    public static int createNum(){
        return r.nextInt(10);
    }

    public static String createVatifaction(char[]arr,int num,int length){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(arr.length);
            str.append(arr[index]);
        }
        str.append(num);
        return str.toString();
    }
    public static String toRandom(String str){
        char[]arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char temp = ' ';
            int index = r.nextInt(arr.length);
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return new String(arr);
    }

}

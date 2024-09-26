package work1;

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
    public static void main(String[] args) {
        char[]arr = createAlpha();
        int num = createNum();
        String str = createVatifaction(arr,num);
        str = toRandom(str);
        System.out.println(str);
    }
    public static char[] createAlpha(){
        char[] arr = new char[52];
        for (int i = 0; i < arr.length; i++) {
            if(i<26){
                arr[i] = (char)('a' + i);
            }
            else
                arr[i] = (char)('A'+ i -26);
        }
        return arr;
    }
    public static int createNum(){
        int x = r.nextInt(10);
        return x;
    }
    public static String createVatifaction(char[]arr,int num){
        String str = "";
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(arr.length);
            str += arr[index];
        }
        str += num;
        return str;
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
        String newstr = new String(arr);
        return newstr;
    }

}

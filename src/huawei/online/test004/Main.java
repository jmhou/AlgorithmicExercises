package test004;

import java.util.Scanner;

public class Main {
    /**
     * HJ4 字符串分隔
     * 描述
     * •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * （注：本题有多组输入）
     * 输入描述：
     * 连续输入字符串(输入多次,每个字符串长度小于等于100)
     *
     * 输出描述：
     * 依次输出所有分割后的长度为8的新字符串
     *
     * 示例1
     * 输入：
     * abc
     * 123456789
     * 输出：
     * abc00000
     * 12345678
     * 90000000
     *
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String input = sc.nextLine();
            if((input+"X").equals("X")){
                return;
            }

            int count = input.length()/8;
            int last = input.length()%8;

            if( last !=0 ){
                input = input + "00000000".substring(0,8-last);
            }

            /**
             * 1. 长度0,不输出
             * 2. 长度不足8，输出多余的
             * 3. 长度超过8,8的倍数，余下不足8的
             */
            for(int i = 0;i<count;i++){
                System.out.println(input.substring(0+8*i,8+8*i));
            }
            System.out.println(input.substring(input.length()-8));
        }
    }
}

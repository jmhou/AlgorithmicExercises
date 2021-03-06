package test001;

import java.util.Scanner;

public class Main {
    /**
     * HJ1 字符串最后一个单词的长度
     * 描述
     * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
     * 输入描述：
     * 输入一行，代表要计算的字符串，非空，长度小于5000。
     *
     * 输出描述：
     * 输出一个整数，表示输入字符串最后一个单词的长度。
     * 示例1
     * 输入：hello nowcoder
     * 输出：8
     * 说明： 最后一个单词为nowcoder，长度为8
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 直接拆分输入行，获取最后一个子串，再去长度属性
         */
        String[] words = sc.nextLine().split(" ");
        System.out.println(words[words.length - 1].length());
    }
}

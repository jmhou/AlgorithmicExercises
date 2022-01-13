package test002;

import java.util.Scanner;

public class FindTimes {
    /**
     * HJ2 计算某字符出现次数
     * 描述
     * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
     *
     * 数据范围：
     * 输入描述：
     * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
     *
     * 输出描述：
     * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
     *
     * 示例1
     * 输入：
     * ABCabc
     * A
     *
     * 输出：
     * 2
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine().toLowerCase();
        String chr = sc.nextLine().toLowerCase();
        System.out.println(strs.length() - strs.replaceAll(chr,"").length());
    }
}

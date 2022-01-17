package test020;

import java.util.Scanner;

public class Password {
    /**
     * HJ20 密码验证合格程序
     *     描述
     *         密码要求:
     *         1.长度超过8位     length
     *         2.包括大小写字母.数字.其它符号,以上四种至少三种
     *         3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）  //3个相同， 4个相同包含3个相同
     *         数据范围：输入的字符串长度满足
     *
     *         本题有多组输入
     *
     *         输入描述：
     *         一组或多组字符串。每组占一行
     *
     *         输出描述：
     *         如果符合要求输出：OK，否则输出NG
     *
     *         示例1
     *         输入：
     *         021Abc9000
     *         021Abc9Abc1
     *         021ABC9000
     *         021$bc9000
     *         复制
     *         输出：
     *         OK
     *         NG
     *         NG
     *         OK
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String result = "OK";
        while (sc.hasNextLine()){
            String password = sc.nextLine();

            if (password.length() < 8){
                result = "NG";
            }

        }
    }
}

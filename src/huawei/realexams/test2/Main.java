package test2;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    /**
     *     前缀模糊匹配
     *     匹配上了就输出，
     *     匹配不上就返回前缀
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] input = in.nextLine().replaceAll("[,\\.]","").replaceAll("'"," ").split(" ");
            String preWord = in.nextLine();
            StringBuilder output = new StringBuilder();

            //
            Arrays.sort(input);
            for(int i = 0;i<input.length;i++){
                // 去重判断
                if(i>0 && input[i-1].equals(input[i])){
                    continue;
                }

                if(input[i].length() > preWord.length() &&
                        preWord.equals(input[i].substring(0,preWord.length()))){
                    output.append(input).append(" ");
                }

            }
            if(output.length() > 1){
                System.out.println(String.valueOf(output).trim());
            }else{
                System.out.println(preWord);
            }
        }
    }
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class sparseArray {

    /**
     * day001 稀疏数组的练习
     * 1)将二维数组转为稀疏数组保存到磁盘上，比如 map.data
     * 2)恢复原来的数组时，读取map.data进行恢复
     */
    public static void main(String[] args) {

        int nums[][] = new int[11][11];
        nums[1][2] = 1;
        nums[2][3] = 2;
        nums[3][4] = 1;

        // 打印原始二维数组   %d  %s
        System.out.println("原始二维数组：");
        arrayPrint(nums);

        // 二维数组转稀疏数组
        int newNums[][] = toSparseArray(nums);

        // 打印新的二维数组
        System.out.println("稀疏数组：");
        arrayPrint(newNums);

        // 保存稀疏数组
        saveSparseArray(newNums,"map.data");

        // 读取稀疏数组
        int sparseArr[][] = readSparseArray("map.data");

        // 打印稀疏数组
        System.out.println("稀疏文件数组：");
        arrayPrint(sparseArr);

        // 还原二维数组
        int originNums[][] = toOriginArray(sparseArr);

        // 打印二维数组
        System.out.println("稀疏还原后的二维数组：");
        arrayPrint(originNums);

    }

    /**
     * 打印二维数组
     * @param arr
     */
    private static void arrayPrint(int[][] arr){
        for(int[] row : arr){
            for(int num : row){
                System.out.printf("%d\s",num); //测试
            }
            System.out.printf("\n");
        }
    }

    /**
     * 二维数组转稀疏数组
     * @param nums
     * @return
     */
    private static int[][] toSparseArray(int[][] nums){
        int[][] newNums = nums;

        // 遍历原始二维数组，获取有效值的个数
        int sum = 0;
        for (int[] row : nums) {
            for(int num : row){
                if(num != 0){
                    sum++;
                }
            }
        }
        // 再遍历原始二维数组，设置到稀疏数组中
        newNums = new int[sum+1][3]; // 多一行记录行数，列数，个数
        newNums[0][0] = nums.length;
        newNums[0][1] = nums[0].length;
        newNums[0][2] = sum;
        int count = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(nums[i][j] != 0) {
                    newNums[count][0] = i;
                    newNums[count][1] = j;
                    newNums[count][2] = nums[i][j];
                    count++;
                }
            }
        }

        return newNums;
    }


    /**
     * 稀疏数组还原二维数组
     * @param nums
     * @return
     */
    private static int[][] toOriginArray(int[][] nums){
        int[][] oldNums = new int[nums[0][0]][nums[0][1]];
        // 遍历稀疏数组，设置原始二维数组
        for(int i=1;i<nums.length;i++){
            oldNums[nums[i][0]][nums[i][1]] = nums[i][2];
        }

        return oldNums;
    }

    /**
     * 数组保存到文件
     * @param nums
     * @return
     */
    private static String saveSparseArray(int[][] nums,String fileName){
        String message = "save successful.";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for(int[] row : nums) {
                StringBuilder sb = new StringBuilder();
                for(int num : row) {
                    sb.append(num + " ");
                }
                sb.deleteCharAt(sb.length()-1);
                bw.write(sb.toString());
                bw.newLine();   // 通用的换行方法
            }
            bw.close();
        }
        catch (Exception e){
            message = e.getMessage();
        }

        return message;
    }

    private static int[][] readSparseArray(String fileName){
        int nums[][] = new int[1][1];
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String row[] = br.readLine().split(" ");
            nums = new int[Integer.parseInt(row[2])+1][3];
            nums[0][0] = Integer.parseInt(row[0]);
            nums[0][1] = Integer.parseInt(row[1]);
            nums[0][2] = Integer.parseInt(row[2]);

            for(int i=0;i<nums[0][2];i++){
                row = br.readLine().split(" ");
                nums[i+1][0] = Integer.parseInt(row[0]);
                nums[i+1][1] = Integer.parseInt(row[1]);
                nums[i+1][2] = Integer.parseInt(row[2]);
            }
        }catch(Exception e){
            nums = null;
        }

        return nums;
    }
}

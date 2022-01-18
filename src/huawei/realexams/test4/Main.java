package test4;


import java.io.File;
import java.util.*;

public class Main {
    /**
     * 遍历某个文件夹下的所有的文件，获取所有的文件名，根据文件后缀分类；并对分类与 文件名都进行任意一种排序；
     *
     * @param args
     */
    public static void main(String[] args) {
        // 定义文件对象
        File originFile = new File("E:");
        List<String> filenames = getFileName(new ArrayList<>(),originFile);

        Collections.sort(filenames);
        Map<String,List<String>> map = new TreeMap<>();
        filenames.forEach(fileName -> {
            String suffix = fileName.substring(fileName.lastIndexOf("\\.")+1);
            if(!map.keySet().contains(suffix)){
                map.put(suffix,new ArrayList<>());
            }
            map.get(suffix).add(fileName);
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,List<String>> en : map.entrySet()){
            sb.append(en.getKey()).append("=").append(en.getValue()).append(";");
        }

        System.out.println(String.valueOf(sb).substring(0,sb.length()-1));
    }

    public static List<String> getFileName(List<String> list, File file){
        File[] files = file.listFiles();
        if(files == null || files.length == 0){
            return list;
        }
        for(int i = 0;i<files.length;i++){
            if(files[i].isFile()){
                list.add(files[i].getName());
                continue;
            }
            list = getFileName(list,files[i]);
        }
        return list;
    }
}

































package day002;

import java.util.Scanner;

public class ArrayQueueDemo {

    /**
     * 队列：先进先出
     *
     * 排队场景
     *
     * 数组（数序存储） || 链表（链式存储）
     *
     * 队列容量：maxSize
     * 对头取，队尾存
     *
     * 添加 / 是否满
     * 获取 / 是否空
     *
     * 数组队列：
     * 容量
     * 队列头（队列头前一个位置）
     * 队列尾 （队尾最后一个数据）
     * 数组
     *
     * 构造器（创建队列，初始化）
     * 添加
     * 获取
     * 判断队列是否满
     * 判断队列是否空
     * 查看队列
     * 显示队列头数据
     */
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.get();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.showHeader();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }

}

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }

    public void add(int num){
        if(isFull()){
            throw new RuntimeException("队列已经满了，不能添加元素~~");
        }
        rear++;
        arr[rear] = num;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，获取不到元素~~");
        }
        front++;
        return arr[front];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int showHeader(){
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }
}
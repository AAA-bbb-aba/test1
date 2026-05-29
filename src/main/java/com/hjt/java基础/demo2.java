package com.hjt.java基础;

public class demo2 {
    int a;
    int b;

    // 1. 私有静态变量：创建类的唯一实例（饿汉式，类加载时就初始化）
    private static final demo2 aa = new demo2(1, 1);

    // 2. 私有构造方法：禁止外部new
    private demo2(int a,int b){
        this.a=a;
        this.b=b;
    }

    // 3. 静态方法：返回唯一的实例
    public static demo2 getit(){
        return aa; // 不再新建，返回已有的实例
    }

    public static void main(String[] args) {
        demo2 instance1 = demo2.getit();
        demo2 instance2 = demo2.getit();

        System.out.println(instance1 == instance2); // 输出：true
    }
}
package chapter7;


public class NotInitialization {
    /**
     * 通过子类引用父类的静态变量，只会初始化父类，子类不会被初始化
     */
//    public static void main(String[] args) {
//        System.out.println(SubClass.value);
//    }

    /**
     * 通过数组定义来引用类，不会触发此类的初始化
     * @param args
     */
//    public static void main(String[] args) {
//        SuperClass[] sca = new SuperClass[10];
//    }

    /**
     * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}

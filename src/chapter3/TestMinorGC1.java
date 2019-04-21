package chapter3;

/**
 * VM 参数 :
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 显示虚拟机运行信息(GC) 初始堆20M 最大堆20M 新生代10M Eden区和一个survivor比例8:1，即10M
 */
public class TestMinorGC1 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[3 * _1MB];
        allocation4 = new byte[4 * _1MB]; //触发Minor GC
    }
}

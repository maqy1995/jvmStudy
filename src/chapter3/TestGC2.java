package chapter3;


public class TestGC2 {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {

        byte[] allocation1,allocation2,allocation3,allocation4,allocation5;

        allocation2 = new byte[4*_1MB];

        allocation3 = new byte[4*_1MB];
        allocation1 = new byte[_1MB/4];
        allocation4 = new byte[_1MB/4];
        allocation5 = new byte[_1MB/4];
        allocation3 = null;
        allocation3 = new byte[4*_1MB];
    }
}

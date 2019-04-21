package chapter3;

public class TestLoop {
    public static void main(String[] args) {
        while (true){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

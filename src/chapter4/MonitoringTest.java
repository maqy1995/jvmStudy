package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MonitoringTest {
    /**
     * 内存占位符对象，一个OOMObject大约占64KB
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for(int i = 0; i < num; i++){
            //稍作延迟，令监视曲线变化更明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    /**
     * 线程死循环演示
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        },"testBysyThread");
        thread.start();
    }

    /**
     * 线程锁等待演示
     * @param lock
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }
    static class SynAddRunnable implements Runnable {
        int a,b;
        public SynAddRunnable(int a,int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println("a+b="+a+b);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        createBusyThread();
//        br.readLine();
//        Object obj = new Object();
//        createLockThread(obj);
        for(int i=0;i<100;i++){
            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2,1)).start();
        }
    }
}

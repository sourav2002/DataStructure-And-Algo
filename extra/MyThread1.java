package extra;

public class MyThread1 extends Thread {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                sleep(1000);
                System.out.println("done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

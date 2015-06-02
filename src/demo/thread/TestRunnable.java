package demo.thread;

/**
 * Created by jiangbin on 15/6/1.
 */
public class TestRunnable {
    public static void main(String[] args) {
        DoSomething ds1=new DoSomething("李三");
        DoSomething ds2=new DoSomething("王五");
        Thread thread1=new Thread(ds1);
        Thread thread2=new Thread(ds2);
        thread1.start();
        thread2.start();
    }

}

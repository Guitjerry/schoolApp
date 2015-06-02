package demo.thread;

/**
 * Created by jiangbin on 15/6/1.
 */
public class DoSomething implements Runnable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoSomething(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            for (long k = 0; k < 1000000000; k++) ;
            System.out.println(name + ": " + i);
        }
    }
}

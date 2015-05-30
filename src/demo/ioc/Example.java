package demo.ioc;

/**
 * Created by jiangbin on 15/5/30.
 */
public class Example {
    private DataFinder dataFinder;
    public Example(DataFinder dataFinder){
       this.dataFinder=dataFinder;
    }
    public void subff(){
        dataFinder.getData();
    }

}

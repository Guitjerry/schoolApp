package demo.ioc;

/**
 * Created by jiangbin on 15/5/31.
 */
public class OracledDataFinder implements DataFinder{

    @Override
    public void getData() {
        System.out.println("获取oracle数据");
    }
}

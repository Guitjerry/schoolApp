package demo.ioc;

/**
 * Created by jiangbin on 15/5/31.
 */
public class MysqlDataFinder implements DataFinder {

    @Override
    public void getData() {
        System.out.println("获取mysql数据");
    }
}

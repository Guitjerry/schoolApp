package demo.ioc;

/**
 * 关于ioc模式大概模拟
 */
public class Client {
    public static void main(String[] args) {
        Example example1=new Example(new MysqlDataFinder());
        Example example2=new Example(new OracledDataFinder());
        example1.subff();
        example2.subff();
    }
}

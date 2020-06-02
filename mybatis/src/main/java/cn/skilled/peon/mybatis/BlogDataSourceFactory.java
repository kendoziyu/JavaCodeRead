package cn.skilled.peon.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/1 0001 <br>
 */
public class BlogDataSourceFactory extends PooledDataSourceFactory {

    public static DataSource getBlogDataSource() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String username = "root";
        String password = "webtm2012";
        return new PooledDataSource(driver, url, username, password);
    }
}

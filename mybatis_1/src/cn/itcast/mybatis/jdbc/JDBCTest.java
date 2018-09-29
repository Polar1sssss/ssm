package cn.itcast.mybatis.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author hujtb
 * @create on 2018-09-04-13:55
 */
public class JDBCTest {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    @Test
    public void test()  {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yiibai", "root", "123");
            String sql = "select username from user where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            result = preparedStatement.executeQuery();
            while(result.next()){
                System.out.println(result.getString(1));
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            if(result != null){
                try{
                    result.close();
                }catch(Exception e){

                }
            }
            if(preparedStatement != null){
                try{
                    preparedStatement.close();
                }catch(Exception e){

                }
            }
            if(connection != null){
                try{
                    connection.close();
                }catch(Exception e){

                }
            }
        }
    }
}

package test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class test {

    private static String url ="jdbc:oracle:thin:@ec2-18-219-241-100.us-east-2.compute.amazonaws.com:1521:xe";
    private static String username="hr";
    private static String password ="hr";

    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection(url, username, password );
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select employee_id, first_name, last_name from employees");

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();


        while(resultSet.next()){
            Map<String, Object> map = new HashMap<>();

            for(int column =1; column<=columnCount; column++){

                System.out.print(metaData.getColumnName(column)+"=>"+resultSet.getObject(column));

            }
            System.out.println();
        }
    }
}

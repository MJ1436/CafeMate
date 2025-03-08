package MyProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class DB_CONN {
    public static void updateRecord(Connection connection,
    int id, String name,String email, String password)
  throws Exception {
    
    String query
      = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
    
    PreparedStatement preparedStatement
      = connection.prepareStatement(query);
    
    preparedStatement.setString(1, name);
    preparedStatement.setString(2, email);
    preparedStatement.setString(3, password);
    preparedStatement.setInt(4, id);
    preparedStatement.executeUpdate();
    
    System.out.println("Record updated successfully.");
  }

   public static void main(String args[]){
    String url = "jdbc:mysql://localhost:3306/cafedb";
    String username = "root";
    String password = "";
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
       

        updateRecord(connection,1,"Carlo","Carlo@sdsa.com","Carlo123");
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
        }
        System.out.println("Connection success");
        connection.close();
    }
    catch(Exception e){
        System.out.println(e);
    }
   }
}

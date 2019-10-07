/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connect;
import java.sql.*;
/**
 *
 * @author dell pc
 */
public class ConnectionManager 
{
 Connection con=null;
 public ConnectionManager() throws ClassNotFoundException, SQLException
 {
     Class.forName("oracle.jdbc.OracleDriver");
     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ttmdb","ttmdba");
 }
  public boolean NonQuery(String query) throws SQLException
  {
      try
      {
  PreparedStatement ps=con.prepareStatement(query);
  ps.executeUpdate();
  return true;
  }
  catch(SQLException ex)
  {
      return false;
  }
      finally
      {
        //  con.close();
      }
}
  public  ResultSet SelectQuery(String qu) throws Exception
  {
  PreparedStatement ps=con.prepareStatement(qu);
 ResultSet rs= ps.executeQuery();
 return  rs;
  }
}
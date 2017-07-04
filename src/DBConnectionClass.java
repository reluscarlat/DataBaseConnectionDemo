import java.sql.*;

/**
 * Created by relu on 02.07.2017.
 */
public class DBConnectionClass {

    private static String databasePath="jdbc:mysql://localhost:3306/testdatabase";
    private static String userName="root";
    private static String password="";

    public DBConnectionClass() {
    }

    void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //se creeaza o instanta a obiectului cu numele din String , adica se incarca driverul cu numele din string
            Connection con = DriverManager.getConnection(databasePath, userName, password);
            System.out.println("Database connection succes !");
            Statement stmt =con.createStatement();   // Statement = clasa statica folosita pentru manipularea bazei de date.
            ResultSet rs= stmt.executeQuery("SELECT * FROM persoane ");

            while(rs.next()){
                String name=rs.getString("name");
                int age=rs.getInt("age");
                System.out.print("name="+name);
                System.out.println("  age="+age);
            }
            //INTRODUCEREA DE DATE IN BAZA
           /* stmt.executeUpdate("INSERT INTO persoane(id,`name`,age) VALUES" +
                    "               (NULL,'PETRESCU',48)"); */
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

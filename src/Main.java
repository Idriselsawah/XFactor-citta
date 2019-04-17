import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; //libreria per gestire i risultati
import java.sql.Statement; //libreria usata per inserire le istruzioni di tipo SQL
import java.util.Scanner;
    
public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
    String message = "";
    String connURL = "jdbc:sqlserver://213.140.22.237\\SQLEXPRESS:1433;databaseName=XFactor;user=gottardo.joshua;password=xxx123#";
    try {
        Connection connection = DriverManager.getConnection(connURL);
        message += "connection OK\n";
        Statement stmt = connection.createStatement();
        System.out.println("Inserisci la città di cui vuoi visualizzare i guidici che ci sono nati");
        String citta = scan.nextLine();
        String sql = "SELECT * FROM Giudice WHERE LuogoDiNascita = '" + citta + "'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String first = rs.getString("Nome");
            String last = rs.getString("Cognome");
            message += first + " | " + last + "\n";
        }
        rs.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println(message); }
}
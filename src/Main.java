import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        final String URL = "jdbc:mysql://localhost:3306/cadevento";
        final String USER = "root";
        final String PASSWORD = "root99";
        final String CONSULTA = "select * from evento";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER,PASSWORD);
            System.out.println("Conectado!");

            Statement st = con.createStatement();
            System.out.println("Statement criado!");


            String query = "insert into evento (nome, local, data, participantes) values (?,?)";


            PreparedStatement stmt = con.prepareStatement(query);

            String nome = JOptionPane.showInputDialog("insira o nome");
            String local = JOptionPane.showInputDialog(("insira o local do evento"));
            String data = JOptionPane.showInputDialog("Insira a data");
            int participantes = 0; JOptionPane.showInputDialog("insira o n de participantes");
            stmt.setString(1, nome);
            stmt.setString(2, local);
            stmt.setInt(3, participantes);
            stmt.setString(4, (data));


            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Dados inseridos!");

            ResultSet resultSet = stmt.executeQuery(CONSULTA);

            while(resultSet.next()){
                System.out.println(resultSet.getString("nome"));
                System.out.println(resultSet.getString("local"));

            }
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }



    }
}

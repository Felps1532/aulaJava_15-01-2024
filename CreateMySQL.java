import java.sql.*;

public class CreateMySQL {
    public static void main(String[] args) {
        
        String status = "Nada aconteceu ainda...";

        try {
            String strCreateTable = "CREATE TABLE `mysql_connector`.`tbl_create` (`id` INT NOT NULL AUTO_INCREMENT, `nome` VARCHAR(255) NULL, PRIMARY KEY (`id`));";
            Connection conn = App.conectar();
            Statement stmSQL = conn.createStatement();
            stmSQL.addBatch(strCreateTable);
            stmSQL.executeBatch();
            stmSQL.close();
            status = "Table criada com sucesso";
        } catch (Exception e) {
            System.err.println("Ops! Algo de errado não está certo." + e);
        }
        System.out.println(status);
    }
}

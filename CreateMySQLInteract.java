import java.sql.*;
import java.util.*;

public class CreateMySQLInteract {
    public static void main(String[] args) {
        
        // DECLARAR VARIÁVEIS FORA DO LOOP!
        String status = "Nada aconteceu ainda...";
        boolean sair = false;
        String str1 = "CREATE TABLE `mysql_connector`.`";
        String str2 = "` (`id` INT NOT NULL AUTO_INCREMENT, `";
        String str3 = "` VARCHAR(255) NULL, PRIMARY KEY (`id`));";
        Scanner scan = new Scanner(System.in);
        String strCreateTable;
        Connection conn;
        Statement stmSQL = null;
        String resp;

        while (sair == false) {
            try {
                System.out.print("Digite o nome da Tabela >> ");
                String strNomeTabela = scan.nextLine();

                System.out.print("Digite o nome do campo >> ");
                String strNomeCampo = scan.nextLine();

                // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

                strCreateTable = str1 + strNomeTabela + str2 + strNomeCampo + str3;

                conn = App.conectar();
                stmSQL = conn.createStatement();
                stmSQL.addBatch(strCreateTable);
                stmSQL.executeBatch();
                stmSQL.close();
                status = "Table criada com sucesso";
                
                System.out.print("Deseja continuar [c] ou sair [s]?\n>> ");
                resp = scan.nextLine();

                // ESTRUTURA CONDICIONAL PARA SAIR OU CONTINUAR

                if (resp.equals("s") || resp.equals("S")) {
                    sair = true;
                } else {
                    sair = false;
                }
            } catch (Exception e) {
                System.err.println("Ops! Algo de errado não está certo." + e);
            }
        }
        scan.close();
        System.out.println(status);
    }
}
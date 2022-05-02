package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.util.Base64Decoder;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);						//N�o faz autoconfirma��o de commit no BD. Vai esperar a confirma��o do programador para fazer isso
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE SELLER SET BASESALARY = 2090 WHERE DEPARTMENTID = 1");
			
			//int x = 1;									//Fake erro para fazer o programa quebrar no meio dos commits e causar o rollback
			//if (x<2) {
			//	throw new SQLException("Fake error");
			//}
			
			int rows2 = st.executeUpdate("UPDATE SELLER SET BASESALARY = 3090 WHERE DEPARTMENTID = 2");
			
			conn.commit(); 									//� a confirma��o do autoCommit. Um meio de proteger os comandos SQL em um bloco de commit
			
			System.out.println("rows1 " + rows1);
			System.out.println("rows2 " + rows2);
			
		} catch (SQLException e) {
			try {
				conn.rollback();							//Caso a confirma��o do autoCommit n�o seja feita por algum erro no programa. O cath vai pegar o erro e na l�gica fazer um rollback para o estado inicial, asntes de qualquer commit
				throw new DbException("Transaction rolled back! Caused by : " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error try rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
}
}

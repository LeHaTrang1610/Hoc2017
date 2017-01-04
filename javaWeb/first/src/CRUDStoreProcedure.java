import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author USER
 *
 */
public class CRUDStoreProcedure {
	private Connection getConnection(){
		Connection connection = null;
		try {
			String dbUrl = "jdbc:sqlserver://ASUS\\SQLEXPRESS1;user=sa;password=123456;database=studentManagement";
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	private void createData(){
		try {
			Connection cnn = getConnection();
			PreparedStatement st = cnn.prepareStatement("{call dbo.insertStudent(?,?,?,?,?)}");
			st.setString(1, "SV021");
			st.setString(2, "CHAU KIET LUAN");
			st.setString(3, "04-15-1985");
			st.setString(4, "DH001");
			st.setString(5, "M");
			int rs = st.executeUpdate();
			if(rs == 1){
				System.out.println("The student was inserted successfully");
			}else{
				System.out.println("Can not insert data");
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void readData(){
		try {
			Connection cnn = getConnection();
			Statement st = cnn.createStatement();
			ResultSet rs = st.executeQuery("{call dbo.getStudent}");
			while(rs.next()){
				System.out.println(rs.getString("MSSV"));
				System.out.println(rs.getString("HOTEN"));
				System.out.println(rs.getString("NGAYSINH"));
				System.out.println(rs.getString("LOP"));
				System.out.println("--------------------");
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updateData(){
		try {
			Connection cnn = getConnection();
			PreparedStatement st = cnn.prepareStatement("{call dbo.updateStudent(?,?)}");
			st.setString(1, "SV104");
			st.setString(2, "HA NHUAN DONG");
			int rs = st.executeUpdate();
			if(rs == 1){
				System.out.println("The student was updated successfully");
			}else{
				System.out.println("Can not update data");
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteData(){
		try {
			Connection cnn = getConnection();
			PreparedStatement st = cnn.prepareStatement("{call dbo.deleteStudent(?)}");
			st.setString(1, "SV111");
			int rs = st.executeUpdate();
			if(rs == 1){
				System.out.println("The student was deleted successfully");
			}else{
				System.out.println("Can not delete data");
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		CRUDStoreProcedure crudService = new CRUDStoreProcedure();
		//crudService.createData();
		//crudService.readData();
		//crudService.updateData();
		crudService.deleteData();
		//crudService.countData();

	}

}

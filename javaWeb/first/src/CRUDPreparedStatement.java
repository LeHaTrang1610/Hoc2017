
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDPreparedStatement {

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
			String sql = "insert into student(MSSV, HOTEN, NGAYSINH, LOP, GIOITINH) values (?,?,?,?,?)";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, "SV020");
			st.setString(2, "CHAU KIET LUAN");
			st.setString(3, "06-17-1985");
			st.setString(4, "DH002");
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
			String sql = "select * from student where MSSV = ?";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, "SV100");
			ResultSet rs = st.executeQuery();
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
			String sql = "update student set HOTEN = ? where MSSV = ? ";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, "BAO THANH THIEN");
			st.setString(2, "SV020");			
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
			String sql = "delete student where MSSV = ? ";
			PreparedStatement st = cnn.prepareStatement(sql);	
			st.setString(1, "SV020");
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
	public static void main(String[] args){
		CRUDPreparedStatement crudService = new CRUDPreparedStatement();
//	crudService.createData();
//		crudService.readData();
	//	crudService.updateData();	
		crudService.deleteData();
		
	}
}

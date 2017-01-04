import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */

/**
 * @author USER
 *
 */
public class willBeDelete {
	
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
	
	
	private void createData() {
		try {
			Connection cnn = getConnection();
			String sql = "insert into student(mssv, hoten, ngaysinh, lop, gioitinh) values (?,?,?,?,?)";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, "t109");
			st.setString(2, "Nguyen Thuy A");
			st.setString(3, "06-17-1985");
			st.setString(4, "k20");
			st.setString(5, "G");
			int rs =st.executeUpdate();
			if(rs == 1){
				System.out.println("The student was insert successfully");
			}else {
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
			st.setString(1, "SV101");
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("MSSV"));
				System.out.println(rs.getString("HOTEN"));
				System.out.println(rs.getString("NGAYSINH"));
				System.out.println(rs.getString("LOP"));
				System.out.println("--------------------");
			}
			//rs.close();
			//st.close();
			//cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updateData(){
		try {
			Connection cnn = getConnection();
			String sql = "update student set HOTEN = ? where MSSV = ? ";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, "THANH THIEN");
			st.setString(2, "SV103");			
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
			String sql = "delete student where hoten = ? ";
			PreparedStatement st = cnn.prepareStatement(sql);	
			st.setString(1, "BAO THANH THIEN");
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
		// TODO Auto-generated method stub
		willBeDelete willdelete = new willBeDelete();
		willdelete.createData();
		//willdelete.readData();
		//willdelete.updateData();
		//willdelete.deleteData();
	}

}

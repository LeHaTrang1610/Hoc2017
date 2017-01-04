
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class CRUDService {
	private Connection getConnection(){
		Connection connection = null;
		try{
			String dbUrl = "jdbc:sqlserver://ASUS\\SQLEXPRESS1;user=sa;password=123456;database=studentManagement";
			connection = DriverManager.getConnection(dbUrl);
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;		
	}
	
	private void createData(){
		try{
				Connection cnn = getConnection();
				Statement st = cnn.createStatement();
				String sql = "insert into student(MSSV, HOTEN, NGAYSINH, LOP, GIOITINH) values ('SV100','Nguyen Van E', '06-17-2016','DH002', 'M')";
				int sr = st.executeUpdate(sql);
				if(sr == 1){
					System.out.print("the student was insert successfully");
					
				}else{
					System.out.println("Cannot insert data");
				}
				st.close();
				cnn.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void readData(){
		try {
			Connection cnn = getConnection();
			Statement st = cnn.createStatement();
			String sql ="select * from student";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("mssv"));
				System.out.println(rs.getString("hoten"));
				System.out.println(rs.getString("ngaysinh"));
				System.out.println(rs.getString("lop"));
				System.out.println(rs.getString("gioitinh"));
				
				System.out.println("------------------------");
			}
			rs.close();
			st.close();
			cnn.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
	private void updateData(){
		try {
			Connection cnn = getConnection();
			Statement st = cnn.createStatement();
			String sql = "update student set HOTEN ='Nguyen thi A' where MSSV = '1234500' ";
			int rs = st.executeUpdate(sql);
			if(rs ==1){
				System.out.println("The student was updated was updated successfully");
				
			}else{
				System.out.println("Cannot update data");
			}
			st.close();
			cnn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
	private void deleteData(){
		try {
			Connection cnn = getConnection();
			Statement st = cnn.createStatement();
			String sql = "delete student where mssv='1234500' or 1=1";
			int rs = st.executeUpdate(sql);
			if(rs ==1){
				System.out.println("The student was updated was updated successfully");
				
			}else{
				System.out.println("Cannot update data");
			}
			st.close();
			cnn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args){
		CRUDService crudService = new CRUDService();
		/*crudService.createData();*/
//		crudService.readData();
	//	crudService.updateData();
	crudService.deleteData();
	}
}

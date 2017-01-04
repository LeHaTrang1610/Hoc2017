

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TinhToan
 */
public class TinhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String so1 = request.getParameter("input1");
		String so2 = request.getParameter("input2");
		String so3 = request.getParameter("input3");
		
		String value = request.getParameter("pheptinh");
		
		double i1 = Double.parseDouble(so1);
		double i2 = Double.parseDouble(so2);
		double i3 = Double.parseDouble(so3);
		
		double ketqua=0;
		if (value.equals("Cong")) {
			ketqua = i1 +i2 + i3;
		}
		if (value.equals("Tru")) {
			ketqua = i1 -i2 - i3;
		}
		if (value.equals("Nhan")) {
			ketqua = i1 *i2 * i3;
		}
		if (value.equals("Chia")) {
			ketqua = i1 /i2 / i3;
		}
		
		request.setAttribute("ketqua", ketqua);
		request.getRequestDispatcher("TinhToan.jsp").forward(request, response);
		
	
	}

}

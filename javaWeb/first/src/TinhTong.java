

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TinhTong
 */
public class TinhTong extends HttpServlet {
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
		String soa = request.getParameter("input");
		int n = Integer.parseInt(soa);
		double ketqua=0;
		for(int i=0;i<=n;i++){
			ketqua=ketqua+i;
		}
		request.setAttribute("ketqua", ketqua);
		request.getRequestDispatcher("Tinhtong.jsp").forward(request, response);
	}

}

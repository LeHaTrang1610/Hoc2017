
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculatoServlet
 */
public class CalculatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String soa = request.getParameter("lba");
		String sob = request.getParameter("lbb");
		String value = request.getParameter("pheptinh");

		double d1 = Double.parseDouble(soa);
		double d2 = Double.parseDouble(sob);
		
		double ketqua=0;
		if (value.equals("Cong")) {
			ketqua = d1 + d2;
			//String ketqua = Double.toString(Cong);
		}
		if (value.equals("Tru")) {
			ketqua = d1 - d2;
		}
		if (value.equals("Nhan")) {
			ketqua = d1 * d2;
		}
		if (value.equals("Chia")) {
			ketqua  = d1 / d2;
		}

		//Object ketqua = null;
		request.setAttribute("ketqua", ketqua);
		request.getRequestDispatcher("Caculator.jsp").forward(request, response);
	}

}

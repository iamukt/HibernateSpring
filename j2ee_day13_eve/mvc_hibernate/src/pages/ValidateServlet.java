package pages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CustomerBean;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// req processing
			String em = request.getParameter("f1");
			String pass = request.getParameter("f2");
			// bean inst --setters --add it to scope
			CustomerBean c1 = new CustomerBean();
			c1.setEmail(em);
			c1.setPass(pass);
			request.setAttribute("cust", c1);
			// B.L
			String sts = c1.validateUser();
			// rd
			RequestDispatcher rd = request.getRequestDispatcher(sts
					.concat(".jsp"));
			if(rd != null)
				rd.forward(request, response);
			System.out.println("came back....");
		} catch (Exception e) {
			throw new ServletException("err in validate's do-get", e);
		}
	}

}

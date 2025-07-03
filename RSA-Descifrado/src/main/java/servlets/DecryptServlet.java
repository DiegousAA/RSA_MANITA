package servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.BigInteger;

public class DecryptServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    BigInteger C = new BigInteger(request.getParameter("cifrado"));
    BigInteger d = new BigInteger(request.getParameter("d"));
    BigInteger n = new BigInteger(request.getParameter("n"));
    BigInteger M = C.modPow(d, n);
    request.setAttribute("mensaje", new String(M.toByteArray()));
    request.getRequestDispatcher("resultado.jsp").forward(request, response);
  }
}

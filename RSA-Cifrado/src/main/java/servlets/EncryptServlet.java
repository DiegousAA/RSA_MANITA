package servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.BigInteger;

public class EncryptServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String mensaje = request.getParameter("mensaje");
    int p = 61, q = 53;
    int n = p * q;
    int phi = (p - 1) * (q - 1);
    int e = 17;
    int d = 2753;
    BigInteger M = new BigInteger(mensaje.getBytes());
    BigInteger C = M.modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
    request.setAttribute("cifrado", C.toString());
    request.setAttribute("n", n);
    request.setAttribute("d", d);
    request.getRequestDispatcher("resultado.jsp").forward(request, response);
  }
}

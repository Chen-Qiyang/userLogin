import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private String username;
    private String password;

    protected  void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        username = request.getParameter("username");
        password = request.getParameter("password");

        response.sendRedirect("login.jsp");
    }
}

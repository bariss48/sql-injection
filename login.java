import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class LoginServlet extends HttpServlet {
 
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbname", "root", "password");


            // ? ile sorgunun sadece istenilen kısmına kullanıcıdan gelen stringi vermek istediğimizi söylüyoruz.
            PreparedStatement ps = con.prepareStatement("select * from users where username=? and password=?");
            // Buarada ise kullanıcıdan gelen değerleri (parametreden) , sorgudaki ? yerler ile replace ediyoruz .
            ps.setString(1, username);
            ps.setString(2, password);

            //Buarada ise sql sorgu işlemini yapıyoruz eğer kullanıcı varsa if bloğunun ilk kısmı execute() ediliyor yok ise else kısmı
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                out.print("Welcome, " + username);
                HttpSession session = request.getSession();
                session.setAttribute("name", username);
            } else {
                out.print("Sorry, username or password error!");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }
        } catch (Exception e) {
            out.print(e);
        }
    }
}


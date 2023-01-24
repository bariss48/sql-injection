import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class LoginServlet extends HttpServlet {
 
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Kullanıcıdan alınan girdiler 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Database Bağlantısı
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbname", "root", "password");

            // Kullanıcıdan gelen veriyi doğrudan sorguya kattığımız için manipüle edilebilir hale gelmiş oluyor bu sebepten buarada sql injection saldırısı yapılabilir. password = ' OR 1=1 ' 
            // Querydeki 'users' , kullanıcıların verilerinin tutulduğu sql tablosunun ismi
            String query = "SELECT * FROM users WHERE username='" + username + "' and password = '" + password + "'";

            Statement stmt = null;
            stmt = con.createStatement();

            // kullanıcıdan gelen verilerle oluşturulan sorguyu doğrudan veritabanına attığımız yer
            ResultSet rs = stmt.executeQuery(query);

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


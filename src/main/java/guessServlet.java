import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "guessServlet", urlPatterns = "/guess")
public class guessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/guessNumber.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userguess = Integer.valueOf(req.getParameter("userguess"));
        int randomNum = (int) ((Math.random() * 3) + 1);
        System.out.println("User guess: " + userguess);
        System.out.println("Random number: " + randomNum);
        if (userguess < 1 || userguess > 3) {
            resp.sendRedirect("/guess");
        } else if (userguess == randomNum) {
            req.getRequestDispatcher("/correct").forward(req, resp);
//            RequestDispatcher dispatcher =
//                    getServletContext().getRequestDispatcher("/correct");
//            dispatcher.forward(req, resp);
//            req.getRequestDispatcher("/correct").forward(req, resp);
//            String result = "You Won!";
//            resp.getWriter().println("<h1>You won!</h1>");
//            resp.sendRedirect("/correct");

        } else {
//            resp.sendRedirect("/incorrect");
            req.getRequestDispatcher("/incorrect").forward(req, resp);
        }

    }
}

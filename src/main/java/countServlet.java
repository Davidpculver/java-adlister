import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class countServlet extends HttpServlet {
    //    initiate the counter. Must be outside the doGet. If it is placed inside the doGet, it resets back to 0 everytime the page gets refreshed.
    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Page count: " + counter + "</h1>");
// try catch is not needed in this instance. Just the if/else
        try {
//        check for param of reset, if set to !yes, increments counter. Otherwise, resets the counter
            boolean reset = req.getParameter("reset").equalsIgnoreCase("yes");
            if (!reset) {
                counter += 1;
//                out.println(counter);
            } else {
                counter = 0;
                resp.sendRedirect("/count?reset=no");
            }
        } catch (Exception e) {
            resp.sendRedirect("/count?reset=yes");
        }
    }
}

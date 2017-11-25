
package me.u6k.sample.sample_http_session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }

        int count = (Integer) session.getAttribute("count") + 1;
        session.setAttribute("count", count);

        resp.setContentType("text/plain");
        resp.getWriter().write("count=" + count);
    }

}

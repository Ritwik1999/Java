package firstservletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ColloquiumServlet")
public class ColloquiumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ColloquiumServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        int papersPublished = Integer.parseInt(request.getParameter("papers-published"));
        String feesPaid[] = request.getParameterValues("fees");

        if (papersPublished > 3 && feesPaid != null) {
            out.println("Welcome " + "Mr. " + name + " . You are eligible to attend the colloquium");
        } else {
            out.println("You are not eligible");
        }
    }
}
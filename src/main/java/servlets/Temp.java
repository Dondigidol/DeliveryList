package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Temp", urlPatterns = "{/temp.xhtml}")
public class Temp extends HttpServlet {

    public Temp() {

    }

    public void doPost(HttpServletRequest req,
                       HttpServletResponse res) throws ServletException {

    }

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res) throws ServletException {

    }

}

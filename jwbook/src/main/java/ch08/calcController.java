package ch08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calcControl")
public class calcController extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public calcController() {
       super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int n1 = Integer.parseInt(request.getParameter("n1"));
      int n2 = Integer.parseInt(request.getParameter("n2"));
      String op = request.getParameter("op");
      
      response.setContentType("text/html; charset=utf-8");      
      
      long result = 0;      
      
      switch(op){      	
         case "+": result=n1+n2; break;
        	 
         case "*": result=n1*n2; break;
        	 
         case "-": result=n1-n2; break;
        	 
         case "/": result=n1/n2; break;
      }
      request.setAttribute("result", result);
      getServletContext().getRequestDispatcher("/ch08/calcResult.jsp")
      .forward(request, response);
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }
}

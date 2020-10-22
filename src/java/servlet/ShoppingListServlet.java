/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 832465
 */

public class ShoppingListServlet extends HttpServlet {
    
    ArrayList<String>listOfItems = new ArrayList<>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
          
          HttpSession session = request.getSession();
          String action = request.getParameter("action");
          
          if(action.equals("logout")) {
              session.invalidate();
              response.sendRedirect(request.getContextPath() + "/ShoppingList");
              return;
          }
          
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        switch(action) {
            case "register":
                String username = request.getParameter("username");
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
                break;
                
            case "add":
                listOfItems.add(request.getParameter("Add item"));
                session.setAttribute("itemsList", listOfItems);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
                break;
           
            case  "delete":
                String itemsAdded = request.getParameter("itemsAdded");
                if(itemsAdded == null | itemsAdded.equals("")){
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList").forward(request, response);
                    return;     
                }
                else{
                int counter = 0;
                for(int i = 0; i < listOfItems.size(); i++) {
                    String itemSelected = listOfItems.get(i);
                    if(itemSelected.equals(itemsAdded)){
                        listOfItems.remove(i);
                        counter++;
                    }
                }
                
                if(counter > 0) {
                    session.setAttribute("itemsList", listOfItems);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList").forward(request, response);
                }
                
                }
                break;
                      
            
        }
        
       
        
    }

    
}

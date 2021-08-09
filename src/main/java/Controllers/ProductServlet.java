package Controllers;

import Daos.ProductDao;
import Models.Product;
import Services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {""})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        RequestDispatcher requestDispatcher=null;
        if(action==null){
            action="";
        }
        switch (action){
            case "edit":
                String productId=req.getParameter("productId");
                req.setAttribute("idProduct",productId);
                requestDispatcher=req.getRequestDispatcher("/views/edit.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "remove":
                String productRemoveId=req.getParameter("productId");
                try {
                    ProductService.removeProduct(productRemoveId);
                    resp.sendRedirect("/");
                    break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            default:
                try {
                    req.setAttribute("List", ProductService.selectAllProduct());
                    requestDispatcher=req.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        RequestDispatcher requestDispatcher=null;
        if(action==null){
            action="";
        }
        switch (action){
            case "edit":
                String productId=req.getParameter("productId");
                String name=req.getParameter("name");
                int price=Integer.parseInt(req.getParameter("price"));
                int soluong=Integer.parseInt(req.getParameter("soluong"));
                String color=req.getParameter("color");
                String about=req.getParameter("about");
                String category=req.getParameter("category");
                Product Product=new Product(1,name,price,soluong,color,about,category);
                try {
                    ProductService.updateProduct(productId,Product);
                    resp.sendRedirect("/");
                    break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            case "create":
                String name1=req.getParameter("name");
                int price1=Integer.parseInt(req.getParameter("price"));
                int soluong1=Integer.parseInt(req.getParameter("soluong"));
                String color1=req.getParameter("color");
                String about1=req.getParameter("about");
                String category1=req.getParameter("category");
                Product Product1=new Product(1,name1,price1,soluong1,color1,about1,category1);
                try {
                    ProductDao.createProduct(Product1);
                    resp.sendRedirect("/");
                    break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            case "find":
                String findname=req.getParameter("find");
                try {
                    req.setAttribute("List", ProductService.FindProduct(findname));
                    requestDispatcher=req.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(req,resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }
}

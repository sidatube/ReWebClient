package com.example.rewebclient.controller;

import com.example.rewebclient.Service.ProductService;
import com.example.rewebclient.entity.Product;
import com.example.rewebclient.retrofiet.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "productServlet", value = "/products/create")
public class ProductServlet extends HttpServlet {
    ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/_id.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        BigDecimal price = new BigDecimal(0);
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        try {
            price = new BigDecimal( req.getParameter("price"));
        } catch (Exception e) {
            System.err.println(e);
        }
        Product food = new Product();
        food.setName(name);

        food.setPrice(price);
        HashMap<String, String> errors;


        if (productService.save(food).execute().isSuccessful()) {
            req.setAttribute("success", "Create success");
        }else {
            req.setAttribute("createFail", "Create fail");
        }

        req.getRequestDispatcher("/_id.jsp").forward(req, resp);    }
}

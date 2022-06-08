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
@WebServlet(name = "FindProductServlet", value = "/products/detail")
public class FindProductServlet extends HttpServlet {
    ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {
            resp.getWriter().println(e);
        }
        if (id <= 0) {
            resp.getWriter().println("Is valid information");
            return;
        }
        Product obj = productService.getProductDetail(id).execute().body();
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
            return;
        }
        req.setAttribute("product", obj);
        req.getRequestDispatcher("/Admin/Food/detail.jsp").forward(req, resp);
    }
}

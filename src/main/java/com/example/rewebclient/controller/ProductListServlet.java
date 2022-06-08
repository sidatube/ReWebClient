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
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/products")
public class ProductListServlet extends HttpServlet {
    ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts().execute().body();
        req.setAttribute("listProduct",products );
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }

}

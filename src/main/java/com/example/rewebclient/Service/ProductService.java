package com.example.rewebclient.Service;

import com.example.rewebclient.entity.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductService {
    @GET("api/v1/products")
    Call<List<Product>> getProducts();

    @GET("api/v1/products/{id}")
    Call<Product> getProductDetail(@Path("id") int id);

    @POST("api/v1/products")
    Call<Product> save(@Body Product product);

    @PUT("api/v1/products/{id}")
    Call<Boolean> update(@Path("id") int id, @Body Product product);

    @DELETE("api/v1/products/{id}")
    Call<Boolean> delete(@Path("id") int id);


}

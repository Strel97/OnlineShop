package com.hellstudios.weedstore.api.product;

import com.hellstudios.weedstore.api.API;
import com.hellstudios.weedstore.api.APIException;

import java.util.List;

/**
 * @author strel
 */
public interface ProductAPI extends API {

    void createProduct(ProductBean account) throws APIException;

    ProductBean getProductById(String id) throws APIException;

    void updateProduct(ProductBean product) throws APIException;

    List<ProductBean> getAllProducts() throws APIException;

}

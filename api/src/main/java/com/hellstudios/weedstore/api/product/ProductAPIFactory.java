package com.hellstudios.weedstore.api.product;

import com.hellstudios.weedstore.api.APIFactory;

/**
 * @author strel
 */
public class ProductAPIFactory implements APIFactory<ProductAPI> {

    @Override
    public ProductAPI createAPI() {
        return new ProductAPIImpl();
    }
}

package com.hellstudios.weedstore.rest.product;

import com.hellstudios.weedstore.Application;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.manufacturer.ManufacturerAPI;
import com.hellstudios.weedstore.api.product.ProductAPI;
import com.hellstudios.weedstore.api.product.ProductBean;
import com.hellstudios.weedstore.api.store.StoreAPI;
import com.hellstudios.weedstore.rest.JSONResponse;
import com.hellstudios.weedstore.rest.ReplyObject;
import com.hellstudios.weedstore.util.FieldValidation;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * @author strel
 */
@Path("product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(ProductResource.class);

    /**
     * {@link ProductAPI} instance.
     */
    private ProductAPI productAPI;

    /**
     * {@link ManufacturerAPI} instance.
     */
    private ManufacturerAPI manufacturerAPI;

    /**
     * {@link StoreAPI} instance.
     */
    private StoreAPI storeAPI;


    public ProductResource() {
        try {
            productAPI = Application.getInstance().getAPI(ProductAPI.class);
            manufacturerAPI = Application.getInstance().getAPI(ManufacturerAPI.class);
            storeAPI = Application.getInstance().getAPI(StoreAPI.class);
        }
        catch (APIException ex) {
            log.error("Can't instantiate APIs", ex);
        }
    }

    @GET
    @Path("get/{id}")
    public ReplyObject getProduct(@PathParam("id") String id) {
        try {
            return ReplyObject.success("product", productAPI.getProductById(id));
        } catch (APIException ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    @GET
    @Path("get/all")
    public ReplyObject getAllProducts() {
        try {
            return ReplyObject.success("products", productAPI.getAllProducts());
        } catch (APIException ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    @POST
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ReplyObject updateProduct(@PathParam("id") String id, final ProductForm productForm) {
        JSONResponse response = validateProductData(productForm);
        if (response.hasErrors()) {
            return ReplyObject.error(response.toString());
        }

        try {
            ProductBean manufacturer = productAPI.getProductById(id);

            ProductBean store = new ProductBean();
            store.setName(productForm.getName());
            store.setDescription(productForm.getDescription());
            store.setQuantity(productForm.getQuantity());
            store.setImgName(productForm.getImage());
            store.setPrice(productForm.getPrice());
            store.setManufacturer(manufacturerAPI.getManufacturerById(productForm.getManufacturerId()));
            store.setStore(storeAPI.getStoreById(productForm.getStoreId()));

            productAPI.updateProduct(manufacturer);

            return ReplyObject.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ReplyObject.error(e.getMessage());
        }
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public ReplyObject createProduct(final ProductForm productForm) {
        JSONResponse response = validateProductData(productForm);
        if (response.hasErrors()) {
            return ReplyObject.error(response.toString());
        }

        try {
            ProductBean store = new ProductBean();
            store.setName(productForm.getName());
            store.setDescription(productForm.getDescription());
            store.setQuantity(productForm.getQuantity());
            store.setImgName(productForm.getImage());
            store.setPrice(productForm.getPrice());
            store.setManufacturer(manufacturerAPI.getManufacturerById(productForm.getManufacturerId()));
            store.setStore(storeAPI.getStoreById(productForm.getStoreId()));

            productAPI.createProduct(store);

            return ReplyObject.success();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ReplyObject.error(ex.getMessage());
        }
    }

    private JSONResponse validateProductData(final ProductForm productForm) {
        JSONResponse response = new JSONResponse();

        FieldValidation.validateName(productForm.getName(), response);

        return response;
    }
}

package com.hellstudios.weedstore.api.product;

import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.core.persistence.DAOException;
import com.hellstudios.weedstore.core.persistence.product.ProductDAO;
import com.hellstudios.weedstore.core.persistence.product.ProductEntity;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author strel
 */
public class ProductAPIImpl implements ProductAPI {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(ProductAPIImpl.class.getName());

    /**
     * {@link ProductDAO} instance.
     */
    private ProductDAO productDAO;


    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    public void deInit() {

    }

    @Override
    public void createProduct(ProductBean product) throws APIException {
        if (product == null) {
            throw new APIException("Given product bean is null.");
        }

        try {
            // Generating UUID for id
            product.setId(UUID.randomUUID().toString());

            productDAO.openCurrentSessionWithTransaction();
            productDAO.create(product.toEntity());
            productDAO.closeCurrentSessionWithTransaction();

            log.debug(String.format("Created product %s.", product));
        } catch (DAOException ex) {
            String msg = "Can't save product in DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    @Override
    public ProductBean getProductById(String id) throws APIException {
        try {
            productDAO.openCurrentSessionWithTransaction();
            ProductEntity entity = productDAO.findById(id);
            productDAO.closeCurrentSessionWithTransaction();

            return new ProductBean(entity);
        } catch (DAOException ex) {
            String msg = "Can't get account by id from DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }

    public List<ProductBean> getAllProducts() throws APIException {
        List<ProductBean> productBeans = new ArrayList<ProductBean>();

        productDAO.openCurrentSessionWithTransaction();
        List<ProductEntity> entities = productDAO.findAll();
        productDAO.closeCurrentSessionWithTransaction();

        for (ProductEntity entity : entities) {
            productBeans.add(new ProductBean(entity));
        }

        return productBeans;
    }

    @Override
    public void updateProduct(ProductBean product) throws APIException {
        if (product == null) {
            throw new IllegalArgumentException("Can't update product, bean is null.");
        }
        if (product.getManufacturer() == null) {
            throw new IllegalArgumentException("Can't update product with empty manufacturer.");
        }
        if (product.getStore() == null) {
            throw new IllegalArgumentException("Can't update product with empty store.");
        }

        try {
            productDAO.openCurrentSessionWithTransaction();
            productDAO.update(product.toEntity());
            productDAO.closeCurrentSessionWithTransaction();

            log.debug(String.format("Updated product %s.", product));
        }
        catch (DAOException ex) {
            String msg = "Can't update product in DB";
            log.error(msg, ex);
            throw new APIException(msg, ex);
        }
    }
}

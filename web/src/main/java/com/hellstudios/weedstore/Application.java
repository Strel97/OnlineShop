package com.hellstudios.weedstore;

import com.hellstudios.weedstore.api.API;
import com.hellstudios.weedstore.api.APIConfigurator;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.APIManager;

/**
 * @author strel
 */
public class Application {

    private static final Application INSTANCE = new Application();


    private Application() {
        // Initializing APIs
        APIConfigurator.configure();
    }

    public static Application getInstance() {
        return INSTANCE;
    }

    public <T extends API> T getAPI(Class<T> identifier) throws APIException {
        return APIManager.findAPI(identifier);
    }
}

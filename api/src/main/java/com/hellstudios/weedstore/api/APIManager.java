package com.hellstudios.weedstore.api;

import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The utility for API resolution.
 *
 * @author strel
 */
public final class APIManager {

    /**
     * Storage for API instances.
     */
    private static Map<Class<? extends API>, API> apis;
    /**
     * Internal storage for API factories.
     */
    private static Map<Class<? extends API>, APIFactory<? extends API>> factories;

    /**
     * Logger.
     */
    private static Logger log;


    static {
        log = Logger.getLogger(APIManager.class);
        init();
    }

    /**
     * Return API by Identifier.
     *
     * @param identifier string clazz name
     * @return api
     */
    @SuppressWarnings("unchecked")
    public static API findAPI(String identifier) throws APIException {
        try {
            return findAPI((Class<? extends API>) Class.forName(identifier));
        } catch (ClassNotFoundException e) {
            throw new APIException("Class not found: " + identifier + ", exception: " + e.getMessage());
        }
    }

    /**
     * Returns the implementation for the given API interface clazz.
     *
     * @param <T>        the API class.
     * @param identifier T.class.
     * @return an implementation of T.
     */
    public static <T extends API> T findAPI(Class<T> identifier) throws APIException {
        @SuppressWarnings("unchecked")
        T loaded = (T) apis.get(identifier);
        if (loaded != null)
            return loaded;

        synchronized (apis) {
            @SuppressWarnings("unchecked")
            T doubleChecked = (T) apis.get(identifier);
            if (doubleChecked != null)
                return doubleChecked;

            T created = createAPI(identifier);
            apis.put(identifier, created);

            try {
                created.init();
            } catch (Exception e) {
                log.error("findAPI.init in API " + identifier, e);
                throw new APIException(identifier.getName(), e);
            }

            return created;
        }
    }

    /**
     * Creates a new instance of T.
     *
     * @param <T>        the API class to create.
     * @param identifier a pattern.
     * @return created API
     * @throws APIException if factory for API creation not founded
     */
    private static synchronized <T extends API> T createAPI(Class<T> identifier) throws APIException {
        @SuppressWarnings("unchecked")
        APIFactory<T> factory = (APIFactory<T>) factories.get(identifier);
        if (factory == null) {
            throw new APIException(identifier.getName());
        }

        return factory.createAPI();
    }

    private static void init() {
        apis = new HashMap<Class<? extends API>, API>();
        factories = new HashMap<Class<? extends API>, APIFactory<? extends API>>();
    }

    /**
     * Adds factory for resolving some API instance.
     *
     * @param apiClass      class of API
     * @param factoryObject actually factory for creating api
     * @param <T>           generic
     */
    public static <T extends API> void addAPIFactory(Class<T> apiClass, APIFactory<T> factoryObject) {
        factories.put(apiClass, factoryObject);
    }

    /**
     * Returns all registered APIs.
     * @return collection of APIs
     */
    static Collection<API> getAPIs() {
        return apis.values();
    }

    private APIManager() { /* disable constructor */}
}

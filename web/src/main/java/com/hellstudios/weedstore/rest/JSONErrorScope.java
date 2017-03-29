package com.hellstudios.weedstore.rest;

import java.io.Serializable;

/**
 * JSON Response error scope interface.
 * @author strel
 */
public interface JSONErrorScope extends Serializable {

    /**
     * Add global error for this response-scope.
     *
     * @param error - error text
     */
    void addError(final String error);

    /**
     * Add field error for this response-scope.
     *
     * @param fieldName - field name
     * @param error - error text
     */
    void addError(final String fieldName, final String error);

    /**
     * Get error object to error scope. New instance will be created if object not found in errors scope.
     *
     * @param objectName - inner error object name in error scope
     * @return {@link JSONErrorScope}
     */
    JSONErrorScope getErrorObject(final String objectName);

}

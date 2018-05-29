/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.luis.authoring.models;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Error response when invoking an operation on the API.
 */
public class ErrorResponse {
    /**
     * Unmatched properties from the message are deserialized this collection.
     */
    @JsonProperty(value = "")
    private Map<String, Object> additionalProperties;

    /**
     * The errorType property.
     */
    @JsonProperty(value = "errorType")
    private String errorType;

    /**
     * Get the additionalProperties value.
     *
     * @return the additionalProperties value
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties value.
     *
     * @param additionalProperties the additionalProperties value to set
     * @return the ErrorResponse object itself.
     */
    public ErrorResponse withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * Get the errorType value.
     *
     * @return the errorType value
     */
    public String errorType() {
        return this.errorType;
    }

    /**
     * Set the errorType value.
     *
     * @param errorType the errorType value to set
     * @return the ErrorResponse object itself.
     */
    public ErrorResponse withErrorType(String errorType) {
        this.errorType = errorType;
        return this;
    }

}
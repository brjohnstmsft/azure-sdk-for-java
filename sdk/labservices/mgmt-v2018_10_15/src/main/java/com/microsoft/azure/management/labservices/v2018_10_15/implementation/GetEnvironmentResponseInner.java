/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.labservices.v2018_10_15.implementation;

import com.microsoft.azure.management.labservices.v2018_10_15.EnvironmentDetails;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the environments details.
 */
public class GetEnvironmentResponseInner {
    /**
     * Details of the environment.
     */
    @JsonProperty(value = "environment", access = JsonProperty.Access.WRITE_ONLY)
    private EnvironmentDetails environment;

    /**
     * Get details of the environment.
     *
     * @return the environment value
     */
    public EnvironmentDetails environment() {
        return this.environment;
    }

}

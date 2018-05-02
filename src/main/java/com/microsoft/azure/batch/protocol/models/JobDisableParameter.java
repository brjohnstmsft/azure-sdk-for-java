/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Options when disabling a job.
 */
public class JobDisableParameter {
    /**
     * What to do with active tasks associated with the job.
     * Possible values include: 'requeue', 'terminate', 'wait'.
     */
    @JsonProperty(value = "disableTasks", required = true)
    private DisableJobOption disableTasks;

    /**
     * Get the disableTasks value.
     *
     * @return the disableTasks value
     */
    public DisableJobOption disableTasks() {
        return this.disableTasks;
    }

    /**
     * Set the disableTasks value.
     *
     * @param disableTasks the disableTasks value to set
     * @return the JobDisableParameter object itself.
     */
    public JobDisableParameter withDisableTasks(DisableJobOption disableTasks) {
        this.disableTasks = disableTasks;
        return this;
    }

}
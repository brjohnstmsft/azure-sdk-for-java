/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.v2018_09_01;

import rx.Observable;
import com.microsoft.azure.management.monitor.v2018_09_01.implementation.MetricBaselinesInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing MetricBaselines.
 */
public interface MetricBaselines extends HasInner<MetricBaselinesInner> {
    /**
     * **Gets the baseline values for a specific metric**.
     *
     * @param resourceUri The identifier of the resource. It has the following structure: subscriptions/{subscriptionName}/resourceGroups/{resourceGroupName}/providers/{providerName}/{resourceName}. For example: subscriptions/b368ca2f-e298-46b7-b0ab-012281956afa/resourceGroups/vms/providers/Microsoft.Compute/virtualMachines/vm1
     * @param metricName The name of the metric to retrieve the baseline for.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<BaselineResponse> getAsync(String resourceUri, String metricName);

    /**
     * **Lists the baseline values for a resource**.
     *
     * @param resourceUri The identifier of the resource. It has the following structure: subscriptions/{subscriptionName}/resourceGroups/{resourceGroupName}/providers/{providerName}/{resourceName}. For example: subscriptions/b368ca2f-e298-46b7-b0ab-012281956afa/resourceGroups/vms/providers/Microsoft.Compute/virtualMachines/vm1
     * @param timeSeriesInformation Information that need to be specified to calculate a baseline on a time series.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<CalculateBaselineResponse> calculateBaselineAsync(String resourceUri, TimeSeriesInformation timeSeriesInformation);

}

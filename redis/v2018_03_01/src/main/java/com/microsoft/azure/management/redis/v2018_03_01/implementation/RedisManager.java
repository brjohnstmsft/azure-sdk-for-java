/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.redis.v2018_03_01.implementation;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.apigeneration.Beta;
import com.microsoft.azure.management.apigeneration.Beta.SinceVersion;
import com.microsoft.azure.arm.resources.AzureConfigurable;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.RestClient;
import com.microsoft.azure.management.redis.v2018_03_01.FirewallRules;
import com.microsoft.azure.management.redis.v2018_03_01.PatchSchedules;
import com.microsoft.azure.management.redis.v2018_03_01.LinkedServers;
import com.microsoft.azure.management.redis.v2018_03_01.Operations;
import com.microsoft.azure.management.redis.v2018_03_01.ListUpgradeNotifications;
import com.microsoft.azure.management.redis.v2018_03_01.Redis;
import com.microsoft.azure.arm.resources.implementation.AzureConfigurableCoreImpl;
import com.microsoft.azure.arm.resources.implementation.ManagerCore;

/**
 * Entry point to Azure Cache resource management.
 */
public final class RedisManager extends ManagerCore<RedisManager, RedisManagementClientImpl> {
    private FirewallRules firewallRules;
    private PatchSchedules patchSchedules;
    private LinkedServers linkedServers;
    private Operations operations;
    private ListUpgradeNotifications listUpgradeNotifications;
    private Redis redis;
    /**
    * Get a Configurable instance that can be used to create RedisManager with optional configuration.
    *
    * @return the instance allowing configurations
    */
    public static Configurable configure() {
        return new RedisManager.ConfigurableImpl();
    }
    /**
    * Creates an instance of RedisManager that exposes Cache resource management API entry points.
    *
    * @param credentials the credentials to use
    * @param subscriptionId the subscription UUID
    * @return the RedisManager
    */
    public static RedisManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
        return new RedisManager(new RestClient.Builder()
            .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
            .withCredentials(credentials)
            .withSerializerAdapter(new AzureJacksonAdapter())
            .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
            .build(), subscriptionId);
    }
    /**
    * Creates an instance of RedisManager that exposes Cache resource management API entry points.
    *
    * @param restClient the RestClient to be used for API calls.
    * @param subscriptionId the subscription UUID
    * @return the RedisManager
    */
    public static RedisManager authenticate(RestClient restClient, String subscriptionId) {
        return new RedisManager(restClient, subscriptionId);
    }
    /**
    * The interface allowing configurations to be set.
    */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
        * Creates an instance of RedisManager that exposes Cache management API entry points.
        *
        * @param credentials the credentials to use
        * @param subscriptionId the subscription UUID
        * @return the interface exposing Cache management API entry points that work across subscriptions
        */
        RedisManager authenticate(AzureTokenCredentials credentials, String subscriptionId);
    }

    /**
     * @return Entry point to manage FirewallRules.
     */
    public FirewallRules firewallRules() {
        if (this.firewallRules == null) {
            this.firewallRules = new FirewallRulesImpl(this);
        }
        return this.firewallRules;
    }

    /**
     * @return Entry point to manage PatchSchedules.
     */
    public PatchSchedules patchSchedules() {
        if (this.patchSchedules == null) {
            this.patchSchedules = new PatchSchedulesImpl(this);
        }
        return this.patchSchedules;
    }

    /**
     * @return Entry point to manage LinkedServers.
     */
    public LinkedServers linkedServers() {
        if (this.linkedServers == null) {
            this.linkedServers = new LinkedServersImpl(this);
        }
        return this.linkedServers;
    }

    /**
     * @return Entry point to manage Operations.
     */
    public Operations operations() {
        if (this.operations == null) {
            this.operations = new OperationsImpl(this);
        }
        return this.operations;
    }

    /**
     * @return Entry point to manage ListUpgradeNotifications.
     */
    public ListUpgradeNotifications listUpgradeNotifications() {
        if (this.listUpgradeNotifications == null) {
            this.listUpgradeNotifications = new ListUpgradeNotificationsImpl(this);
        }
        return this.listUpgradeNotifications;
    }

    /**
     * @return Entry point to manage Redis.
     */
    public Redis redis() {
        if (this.redis == null) {
            this.redis = new RedisImpl(this);
        }
        return this.redis;
    }

    /**
    * The implementation for Configurable interface.
    */
    private static final class ConfigurableImpl extends AzureConfigurableCoreImpl<Configurable> implements Configurable {
        public RedisManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
           return RedisManager.authenticate(buildRestClient(credentials), subscriptionId);
        }
     }
    private RedisManager(RestClient restClient, String subscriptionId) {
        super(
            restClient,
            subscriptionId,
            new RedisManagementClientImpl(restClient).withSubscriptionId(subscriptionId));
    }
}

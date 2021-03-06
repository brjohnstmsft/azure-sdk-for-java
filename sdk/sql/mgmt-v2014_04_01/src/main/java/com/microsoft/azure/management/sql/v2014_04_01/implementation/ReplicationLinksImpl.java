/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.sql.v2014_04_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.sql.v2014_04_01.ReplicationLinks;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import java.util.List;
import com.microsoft.azure.management.sql.v2014_04_01.ReplicationLink;

class ReplicationLinksImpl extends WrapperImpl<ReplicationLinksInner> implements ReplicationLinks {
    private final SqlManager manager;

    ReplicationLinksImpl(SqlManager manager) {
        super(manager.inner().replicationLinks());
        this.manager = manager;
    }

    public SqlManager manager() {
        return this.manager;
    }

    private ReplicationLinkImpl wrapModel(ReplicationLinkInner inner) {
        return  new ReplicationLinkImpl(inner, manager());
    }

    @Override
    public Completable failoverAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        ReplicationLinksInner client = this.inner();
        return client.failoverAsync(resourceGroupName, serverName, databaseName, linkId).toCompletable();
    }

    @Override
    public Completable failoverAllowDataLossAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        ReplicationLinksInner client = this.inner();
        return client.failoverAllowDataLossAsync(resourceGroupName, serverName, databaseName, linkId).toCompletable();
    }

    @Override
    public Observable<ReplicationLink> listByDatabaseAsync(String resourceGroupName, String serverName, String databaseName) {
        ReplicationLinksInner client = this.inner();
        return client.listByDatabaseAsync(resourceGroupName, serverName, databaseName)
        .flatMap(new Func1<List<ReplicationLinkInner>, Observable<ReplicationLinkInner>>() {
            @Override
            public Observable<ReplicationLinkInner> call(List<ReplicationLinkInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<ReplicationLinkInner, ReplicationLink>() {
            @Override
            public ReplicationLink call(ReplicationLinkInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<ReplicationLink> getAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        ReplicationLinksInner client = this.inner();
        return client.getAsync(resourceGroupName, serverName, databaseName, linkId)
        .map(new Func1<ReplicationLinkInner, ReplicationLink>() {
            @Override
            public ReplicationLink call(ReplicationLinkInner inner) {
                return wrapModel(inner);
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String serverName, String databaseName, String linkId) {
        ReplicationLinksInner client = this.inner();
        return client.deleteAsync(resourceGroupName, serverName, databaseName, linkId).toCompletable();
    }

}

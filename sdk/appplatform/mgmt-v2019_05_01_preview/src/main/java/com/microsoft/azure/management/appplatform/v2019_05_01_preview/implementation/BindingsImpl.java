/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.appplatform.v2019_05_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.appplatform.v2019_05_01_preview.Bindings;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.appplatform.v2019_05_01_preview.BindingResource;

class BindingsImpl extends WrapperImpl<BindingsInner> implements Bindings {
    private final AppPlatformManager manager;

    BindingsImpl(AppPlatformManager manager) {
        super(manager.inner().bindings());
        this.manager = manager;
    }

    public AppPlatformManager manager() {
        return this.manager;
    }

    @Override
    public BindingResourceImpl define(String name) {
        return wrapModel(name);
    }

    private BindingResourceImpl wrapModel(BindingResourceInner inner) {
        return  new BindingResourceImpl(inner, manager());
    }

    private BindingResourceImpl wrapModel(String name) {
        return new BindingResourceImpl(name, this.manager());
    }

    @Override
    public Observable<BindingResource> listAsync(final String resourceGroupName, final String serviceName, final String appName) {
        BindingsInner client = this.inner();
        return client.listAsync(resourceGroupName, serviceName, appName)
        .flatMapIterable(new Func1<Page<BindingResourceInner>, Iterable<BindingResourceInner>>() {
            @Override
            public Iterable<BindingResourceInner> call(Page<BindingResourceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<BindingResourceInner, BindingResource>() {
            @Override
            public BindingResource call(BindingResourceInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<BindingResource> getAsync(String resourceGroupName, String serviceName, String appName, String bindingName) {
        BindingsInner client = this.inner();
        return client.getAsync(resourceGroupName, serviceName, appName, bindingName)
        .flatMap(new Func1<BindingResourceInner, Observable<BindingResource>>() {
            @Override
            public Observable<BindingResource> call(BindingResourceInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((BindingResource)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String serviceName, String appName, String bindingName) {
        BindingsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, serviceName, appName, bindingName).toCompletable();
    }

}

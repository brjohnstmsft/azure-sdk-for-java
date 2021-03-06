/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.advisor.v2017_04_19.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.advisor.v2017_04_19.RecommendationsGenerateHeaders;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseWithHeaders;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Recommendations.
 */
public class RecommendationsInner {
    /** The Retrofit service to perform REST calls. */
    private RecommendationsService service;
    /** The service client containing this operation class. */
    private AdvisorManagementClientImpl client;

    /**
     * Initializes an instance of RecommendationsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public RecommendationsInner(Retrofit retrofit, AdvisorManagementClientImpl client) {
        this.service = retrofit.create(RecommendationsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Recommendations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface RecommendationsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.advisor.v2017_04_19.Recommendations generate" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.Advisor/generateRecommendations")
        Observable<Response<ResponseBody>> generate(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.advisor.v2017_04_19.Recommendations getGenerateStatus" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Advisor/generateRecommendations/{operationId}")
        Observable<Response<ResponseBody>> getGenerateStatus(@Path("subscriptionId") String subscriptionId, @Path("operationId") UUID operationId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.advisor.v2017_04_19.Recommendations list" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.Advisor/recommendations")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Query("$filter") String filter, @Query("$top") Integer top, @Query("$skipToken") String skipToken, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.advisor.v2017_04_19.Recommendations get" })
        @GET("{resourceUri}/providers/Microsoft.Advisor/recommendations/{recommendationId}")
        Observable<Response<ResponseBody>> get(@Path("resourceUri") String resourceUri, @Path("recommendationId") String recommendationId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.advisor.v2017_04_19.Recommendations listNext" })
        @GET
        Observable<Response<ResponseBody>> listNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Initiates the recommendation generation or computation process for a subscription. This operation is asynchronous. The generated recommendations are stored in a cache in the Advisor service.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void generate() {
        generateWithServiceResponseAsync().toBlocking().single().body();
    }

    /**
     * Initiates the recommendation generation or computation process for a subscription. This operation is asynchronous. The generated recommendations are stored in a cache in the Advisor service.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> generateAsync(final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromHeaderResponse(generateWithServiceResponseAsync(), serviceCallback);
    }

    /**
     * Initiates the recommendation generation or computation process for a subscription. This operation is asynchronous. The generated recommendations are stored in a cache in the Advisor service.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public Observable<Void> generateAsync() {
        return generateWithServiceResponseAsync().map(new Func1<ServiceResponseWithHeaders<Void, RecommendationsGenerateHeaders>, Void>() {
            @Override
            public Void call(ServiceResponseWithHeaders<Void, RecommendationsGenerateHeaders> response) {
                return response.body();
            }
        });
    }

    /**
     * Initiates the recommendation generation or computation process for a subscription. This operation is asynchronous. The generated recommendations are stored in a cache in the Advisor service.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public Observable<ServiceResponseWithHeaders<Void, RecommendationsGenerateHeaders>> generateWithServiceResponseAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.generate(this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Void, RecommendationsGenerateHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Void, RecommendationsGenerateHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<Void, RecommendationsGenerateHeaders> clientResponse = generateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<Void, RecommendationsGenerateHeaders> generateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Void, CloudException>newInstance(this.client.serializerAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .registerError(CloudException.class)
                .buildWithHeaders(response, RecommendationsGenerateHeaders.class);
    }

    /**
     * Retrieves the status of the recommendation computation or generation process. Invoke this API after calling the generation recommendation. The URI of this API is returned in the Location field of the response header.
     *
     * @param operationId The operation ID, which can be found from the Location field in the generate recommendation response header.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void getGenerateStatus(UUID operationId) {
        getGenerateStatusWithServiceResponseAsync(operationId).toBlocking().single().body();
    }

    /**
     * Retrieves the status of the recommendation computation or generation process. Invoke this API after calling the generation recommendation. The URI of this API is returned in the Location field of the response header.
     *
     * @param operationId The operation ID, which can be found from the Location field in the generate recommendation response header.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> getGenerateStatusAsync(UUID operationId, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(getGenerateStatusWithServiceResponseAsync(operationId), serviceCallback);
    }

    /**
     * Retrieves the status of the recommendation computation or generation process. Invoke this API after calling the generation recommendation. The URI of this API is returned in the Location field of the response header.
     *
     * @param operationId The operation ID, which can be found from the Location field in the generate recommendation response header.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> getGenerateStatusAsync(UUID operationId) {
        return getGenerateStatusWithServiceResponseAsync(operationId).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     * Retrieves the status of the recommendation computation or generation process. Invoke this API after calling the generation recommendation. The URI of this API is returned in the Location field of the response header.
     *
     * @param operationId The operation ID, which can be found from the Location field in the generate recommendation response header.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> getGenerateStatusWithServiceResponseAsync(UUID operationId) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (operationId == null) {
            throw new IllegalArgumentException("Parameter operationId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.getGenerateStatus(this.client.subscriptionId(), operationId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = getGenerateStatusDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> getGenerateStatusDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Void, CloudException>newInstance(this.client.serializerAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;ResourceRecommendationBaseInner&gt; object if successful.
     */
    public PagedList<ResourceRecommendationBaseInner> list() {
        ServiceResponse<Page<ResourceRecommendationBaseInner>> response = listSinglePageAsync().toBlocking().single();
        return new PagedList<ResourceRecommendationBaseInner>(response.body()) {
            @Override
            public Page<ResourceRecommendationBaseInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ResourceRecommendationBaseInner>> listAsync(final ListOperationCallback<ResourceRecommendationBaseInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(),
            new Func1<String, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ResourceRecommendationBaseInner&gt; object
     */
    public Observable<Page<ResourceRecommendationBaseInner>> listAsync() {
        return listWithServiceResponseAsync()
            .map(new Func1<ServiceResponse<Page<ResourceRecommendationBaseInner>>, Page<ResourceRecommendationBaseInner>>() {
                @Override
                public Page<ResourceRecommendationBaseInner> call(ServiceResponse<Page<ResourceRecommendationBaseInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ResourceRecommendationBaseInner&gt; object
     */
    public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> listWithServiceResponseAsync() {
        return listSinglePageAsync()
            .concatMap(new Func1<ServiceResponse<Page<ResourceRecommendationBaseInner>>, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(ServiceResponse<Page<ResourceRecommendationBaseInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;ResourceRecommendationBaseInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> listSinglePageAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final String filter = null;
        final Integer top = null;
        final String skipToken = null;
        return service.list(this.client.subscriptionId(), this.client.apiVersion(), filter, top, skipToken, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<ResourceRecommendationBaseInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param filter The filter to apply to the recommendations.
     * @param top The number of recommendations per page if a paged version of this API is being used.
     * @param skipToken The page-continuation token to use with a paged version of this API.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;ResourceRecommendationBaseInner&gt; object if successful.
     */
    public PagedList<ResourceRecommendationBaseInner> list(final String filter, final Integer top, final String skipToken) {
        ServiceResponse<Page<ResourceRecommendationBaseInner>> response = listSinglePageAsync(filter, top, skipToken).toBlocking().single();
        return new PagedList<ResourceRecommendationBaseInner>(response.body()) {
            @Override
            public Page<ResourceRecommendationBaseInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param filter The filter to apply to the recommendations.
     * @param top The number of recommendations per page if a paged version of this API is being used.
     * @param skipToken The page-continuation token to use with a paged version of this API.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ResourceRecommendationBaseInner>> listAsync(final String filter, final Integer top, final String skipToken, final ListOperationCallback<ResourceRecommendationBaseInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(filter, top, skipToken),
            new Func1<String, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param filter The filter to apply to the recommendations.
     * @param top The number of recommendations per page if a paged version of this API is being used.
     * @param skipToken The page-continuation token to use with a paged version of this API.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ResourceRecommendationBaseInner&gt; object
     */
    public Observable<Page<ResourceRecommendationBaseInner>> listAsync(final String filter, final Integer top, final String skipToken) {
        return listWithServiceResponseAsync(filter, top, skipToken)
            .map(new Func1<ServiceResponse<Page<ResourceRecommendationBaseInner>>, Page<ResourceRecommendationBaseInner>>() {
                @Override
                public Page<ResourceRecommendationBaseInner> call(ServiceResponse<Page<ResourceRecommendationBaseInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param filter The filter to apply to the recommendations.
     * @param top The number of recommendations per page if a paged version of this API is being used.
     * @param skipToken The page-continuation token to use with a paged version of this API.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ResourceRecommendationBaseInner&gt; object
     */
    public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> listWithServiceResponseAsync(final String filter, final Integer top, final String skipToken) {
        return listSinglePageAsync(filter, top, skipToken)
            .concatMap(new Func1<ServiceResponse<Page<ResourceRecommendationBaseInner>>, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(ServiceResponse<Page<ResourceRecommendationBaseInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
    ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> * @param filter The filter to apply to the recommendations.
    ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> * @param top The number of recommendations per page if a paged version of this API is being used.
    ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> * @param skipToken The page-continuation token to use with a paged version of this API.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;ResourceRecommendationBaseInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> listSinglePageAsync(final String filter, final Integer top, final String skipToken) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), this.client.apiVersion(), filter, top, skipToken, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<ResourceRecommendationBaseInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<ResourceRecommendationBaseInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<ResourceRecommendationBaseInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Obtains details of a cached recommendation.
     *
     * @param resourceUri The fully qualified Azure Resource Manager identifier of the resource to which the recommendation applies.
     * @param recommendationId The recommendation ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ResourceRecommendationBaseInner object if successful.
     */
    public ResourceRecommendationBaseInner get(String resourceUri, String recommendationId) {
        return getWithServiceResponseAsync(resourceUri, recommendationId).toBlocking().single().body();
    }

    /**
     * Obtains details of a cached recommendation.
     *
     * @param resourceUri The fully qualified Azure Resource Manager identifier of the resource to which the recommendation applies.
     * @param recommendationId The recommendation ID.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ResourceRecommendationBaseInner> getAsync(String resourceUri, String recommendationId, final ServiceCallback<ResourceRecommendationBaseInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(resourceUri, recommendationId), serviceCallback);
    }

    /**
     * Obtains details of a cached recommendation.
     *
     * @param resourceUri The fully qualified Azure Resource Manager identifier of the resource to which the recommendation applies.
     * @param recommendationId The recommendation ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ResourceRecommendationBaseInner object
     */
    public Observable<ResourceRecommendationBaseInner> getAsync(String resourceUri, String recommendationId) {
        return getWithServiceResponseAsync(resourceUri, recommendationId).map(new Func1<ServiceResponse<ResourceRecommendationBaseInner>, ResourceRecommendationBaseInner>() {
            @Override
            public ResourceRecommendationBaseInner call(ServiceResponse<ResourceRecommendationBaseInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Obtains details of a cached recommendation.
     *
     * @param resourceUri The fully qualified Azure Resource Manager identifier of the resource to which the recommendation applies.
     * @param recommendationId The recommendation ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ResourceRecommendationBaseInner object
     */
    public Observable<ServiceResponse<ResourceRecommendationBaseInner>> getWithServiceResponseAsync(String resourceUri, String recommendationId) {
        if (resourceUri == null) {
            throw new IllegalArgumentException("Parameter resourceUri is required and cannot be null.");
        }
        if (recommendationId == null) {
            throw new IllegalArgumentException("Parameter recommendationId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(resourceUri, recommendationId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ResourceRecommendationBaseInner>>>() {
                @Override
                public Observable<ServiceResponse<ResourceRecommendationBaseInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ResourceRecommendationBaseInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<ResourceRecommendationBaseInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<ResourceRecommendationBaseInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<ResourceRecommendationBaseInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;ResourceRecommendationBaseInner&gt; object if successful.
     */
    public PagedList<ResourceRecommendationBaseInner> listNext(final String nextPageLink) {
        ServiceResponse<Page<ResourceRecommendationBaseInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<ResourceRecommendationBaseInner>(response.body()) {
            @Override
            public Page<ResourceRecommendationBaseInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ResourceRecommendationBaseInner>> listNextAsync(final String nextPageLink, final ServiceFuture<List<ResourceRecommendationBaseInner>> serviceFuture, final ListOperationCallback<ResourceRecommendationBaseInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ResourceRecommendationBaseInner&gt; object
     */
    public Observable<Page<ResourceRecommendationBaseInner>> listNextAsync(final String nextPageLink) {
        return listNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<ResourceRecommendationBaseInner>>, Page<ResourceRecommendationBaseInner>>() {
                @Override
                public Page<ResourceRecommendationBaseInner> call(ServiceResponse<Page<ResourceRecommendationBaseInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ResourceRecommendationBaseInner&gt; object
     */
    public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> listNextWithServiceResponseAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<ResourceRecommendationBaseInner>>, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(ServiceResponse<Page<ResourceRecommendationBaseInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Obtains cached recommendations for a subscription. The recommendations are generated or computed by invoking generateRecommendations.
     *
    ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;ResourceRecommendationBaseInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ResourceRecommendationBaseInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<ResourceRecommendationBaseInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<ResourceRecommendationBaseInner>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<ResourceRecommendationBaseInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<ResourceRecommendationBaseInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}

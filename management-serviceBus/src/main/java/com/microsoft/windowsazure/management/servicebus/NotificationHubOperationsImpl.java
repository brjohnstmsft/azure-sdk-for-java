/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.servicebus;

import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.servicebus.models.AccessRight;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusConnectionDetail;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusConnectionDetailsResponse;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusNotificationHub;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusNotificationHubResponse;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusNotificationHubsResponse;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusSharedAccessAuthorizationRule;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
* The Service Bus Management API includes operations for managing Service Bus
* notification hubs.
*/
public class NotificationHubOperationsImpl implements ServiceOperations<ServiceBusManagementClientImpl>, NotificationHubOperations {
    /**
    * Initializes a new instance of the NotificationHubOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    NotificationHubOperationsImpl(ServiceBusManagementClientImpl client) {
        this.client = client;
    }
    
    private ServiceBusManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.servicebus.ServiceBusManagementClientImpl.
    * @return The Client value.
    */
    public ServiceBusManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * Lists the notification hubs associated with a namespace.
    *
    * @param namespaceName The namespace name.
    * @param notificationHubName The notification hub name.
    * @return A standard storage response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<ServiceBusNotificationHubResponse> getAsync(final String namespaceName, final String notificationHubName) {
        return this.getClient().getExecutorService().submit(new Callable<ServiceBusNotificationHubResponse>() { 
            @Override
            public ServiceBusNotificationHubResponse call() throws Exception {
                return get(namespaceName, notificationHubName);
            }
         });
    }
    
    /**
    * Lists the notification hubs associated with a namespace.
    *
    * @param namespaceName The namespace name.
    * @param notificationHubName The notification hub name.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return A standard storage response including an HTTP status code and
    * request ID.
    */
    @Override
    public ServiceBusNotificationHubResponse get(String namespaceName, String notificationHubName) throws IOException, ServiceException, ParserConfigurationException, SAXException, URISyntaxException {
        // Validate
        if (namespaceName == null) {
            throw new NullPointerException("namespaceName");
        }
        if (notificationHubName == null) {
            throw new NullPointerException("notificationHubName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("namespaceName", namespaceName);
            tracingParameters.put("notificationHubName", notificationHubName);
            CloudTracing.enter(invocationId, this, "getAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/services/servicebus/namespaces/" + namespaceName + "/NotificationHubs/" + notificationHubName;
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-08-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ServiceBusNotificationHubResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new ServiceBusNotificationHubResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            Element entryElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://www.w3.org/2005/Atom", "entry");
            if (entryElement != null) {
                Element titleElement = XmlUtility.getElementByTagNameNS(entryElement, "http://www.w3.org/2005/Atom", "title");
                if (titleElement != null) {
                }
                
                Element contentElement = XmlUtility.getElementByTagNameNS(entryElement, "http://www.w3.org/2005/Atom", "content");
                if (contentElement != null) {
                    Element notificationHubDescriptionElement = XmlUtility.getElementByTagNameNS(contentElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "NotificationHubDescription");
                    if (notificationHubDescriptionElement != null) {
                        ServiceBusNotificationHub notificationHubDescriptionInstance = new ServiceBusNotificationHub();
                        result.setNotificationHub(notificationHubDescriptionInstance);
                        
                        Element registrationTtlElement = XmlUtility.getElementByTagNameNS(notificationHubDescriptionElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "RegistrationTtl");
                        if (registrationTtlElement != null) {
                            String registrationTtlInstance;
                            registrationTtlInstance = registrationTtlElement.getTextContent();
                            notificationHubDescriptionInstance.setRegistrationTtl(registrationTtlInstance);
                        }
                        
                        Element authorizationRulesSequenceElement = XmlUtility.getElementByTagNameNS(notificationHubDescriptionElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AuthorizationRules");
                        if (authorizationRulesSequenceElement != null) {
                            for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(authorizationRulesSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AuthorizationRule").size(); i1 = i1 + 1) {
                                org.w3c.dom.Element authorizationRulesElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(authorizationRulesSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AuthorizationRule").get(i1));
                                ServiceBusSharedAccessAuthorizationRule authorizationRuleInstance = new ServiceBusSharedAccessAuthorizationRule();
                                notificationHubDescriptionInstance.getAuthorizationRules().add(authorizationRuleInstance);
                                
                                Element claimTypeElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ClaimType");
                                if (claimTypeElement != null) {
                                    String claimTypeInstance;
                                    claimTypeInstance = claimTypeElement.getTextContent();
                                    authorizationRuleInstance.setClaimType(claimTypeInstance);
                                }
                                
                                Element claimValueElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ClaimValue");
                                if (claimValueElement != null) {
                                    String claimValueInstance;
                                    claimValueInstance = claimValueElement.getTextContent();
                                    authorizationRuleInstance.setClaimValue(claimValueInstance);
                                }
                                
                                Element rightsSequenceElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "Rights");
                                if (rightsSequenceElement != null) {
                                    for (int i2 = 0; i2 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(rightsSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AccessRights").size(); i2 = i2 + 1) {
                                        org.w3c.dom.Element rightsElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(rightsSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AccessRights").get(i2));
                                        authorizationRuleInstance.getRights().add(AccessRight.valueOf(rightsElement.getTextContent()));
                                    }
                                }
                                
                                Element createdTimeElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "CreatedTime");
                                if (createdTimeElement != null) {
                                    Calendar createdTimeInstance;
                                    createdTimeInstance = DatatypeConverter.parseDateTime(createdTimeElement.getTextContent());
                                    authorizationRuleInstance.setCreatedTime(createdTimeInstance);
                                }
                                
                                Element keyNameElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "KeyName");
                                if (keyNameElement != null) {
                                    String keyNameInstance;
                                    keyNameInstance = keyNameElement.getTextContent();
                                    authorizationRuleInstance.setKeyName(keyNameInstance);
                                }
                                
                                Element modifiedTimeElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ModifiedTime");
                                if (modifiedTimeElement != null) {
                                    Calendar modifiedTimeInstance;
                                    modifiedTimeInstance = DatatypeConverter.parseDateTime(modifiedTimeElement.getTextContent());
                                    authorizationRuleInstance.setModifiedTime(modifiedTimeInstance);
                                }
                                
                                Element primaryKeyElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "PrimaryKey");
                                if (primaryKeyElement != null) {
                                    String primaryKeyInstance;
                                    primaryKeyInstance = primaryKeyElement.getTextContent();
                                    authorizationRuleInstance.setPrimaryKey(primaryKeyInstance);
                                }
                                
                                Element secondaryKeyElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "SecondaryKey");
                                if (secondaryKeyElement != null) {
                                    String secondaryKeyInstance;
                                    secondaryKeyInstance = secondaryKeyElement.getTextContent();
                                    authorizationRuleInstance.setSecondaryKey(secondaryKeyInstance);
                                }
                            }
                        }
                    }
                }
            }
            
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Lists the notification hubs associated with a namespace.
    *
    * @param namespaceName The namespace name.
    * @param notificationHubName The notification hub name.
    * @return The set of connection details for a service bus entity.
    */
    @Override
    public Future<ServiceBusConnectionDetailsResponse> getConnectionDetailsAsync(final String namespaceName, final String notificationHubName) {
        return this.getClient().getExecutorService().submit(new Callable<ServiceBusConnectionDetailsResponse>() { 
            @Override
            public ServiceBusConnectionDetailsResponse call() throws Exception {
                return getConnectionDetails(namespaceName, notificationHubName);
            }
         });
    }
    
    /**
    * Lists the notification hubs associated with a namespace.
    *
    * @param namespaceName The namespace name.
    * @param notificationHubName The notification hub name.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The set of connection details for a service bus entity.
    */
    @Override
    public ServiceBusConnectionDetailsResponse getConnectionDetails(String namespaceName, String notificationHubName) throws IOException, ServiceException, ParserConfigurationException, SAXException {
        // Validate
        if (namespaceName == null) {
            throw new NullPointerException("namespaceName");
        }
        if (notificationHubName == null) {
            throw new NullPointerException("notificationHubName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("namespaceName", namespaceName);
            tracingParameters.put("notificationHubName", notificationHubName);
            CloudTracing.enter(invocationId, this, "getConnectionDetailsAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/services/servicebus/namespaces/" + namespaceName + "/NotificationHubs/" + notificationHubName + "/ConnectionDetails";
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-08-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ServiceBusConnectionDetailsResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new ServiceBusConnectionDetailsResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            Element feedElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://www.w3.org/2005/Atom", "feed");
            if (feedElement != null) {
                if (feedElement != null) {
                    for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(feedElement, "http://www.w3.org/2005/Atom", "entry").size(); i1 = i1 + 1) {
                        org.w3c.dom.Element entriesElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(feedElement, "http://www.w3.org/2005/Atom", "entry").get(i1));
                        ServiceBusConnectionDetail entryInstance = new ServiceBusConnectionDetail();
                        result.getConnectionDetails().add(entryInstance);
                        
                        Element contentElement = XmlUtility.getElementByTagNameNS(entriesElement, "http://www.w3.org/2005/Atom", "content");
                        if (contentElement != null) {
                            Element connectionDetailElement = XmlUtility.getElementByTagNameNS(contentElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ConnectionDetail");
                            if (connectionDetailElement != null) {
                                Element keyNameElement = XmlUtility.getElementByTagNameNS(connectionDetailElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "KeyName");
                                if (keyNameElement != null) {
                                    String keyNameInstance;
                                    keyNameInstance = keyNameElement.getTextContent();
                                    entryInstance.setKeyName(keyNameInstance);
                                }
                                
                                Element connectionStringElement = XmlUtility.getElementByTagNameNS(connectionDetailElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ConnectionString");
                                if (connectionStringElement != null) {
                                    String connectionStringInstance;
                                    connectionStringInstance = connectionStringElement.getTextContent();
                                    entryInstance.setConnectionString(connectionStringInstance);
                                }
                                
                                Element authorizationTypeElement = XmlUtility.getElementByTagNameNS(connectionDetailElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AuthorizationType");
                                if (authorizationTypeElement != null) {
                                    String authorizationTypeInstance;
                                    authorizationTypeInstance = authorizationTypeElement.getTextContent();
                                    entryInstance.setAuthorizationType(authorizationTypeInstance);
                                }
                                
                                Element rightsSequenceElement = XmlUtility.getElementByTagNameNS(connectionDetailElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "Rights");
                                if (rightsSequenceElement != null) {
                                    for (int i2 = 0; i2 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(rightsSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AccessRights").size(); i2 = i2 + 1) {
                                        org.w3c.dom.Element rightsElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(rightsSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AccessRights").get(i2));
                                        entryInstance.getRights().add(AccessRight.valueOf(rightsElement.getTextContent()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Lists the notification hubs associated with a namespace.
    *
    * @param namespaceName The namespace name.
    * @return A standard storage response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<ServiceBusNotificationHubsResponse> listAsync(final String namespaceName) {
        return this.getClient().getExecutorService().submit(new Callable<ServiceBusNotificationHubsResponse>() { 
            @Override
            public ServiceBusNotificationHubsResponse call() throws Exception {
                return list(namespaceName);
            }
         });
    }
    
    /**
    * Lists the notification hubs associated with a namespace.
    *
    * @param namespaceName The namespace name.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return A standard storage response including an HTTP status code and
    * request ID.
    */
    @Override
    public ServiceBusNotificationHubsResponse list(String namespaceName) throws IOException, ServiceException, ParserConfigurationException, SAXException, URISyntaxException {
        // Validate
        if (namespaceName == null) {
            throw new NullPointerException("namespaceName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("namespaceName", namespaceName);
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/services/servicebus/namespaces/" + namespaceName + "/NotificationHubs";
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-08-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ServiceBusNotificationHubsResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new ServiceBusNotificationHubsResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            Element feedElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://www.w3.org/2005/Atom", "feed");
            if (feedElement != null) {
                if (feedElement != null) {
                    for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(feedElement, "http://www.w3.org/2005/Atom", "entry").size(); i1 = i1 + 1) {
                        org.w3c.dom.Element entriesElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(feedElement, "http://www.w3.org/2005/Atom", "entry").get(i1));
                        ServiceBusNotificationHub entryInstance = new ServiceBusNotificationHub();
                        result.getNotificationHubs().add(entryInstance);
                        
                        Element titleElement = XmlUtility.getElementByTagNameNS(entriesElement, "http://www.w3.org/2005/Atom", "title");
                        if (titleElement != null) {
                            String titleInstance;
                            titleInstance = titleElement.getTextContent();
                            entryInstance.setName(titleInstance);
                        }
                        
                        Element contentElement = XmlUtility.getElementByTagNameNS(entriesElement, "http://www.w3.org/2005/Atom", "content");
                        if (contentElement != null) {
                            Element notificationHubDescriptionElement = XmlUtility.getElementByTagNameNS(contentElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "NotificationHubDescription");
                            if (notificationHubDescriptionElement != null) {
                                Element registrationTtlElement = XmlUtility.getElementByTagNameNS(notificationHubDescriptionElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "RegistrationTtl");
                                if (registrationTtlElement != null) {
                                    String registrationTtlInstance;
                                    registrationTtlInstance = registrationTtlElement.getTextContent();
                                    entryInstance.setRegistrationTtl(registrationTtlInstance);
                                }
                                
                                Element authorizationRulesSequenceElement = XmlUtility.getElementByTagNameNS(notificationHubDescriptionElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AuthorizationRules");
                                if (authorizationRulesSequenceElement != null) {
                                    for (int i2 = 0; i2 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(authorizationRulesSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AuthorizationRule").size(); i2 = i2 + 1) {
                                        org.w3c.dom.Element authorizationRulesElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(authorizationRulesSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AuthorizationRule").get(i2));
                                        ServiceBusSharedAccessAuthorizationRule authorizationRuleInstance = new ServiceBusSharedAccessAuthorizationRule();
                                        entryInstance.getAuthorizationRules().add(authorizationRuleInstance);
                                        
                                        Element claimTypeElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ClaimType");
                                        if (claimTypeElement != null) {
                                            String claimTypeInstance;
                                            claimTypeInstance = claimTypeElement.getTextContent();
                                            authorizationRuleInstance.setClaimType(claimTypeInstance);
                                        }
                                        
                                        Element claimValueElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ClaimValue");
                                        if (claimValueElement != null) {
                                            String claimValueInstance;
                                            claimValueInstance = claimValueElement.getTextContent();
                                            authorizationRuleInstance.setClaimValue(claimValueInstance);
                                        }
                                        
                                        Element rightsSequenceElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "Rights");
                                        if (rightsSequenceElement != null) {
                                            for (int i3 = 0; i3 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(rightsSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AccessRights").size(); i3 = i3 + 1) {
                                                org.w3c.dom.Element rightsElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(rightsSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AccessRights").get(i3));
                                                authorizationRuleInstance.getRights().add(AccessRight.valueOf(rightsElement.getTextContent()));
                                            }
                                        }
                                        
                                        Element createdTimeElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "CreatedTime");
                                        if (createdTimeElement != null) {
                                            Calendar createdTimeInstance;
                                            createdTimeInstance = DatatypeConverter.parseDateTime(createdTimeElement.getTextContent());
                                            authorizationRuleInstance.setCreatedTime(createdTimeInstance);
                                        }
                                        
                                        Element keyNameElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "KeyName");
                                        if (keyNameElement != null) {
                                            String keyNameInstance;
                                            keyNameInstance = keyNameElement.getTextContent();
                                            authorizationRuleInstance.setKeyName(keyNameInstance);
                                        }
                                        
                                        Element modifiedTimeElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ModifiedTime");
                                        if (modifiedTimeElement != null) {
                                            Calendar modifiedTimeInstance;
                                            modifiedTimeInstance = DatatypeConverter.parseDateTime(modifiedTimeElement.getTextContent());
                                            authorizationRuleInstance.setModifiedTime(modifiedTimeInstance);
                                        }
                                        
                                        Element primaryKeyElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "PrimaryKey");
                                        if (primaryKeyElement != null) {
                                            String primaryKeyInstance;
                                            primaryKeyInstance = primaryKeyElement.getTextContent();
                                            authorizationRuleInstance.setPrimaryKey(primaryKeyInstance);
                                        }
                                        
                                        Element secondaryKeyElement = XmlUtility.getElementByTagNameNS(authorizationRulesElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "SecondaryKey");
                                        if (secondaryKeyElement != null) {
                                            String secondaryKeyInstance;
                                            secondaryKeyInstance = secondaryKeyElement.getTextContent();
                                            authorizationRuleInstance.setSecondaryKey(secondaryKeyInstance);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
}

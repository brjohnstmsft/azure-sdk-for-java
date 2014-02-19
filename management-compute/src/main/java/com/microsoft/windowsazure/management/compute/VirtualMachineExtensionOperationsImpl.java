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

package com.microsoft.windowsazure.management.compute;

import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.compute.models.VirtualMachineExtensionListResponse;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
* The Service Management API includes operations for managing the virtual
* machine extensions in your subscription.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/jj157206.aspx for more
* information)
*/
public class VirtualMachineExtensionOperationsImpl implements ServiceOperations<ComputeManagementClientImpl>, VirtualMachineExtensionOperations {
    /**
    * Initializes a new instance of the VirtualMachineExtensionOperationsImpl
    * class.
    *
    * @param client Reference to the service client.
    */
    VirtualMachineExtensionOperationsImpl(ComputeManagementClientImpl client) {
        this.client = client;
    }
    
    private ComputeManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.compute.ComputeManagementClientImpl.
    * @return The Client value.
    */
    public ComputeManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * The List Resource Extensions operation lists the resource extensions that
    * are available to add to a Virtual Machine. In Windows Azure, a process
    * can run as a resource extension of a Virtual Machine. For example,
    * Remote Desktop Access or the Windows Azure Diagnostics Agent can run as
    * resource extensions to the Virtual Machine.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn495441.aspx for
    * more information)
    *
    * @return The List Resource Extensions operation response.
    */
    @Override
    public Future<VirtualMachineExtensionListResponse> listAsync() {
        return this.getClient().getExecutorService().submit(new Callable<VirtualMachineExtensionListResponse>() { 
            @Override
            public VirtualMachineExtensionListResponse call() throws Exception {
                return list();
            }
         });
    }
    
    /**
    * The List Resource Extensions operation lists the resource extensions that
    * are available to add to a Virtual Machine. In Windows Azure, a process
    * can run as a resource extension of a Virtual Machine. For example,
    * Remote Desktop Access or the Windows Azure Diagnostics Agent can run as
    * resource extensions to the Virtual Machine.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn495441.aspx for
    * more information)
    *
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
    * @return The List Resource Extensions operation response.
    */
    @Override
    public VirtualMachineExtensionListResponse list() throws IOException, ServiceException, ParserConfigurationException, SAXException, URISyntaxException {
        // Validate
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/services/resourceextensions";
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-11-01");
        
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
            VirtualMachineExtensionListResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new VirtualMachineExtensionListResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            Element resourceExtensionsSequenceElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "ResourceExtensions");
            if (resourceExtensionsSequenceElement != null) {
                for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(resourceExtensionsSequenceElement, "http://schemas.microsoft.com/windowsazure", "ResourceExtension").size(); i1 = i1 + 1) {
                    org.w3c.dom.Element resourceExtensionsElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(resourceExtensionsSequenceElement, "http://schemas.microsoft.com/windowsazure", "ResourceExtension").get(i1));
                    VirtualMachineExtensionListResponse.ResourceExtension resourceExtensionInstance = new VirtualMachineExtensionListResponse.ResourceExtension();
                    result.getResourceExtensions().add(resourceExtensionInstance);
                    
                    Element publisherElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Publisher");
                    if (publisherElement != null) {
                        String publisherInstance;
                        publisherInstance = publisherElement.getTextContent();
                        resourceExtensionInstance.setPublisher(publisherInstance);
                    }
                    
                    Element nameElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Name");
                    if (nameElement != null) {
                        String nameInstance;
                        nameInstance = nameElement.getTextContent();
                        resourceExtensionInstance.setName(nameInstance);
                    }
                    
                    Element versionElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Version");
                    if (versionElement != null) {
                        String versionInstance;
                        versionInstance = versionElement.getTextContent();
                        resourceExtensionInstance.setVersion(versionInstance);
                    }
                    
                    Element labelElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Label");
                    if (labelElement != null) {
                        String labelInstance;
                        labelInstance = labelElement.getTextContent();
                        resourceExtensionInstance.setLabel(labelInstance);
                    }
                    
                    Element descriptionElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Description");
                    if (descriptionElement != null) {
                        String descriptionInstance;
                        descriptionInstance = descriptionElement.getTextContent();
                        resourceExtensionInstance.setDescription(descriptionInstance);
                    }
                    
                    Element publicConfigurationSchemaElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "PublicConfigurationSchema");
                    if (publicConfigurationSchemaElement != null) {
                        String publicConfigurationSchemaInstance;
                        publicConfigurationSchemaInstance = publicConfigurationSchemaElement.getTextContent() != null ? new String(Base64.decodeBase64(publicConfigurationSchemaElement.getTextContent().getBytes())) : null;
                        resourceExtensionInstance.setPublicConfigurationSchema(publicConfigurationSchemaInstance);
                    }
                    
                    Element privateConfigurationSchemaElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "PrivateConfigurationSchema");
                    if (privateConfigurationSchemaElement != null) {
                        String privateConfigurationSchemaInstance;
                        privateConfigurationSchemaInstance = privateConfigurationSchemaElement.getTextContent() != null ? new String(Base64.decodeBase64(privateConfigurationSchemaElement.getTextContent().getBytes())) : null;
                        resourceExtensionInstance.setPrivateConfigurationSchema(privateConfigurationSchemaInstance);
                    }
                    
                    Element sampleConfigElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "SampleConfig");
                    if (sampleConfigElement != null) {
                        String sampleConfigInstance;
                        sampleConfigInstance = sampleConfigElement.getTextContent() != null ? new String(Base64.decodeBase64(sampleConfigElement.getTextContent().getBytes())) : null;
                        resourceExtensionInstance.setSampleConfig(sampleConfigInstance);
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
    * The List Resource Extension Versions operation lists the versions of a
    * resource extension that are available to add to a Virtual Machine. In
    * Windows Azure, a process can run as a resource extension of a Virtual
    * Machine. For example, Remote Desktop Access or the Windows Azure
    * Diagnostics Agent can run as resource extensions to the Virtual Machine.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/dn495440.aspx
    * for more information)
    *
    * @param publisherName The name of the publisher.
    * @param extensionName The name of the extension.
    * @return The List Resource Extensions operation response.
    */
    @Override
    public Future<VirtualMachineExtensionListResponse> listVersionsAsync(final String publisherName, final String extensionName) {
        return this.getClient().getExecutorService().submit(new Callable<VirtualMachineExtensionListResponse>() { 
            @Override
            public VirtualMachineExtensionListResponse call() throws Exception {
                return listVersions(publisherName, extensionName);
            }
         });
    }
    
    /**
    * The List Resource Extension Versions operation lists the versions of a
    * resource extension that are available to add to a Virtual Machine. In
    * Windows Azure, a process can run as a resource extension of a Virtual
    * Machine. For example, Remote Desktop Access or the Windows Azure
    * Diagnostics Agent can run as resource extensions to the Virtual Machine.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/dn495440.aspx
    * for more information)
    *
    * @param publisherName The name of the publisher.
    * @param extensionName The name of the extension.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The List Resource Extensions operation response.
    */
    @Override
    public VirtualMachineExtensionListResponse listVersions(String publisherName, String extensionName) throws IOException, ServiceException, ParserConfigurationException, SAXException {
        // Validate
        if (publisherName == null) {
            throw new NullPointerException("publisherName");
        }
        if (extensionName == null) {
            throw new NullPointerException("extensionName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("publisherName", publisherName);
            tracingParameters.put("extensionName", extensionName);
            CloudTracing.enter(invocationId, this, "listVersionsAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/services/resourceextensions/" + publisherName + "/" + extensionName;
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-11-01");
        
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
            VirtualMachineExtensionListResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new VirtualMachineExtensionListResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            Element resourceExtensionsSequenceElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "ResourceExtensions");
            if (resourceExtensionsSequenceElement != null) {
                for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(resourceExtensionsSequenceElement, "http://schemas.microsoft.com/windowsazure", "ResourceExtension").size(); i1 = i1 + 1) {
                    org.w3c.dom.Element resourceExtensionsElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(resourceExtensionsSequenceElement, "http://schemas.microsoft.com/windowsazure", "ResourceExtension").get(i1));
                    VirtualMachineExtensionListResponse.ResourceExtension resourceExtensionInstance = new VirtualMachineExtensionListResponse.ResourceExtension();
                    result.getResourceExtensions().add(resourceExtensionInstance);
                    
                    Element publisherElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Publisher");
                    if (publisherElement != null) {
                        String publisherInstance;
                        publisherInstance = publisherElement.getTextContent();
                        resourceExtensionInstance.setPublisher(publisherInstance);
                    }
                    
                    Element nameElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Name");
                    if (nameElement != null) {
                        String nameInstance;
                        nameInstance = nameElement.getTextContent();
                        resourceExtensionInstance.setName(nameInstance);
                    }
                    
                    Element versionElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Version");
                    if (versionElement != null) {
                        String versionInstance;
                        versionInstance = versionElement.getTextContent();
                        resourceExtensionInstance.setVersion(versionInstance);
                    }
                    
                    Element labelElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Label");
                    if (labelElement != null) {
                        String labelInstance;
                        labelInstance = labelElement.getTextContent();
                        resourceExtensionInstance.setLabel(labelInstance);
                    }
                    
                    Element descriptionElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "Description");
                    if (descriptionElement != null) {
                        String descriptionInstance;
                        descriptionInstance = descriptionElement.getTextContent();
                        resourceExtensionInstance.setDescription(descriptionInstance);
                    }
                    
                    Element publicConfigurationSchemaElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "PublicConfigurationSchema");
                    if (publicConfigurationSchemaElement != null) {
                        String publicConfigurationSchemaInstance;
                        publicConfigurationSchemaInstance = publicConfigurationSchemaElement.getTextContent() != null ? new String(Base64.decodeBase64(publicConfigurationSchemaElement.getTextContent().getBytes())) : null;
                        resourceExtensionInstance.setPublicConfigurationSchema(publicConfigurationSchemaInstance);
                    }
                    
                    Element privateConfigurationSchemaElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "PrivateConfigurationSchema");
                    if (privateConfigurationSchemaElement != null) {
                        String privateConfigurationSchemaInstance;
                        privateConfigurationSchemaInstance = privateConfigurationSchemaElement.getTextContent() != null ? new String(Base64.decodeBase64(privateConfigurationSchemaElement.getTextContent().getBytes())) : null;
                        resourceExtensionInstance.setPrivateConfigurationSchema(privateConfigurationSchemaInstance);
                    }
                    
                    Element sampleConfigElement = XmlUtility.getElementByTagNameNS(resourceExtensionsElement, "http://schemas.microsoft.com/windowsazure", "SampleConfig");
                    if (sampleConfigElement != null) {
                        String sampleConfigInstance;
                        sampleConfigInstance = sampleConfigElement.getTextContent() != null ? new String(Base64.decodeBase64(sampleConfigElement.getTextContent().getBytes())) : null;
                        resourceExtensionInstance.setSampleConfig(sampleConfigInstance);
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

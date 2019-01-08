
package com.mercury.review.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mercury.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMobileAddress_QNAME = new QName("http://impl.server.webservice.review.mercury.com/", "getMobileAddress");
    private final static QName _GetMobileAddressResponse_QNAME = new QName("http://impl.server.webservice.review.mercury.com/", "getMobileAddressResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mercury.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMobileAddressResponse }
     * 
     */
    public GetMobileAddressResponse createGetMobileAddressResponse() {
        return new GetMobileAddressResponse();
    }

    /**
     * Create an instance of {@link GetMobileAddress }
     * 
     */
    public GetMobileAddress createGetMobileAddress() {
        return new GetMobileAddress();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMobileAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.server.webservice.review.mercury.com/", name = "getMobileAddress")
    public JAXBElement<GetMobileAddress> createGetMobileAddress(GetMobileAddress value) {
        return new JAXBElement<GetMobileAddress>(_GetMobileAddress_QNAME, GetMobileAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMobileAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.server.webservice.review.mercury.com/", name = "getMobileAddressResponse")
    public JAXBElement<GetMobileAddressResponse> createGetMobileAddressResponse(GetMobileAddressResponse value) {
        return new JAXBElement<GetMobileAddressResponse>(_GetMobileAddressResponse_QNAME, GetMobileAddressResponse.class, null, value);
    }

}

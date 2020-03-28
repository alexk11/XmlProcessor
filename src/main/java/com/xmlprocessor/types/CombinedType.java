package com.xmlprocessor.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
* <p>Java class for CombinedType complex type.
*/
@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CombinedType", propOrder = {
 "version",
 "clients",
 "address"
})
@XmlRootElement(name = "Combined", namespace = "http://www.tempuri.org/types")
public class CombinedType {

	 @XmlElement(name = "Version", required = true)
	 protected String version;
	 @XmlElement(name = "Client")
	 protected List<ClientType> clients;
	 @XmlElement(name = "Address")
	 protected AddressType address;
	 
	 /**
	  * Gets the value of the version property.
	  * 
	  * @return
	  *     possible object is
	  *     {@link String }     
	  */
	 public String getVersion() {
	     return version;
	 }
	
	 /**
	  * Sets the value of the version property.
	  * 
	  * @param value
	  *     allowed object is
	  *     {@link String }     
	  */
	 public void setVersion(String value) {
	     this.version = value;
	 }	
	
//	 /**
//	  * Gets the value of the client 
//	  * 
//	  * @param value
//	  *     allowed object is
//	  *     {@link ClientType }     
//	  */
//	 public ClientType getClient() {
//	     return client;
//	 }
//	
//	 /**
//	  * Sets the value of the client
//	  * 
//	  *  @param value
//	  *     allowed object is
//	  *     {@link ClientType }     
//	  */
//	 public void setClientId(ClientType value) {
//	     this.client = value;
//	 }
	 
	/**
     * Gets the value of the clients property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clients property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClients().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClientType }
     * 
     * 
     */
    public List<ClientType> getClients() {
        if (clients == null) {
        	clients = new ArrayList<ClientType>();
        }
        return this.clients;
    }

    public boolean isSetClients() {
        return ((this.clients!= null)&&(!this.clients.isEmpty()));
    }

    public void unsetClients() {
        this.clients = null;
    }
	
	 /**
	  * Gets the value of the address
	  * 
	  * @return
	  *     possible object is
	  *     {@link AddressType }     
	  */
	 public AddressType getAddress() {
	     return address;
	 }
	
	 /**
	  * Sets the value of the address.
	  * 
	  * @param value
	  *     allowed object is
	  *     {@link AddressType }     
	  */
	 public void setAddress(AddressType value) {
	     this.address = value;
	 }
	
	 
}


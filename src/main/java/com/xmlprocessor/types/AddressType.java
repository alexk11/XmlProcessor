package com.xmlprocessor.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
* <p>Java class for AddressType complex type.</p>
*/
@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
 "apartment",		
 "street",
 "house",
 "city",
 "country",
 "index"
})
public class AddressType {

 @XmlElement(name = "Apartment", required = true)
 protected Integer apartment;
 @XmlElement(name = "House", required = true)
 protected BigInteger house;
 @XmlElement(name = "Street", required = true)
 protected String street; 
 @XmlElement(name = "City", required = true)
 protected String city;
 @XmlElement(name = "Country", required = true)
 protected String country;
 @XmlElement(name = "Index")
 protected BigInteger index;

 
 /**
  * Gets the value of the apartment.
  * 
  * @return
  *     possible object is
  *     {@link Integer }     
  */
 public Integer getApartment() {
     return apartment;
 }

 /**
  * Sets the value of the apartment.
  * 
  * @param value
  *     allowed object is
  *     {@link Integer }     
  */
 public void setApartment(Integer value) {
     this.apartment = value;
 }

 public boolean isSetApartment() {
     return (this.apartment!= null);
 }
 
 
 /**
  * Gets the value of the street.
  * 
  * @return
  *     possible object is
  *     {@link String }     
  */
 public String getStreet() {
     return street;
 }

 /**
  * Sets the value of the street property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }     
  */
 public void setStreet(String value) {
     this.street = value;
 }

 public boolean isSetStreet() {
     return (this.street!= null);
 }

 /**
  * Gets the value of the house.
  * 
  * @return
  *     possible object is
  *     {@link BigInteger }
  *     
  */
 public BigInteger getHouse() {
     return house;
 }

 /**
  * Sets the value of the house property.
  * 
  * @param value
  *     allowed object is
  *     {@link BigInteger }
  *     
  */
 public void setHouse(BigInteger value) {
     this.house = value;
 }

 public boolean isSetHouse() {
     return (this.house!= null);
 }

 /**
  * Gets the value of the city property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getCity() {
     return city;
 }

 /**
  * Sets the value of the city property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setCity(String value) {
     this.city = value;
 }

 public boolean isSetCity() {
     return (this.city!= null);
 }

 /**
  * Gets the value of the country property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getCountry() {
     return country;
 }

 /**
  * Sets the value of the country property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setCountry(String value) {
     this.country = value;
 }

 public boolean isSetCountry() {
     return (this.country!= null);
 }

 
 /**
  * Gets the value of the index.
  * 
  * @return
  *     possible object is
  *     {@link BigInteger }
  *     
  */
 public BigInteger getIndex() {
     return index;
 }

 /**
  * Sets the value of the index property.
  * 
  * @param value
  *     allowed object is
  *     {@link BigInteger }
  *     
  */
 public void setIndex(BigInteger value) {
     this.index = value;
 }

 public boolean isSetIndex() {
     return (this.index!= null);
 }
 
 @Override
 public String toString() {	 
	 StringBuilder sb = new StringBuilder();	
	 sb.append("\nApartment#: " + apartment);
	 sb.append("\nHouse#: " + house);
	 sb.append("\nStreet: " + street);
	 sb.append("\nCity: " + city);
	 sb.append("\nCountry: " + country);
	 if (this.isSetIndex()) {
		 sb.append("\nIndex: " + index);
	 } 
	 return sb.toString();
 }

 
}


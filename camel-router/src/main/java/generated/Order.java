
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonInfoBillTo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="DayPhone" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="EMailID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="OrderNo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DocumentType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EnterpriseCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personInfoBillTo"
})
@XmlRootElement(name = "Order")
public class Order {

    @XmlElement(name = "PersonInfoBillTo", required = true)
    protected Order.PersonInfoBillTo personInfoBillTo;
    @XmlAttribute(name = "OrderNo", required = true)
    protected String orderNo;
    @XmlAttribute(name = "DocumentType")
    protected String documentType;
    @XmlAttribute(name = "EnterpriseCode")
    protected String enterpriseCode;
    @XmlAttribute(name = "Status")
    protected String status;

    /**
     * Gets the value of the personInfoBillTo property.
     * 
     * @return
     *     possible object is
     *     {@link Order.PersonInfoBillTo }
     *     
     */
    public Order.PersonInfoBillTo getPersonInfoBillTo() {
        return personInfoBillTo;
    }

    /**
     * Sets the value of the personInfoBillTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Order.PersonInfoBillTo }
     *     
     */
    public void setPersonInfoBillTo(Order.PersonInfoBillTo value) {
        this.personInfoBillTo = value;
    }

    /**
     * Gets the value of the orderNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * Sets the value of the orderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNo(String value) {
        this.orderNo = value;
    }

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentType(String value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the enterpriseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    /**
     * Sets the value of the enterpriseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnterpriseCode(String value) {
        this.enterpriseCode = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="DayPhone" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="EMailID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PersonInfoBillTo {

        @XmlAttribute(name = "DayPhone", required = true)
        protected String dayPhone;
        @XmlAttribute(name = "EMailID", required = true)
        protected String eMailID;
        @XmlAttribute(name = "FirstName")
        protected String firstName;
        @XmlAttribute(name = "LastName")
        protected String lastName;

        /**
         * Gets the value of the dayPhone property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDayPhone() {
            return dayPhone;
        }

        /**
         * Sets the value of the dayPhone property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDayPhone(String value) {
            this.dayPhone = value;
        }

        /**
         * Gets the value of the eMailID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEMailID() {
            return eMailID;
        }

        /**
         * Sets the value of the eMailID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEMailID(String value) {
            this.eMailID = value;
        }

        /**
         * Gets the value of the firstName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Sets the value of the firstName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstName(String value) {
            this.firstName = value;
        }

        /**
         * Gets the value of the lastName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Sets the value of the lastName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastName(String value) {
            this.lastName = value;
        }

    }

}

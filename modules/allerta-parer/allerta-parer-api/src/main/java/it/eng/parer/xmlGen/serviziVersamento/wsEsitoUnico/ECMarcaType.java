//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.13 at 01:46:09 PM CET 
//


package it.eng.parer.xmlGen.serviziVersamento.wsEsitoUnico;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ECMarcaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ECMarcaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrdineMarca" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="FormatoMarca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EsitoMarca">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ControlloConformita" type="{}ECEsitoControlloType" minOccurs="0"/>
 *                   &lt;element name="DettaglioControlloConformita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="VerificaMarca" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CodiceEsito" type="{}ECEsitoPosNegWarType"/>
 *                             &lt;element name="ControlloCrittografico" type="{}ECEsitoControlloType" minOccurs="0"/>
 *                             &lt;element name="DettaglioControlloCrittografico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ControlloCatenaTrusted" type="{}ECEsitoControlloType" minOccurs="0"/>
 *                             &lt;element name="DettaglioControlloCatenaTrusted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ControlloCertificato" type="{}ECEsitoControlloType" minOccurs="0"/>
 *                             &lt;element name="DettaglioControlloCertificato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ControlloCRL" type="{}ECEsitoControlloType" minOccurs="0"/>
 *                             &lt;element name="DettaglioControlloCRL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ECMarcaType", propOrder = {
    "ordineMarca",
    "formatoMarca",
    "timestamp",
    "esitoMarca"
})
public class ECMarcaType {

    @XmlElement(name = "OrdineMarca")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger ordineMarca;
    @XmlElement(name = "FormatoMarca")
    protected String formatoMarca;
    @XmlElement(name = "Timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    @XmlElement(name = "EsitoMarca", required = true)
    protected ECMarcaType.EsitoMarca esitoMarca;

    /**
     * Gets the value of the ordineMarca property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrdineMarca() {
        return ordineMarca;
    }

    /**
     * Sets the value of the ordineMarca property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrdineMarca(BigInteger value) {
        this.ordineMarca = value;
    }

    /**
     * Gets the value of the formatoMarca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatoMarca() {
        return formatoMarca;
    }

    /**
     * Sets the value of the formatoMarca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatoMarca(String value) {
        this.formatoMarca = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the esitoMarca property.
     * 
     * @return
     *     possible object is
     *     {@link ECMarcaType.EsitoMarca }
     *     
     */
    public ECMarcaType.EsitoMarca getEsitoMarca() {
        return esitoMarca;
    }

    /**
     * Sets the value of the esitoMarca property.
     * 
     * @param value
     *     allowed object is
     *     {@link ECMarcaType.EsitoMarca }
     *     
     */
    public void setEsitoMarca(ECMarcaType.EsitoMarca value) {
        this.esitoMarca = value;
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
     *       &lt;sequence>
     *         &lt;element name="ControlloConformita" type="{}ECEsitoControlloType" minOccurs="0"/>
     *         &lt;element name="DettaglioControlloConformita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="VerificaMarca" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CodiceEsito" type="{}ECEsitoPosNegWarType"/>
     *                   &lt;element name="ControlloCrittografico" type="{}ECEsitoControlloType" minOccurs="0"/>
     *                   &lt;element name="DettaglioControlloCrittografico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ControlloCatenaTrusted" type="{}ECEsitoControlloType" minOccurs="0"/>
     *                   &lt;element name="DettaglioControlloCatenaTrusted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ControlloCertificato" type="{}ECEsitoControlloType" minOccurs="0"/>
     *                   &lt;element name="DettaglioControlloCertificato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ControlloCRL" type="{}ECEsitoControlloType" minOccurs="0"/>
     *                   &lt;element name="DettaglioControlloCRL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "controlloConformita",
        "dettaglioControlloConformita",
        "verificaMarca"
    })
    public static class EsitoMarca {

        @XmlElement(name = "ControlloConformita")
        protected ECEsitoControlloType controlloConformita;
        @XmlElement(name = "DettaglioControlloConformita")
        protected String dettaglioControlloConformita;
        @XmlElement(name = "VerificaMarca")
        protected ECMarcaType.EsitoMarca.VerificaMarca verificaMarca;

        /**
         * Gets the value of the controlloConformita property.
         * 
         * @return
         *     possible object is
         *     {@link ECEsitoControlloType }
         *     
         */
        public ECEsitoControlloType getControlloConformita() {
            return controlloConformita;
        }

        /**
         * Sets the value of the controlloConformita property.
         * 
         * @param value
         *     allowed object is
         *     {@link ECEsitoControlloType }
         *     
         */
        public void setControlloConformita(ECEsitoControlloType value) {
            this.controlloConformita = value;
        }

        /**
         * Gets the value of the dettaglioControlloConformita property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDettaglioControlloConformita() {
            return dettaglioControlloConformita;
        }

        /**
         * Sets the value of the dettaglioControlloConformita property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDettaglioControlloConformita(String value) {
            this.dettaglioControlloConformita = value;
        }

        /**
         * Gets the value of the verificaMarca property.
         * 
         * @return
         *     possible object is
         *     {@link ECMarcaType.EsitoMarca.VerificaMarca }
         *     
         */
        public ECMarcaType.EsitoMarca.VerificaMarca getVerificaMarca() {
            return verificaMarca;
        }

        /**
         * Sets the value of the verificaMarca property.
         * 
         * @param value
         *     allowed object is
         *     {@link ECMarcaType.EsitoMarca.VerificaMarca }
         *     
         */
        public void setVerificaMarca(ECMarcaType.EsitoMarca.VerificaMarca value) {
            this.verificaMarca = value;
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
         *       &lt;sequence>
         *         &lt;element name="CodiceEsito" type="{}ECEsitoPosNegWarType"/>
         *         &lt;element name="ControlloCrittografico" type="{}ECEsitoControlloType" minOccurs="0"/>
         *         &lt;element name="DettaglioControlloCrittografico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ControlloCatenaTrusted" type="{}ECEsitoControlloType" minOccurs="0"/>
         *         &lt;element name="DettaglioControlloCatenaTrusted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ControlloCertificato" type="{}ECEsitoControlloType" minOccurs="0"/>
         *         &lt;element name="DettaglioControlloCertificato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ControlloCRL" type="{}ECEsitoControlloType" minOccurs="0"/>
         *         &lt;element name="DettaglioControlloCRL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codiceEsito",
            "controlloCrittografico",
            "dettaglioControlloCrittografico",
            "controlloCatenaTrusted",
            "dettaglioControlloCatenaTrusted",
            "controlloCertificato",
            "dettaglioControlloCertificato",
            "controlloCRL",
            "dettaglioControlloCRL"
        })
        public static class VerificaMarca {

            @XmlElement(name = "CodiceEsito", required = true)
            protected ECEsitoPosNegWarType codiceEsito;
            @XmlElement(name = "ControlloCrittografico")
            protected ECEsitoControlloType controlloCrittografico;
            @XmlElement(name = "DettaglioControlloCrittografico")
            protected String dettaglioControlloCrittografico;
            @XmlElement(name = "ControlloCatenaTrusted")
            protected ECEsitoControlloType controlloCatenaTrusted;
            @XmlElement(name = "DettaglioControlloCatenaTrusted")
            protected String dettaglioControlloCatenaTrusted;
            @XmlElement(name = "ControlloCertificato")
            protected ECEsitoControlloType controlloCertificato;
            @XmlElement(name = "DettaglioControlloCertificato")
            protected String dettaglioControlloCertificato;
            @XmlElement(name = "ControlloCRL")
            protected ECEsitoControlloType controlloCRL;
            @XmlElement(name = "DettaglioControlloCRL")
            protected String dettaglioControlloCRL;

            /**
             * Gets the value of the codiceEsito property.
             * 
             * @return
             *     possible object is
             *     {@link ECEsitoPosNegWarType }
             *     
             */
            public ECEsitoPosNegWarType getCodiceEsito() {
                return codiceEsito;
            }

            /**
             * Sets the value of the codiceEsito property.
             * 
             * @param value
             *     allowed object is
             *     {@link ECEsitoPosNegWarType }
             *     
             */
            public void setCodiceEsito(ECEsitoPosNegWarType value) {
                this.codiceEsito = value;
            }

            /**
             * Gets the value of the controlloCrittografico property.
             * 
             * @return
             *     possible object is
             *     {@link ECEsitoControlloType }
             *     
             */
            public ECEsitoControlloType getControlloCrittografico() {
                return controlloCrittografico;
            }

            /**
             * Sets the value of the controlloCrittografico property.
             * 
             * @param value
             *     allowed object is
             *     {@link ECEsitoControlloType }
             *     
             */
            public void setControlloCrittografico(ECEsitoControlloType value) {
                this.controlloCrittografico = value;
            }

            /**
             * Gets the value of the dettaglioControlloCrittografico property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDettaglioControlloCrittografico() {
                return dettaglioControlloCrittografico;
            }

            /**
             * Sets the value of the dettaglioControlloCrittografico property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDettaglioControlloCrittografico(String value) {
                this.dettaglioControlloCrittografico = value;
            }

            /**
             * Gets the value of the controlloCatenaTrusted property.
             * 
             * @return
             *     possible object is
             *     {@link ECEsitoControlloType }
             *     
             */
            public ECEsitoControlloType getControlloCatenaTrusted() {
                return controlloCatenaTrusted;
            }

            /**
             * Sets the value of the controlloCatenaTrusted property.
             * 
             * @param value
             *     allowed object is
             *     {@link ECEsitoControlloType }
             *     
             */
            public void setControlloCatenaTrusted(ECEsitoControlloType value) {
                this.controlloCatenaTrusted = value;
            }

            /**
             * Gets the value of the dettaglioControlloCatenaTrusted property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDettaglioControlloCatenaTrusted() {
                return dettaglioControlloCatenaTrusted;
            }

            /**
             * Sets the value of the dettaglioControlloCatenaTrusted property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDettaglioControlloCatenaTrusted(String value) {
                this.dettaglioControlloCatenaTrusted = value;
            }

            /**
             * Gets the value of the controlloCertificato property.
             * 
             * @return
             *     possible object is
             *     {@link ECEsitoControlloType }
             *     
             */
            public ECEsitoControlloType getControlloCertificato() {
                return controlloCertificato;
            }

            /**
             * Sets the value of the controlloCertificato property.
             * 
             * @param value
             *     allowed object is
             *     {@link ECEsitoControlloType }
             *     
             */
            public void setControlloCertificato(ECEsitoControlloType value) {
                this.controlloCertificato = value;
            }

            /**
             * Gets the value of the dettaglioControlloCertificato property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDettaglioControlloCertificato() {
                return dettaglioControlloCertificato;
            }

            /**
             * Sets the value of the dettaglioControlloCertificato property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDettaglioControlloCertificato(String value) {
                this.dettaglioControlloCertificato = value;
            }

            /**
             * Gets the value of the controlloCRL property.
             * 
             * @return
             *     possible object is
             *     {@link ECEsitoControlloType }
             *     
             */
            public ECEsitoControlloType getControlloCRL() {
                return controlloCRL;
            }

            /**
             * Sets the value of the controlloCRL property.
             * 
             * @param value
             *     allowed object is
             *     {@link ECEsitoControlloType }
             *     
             */
            public void setControlloCRL(ECEsitoControlloType value) {
                this.controlloCRL = value;
            }

            /**
             * Gets the value of the dettaglioControlloCRL property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDettaglioControlloCRL() {
                return dettaglioControlloCRL;
            }

            /**
             * Sets the value of the dettaglioControlloCRL property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDettaglioControlloCRL(String value) {
                this.dettaglioControlloCRL = value;
            }

        }

    }

}

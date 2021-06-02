/**
 * DataValoracion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataValoracion  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.Integer idJugador;

    private java.lang.Integer valoracion;

    private java.lang.Integer idJuego;

    public DataValoracion() {
    }

    public DataValoracion(
           java.lang.Integer id,
           java.lang.Integer idJugador,
           java.lang.Integer valoracion,
           java.lang.Integer idJuego) {
           this.id = id;
           this.idJugador = idJugador;
           this.valoracion = valoracion;
           this.idJuego = idJuego;
    }


    /**
     * Gets the id value for this DataValoracion.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DataValoracion.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the idJugador value for this DataValoracion.
     * 
     * @return idJugador
     */
    public java.lang.Integer getIdJugador() {
        return idJugador;
    }


    /**
     * Sets the idJugador value for this DataValoracion.
     * 
     * @param idJugador
     */
    public void setIdJugador(java.lang.Integer idJugador) {
        this.idJugador = idJugador;
    }


    /**
     * Gets the valoracion value for this DataValoracion.
     * 
     * @return valoracion
     */
    public java.lang.Integer getValoracion() {
        return valoracion;
    }


    /**
     * Sets the valoracion value for this DataValoracion.
     * 
     * @param valoracion
     */
    public void setValoracion(java.lang.Integer valoracion) {
        this.valoracion = valoracion;
    }


    /**
     * Gets the idJuego value for this DataValoracion.
     * 
     * @return idJuego
     */
    public java.lang.Integer getIdJuego() {
        return idJuego;
    }


    /**
     * Sets the idJuego value for this DataValoracion.
     * 
     * @param idJuego
     */
    public void setIdJuego(java.lang.Integer idJuego) {
        this.idJuego = idJuego;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataValoracion)) return false;
        DataValoracion other = (DataValoracion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.idJugador==null && other.getIdJugador()==null) || 
             (this.idJugador!=null &&
              this.idJugador.equals(other.getIdJugador()))) &&
            ((this.valoracion==null && other.getValoracion()==null) || 
             (this.valoracion!=null &&
              this.valoracion.equals(other.getValoracion()))) &&
            ((this.idJuego==null && other.getIdJuego()==null) || 
             (this.idJuego!=null &&
              this.idJuego.equals(other.getIdJuego())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIdJugador() != null) {
            _hashCode += getIdJugador().hashCode();
        }
        if (getValoracion() != null) {
            _hashCode += getValoracion().hashCode();
        }
        if (getIdJuego() != null) {
            _hashCode += getIdJuego().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataValoracion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataValoracion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idJugador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idJugador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valoracion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Valoracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idJuego");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idJuego"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

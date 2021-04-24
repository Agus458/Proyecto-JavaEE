/**
 * DataPublicacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataPublicacion  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.Integer creador;

    private java.lang.Integer juego;

    private java.util.Calendar fechaPublicacion;

    public DataPublicacion() {
    }

    public DataPublicacion(
           java.lang.Integer id,
           java.lang.Integer creador,
           java.lang.Integer juego,
           java.util.Calendar fechaPublicacion) {
           this.id = id;
           this.creador = creador;
           this.juego = juego;
           this.fechaPublicacion = fechaPublicacion;
    }


    /**
     * Gets the id value for this DataPublicacion.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DataPublicacion.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the creador value for this DataPublicacion.
     * 
     * @return creador
     */
    public java.lang.Integer getCreador() {
        return creador;
    }


    /**
     * Sets the creador value for this DataPublicacion.
     * 
     * @param creador
     */
    public void setCreador(java.lang.Integer creador) {
        this.creador = creador;
    }


    /**
     * Gets the juego value for this DataPublicacion.
     * 
     * @return juego
     */
    public java.lang.Integer getJuego() {
        return juego;
    }


    /**
     * Sets the juego value for this DataPublicacion.
     * 
     * @param juego
     */
    public void setJuego(java.lang.Integer juego) {
        this.juego = juego;
    }


    /**
     * Gets the fechaPublicacion value for this DataPublicacion.
     * 
     * @return fechaPublicacion
     */
    public java.util.Calendar getFechaPublicacion() {
        return fechaPublicacion;
    }


    /**
     * Sets the fechaPublicacion value for this DataPublicacion.
     * 
     * @param fechaPublicacion
     */
    public void setFechaPublicacion(java.util.Calendar fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataPublicacion)) return false;
        DataPublicacion other = (DataPublicacion) obj;
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
            ((this.creador==null && other.getCreador()==null) || 
             (this.creador!=null &&
              this.creador.equals(other.getCreador()))) &&
            ((this.juego==null && other.getJuego()==null) || 
             (this.juego!=null &&
              this.juego.equals(other.getJuego()))) &&
            ((this.fechaPublicacion==null && other.getFechaPublicacion()==null) || 
             (this.fechaPublicacion!=null &&
              this.fechaPublicacion.equals(other.getFechaPublicacion())));
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
        if (getCreador() != null) {
            _hashCode += getCreador().hashCode();
        }
        if (getJuego() != null) {
            _hashCode += getJuego().hashCode();
        }
        if (getFechaPublicacion() != null) {
            _hashCode += getFechaPublicacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataPublicacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataPublicacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("juego");
        elemField.setXmlName(new javax.xml.namespace.QName("", "juego"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPublicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaPublicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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

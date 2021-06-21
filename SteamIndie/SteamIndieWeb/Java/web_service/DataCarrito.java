/**
 * DataCarrito.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataCarrito  implements java.io.Serializable {
    private java.lang.Integer id;

    private web_service.DataJuego[] juegos;

    private java.lang.Integer jugador;

    private java.lang.Float total;

    public DataCarrito() {
    }

    public DataCarrito(
           java.lang.Integer id,
           web_service.DataJuego[] juegos,
           java.lang.Integer jugador,
           java.lang.Float total) {
           this.id = id;
           this.juegos = juegos;
           this.jugador = jugador;
           this.total = total;
    }


    /**
     * Gets the id value for this DataCarrito.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DataCarrito.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the juegos value for this DataCarrito.
     * 
     * @return juegos
     */
    public web_service.DataJuego[] getJuegos() {
        return juegos;
    }


    /**
     * Sets the juegos value for this DataCarrito.
     * 
     * @param juegos
     */
    public void setJuegos(web_service.DataJuego[] juegos) {
        this.juegos = juegos;
    }

    public web_service.DataJuego getJuegos(int i) {
        return this.juegos[i];
    }

    public void setJuegos(int i, web_service.DataJuego _value) {
        this.juegos[i] = _value;
    }


    /**
     * Gets the jugador value for this DataCarrito.
     * 
     * @return jugador
     */
    public java.lang.Integer getJugador() {
        return jugador;
    }


    /**
     * Sets the jugador value for this DataCarrito.
     * 
     * @param jugador
     */
    public void setJugador(java.lang.Integer jugador) {
        this.jugador = jugador;
    }


    /**
     * Gets the total value for this DataCarrito.
     * 
     * @return total
     */
    public java.lang.Float getTotal() {
        return total;
    }


    /**
     * Sets the total value for this DataCarrito.
     * 
     * @param total
     */
    public void setTotal(java.lang.Float total) {
        this.total = total;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataCarrito)) return false;
        DataCarrito other = (DataCarrito) obj;
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
            ((this.juegos==null && other.getJuegos()==null) || 
             (this.juegos!=null &&
              java.util.Arrays.equals(this.juegos, other.getJuegos()))) &&
            ((this.jugador==null && other.getJugador()==null) || 
             (this.jugador!=null &&
              this.jugador.equals(other.getJugador()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal())));
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
        if (getJuegos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJuegos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJuegos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getJugador() != null) {
            _hashCode += getJugador().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataCarrito.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataCarrito"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("juegos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "juegos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataJuego"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jugador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jugador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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

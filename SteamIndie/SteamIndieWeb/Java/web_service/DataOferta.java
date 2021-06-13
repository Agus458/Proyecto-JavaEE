/**
 * DataOferta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataOferta  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.util.Calendar fechaInicio;

    private java.util.Calendar fechaFin;

    private java.lang.String nombre;

    private java.lang.Float descuento;

    private java.lang.Integer[] juegos;

    private web_service.EstadoOferta estado;

    public DataOferta() {
    }

    public DataOferta(
           java.lang.Integer id,
           java.util.Calendar fechaInicio,
           java.util.Calendar fechaFin,
           java.lang.String nombre,
           java.lang.Float descuento,
           java.lang.Integer[] juegos,
           web_service.EstadoOferta estado) {
           this.id = id;
           this.fechaInicio = fechaInicio;
           this.fechaFin = fechaFin;
           this.nombre = nombre;
           this.descuento = descuento;
           this.juegos = juegos;
           this.estado = estado;
    }


    /**
     * Gets the id value for this DataOferta.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DataOferta.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the fechaInicio value for this DataOferta.
     * 
     * @return fechaInicio
     */
    public java.util.Calendar getFechaInicio() {
        return fechaInicio;
    }


    /**
     * Sets the fechaInicio value for this DataOferta.
     * 
     * @param fechaInicio
     */
    public void setFechaInicio(java.util.Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Gets the fechaFin value for this DataOferta.
     * 
     * @return fechaFin
     */
    public java.util.Calendar getFechaFin() {
        return fechaFin;
    }


    /**
     * Sets the fechaFin value for this DataOferta.
     * 
     * @param fechaFin
     */
    public void setFechaFin(java.util.Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }


    /**
     * Gets the nombre value for this DataOferta.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DataOferta.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the descuento value for this DataOferta.
     * 
     * @return descuento
     */
    public java.lang.Float getDescuento() {
        return descuento;
    }


    /**
     * Sets the descuento value for this DataOferta.
     * 
     * @param descuento
     */
    public void setDescuento(java.lang.Float descuento) {
        this.descuento = descuento;
    }


    /**
     * Gets the juegos value for this DataOferta.
     * 
     * @return juegos
     */
    public java.lang.Integer[] getJuegos() {
        return juegos;
    }


    /**
     * Sets the juegos value for this DataOferta.
     * 
     * @param juegos
     */
    public void setJuegos(java.lang.Integer[] juegos) {
        this.juegos = juegos;
    }

    public java.lang.Integer getJuegos(int i) {
        return this.juegos[i];
    }

    public void setJuegos(int i, java.lang.Integer _value) {
        this.juegos[i] = _value;
    }


    /**
     * Gets the estado value for this DataOferta.
     * 
     * @return estado
     */
    public web_service.EstadoOferta getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this DataOferta.
     * 
     * @param estado
     */
    public void setEstado(web_service.EstadoOferta estado) {
        this.estado = estado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataOferta)) return false;
        DataOferta other = (DataOferta) obj;
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
            ((this.fechaInicio==null && other.getFechaInicio()==null) || 
             (this.fechaInicio!=null &&
              this.fechaInicio.equals(other.getFechaInicio()))) &&
            ((this.fechaFin==null && other.getFechaFin()==null) || 
             (this.fechaFin!=null &&
              this.fechaFin.equals(other.getFechaFin()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.descuento==null && other.getDescuento()==null) || 
             (this.descuento!=null &&
              this.descuento.equals(other.getDescuento()))) &&
            ((this.juegos==null && other.getJuegos()==null) || 
             (this.juegos!=null &&
              java.util.Arrays.equals(this.juegos, other.getJuegos()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado())));
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
        if (getFechaInicio() != null) {
            _hashCode += getFechaInicio().hashCode();
        }
        if (getFechaFin() != null) {
            _hashCode += getFechaFin().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getDescuento() != null) {
            _hashCode += getDescuento().hashCode();
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
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataOferta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataOferta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaFin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("juegos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "juegos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "estadoOferta"));
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

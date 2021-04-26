/**
 * DataJuego.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataJuego  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.String nombre;

    private java.lang.String descripcion;

    private java.lang.Float precio;

    private web_service.DataCategoria[] categorias;

    private web_service.DataMedia media;

    private web_service.DataPublicacion publicacion;

    public DataJuego() {
    }

    public DataJuego(
           java.lang.Integer id,
           java.lang.String nombre,
           java.lang.String descripcion,
           java.lang.Float precio,
           web_service.DataCategoria[] categorias,
           web_service.DataMedia media,
           web_service.DataPublicacion publicacion) {
           this.id = id;
           this.nombre = nombre;
           this.descripcion = descripcion;
           this.precio = precio;
           this.categorias = categorias;
           this.media = media;
           this.publicacion = publicacion;
    }


    /**
     * Gets the id value for this DataJuego.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DataJuego.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the nombre value for this DataJuego.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DataJuego.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the descripcion value for this DataJuego.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DataJuego.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the precio value for this DataJuego.
     * 
     * @return precio
     */
    public java.lang.Float getPrecio() {
        return precio;
    }


    /**
     * Sets the precio value for this DataJuego.
     * 
     * @param precio
     */
    public void setPrecio(java.lang.Float precio) {
        this.precio = precio;
    }


    /**
     * Gets the categorias value for this DataJuego.
     * 
     * @return categorias
     */
    public web_service.DataCategoria[] getCategorias() {
        return categorias;
    }


    /**
     * Sets the categorias value for this DataJuego.
     * 
     * @param categorias
     */
    public void setCategorias(web_service.DataCategoria[] categorias) {
        this.categorias = categorias;
    }

    public web_service.DataCategoria getCategorias(int i) {
        return this.categorias[i];
    }

    public void setCategorias(int i, web_service.DataCategoria _value) {
        this.categorias[i] = _value;
    }


    /**
     * Gets the media value for this DataJuego.
     * 
     * @return media
     */
    public web_service.DataMedia getMedia() {
        return media;
    }


    /**
     * Sets the media value for this DataJuego.
     * 
     * @param media
     */
    public void setMedia(web_service.DataMedia media) {
        this.media = media;
    }


    /**
     * Gets the publicacion value for this DataJuego.
     * 
     * @return publicacion
     */
    public web_service.DataPublicacion getPublicacion() {
        return publicacion;
    }


    /**
     * Sets the publicacion value for this DataJuego.
     * 
     * @param publicacion
     */
    public void setPublicacion(web_service.DataPublicacion publicacion) {
        this.publicacion = publicacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataJuego)) return false;
        DataJuego other = (DataJuego) obj;
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
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.precio==null && other.getPrecio()==null) || 
             (this.precio!=null &&
              this.precio.equals(other.getPrecio()))) &&
            ((this.categorias==null && other.getCategorias()==null) || 
             (this.categorias!=null &&
              java.util.Arrays.equals(this.categorias, other.getCategorias()))) &&
            ((this.media==null && other.getMedia()==null) || 
             (this.media!=null &&
              this.media.equals(other.getMedia()))) &&
            ((this.publicacion==null && other.getPublicacion()==null) || 
             (this.publicacion!=null &&
              this.publicacion.equals(other.getPublicacion())));
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
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getPrecio() != null) {
            _hashCode += getPrecio().hashCode();
        }
        if (getCategorias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategorias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategorias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMedia() != null) {
            _hashCode += getMedia().hashCode();
        }
        if (getPublicacion() != null) {
            _hashCode += getPublicacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataJuego.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataJuego"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categorias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataCategoria"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("media");
        elemField.setXmlName(new javax.xml.namespace.QName("", "media"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataMedia"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataPublicacion"));
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

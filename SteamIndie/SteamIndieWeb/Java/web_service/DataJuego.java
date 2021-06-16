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

    private java.lang.Float precioFinal;

    private java.lang.Integer reportes;

    private web_service.DataCategoria[] categorias;

    private web_service.DataTag[] tags;

    private web_service.DataMedia media;

    private web_service.DataPublicacion publicacion;

    private web_service.DataValoracion[] valoraciones;

    public DataJuego() {
    }

    public DataJuego(
           java.lang.Integer id,
           java.lang.String nombre,
           java.lang.String descripcion,
           java.lang.Float precio,
           java.lang.Float precioFinal,
           java.lang.Integer reportes,
           web_service.DataCategoria[] categorias,
           web_service.DataTag[] tags,
           web_service.DataMedia media,
           web_service.DataPublicacion publicacion,
           web_service.DataValoracion[] valoraciones) {
           this.id = id;
           this.nombre = nombre;
           this.descripcion = descripcion;
           this.precio = precio;
           this.precioFinal = precioFinal;
           this.reportes = reportes;
           this.categorias = categorias;
           this.tags = tags;
           this.media = media;
           this.publicacion = publicacion;
           this.valoraciones = valoraciones;
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
     * Gets the precioFinal value for this DataJuego.
     * 
     * @return precioFinal
     */
    public java.lang.Float getPrecioFinal() {
        return precioFinal;
    }


    /**
     * Sets the precioFinal value for this DataJuego.
     * 
     * @param precioFinal
     */
    public void setPrecioFinal(java.lang.Float precioFinal) {
        this.precioFinal = precioFinal;
    }


    /**
     * Gets the reportes value for this DataJuego.
     * 
     * @return reportes
     */
    public java.lang.Integer getReportes() {
        return reportes;
    }


    /**
     * Sets the reportes value for this DataJuego.
     * 
     * @param reportes
     */
    public void setReportes(java.lang.Integer reportes) {
        this.reportes = reportes;
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
     * Gets the tags value for this DataJuego.
     * 
     * @return tags
     */
    public web_service.DataTag[] getTags() {
        return tags;
    }


    /**
     * Sets the tags value for this DataJuego.
     * 
     * @param tags
     */
    public void setTags(web_service.DataTag[] tags) {
        this.tags = tags;
    }

    public web_service.DataTag getTags(int i) {
        return this.tags[i];
    }

    public void setTags(int i, web_service.DataTag _value) {
        this.tags[i] = _value;
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


    /**
     * Gets the valoraciones value for this DataJuego.
     * 
     * @return valoraciones
     */
    public web_service.DataValoracion[] getValoraciones() {
        return valoraciones;
    }


    /**
     * Sets the valoraciones value for this DataJuego.
     * 
     * @param valoraciones
     */
    public void setValoraciones(web_service.DataValoracion[] valoraciones) {
        this.valoraciones = valoraciones;
    }

    public web_service.DataValoracion getValoraciones(int i) {
        return this.valoraciones[i];
    }

    public void setValoraciones(int i, web_service.DataValoracion _value) {
        this.valoraciones[i] = _value;
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
            ((this.precioFinal==null && other.getPrecioFinal()==null) || 
             (this.precioFinal!=null &&
              this.precioFinal.equals(other.getPrecioFinal()))) &&
            ((this.reportes==null && other.getReportes()==null) || 
             (this.reportes!=null &&
              this.reportes.equals(other.getReportes()))) &&
            ((this.categorias==null && other.getCategorias()==null) || 
             (this.categorias!=null &&
              java.util.Arrays.equals(this.categorias, other.getCategorias()))) &&
            ((this.tags==null && other.getTags()==null) || 
             (this.tags!=null &&
              java.util.Arrays.equals(this.tags, other.getTags()))) &&
            ((this.media==null && other.getMedia()==null) || 
             (this.media!=null &&
              this.media.equals(other.getMedia()))) &&
            ((this.publicacion==null && other.getPublicacion()==null) || 
             (this.publicacion!=null &&
              this.publicacion.equals(other.getPublicacion()))) &&
            ((this.valoraciones==null && other.getValoraciones()==null) || 
             (this.valoraciones!=null &&
              java.util.Arrays.equals(this.valoraciones, other.getValoraciones())));
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
        if (getPrecioFinal() != null) {
            _hashCode += getPrecioFinal().hashCode();
        }
        if (getReportes() != null) {
            _hashCode += getReportes().hashCode();
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
        if (getTags() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTags());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTags(), i);
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
        if (getValoraciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValoraciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValoraciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        elemField.setFieldName("precioFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precioFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("tags");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tags"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataTag"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valoraciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valoraciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataValoracion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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

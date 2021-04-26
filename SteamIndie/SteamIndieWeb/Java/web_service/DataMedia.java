/**
 * DataMedia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataMedia  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.String logo;

    private java.lang.String[] videos;

    private java.lang.String[] imagenes;

    public DataMedia() {
    }

    public DataMedia(
           java.lang.Integer id,
           java.lang.String logo,
           java.lang.String[] videos,
           java.lang.String[] imagenes) {
           this.id = id;
           this.logo = logo;
           this.videos = videos;
           this.imagenes = imagenes;
    }


    /**
     * Gets the id value for this DataMedia.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DataMedia.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the logo value for this DataMedia.
     * 
     * @return logo
     */
    public java.lang.String getLogo() {
        return logo;
    }


    /**
     * Sets the logo value for this DataMedia.
     * 
     * @param logo
     */
    public void setLogo(java.lang.String logo) {
        this.logo = logo;
    }


    /**
     * Gets the videos value for this DataMedia.
     * 
     * @return videos
     */
    public java.lang.String[] getVideos() {
        return videos;
    }


    /**
     * Sets the videos value for this DataMedia.
     * 
     * @param videos
     */
    public void setVideos(java.lang.String[] videos) {
        this.videos = videos;
    }

    public java.lang.String getVideos(int i) {
        return this.videos[i];
    }

    public void setVideos(int i, java.lang.String _value) {
        this.videos[i] = _value;
    }


    /**
     * Gets the imagenes value for this DataMedia.
     * 
     * @return imagenes
     */
    public java.lang.String[] getImagenes() {
        return imagenes;
    }


    /**
     * Sets the imagenes value for this DataMedia.
     * 
     * @param imagenes
     */
    public void setImagenes(java.lang.String[] imagenes) {
        this.imagenes = imagenes;
    }

    public java.lang.String getImagenes(int i) {
        return this.imagenes[i];
    }

    public void setImagenes(int i, java.lang.String _value) {
        this.imagenes[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataMedia)) return false;
        DataMedia other = (DataMedia) obj;
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
            ((this.logo==null && other.getLogo()==null) || 
             (this.logo!=null &&
              this.logo.equals(other.getLogo()))) &&
            ((this.videos==null && other.getVideos()==null) || 
             (this.videos!=null &&
              java.util.Arrays.equals(this.videos, other.getVideos()))) &&
            ((this.imagenes==null && other.getImagenes()==null) || 
             (this.imagenes!=null &&
              java.util.Arrays.equals(this.imagenes, other.getImagenes())));
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
        if (getLogo() != null) {
            _hashCode += getLogo().hashCode();
        }
        if (getVideos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVideos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVideos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getImagenes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImagenes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImagenes(), i);
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
        new org.apache.axis.description.TypeDesc(DataMedia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataMedia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("videos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "videos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagenes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagenes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

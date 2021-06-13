/**
 * DataMuro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataMuro  implements java.io.Serializable {
    private java.lang.Integer id;

    private web_service.DataPost[] posts;

    public DataMuro() {
    }

    public DataMuro(
           java.lang.Integer id,
           web_service.DataPost[] posts) {
           this.id = id;
           this.posts = posts;
    }


    /**
     * Gets the id value for this DataMuro.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DataMuro.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the posts value for this DataMuro.
     * 
     * @return posts
     */
    public web_service.DataPost[] getPosts() {
        return posts;
    }


    /**
     * Sets the posts value for this DataMuro.
     * 
     * @param posts
     */
    public void setPosts(web_service.DataPost[] posts) {
        this.posts = posts;
    }

    public web_service.DataPost getPosts(int i) {
        return this.posts[i];
    }

    public void setPosts(int i, web_service.DataPost _value) {
        this.posts[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataMuro)) return false;
        DataMuro other = (DataMuro) obj;
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
            ((this.posts==null && other.getPosts()==null) || 
             (this.posts!=null &&
              java.util.Arrays.equals(this.posts, other.getPosts())));
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
        if (getPosts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPosts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPosts(), i);
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
        new org.apache.axis.description.TypeDesc(DataMuro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataMuro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataPost"));
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

/**
 * DataCreador.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataCreador  extends web_service.DataUsuario  implements java.io.Serializable {
    private web_service.DataPublicacion[] publicaciones;

    public DataCreador() {
    }

    public DataCreador(
           java.lang.Integer id,
           java.lang.String nombre,
           java.lang.String apellido,
           java.lang.String email,
           java.lang.String password,
           java.lang.String nickname,
           web_service.DataPublicacion[] publicaciones) {
        super(
            id,
            nombre,
            apellido,
            email,
            password,
            nickname);
        this.publicaciones = publicaciones;
    }


    /**
     * Gets the publicaciones value for this DataCreador.
     * 
     * @return publicaciones
     */
    public web_service.DataPublicacion[] getPublicaciones() {
        return publicaciones;
    }


    /**
     * Sets the publicaciones value for this DataCreador.
     * 
     * @param publicaciones
     */
    public void setPublicaciones(web_service.DataPublicacion[] publicaciones) {
        this.publicaciones = publicaciones;
    }

    public web_service.DataPublicacion getPublicaciones(int i) {
        return this.publicaciones[i];
    }

    public void setPublicaciones(int i, web_service.DataPublicacion _value) {
        this.publicaciones[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataCreador)) return false;
        DataCreador other = (DataCreador) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.publicaciones==null && other.getPublicaciones()==null) || 
             (this.publicaciones!=null &&
              java.util.Arrays.equals(this.publicaciones, other.getPublicaciones())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getPublicaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublicaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublicaciones(), i);
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
        new org.apache.axis.description.TypeDesc(DataCreador.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataCreador"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publicaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataPublicacion"));
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

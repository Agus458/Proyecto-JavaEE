/**
 * AgregarJuegoAOferta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class AgregarJuegoAOferta  implements java.io.Serializable {
    private java.lang.Integer arg0;

    private int[] arg1;

    public AgregarJuegoAOferta() {
    }

    public AgregarJuegoAOferta(
           java.lang.Integer arg0,
           int[] arg1) {
           this.arg0 = arg0;
           this.arg1 = arg1;
    }


    /**
     * Gets the arg0 value for this AgregarJuegoAOferta.
     * 
     * @return arg0
     */
    public java.lang.Integer getArg0() {
        return arg0;
    }


    /**
     * Sets the arg0 value for this AgregarJuegoAOferta.
     * 
     * @param arg0
     */
    public void setArg0(java.lang.Integer arg0) {
        this.arg0 = arg0;
    }


    /**
     * Gets the arg1 value for this AgregarJuegoAOferta.
     * 
     * @return arg1
     */
    public int[] getArg1() {
        return arg1;
    }


    /**
     * Sets the arg1 value for this AgregarJuegoAOferta.
     * 
     * @param arg1
     */
    public void setArg1(int[] arg1) {
        this.arg1 = arg1;
    }

    public int getArg1(int i) {
        return this.arg1[i];
    }

    public void setArg1(int i, int _value) {
        this.arg1[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgregarJuegoAOferta)) return false;
        AgregarJuegoAOferta other = (AgregarJuegoAOferta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arg0==null && other.getArg0()==null) || 
             (this.arg0!=null &&
              this.arg0.equals(other.getArg0()))) &&
            ((this.arg1==null && other.getArg1()==null) || 
             (this.arg1!=null &&
              java.util.Arrays.equals(this.arg1, other.getArg1())));
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
        if (getArg0() != null) {
            _hashCode += getArg0().hashCode();
        }
        if (getArg1() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArg1());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArg1(), i);
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
        new org.apache.axis.description.TypeDesc(AgregarJuegoAOferta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "agregarJuegoAOferta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg0");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg0"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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

/**
 * DataPagina.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataPagina  implements java.io.Serializable {
    private java.lang.Integer pagina;

    private java.lang.Integer cantPaginas;

    private web_service.DataPost[] data;

    public DataPagina() {
    }

    public DataPagina(
           java.lang.Integer pagina,
           java.lang.Integer cantPaginas,
           web_service.DataPost[] data) {
           this.pagina = pagina;
           this.cantPaginas = cantPaginas;
           this.data = data;
    }


    /**
     * Gets the pagina value for this DataPagina.
     * 
     * @return pagina
     */
    public java.lang.Integer getPagina() {
        return pagina;
    }


    /**
     * Sets the pagina value for this DataPagina.
     * 
     * @param pagina
     */
    public void setPagina(java.lang.Integer pagina) {
        this.pagina = pagina;
    }


    /**
     * Gets the cantPaginas value for this DataPagina.
     * 
     * @return cantPaginas
     */
    public java.lang.Integer getCantPaginas() {
        return cantPaginas;
    }


    /**
     * Sets the cantPaginas value for this DataPagina.
     * 
     * @param cantPaginas
     */
    public void setCantPaginas(java.lang.Integer cantPaginas) {
        this.cantPaginas = cantPaginas;
    }


    /**
     * Gets the data value for this DataPagina.
     * 
     * @return data
     */
    public web_service.DataPost[] getData() {
        return data;
    }


    /**
     * Sets the data value for this DataPagina.
     * 
     * @param data
     */
    public void setData(web_service.DataPost[] data) {
        this.data = data;
    }

    public web_service.DataPost getData(int i) {
        return this.data[i];
    }

    public void setData(int i, web_service.DataPost _value) {
        this.data[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataPagina)) return false;
        DataPagina other = (DataPagina) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pagina==null && other.getPagina()==null) || 
             (this.pagina!=null &&
              this.pagina.equals(other.getPagina()))) &&
            ((this.cantPaginas==null && other.getCantPaginas()==null) || 
             (this.cantPaginas!=null &&
              this.cantPaginas.equals(other.getCantPaginas()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              java.util.Arrays.equals(this.data, other.getData())));
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
        if (getPagina() != null) {
            _hashCode += getPagina().hashCode();
        }
        if (getCantPaginas() != null) {
            _hashCode += getCantPaginas().hashCode();
        }
        if (getData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getData(), i);
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
        new org.apache.axis.description.TypeDesc(DataPagina.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataPagina"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pagina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantPaginas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantPaginas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
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

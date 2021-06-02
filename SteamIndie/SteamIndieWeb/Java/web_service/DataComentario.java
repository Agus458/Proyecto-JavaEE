/**
 * DataComentario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web_service;

public class DataComentario  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.Integer idJugador;

    private java.lang.Integer idJuego;

    private web_service.DataRespuesta[] respuestas;

    private java.lang.String contenido;

    private java.lang.Boolean reportado;

    private java.util.Calendar fechaPublicacion;

    public DataComentario() {
    }

    public DataComentario(
           java.lang.Integer id,
           java.lang.Integer idJugador,
           java.lang.Integer idJuego,
           web_service.DataRespuesta[] respuestas,
           java.lang.String contenido,
           java.lang.Boolean reportado,
           java.util.Calendar fechaPublicacion) {
           this.id = id;
           this.idJugador = idJugador;
           this.idJuego = idJuego;
           this.respuestas = respuestas;
           this.contenido = contenido;
           this.reportado = reportado;
           this.fechaPublicacion = fechaPublicacion;
    }


    /**
     * Gets the id value for this DataComentario.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DataComentario.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the idJugador value for this DataComentario.
     * 
     * @return idJugador
     */
    public java.lang.Integer getIdJugador() {
        return idJugador;
    }


    /**
     * Sets the idJugador value for this DataComentario.
     * 
     * @param idJugador
     */
    public void setIdJugador(java.lang.Integer idJugador) {
        this.idJugador = idJugador;
    }


    /**
     * Gets the idJuego value for this DataComentario.
     * 
     * @return idJuego
     */
    public java.lang.Integer getIdJuego() {
        return idJuego;
    }


    /**
     * Sets the idJuego value for this DataComentario.
     * 
     * @param idJuego
     */
    public void setIdJuego(java.lang.Integer idJuego) {
        this.idJuego = idJuego;
    }


    /**
     * Gets the respuestas value for this DataComentario.
     * 
     * @return respuestas
     */
    public web_service.DataRespuesta[] getRespuestas() {
        return respuestas;
    }


    /**
     * Sets the respuestas value for this DataComentario.
     * 
     * @param respuestas
     */
    public void setRespuestas(web_service.DataRespuesta[] respuestas) {
        this.respuestas = respuestas;
    }

    public web_service.DataRespuesta getRespuestas(int i) {
        return this.respuestas[i];
    }

    public void setRespuestas(int i, web_service.DataRespuesta _value) {
        this.respuestas[i] = _value;
    }


    /**
     * Gets the contenido value for this DataComentario.
     * 
     * @return contenido
     */
    public java.lang.String getContenido() {
        return contenido;
    }


    /**
     * Sets the contenido value for this DataComentario.
     * 
     * @param contenido
     */
    public void setContenido(java.lang.String contenido) {
        this.contenido = contenido;
    }


    /**
     * Gets the reportado value for this DataComentario.
     * 
     * @return reportado
     */
    public java.lang.Boolean getReportado() {
        return reportado;
    }


    /**
     * Sets the reportado value for this DataComentario.
     * 
     * @param reportado
     */
    public void setReportado(java.lang.Boolean reportado) {
        this.reportado = reportado;
    }


    /**
     * Gets the fechaPublicacion value for this DataComentario.
     * 
     * @return fechaPublicacion
     */
    public java.util.Calendar getFechaPublicacion() {
        return fechaPublicacion;
    }


    /**
     * Sets the fechaPublicacion value for this DataComentario.
     * 
     * @param fechaPublicacion
     */
    public void setFechaPublicacion(java.util.Calendar fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataComentario)) return false;
        DataComentario other = (DataComentario) obj;
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
            ((this.idJugador==null && other.getIdJugador()==null) || 
             (this.idJugador!=null &&
              this.idJugador.equals(other.getIdJugador()))) &&
            ((this.idJuego==null && other.getIdJuego()==null) || 
             (this.idJuego!=null &&
              this.idJuego.equals(other.getIdJuego()))) &&
            ((this.respuestas==null && other.getRespuestas()==null) || 
             (this.respuestas!=null &&
              java.util.Arrays.equals(this.respuestas, other.getRespuestas()))) &&
            ((this.contenido==null && other.getContenido()==null) || 
             (this.contenido!=null &&
              this.contenido.equals(other.getContenido()))) &&
            ((this.reportado==null && other.getReportado()==null) || 
             (this.reportado!=null &&
              this.reportado.equals(other.getReportado()))) &&
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
        if (getIdJugador() != null) {
            _hashCode += getIdJugador().hashCode();
        }
        if (getIdJuego() != null) {
            _hashCode += getIdJuego().hashCode();
        }
        if (getRespuestas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRespuestas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRespuestas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContenido() != null) {
            _hashCode += getContenido().hashCode();
        }
        if (getReportado() != null) {
            _hashCode += getReportado().hashCode();
        }
        if (getFechaPublicacion() != null) {
            _hashCode += getFechaPublicacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataComentario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataComentario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idJugador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idJugador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idJuego");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idJuego"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "respuestas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://web_service/", "dataRespuesta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contenido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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

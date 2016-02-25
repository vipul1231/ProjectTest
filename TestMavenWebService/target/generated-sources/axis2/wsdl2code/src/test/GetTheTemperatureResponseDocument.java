/*
 * An XML document type.
 * Localname: getTheTemperatureResponse
 * Namespace: http://test
 * Java type: test.GetTheTemperatureResponseDocument
 *
 * Automatically generated - do not modify.
 */
package test;


/**
 * A document containing one getTheTemperatureResponse(@http://test) element.
 *
 * This is a complex type.
 */
public interface GetTheTemperatureResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetTheTemperatureResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3428FF43F1E84A97B61E66A7E8481735").resolveHandle("getthetemperatureresponse7e25doctype");
    
    /**
     * Gets the "getTheTemperatureResponse" element
     */
    test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse getGetTheTemperatureResponse();
    
    /**
     * Sets the "getTheTemperatureResponse" element
     */
    void setGetTheTemperatureResponse(test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse getTheTemperatureResponse);
    
    /**
     * Appends and returns a new empty "getTheTemperatureResponse" element
     */
    test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse addNewGetTheTemperatureResponse();
    
    /**
     * An XML getTheTemperatureResponse(@http://test).
     *
     * This is a complex type.
     */
    public interface GetTheTemperatureResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetTheTemperatureResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3428FF43F1E84A97B61E66A7E8481735").resolveHandle("getthetemperatureresponse7b2belemtype");
        
        /**
         * Gets the "getTheTemperatureReturn" element
         */
        java.lang.String getGetTheTemperatureReturn();
        
        /**
         * Gets (as xml) the "getTheTemperatureReturn" element
         */
        org.apache.xmlbeans.XmlString xgetGetTheTemperatureReturn();
        
        /**
         * Sets the "getTheTemperatureReturn" element
         */
        void setGetTheTemperatureReturn(java.lang.String getTheTemperatureReturn);
        
        /**
         * Sets (as xml) the "getTheTemperatureReturn" element
         */
        void xsetGetTheTemperatureReturn(org.apache.xmlbeans.XmlString getTheTemperatureReturn);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse newInstance() {
              return (test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static test.GetTheTemperatureResponseDocument newInstance() {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static test.GetTheTemperatureResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static test.GetTheTemperatureResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static test.GetTheTemperatureResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static test.GetTheTemperatureResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static test.GetTheTemperatureResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static test.GetTheTemperatureResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static test.GetTheTemperatureResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static test.GetTheTemperatureResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static test.GetTheTemperatureResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static test.GetTheTemperatureResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static test.GetTheTemperatureResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static test.GetTheTemperatureResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static test.GetTheTemperatureResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static test.GetTheTemperatureResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static test.GetTheTemperatureResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static test.GetTheTemperatureResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static test.GetTheTemperatureResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (test.GetTheTemperatureResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

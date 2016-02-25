/*
 * An XML document type.
 * Localname: getTheTemperature
 * Namespace: http://test
 * Java type: test.GetTheTemperatureDocument
 *
 * Automatically generated - do not modify.
 */
package test;


/**
 * A document containing one getTheTemperature(@http://test) element.
 *
 * This is a complex type.
 */
public interface GetTheTemperatureDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetTheTemperatureDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3428FF43F1E84A97B61E66A7E8481735").resolveHandle("getthetemperature6f44doctype");
    
    /**
     * Gets the "getTheTemperature" element
     */
    test.GetTheTemperatureDocument.GetTheTemperature getGetTheTemperature();
    
    /**
     * Sets the "getTheTemperature" element
     */
    void setGetTheTemperature(test.GetTheTemperatureDocument.GetTheTemperature getTheTemperature);
    
    /**
     * Appends and returns a new empty "getTheTemperature" element
     */
    test.GetTheTemperatureDocument.GetTheTemperature addNewGetTheTemperature();
    
    /**
     * An XML getTheTemperature(@http://test).
     *
     * This is a complex type.
     */
    public interface GetTheTemperature extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetTheTemperature.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s3428FF43F1E84A97B61E66A7E8481735").resolveHandle("getthetemperature4ee9elemtype");
        
        /**
         * Gets the "city" element
         */
        java.lang.String getCity();
        
        /**
         * Gets (as xml) the "city" element
         */
        org.apache.xmlbeans.XmlString xgetCity();
        
        /**
         * Sets the "city" element
         */
        void setCity(java.lang.String city);
        
        /**
         * Sets (as xml) the "city" element
         */
        void xsetCity(org.apache.xmlbeans.XmlString city);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static test.GetTheTemperatureDocument.GetTheTemperature newInstance() {
              return (test.GetTheTemperatureDocument.GetTheTemperature) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static test.GetTheTemperatureDocument.GetTheTemperature newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (test.GetTheTemperatureDocument.GetTheTemperature) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static test.GetTheTemperatureDocument newInstance() {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static test.GetTheTemperatureDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static test.GetTheTemperatureDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static test.GetTheTemperatureDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static test.GetTheTemperatureDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static test.GetTheTemperatureDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static test.GetTheTemperatureDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static test.GetTheTemperatureDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static test.GetTheTemperatureDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static test.GetTheTemperatureDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static test.GetTheTemperatureDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static test.GetTheTemperatureDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static test.GetTheTemperatureDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static test.GetTheTemperatureDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static test.GetTheTemperatureDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static test.GetTheTemperatureDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static test.GetTheTemperatureDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static test.GetTheTemperatureDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (test.GetTheTemperatureDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

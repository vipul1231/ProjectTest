/*
 * An XML document type.
 * Localname: getTheTemperature
 * Namespace: http://test
 * Java type: test.GetTheTemperatureDocument
 *
 * Automatically generated - do not modify.
 */
package test.impl;
/**
 * A document containing one getTheTemperature(@http://test) element.
 *
 * This is a complex type.
 */
public class GetTheTemperatureDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements test.GetTheTemperatureDocument
{
    
    public GetTheTemperatureDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETTHETEMPERATURE$0 = 
        new javax.xml.namespace.QName("http://test", "getTheTemperature");
    
    
    /**
     * Gets the "getTheTemperature" element
     */
    public test.GetTheTemperatureDocument.GetTheTemperature getGetTheTemperature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            test.GetTheTemperatureDocument.GetTheTemperature target = null;
            target = (test.GetTheTemperatureDocument.GetTheTemperature)get_store().find_element_user(GETTHETEMPERATURE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getTheTemperature" element
     */
    public void setGetTheTemperature(test.GetTheTemperatureDocument.GetTheTemperature getTheTemperature)
    {
        synchronized (monitor())
        {
            check_orphaned();
            test.GetTheTemperatureDocument.GetTheTemperature target = null;
            target = (test.GetTheTemperatureDocument.GetTheTemperature)get_store().find_element_user(GETTHETEMPERATURE$0, 0);
            if (target == null)
            {
                target = (test.GetTheTemperatureDocument.GetTheTemperature)get_store().add_element_user(GETTHETEMPERATURE$0);
            }
            target.set(getTheTemperature);
        }
    }
    
    /**
     * Appends and returns a new empty "getTheTemperature" element
     */
    public test.GetTheTemperatureDocument.GetTheTemperature addNewGetTheTemperature()
    {
        synchronized (monitor())
        {
            check_orphaned();
            test.GetTheTemperatureDocument.GetTheTemperature target = null;
            target = (test.GetTheTemperatureDocument.GetTheTemperature)get_store().add_element_user(GETTHETEMPERATURE$0);
            return target;
        }
    }
    /**
     * An XML getTheTemperature(@http://test).
     *
     * This is a complex type.
     */
    public static class GetTheTemperatureImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements test.GetTheTemperatureDocument.GetTheTemperature
    {
        
        public GetTheTemperatureImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CITY$0 = 
            new javax.xml.namespace.QName("http://test", "city");
        
        
        /**
         * Gets the "city" element
         */
        public java.lang.String getCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CITY$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "city" element
         */
        public org.apache.xmlbeans.XmlString xgetCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "city" element
         */
        public void setCity(java.lang.String city)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CITY$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CITY$0);
                }
                target.setStringValue(city);
            }
        }
        
        /**
         * Sets (as xml) the "city" element
         */
        public void xsetCity(org.apache.xmlbeans.XmlString city)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CITY$0);
                }
                target.set(city);
            }
        }
    }
}

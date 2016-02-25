/*
 * An XML document type.
 * Localname: getTheTemperatureResponse
 * Namespace: http://test
 * Java type: test.GetTheTemperatureResponseDocument
 *
 * Automatically generated - do not modify.
 */
package test.impl;
/**
 * A document containing one getTheTemperatureResponse(@http://test) element.
 *
 * This is a complex type.
 */
public class GetTheTemperatureResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements test.GetTheTemperatureResponseDocument
{
    
    public GetTheTemperatureResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETTHETEMPERATURERESPONSE$0 = 
        new javax.xml.namespace.QName("http://test", "getTheTemperatureResponse");
    
    
    /**
     * Gets the "getTheTemperatureResponse" element
     */
    public test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse getGetTheTemperatureResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse target = null;
            target = (test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse)get_store().find_element_user(GETTHETEMPERATURERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getTheTemperatureResponse" element
     */
    public void setGetTheTemperatureResponse(test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse getTheTemperatureResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse target = null;
            target = (test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse)get_store().find_element_user(GETTHETEMPERATURERESPONSE$0, 0);
            if (target == null)
            {
                target = (test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse)get_store().add_element_user(GETTHETEMPERATURERESPONSE$0);
            }
            target.set(getTheTemperatureResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getTheTemperatureResponse" element
     */
    public test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse addNewGetTheTemperatureResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse target = null;
            target = (test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse)get_store().add_element_user(GETTHETEMPERATURERESPONSE$0);
            return target;
        }
    }
    /**
     * An XML getTheTemperatureResponse(@http://test).
     *
     * This is a complex type.
     */
    public static class GetTheTemperatureResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements test.GetTheTemperatureResponseDocument.GetTheTemperatureResponse
    {
        
        public GetTheTemperatureResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName GETTHETEMPERATURERETURN$0 = 
            new javax.xml.namespace.QName("http://test", "getTheTemperatureReturn");
        
        
        /**
         * Gets the "getTheTemperatureReturn" element
         */
        public java.lang.String getGetTheTemperatureReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GETTHETEMPERATURERETURN$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "getTheTemperatureReturn" element
         */
        public org.apache.xmlbeans.XmlString xgetGetTheTemperatureReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GETTHETEMPERATURERETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "getTheTemperatureReturn" element
         */
        public void setGetTheTemperatureReturn(java.lang.String getTheTemperatureReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GETTHETEMPERATURERETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(GETTHETEMPERATURERETURN$0);
                }
                target.setStringValue(getTheTemperatureReturn);
            }
        }
        
        /**
         * Sets (as xml) the "getTheTemperatureReturn" element
         */
        public void xsetGetTheTemperatureReturn(org.apache.xmlbeans.XmlString getTheTemperatureReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GETTHETEMPERATURERETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(GETTHETEMPERATURERETURN$0);
                }
                target.set(getTheTemperatureReturn);
            }
        }
    }
}

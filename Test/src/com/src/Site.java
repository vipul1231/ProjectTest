package com.src;

public class Site {
    private Integer siteID = null;
    private String siteDescription = null;

    public Site() {
    }

    
   
    public Integer getSiteID() {
        return this.siteID;
    }

    public void setSiteID(Integer siteID) {
        this.siteID = siteID;
    }
    
    public String getSiteDescription() {
        return this.siteDescription;
    }

    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Site {\n");
        sb.append("  siteID: ").append(this.siteID).append("\n");
        sb.append("  siteDescription: ").append(this.siteDescription).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}


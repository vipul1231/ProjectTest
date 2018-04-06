package com.src;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StopCodes  {
	  
	  private List<PropertyStopCodes> propertyStopCodes = new ArrayList<PropertyStopCodes>();

	  
	  /**
	   * The MgmCasinoPlayer object for this player at this property.
	   **/
	  @JsonProperty("propertyStopCodes")
	  public List<PropertyStopCodes> getPropertyStopCodes() {
	    return propertyStopCodes;
	  }
	  public void setPropertyStopCodes(List<PropertyStopCodes> propertyStopCodes) {
	    this.propertyStopCodes = propertyStopCodes;
	  }

	  

	  @Override
	  public String toString()  {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class StopCodes {\n");
	    
	    sb.append("  propertyStopCodes: ").append(propertyStopCodes).append("\n");
	    sb.append("}\n");
	    return sb.toString();
	  }
	}


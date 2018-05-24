package com.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


class ChipInfo  {
	  
	  private Integer denom = null;
	  private Integer noOfChips = null;

	  
	  /**
	   * denom of chips
	   **/
	  public Integer getDenom() {
	    return denom;
	  }
	  public void setDenom(Integer denom) {
	    this.denom = denom;
	  }

	  
	  /**
	   * no of chips
	   **/
	  public Integer getNoOfChips() {
	    return noOfChips;
	  }
	  public void setNoOfChips(Integer noOfChips) {
	    this.noOfChips = noOfChips;
	  }

	  

	  @Override
	  public String toString()  {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ChipInfo {\n");
	    
	    sb.append("  denom: ").append(denom).append("\n");
	    sb.append("  noOfChips: ").append(noOfChips).append("\n");
	    sb.append("}\n");
	    return sb.toString();
	  }
	}


class ChipMoveElement  {
	  
	  private List<ChipInfo> moves = new ArrayList<ChipInfo>();

	  
	  /**
	   * List of chip moves
	   **/
	  public List<ChipInfo> getMoves() {
	    return moves;
	  }
	  public void setMoves(List<ChipInfo> moves) {
	    this.moves = moves;
	  }

	  

	  @Override
	  public String toString()  {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ChipMoveElement {\n");
	    
	    sb.append("  moves: ").append(moves).append("\n");
	    sb.append("}\n");
	    return sb.toString();
	  }
	}


public class EmptyClass {
	
	public static void main(String[] args){
		
		ChipMoveElement chipMoveElement = new ChipMoveElement();
		ChipInfo chipInfo = new ChipInfo();
		chipInfo.setDenom(100);
		chipInfo.setNoOfChips(3);
		
		ChipInfo chipInfo1 = new ChipInfo();
		chipInfo1.setDenom(100);
		chipInfo1.setNoOfChips(3);
		
		chipMoveElement.getMoves().add(chipInfo);
		chipMoveElement.getMoves().add(chipInfo1);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File("read.json"),chipMoveElement);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

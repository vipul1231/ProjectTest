package com.src;

import java.util.*;


/**
 * Player object containing list of mgm casino players.
 **/
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2017-09-01T14:05:30.887+05:30")
public class Players  {
  
  private List<MgmCasinoPlayer> players = new ArrayList<MgmCasinoPlayer>();

  
  /**
   * The MgmCasinoPlayer object for this player at this property.
   **/
  
  public List<MgmCasinoPlayer> getPlayers() {
    return players;
  }
  public void setPlayers(List<MgmCasinoPlayer> players) {
    this.players = players;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Players {\n");
    
    sb.append("  players: ").append(players).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

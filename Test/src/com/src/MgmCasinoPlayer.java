package com.src;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MgmCasinoPlayer  {
	  
	  private String playerID = null;
	  private String lastName = null;
	  private String firstName = null;
	  private String middleName = null;
	  private String preferredName = null;
	  private String cardId = null;
	  private String dateOfBirth = null;
	  private String city = null;
	  private String state = null;
	  private String country = null;
	  private String creditAccount = null;
	  private String ranking = null;
	  private Integer siteID = null;
	  private String siteDescription = null;
	  private StopCodes stopCodes = null;

	  
	  
	  @JsonProperty("playerID")
	  public String getPlayerID() {
	    return playerID;
	  }
	  public void setPlayerID(String playerID) {
	    this.playerID = playerID;
	  }

	  
	  /**
	   * The last name of the player.
	   **/
	  
	  @JsonProperty("lastName")
	  public String getLastName() {
	    return lastName;
	  }
	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	  
	  /**
	   * The first name of the player.
	   **/
	  
	  @JsonProperty("firstName")
	  public String getFirstName() {
	    return firstName;
	  }
	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  
	  /**
	   * The middle name of the player.
	   **/
	  
	  @JsonProperty("middleName")
	  public String getMiddleName() {
	    return middleName;
	  }
	  public void setMiddleName(String middleName) {
	    this.middleName = middleName;
	  }

	  
	  /**
	   * The preferred name of the player.
	   **/
	  
	  @JsonProperty("preferredName")
	  public String getPreferredName() {
	    return preferredName;
	  }
	  public void setPreferredName(String preferredName) {
	    this.preferredName = preferredName;
	  }

	  
	  /**
	   * The card Id of the player.
	   **/
	 
	  @JsonProperty("cardId")
	  public String getCardId() {
	    return cardId;
	  }
	  public void setCardId(String cardId) {
	    this.cardId = cardId;
	  }

	  
	  /**
	   * The DOB of the player.
	   **/
	  
	  @JsonProperty("dateOfBirth")
	  public String getDateOfBirth() {
	    return dateOfBirth;
	  }
	  public void setDateOfBirth(String dateOfBirth) {
	    this.dateOfBirth = dateOfBirth;
	  }

	  
	  /**
	   * The city of the player.
	   **/
	  
	  @JsonProperty("city")
	  public String getCity() {
	    return city;
	  }
	  public void setCity(String city) {
	    this.city = city;
	  }

	  
	  /**
	   * The state of the player.
	   **/
	 
	  @JsonProperty("state")
	  public String getState() {
	    return state;
	  }
	  public void setState(String state) {
	    this.state = state;
	  }

	  
	  /**
	   * The country of the player.
	   **/
	  
	  @JsonProperty("country")
	  public String getCountry() {
	    return country;
	  }
	  public void setCountry(String country) {
	    this.country = country;
	  }

	  
	  /**
	   * The credit Account of the player.
	   **/
	  
	  @JsonProperty("creditAccount")
	  public String getCreditAccount() {
	    return creditAccount;
	  }
	  public void setCreditAccount(String creditAccount) {
	    this.creditAccount = creditAccount;
	  }

	  
	  /**
	   * The ranking of the player.
	   **/
	  
	  @JsonProperty("ranking")
	  public String getRanking() {
	    return ranking;
	  }
	  public void setRanking(String ranking) {
	    this.ranking = ranking;
	  }

	  
	  /**
	   * The site ID of the player.
	   **/
	  
	  @JsonProperty("siteID")
	  public Integer getSiteID() {
	    return siteID;
	  }
	  public void setSiteID(Integer siteID) {
	    this.siteID = siteID;
	  }

	  
	  /**
	   * The siteDescription of the player.
	   **/
	 
	  @JsonProperty("siteDescription")
	  public String getSiteDescription() {
	    return siteDescription;
	  }
	  public void setSiteDescription(String siteDescription) {
	    this.siteDescription = siteDescription;
	  }

	  
	  /**
	   * The stop codes for this player at this property.
	   **/
	  
	  @JsonProperty("stopCodes")
	  public StopCodes getStopCodes() {
	    return stopCodes;
	  }
	  public void setStopCodes(StopCodes stopCodes) {
	    this.stopCodes = stopCodes;
	  }

	  

	  @Override
	  public String toString()  {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class MgmCasinoPlayer {\n");
	    
	    sb.append("  playerID: ").append(playerID).append("\n");
	    sb.append("  lastName: ").append(lastName).append("\n");
	    sb.append("  firstName: ").append(firstName).append("\n");
	    sb.append("  middleName: ").append(middleName).append("\n");
	    sb.append("  preferredName: ").append(preferredName).append("\n");
	    sb.append("  cardId: ").append(cardId).append("\n");
	    sb.append("  dateOfBirth: ").append(dateOfBirth).append("\n");
	    sb.append("  city: ").append(city).append("\n");
	    sb.append("  state: ").append(state).append("\n");
	    sb.append("  country: ").append(country).append("\n");
	    sb.append("  creditAccount: ").append(creditAccount).append("\n");
	    sb.append("  ranking: ").append(ranking).append("\n");
	    sb.append("  siteID: ").append(siteID).append("\n");
	    sb.append("  siteDescription: ").append(siteDescription).append("\n");
	    sb.append("  stopCodes: ").append(stopCodes).append("\n");
	    sb.append("}\n");
	    return sb.toString();
	  }
	}


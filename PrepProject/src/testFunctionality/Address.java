package testFunctionality;

public class Address {

	int homeNo;
	public int getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	String street;
	String city;
	
	public Address(int homeNumber, String Street,String City) {
		
		this.homeNo = homeNumber;
		this.street = Street;
		this.city = City;
	}
	
}

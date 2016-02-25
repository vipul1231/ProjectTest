package hibernateVehicle;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FOUR_WHEELER")
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	
	@Column(name="STEERING_TYPE")
	private String streeingFourWheeler;

	public String getStreeingTwoWheeler() {
		return streeingFourWheeler;
	}

	public void setStreeingTwoWheeler(String streeingFourWheeler) {
		this.streeingFourWheeler = streeingFourWheeler;
	}
}

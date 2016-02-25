package hibernateVehicle;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TWO_WHEELER")
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle{
	
	@Column(name="STEERING_TYPE")
	private String streeingTwoWheeler;

	public String getStreeingTwoWheeler() {
		return streeingTwoWheeler;
	}

	public void setStreeingTwoWheeler(String streeingTwoWheeler) {
		this.streeingTwoWheeler = streeingTwoWheeler;
	}
}

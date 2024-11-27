package dev.pedrolobo.customerservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "tb_customer_address")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
	@NotNull
	@Column(length = 60)
  private String streetName;

	@NotNull
	@Column(length = 5)
  private int houseNumber;

	@NotNull
	@Column(length = 5)
  
  private String neighborhoodName;

	@NotNull
	@Column(length = 5)
  private String cityName;

  @NotNull
	@Column(length = 2)
  private String state;

  @NotNull
	@Column(length = 9)
  private String zipCode;
}

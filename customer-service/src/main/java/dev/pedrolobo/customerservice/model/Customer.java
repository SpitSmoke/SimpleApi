package dev.pedrolobo.customerservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import dev.pedrolobo.customerservice.utils.Gender;

@Data
@Entity
@Builder
@Table(name = "tb_customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

	@NotNull
	@Column(length = 60)
  private String name;

	@NotNull
  @Enumerated(EnumType.STRING)
  private Gender gender;

	@NotNull
	@Column(length = 60)
  @Pattern(regexp = ".+@.+\\..+", message = "invalid email")
  private String email;

	@Column(length = 11)
  private String telephone;

  @Temporal(TemporalType.DATE)
  private LocalDate birthDay;
  
	@NotNull
  @OneToOne(cascade=CascadeType.ALL)
  private CustomerAddress address;

}

package dev.pedrolobo.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import dev.pedrolobo.customerservice.model.CustomerAddress;
import dev.pedrolobo.customerservice.utils.Gender;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse{

  @Id
  private Long id;
  private String name;
  private Gender gender;
  private String email;
  private LocalDate birthDay;
  private String telephone;
  private CustomerAddress address;
}


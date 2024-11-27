package dev.pedrolobo.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import dev.pedrolobo.customerservice.model.CustomerAddress;
import dev.pedrolobo.customerservice.utils.Gender;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest{

  private String name;
  private Gender gender;
  private String email;
  private LocalDate birthDay;
  private String telephone;
  private CustomerAddress address;
}

package dev.pedrolobo.customerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.pedrolobo.customerservice.dto.CustomerRequest;
import dev.pedrolobo.customerservice.dto.CustomerResponse;
import dev.pedrolobo.customerservice.model.CustomerAddress;
import dev.pedrolobo.customerservice.model.Customer;
import dev.pedrolobo.customerservice.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final ICustomerRepository customerRepository;

  public void update(CustomerRequest customerRequest, Long id) {
    customerRepository.save(mapCustomerToEntity(customerRequest, id));
  }

  public void add(CustomerRequest customerRequest) {
    Customer customer = buildCustomer(customerRequest);
    customerRepository.save(customer);
  }

  public boolean existsById(Long id) {
    return customerRepository.existsById(id);
  }

  public CustomerResponse getById(Long id) {
    return mapToResponse(customerRepository.findById(id).get());
  }

  public List<CustomerResponse> getAll() {
    List<Customer> customers = customerRepository.findAll();
    return customers.stream().map(customer -> mapToResponse(customer)).toList();
  }

  public void deleteById(Long id) {
    customerRepository.deleteById(id);
  }

  private CustomerResponse mapToResponse(Customer customer) {

    return CustomerResponse.builder()
        .id(customer.getId())
        .name(customer.getName())
        .gender(customer.getGender())
        .email(customer.getEmail())
        .birthDay(customer.getBirthDay())
        .telephone(customer.getTelephone())
        .address(customer.getAddress())
        .build();
  }

  private Customer buildCustomer(CustomerRequest customerRequest) {
    CustomerAddress address = CustomerAddress.builder()
        .streetName(customerRequest.getAddress().getStreetName())
        .houseNumber(customerRequest.getAddress().getHouseNumber())
        .neighborhoodName(customerRequest.getAddress().getNeighborhoodName())
        .cityName(customerRequest.getAddress().getCityName())
        .state(customerRequest.getAddress().getState())
        .zipCode(customerRequest.getAddress().getZipCode())
        .build();

    Customer customer = Customer.builder()
        .name(customerRequest.getName())
        .gender(customerRequest.getGender())
        .email(customerRequest.getEmail())
        .birthDay(customerRequest.getBirthDay())
        .telephone(customerRequest.getTelephone())
        .address(address)
        .build();
    return customer;
  }

  private Customer mapCustomerToEntity(CustomerRequest customerRequest, Long id){
    Customer customer = buildCustomer(customerRequest);
    customer.setId(id);

    CustomerAddress customerAddress = customer.getAddress();
    customerAddress.setId(customerRepository.findById(id).get().getAddress().getId());
    customer.setAddress(customerAddress);
    return customer;
  }

}

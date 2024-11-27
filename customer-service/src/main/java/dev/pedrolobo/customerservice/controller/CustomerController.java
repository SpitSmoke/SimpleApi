package dev.pedrolobo.customerservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.pedrolobo.customerservice.controller.exception.CustomerNotFoundException;
import dev.pedrolobo.customerservice.dto.CustomerRequest;
import dev.pedrolobo.customerservice.dto.CustomerResponse;
import dev.pedrolobo.customerservice.service.CustomerService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/customer-service")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody @Valid CustomerRequest customerRequest) {
    customerService.add(customerRequest);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody @Valid CustomerRequest customerRequest, @PathVariable(value = "id") Long id) {
    if (!customerService.existsById(id)) {
      throw new CustomerNotFoundException(id);
    }
    customerService.update(customerRequest, id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CustomerResponse> getAllCustomers() {
    return customerService.getAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CustomerResponse get(@PathVariable(value = "id") Long id) {
    if (!customerService.existsById(id)) {
      throw new CustomerNotFoundException(id);
    }
    return customerService.getById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable(value = "id") Long id) {
    if (!customerService.existsById(id)) {
      throw new CustomerNotFoundException(id);
    }
    customerService.deleteById(id);
  }

}

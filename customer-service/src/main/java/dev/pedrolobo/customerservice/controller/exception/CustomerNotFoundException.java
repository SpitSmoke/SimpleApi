package dev.pedrolobo.customerservice.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

  public CustomerNotFoundException(Long id) {
    super(String.format("Customer with id %s not found.", id));
  }
}

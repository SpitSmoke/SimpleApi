package dev.pedrolobo.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pedrolobo.customerservice.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}

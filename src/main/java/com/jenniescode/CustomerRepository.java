package com.jenniescode;

import org.springframework.data.jpa.repository.JpaRepository;

// <Customer,Integer>：the Integer represents the type of the primary key of the Customer entity(id of the customer)
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}

package com.OnWeb.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnWeb.demo.pojos.Payment;

public interface IPaymentRepo extends JpaRepository<Payment, Integer>{

}

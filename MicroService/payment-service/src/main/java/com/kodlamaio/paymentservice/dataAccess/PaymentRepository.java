package com.kodlamaio.paymentservice.dataAccess;

import com.kodlamaio.paymentservice.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,String> {
    boolean existsByRentalId(String rentalId);
}

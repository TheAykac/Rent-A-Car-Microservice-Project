package com.kodlamaio.paymentservice.dataAccess;

import com.kodlamaio.paymentservice.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,String> {
}

package com.vinay.InquireCustomer.repository;

import com.vinay.InquireCustomer.model.CustomerAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccountModel, Long> {

}

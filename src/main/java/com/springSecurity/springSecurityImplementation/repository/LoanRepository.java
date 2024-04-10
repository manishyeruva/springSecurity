package com.springSecurity.springSecurityImplementation.repository;

import java.util.List;

import com.springSecurity.springSecurityImplementation.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}

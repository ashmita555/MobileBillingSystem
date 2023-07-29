package com.cg.mobilebilling.daoservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;

public interface PostpaidAccountDAOServices extends JpaRepository<PostpaidAccount, Long>{
	
	@Query("SELECT p from PostpaidAccount p WHERE p.customer.customerID =:customerID ")
	public List<PostpaidAccount> getCustomerAllPostpaidAccountsDetails(@Param("customerID") int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException;
	
}

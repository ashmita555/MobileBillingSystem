package com.cg.mobilebilling.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobilebilling.beans.Customer;

public interface CustomerDAOServices extends JpaRepository<Customer, Integer>{

}

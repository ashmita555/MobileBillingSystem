package com.cg.mobilebilling.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class CustomerController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/customerController")
	public ModelAndView registerCustomer(HttpServletRequest request) {
		try {
			HttpSession session=request.getSession(false);
			Customer customer=billingServices.getCustomerDetails((int) session.getAttribute("customerID"));
			return new ModelAndView("getCustomerDetails", "customer", customer);
		} catch (CustomerDetailsNotFoundException | BillingServicesDownException e) {
			return new ModelAndView("getCustomerDetails", "message", e.getMessage());
		} 
	}
}

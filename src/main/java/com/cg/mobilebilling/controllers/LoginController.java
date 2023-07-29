package com.cg.mobilebilling.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class LoginController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/LoginController")
	public ModelAndView registerCustomer(@RequestParam("customerID")int customerID, HttpServletRequest request) {
		try {
			Customer customer= billingServices.getCustomerDetails(customerID);
			HttpSession session=request.getSession();
			session.setAttribute("customerID", customerID);
			return new ModelAndView("welcomePage", "customer", customer);
		} catch (CustomerDetailsNotFoundException | BillingServicesDownException e) {
			return new ModelAndView("loginPage", "message", e.getMessage());
		} 
	}
}

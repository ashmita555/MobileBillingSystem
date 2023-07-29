package com.cg.mobilebilling.controllers;

import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.services.BillingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class OpenCustomerAccountController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/openCustomerAccountController")
	public ModelAndView registerCustomer(@Valid @ModelAttribute Customer customer,BindingResult result,@RequestParam("planID") int planID, HttpServletRequest request) throws BillingServicesDownException, PlanDetailsNotFoundException, CustomerDetailsNotFoundException {
		if(result.hasErrors()) return new ModelAndView("accountOpeningPage");
		int customerID=billingServices.acceptCustomerDetails(customer.getFirstName(), customer.getLastName(), customer.getEmailID(),
				customer.getDateOfBirth(), customer.getAddress().getCity(), customer.getAddress().getState(), customer.getAddress().getPinCode());
		customer.setCustomerID(customerID);
		long mobileNo=billingServices.openPostpaidMobileAccount(customerID, planID);
		HttpSession session=request.getSession();
		session.setAttribute("mobileNo", mobileNo);
		return new ModelAndView("accountOpeningSuccessfulPage", "customer", customer);
	}
	
}

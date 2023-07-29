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
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class OpenPostpaidAccountController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/openPostpaidAccountController")
	public ModelAndView registerCustomer(@RequestParam("planID")int planID, HttpServletRequest request) {
		try {
			HttpSession session=request.getSession(false);
			int customerID=(int) session.getAttribute("customerID");
			long mobileNo=billingServices.openPostpaidMobileAccount(customerID, planID);
			session.setAttribute("check", 1);
			return new ModelAndView("openPostpaidAccount", "mobileNo", mobileNo);
		} catch (CustomerDetailsNotFoundException | PlanDetailsNotFoundException | BillingServicesDownException e) {
			return new ModelAndView("openPostpaidAccount", "message", e.getMessage());
		} 
	}
}

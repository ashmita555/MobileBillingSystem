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
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class ChangeAccountPlanController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/changeAccountPlanController")
	public ModelAndView registerCustomer(@RequestParam("mobileNo") long mobileNo,@RequestParam("planID") int planID, HttpServletRequest request) 
	throws CustomerDetailsNotFoundException,PostpaidAccountNotFoundException, PlanDetailsNotFoundException, BillingServicesDownException{
		try {
			HttpSession session=request.getSession();
			int customerID=(int) session.getAttribute("customerID");
			billingServices.changePlan(customerID, mobileNo, planID);
			return new ModelAndView("changeAccountPlan", "message","Plan changed!!");
		} catch (CustomerDetailsNotFoundException |PostpaidAccountNotFoundException | PlanDetailsNotFoundException | BillingServicesDownException e) {
			return new ModelAndView("changeAccountPlan", "message", e.getMessage());
		} 
	}
}

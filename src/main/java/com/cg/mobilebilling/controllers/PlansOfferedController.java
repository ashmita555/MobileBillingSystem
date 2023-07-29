package com.cg.mobilebilling.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class PlansOfferedController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/plansOfferedController")
	public ModelAndView registerCustomer(HttpServletRequest request) {
		try {
			ArrayList<Plan>plans=(ArrayList<Plan>) billingServices.getPlanAllDetails();
			return new ModelAndView("plansOffered", "plans",plans);
		} catch (BillingServicesDownException e) {
			return new ModelAndView("plansOffered", "message", e.getMessage());
		} 
	}
}

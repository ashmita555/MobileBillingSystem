package com.cg.mobilebilling.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class DeactivatePostpaidAccountController {
	@Autowired
	private BillingServices billingServices;
	@RequestMapping("/deactivatePostpaidAccountController")
	public ModelAndView registerCustomer(@RequestParam("mobileNo") int mobileNo,HttpServletRequest request) {
		try {
			HttpSession session=request.getSession();
			int customerID=(int) session.getAttribute("customerID");
			billingServices.closeCustomerPostPaidAccount(customerID, mobileNo);
			return new ModelAndView("deactivatePostpaidAccount", "message", "Account Deactivated Successfully");
		} catch (CustomerDetailsNotFoundException | BillingServicesDownException | PostpaidAccountNotFoundException e) {
			return new ModelAndView("deactivatePostpaidAccount", "message", e.getMessage());
		} 
	}
}

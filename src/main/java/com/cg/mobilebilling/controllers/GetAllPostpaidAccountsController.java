package com.cg.mobilebilling.controllers;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class GetAllPostpaidAccountsController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/getAllPostpaidAccountsController")
	public ModelAndView registerCustomer(HttpServletRequest request) {
		try {
			HttpSession session=request.getSession(false);
			int customerID=(int) session.getAttribute("customerID");
			ArrayList<PostpaidAccount>postpaidAccounts=(ArrayList<PostpaidAccount>) billingServices.getCustomerAllPostpaidAccountsDetails(customerID);
			return new ModelAndView("getAllPostpaidAccounts", "postpaidAccounts", postpaidAccounts);
		} catch (CustomerDetailsNotFoundException | BillingServicesDownException e) {
			return new ModelAndView("getAllPostpaidAccounts", "message", e.getMessage());
		} 
	}
}

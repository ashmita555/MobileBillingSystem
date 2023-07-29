package com.cg.mobilebilling.controllers;

import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.exceptions.*;
import com.cg.mobilebilling.services.BillingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class GetBillDetailsController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/getBillDetailsController")
	public ModelAndView registerCustomer(@RequestParam("mobileNo")long mobileNo,@RequestParam("billMonth")String billMonth, HttpServletRequest request) {
		try {
			HttpSession session=request.getSession(false);
			int customerID=(int) session.getAttribute("customerID");
			session.setAttribute("check2", 1);
			Bill bill=billingServices.getMobileBillDetails(customerID, mobileNo, billMonth);
			/*return new ModelAndView("billDetails", "bill", bill);*/
			Customer customer=billingServices.getCustomerDetails(customerID);
			PostpaidAccount postpaidAccount=billingServices.getPostPaidAccountDetails(customerID, mobileNo);
			ModelAndView model = new ModelAndView("pdfView");
			model.addObject("customer", customer);
			model.addObject("postpaidAccount", postpaidAccount);
			model.addObject("bill", bill);
			return model;
			
		} catch (CustomerDetailsNotFoundException | BillingServicesDownException | PostpaidAccountNotFoundException| InvalidBillMonthException|BillDetailsNotFoundException  e) {
			return new ModelAndView("billDetails", "message", e.getMessage());
		} 
	}
}

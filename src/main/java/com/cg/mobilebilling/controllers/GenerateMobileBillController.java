package com.cg.mobilebilling.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;
@Controller
public class GenerateMobileBillController {
	@Autowired
	private BillingServices billingServices;
	
	@RequestMapping("/generateBillController")
	public ModelAndView getGenerateBillAction( @RequestParam("mobileNo") long mobileNo, @ModelAttribute Bill bill,BindingResult result,HttpServletRequest request) {
		try {
			Customer customer = billingServices.getCustomerDetails((int) request.getSession(false).getAttribute("customerID"));
			PostpaidAccount account = billingServices.getPostPaidAccountDetails(customer.getCustomerID(), mobileNo);
			int billId = billingServices.generateMonthlyMobileBill(customer.getCustomerID(), mobileNo, bill.getBillMonth(), bill.getNoOfLocalSMS(), bill.getNoOfStdSMS(), bill.getNoOfLocalCalls(), bill.getNoOfStdCalls(), bill.getInternetDataUsageUnits());
			//GeneratePdfReport.generateBillSummaryReport(customer, account.getPlan(), account); 
			return new ModelAndView("generateBillPage", "resultMessage", "Your generated Bill ID is: " + billId);
		} catch (BillingServicesDownException | CustomerDetailsNotFoundException | PostpaidAccountNotFoundException | InvalidBillMonthException | PlanDetailsNotFoundException e) {
			return new ModelAndView("generateBillPage", "errorMessage", e.getMessage());
		}
	}
}

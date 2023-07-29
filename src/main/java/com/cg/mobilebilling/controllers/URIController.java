package com.cg.mobilebilling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.PostpaidAccount;

@Controller
public class URIController {
	@RequestMapping("/")
	public String getIndexPage() {
		return "loginPage";
	}
	
	@RequestMapping("/headerPage")
	public String getHeaderPage() {
		return "headerPage";
	}
	
	@RequestMapping("/loginPage")
	public String getLoginPage() {
		return "loginPage";
	}
	
	
	@RequestMapping("/accountOpeningPage")
	public String getAccountOpeningPage() {
		return "accountOpeningPage";
	}
	
	@RequestMapping("/accountOpeningSuccessfulPage")
	public String getAccountOpeningSuccessfulPage() {
		return "accountOpeningSuccessfulPage";
	}
	
	@RequestMapping("/welcomePage")
	public String getWelcomePage() {
		return "welcomePage";
	}
	
	@RequestMapping("/getCustomerDetails")
	public String getCustomerDetails() {
		return "getCustomerDetails";
	}
	@RequestMapping("/plansOffered")
	public String getPlansOffered() {
		return "plansOffered";
	}
	
	@RequestMapping("/openPostpaidAccount")
	public String getOpenPostpaidAccount() {
		return "openPostpaidAccount";
	}
	
	@RequestMapping("/getAllPostpaidAccounts")
	public String getAllPostpaidAccounts() {
		return "getAllPostpaidAccounts";
	}
	
	@RequestMapping("/changeAccountPlan")
	public String changeAccountPlan() {
		return "changeAccountPlan";
	}
	
	@RequestMapping("/deactivatePostpaidAccount")
	public String deactivatePostpaidAccount() {
		return "deactivatePostpaidAccount";
	}
	
	@RequestMapping("/generateBillPage")
	public String generateBill() {
		return "generateBillPage";
	}
	
	@RequestMapping("/billDetails")
	public String billDetails() {
		return "billDetails";
	}
	
	@ModelAttribute
	public Customer getCustomer() {
		Customer customer= new Customer();
		return customer;
	}
	
	@ModelAttribute
	public PostpaidAccount getpostpaidAccount() {
		PostpaidAccount postpaidAccount= new PostpaidAccount();
		return postpaidAccount;
	}
	
	@ModelAttribute
	public Bill getBill() {
		Bill bill=new Bill();
		return bill;
	}
}

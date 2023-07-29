package com.cg.mobilebilling.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mobilebilling.beans.Address;
import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.daoservices.BillingDAOServices;
import com.cg.mobilebilling.daoservices.CustomerDAOServices;
import com.cg.mobilebilling.daoservices.PlanDAOServices;
import com.cg.mobilebilling.daoservices.PostpaidAccountDAOServices;
import com.cg.mobilebilling.exceptions.BillDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;

@Component("billingServices")
public class BillingServicesImpl implements BillingServices {
	
	@Autowired
	 CustomerDAOServices customerDAOServices;
	@Autowired
	BillingDAOServices billingDAOServices;
	@Autowired
	 PlanDAOServices planDAOServices;
	@Autowired
	PostpaidAccountDAOServices postpaidAccountDAOServices;
	
	@Override
	public List<Plan> getPlanAllDetails() throws BillingServicesDownException {
		return planDAOServices.findAll();
	}

	@Override
	public int acceptCustomerDetails(String firstName, String lastName, String emailID, String dateOfBirth,
			String billingAddressCity, String billingAddressState, int billingAddressPinCode)
			throws BillingServicesDownException {
		Customer customer= new Customer(firstName, lastName, emailID, dateOfBirth, new Address(billingAddressPinCode, billingAddressCity, billingAddressState), null);
		customer=customerDAOServices.save(customer);
		return customer.getCustomerID();
	}
	
	
	@Override
	public int generateMonthlyMobileBill(int customerID, long mobileNo, String billMonth, int noOfLocalSMS,
			int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls, int internetDataUsageUnits)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
			BillingServicesDownException, PlanDetailsNotFoundException {
		Customer customer= customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		PostpaidAccount postpaidAccount =postpaidAccountDAOServices.findById(mobileNo).orElseThrow(()->
		new PostpaidAccountNotFoundException("No postpaid account found"));
		int planID=postpaidAccount.getPlan().getPlanID();
		Plan plan=planDAOServices.findById(planID).orElseThrow(()->
		new PlanDetailsNotFoundException("Plan Id requested is not available"));
		/*Bill bill=new Bill(noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls, internetDataUsageUnits, billMonth, postpaidAccount);
		if(noOfLocalSMS > plan.getFreeLocalSMS()) {
			bill.setLocalSMSAmount((noOfLocalSMS-plan.getFreeLocalSMS())*plan.getLocalSMSRate());
		} else bill.setLocalSMSAmount(0);
		if(noOfStdSMS > plan.getFreeStdSMS()) {
			bill.setStdSMSAmount((noOfStdSMS-plan.getFreeStdSMS())*plan.getStdSMSRate());
		} else bill.setStdSMSAmount(0);
		if(noOfLocalCalls > plan.getFreeLocalCalls()) {
			bill.setLocalCallAmount((noOfLocalCalls-plan.getFreeLocalCalls())*plan.getLocalCallRate());
		} else bill.setLocalCallAmount(0);
		return 0;*/
		float localSMSAmount = ((noOfLocalSMS - plan.getFreeLocalSMS())<=0) ? 0 : (noOfLocalSMS - plan.getFreeLocalSMS()) * plan.getLocalSMSRate(); 
		float localCallAmount = ((noOfLocalCalls - plan.getFreeLocalCalls())<=0) ? 0 :  (noOfLocalCalls - plan.getFreeLocalCalls()) * plan.getLocalCallRate();
		float stdSMSAmount = ((noOfStdSMS - plan.getFreeStdSMS())<=0) ? 0 : (noOfStdSMS - plan.getFreeStdSMS()) * plan.getStdSMSRate();
		float stdCallAmount = ((noOfStdCalls - plan.getFreeStdCalls())<=0) ? 0 : (noOfStdCalls - plan.getFreeStdCalls()) * plan.getStdCallRate();
		float internetDataUsageAmount = ((internetDataUsageUnits - plan.getFreeInternetDataUsageUnits())<=0) ? 0 : (internetDataUsageUnits - plan.getFreeInternetDataUsageUnits()) * (plan.getInternetDataUsageRate() / 10);
		float totalAmountWithoutTaxes = plan.getMonthlyRental() + localCallAmount + localSMSAmount + stdCallAmount + stdSMSAmount + internetDataUsageAmount;
		float cgst = 0.09f * totalAmountWithoutTaxes;
		float sgst = 0.09f * totalAmountWithoutTaxes;
		float servicesTax = cgst + sgst;
		float vat = 0.05f * totalAmountWithoutTaxes;
		float totalBillAmount = totalAmountWithoutTaxes + servicesTax + vat;
		/*System.out.println("Bill Amount: "+totalBillAmount);*/
		Bill bill = new Bill(noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls, internetDataUsageUnits, billMonth, totalBillAmount, localSMSAmount, stdSMSAmount, localCallAmount, stdCallAmount, internetDataUsageAmount, servicesTax, vat, postpaidAccount);
		bill = billingDAOServices.save(bill);
		return bill.getBillID();
	}

	@Override
	public Customer getCustomerDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		System.out.println("hello");
		return customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("Customer details not found"));
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws BillingServicesDownException {
		return customerDAOServices.findAll();
	}

	@Override
	public PostpaidAccount getPostPaidAccountDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException {
		Customer customer= customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		PostpaidAccount postpaidAccount =postpaidAccountDAOServices.findById(mobileNo).orElseThrow(()->
		new PostpaidAccountNotFoundException("No postpaid account found"));
		return postpaidAccount;
	}

	@Override
	public List<PostpaidAccount> getCustomerAllPostpaidAccountsDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		Customer customer=customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		return postpaidAccountDAOServices.getCustomerAllPostpaidAccountsDetails(customerID);
	}

	@Override
	public Bill getMobileBillDetails(int customerID, long mobileNo, String billMonth)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
			BillDetailsNotFoundException, BillingServicesDownException {
		Customer customer=customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		PostpaidAccount postpaidAccount =postpaidAccountDAOServices.findById(mobileNo).orElseThrow(()->
		new PostpaidAccountNotFoundException("No postpaid account found"));
		Bill bill=billingDAOServices.getBillForAAccountForAMonth(mobileNo, billMonth);
		if(bill==null) throw new BillDetailsNotFoundException("No bill found for this month");
		else return bill;
	}

	@Override
	public List<Bill> getCustomerPostPaidAccountAllBillDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			BillDetailsNotFoundException {
		Customer customer= customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		PostpaidAccount postpaidAccount =postpaidAccountDAOServices.findById(mobileNo).orElseThrow(()->
		new PostpaidAccountNotFoundException("No postpaid account found"));
		List<Bill> bills=billingDAOServices.getAllBillsForAAccount(mobileNo);
		if (bills==null) throw new BillDetailsNotFoundException("No bill found for this month");
		return bills;
	}

	@Override
	public boolean changePlan(int customerID, long mobileNo, int planID) throws CustomerDetailsNotFoundException,
			PostpaidAccountNotFoundException, PlanDetailsNotFoundException, BillingServicesDownException {
		Customer customer= customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		PostpaidAccount postpaidAccount =postpaidAccountDAOServices.findById(mobileNo).orElseThrow(()->
		new PostpaidAccountNotFoundException("No postpaid account found"));
		if(postpaidAccount.getPlan().getPlanID() == planID)
		throw new PlanDetailsNotFoundException("This plan is already registered with this account.");
		/*Plan plan=planDAOServices.findById(postpaidAccount.getPlan().getPlanID()).orElseThrow(()->
		new PlanDetailsNotFoundException("No plan is registered with this account"));
		*/
		Plan plan=planDAOServices.findById(planID).orElseThrow(()->
		new PlanDetailsNotFoundException("Plan Id requested is not available"));
		postpaidAccount.setPlan(plan);
		postpaidAccountDAOServices.save(postpaidAccount);
		return true;
	}

	@Override
	public boolean closeCustomerPostPaidAccount(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException {
		Customer customer= customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		PostpaidAccount postpaidAccount =postpaidAccountDAOServices.findById(mobileNo).orElseThrow(()->
		new PostpaidAccountNotFoundException("No postpaid account found"));
		postpaidAccountDAOServices.deleteById(mobileNo);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerID)
			throws BillingServicesDownException, CustomerDetailsNotFoundException {
		Customer customer= customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		customerDAOServices.deleteById(customerID);
		return true;
	}

	@Override
	public Plan getCustomerPostPaidAccountPlanDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			PlanDetailsNotFoundException {
		Customer customer= customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		PostpaidAccount postpaidAccount =postpaidAccountDAOServices.findById(mobileNo).orElseThrow(()->
		new PostpaidAccountNotFoundException("No postpaid account found"));
		return postpaidAccount.getPlan();
	}

	@Override
	public long openPostpaidMobileAccount(int customerID, int planID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException {
		Customer customer=customerDAOServices.findById(customerID).orElseThrow(()->
		new CustomerDetailsNotFoundException("No customer details found"));
		Plan plan=planDAOServices.findById(planID).orElseThrow(()->
		new PlanDetailsNotFoundException("No plan details found with this Plan Id"));
		PostpaidAccount postpaidAccount= new PostpaidAccount(plan, null, customer);
		postpaidAccount=postpaidAccountDAOServices.save(postpaidAccount);
		return postpaidAccount.getMobileNo();
	}

}
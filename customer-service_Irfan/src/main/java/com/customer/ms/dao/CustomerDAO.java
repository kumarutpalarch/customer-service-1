package com.customer.ms.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap; 
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.customer.ms.model.Customer;
@Repository
public class CustomerDAO {

	private static final Map<String, Customer> cusMap = new HashMap<String, Customer>();

	static {

		initCus();
	}

	private static void initCus() {

		Customer cus1 = new Customer ("C01", "Smith", "NY");
		Customer cus2 = new Customer ("C02", "John", "CT");
		Customer cus3 = new Customer ("C03", "Ethan", "CA");

		cusMap.put(cus1.getCusId(),  cus1);
		cusMap.put(cus1.getCusId(),  cus2);
		cusMap.put(cus1.getCusId(),  cus3);

	}

	public Customer getCustomer (String cusId) {
		return cusMap.get(cusId);
	}
	public Customer addCustomer(Customer cus ) {
		cusMap.put(cus.getCusId(),  cus);
		return cus;
	}
	
	public Customer updateCustomer (Customer cus ) {
		cusMap.replace(cus.getCusId(), cus);
		return cus; 
	}
	
	public Customer deleteCustomer (Customer cus ) {
		cusMap.replace(cus.getCusId(), cus);
		return cus; 
	}

	public List<Customer> getAllCustomer(){

		Collection<Customer> c = cusMap.values();
		List<Customer> list = new ArrayList<Customer>();
		list.addAll(c);
		return list;
	}

}

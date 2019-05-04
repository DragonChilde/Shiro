package com.maven.ssm.service;

import com.maven.ssm.pojo.Customer;
import com.maven.ssm.pojo.QueryVo;
import com.maven.ssm.utils.Page;

public interface CustomerSerivce {
	public Page<Customer> getCustomerListByQueryVo(QueryVo vo);
	
	public int getCountCustomerByQueryVo(QueryVo vo);
	
	public Customer getCustomerListByCustId(int custId);
	
	public void updateCustomerByCustId(Customer customer);
	
	public void deleteCustomerByCustId(int id);
}

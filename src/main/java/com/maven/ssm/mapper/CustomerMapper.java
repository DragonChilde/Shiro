package com.maven.ssm.mapper;

import java.util.List;

import com.maven.ssm.pojo.Customer;
import com.maven.ssm.pojo.QueryVo;


public interface CustomerMapper {
	
	public List<Customer> getCustomerListByQueryVo(QueryVo vo);
	
	public int getCountCustomerByQueryVo(QueryVo vo);
	
	public Customer getCustomerListByCustId(int custId);
	
	public void updateCustomerByCustId(Customer customer);
	
	public void deleteCustomerByCustId(int id);
}

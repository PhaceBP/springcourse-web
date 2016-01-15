package hu.ericsson.springcourse.service;

import hu.ericsson.springcourse.model.Customer;

public interface CustomerService
{
  
   Long createCustomer(Customer customer);
   
   void scheduledTaskRunner() throws InterruptedException;
   
   Customer getCustomer(Long id);

}

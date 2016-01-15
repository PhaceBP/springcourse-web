package hu.ericsson.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.ericsson.springcourse.dao.CustomerDao;
import hu.ericsson.springcourse.listeners.CustomerCreationEvent;
import hu.ericsson.springcourse.model.Customer;

@Service
public class DefaultCustomerService implements CustomerService
{

  @Autowired
  private CustomerDao dao;

  @Autowired
  private ApplicationEventPublisher publisher;

  @Transactional
  public Long createCustomer(Customer customer)
  {
    dao.create(customer);
    CustomerCreationEvent evt = new CustomerCreationEvent(this);
    evt.setMessage("Customer creadted: "+customer.toString());
    publisher.publishEvent(evt);
    return 1L;
  }

  @Scheduled(fixedRate = 2000)
  public void scheduledTaskRunner() throws InterruptedException
  {
    System.out.println("Scheduled task run!!!");

  }

  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public Customer getCustomer(Long id)
  {
    return dao.get(id);
  }

}

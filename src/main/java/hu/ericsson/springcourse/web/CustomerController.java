package hu.ericsson.springcourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.ericsson.springcourse.model.Customer;
import hu.ericsson.springcourse.service.CustomerService;

@RequestMapping(value = "/customers")
@RestController
public class CustomerController
{

  @Autowired
  private CustomerService customerService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId)
  {
    Customer cust = customerService.getCustomer(customerId);
    if (cust == null)
    {
      return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Customer>(cust, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Long> addEmployee(@RequestBody Customer c)
  {
    Long id = customerService.createCustomer(c);
    return new ResponseEntity<Long>(id, HttpStatus.OK);
  }
}

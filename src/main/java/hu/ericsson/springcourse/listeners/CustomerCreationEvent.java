package hu.ericsson.springcourse.listeners;

import org.springframework.context.ApplicationEvent;

public class CustomerCreationEvent extends ApplicationEvent
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String message;
  
  public CustomerCreationEvent(Object source){
    super(source); 
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }
  
  
  
}

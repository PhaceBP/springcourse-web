package hu.ericsson.springcourse.listeners;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TransactionEventListener
{

  
  @TransactionalEventListener(condition = "#event.message eq 'handle'",fallbackExecution = false, phase = TransactionPhase.AFTER_COMMIT) 
  public void handleTransactionEvents(CustomerCreationEvent event){
    
    System.out.println(event.getMessage());
  }
  
  
}

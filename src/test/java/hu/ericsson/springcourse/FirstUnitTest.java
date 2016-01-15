package hu.ericsson.springcourse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@ActiveProfiles("dev")
@ContextHierarchy({ @ContextConfiguration(locations = { "classpath:/spring-config/application-context.xml" }), @ContextConfiguration(locations = { "classpath:/spring-config/mvc-config.xml" }) })
public class FirstUnitTest
{

  @Autowired
  protected WebApplicationContext ctx;

  private MockMvc mockMvc;

  @Before
  public void setUp()
  {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
  }

  @Sql(scripts = "classpath:db/insert_customer.sql", config = @SqlConfig(transactionMode = TransactionMode.ISOLATED) , executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
  @Test
  public void testCustomerControllerGET() throws Exception
  {
    mockMvc.perform(get("/customers/1").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

    System.out.println(content());
  }

}

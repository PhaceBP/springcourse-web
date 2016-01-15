package hu.ericsson.springcourse;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockPropertySource;

public class MockInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>
{

  public void initialize(ConfigurableApplicationContext applicationContext)
  {
    MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
    MockPropertySource mockEnvVars = new MockPropertySource().withProperty("a", "value");
    propertySources.replace(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, mockEnvVars);
  }
}
package co.com.templay.api.pom.stepDefinitions.hook;

import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.util.EnvironmentVariables;

@Slf4j
public class hook {


   private EnvironmentVariables environmentVariables;
    @Before
    public void configureBaseUrl()  {
        log.info("Realizando peticion ...");
    }
}

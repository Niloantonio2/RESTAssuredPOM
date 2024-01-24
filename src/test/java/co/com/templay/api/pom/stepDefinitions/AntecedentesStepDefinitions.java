package co.com.templay.api.pom.stepDefinitions;

import io.cucumber.java.es.Dado;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;

@Slf4j
public class AntecedentesStepDefinitions {

    @Dado("que tengo un servicio RESTful")
    public void queTengoUnServicioRESTful(io.cucumber.datatable.DataTable dataTable) {
        Serenity.setSessionVariable("ENDPOINT").to(dataTable.row(1).get(0));
        log.info("ENDPOINT DE API: {}",dataTable.row(1).get(0));
    }

}

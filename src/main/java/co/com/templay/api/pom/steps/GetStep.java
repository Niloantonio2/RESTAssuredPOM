package co.com.templay.api.pom.steps;


import co.com.templay.api.pom.utils.JsonManager;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static junit.framework.Assert.assertEquals;

@Slf4j
public class GetStep {

    String filePath = "src/test/resources/data/bodyCreateUsuario.JSON";
    JsonManager jsonManager = new JsonManager(filePath);
    @Step
    public void consultarUsuario(String endpoint, String usuario){

        SerenityRest.given().baseUri(endpoint +"/user/"+usuario).contentType(ContentType.JSON).get();
        log.info("Response: {}",SerenityRest.lastResponse().asString());


    }

    @Step
    public void validarResponseCode (int responseCode){

        assertEquals(responseCode, SerenityRest.lastResponse().statusCode());
        log.info("Response code esperado: {}",responseCode, "Response code obtenido: {}",SerenityRest.lastResponse().statusCode());

    }

    @Step
    public void validarCapos (String nombreUsuario){

      //  Assert.assertNotNull("El valor no debería ser nulo", SerenityRest.lastResponse().asString());
      //  Assert.assertTrue("El valor debería contener '" + nombreUsuario + "'", SerenityRest.lastResponse().asString().contains(nombreUsuario));



    }

}

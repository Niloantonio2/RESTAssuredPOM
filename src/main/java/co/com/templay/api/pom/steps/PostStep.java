package co.com.templay.api.pom.steps;

import co.com.templay.api.pom.utils.JsonManager;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


import static junit.framework.Assert.assertEquals;


@Slf4j
public class PostStep {
    String filePath = "src/test/resources/data/bodyCreateUsuario.JSON";
    JsonManager jsonManager = new JsonManager(filePath);



    @Step
    public void crearUsuario (String endpoint, int id,  String username, String firstName, String lastName, String email, String password, String phone, int userStatus){

        jsonManager.modificarValores(id, username, firstName, lastName, email, password, phone, userStatus);
        log.info("Body generado: {}",jsonManager.obtenerBody());

        SerenityRest.given().baseUri(endpoint +"/user").contentType(ContentType.JSON).body(jsonManager.obtenerBody()).post();
        log.info("Response code: {}",SerenityRest.lastResponse().statusCode());

    }

    @Step
    public void validarResponseCode (int responseCode){

        assertEquals(responseCode, SerenityRest.lastResponse().statusCode());
        log.info("Response code esperado: {}",responseCode, "Response code obtenido: {}",SerenityRest.lastResponse().statusCode());


    }


}

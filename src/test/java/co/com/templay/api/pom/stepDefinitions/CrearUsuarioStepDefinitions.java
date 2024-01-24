package co.com.templay.api.pom.stepDefinitions;

import co.com.templay.api.pom.steps.PostStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;


@Slf4j
public class CrearUsuarioStepDefinitions {

    @Steps
    PostStep postStep;



    @Cuando("hago una solicitud POST para crear un nuevo recurso")
    public void hagoUnaSolicitudPOSTParaCrearUnNuevoRecurso(io.cucumber.datatable.DataTable dataTable) {
         ;
        postStep.crearUsuario(Serenity.sessionVariableCalled("ENDPOINT"),Integer.parseInt(dataTable.row(0).get(0)),
                (dataTable.row(0).get(1)),(dataTable.row(0).get(2)),(dataTable.row(0).get(3)),(dataTable.row(0).get(4)),
                (dataTable.row(0).get(5)),(dataTable.row(0).get(6)),Integer.parseInt((dataTable.row(0).get(7))));


    }
    @Entonces("la respuesta de la peticion POST debe tener un codigo de estado {int}")
    public void laRespuestaDeLaPeticionPOSTDebeTenerUnCodigoDeEstado(Integer int1) {
        postStep.validarResponseCode(int1);
    }

}

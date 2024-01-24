package co.com.templay.api.pom.stepDefinitions;

import co.com.templay.api.pom.steps.GetStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ConsultarUsuarioStepDefinitions {

    @Steps
    GetStep getStep;


    @Cuando("hago una solicitud GET para consultar usuario")
    public void hagoUnaSolicitudGETParaConsultarUsuario(io.cucumber.datatable.DataTable dataTable) {
        getStep.consultarUsuario(Serenity.sessionVariableCalled("ENDPOINT"),dataTable.row(0).get(0));

    }
    @Entonces("la respuesta de la peticion GET debe tener un codigo de estado {int}")
    public void laRespuestaDeLaPeticionGETDebeTenerUnCodigoDeEstado(Integer int1) {
        getStep.validarResponseCode(int1);

    }

    @Entonces("podre ver informacion del usuario")
    public void podreVerInformacionDelUsuario(io.cucumber.datatable.DataTable dataTable) {
    getStep.validarCapos(dataTable.cell(0,0));
    }
}

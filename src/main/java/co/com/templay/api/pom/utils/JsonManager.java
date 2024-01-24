package co.com.templay.api.pom.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class JsonManager {

    private final String filePath;
    private ObjectNode jsonNode;

    public JsonManager(String filePath) {
        this.filePath = filePath;
        cargarJson();
        log.info("buscando archivo JSON ubicado en {}", filePath);

    }

    private void cargarJson() {
        try {
            // Leer el archivo JSON
            ObjectMapper objectMapper = new ObjectMapper();
            this.jsonNode = (ObjectNode) objectMapper.readTree(new File(filePath));
            log.info("leer archivo JSON ubicado en {}", filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modificarValores(int id, String username, String firstName, String lastName,
                                 String email, String password, String phone, int userStatus) {

        if (jsonNode != null) {
            jsonNode.put("id", id);
            jsonNode.put("username", username);
            jsonNode.put("firstName", firstName);
            jsonNode.put("lastName", lastName);
            jsonNode.put("email", email);
            jsonNode.put("password", password);
            jsonNode.put("phone", phone);
            jsonNode.put("userStatus", userStatus);
            log.info("Escribiendo datos... {}",jsonNode);
        }
    }

    public String obtenerBody() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}

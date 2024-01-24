# author: Nilo Chaverra
# date: 15/01/2024
# language: es

@HU
Característica: Api CRUD
  Descripcion: Yo como analaista QA necesito probar una api,
  mediante peticiones al servicio quiero crear, consultar,
  actualizar y eliminar un usuario de manera exitosa.


  Antecedentes:
    Dado que tengo un servicio RESTful
   | endpoint                       |
   | https://petstore.swagger.io/v2 |



    Esquema del escenario: Creacion usuario <Escenario>
      Cuando  hago una solicitud POST para crear un nuevo recurso
       | <strId>| <strUsername> | <strFirstName> | <strLastName> | <strEmail> | <strPassword> | <strPhone> | <strUserStatus>|
      Entonces la respuesta de la peticion POST debe tener un codigo de estado <Statscode>

      Ejemplos:
        |Escenario  | strId  | strUsername | strFirstName | strLastName | strEmail         | strPassword | strPhone | strUserStatus | Statscode |
        |Exitoso    | 123    | NiloAcha    | Nilo         | Chaverra    | noTengo@test.com | 01234567890 | 12345678 | 0             | 200       |
       # |Duplicado  |     | NiloAcha    | Nilo         | Chaverra    | noTengo@test.com | 01234567890 | 12345678 | 0             | 200       |
        |Fallido    |0123| NiloAcha    | Nilo         | Chaverra    | noTengo@test.com | 01234567890 | 12345600007890 | 5           | 500       |



    Esquema del escenario: Consultar usuario <Escenario>
      Cuando  hago una solicitud GET para consultar usuario
       |  <strUsername> |
      Entonces la respuesta de la peticion GET debe tener un codigo de estado <Statscode>
      Y podre ver informacion del usuario
        |  <strUsername> |

      Ejemplos:
      |Escenario     | strUsername | Statscode |
      |Existente     | NiloAcha    | 200       |
      |No Existente  | Noloocha    | 404       |


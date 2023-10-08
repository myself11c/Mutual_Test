PRUEBA TÉCNICA ANALSTA TI 2 DESARROLLO
1. SerequiereeldesarrollodeunaaplicaciónenJavaquepermitagenerar un token JWT, empleando la librería Sprint security . El API debe recibir un usuario (admin) y contraseña (admin123*); este debe integrarse a una base de datos H2 embebida. La contraseña en base de datos debe estar codificada y en la aplicación debe estar decodificada.
2. De igual forma se espera que se construya un API de gestión de información de un empleado a la cual se pueda acceder a através del
   token
   generado previamente. El API debe permitir:
   a. Guardarempleado
   b. Consultarempleado
   c. Editarempleado
   d. Eliminarempleado
   e. Consultarlosempleadosregistrados.(Máximo30)
   f. Consultar empleados con edad mayor o igual a 40 años.
   g. ConsultarempleadosconsexoFemenino.
3. Elempleadodebecontenerlassiguientespropiedadesobligatorias: a. Nombres
   b. Apellidos
   c. Sexo
   d. Edad
   e. Correoelectrónico

MOD-SIG-01 Versión 02 Aprobado 2019-09-27| Aprueba: Junta Directiva
4. Losmensajesdeerrordebencontenercódigoymensaje. a. Ejemplo:
   {
   “code”:”100”,
   “message”:”Error XXXX”
   }
5. Elresultadodebesermontadoaunrepositorioonline(GIT,Bitbucket).
   Fecha y hora máxima de entrega para la prueba: 72 horas 

Endpoints
1 http://localhost:8090/token POST
Recibe usuario y contraseña, y devuelve token



2 http://localhost:8090/api/v1/empleados GET 
Recibe token devuelve listado de empleados

3 http://localhost:8090/api/v1/empleado/idEmpleado DELETE
Recibe token e idEmpleado, elimina empleado

4 http://localhost:8090/api/v1/empleado/idEmpleado GET
Recibe token e idEmpleado devuelve info de empleado

5 http://localhost:8090/api/v1/empleados/sexo/SEXO GET 
Recibe token y sexo y  devuelve listado de empleado

6 http://localhost:8090/api/v1/empleado/IdEmpleado PUT 
Recibe Token + JSON
{
"idEmpleado": 5,
"nombres": "CAROLINA ",
"apellidos": " DIAZ",
"sexo": "FEMENINO",
"correo": "CARO@GMAIL.COM",
"edad": 47
}
Actualiza informacion del empleado

7 http://localhost:8090/api/v1/empleado POST
Recibe Token + JSON
{
"nombres": "CAROLINA ",
"apellidos": " DIAZ",
"sexo": "FEMENINO",
"correo": "CARO@GMAIL.COM",
"edad": 47
}
Crea Empleado
http://localhost:8090/api/v1/empleados/edad/EDADMAYOR GET
Recibe Token y edad mayor a filtrar



# CVDS_LAB8

[![CircleCI](https://circleci.com/gh/angiedanielar/CVDS_LAB8.svg?style=svg)](https://circleci.com/gh/angiedanielar/CVDS_LAB8) 


[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9106912acf4e42f38eef7f27eb0c8522)](https://www.codacy.com/manual/angiedanielar/CVDS_LAB8?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=angiedanielar/CVDS_LAB8&amp;utm_campaign=Badge_Grade)


Página de REGISTRO para nuevos Clientes: https://daniandernest.herokuapp.com/faces/registrocliente.xhtml


Página de registro para ALQUILER: https://daniandernest.herokuapp.com/faces/registroalquiler.xhtml


Clases de equivalencia: ServiciosAlquilerImpl 


1. En consultarCliente(long docu)
El cliente no existe. NO SATISFACTORIO. EXCEPCION
El cliente existe. SATISFACTORIO
Se probará con un cliente existente y con uno no existente, esperando los resultados descritos anteriormente. 
No hay posibles combinaciones. No hay limites de equivalencia.

2. En valorMultaRetrasoxDia(int itemId)
El item no existe o no está porque está actualmente alquilado. NO SATISFACTORIO. EXCEPCION
El item existe porque no está actualmente alquilado. SATISFACTORIO.
El item existente con descuento por antelacion. SATISFACTORIO.
El item existente con descuento por mayoria de edad. SATISFACTORIO.
El item existente con descuento por menoria de edad. SATISFACTORIO.
El item no existente con descuento por mayoria de edad. NO SATISFACTORIO.
El item no existente con descuento por menoria de edad. NO SATISFACTORIO.
Se probará con un item existente y con uno que se encuentre alquilado (no existe), esperando los resultados descritos anteriormente. 
Las posibles combinaciones son:
El item existente con descuento por antelacion y mayoria de edad. SATISFACTORIO.
El item existente con descuento por antelacion y menoria de edad. SATISFACTORIO.
Se prueban las combianciones: (1,0,0), (1, -1, -1), (1, -1, 1), (1, 1, -1). NO SATISFACTORIO
(1,1,1) SATISFACTORIO.
Limites de equivalencia:  Para la antelacion correcta debe ser 1 día para que sea correcto, entonces se prueba (0,0,0), (-1,0,0). 
NO SATISFACTORIO y (1,21,18) SATISFACTORIO.

3. En consultarItemsCliente(long idcliente)
Cliente existente sin items. SATISFACTORIO.
Cliente existente con items. SATISFACTORIO.
Cliente no existente sin items. NO SATISFACTORIO.
Cliente no existente con items. NO SATISFACTORIO.
Se prueba con un cliente existente y con uno no existente. No hay posibles combinaciones. No hay limites de equivalenica.

4. En consultarClientes()
Si no hay clientes, tiene que ser 0 porque se prueba antes de insertar un cliente. SATISFACTORIO. 
Si hay mas de un cliente, tiene que ser 1 porque se prueba después de insertar el primer cliente. SATISFACTORIO.
No hay posibles combinaciones. No hay limites de equivalencia.

5. En consultarItem(int id)
El item no existe. NO SATISFACTORIO. EXCEPCION. 
El item existe. SATISFACTORIO. 
Se prueba con un item no alquilado y con uno alquilado. 
No hay posibles combinaciones. No hay limites de equivalencia.

6. En consultarItemsDisponibles()
Que no haya items disponiles, tiene que ser el numero 0. SATISFACTORIO. 
Que haya más o 1, tiene que ser mayor o igual que el numero 1. SATISFACTORIO. 
No hay posibles combinaciones. No hay limites de equivalencia.

7. En consultarMultaAlquiler(int iditem, Date fechaDevolucion)  
Probar con item existemte y no existente. (1,fecha valida), (-1,fecha valida). SATISFACTORIO Y NO SATISFACTORIO. 
Posibles combinaciones.
Probar con item existemte y no existente. Para fecha invalida  (1,fecha invalida), (-1,fecha invalida). NO SATISFACTORIO Y NO SATISFACTORIO. 
No hay limites de equivalencia.

8. En consultarTipoItem(int id)
Probar con un tipo existente. SATISFACTORIO.
Probar con un tipo no existente. NO SATISFACTORIO.
No hay posibles combinaciones. No hay limites de equivalencia.

9. En consultarTiposItem()
Que no haya tipos de items, tiene que ser el numero 0. SATISFACTORIO. 
Que haya más de o 1 tipo, tiene que ser mayor o igual que el numero 1. SATISFACTORIO. 
No hay posibles combinaciones. No hay limites de equivalencia.

10. En registrarAlquilerCliente(Date date, long docu, Item item, int numdias)
Fecha no valida. NO SATISFACTORIO. 
Fecha valida. SATISFACTORIO. 
Documento no valido. NO SATISFACTORIO. 
Documento valido. SATISFACTORIO. 
Item no valido. NO SATISFACTORIO. 
Item valido. SATISFACTORIO. 
Dias no validos. NO SATISFACTORIO. 
Dias validos. SATISFACTORIO. 
Posibles combinaciones y limites de equivalencia: 
Ya se han probado en las demás las posibles combinaciones, en este caso son varias, porque se prueban todas las posibles combinaciones.

11. registrarCliente(Cliente p)
No deberia registrar clientes con el nombre nulo. NO SATISFACTORIO. 
Cliente no puede ser el numero 0, ni numeros negativos. Se prueba, -1, 0 y 1. Correcto solamente el numero 1. 
No hay posibles combinaciones. No hay limites de equivalencia.

12. En consultarCostoAlquiler(int iditem, int numdias)
Consultar un item existente. SATISFACTORIO. 
Consultar un item no existente. NO SATISFACTORIO. 
Probar días -1,0 y 1. Solo satisfactorio el numero 1. 
Posibles combinaciones y limites de equivalencia: 
Consultar un item existente con numero de dias mayor o igual que 1. SATISFACTORIO. 
Consultar un item existente con numero de dias igual o menor que 0. NO SATISFACTORIO. 
Consultar un item no existente con numero de dias mayor o igual que 1. NO SATISFACTORIO. 
Consultar un item no existente con numero de dias igual o menor que 0. NO SATISFACTORIO. 

13. En actualizarTarifaItem(int id, long tarifa)
Nueva tarifa 0 o negativa. NO SATISFACTORIO. Se prueba con -1, 0 y 1. Solo pasa la del numero 1. 
Se prueba actaulizar con un item existente y con uno no existente. SATISFACTORIO y NO SATISFACTORIO. 
No hay posibles combinaciones. No hay limites de equivalencia.

14. En registrarItem(Item i)
Item no puede ser el numero 0, ni numeros negativos. Se prueba, -1, 0 y 1. Correcto solamente el numero 1.
No hay posibles combinaciones. No hay limites de equivalencia.

15. vetarCliente(long docu, boolean estado)
Vetar a un cliente ya vetado. NO SATISFACTORIO. 
Vetar a un cliente no vetado. SATISFACTORIO. 
Vetar a un cliente no existente. NO SATISFACTORIO. 
No hay posibles combinaciones. No hay limites de equivalencia.



(En algunas pruebas en la implementacion, se puso un valor cualquiera dado que no teniamos acceso a la base de datos para ver si algun valor no estaba)

¡Buenas!
En este documento describo el proyecto incluido en el. Se podran encontrar dos carpetas.

Carpeta tests:
  Incluye dos ficheros:
    INDITEX TEST COLLECTION.postman_collection.json -> Fichero con una coleccion de pruebas definidas para postman.
    INDITEX TEST COLLECTION.postman_test_run.json -> Resultado de la ejecucion de la colección de pruebas para postman.

Carpeta inditex:
  En esta carpeta se incluye el proyecto java springboot. Este proyecto esta construido utilizando maven, java 21, swagger, h2 y lombok. Ademas de utilzar jib para la dockerizacion. Ademas se pondran encontrar una serie de pruebas unitarias dentro de la carpeta src/test/java cumpliendo con lo solicitado.

  Para la construccion de este servicio se pueden utilizar dos comandos:
    - Construccion del jar springboot ejecutando pruebas y actualizando artefactos locales: clean install -U
    - Construccion del componente dockerizado en un docker local: compile jib:build

  Una vez se levante el servicio ya sea mediante docker, el jar o desde el entorno utilizado. Swagger se encontrará disponible por defecto en: [http://localhost:8080/swagger-ui/index.html#/prices-controller/productPriceByIdAndBrandAndDate](http://localhost:8080/swagger-ui/index.html#/prices-controller/productPriceByIdAndBrandAndDate)

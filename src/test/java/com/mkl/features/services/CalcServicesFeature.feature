Feature: Calculadora
Dado como entrada dos numeros y un operador
Quiero obtener el resultado de la operación


Scenario Outline: Suma
Given el siguiente "http://localhost:8080/restMKL/services/mkl" endpoint
And los operadores <nro1> y <nro2>
When la operacion seleccionada es <operacion>
Then se espera el <estado> y el resultado <resultado>
Examples:

|nro1|nro2|operacion|estado|resultado|
|1|1|"Suma"|0|2|

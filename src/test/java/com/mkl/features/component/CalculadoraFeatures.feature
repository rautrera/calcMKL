Feature: Calculadora
Dado como entrada dos numeros y un operador
Quiero obtener el resultado de la operación


Scenario Outline: Suma
Given los numeros <input1> y <input2>
When la operacion seleccionada es "Suma"
Then el resultado debe ser <resultado>
Examples:
|input1|input2|resultado|
|1|1|2|
|1|1000|1001|
|45|45|91|


Scenario Outline: Resta
Given los numeros <input1> y <input2>
When la operacion seleccionada es "Resta"
Then el resultado debe ser <resultado>
Examples:
|input1|input2|resultado|
|10|1|9|
|1|1000|-999|
|45|45|1|

Scenario Outline: Multiplicacion
Given los numeros <input1> y <input2>
When la operacion seleccionada es "Multiplicacion"
Then el resultado debe ser <resultado>
Examples:
|input1|input2|resultado|
|10|1|10|
|1|1000|1000|
|45|45|1|


Scenario Outline: Division
Given los numeros <input1> y <input2>
When la operacion seleccionada es "Division"
Then el resultado debe ser <resultado>
Examples:
|input1|input2|resultado|
|10|1|10|
|1|1000|0|
|45|45|1|
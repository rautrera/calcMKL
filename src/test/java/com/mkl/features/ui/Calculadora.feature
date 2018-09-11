Feature: Calculadora
Como un usuario de MakingLab
Deseo tener una calculadora
Para poder realizar calculos

Background:
Given entro a la url "http://localhost:8080/calculator/index.jsp"

Scenario Outline: Resultados
And ingreso <nro1> y <nro2> en los operandos
And selecciono el siguiente <operador>
When presiono Calcular
Then el resultado sera <resultado>
Examples:
|nro1|nro2|operador|resultado|
|"1"|"2"|"Suma"|"3"|


Scenario Outline: OperadoresIncompletos
And ingreso <nro1> y <nro2> en los operandos
When presiono Calcular
Then el mensaje de error sera <msjError>.
And se marcara el <input> con error en rojo
Examples:
|nro1|nro2|msjError|input|
|"1"|""|"Errores:\nIngrese el segundo operando"|"nro2"|
|""|"2"|"Errores:\nIngrese el primer operando"|"nro1"|
|""|""|"Errores:\nIngrese el primer operando\nIngrese el segundo operando"|"nro1;nro2"|
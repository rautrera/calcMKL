<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6 border border-info">
				<div class="shadow-none p-3 mb-5 bg-light rounded text-center">Calculadora
					MKL</div>
				<!--  -->
					<div class="form-group">
						<label for="nro1">Primer número</label> <input type="number"
							class="form-control" id="nro1" placeholder="Ej: 5">
					</div>
					<div class="form-group">
						<label for="nro2">Segundo número</label> <input type="number"
							class="form-control" id="nro2" placeholder="Ej: 1">
					</div>
					<div class="form-group">
						<label for="operacion">Operación</label> <select
							class="form-control" id="operacion">
							<option value="Suma">Suma</option>
							<option value="Resta">Resta</option>
							<option value="Multiplicacion">Multiplicación</option>
							<option value="Division">División</option>
						</select>
					</div>
					<button id="calcButton"
						class="btn btn-primary btn-block">Calcular</button>
				<div class="form-group">
					<label for="resultado">Resultado</label> <input 
						class="form-control" id="resultado" placeholder="Resultado"
						readonly>
				</div>
				<div class="alert alert-danger" id="msjError" role="alert"
					style="display: none;">A simple danger alert-check it out!</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

	var calcularButton = $('#calcButton');
	calcularButton.click(function() {
				var nro1 = document.getElementById("nro1").value;
				var nro2 = document.getElementById("nro2").value;
				var operacion = document.getElementById("operacion").value;
				var validate = true;
				var msjError = "Errores:<br>"
				document.getElementById("msjError").style = "display:none;"

				document.getElementById("nro1").className = "form-control";
				document.getElementById("nro2").className = "form-control";
				if (document.getElementById("nro1").value == "") {
					validate = false;
					msjError = msjError + "Ingrese el primer operando<br>"
					document.getElementById("nro1").className = "form-control border-danger";
				}
				if (document.getElementById("nro2").value == "") {
					validate = false;
					msjError = msjError + "Ingrese el segundo operando<br>"
					document.getElementById("nro2").className = "form-control border-danger";
				}

				if (!validate) {
					document.getElementById("msjError").style = "display:block;"
					document.getElementById("msjError").innerHTML = msjError;
					/* return validate; */
				} else {
					var jsonRequest = { "nro1": nro1,"nro2": nro2,"operacion": operacion};
					
					$.ajax({
				        url: "/calcMKL/services/mkl/calcular/",
				        type: "POST",
				        data: JSON.stringify(jsonRequest),
				        	contentType: 'application/json',
				        	 dataType: 'json',
				         success: function(result,status,jqXHR ){
				              if(result.resp.codRta == 0)
				            	  {
				            	  	document.getElementById("resultado").value = result.resultado;
				            	  }else
				            		  {
				            		  	document.getElementById("resultado").value = "Error";
				            		  	document.getElementById("msjError").innerHTML = result.resp.descRta;
				            		  	document.getElementById("msjError").style = "display:block;"
				            		  }
				         },
				         error(jqXHR, textStatus, errorThrown){
				             alert(textStatus);
				         }
				    });

				}
			}); 
			
</script>

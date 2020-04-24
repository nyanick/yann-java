<?php 

$method = $_SERVER['REQUEST_METHOD'];

// Process only when method is POST
if($method == 'POST'){
	$requestBody = file_get_contents('php://input');
	$json = json_decode($requestBody);

	$text = $json->queryResult->parameters->number;

	if($text[0]>=6 || $text[0] == null || $text[0] == ""){
		$speech = "please select a valid number. 1-5" ;
	}
	
	else if($text[0] == 1){
		
		$speech = "IWOMI Technologies Ltd, est un acteur majeur dans la lutte pour l’inclusion financier à travers la transformation digital du secteur bancaire et finance en Afrique. ";
	}
	
	else if($text[0] == 2){
		$speech = 'A - Softeller '."\r\n" .'B - MOSA '."\r\n" .'B - IWOMI CORE '."\r\n" ;
	}
	
	else if($text[0] == 3){
		$speech = 'CEO - FOMBA COLLINS '."\r\n" .'R&D - RAOUL BILLIE '."\r\n" .'CIO - FUH DAISY '."\r\n" ;
	}
	
	else if($text[0] == 4){
		$speech = "You selected ".$text[0];
	}
	
	else{
		$speech = "You selected ".$text[0];
	}
	$response = new \stdClass();
	$response->text = $speech;
	$response->fulfillmentText = $speech;
	$response->source = "webhook";
	echo json_encode($response);
}
else
{
	echo "Method not allowed";
}

?>

<?php 

$method = $_SERVER['REQUEST_METHOD'];

// Process only when method is POST
if($method == 'POST'){
	$requestBody = file_get_contents('php://input');
	$json = json_decode($requestBody);

	$text = $json->queryResult->parameters->number;
	$response = new \stdClass();

	if($text[0]>=6 || $text[0] == null || $text[0] == ""){
		$speech = "please select a valid number. 1-5" ;
	}
	
	else if($text[0] == 1){
		
		$speech = "IWOMI Technologies Ltd, est un acteur majeur dans la lutte pour l’inclusion financier à travers la transformation digital du secteur bancaire et finance en Afrique. ";
		$response->text = $speech;
		$response->fulfillmentText = $speech;
		$response->source = "webhook";
		echo json_encode($response);
	}
	
	else if($text[0] == 2){
		$speech = 'A - Softeller '."\r\n" .'B - MOSA '."\r\n" .'B - IWOMI CORE '."\r\n" ;
		$response->outputContexts[0]->name = "projects/yanick-xckqyx/agent/sessions/2174c088-f4b4-b9fe-a16f-04a42845ace8/contexts/selectproduct";
		$response->outputContexts[1]->name = "projects/yanick-xckqyx/agent/sessions/2174c088-f4b4-b9fe-a16f-04a42845ace8/contexts/enterproductname";
		
		$response->text = $speech;
		$response->fulfillmentText = $speech;
		$response->source = "webhook";
		echo json_encode($response);
	}
	
	else if($text[0] == 3){
		$speech = 'CEO - FOMBA COLLINS '."\r\n" .'R&D - RAOUL BILLIE '."\r\n" .'CIO - FUH DAISY '."\r\n" ;
		$response->text = $speech;
		$response->fulfillmentText = $speech;
		$response->source = "webhook";
		echo json_encode($response);
	}
	
	else if($text[0] == 4){
		$speech = "You selected ".$text[0];
		$response->text = $speech;
		$response->fulfillmentText = $speech;
		$response->source = "webhook";
		echo json_encode($response);
	}
	
	else{
		$speech = "You selected ".$text[0];
		$response->text = $speech;
		$response->fulfillmentText = $speech;
		$response->source = "webhook";
		echo json_encode($response);
	}
	
	
}
else
{
	echo "Method not allowed";
}

?>

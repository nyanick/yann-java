<?php 

$method = $_SERVER['REQUEST_METHOD'];

// Process only when method is POST
if($method == 'POST'){
	$requestBody = file_get_contents('php://input');
	$json = json_decode($requestBody);

	$text = $json->queryResult->parameters->number;

	if($text[0]>=6 || $text[0] == null || $text[0] == ""){
		$speech = "please select a valid number." .$text[0];
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

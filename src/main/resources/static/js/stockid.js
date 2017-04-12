var price = "";
var fees = "";
var type =""; //0 for buy, 1 for sell
var total="";
var quantity="";
var stockid="";

function setBuy(){
	document.getElementById("quantityForm").style.visibility="visible";
	var id = document.getElementById("buyButton");
	price = Number(id.getAttribute('data-price'));
	
	fees =  (0.005*price);
	document.getElementById("fees").innerHTML = ((0.005*price).toFixed(2)+"EUR");
	
	document.getElementById("test").innerHTML = ((price+fees).toFixed(2));
	type=0;
}

function setSell(){
	document.getElementById("quantityForm").style.visibility="visible";
	var id = document.getElementById("sellButton");
	price = Number(id.getAttribute('data-price'));
	
	fees =  (0.005*price+3);
	document.getElementById("fees").innerHTML = ((0.005*price+3).toFixed(2)+"EUR");
	
	document.getElementById("test").innerHTML = ((price+fees).toFixed(2));
	type=1;
}

function addQuantity(){
	quantity = Number(document.getElementById("quantity").value);
	
	total = quantity*(price+fees).toFixed(2);
	document.getElementById("test").innerHTML = total;
}

function submitForms() {
	var id = document.getElementById("submitButton");
	stockid = Number(id.getAttribute('data-stockid'));
	
	document.body.innerHTML += '<form id="dynForm" action="/ordered/'+stockid+'" method="post"><input type="hidden" name="quantity" value='+quantity+'><input type="hidden" name="price" value='+price+'><input type="hidden" name="type" value='+type+'><input type="hidden" name="total" value='+total+'></form>';
	
	document.getElementById("dynForm").submit();
}
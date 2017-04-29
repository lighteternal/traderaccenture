var price = "";
var fees = "";
var type =""; 
var total="";
var quantity="";
var stockid="";

function setBuy(){
	document.getElementById("quantityForm").style.visibility="visible";
	var id = document.getElementById("buyButton");
	price = Number(id.getAttribute('data-price'));
	
	fees =  (0.005*price);
	document.getElementById("fees").innerHTML = ((0.005*price).toFixed(2)+"EUR");
	
	document.getElementById("orderprice").innerHTML = ((price+fees).toFixed(2));
	type="BUY";
}

function setSell(){
	document.getElementById("quantityForm").style.visibility="visible";
	var id = document.getElementById("sellButton");
	price = Number(id.getAttribute('data-price'));
	
	fees =  (0.005*price+3);
	document.getElementById("fees").innerHTML = ((0.005*price+3).toFixed(2)+"EUR");
	
	document.getElementById("orderprice").innerHTML = ((price+fees).toFixed(2));
	type="SELL";
}

function addQuantity(){
	quantity = Number(document.getElementById("quantity").value);
	
	total = quantity*(price+fees).toFixed(2);
	document.getElementById("orderprice").innerHTML = total;
}

function submitForms() {
	var id = document.getElementById("submitButton");
	stockid = Number(id.getAttribute('data-stockid'));
	
	document.body.innerHTML += '<form id="dynForm" action="/ordered/'+stockid+'" method="post"><input type="hidden" name="quantity" value='+quantity+'><input type="hidden" name="price" value='+price+'><input type="hidden" name="type" value='+type+'><input type="hidden" name="total" value='+total+'></form>';
	
	document.getElementById("dynForm").submit();
	
	
}


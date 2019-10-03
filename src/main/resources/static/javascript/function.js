function validateForm() {

  var x = document.forms["orderForm"]["product"].value;
  if (x == "") {
    alert("Product information missing");
    return false;
  }

  x = document.forms["orderForm"]["description"].value;
  if (x == "") {
    alert("Description of product is missing");
    return false;
  }

  x = document.forms["orderForm"]["quantity"].value;
  if (x == null) {
    alert("quantity missing");
    return false;
  }

  x = document.forms["orderForm"]["cname"].value;
  if (x == "") {
    alert("Customer information missing");
    return false;
  }

  x = document.forms["orderForm"]["cno"].value;
  if (x == null) {
    alert("Customer information missing");
    return false;
  }

  x = document.forms["orderForm"]["status"].value;
  if(x == "") {
    alert("Status not mentioned");
  }

}
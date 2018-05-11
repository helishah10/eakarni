
var i = 1; // Global Variable for Name
var j = 1;
var a = 1;
var b = 1;


function textBoxCreate(){

var y = document.createElement("INPUT");
y.setAttribute("type", "text");
y.setAttribute("Placeholder", "Owner_" + i);
y.setAttribute("Name", "owner" + i);
document.getElementById("myForm").appendChild(y);
i++;
var x = document.createElement("INPUT");
x.setAttribute("type", "text");
x.setAttribute("Placeholder", "AadharCard__" + j);
x.setAttribute("Name", "aadhar" + j);
document.getElementById("myForm").appendChild(x);
j++;
}



function self(){
var y = document.createElement("INPUT");
var t = document.createTextNode("Email");
y.appendChild(t);
y.setAttribute("Placeholder", "milkat number");
y.setAttribute("Name", "milkat_number" );
document.getElementById("myForm").appendChild(y);

var y = document.createElement("INPUT");
var t = document.createTextNode("Email");
y.appendChild(t);
y.setAttribute("Placeholder", "milkat desc");
y.setAttribute("Name", "milkat_desc" );
document.getElementById("myForm").appendChild(y);

var y = document.createElement("INPUT");
var t = document.createTextNode("Email");
y.appendChild(t);
y.setAttribute("Placeholder", "area name");
y.setAttribute("Name", "area_name" );
document.getElementById("myForm").appendChild(y);

var y = document.createElement("INPUT");
var t = document.createTextNode("Email");
y.appendChild(t);
y.setAttribute("Placeholder", "estimated tax amount");
y.setAttribute("Name", "tax" );
document.getElementById("myForm").appendChild(y);

var y = document.createElement("INPUT");
var t = document.createTextNode("Email");
y.appendChild(t);
y.setAttribute("Placeholder", "assessmentOfAnnualRent :");
y.setAttribute("Name", "rent" );
document.getElementById("myForm").appendChild(y);

var y = document.createElement("INPUT");
var t = document.createTextNode("Email");
y.appendChild(t);
y.setAttribute("Placeholder", "પછલા વધારેલા અને ગટાળા ની બાબત  :");
y.setAttribute("Name", "increase_decrease" );
document.getElementById("myForm").appendChild(y);



var y = document.createElement("INPUT");
var t = document.createTextNode("Email");
y.appendChild(t);
y.setAttribute("Placeholder", "રજીસ્ટર પાનાં ક્રમાંક: :");
y.setAttribute("Name", "reg_pgno" );
document.getElementById("myForm").appendChild(y);




j++;
}

function other(){
var k = document.createElement("INPUT");
k.setAttribute("type", "text");
k.setAttribute("Placeholder", "Occupant_" + a);
k.setAttribute("Name", "occupnt" + a);
document.getElementById("myForm").appendChild(k);
a++;
var l = document.createElement("INPUT");
l.setAttribute("type", "text");
l.setAttribute("Placeholder", "AadharCard__" + b);
l.setAttribute("Name", "aadhar1" + b);
document.getElementById("myForm").appendChild(l);
b++;
}


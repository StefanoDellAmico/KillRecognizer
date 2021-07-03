function screenit(){
	variables.printed += counted - previous;
	variables.previous = variables.counted;
	
	return variables.printed;
}

function prova(){
	setTimeout(function(){location.reload()},1000);
	document.getElementById("prova").innerHTML = "Kill:" + screenit() + "/500";
}

function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}

function giveBack(){
	return variables.printed;
}


prova();

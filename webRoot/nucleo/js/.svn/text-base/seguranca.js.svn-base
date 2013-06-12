function popup(url, width, height){
	window.open(url, 'popupSeguranca', 'width=' + width + ',height=' + height + ', resizable=yes,scrollbars=yes');
}

function transfere(origem, destino){
	alert("origem.options.length " + origem.options.length);
	alert("destino.options.length " + destino.options.length);
	for(i = 0; i < origem.options.length; i++){
		if (origem.options[i].selected){
			//alert("transfere " + origem.options[i].text + " com o valor " + origem.options[i].value);
			destino.options[destino.options.length] = new Option(origem.options[i].text, origem.options[i].value);
			origem.options[i] = null;
		}
	}
}
//MODAL
var modal = document.getElementById('modalItem');
var modalcpf = document.getElementById('modalCPF');
var btn = document.getElementById('btnPedido');
var spanCPF = document.getElementsByClassName("closecpf")[0];
var span = document.getElementsByClassName("close")[0];

window.onclick = function(event) {
	if (event.target == modalcpf) {
		hideModalCpf();
	}
	if (modal && event.target == modal) {
		hideModal();
	}
	if (event.target == btn) {
		modalcpf.style.display = "block";
	}
	if (span && event.target == span) {
		hideModal();
	}
	if (event.target == spanCPF) {
		hideModalCpf();
	}
}

hideModalCpf = function() {
	modalcpf.style.display = "none";
	document.getElementById('modalTxt').value = "";
}

hideModal = function() {
	modal.style.display = "none";
	$('.input-number').val('1');
}

// MASCARA PARA CPF
$(document).ready(function() {
	$('.cpf').mask('000.000.000-00', {
		reverse : true
	});
});
//MODAL
var modal = document.getElementById('modalItem');
var modalcpf = document.getElementById('modalCPF');
var btn = document.getElementById('btnPedido');
var spanCPF = document.getElementsByClassName("closecpf")[0];
btn.onclick = function() {
	modalcpf.style.display = "block";
}

spanCPF.onclick = function() {
	modalcpf.style.display = "none";
}

window.onclick = function(event) {
	if (event.target == modalcpf) {
		modalcpf.style.display = "none";
	}
	if (modal && event.target == modal) {
		modal.style.display = "none";
	}
}

// MASCARA PARA CPF
$(document).ready(function() {
	$('#CPF').mask('000.000.000-00', {
		reverse : true
	});
});
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
</script>

<button id="fecharVenda" onclick="fecharVenda()" class="btn btn-success">Fechar Venda</button>
<script>
    function fecharVenda() {
        $.post("fecharVenda?venda_id=${venda.id}&tipoDeReceita_id=" + $("#receita").val(), function (dadosDeResposta) {


//                                                    if (dadosDeResposta == true) {
//                                                        window.location.href = "vendas";
//                                                    }else{
//                                                        alert("saldo insuficiente");
//                                                    }

        });
        window.location.href = "vendas";
    }
</script>

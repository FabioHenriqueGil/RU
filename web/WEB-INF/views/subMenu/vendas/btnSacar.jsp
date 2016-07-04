
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
</script>
<div class="highlights">
    <input type="radio" id="radio-img1" name="highlights" checked="checked" />
    <label class="btn btn-primary" for="modal_saca">Sacar</label>
</div>
<input type="checkbox" id="modal_saca" />
<div class="modal">
    <div class="modal-content">
        <label for="valor">Informe o Valor:</label> 
        <input type="text" onkeypress='return SomenteNumero(event)'
               class="form-control" name="saca" id="saca">
        <br>
        <button id="sacar" onclick="saca()" class="btn btn-primary">Sacar</button>
    </div>
    <label class="modal-close" for="modal_saca"></label>
</div>
<script>
    function saca() {
        $.post("saca?valor=" + $('#saca').val() + "&consumidor_id=${consumidor.id}", function (dadosDeResposta) {

//                                                    if (dadosDeResposta != true) {
//                                                        alert("não foi possivel sacar, saldo insuficiente");
//                                                    }

        });
    }

</script> 
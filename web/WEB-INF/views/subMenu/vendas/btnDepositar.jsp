

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
</script>

<div class="highlights">
    <input type="radio" id="radio-img1" name="highlights" checked="checked" />
    <label class="btn btn-primary" for="modal_deposita">Depositar</label>
</div>
<input type="checkbox" id="modal_deposita" />
<div class="modal">
    <div class="modal-content">
        <label for="valor">Informe o Valor:</label> 
        <input type="text" onkeypress='return SomenteNumero(event)'
               class="form-control" name="deposita" id="deposita">
        <br>
        <button id="depositar" onclick="deposita()" class="btn btn-primary">Depositar</button>
    </div>
    <label class="modal-close" for="modal_deposita"></label>
</div>
<script>
    function deposita() {
        $.get("deposita?valor=" + $("#deposita").val() + "&consumidor_id=${consumidor.id}");
        
    }

</script>
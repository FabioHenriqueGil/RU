
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
</script>
<div class="highlights">
    <input type="radio" id="radio-img1" name="highlights" checked="checked" />
    <label class="btn btn-primary" for="modal_produto">ADD Produto</label>
</div>
<input type="checkbox" id="modal_produto" />
<div class="modal">
    <div class="modal-content">
        <h4>Selecione o Produto</h4>
        <table class="table">
            <tr>
                <td><b>ID</b></td>
                <td><b>Descrição</b></td> 
                <td><b>Preço</b></td>  
            </tr>
            <c:forEach items="${buscaProdutos}" var="produto">
                <tr onMouseOver="javascript:this.style.backgroundColor = '#00BB55'" 
                    onMouseOut="javascript:this.style.backgroundColor = ''" 
                    onclick="atualiza(${produto.id},${produto.precoVenda}, ${venda.id})">
                    <td>${produto.id}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.precoVenda}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <label class="modal-close" for="modal_produto"></label>
</div>
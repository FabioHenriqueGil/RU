
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="table-responsive">
    <table class="table">
        <tr>
            <td><b>ID</b></td>
            <td><b>Descricao</b></td>
            <td><b>Preco</b></td>
            <td><b>QTD</b></td>
            <td><b>Remover</b></td>
        </tr>


        <c:forEach items="${produtos}" var="produto">
            <tr >
                <td>${produto.id}</td>
                <td>${produto.descricao}</td>
                <td>${produto.precoVenda}</td>
                <td>${produto.qtd}</td>
                <td>
                    <button id="remover" onclick="removerProduto(${produto.id},${venda.id})" class="btn btn-danger">
                        Remover
                    </button>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
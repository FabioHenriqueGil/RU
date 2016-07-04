
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

         
        <div class="table-responsive">
            <table class="table">
                <tr>
                    <td><b><label for="filtro">ID</label></b></td>
                    <td><b><label for="filtro">Descricao</label></b></td>
                    <td><b><label for="filtro">Preco</label></b></td>
                    <td><b><label for="filtro">Remover</label></b></td>
                </tr>


                <c:forEach items="${produtos}" var="produto">
                    <tr >
                        <td>${produto.id}</td>
                        <td>${produto.descricao}</td>
                        <td>${produto.precoVenda}</td>
                        <td>Por fazer</td>

                    </tr>
                </c:forEach>
            </table>
        </div>
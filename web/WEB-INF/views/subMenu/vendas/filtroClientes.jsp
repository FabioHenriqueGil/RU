

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        
        <div class="table-responsive">
            <table class="table">
                <tr>
                    <td><b><label for="filtro">ID</label></b></td>
                    <td><b><label for="filtro">Nome</label></b></td>
                    <td><b><label for="filtro">GRR</label></b></td>
                    <td><b><label for="filtro">Modalidade</label></b></td>
                    <td><b><label for="filtro">Vinculo</label></b></td>
                </tr>


                <c:forEach items="${consumidores}" var="consumidor">
                    <tr onMouseOver="javascript:this.style.backgroundColor = '#00BB55'" 
                        onMouseOut="javascript:this.style.backgroundColor = ''" 
                        onclick="iniciaVenda(${consumidor.id})">
                        <td>${consumidor.id}</td>
                        <td>${consumidor.nome}</td>
                        <td>${consumidor.grr}</td>
                        <td>${consumidor.modalidade.descricao}</td>
                        <td>${consumidor.vinculo.descricao}</td>  

                    </tr>
                </c:forEach>
            </table>
        </div>

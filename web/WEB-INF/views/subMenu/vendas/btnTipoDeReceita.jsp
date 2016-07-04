<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form-group" align="center">
    <select name="receita" id="receita" class="list-group center-block" >
        <c:forEach items="${tiposDeReceita}" var="receita">
            <option value="${receita.id}" class="list-group-item">
                ${receita.descricao}
            </option>
        </c:forEach>
    </select>
</div>
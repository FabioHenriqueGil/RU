

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title> Lista Vinculos</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>

        <!--        <script src="js/bootstrap.min.js"/>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
        </script>
        <!--    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>-->
    </head>
    <body>

        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" align="center">Lista de Tipos de Receitas</div>

                <div class="panel panel-primary">
                    <div class="table-responsive">
                        <table class="table">
                            <tr>


                                <td><b>ID</b></td>
                                <td><b>Descrição</b></td>
                                <td><b>Crédito</b></td>
                                <td><b>Alterar</b></td>
                            </tr>


                            <c:forEach items="${tipos}" var="tipo">
                                <tr>
                                    <td>${tipo.id}</td>
                                    <td>${tipo.descricao}</td>
                                    <c:if test="${tipo.credito eq true}">
                                        <td>Crédito</td>

                                    </c:if>
                                    <c:if test="${tipo.credito eq false}">
                                        <td>Caixa</td>

                                    </c:if>
                                    <td><a href="mostraTipoDeReceita?id=${tipo.id}">Alterar</td>

                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div align="center">
                    <button class="btn btn-danger"
                            onclick="window.location.href = 'cadastro';">Voltar
                    </button>
                    <button class="btn btn-success "
                            onclick="window.location.href = 'novoTipoDeReceita';">ADD
                    </button>
                </div>
            </div>
        </div>

    </body>
</html>
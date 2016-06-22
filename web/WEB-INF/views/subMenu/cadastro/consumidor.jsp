

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title> Lista Consumidores</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>

        <!--        <script src="js/bootstrap.min.js"/>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
        </script>
        <!--    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>-->
    </head>
    <body>

        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" align="center">Lista de Consumidores</div>

                <div class="panel panel-primary">
                    <div class="table-responsive">
                        <table class="table">
                            <tr>


                                <td><b>ID</b></td>
                                <td><b>Nome</b></td>
                                <td><b>GRR</b></td>
                                <td><b>Modalidade</b></td>
                                <td><b>Vinculo</b></td>
                                <td><b>Ativo</b></td>
                                <td><b>Alterar</b></td>
                            </tr>


                            <c:forEach items="${consumidores}" var="consumidor">
                                <tr>
                                    <td>${consumidor.id}</td>
                                    <td>${consumidor.nome}</td>
                                    <td>${consumidor.grr}</td>
                                    <td>${consumidor.modalidade.descricao}</td>
                                    <td>${consumidor.vinculo.descricao}</td>                                    
                                    <c:if test="${consumidor.ativo eq false}">
                                        <td>Inativo</td>

                                    </c:if>
                                    <c:if test="${consumidor.ativo eq true}">
                                        <td>Ativo</td>

                                    </c:if>
                                        <td><a href="mostraConsumidor?id=${consumidor.id}">Alterar</td>
                                    
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div align="center">
                    <button class="btn btn-danger"
                            onclick="window.location.href = 'cadastro';">Voltar
                    </button>
                    <button class="btn btn-primary"
                            onclick="window.location.href = 'novoConsumidor';">ADD
                    </button>
                </div>
            </div>
        </div>






        <!--        <script type="text/javascript">
                    function finalizaAgora(id) {
                        $.get("finalizarTarefa?id=" + id,
                                function (resposta) {
                                    $("#tarefa_" + id).html(resposta);
                                });
                    }
                </script>-->


        <script type="text/javascript" >
            function finalizarAgora(id) {
                $.get("finalizarTarefa?id=" + id, function () {
                    alert("Tarefa Finalizada ");
                    $("#tarefa_" + id).html("Finalizada Com Ajax");

                });

            }
        </script>
    </body>
</html>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title> Lista Taxas</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>

        <!--        <script src="js/bootstrap.min.js"/>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
        </script>
        <!--    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>-->
    </head>
    <body>

        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" align="center">Lista de Taxas</div>

                <div class="panel panel-primary">
                    <div class="table-responsive">
                        <table class="table">
                            <tr>


                                <td><b>Modalidade</b></td>
                                <td><b>Produto</b></td>
                                <td><b>Valor de Subsidio</b></td>
                                <td><b>Alterar</b></td>
                            </tr>


                            <c:forEach items="${taxas}" var="taxa">
                                <tr>

                                    <td>${taxa.modalidade.descricao}</td>
                                    <td>${taxa.produto.descricao}</td>
                                    <td>${taxa.desconto}</td>
                                    <td><a href="mostraTaxa?modalidade_id=${taxa.modalidade.id}&produto_id=${taxa.produto.id}">Alterar</td>

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
                            onclick="window.location.href = 'novaTaxa';">ADD
                    </button>
                </div>
            </div>
        </div>


    </body>
</html>
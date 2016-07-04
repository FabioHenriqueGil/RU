

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
                <div class="panel-heading" align="center">Selecione um Consumidor</div>
                <div class="panel panel-primary">
                    <div class="form-group">
                        <br>
                        <input type="text" onkeyup="filtrar()" placeholder="FILTRO DE CONSUMIDOR" 
                               class="form-control" name="like" id="like">
                    </div>

                </div>

                <div id="filtroClientes"  class="panel panel-primary">
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
                </div>
                <div align="center">
                    <button class="btn btn-danger"
                            onclick="window.location.href = 'inicio';">Voltar
                    </button>

                </div>
            </div>
        </div>
        <script type="text/javascript">
            function filtrar() {

                var f = $('#like').val();
                $.post("filtrarConsumidor?filtroC="+f, function (dadosDeResposta) {
                    
                    $("#filtroClientes").html(dadosDeResposta);
                });

            }
            function iniciaVenda(id) {
                window.location.href = 'selecionaProdutos?consumidor_id=' + id;
            }
        </script>
    </body>
</html>
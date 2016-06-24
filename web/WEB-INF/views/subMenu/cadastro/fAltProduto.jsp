<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Altera Produto</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="js/jquery/jquery-ui.css">
        <!--        <script src="js/bootstrap.min.js"></script>-->
        <!-- <script src="js/jquery/jquery-ui.js" ></script> -->
        <!-- <script src="js/jquery/jquery-1.9.1.js"></script> -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

    </head>
    <body>

        <form role="form" action="alteraProduto" method="POST">
            <input type="hidden" name="id" value="${produto.id}">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading" align="center"><h2>Alterar</h2></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="descricao">Descrição:</label> <input type="text"
                                                                             value="${produto.descricao}" class="form-control" name="descricao" id="descricao">
                        </div>
                        <div class="form-group">
                            <label for="descricao">Preço:</label> <input type="text"
                                                                         value="${produto.precoPadrao}" class="form-control" name="precoPadrao" id="precoPadrao">
                        </div>
                        <div>
                            <label for="ativo">Ativo: </label>
                            <c:if test="${produto.ativo eq true}">
                                <input class=" checkbox-inline" type="checkbox"
                                       name="ativo" id="ativo"  checked>

                            </c:if>
                            <c:if test="${produto.ativo eq false}">
                                <input class=" checkbox-inline" type="checkbox"
                                       name="ativo" id="ativo"  >

                            </c:if>


                            <br><br>                               

                        </div>



                        <button type="submit" class="btn btn-primary">Gravar</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href = 'listaproduto';">Cancelar</button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Altera Vinculo</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="js/jquery/jquery-ui.css">
        <!--        <script src="js/bootstrap.min.js"></script>-->
        <!-- <script src="js/jquery/jquery-ui.js" ></script> -->
        <!-- <script src="js/jquery/jquery-1.9.1.js"></script> -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

    </head>
    <body>

        <form id="form" name="form" role="form" action="alteraTipoDeReceita" method="POST">
            <input type="hidden" name="id" value="${tipo.id}">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading" align="center"><h2>Alterar Tipo de Receita</h2></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="descricao">Descrição:</label> 
                            <input type="text" onblur="botaoGravar()"
                                   value="${tipo.descricao}" class="form-control" name="descricao" id="descricao">
                        </div>
                        <div>
                            <label for="credito">Crédito: </label>
                            <c:if test="${tipo.credito eq true}">
                                <input class=" checkbox-inline" type="checkbox"
                                       name="credito" id="credito"  checked>

                            </c:if>
                            <c:if test="${tipo.credito eq false}">
                                <input class=" checkbox-inline" type="checkbox"
                                       name="credito" id="credito"  >

                            </c:if>


                            <br><br>                               

                        </div>



                        <button id="gravar" type="submit" class="btn btn-primary">Gravar</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href = 'listaTiposDeReceitas';">Cancelar</button>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function botaoGravar() {
                    if ($('#descricao').val() == '') {
                        document.form.gravar.disabled = true;
                    } else {
                        document.form.gravar.disabled = false;
                    }
                }


                window.onload = function () {
                    if ($('#descricao').val() == '') {
                        document.form.gravar.disabled = true;
                    } else {
                        document.form.gravar.disabled = false;
                    }
                }
            </script>
        </form>
    </body>
</html>

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
        <script language='JavaScript'>
            function SomenteNumero(e) {
                var tecla = (window.event) ? event.keyCode : e.which;
                if ((tecla > 47 && tecla < 58))
                    return true;
                else {
                    if (tecla == 8 || tecla == 0 || tecla == 46)
                        return true;
                    else
                        return false;
                }
            }
        </script>
    </head>
    <body>

        <form id="form" name="form" role="form" action="alteraProduto" method="POST">
            <input type="hidden" name="id" value="${produto.id}">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading" align="center"><h2>Alterar</h2></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="descricao">Descri��o:</label>
                            <input type="text" onblur="botaoGravar()" 
                                   value="${produto.descricao}" class="form-control" name="descricao" id="descricao">
                        </div>
                        <div class="form-group">
                            <label for="descricao">Pre�o:</label> 
                            <input type="text" onblur="botaoGravar()" onkeypress='return SomenteNumero(event)'
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



                        <button id="gravar" type="submit" class="btn btn-primary">Gravar</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href = 'listaProdutos';">Cancelar</button>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function botaoGravar() {
                    if (($('#descricao').val() == '')||($('#precoPadrao').val() == '')) {
                        document.form.gravar.disabled = true;
                    } else {
                        document.form.gravar.disabled = false;
                    }
                }


                window.onload = function () {
                    if (($('#descricao').val() == '')||($('#precoPadrao').val() == '')) {
                        document.form.gravar.disabled = true;
                    } else {
                        document.form.gravar.disabled = false;
                    }
                }
            </script>
        </form>
    </body>
</html>

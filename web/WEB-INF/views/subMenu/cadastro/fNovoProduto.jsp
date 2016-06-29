<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Adiona Produto</title>
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

        <form role="form" name="form" id="form" action="adicionaProduto" method="POST">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading" align="center"><h2>Cadastro</h2></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="descricao">Descrição:</label> 
                            <input type="text"  onblur="botaoGravar()" 
                                   class="form-control" name="descricao" id="descricao">
                        </div>
                        <div class="form-group">
                            <label for="precoPadrao">Preço:</label> 
                            <input type="text"  onblur="botaoGravar()" onkeypress='return SomenteNumero(event)'
                                   class="form-control" name="precoPadrao" id="precoPadrao">
                        </div>




                        <button name="gravar" id="gravar" type="submit" class="btn btn-primary">Gravar</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href = 'listaProdutos';">Cancelar</button>
                    </div>
                </div>
            </div>
        </form>
        <script type="text/javascript">
            function botaoGravar() {
                if (($('#descricao').val() == '') || ($('#precoPadrao').val() == '')) {
                    document.form.gravar.disabled = true;
                } else {
                    document.form.gravar.disabled = false;
                }
            }


            window.onload = function () {
                if (($('#descricao').val() == '') || ($('#precoPadrao').val() == '')) {
                    document.form.gravar.disabled = true;
                } else {
                    document.form.gravar.disabled = false;
                }
            }


        </script>
    </body>
</html>

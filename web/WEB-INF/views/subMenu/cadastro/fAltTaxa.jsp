<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Altera Desconto</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="js/jquery/jquery-ui.css">
        <script src="js/bootstrap.min.js"></script>
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

        <form name="form" id="form" role="form" action="alteraTaxa" method="POST">
            <input type="hidden" id="modalidade_id" name="modalidade_id" value="${taxa.modalidade.id}">
            <input type="hidden" id="produto_id" name="produto_id" value="${taxa.produto.id}">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading" align="center"><h2>Alterar Desconto</h2></div>
                    <div class="panel-body">
                        <div class="panel-heading">
                            <h3><b>Modalidade:</b> ${taxa.modalidade.descricao}  <br><b>Produto:</b> ${taxa.produto.descricao}</h3>
                        </div>
                        <div class="form-group">
                            <label for="desconto">Desconto: </label> 
                            <input onblur="botaoGravar()" type="text" value="${taxa.desconto}" onkeypress='return SomenteNumero(event)'
                                   class="form-control" name="desconto" id="desconto" >
                        </div>

                    </div>

                    <div align="center" >
                        <button id="gravar" type="submit" class="btn btn-primary" >Gravar</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href = 'listaTaxas';">Cancelar</button>
                        <br><br>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function botaoGravar() {
                    if ($('#desconto').val() == '') {
                        document.form.gravar.disabled = true;
                    } else {
                        document.form.gravar.disabled = false;
                    }
                }


                window.onload = function () {
                    if ($('#desconto').val() == '') {
                        document.form.gravar.disabled = true;
                    } else {
                        document.form.gravar.disabled = false;
                    }

                    if (${flagInsert}) {
                        alert("Subs�dio j� est� cadastrado!");
                ${flagInsert} = false;
                    }
                }


            </script>
        </form>
    </body>
</html>

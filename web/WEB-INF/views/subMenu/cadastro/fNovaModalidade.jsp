<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Adiona Modalidade</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="js/jquery/jquery-ui.css">
        <script src="js/bootstrap.min.js"></script>
        <!-- <script src="js/jquery/jquery-ui.js" ></script> -->
        <!-- <script src="js/jquery/jquery-1.9.1.js"></script> -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

    </head>
    <body>

<!--        <form role="form" id="form" name="form" action="" method="POST">-->
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading" align="center"><h2>Cadastro</h2></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="descricao">Descrição:</label> 
                            <input type="text" onblur="botaoGravar()"
                                   class="form-control" name="descricao" id="descricao">
                        </div>
                        <div id="checkDiv" class="panel-body">
                            <div class="panel-heading" >Vinculos Bloqueados</div>
                            <c:forEach items="${vinculos}" var="vinculo">
                                <input type="checkbox" id="${vinculo.id}" 
                                       name="${vinculo.id}" />
                                <label for="${vinculo.id}">
                                    ${vinculo.descricao}
                                </label>
                                <br />

                            </c:forEach>


                        </div>

                        <button id="gravar" type="button" class="btn btn-primary" onclick="gravar()">Gravar</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href = 'listaModalidades';">Cancelar</button>
                    </div>
                </div>
            </div>
        <!--</form>-->
        <script type="text/javascript">
            function botaoGravar() {
                if ($('#descricao').val() == '') {
                    document.forms.gravar.disabled = true;
                } else {
                    document.forms.gravar.disabled = false;
                }
            }


            window.onload = function () {
                if ($('#descricao').val() == '') {
                    document.forms.gravar.disabled = true;
                } else {
                    document.forms.gravar.disabled = false;
                }
            }
            function gravar() {
                var minhaDiv = document.getElementById("checkDiv");
                var listaMarcados = minhaDiv.getElementsByTagName("INPUT");
                var list = new Array();
                for (loop = 0; loop < listaMarcados.length; loop++) {
                    var item = listaMarcados[loop];
                    if (item.type == "checkbox" && item.checked) {
                        list[list.length] = item.id;
                        //list = new Array(list, item.id);
                    }
                }

                window.location.href = "adicionaModalidade?descricao=" + $('#descricao').val() + "&vinculosBloqueados=" + list;
            }

        </script>
    </body>
</html>

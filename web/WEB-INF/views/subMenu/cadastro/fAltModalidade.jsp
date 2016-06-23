<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Altera Modalidade</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="js/jquery/jquery-ui.css">
        <!--        <script src="js/bootstrap.min.js"></script>-->
        <!-- <script src="js/jquery/jquery-ui.js" ></script> -->
        <!-- <script src="js/jquery/jquery-1.9.1.js"></script> -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

    </head>
    <body>

        <!--        <form role="form" action="alteraModalidade" method="POST">-->
        <input type="hidden" id="id" name="id" value="${modalidade.id}">
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" align="center"><h2>Alterar</h2></div>
                <div class="panel-body">
                    <div class="form-group">
                        <label for="descricao">Descrição:</label> <input type="text"
                                                                         value="${modalidade.descricao}" class="form-control" name="descricao" id="descricao">
                    </div>
                    <div>
                        <label for="ativo">Ativo: </label>
                            <input class=" checkbox-inline" type="checkbox"
                                   name="ativo" id="ativo" value="${modalidade.ativo}"  ${modalidade.ativo? 'checked' : ''} onclick="refreshCheckBox(this)"/>
                           
                    </div>
                    <div id="checkDiv" class="panel-body">
                        <div class="panel-heading" >Vinculos Bloqueados</div>


                        <c:forEach items="${modalidade.vinculosBloqueados}" var="vinculo">
                            <input type="checkbox" id="${vinculo.id}" 
                                   name="${modalidade.vinculosBloqueados}" checked="true">
                            <label for="${vinculo.id}">
                                ${vinculo.descricao}
                            </label>
                            <br />

                        </c:forEach>
                        <c:forEach items="${vinculos}" var="vinculo">
                            <input type="checkbox" id="${vinculo.id}" 
                                   name="${vinculos}">
                            <label for="${vinculo.id}">
                                ${vinculo.descricao}
                            </label>
                            <br />

                        </c:forEach>


                    </div>



                    <button type="button" class="btn btn-primary" onclick="gravar()" >Gravar</button>
                    <button type="button" class="btn btn-primary"
                            onclick="window.location.href = 'listaModalidades';">Cancelar</button>
                </div>
            </div>
        </div>
        <!--        </form>-->
        <script type="text/javascript">
            function refreshCheckBox(checkbox){
                checkbox.value=checkbox.checked;
                
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
                window.location.href = "alteraModalidade?id=" + $('#id').val() + "&descricao=" + $('#descricao').val() + "&ativo=" + $('#ativo').val() + "&vinculosBloqueados=" + list;
            }

        </script>
    </body>
</html>

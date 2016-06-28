<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Adiciona Taxa de Subsídio</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="js/jquery/jquery-ui.css">
        <script src="js/bootstrap.min.js"></script>
        <!-- <script src="js/jquery/jquery-ui.js" ></script> -->
        <!-- <script src="js/jquery/jquery-1.9.1.js"></script> -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

    </head>
    <body>

        <form name="form" id="form" role="form" action="adicionaTaxa" method="POST">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading" align="center"><h2>Cadastro</h2></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label  for="desconto">Desconto: </label> <input onblur="botaoGravar()" type="number" value="${desconto}"
                                                                    class="form-control" name="desconto" id="desconto">
                        </div>
                        

                        <div class="form-group" align="center">
                            <select name="modalidade_id" id="modalidade_id" class="list-group center-block" >
                                <option  value="0" class="list-group-item" onclick="atualiza(0)">Modalidade</option>
                                <c:forEach items="${modalidades}" var="modalidade">

                                    <c:if test="${param.modalidade_id == modalidade.id}">
                                        <option value="${modalidade.id}" class="list-group-item" onclick="atualiza(${modalidade.id})" selected>
                                            ${modalidade.descricao}
                                        </option>
                                    </c:if>
                                    <c:if test="${param.modalidade_id != modalidade.id}">
                                        <option value="${modalidade.id}" class="list-group-item" onclick="atualiza(${modalidade.id})">
                                            ${modalidade.descricao}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </select>

                        </div>

                        <div onclick="botaoGravar()" id="produtosDiv" class="form-group" align="center"> 
                            <c:if test="${param.idModalidade != 0}">
                                <select name="produto_id" id="produto_id" class="list-group center-block" >
                                    <option value="0" class="list-group-item" selected>Produto</option>
                                    <c:forEach items="${produtos}" var="produto" >
                                        <option value="${produto.id}" class="list-group-item ">${produto.descricao}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                            <c:if test="${param.idModalidade == 0}">
                                <select name="produto_id" id="produto_id" class="list-group center-block" disabled>
                                    <option value="0" class="list-group-item" selected>Produto</option>
                                </select>
                            </c:if>
                        </div>

                    </div>

                    <div align="center" >
                        <button name="gravar" id="gravar" type="submit" class="btn btn-primary">Gravar</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href = 'listaTaxas';">Cancelar</button>
                        <br><br>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function botaoGravar() {
                    if (($('#produto_id').val() == 0) || ($('#desconto').val() == '')) {
                        document.form.gravar.disabled = true;
                    } else {
                        document.form.gravar.disabled = false;
                    }
                }


                window.onload = function () {
                    if (($('#produto_id').val() == 0) || ($('#desconto').val() == '')) {
                        document.form.gravar.disabled = true;
                    } else {
                        document.form.gravar.disabled = false;
                    }
                }
                function atualiza(idMod) {

                    window.location.assign("novaTaxa?desconto=" + $('#desconto').val() +"&modalidade_id=" + idMod );
                    //$.get("novoConsumidor?id=" + idMod);

                    // $("#produtosDiv").html(idMod);
                }

            </script>
        </form>
    </body>
</html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Adiona Consumidor</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="js/jquery/jquery-ui.css">
        <script src="js/bootstrap.min.js"></script>
        <!-- <script src="js/jquery/jquery-ui.js" ></script> -->
        <!-- <script src="js/jquery/jquery-1.9.1.js"></script> -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

    </head>
    <body>

        <form role="form" action="adicionaConsumidor" method="POST">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading" align="center"><h2>Cadastro</h2></div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="nome">Nome: </label> <input type="text" value="${nome}"
                                                                    class="form-control" name="nome" id="nome">
                        </div>
                        <div class="form-group">
                            <label for="grr">GRR: </label> <input type="text" value="${grr}"
                                                                  class="form-control" name="grr" id="grr">
                        </div>

                        <div class="form-group" align="center">
                            <select name="modalidade_id" id="modalidade_id" class="list-group center-block">
                                <option  value="" class="list-group-item" onclick="atualiza(0)">Modalidade</option>
                                <c:forEach items="${modalidades}" var="modalidade">

                                    <c:if test="${param.idModalidade == modalidade.id}">
                                        <option value="${modalidade.id}" class="list-group-item" onclick="atualiza(${modalidade.id})" selected>
                                            ${modalidade.descricao}
                                        </option>
                                    </c:if>
                                    <c:if test="${param.idModalidade != modalidade.id}">
                                        <option value="${modalidade.id}" class="list-group-item" onclick="atualiza(${modalidade.id})">
                                            ${modalidade.descricao}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </select>

                        </div>

                        <div id="vinculosDiv" class="form-group" align="center"> 
                            <c:if test="${param.idModalidade != 0}">
                                <select name="vinculo_id" id="vinculo_id" class="list-group center-block" >
                                    <option value="" class="list-group-item" selected>Vinculo</option>
                                    <c:forEach items="${vinculos}" var="vinculo" >
                                        <option value="${vinculo.id}" class="list-group-item ">${vinculo.descricao}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                            <c:if test="${param.idModalidade == 0}">
                                <select name="vinculo_id" id="vinculo_id" class="list-group center-block" disabled>
                                    <option value="" class="list-group-item" selected>Vinculo</option>
                                </select>
                            </c:if>
                        </div>

                    </div>

                    <div align="center" >
                        <button type="submit" class="btn btn-primary">Gravar</button>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location.href = 'listaConsumidores';">Cancelar</button>
                        <br><br>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                
                function atualiza(idMod) {
                    
                    window.location.assign("novoConsumidor?idModalidade=" + idMod+"&nome="+$('#nome').val()+"&grr="+$('#grr').val());
                    
                    //$.get("novoConsumidor?id=" + idMod);

                    // $("#vinculosDiv").html(idMod);
                }

            </script>
        </form>
    </body>
</html>

<%-- 
    Document   : selecionaProdutos
    Created on : 29/06/2016, 11:16:35
    Author     : fabio
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seleciona Produto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=no" />
        <meta name="keywords" content="css4html, css+for+html, css 4 html, css4, css4 html, css, css3, html, html5" />

        <meta property="og:keywords" content="css4html, css+for+html, css 4 html, css4, css4 html, css, css3, html, html5" />
        <link rel="stylesheet" type="text/css" href="css/modal.css" />
        <link href="css/bootstrapGlobo.css" rel="stylesheet">

        <link href="css/bootstrapGlobo-responsive.css" rel="stylesheet">
        <!--        <link rel="stylesheet" href="css/bootstrap.min.css"/>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js">
        </script>
        <style type="text/css">
            body {
                padding-top: 5px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }
        </style>

    </head>
    <body>
        <div align="center" class="container">
            <div class="panel panel-primary">
                <div class="panel-heading" align="center"><h1>Venda</h1></div>

                <div class="panel panel-primary">
                    <br><br>
                    <div class="container-fluid">
                        <div align="center"  class="row-fluid span12">
                            <div class="span3">
                                <div align="center" class="well sidebar-nav">

                                    <label>MENU</label>
                                    <section id="produtos">
                                        <div class="highlights">
                                            <input type="radio" id="radio-img1" name="highlights" checked="checked" />
                                            <label class="btn btn-primary" for="modal_produto">ADD Produto</label>
                                        </div>
                                        <input type="checkbox" id="modal_produto" />
                                        <div class="modal">
                                            <div class="modal-content">
                                                <h4>Selecione o Produto</h4>
                                                <table class="table">
                                                    <tr>
                                                        <td><b>ID</b></td>
                                                        <td><b>Descrição</b></td> 
                                                        <td><b>Preço</b></td>  
                                                    </tr>
                                                    <c:forEach items="${buscaProdutos}" var="produto">
                                                        <tr onMouseOver="javascript:this.style.backgroundColor = '#00BB55'" 
                                                            onMouseOut="javascript:this.style.backgroundColor = ''" 
                                                            onclick="atualiza(${produto.id},${produto.precoVenda}, ${venda.id})">
                                                            <td>${produto.id}</td>
                                                            <td>${produto.descricao}</td>
                                                            <td>${produto.precoVenda}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                            <label class="modal-close" for="modal_produto"></label>
                                        </div>
                                        <script>

                                            function atualiza(id, precoVenda, idVenda) {
                                                $.post("adicionaProdutoVenda?idProduto=" + id + "&precoVenda=" + precoVenda + "&idVenda=" + idVenda, function (dadosDeResposta) {

                                                    $("#produtosSelecionados").html(dadosDeResposta);
                                                    
                                                    
                                                });

                                            }
                                            function removerProduto(id, idVenda) {
                                                $.post("removerProduto?idProduto=" + id + "&idVenda=" + idVenda, function (dadosDeResposta) {

                                                    $("#produtosSelecionados").html(dadosDeResposta);
                                                    
                                                    
                                                });

                                            }

                                        </script>

                                        <br><br>
                                        <div class="form-group" align="center">
                                            <select name="receita" id="receita" class="list-group center-block" >
                                                <c:forEach items="${tiposDeReceita}" var="receita">
                                                    <option value="${receita.id}" class="list-group-item">
                                                        ${receita.descricao}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <br><br>
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
                                        <div class="highlights">
                                            <input type="radio" id="radio-img1" name="highlights" checked="checked" />
                                            <label class="btn btn-primary" for="modal_deposita">Depositar</label>
                                        </div>
                                        <input type="checkbox" id="modal_deposita" />
                                        <div class="modal">
                                            <div class="modal-content">
                                                <label for="valor">Informe o Valor:</label> 
                                                <input type="text" onkeypress='return SomenteNumero(event)'
                                                       class="form-control" name="deposita" id="deposita">
                                                <br>
                                                <button id="depositar" onclick="deposita()" class="btn btn-primary">Depositar</button>
                                            </div>
                                            <label class="modal-close" for="modal_deposita"></label>
                                        </div>
                                        <script>
                                            function deposita() {
                                                alert($('#deposita').val());
                                            }

                                        </script>
                                        <br>
                                        <div class="highlights">
                                            <input type="radio" id="radio-img1" name="highlights" checked="checked" />
                                            <label class="btn btn-primary" for="modal_saca">Sacar</label>
                                        </div>
                                        <input type="checkbox" id="modal_saca" />
                                        <div class="modal">
                                            <div class="modal-content">
                                                <label for="valor">Informe o Valor:</label> 
                                                <input type="text" onkeypress='return SomenteNumero(event)'
                                                       class="form-control" name="saca" id="deposita">
                                                <br>
                                                <button id="depositar" onclick="saca()" class="btn btn-primary">Sacar</button>
                                            </div>
                                            <label class="modal-close" for="modal_saca"></label>
                                        </div>
                                        <script>
                                            function saca() {
                                                alert($('#saca').val());
                                            }

                                        </script>                                            
                                        <br><br>
                                        <button id="cancela" onclick="cancela()" class="btn btn-danger">Cancela Venda</button>
                                        <script>
                                            function cancela() {
                                                window.location.href = "vendas";
                                            }
                                        </script>

                                        <br><br>
                                        <button id="fecharVenda" onclick="fecharVenda()" class="btn btn-success">Fechar Venda</button>
                                        <script>
                                            function fecharVenda() {
                                                alert("venda fechada");
                                            }
                                        </script>


                                    </section>

                                </div><!--/.well -->
                            </div><!--/span-->
                            <div class="span8">
                                <div class="hero-unit">

                                    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                                    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                                    <div id="produtosSelecionados"  class="panel panel-primary">                                        
                                        <c:import url="produtosSelecionados.jsp"/>                                        
                                    </div>
                                </div>
                            </div><!--/row-->
                        </div><!--/span-->
                        <div class="span11">
                            <div align="left" class="hero-unit">

                                <label><h2><b>NOME DO CLIENTE: ${consumidor.nome}<br></b></h2></label>
                                
                                


                            </div>
                        </div><!--/span-->
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>

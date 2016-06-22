

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Cadastro</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>

    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">

                <div class="panel-heading" align="center"><h1>Cadastro</h1></div>
                <div class="panel panel-primary col-xs-8 col-sm-6">

                    <div class="panel panel-primary col-lg-2" align="center">
                        <br>
                        <a href="listaModalidades" class="btn btn-success btn-lg" >Modalidade</a>
                        <br><br>
                    </div>
                    <div class="panel panel-primary col-lg-2" align="center">
                        <br>
                        <a href="listaVinculos" class="btn btn-primary btn-lg">Vinculo</a>
                        <br><br>


                    </div>
                </div>
                <div class="panel panel-primary col-xs-8 col-sm-6">
                    <div class="panel panel-primary col-lg-2" align="center">
                        <br>
                        <a href="listaConsumidores" class="btn btn-warning btn-lg">Consumidor</a>
                        <br><br>

                    </div>
                    <div class="panel panel-primary col-lg-2" align="center">
                        <br>
                        <a href="listaProdutos" class="btn btn-danger btn-lg">Produto</a>
                        <br><br>

                    </div>

                </div >
                <div align="center">
                    <a  href="inicio" class="btn btn-danger btn-lg" >voltar</a>
                    <br><br>
                </div>
            </div>
        </div>
    </body>
</html>
<%-- 
    Document   : Principal
    Created on : 6/05/2024, 12:09:17 p. m.
    Author     : valer
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Parcial 2</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva venta</a>
                </li>
            </ul>
            
        </div>
        <div class="dropdown">
            <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${usuario.getNom()}
            </button>
            <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">
                    <img src="img/user.jpeg" alt="60" width="60"/>
                </a>
                <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                <a class="dropdown-item" href="#">usuario@gmail.com</a>
                <div class="dropdown-divider"></div>
                <form action="Validar" method="POST">
                    <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                </form>
            </div>
        </div>
    </nav>
                <div class="m-4" style="height: 5850px;">
                    <iframe name="myFrame" style="height: 100%;  border: none; width: 100%;"></iframe>
                </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>


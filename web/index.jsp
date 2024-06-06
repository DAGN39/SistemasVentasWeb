<%-- 
    Document   : index
    Created on : 6/05/2024, 12:07:43 p. m.
    Author     : valer
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="background-color: #f5f5f5;">
        <div class="container mt-4 col-lg-4">
            <div class="card">
                <div class="card-body text-center">
                    <form action="Validar" class="form-sign" method="POST">
                        <div class="form-group">
                            <h3>INICIO</h3>
                            <img src="img/logo.jpg" alt="70" width="170"/>
                            <p class="text-muted">BIENVENIDOS AL SISTEMA</p>
                        </div>
                        <div class="form-group">
                            <label for="txtuser">Usuario:</label>
                            <input type="text" id="txtuser" name="txtuser" class="form-control" placeholder="Usuario" required>
                        </div>
                        <div class="form-group">
                            <label for="txtpass">Contraseña:</label>
                            <input type="password" id="txtpass" name="txtpass" class="form-control" placeholder="Contraseña" required>
                        </div>
                        <button type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block mt-3">Ingresar</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>

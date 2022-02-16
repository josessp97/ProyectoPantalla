<%-- 
    Document   : index.jsp
    Created on : 17 ene. 2022, 8:21:03
    Author     : Josema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        
       <!-- <div class="alert alert-success" role="alert">El alumno ha sido insertado correctamente</div>
        
        <div class="alert alert-success" role="alert">El alumno ha sido eliminado correctamente</div>
        
        <div class="alert alert-success" role="alert">El alumno ha sido editado correctamente</div>
        
        <div class="alert alert-danger" role="alert">Error al insertar, editar o eliminar alumno</div>-->
        
        <div class="container">
            <!-- ENCABEZADO -->
            <div class="row">
                <div class="col-12"><h1 class="text-center">Gestión de Noticias</h1></div>
            </div>
            
            <!-- TABLA -->
            <div class="row">
                <table class="table table-striped">
                    <!-- ENCABEZADO DE LA TABLA -->
                    <thead class=".table-dark">
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Titulo</th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                        </tr>
                    </thead>

                    <!-- INFORMACION DE LA TABLA -->
                    <tbody>
                        
                        <tr>
                            <td class="col-3">1</td>
                            <td class="col-12">Titulo 1></td>
                            <td class="col-3">
                                <!--PARA ACTUALIZAR DATOS -->
                                <form method="GET" action="formulario.jsp">
                                    <!-- PARA DARLE ACCION AL BOTON -->
                                    <input type="hidden" name="accion" value="editar">
                                    <!--PARA ASIGNARLE UN ID SEGUN EL BOTON-->
                                    <input type="hidden" name="id">
                                    <!--PARA RECOGER LA DEMAS INFORMACION-->
                                    <input type="hidden" name="titulo">
                                    <!--BOTON-->
                                    <input type="submit" value="Editar" class="btn btn-warning">
                                </form>
                            </td>
                            <td>
                                <!--PARA ELIMINAR DATOS -->
                                <form method="GET" action="index.jsp">
                                    <!-- PARA DARLE ACCION AL BOTON -->
                                    <input type="hidden" name="accion" value="eliminar">
                                    <!--PARA ASIGNARLE UN ID SEGUN EL BOTON-->
                                    <input type="hidden" name="id">
                                    <input type="submit" value="Eliminar" class="btn btn-danger">
                                </form>
                            </td>
                        </tr>
                        
                    </tbody>
                        
                </table>
            </div>
            
            <!-- FILA BOTON FINAL, BOTON INSERTAR -->
            <div class="row">
                <div class="col-12">
                    <!-- POST ES PARA RECIBIR DATOS -->
                    <form method="GET" action="formulario.jsp">
                        <div class="d-grid gap-2">
                            <!-- PARA DARLE ACCION AL BOTON -->
                            <input type="hidden" name="accion" value="insertar">
                            <input type="submit" class="btn btn-success" value="Insertar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
                    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

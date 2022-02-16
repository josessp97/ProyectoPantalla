<%-- 
    Document   : formulario
    Created on : 17 ene. 2022, 10:35:58
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
        <div class="container">
            <!-- ENCABEZADO -->
            <div class="row">
                <div class="col-12">
                    <h1 class="text-center">
                    <%
                        String accion=request.getParameter("accion");
                        String clase="";
                        String valor="";
                        String  nombre="", apellidos="", direccion="", datosFamilia="";
                        int id=0, edad=0, curso=0;
                        
                        if(accion!=null){
                            if (accion.compareTo("insertar") == 0) {
                                clase="btn btn-primary";
                                valor="Insertar Noticia";
                                out.print(valor);
                            }else if (accion.compareTo("editar") == 0) {
                                clase="btn btn-warning";
                                valor="Editar Noticia";
                                out.print(valor);
                                id=Integer.parseInt(request.getParameter("id"));
                                nombre=request.getParameter("nombre");
                                apellidos=request.getParameter("apellidos");
                                edad=Integer.parseInt(request.getParameter("edad"));
                                direccion=request.getParameter("direccion");
                                curso=Integer.parseInt(request.getParameter("curso"));;
                                datosFamilia=request.getParameter("datosFamilia");
                            }
                        }
                    %>
                    </h1>
                    
                </div>
            </div>
            <!-- FORMULARIO -->
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <!--POST ES PARA ENVIAR DATOS -->
                    <form method="POST" action="index.jsp">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Titulo de la noticia</label>
                            <input type="text" class="form-control" name="nombre" value="<%=nombre%>">
                        </div>
                        <div class="mb-3">
                            <label for="apellidos" class="form-label">Tipo de noticia</label>
                            <input type="text" class="form-control" name="apellidos" value="<%=apellidos%>">
                        </div><!-- comment -->
                        <div class="mb-3">
                            <label for="edad" class="form-label">Informacion de la noticia</label>
                            <input type="text" class="form-control" name="edad" value="<%=edad%>">
                        </div><!-- comment -->
                        <div class="mb-3">
                            <label for="direccion" class="form-label">Fecha de la noticia</label>
                            <input type="text" class="form-control" name="direccion" value="<%=direccion%>">
                        </div><!-- comment -->
                        <div class="mb-3">
                            <label for="curso" class="form-label">Ruta de la imagen</label>
                            <input type="text" class="form-control" name="curso" value="<%=curso%>">
                        </div>
                        <input type="hidden" name="id" value="<%=id%>">
                        <input name="accion" type="hidden" value="<%=accion%>">
                        <!--PARA RECOGER EL ID-->
                        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
                        <div class="d-grid gap-2">
                            <input type="submit" class="<%=clase%>" value="<%=valor%>">
                        </div>
                    </form>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

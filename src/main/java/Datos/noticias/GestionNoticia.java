/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.noticias;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author Equipo
 */
public class GestionNoticia {
    
    private static SessionFactory miSessionFactory;
    private static Session miSession;
    
    public GestionNoticia(){
        //ESTABLECIENDO LA CONFIGURACION A LA SessionFactory
        miSessionFactory=new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Noticia.class).buildSessionFactory();
        //PARA ABRIR LA SESION
        miSession=miSessionFactory.openSession();
    }
    
    //LEER UN REGISTRO
    public void leerRegistro(int id){
        try{
            //COMENZAR TRANSACCION
            miSession.beginTransaction();
            
            System.out.println("Lectura del registro con id: "+id);
            
            //OBTENER EL REGISTRO
            Noticia aux=(Noticia)miSession.get(Noticia.class, id);
           
            System.out.println("Registro leido: "+aux);
            //CERRAR CONEXION
            miSession.close();
            
        }finally{
            //PARA CERRAR SIEMPRE 
            miSessionFactory.close();
        }
    }
    
    //LEER UN REGISTRO
    public void leerRegistros(){
        try{
            //COMENZAR TRANSACCION
            miSession.beginTransaction();
            //CONSULA HQL
            List<Noticia> registros = miSession.createQuery("from Noticia").getResultList();
            
            for(Noticia cada:registros){
                System.out.println(cada);
            }
            
            //CERRAR CONEXION
            miSession.close();
            
        }finally{
            //PARA CERRAR SIEMPRE 
            miSessionFactory.close();
        }
    }
    
    //INSERTAR UN REGISTRO
    public void insertarRegistro(Noticia p){
        try{
            //COMENZAR TRANSACCION
            miSession.beginTransaction();
            //GUARDAR MI NUEVO OBJETO
            miSession.save(p);
            //HACERLE COMMIT
            miSession.getTransaction().commit();
            
            System.out.println("Resgistro insertado correctamente");
            miSession.close();
            
        }finally{
            //PARA CERRAR SIEMPRE 
            miSessionFactory.close();
        }
    }
    
    //MODIFICAR UN REGISTRO
    public void modificarRegistro(int id, Noticia p){
        try{
            //COMENZAR TRANSACCION
            miSession.beginTransaction();
            
            //OBTENER EL REGISTRO
            Noticia aux=(Noticia)miSession.get(Noticia.class, id);
            
            //MODIFICAR EL OBJETO
            aux.setTitulo(p.getTitulo());
            aux.setTipo(p.getTipo());
            aux.setInformacion(p.getInformacion());
            aux.setFechaN(p.getFechaN());
            aux.setImagen(p.getImagen());
            
            //ACTUALIZAR MI NUEVO OBJETO
            miSession.update(aux);
            //HACERLE COMMIT
            miSession.getTransaction().commit();
            
            System.out.println("Registro modificado correctamente");
            //CERRAR CONEXION
            miSession.close();
            
        }finally{
            //PARA CERRAR SIEMPRE 
            miSessionFactory.close();
        }
    }
    
    //BORRRAR UN REGISTRO
    public void borrarRegistro(int id){
        try{
            //COMENZAR TRANSACCION
            miSession.beginTransaction();
            
            //CONSULA HQL
            String hql = "DELETE FROM Noticia "  + 
             "WHERE id = "+String.valueOf(id);
            //EJECUTAR CONSULA
            miSession.createQuery(hql).executeUpdate();
            
            System.out.println("REGISTRO BORRADO CORRECTAMENTE");
            //CERRAR CONEXION
            miSession.close();
            
        }finally{
            //PARA CERRAR SIEMPRE 
            miSessionFactory.close();
        }
    }
    
    //BORRRAR UN REGISTRO
    public void borrarRegistro2(int id){
        try{
            //COMENZAR TRANSACCION
            miSession.beginTransaction();
            
            //OBTENER EL REGISTRO
            Noticia aux=(Noticia)miSession.get(Noticia.class, id);
            //BORRAR EL REGISTRO
            miSession.delete(aux);
            
            System.out.println("Registro borrado correctamente");
            //CERRAR CONEXION
            miSession.close();
            
        }finally{
            //PARA CERRAR SIEMPRE 
            miSessionFactory.close();
        }
    }
    
    public static void main(String[] args) {
        GestionNoticia g=new GestionNoticia();
        //g.leerRegistro(4);
        //g.leerRegistros();
        //g.insertarRegistro(new Noticia("Nueva","Nueva","Nueva",LocalDate.now().toString(),"D:\\PROGRAMAS\\INFORMATICA\\asfvfaev\\2_DAM"));
        //g.modificarRegistro(4, new Noticia("Nueva","Nueva","Nueva",LocalDate.now().toString(),"D:\\PROGRAMAS\\INFORMATICA\\asfvfaev\\2_DAM"));
        //g.borrarRegistro(3);
    }
}

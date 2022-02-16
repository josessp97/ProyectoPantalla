/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.usuarios;

import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author Equipo
 */
public class GestionUsuario {
    
    private static SessionFactory miSessionFactory;
    private static Session miSession;
    
    public GestionUsuario(){
        //ESTABLECIENDO LA CONFIGURACION A LA SessionFactory
        miSessionFactory=new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Usuario.class).buildSessionFactory();
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
            Usuario aux=(Usuario)miSession.get(Usuario.class, id);
           
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
            List<Usuario> registros = miSession.createQuery("from Usuario").getResultList();
            
            for(Usuario cada:registros){
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
    public void insertarRegistro(Usuario p){
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
    public void modificarRegistro(int id, Usuario p){
        try{
            //COMENZAR TRANSACCION
            miSession.beginTransaction();
            
            //OBTENER EL REGISTRO
            Usuario aux=(Usuario)miSession.get(Usuario.class, id);
            
            //MODIFICAR EL OBJETO
            aux.setNombre(p.getNombre());
            aux.setApellidos(p.getApellidos());
            aux.setEmail(p.getEmail());
            aux.setContrasenia(p.getContrasenia());
            
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
            String hql = "DELETE FROM Usuario "  + 
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
            Usuario aux=(Usuario)miSession.get(Usuario.class, id);
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
        GestionUsuario g=new GestionUsuario();
        //g.leerRegistro(3);
        //g.leerRegistros();
        //g.insertarRegistro(new Usuario("Pepito","Grillo","pepitoGrillo@gmail.com","root"));
        //g.modificarRegistro(3, new Usuario("sdfghnsgfdh","Grillo","abdfbad@gmail.com","adfba"));
        //g.borrarRegistro(3);
    }
}

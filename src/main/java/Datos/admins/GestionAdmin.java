/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.admins;

import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author Equipo
 */
public class GestionAdmin {
    
    private static SessionFactory miSessionFactory;
    private static Session miSession;
    
    public GestionAdmin(){
        //ESTABLECIENDO LA CONFIGURACION A LA SessionFactory
        miSessionFactory=new Configuration().configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Admin.class).buildSessionFactory();
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
            Admin aux=(Admin)miSession.get(Admin.class, id);
           
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
            List<Admin> registros = miSession.createQuery("from Admin").getResultList();
            
            for(Admin cada:registros){
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
    public void insertarRegistro(Admin p){
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
    public void modificarRegistro(int id, Admin p){
        try{
            //COMENZAR TRANSACCION
            miSession.beginTransaction();
            
            //OBTENER EL REGISTRO
            Admin aux=(Admin)miSession.get(Admin.class, id);
            
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
            String hql = "DELETE FROM Admin "  + 
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
            Admin aux=(Admin)miSession.get(Admin.class, id);
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
        GestionAdmin g=new GestionAdmin();
        //g.leerRegistro(7);
        //g.leerRegistros();
        //g.insertarRegistro(new Admin("Pepito","Grillo","pepitoGrillo@gmail.com","root"));
        //g.modificarRegistro(7, new Admin("loooooooooo","loooooooooo","loooooooooo@gmail.com","looooooooo"));
        //g.borrarRegistro(8);
    }
}

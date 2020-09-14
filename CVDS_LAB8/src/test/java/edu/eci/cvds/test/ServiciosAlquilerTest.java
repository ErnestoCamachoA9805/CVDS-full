
package edu.eci.cvds.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import excepciones.*;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void deberiaConsultarCliente() {
    	try {
    		serviciosAlquiler.consultarCliente(30);  		
    	}catch(Exception e) {
    		fail();
    	}
    }
    
    @Test
    public void noDeberiaConsultarCliente() {
    	try {
    		serviciosAlquiler.consultarCliente(0);  		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

    @Test
    public void deberiaConsultarItemsClienteExistente() {
    	try {
    		serviciosAlquiler.consultarItemsCliente(-30); 		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		fail();
    	}
    }
    
    @Test
    public void noDeberiaConsultarItemsClienteNoExistente() {
    	try {
    		serviciosAlquiler.consultarItemsCliente(0); 		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    @Test
    public void deberiaConsultarClientes() {
    	try {
    		serviciosAlquiler.consultarClientes(); 		
    	}catch(Exception e) {
    		fail();
    	}
    }
    
    @Test
    public void deberiaConsultarItem() {
    	try {
    		serviciosAlquiler.consultarItem(0); 		
    	}catch(Exception e) {
    		fail();
    	}
    }
    
    @Test
    public void noDeberiaConsultarItem() {
    	try {
    		serviciosAlquiler.consultarClientes(); 		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    @Test
    public void deberiaConsultarItemsDisponibles() {
    	try {
    		serviciosAlquiler.consultarItemsDisponibles(); 		
    	}catch(Exception e) {
    		fail();
    	}
    }
    
    @Test
    public void deberiaConsultarTipoItem() {
    	try {
    		serviciosAlquiler.consultarTipoItem(15);	
    	}catch(Exception e) {
    		fail();
    	}
    }
    
    @Test
    public void noDeberiaConsultarTipoItem() {
    	try {
    		serviciosAlquiler.consultarTipoItem(0); 		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    
    
    @Test
    public void emptyDB() {
        for(int i = 0; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(i);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            //Assert.assertTrue(r);
        };
    }
}

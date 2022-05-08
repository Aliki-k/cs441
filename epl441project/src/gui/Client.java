package gui;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
public class Client {
	try { 
        // Getting the registry 
        Registry registry = LocateRegistry.getRegistry(null); 
       
     } catch (Exception e) {
        System.err.println("Client exception: " + e.toString()); 
        e.printStackTrace(); 
     } 
}

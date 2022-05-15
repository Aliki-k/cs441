package rmiInterface;


	import java.rmi.Remote;
	import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;



	public interface RmiInterface extends Remote {
	    public void connDB() throws RemoteException;
	    public boolean signUp(int id,String name,String surname,int telephone,String email,String username,String password,String address,int job) throws RemoteException;
	    public int [] signIn(String username,String password,int job) throws RemoteException;
	    public boolean addPatient(String name,String surname,int id,int telephone,String birthday,String address,String allergies) throws RemoteException;
	    public String[] patientSearch1(int id)  throws RemoteException;
	    public Object[] patientSearch2(int id)  throws RemoteException;
	    public int updatePatientRecord(int id,String allergies,String diagnosisNotes,boolean critical,int disorderID,int medicineID,String selfHarmInfo) throws RemoteException;
	    public ArrayList<Object> viewAppointments(int day,int month,int year,int clinicID) throws RemoteException;
	    public void attendAppointment(int id) throws RemoteException;
	    public void addAppointment(String date,String time,String name,String surname,String doctorName,int clinicID) throws RemoteException;
	    public String[] searchMedication(int id) throws RemoteException;
	    public void updatePantientInfo(String name,String surname,int id,int telephone,String address,String birthday,String allergies) throws RemoteException;
	   
	}



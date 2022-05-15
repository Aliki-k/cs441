package rmiServer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import rmiClient.*;
import rmiInterface.RmiInterface;


public class RmiServer implements RmiInterface{
	Connection conn;
	public RmiServer() {
		super();
	}



	@Override
	public void connDB() throws RemoteException {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/epl441";
			String user = "root";
			String pass = "abcd1234";
			conn = DriverManager.getConnection(dbURL,user,pass);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}
			//conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}





	@Override
	public boolean signUp(int id, String name, String surname, int telephone, String email, String username,
			String password, String address, int job) throws RemoteException {
		PreparedStatement ps;
		boolean b=false;
		try {


			ps = conn.prepareStatement("select *from staff where ID=? || Username= ?");
			ps.setInt(1, id);
			ps.setString(2, username);

			ResultSet rs = ps.executeQuery();
			b=rs.next();

			if(!b) {
				ps=conn.prepareStatement("insert into staff (ID,Name,Surname,Telephone,Email,Username,Password,Address,Job) values (?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, surname);
				ps.setInt(4, telephone);
				ps.setString(5, email);
				ps.setString(6, username);
				ps.setString(7, password);
				ps.setString(8, address);
				ps.setInt(9, job);
				ps.executeUpdate();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;

	}



	@Override
	public int[] signIn(String username,String password,int job) {

		PreparedStatement ps;
		boolean b=false;
		int a[]=new int[2];
		try {


			ps = conn.prepareStatement("select *from staff where Username= ? AND Password=? AND Job=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, job);			
			ResultSet rs = ps.executeQuery();
			b=rs.next();
			if(b) {
				a[0]=1;
				ps = conn.prepareStatement("select ClinicID from staff where Username= ?");
				ps.setString(1, username);
				rs = ps.executeQuery();
				rs.next();
				a[1]=rs.getInt(1);
			}
			else
				a[0]=0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;


	}
	public boolean addPatient(String name,String surname,int id,int telephone,String birthday,String address,String allergies) {
		PreparedStatement ps;
		boolean b=false;

		try {
			ps = conn.prepareStatement("select *from patient where ID=?");
			ps.setInt(1, id);


			ResultSet rs = ps.executeQuery();
			b=rs.next();
			if(!b) {
				ps=conn.prepareStatement("insert into patient (ID,Name,Surname,Telephone,Address,Birthday,Allergies,Dead) values (?,?,?,?,?,?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, surname);
				ps.setInt(4, telephone);
				ps.setString(5, address);
				String s[]=birthday.split("/");
				String bd=s[2]+"/"+s[1]+"/"+s[0];
				Date d=new Date(Date.parse(bd));
				ps.setDate(6, d);
				ps.setString(7,allergies);
				ps.setBoolean(8, false);
				ps.executeUpdate();
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return b;
	}
	public String[] patientSearch1(int id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean b=false;
		String s[]=new String[8];
		try {
			ps = conn.prepareStatement("select *from patient where ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			b=rs.next();
			if(b) {
				for(int i=0;i<8;i++)
					s[i]=rs.getString(i+1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public Object[] patientSearch2(int id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Object o[]=new Object[9];
		String s="";
		try {

			ps=conn.prepareStatement("select p.Name,p.Surname,p.ID,p.Allergies,pr.DiagnosisNotes,pr.Critical,pr.DisorderID,pr.MedicineID,pr.SelfHarmInfo from patient p,patientrecord pr where pr.PatientID=? and p.ID=pr.PatientID");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			for(int i=0;i<9;i++)
				o[i]=rs.getObject(i+1);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	public int updatePatientRecord(int id,String allergies,String diagnosisNotes,boolean critical,int disorderID,int medicineID,String selfHarmInfo) {
		int x=0;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {

			ps=conn.prepareStatement("update patientrecord set DiagnosisNotes=?,Critical=?,DisorderID=?,MedicineID=?,SelfHarmInfo=? where PatientID=? ");
			ps.setString(1, diagnosisNotes);
			ps.setBoolean(2, critical);
			ps.setInt(3, disorderID);
			ps.setInt(4, medicineID);
			ps.setString(5, selfHarmInfo);
			ps.setInt(6, id);
			x = ps.executeUpdate();
			ps=conn.prepareStatement("update patient set Allergies=? where ID=?");
			ps.setString(1, allergies);
			ps.setInt(2, id);
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	public ArrayList<Object> viewAppointments(int day,int month,int year,int clinicID) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Object> al=new ArrayList<Object>();
		try {

			ps=conn.prepareStatement("select ID,Date,Time,Attended, Name,Surname,DoctorName from appointment a where a.Date=? and ClinicID=?");
			String s=year+"/"+month+"/"+day;

			ps.setDate(1, new Date(Date.parse(s)));
			ps.setInt(2, clinicID);
			rs = ps.executeQuery();
			while(rs.next()) {
				for(int i=0;i<7;i++) {
					al.add(rs.getObject(i+1));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	public void attendAppointment(int id) {
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {

			ps=conn.prepareStatement("update appointment set Attended=? where ID=? ");
			ps.setBoolean(1, true);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	@Override
	public void addAppointment(String date, String time, String name, String surname, String doctorName,int clinicID){
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {

			ps=conn.prepareStatement("insert into appointment (Date,Time,Name,Surname,DoctorName,Attended,ClinicID) values(?,?,?,?,?,?,?)");
			String s[]=date.split("/");
			String d=s[2]+"/"+s[1]+"/"+s[0];
			ps.setDate(1, new Date(Date.parse(d)));
			ps.setString(2, time);
			ps.setString(3, name);
			ps.setString(4, surname);
			ps.setString(5, doctorName);
			ps.setBoolean(6, false);
			ps.setInt(7, clinicID);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public String[] searchMedication(int id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String s[]=new String[4];
		try {

			ps=conn.prepareStatement("select p.ID,p.Name, p.Surname,m.Name from patientrecord pr,patient p,medicine m where p.ID=? and p.ID=pr.PatientID and m.ID=pr.MedicineID");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				for(int i=0;i<4;i++) {
					s[i]=rs.getString(i+1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	 public void updatePantientInfo(String name,String surname,int id,int telephone,String address,String birthday,String allergies) {
		 PreparedStatement ps=null;
			ResultSet rs=null;

			try {

				ps=conn.prepareStatement("update patient set Name=?,Surname=?,Telephone=?,Address=?,Birthday=?,Allergies=? where ID=? ");
				ps.setString(1, name);
				ps.setString(2, surname);
				ps.setInt(3, telephone);
				ps.setString(4, address);
				String temp[]=birthday.split("/");
				String bd=temp[2]+"/"+temp[1]+"/"+temp[0];
				ps.setDate(5, new Date(Date.parse(bd)));
				ps.setString(6, allergies);
				ps.setInt(7, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		

	 }
	public static void main(String[] args) {
		RmiServer obj = new RmiServer();
		RmiInterface stub;
		try {
			stub = (RmiInterface) UnicastRemoteObject.exportObject(obj, 0);
			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Server", stub);

			System.err.println("Server ready");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}






}

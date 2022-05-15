package rmiClient;

import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import rmiInterface.RmiInterface;

public class Start {
	Connection conn;
	AddAppointment aa;
	AddPatient ap;
	Appointments a; 
	ClinicalStaff cs;
	First f;
	HealthServiceManagement hsm;
	HealthServiceManagementReports hsmr;
	IndividualAppointments ia;
	ListPatientsConditionsTreatments lpct;
	ListPatients lp;
	MedicalRecordStaff mrs;
	PatientHistory ph;
	PatientInformation pi;
	PatientRecord pr;
	PatientSearch_NotUsed psnu;
	PatientSearchClinicalStaff pscs;
	PatientSearchClinicalStaffMore pscsm;
	PatientSearchMedicalRecordStaff psmrs;
	Receptionist r;
	RepeatedPrescriptions rp;
	SearchList sl;
	SelectWeek sw;
	SideEffects se;
	SignIn si;
	SignInClinicalStaff sics;
	SignInHealthServiceManagement sihsm;
	SignInMedicalRecordStaff simrs;
	SignInReceptionist sir;
	SignUp su;
	SignUpClinicalStaff sucs;
	SignUpHealthServiceManagement suhsm;
	SignUpMedicalRecordStaff sumrs;
	SignUpReceptionist sur;
	Transactions t;
	TransactionsSession ts;
	UpdatePatientInfo upi;
	
	Start(){
		aa=new AddAppointment(this);
		ap=new AddPatient(this);
		a=new Appointments(this);
		cs=new ClinicalStaff(this);
		f=new First(this);
		hsm=new HealthServiceManagement(this);
		hsmr=new HealthServiceManagementReports(this);
		ia=new IndividualAppointments(this);
		lpct=new ListPatientsConditionsTreatments(this);
		lp=new ListPatients(this);
		mrs=new MedicalRecordStaff(this);
		ph=new PatientHistory(this);
		pi=new PatientInformation(this);
		pr=new PatientRecord(this);
		psnu=new PatientSearch_NotUsed(this);
		pscs=new PatientSearchClinicalStaff(this);
		pscsm=new PatientSearchClinicalStaffMore(this);
		psmrs=new PatientSearchMedicalRecordStaff(this);
		r=new Receptionist(this);
		rp=new RepeatedPrescriptions(this);
		sl=new SearchList(this);
		sw=new SelectWeek(this);
		se=new SideEffects(this);
		si=new SignIn(this);
		sics=new SignInClinicalStaff(this);
		sihsm=new SignInHealthServiceManagement(this);
		simrs=new SignInMedicalRecordStaff(this);
		sir=new SignInReceptionist(this);
		su=new SignUp(this);
		sucs=new SignUpClinicalStaff(this);
		suhsm=new SignUpHealthServiceManagement(this);
		sumrs=new SignUpMedicalRecordStaff(this);
		sur=new SignUpReceptionist(this);
		t=new Transactions(this);
		ts=new TransactionsSession(this);
		upi=new UpdatePatientInfo(this);
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			RmiInterface stub = (RmiInterface) registry.lookup("Server");
			stub.connDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.toString();
		}
	
		//f.setVisible(true);
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start s=new Start();
					s.f.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

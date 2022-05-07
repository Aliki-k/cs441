package gui;

import java.awt.EventQueue;

public class Start {
	AddAppointment aa;
	AppointmentMore am;
	Appointments a; 
	Clinical c;
	First f;
	HealthServiceManagement hsm;
	HealthServiceManagementReports hsmr;
	IndividualAppointments ia;
	ListPatientsConditionsTreatments lpct;
	ListPatients lp;
	PatientHistory ph;
	PatientInformation pi;
	PatientRecord pr;
	PatientSearch_NotUsed psnu;
	PatientSearchClinicalStaff pscs;
	PatientSearchClinicalStaffMore pscsm;
	PatientSearchReceptionist psr;
	Reception r;
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
	
	Start(){
		aa=new AddAppointment(this);
		am=new AppointmentMore(this);
		a=new Appointments(this);
		c=new Clinical(this);
		f=new First(this);
		hsm=new HealthServiceManagement(this);
		hsmr=new HealthServiceManagementReports(this);
		ia=new IndividualAppointments(this);
		lpct=new ListPatientsConditionsTreatments(this);
		lp=new ListPatients(this);
		ph=new PatientHistory(this);
		pi=new PatientInformation(this);
		pr=new PatientRecord(this);
		psnu=new PatientSearch_NotUsed(this);
		pscs=new PatientSearchClinicalStaff(this);
		pscsm=new PatientSearchClinicalStaffMore(this);
		psr=new PatientSearchReceptionist(this);
		r=new Reception(this);
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

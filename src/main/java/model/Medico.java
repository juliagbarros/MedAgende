package model;

import dao.MedicoDAO;

public class Medico extends Usuario {

	static private Medico Instance = null;
	private String Matricula;
	private String Especialidade;
	private String Crm;
	private String Rqe;
	

	public String getMatricula() {
		return Matricula;
	}
	public String getEspecialidade() {
		return Especialidade;
	}
	public String getCrm() {
		return Crm;
	}
	public String getRqe() {
		return Rqe;
	}

	public void setMatricula(String Mat) {
		Matricula = Mat;
	}
	public void setEspecialidade(String Esp) {
		Especialidade = Esp;
	}
	public void setCrm(String Crm) {
		this.Crm = Crm;
	}
	public void setRqe(String Rqe) {
		this.Rqe = Rqe;
	}
	
	public static void criamedico(String Id) {
		if (Instance == null) {
		try {
			Instance = MedicoDAO.criamedicoconectado(Id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static Medico GetMedico() {
		return Instance;
	}
}

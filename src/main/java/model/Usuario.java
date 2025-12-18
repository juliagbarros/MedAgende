package model;

import java.sql.Date;

public class Usuario {
	
	 	protected int idUsuario;
	    protected String email;
	    protected String senha;
	    protected String nome;
		protected String cpf;
	    protected Date dataNasc;
	    protected String bairro;
	    protected String rua;
	    protected String numCasa;
	    protected String cidade;
	    protected String servico;
	    protected String planoDeSaude;
	    protected String cep;
	    protected String telefone;
		protected String Uf;
	    
	    public Usuario() {
	    }
	    
	    public Usuario(String email, String senha, String nome, String cpf, Date dataNasc, String bairro, 
	                   String rua, String numCasa, String cidade, String servico, String uf,
	                   String planoDeSaude, String cep, String telefone) {
	        this.email = email;
	        this.senha=senha;
	        this.nome = nome;
	        this.cpf=cpf;
	        this.dataNasc = dataNasc;
	        this.bairro = bairro;
	        this.rua = rua;
	        this.numCasa = numCasa;
	        this.cidade = cidade;
	        this.servico = servico;
	        this.planoDeSaude = planoDeSaude;
	        this.cep = cep;
	        this.telefone=telefone;
	        this.Uf=uf;
	    }

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public int getIdUsuario() {
	        return idUsuario;
	    }
	    
	    public void setIdUsuario(int idUsuario) {
	        this.idUsuario = idUsuario;
	    }
	    
	    public String getEmail() {
	        return email;
	    }
	    
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
		public String getSenha() {
			return senha;
		}
		
		public void setSenha(String senha) {
			 this.senha=senha;		}
		
	   
	    public String getNome() {
	        return nome;
	    }
	    
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    
		public String getCpf() {
			return cpf;
		}
		
		public void setCPF (String cpf) {
			this.cpf=cpf;
		}


	    public Date getDataNasc() {
	        return dataNasc;
	    }
	    
	    public void setDataNasc(java.util.Date dataNasc) {
	        if (dataNasc != null) {
	            this.dataNasc = new java.sql.Date(dataNasc.getTime());
	        } else {
	            this.dataNasc = null;
	        }
	    }
	    
	    public String getBairro() {
	        return bairro;
	    }
	    
	    public void setBairro(String bairro) {
	        this.bairro = bairro;
	    }
	    
	    public String getRua() {
	        return rua;
	    }
	    
	    public void setRua(String rua) {
	        this.rua = rua;
	    }
	    
	    public String getNumCasa() {
	        return numCasa;
	    }
	    
	    public void setNumCasa(String numCasa) {
	        this.numCasa = numCasa;
	    }
	    
	    public String getCidade() {
	        return cidade;
	    }
	    
	    public void setCidade(String cidade) {
	        this.cidade = cidade;
	    }
	    
	    public String getServico() {
	        return servico;
	    }
	    
	    public void setServico(String servico) {
	        this.servico = servico;
	    }
	    
	    public String getPlanoDeSaude() {
	        return planoDeSaude;
	    }
	    
	    public void setPlanoDeSaude(String planoDeSaude) {
	        this.planoDeSaude = planoDeSaude;
	    }
	    
	    public String getCep() {
	        return cep;
	    }
	    
	    public void setCep(String cep) {
	        this.cep = cep;
	    }
	    

		public String getTelefone() {
			// TODO Auto-generated method stub
			return telefone;
		}
		
		public void setTelefone(String telefone) {
			this.telefone=telefone;
		}

		public String getUf() {
			return Uf;
		}

		public void setUf(String uf) {
			Uf = uf;
		}
		
	


}
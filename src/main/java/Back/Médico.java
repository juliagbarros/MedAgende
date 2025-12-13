package Back;

import model.Usuario;
import java.sql.Date;

public class Médico extends Usuario {
    private String CRM;
    private String RQE;
    private String especialidade;

    public Médico() {
        super();
    }

    public Médico(String email, String senha, String nome, String cpf, Date dataNasc, String bairro,
            String rua, String numCasa, String cidade, String servico, String planoDeSaude, String cep,
            String telefone, String CRM, String RQE, String especialidade) {
        super(email, senha, nome, cpf, dataNasc, bairro, rua, numCasa, cidade, servico, planoDeSaude, cep, telefone);
        this.CRM = CRM;
        this.RQE = RQE;
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String cRM) {
        CRM = cRM;
    }

    public String getRQE() {
        return RQE;
    }

    public void setRQE(String rQE) {
        RQE = rQE;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
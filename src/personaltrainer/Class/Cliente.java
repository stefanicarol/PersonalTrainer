package personaltrainer.Class;
/**
 * @author Stéfani Carol A. A. G. Souza
 * @email stefanicarol@gmail.com
 */
public class Cliente {
   private String cpf, nome, telefone;

    public Cliente() {
    }

    public Cliente(String Cpf, String nome, String telefone) {
        this.cpf = Cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String Cpf) {
        this.cpf = Cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "NOME: " + nome + ", CPF: " + cpf + ", TELEFONE: " + telefone;
    }
}

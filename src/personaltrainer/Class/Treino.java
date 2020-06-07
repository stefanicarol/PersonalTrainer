package personaltrainer.Class; 
/**
 * @author Stéfani Carol A. A. G. Souza
 * @email stefanicarol@gmail.com
 */
public abstract class Treino{
    private int numero;
    private String categoria;
    private String horario;
    private double valorFixo;

    public Treino() {
    }
 
    public Treino(int numero, String categoria, String horario, double valorFixo) {
        this.numero = numero;
        this.categoria = categoria;
        this.horario = horario;
        this.valorFixo = valorFixo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getValorFixo() {
        return valorFixo;
    }

    public void setValorFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    public abstract double ValorSemanal(String categoria); 
    public void addClientes(Cliente cliente) {} 
    @Override
    public String toString() {
        return "Treino{" + "numero=" + numero + ", categoria=" + categoria + ", horario=" + horario + ", valorFixo=" + valorFixo + '}';
    }  
}

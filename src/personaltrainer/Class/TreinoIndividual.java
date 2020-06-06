package personaltrainer.Class;
/**
 * @author Stéfani Carol A. A. G. Souza
 * @email stefanicarol@gmail.com
 */
public class TreinoIndividual extends Treino{
    private Cliente cliente;

    public TreinoIndividual() {
    }

    public TreinoIndividual(Cliente cliente, int numero, String categoria, String horario, double valorFixo) {
        super(numero, categoria, horario, valorFixo);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
      
    @Override
    public double ValorSemanal(String categoria) {
        if(super.getCategoria().equalsIgnoreCase("A")){ 
            return super.getValorFixo()*2;
        }else{
            return super.getValorFixo()*3;
        } 
    }

    @Override
    public String toString() {
        return super.toString()+" Cliente: " + cliente;
    } 
}

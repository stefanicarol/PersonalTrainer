package personaltrainer.Class; 
import java.util.ArrayList;
/**
 * @author Stéfani Carol A. A. G. Souza
 * @email stefanicarol@gmail.com
 */
public class TreinoGrupo extends Treino{
    private ArrayList<Cliente> clientes;

    public TreinoGrupo() {
        clientes = new ArrayList();
    }
 
    public TreinoGrupo(int numero, String categoria, String horario, double valorFixo) {
        super(numero, categoria, horario, valorFixo);
        clientes = new ArrayList();
    }

    public TreinoGrupo(int numero, String categoria, String horario, double valorFixo, ArrayList<Cliente> clientes) {
        super(numero, categoria, horario, valorFixo);
        this.clientes = clientes;
    } 
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
     
    public void addClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }  
     
    @Override
    public double ValorSemanal(String categoria) {
        if(super.getCategoria().equalsIgnoreCase("A")){ 
            return (super.getValorFixo())*2/clientes.size();
        }else{
            return (super.getValorFixo()*3/clientes.size());
        } 
    }

    @Override
    public String toString() {
        return super.toString() + "Clientes: " + clientes;
    } 
}

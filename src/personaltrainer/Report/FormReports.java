package personaltrainer.Report;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import personaltrainer.Class.Cliente;
import personaltrainer.Class.Treino;
import personaltrainer.Class.TreinoGrupo;
import personaltrainer.Class.TreinoIndividual;

/**
 * @author Stéfani Carol A. A. G. Souza
 * @email stefanicarol@gmail.com
 */
public class FormReports extends javax.swing.JInternalFrame {

   ArrayList<Treino> treino;
   ArrayList<Cliente> cliente;
   
    public FormReports() {
        initComponents();
        tfNum.setEnabled(false);
    }
 
    public FormReports(ArrayList<Cliente> cliente, ArrayList<Treino> treino) { 
       initComponents();
       this.cliente = cliente;
       this.treino = treino; 
       tfNum.setEnabled(false);
    }
  /*
    MÉTODO QUE LISTA O VALOR SEMANAL QUE CADA CLIENTE IRÁ PAGAR DE ACORDO COM A CATEGORIA ESCOLHIDA NA HORA DO CADASTRO DA TURMA. 
    AO SELECIONAR O "VALOR SEMANAL" DEVERÁ SER INFORMADO NÚMERO DA TURMA... SE FOR TURMA INDIVIDUAL, SERÁ MOSTRADO O VALOR QUE O CLIENTE 
    IRÁ PAGAR PODE SEMANA, SE FOR TURMA DE GRUPO, IRÁ MOSTRAR O VALOR DE CADA INTEGRANTE DA TURMA IRÁ PAGAR SEMANALEMENTE.
 */
    public void taxaSemanal(){ 
    try{
        taSaida.setText("");
        for(Treino t: treino){  
            if(t instanceof TreinoGrupo){ 
                if(t.getNumero()==Integer.parseInt(tfNum.getText())){ 
                    String a = t.getCategoria();
                    taSaida.append( "TREINO EM GRUPO - VALOR POR CLIENTE: Categoria "+t.getCategoria()+" \n"); 
                        for(int i = 0; i<((TreinoGrupo) t).getClientes().size();i++){
                            taSaida.append((((TreinoGrupo) t).getClientes().get(i).getNome().toString()));
                            taSaida.append(" R$ "+ t.ValorSemanal(a)+""+" \n"); 
                        } 
                   } 
              } else if(t instanceof TreinoIndividual){ 
                if(t.getNumero()==Integer.parseInt(tfNum.getText())){ 
                    String a = t.getCategoria();
                    taSaida.append( "TREINO INDIVIDUAL: Categoria "+t.getCategoria()+" \n"); 
                    taSaida.append((((TreinoIndividual) t).getCliente().getNome()));
                    taSaida.append(" R$ "+ t.ValorSemanal(a)+""+" \n"); 
                   } 
              } 
         } 
       }catch (Exception exe) {
          JOptionPane.showMessageDialog(null, "INSIRA O NÚMERO DA TURMA");
           System.out.println(exe); 
      }
    }
      
    /*
      LISTA AS INFORMAÇÕES DE TODOS OS CLIENTES CADASTRADOS
    */
    
    public void listaClientes(){
        taSaida.setText("");
        taSaida.append( "CLIENTES:"+" \n"); 
      for(Cliente c: cliente){ 
          taSaida.append(c.toString()+" \n"); 
       }  
    }
   
    
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfNum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        rbSemanal = new javax.swing.JRadioButton();
        rbClientes = new javax.swing.JRadioButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("REPORTS");

        jLabel2.setText("Turma:");

        taSaida.setColumns(20);
        taSaida.setRows(5);
        jScrollPane1.setViewportView(taSaida);

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSemanal);
        rbSemanal.setText("Valor Semanal");
        rbSemanal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSemanalActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbClientes);
        rbClientes.setText("Lista de Clientes");
        rbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rbSemanal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbClientes))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbSemanal)
                            .addComponent(rbClientes))
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))
                        .addGap(23, 23, 23)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(rbSemanal.isSelected()){
           taxaSemanal();
      }else if(rbClientes.isSelected()){
           listaClientes();
      } else{
             JOptionPane.showMessageDialog(null, "SELECIONE UMA OPÇÃO");
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClientesActionPerformed
        tfNum.setEnabled(false);
    }//GEN-LAST:event_rbClientesActionPerformed

    private void rbSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSemanalActionPerformed
        tfNum.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_rbSemanalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbClientes;
    private javax.swing.JRadioButton rbSemanal;
    private javax.swing.JTextArea taSaida;
    private javax.swing.JTextField tfNum;
    // End of variables declaration//GEN-END:variables
}

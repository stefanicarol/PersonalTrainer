package personaltrainer.Form;
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
public class FormTreinos extends javax.swing.JInternalFrame {
   ArrayList<Treino> treino;
   ArrayList<Cliente> cliente;
   
    Treino treinoGlobal;
   
    public FormTreinos() { 
        initComponents(); 
        cbxIn();
    }

    FormTreinos(ArrayList<Treino> treino, ArrayList<Cliente> cliente) { 
       initComponents();
       this.cliente = cliente;
       this.treino = treino; 
       cbxIn();
    }
    
    /* METÓDOS DE PREENCHER COMBBOX */
     public void cbxIn(){   
        cbxCliente.removeAllItems();
        for(Cliente p : cliente){  
           cbxCliente.addItem(p.getNome());  
       } 
    }
     
    public void cbxCliente(){ 
        cbxCliente.removeAllItems();
        for(Cliente p : cliente){  
           for(Object t : treino){
            if(t instanceof TreinoGrupo){
                if(((TreinoGrupo) t).getClientes().contains(p)){
                    System.out.println("cliente já possui turma -- remover da cbx"); 
                }else{
                    cbxCliente.addItem(p.getNome());  
                }
             }
          }
       } 
     }
   
     /* METÓDOS CADASTRO DE TREINO, INDIVIDUAL E GRUPO */
     public void cadastrarTreinoIndividual(){  
      try{
          if(existeTreino(Integer.parseInt(tfNumero.getText()))== null){
              Cliente c = null;    
              int n = Integer.parseInt(tfNumero.getText());
              double v = Double.parseDouble(tfValor.getText());
              String h = tfHorario.getText(); 
              for(Cliente t: cliente){ 
                  if(t.getNome().equals(cbxCliente.getSelectedItem())){
                         c = t;
                     if(btA.isSelected()){
                         treino.add(new TreinoIndividual(c, n, "A", h, v));  
                     }else{
                         treino.add(new TreinoIndividual(c, n, "B", h, v));
                     }
                        JOptionPane.showMessageDialog(null, "TREINO INDIVIDUAL CADASTRADO!");
                        limpar();
                        System.out.println(treino); 
                     }
                  }  
           }else{
               JOptionPane.showMessageDialog(null, "Já existe treino com esse código!");
          } 
         }catch (Exception exe) {
          JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
          System.out.println(exe); 
       }
     } 
     
     public void cadastrarTreinoGrupo(){ 
       try{
            if(existeTreino(Integer.parseInt(tfNumero.getText()))== null){ 
                  int n = Integer.parseInt(tfNumero.getText());
                  double v = Double.parseDouble(tfValor.getText());
                  String h = tfHorario.getText();
                  if(btA.isSelected()){
                     treino.add(new TreinoGrupo(n, "A", h, v)); 
                 }else{
                     treino.add(new TreinoGrupo(n, "B", h, v));
                 }
                   JOptionPane.showMessageDialog(null, "TREINO EM GRUPO CADASTRADO, AGORA INSIRA ATÉ 5 CLIENTES");
                   System.out.println(treino);
              }else{
                   JOptionPane.showMessageDialog(null, "Já existe treino com esse código!");
              } 
         }catch(Exception exe){
          JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
          System.out.println(exe); 
       }
     }  
     
   /* METÓDO DE INSERIR CLIENTE NO TREINO DE GRUPO */
     public void inserirCliente(){ 
       Cliente nome = null;  
       for(Cliente n : cliente){  
          if(n.getNome().equals(cbxCliente.getSelectedItem())){ 
               nome = n; 
          } 
       }
       for(Object p : treino){
          if(p instanceof TreinoGrupo){
             if(((TreinoGrupo) p).getNumero()== (Integer.parseInt(tfNumero.getText()))){
                 if((((TreinoGrupo) p).getClientes().size()<5)){ 
                      ((TreinoGrupo)p).addClientes(nome);
                      JOptionPane.showMessageDialog(null, "Cliente "+((TreinoGrupo) p).getClientes().size()+" inserido com sucesso, insira o próximo!");
                      System.out.println(treino);  
                      cbxCliente();
                 }else{
                     JOptionPane.showMessageDialog(null,"Quantidade máxima de clientes nessa turma.");  
                     limpar();
                 }
             } 
          }    
       } 
    }   
     
   /* METÓDO PARA VERIFICAR JÁ EXISTE TREINO COM O NÚMERO CADASTRADO */
   public Treino existeTreino(int n){
        for(Treino t : treino){
            if(t.getNumero() == Integer.parseInt(tfNumero.getText())){
                return t;
            }
        }
       return null;
   }  

   /* MÉTODO DE PESQUISAR */
   public void Pesquisar(){
    taSaida.setText(""); 
    treinoGlobal = existeTreino(Integer.parseInt(tfNumero.getText()));
    if (treinoGlobal != null){
        for(Treino t: treino){ 
         if(t instanceof TreinoIndividual){ 
            if(t.getNumero() == Integer.parseInt(tfNumero.getText())){
               btIndividual.setSelected(true);
               tfNumero.setText(t.getNumero()+"");
               tfHorario.setText(t.getHorario());
               tfValor.setText(t.getValorFixo()+"");
               cbxCliente.removeAllItems();
               cbxCliente.addItem(((TreinoIndividual)t).getCliente().getNome());
               if(t.getCategoria().equals("A")){
                   btA.setSelected(true);
               }else{
                  btB.setSelected(true);
               }
             } 
          }else if(t instanceof TreinoGrupo){
              if(t.getNumero() == Integer.parseInt(tfNumero.getText())){
               btGrupo.setSelected(true);
               tfNumero.setText(t.getNumero()+"");
               tfHorario.setText(t.getHorario());
               tfValor.setText(t.getValorFixo()+"");
               cbxCliente.removeAllItems();
               cbxCliente.addItem("...");
               taSaida.append("Clientes: \n");
               for(int i = 0; i<((TreinoGrupo) t).getClientes().size();i++){
                    taSaida.append((((TreinoGrupo) t).getClientes().get(i).getNome().toString())+"\n");
               }
                
               if(t.getCategoria().equals("A")){
                   btA.setSelected(true);
               }else{
                  btB.setSelected(true);
               }
               
             }  
          }
        }
    }else{
          JOptionPane.showMessageDialog(null, "Treino não foi cadastrado!!!");
        }
    }
   
   public void limpar(){
    buttonGroup1.clearSelection();
    buttonGroup2.clearSelection();
    buttonGroup3.clearSelection();
    cbxCliente.removeAllItems(); 
    tfHorario.setText(""); 
    tfNumero.setText(""); 
    tfValor.setText(""); 
    taSaida.setText(""); 
   }
   public void limparInserir(){
    buttonGroup1.clearSelection();
    buttonGroup2.clearSelection();
    buttonGroup3.clearSelection();
    cbxCliente.removeAllItems(); 
    tfHorario.setText("");  
    tfValor.setText(""); 
    taSaida.setText(""); 
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        btIndividual = new javax.swing.JRadioButton();
        btGrupo = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        tfHorario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btB = new javax.swing.JRadioButton();
        btA = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbxCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("TURMA");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Número:");

        jLabel4.setText("Valor Fixo R$:");

        buttonGroup1.add(btIndividual);
        btIndividual.setText("Individual");
        btIndividual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btIndividualMouseClicked(evt);
            }
        });
        btIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIndividualActionPerformed(evt);
            }
        });

        buttonGroup1.add(btGrupo);
        btGrupo.setText("Grupo");
        btGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrupoActionPerformed(evt);
            }
        });

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfHorario.setText(" ");

        jLabel5.setText("Horário:");

        buttonGroup3.add(btB);
        btB.setText("B");

        buttonGroup3.add(btA);
        btA.setText("A");

        jLabel6.setText("Categoria:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfHorario)
                                .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btIndividual)
                        .addGap(18, 18, 18)
                        .addComponent(btGrupo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btB)
                            .addComponent(btA))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(btA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btB))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btIndividual)
                            .addComponent(btGrupo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        jButton2.setText("Inserir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxCliente, 0, 264, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(53, 53, 53))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton4.setText("Pesquisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        taSaida.setColumns(20);
        taSaida.setRows(5);
        jScrollPane1.setViewportView(taSaida);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed
     
    }//GEN-LAST:event_cbxClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(btIndividual.isSelected()){ 
          cadastrarTreinoIndividual();
       }else{
         cadastrarTreinoGrupo();
         limparInserir();
         cbxCliente();
       }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
          inserirCliente(); 
          limparInserir();
          cbxCliente();
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIndividualActionPerformed
       // limpar();
        cbxIn();    
     }//GEN-LAST:event_btIndividualActionPerformed

    private void btIndividualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btIndividualMouseClicked
     }//GEN-LAST:event_btIndividualMouseClicked

    private void btGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrupoActionPerformed
       
     }//GEN-LAST:event_btGrupoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        buttonGroup1.clearSelection();
        cbxCliente();
        Pesquisar();  
            
            
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btA;
    private javax.swing.JRadioButton btB;
    private javax.swing.JRadioButton btGrupo;
    private javax.swing.JRadioButton btIndividual;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSaida;
    private javax.swing.JTextField tfHorario;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables

}

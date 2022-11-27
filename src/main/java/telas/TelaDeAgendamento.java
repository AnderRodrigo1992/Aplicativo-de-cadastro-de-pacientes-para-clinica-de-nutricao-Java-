package telas;
import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import net.proteanit.sql.DbUtils;

public class TelaDeAgendamento extends javax.swing.JInternalFrame {
   
   Connection conn ;
   PreparedStatement pstm ;
   ResultSet rs ;
   Date data = new Date();
   DateFormat Mudarhora = DateFormat.getDateInstance(DateFormat.LONG );
   
   
         
  
private void formatarCampos(){
       try {
           MaskFormatter mask = new MaskFormatter("##/##/####");
          mask.install(txtDia);
           
           
       } catch (ParseException ex) {
           Logger.getLogger(TelaDeAgendamento.class.getName()).log(Level.SEVERE, null, ex);
       }
      try {
           MaskFormatter mask2 = new MaskFormatter("##:##");
           mask2.install(txtHora);
           
           
       } catch (ParseException ex) {
           Logger.getLogger(TelaDeAgendamento.class.getName()).log(Level.SEVERE, null, ex);
       }


}

  
   
    private void Adicionar(){
    
    String sql = "insert into agenda (Paciente,Nutricionista,Dia,hora,notas) values(?,?,?,?,?)";
         
        try {     
                         
            pstm = conn.prepareStatement(sql);
            pstm.setString(2, comboNutri.getSelectedItem().toString());
            pstm.setString(1, txtPaciente.getText());
            pstm.setString(3, txtDia.getText());
            pstm.setString(4, txtHora.getText());
            pstm.setString(5, txtNotas.getText());
                     
            
               if ((txtPaciente.getText().isEmpty()) ||
                (txtDia.getText().isEmpty()) ||              
               (txtHora.getText().isEmpty()) )
            
            
            
            {JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios , são os campos marcados com *");                    
              
            } else {                   
                 int adicionado =   pstm.executeUpdate();                     
                     
          
            if (adicionado > 0) {
            JOptionPane.showMessageDialog(null,"Agenda Cadastrada com sucesso ");
             
           //Limpa os campos após cadastrar um usuário 
            limpar_campos();
                             
           } 
            
                } 
        }
        
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Adicionar ");
        }
       
   
   
   
     }

   private void Alterar(){
    
    String sql = "update agenda set Paciente = ?,Nutricionista =?,Dia=?,hora = ?, notas = ? where iDagenda = ?";
          
    try {
        
        pstm = conn.prepareStatement(sql);
            
           
            pstm.setString(1, txtPaciente.getText());
            pstm.setString(2, comboNutri.getSelectedItem().toString());
            pstm.setString(3, txtDia.getText());
            pstm.setString(4, txtHora.getText());         
            pstm.setString(5, txtNotas.getText());
            pstm.setString(6, txtAgenda.getText());
            
            
               if ((txtPaciente.getText().isEmpty()) ||
               
               (txtDia.getText().isEmpty()) ||
               (txtHora.getText().isEmpty()) 
                                   )
                      
            
            {JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios , são os campos marcados com *");                    
              
            } else {                   
            int adicionado =   pstm.executeUpdate();                     
                     
          
            if (adicionado > 0) {
            JOptionPane.showMessageDialog(null,"Agenda Alterada Com Sucesso ");
             
           //Limpa os campos após cadastrar um usuário 
             limpar_campos();
                             
           } 
            
                } 
        
            
        
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null,"Erro Metodo Alterar ");

    }


   }
   
   private void Excluir(){

 int confirma = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR ESSA AGENDA?","atenção",JOptionPane.YES_NO_OPTION);
 
    
    if (confirma == JOptionPane.YES_OPTION){
    
         String sql = "delete from Agenda where idAgenda = ? ";
        
 try {
        
        pstm = conn.prepareStatement(sql);
                               
            pstm.setString(1, txtAgenda.getText());
            int apagado = pstm.executeUpdate();
            
            if (apagado > 0){
             
             JOptionPane.showMessageDialog(null,"Agenda Removida com sucesso");
            limpar_campos();
            
            }
            


 }
    
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Excluir");
        }



    }}
    
   
    private void combo(){
        
     String sql ="select nome from Nutricionista ";
        try {
        pstm = conn.prepareStatement(sql);
        rs= pstm.executeQuery();
         while(rs.next())  
            { 
           
                comboNutri.addItem(rs.getString("nome"));  
            }  
            
          } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro combo");
    }}
   
 /*  private void pesquisarPaciente(){
   
       String sql = "select idPaciente as ID , nome as Nome, cpf as Cpf from Paciente where nome like ?";

    try {
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,txtPesquisa.getText() + "%");
        rs = pstm.executeQuery();
        tlbTable.setModel(DbUtils.resultSetToTableModel(rs)
        );    
                
    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro Metodo Pesquisar");
    }
   }
*/
    
    private void pesquisarAgenda(){
   
       String sql = "select * from agenda where  Dia like ?";

    try {
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,txtPesquisa1.getText() + "%");
        rs = pstm.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs)
        );    
                
    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro Metodo Pesquisar");
    }
   }
   
 private void setar_campos(){
  int setar = jTable1.getSelectedRow();
             txtAgenda.setText(jTable1.getModel().getValueAt(setar,0 ).toString());
             comboNutri.setSelectedItem(jTable1.getModel().getValueAt(setar,2 ).toString());
             txtPaciente.setText(jTable1.getModel().getValueAt(setar,1 ).toString()); 
             txtDia.setText(jTable1.getModel().getValueAt(setar,3 ).toString());
             txtHora.setText(jTable1.getModel().getValueAt(setar,4 ).toString());
             txtNotas.setText(jTable1.getModel().getValueAt(setar,5 ).toString());
  }
     
     
     
     
     
     
     private void limpar_campos(){
    
             txtDia.setText(null);
             txtPaciente.setText(null);
             txtNotas.setText(null);
             txtPesquisa1.setText(null);
             txtHora.setText(null);
             txtAgenda.setText(null);
             ((DefaultTableModel)jTable1.getModel()).setRowCount(0);

} 
     
     
     
     
     
    public TelaDeAgendamento() {
        initComponents();
        conn = Conexao.conectabd();
            combo();
            formatarCampos() ;   
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtAgenda = new javax.swing.JTextField();
        comboNutri = new javax.swing.JComboBox<>();
        txtDia = new javax.swing.JFormattedTextField();
        txtHora = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNotas = new javax.swing.JTextField();
        txtPesquisa1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1269, 654));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Paciente:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Hora:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nutricionista:");

        btnAdicionar.setForeground(new java.awt.Color(0, 0, 0));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setForeground(new java.awt.Color(0, 0, 0));
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setForeground(new java.awt.Color(255, 0, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("ID Agenda");

        txtAgenda.setEnabled(false);
        txtAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgendaActionPerformed(evt);
            }
        });

        comboNutri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNutriActionPerformed(evt);
            }
        });

        txtDia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Anotações:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(txtPaciente))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(50, 50, 50)
                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(166, 166, 166))
                                    .addComponent(comboNutri, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(201, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboNutri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAdicionar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        txtPesquisa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisa1KeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idAgenda", "Paciente", "Nutricionista", "Dia", "hora"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel6.setText("Pesquise a data do agendamento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel6)))
                .addContainerGap(497, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisa1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisa1KeyReleased
pesquisarAgenda();
    }//GEN-LAST:event_txtPesquisa1KeyReleased

    private void txtAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgendaActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
Adicionar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
setar_campos();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
Alterar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void comboNutriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNutriActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_comboNutriActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
Excluir();        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> comboNutri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAgenda;
    private javax.swing.JFormattedTextField txtDia;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtNotas;
    private javax.swing.JTextField txtPaciente;
    private javax.swing.JTextField txtPesquisa1;
    // End of variables declaration//GEN-END:variables
}

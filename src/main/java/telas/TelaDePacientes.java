
package telas;
import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class TelaDePacientes extends javax.swing.JInternalFrame {
 
    Connection conn ;
   PreparedStatement pstm ;
   ResultSet rs ;
   
   private void Adicionar(){
    
    String sql = "insert into Paciente (nome,idade,cpf,cidade,uf,endereço,telefone,sexo) values(?,?,?,?,?,?,?,?)";
         
        try {     
                         
            pstm = conn.prepareStatement(sql);
            
        
            pstm.setString(1, txtNome.getText());
            pstm.setString(2, txtIdade.getText());
            pstm.setString(3, txtCpf.getText());
            pstm.setString(4, txtCidade.getText());
            pstm.setString(5, txtUf.getText());
            pstm.setString(6, txtEndereço.getText()); 
            pstm.setString(7, txtTelefone.getText());
            pstm.setString(8, txtSexo.getSelectedItem().toString());
            
               if ((txtNome.getText().isEmpty()) ||
               (txtCpf.getText().isEmpty()) ||
               (txtEndereço.getText().isEmpty()) ||              
               (txtIdade.getText().isEmpty())||
               (txtTelefone.getText().isEmpty())||
               (txtCidade.getText().isEmpty())||
               (txtUf.getText().isEmpty())    )
            
            
            
            {JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios , são os campos marcados com *");                    
              
            } else {                   
                 int adicionado =   pstm.executeUpdate();                     
                     
          
            if (adicionado > 0) {
            JOptionPane.showMessageDialog(null,"Usuario Cadastrado com sucesso ");
             
           //Limpa os campos após cadastrar um usuário 
            limpar_campos();
                             
           } 
            
                } 
        }
        
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Adicionar ");
        }
       
   
   
   
     }

  /* private void Buscar()   {

String sql = "select * from Paciente where idPaciente = ?";
         
        try {     
                         
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,txtId.getText());
           
            rs= pstm.executeQuery();
            
                if (rs.next()){
            txtNome.setText(rs.getString(2));
            txtIdade.setText(rs.getString(3));
            txtCpf.setText(rs.getString(4));
            txtCidade.setText(rs.getString(5));
            txtUf.setText(rs.getString(6));
            txtEndereço.setText(rs.getString(7));
            txtTelefone.setText(rs.getString(8)); 
            
            
                         }
            else{
            JOptionPane.showMessageDialog(null," Usuário não cadastrado ");
             
             limpar_campos();
            }


        }
 catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Buscar ");
        }


}
   */
   private void Alterar(){
    
    String sql = "update Paciente set nome = ?, idade = ?,cpf =?,cidade=?,uf = ?,endereço = ?,telefone = ?, sexo = ? where idPaciente = ?";
          
    try {
        
        pstm = conn.prepareStatement(sql);
            
           
            pstm.setString(1, txtNome.getText());
            pstm.setString(2, txtIdade.getText());
            pstm.setString(3, txtCpf.getText());
            pstm.setString(4, txtCidade.getText());
            pstm.setString(5, txtUf.getText());
            pstm.setString(6, txtEndereço.getText()); 
            pstm.setString(7, txtTelefone.getText());           
            pstm.setString(8, txtSexo.getSelectedItem().toString());
            pstm.setString(9, txtId.getText());

            
            
               if ((txtNome.getText().isEmpty()) ||
               (txtCpf.getText().isEmpty()) ||
               (txtEndereço.getText().isEmpty()) ||
               (txtId.getText().isEmpty()) ||
               (txtIdade.getText().isEmpty())||
               (txtTelefone.getText().isEmpty())||
               (txtCidade.getText().isEmpty())||
               (txtUf.getText().isEmpty())                    )
                      
            
            {JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios , são os campos marcados com *");                    
              
            } else {                   
            int adicionado =   pstm.executeUpdate();                     
                     
          
            if (adicionado > 0) {
            JOptionPane.showMessageDialog(null,"Usuario Alterado Com Sucesso ");
             
           //Limpa os campos após cadastrar um usuário 
             limpar_campos();
                             
           } 
            
                } 
        
            
        
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null,"Erro Metodo Alterar ");

    }


   }
   
   private void Excluir(){

 int confirma = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR ESSE PACIENTE?","atenção",JOptionPane.YES_NO_OPTION);
 
    
    if (confirma == JOptionPane.YES_OPTION){
    
         String sql = "delete from Paciente where idPaciente = ? ";
        
 try {
        
        pstm = conn.prepareStatement(sql);
                               
            pstm.setString(1, txtId.getText());
            int apagado = pstm.executeUpdate();
            
            if (apagado > 0){
             
             JOptionPane.showMessageDialog(null,"Usuário Removido com sucesso");
             limpar_campos();
             
            }
            


 }
    
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Excluir");
        }




}}

   private void Pesquisar(){
    
    String sql = "select * from Paciente where nome like ?";

    try {
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,txtPesquisar.getText() + "%");
        rs = pstm.executeQuery();
        tblPaciente.setModel(DbUtils.resultSetToTableModel(rs));
        

        
        
    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro Metodo Pesquisar");

    }
   
}

   private void setar_campos(){
  int setar = tblPaciente.getSelectedRow();
             txtId.setText(tblPaciente.getModel().getValueAt(setar,0 ).toString());
             txtNome.setText(tblPaciente.getModel().getValueAt(setar,1 ).toString());
             txtIdade.setText(tblPaciente.getModel().getValueAt(setar,2 ).toString()); 
             txtCpf.setText(tblPaciente.getModel().getValueAt(setar,3 ).toString());
             txtCidade.setText(tblPaciente.getModel().getValueAt(setar,4 ).toString());
             txtUf.setText(tblPaciente.getModel().getValueAt(setar,5 ).toString());
             txtEndereço.setText(tblPaciente.getModel().getValueAt(setar,6 ).toString());
             txtTelefone.setText(tblPaciente.getModel().getValueAt(setar,7 ).toString());
  }
     
   private void limpar_campos(){
    
             txtCidade.setText(null);
             txtCpf.setText(null);
             txtEndereço.setText(null);
             txtId.setText(null);
             txtIdade.setText(null);
             txtNome.setText(null);
             txtTelefone.setText(null);
             txtUf.setText(null);
             ((DefaultTableModel)tblPaciente.getModel()).setRowCount(0);


}
    

    public TelaDePacientes() {
        initComponents();
        conn = Conexao.conectabd();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtUf = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JToggleButton();
        txtEndereço = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAlterar = new javax.swing.JButton();
        txtExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel8.setText("*TELEFONE:");

        txtId.setEnabled(false);

        txtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeActionPerformed(evt);
            }
        });

        btnAdicionar.setForeground(new java.awt.Color(0, 0, 0));
        btnAdicionar.setText("ADICIONAR");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel9.setText("*ENDEREÇO");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Campos obrigatórios estão marcados com *");

        txtAlterar.setForeground(new java.awt.Color(0, 0, 0));
        txtAlterar.setText("ALTERAR");
        txtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlterarActionPerformed(evt);
            }
        });

        txtExcluir.setForeground(new java.awt.Color(255, 0, 0));
        txtExcluir.setText("EXCLUIR");
        txtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText("*NOME:");

        tblPaciente = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idPaciente", "nome", "Idade", "cpf", "cidade", "uf", "endereço", "telefone", "sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaciente);

        jLabel2.setText(" *ID :");

        jLabel3.setText("*IDADE:");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel4.setText("*CPF:");

        jLabel5.setText("*UF:");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("PESQUISAR PACIENTE");

        jLabel6.setText("*CIDADE :");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("CADASTRO DE PACIENTES");

        txtSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel12.setText("Sexo:");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtEndereço, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtIdade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(txtAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(txtExcluir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(499, 499, 499)
                        .addComponent(jLabel7)))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtEndereço))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExcluir)
                    .addComponent(txtAlterar)
                    .addComponent(btnAdicionar))
                .addGap(405, 405, 405))
        );

        setBounds(0, 0, 1257, 631);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        Adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlterarActionPerformed
        Alterar();        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlterarActionPerformed

    private void txtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExcluirActionPerformed
        Excluir();        // TODO add your handling code here:
    }//GEN-LAST:event_txtExcluirActionPerformed

    private void tblPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacienteMouseClicked
        setar_campos();
    }//GEN-LAST:event_tblPacienteMouseClicked

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        Pesquisar();
    }//GEN-LAST:event_txtPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdicionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPaciente;
    private javax.swing.JButton txtAlterar;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEndereço;
    private javax.swing.JButton txtExcluir;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JComboBox<String> txtSexo;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}

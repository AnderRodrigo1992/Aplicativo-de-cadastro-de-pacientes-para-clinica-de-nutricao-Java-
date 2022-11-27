
package telas;
import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



public class TelaDeNutricionistas extends javax.swing.JInternalFrame {
   Connection conn ;
   PreparedStatement pstm ;
   ResultSet rs ;
   
   private void Buscar()   {

String sql = "select * from Nutricionista where idNutricionista = ?";
         
        try {     
                         
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, txtId.getText());
           
            rs= pstm.executeQuery();
            
            if (rs.next()){
            pstm.setString(1,txtId.getText());
            txtNome.setText(rs.getString(2));
            txtIdade.setText(rs.getString(3));
            txtCpf.setText(rs.getString(4));
            txtCidade.setText(rs.getString(5));
            txtUf.setText(rs.getString(6));
            txtEndereço.setText(rs.getString(7));
            txtTelefone.setText(rs.getString(8));  
            txtLogin.setText(rs.getString(9)); 
            txtSenha.setText(rs.getString(10)); 
            txtPerfil.setSelectedItem(rs.getString(11)); 
            }
            
            else{
            JOptionPane.showMessageDialog(null," Usuário não cadastrado ");
             
             
             txtId.setText(null);
             txtCidade.setText(null);
             txtCpf.setText(null);
             txtEndereço.setText(null);
             txtId.setText(null);
             txtIdade.setText(null);
             txtNome.setText(null);
             txtTelefone.setText(null);
             txtUf.setText(null); 
             txtLogin.setText(null); 
             txtSenha.setText(null); 
                        }


        }
 catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Buscar ");
        }


}
           
private void Adicionar(){
    
    String sql = "insert into Nutricionista (idNutricionista,nome,idade,cpf,cidade,uf,endereço,telefone,Login,Senha,Perfil) values(?,?,?,?,?,?,?,?,?,?,?)";
         
        try {     
                         
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, txtId.getText());
            pstm.setString(2, txtNome.getText());
            pstm.setString(3, txtIdade.getText());
            pstm.setString(4, txtCpf.getText());
            pstm.setString(5, txtCidade.getText());
            pstm.setString(6, txtUf.getText());
            pstm.setString(7, txtEndereço.getText()); 
            pstm.setString(8, txtTelefone.getText());
            pstm.setString(9, txtLogin.getText()); 
            pstm.setString(10, txtSenha.getText());
            pstm.setString(11, txtPerfil.getSelectedItem().toString());
                               
                if ((txtNome.getText().isEmpty()) ||
               (txtCpf.getText().isEmpty()) ||
               (txtEndereço.getText().isEmpty()) ||
               (txtId.getText().isEmpty()) ||
               (txtIdade.getText().isEmpty())||
               (txtTelefone.getText().isEmpty())||
               (txtCidade.getText().isEmpty())||
               (txtUf.getText().isEmpty())||    
               (txtLogin.getText().isEmpty())|| 
               (txtSenha.getText().isEmpty()) ) 
            
            
            
            {JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios , são os campos marcados com *");                    
              
            } else {                   
                 int adicionado =   pstm.executeUpdate();                     
                     
          
            if (adicionado > 0) {
            JOptionPane.showMessageDialog(null,"Usuario Cadastrado com sucesso ");
             
           //Limpa os campos após cadastrar um usuário 
             txtCidade.setText(null);
             txtCpf.setText(null);
             txtEndereço.setText(null);
             txtId.setText(null);
             txtIdade.setText(null);
             txtNome.setText(null);
             txtTelefone.setText(null);
             txtUf.setText(null);
             txtLogin.setText(null);
             txtSenha.setText(null);
           
                             
           } 
            
                } 
        }
        
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Adicionar ");
        }
       
   
   
   
     }

private void Alterar(){
    
    String sql = "update Nutricionista set  nome = ?, idade = ?,cpf =?,cidade = ?, uf = ? ,endereço = ?,telefone = ?, Login = ?, Senha = ? , Perfil = ? where idNutricionista = ?";
          
    try {
        
        pstm = conn.prepareStatement(sql);
            
           
            pstm.setString(1, txtNome.getText());
            pstm.setString(2, txtIdade.getText());
            pstm.setString(3, txtCpf.getText());
            pstm.setString(4, txtCidade.getText());
            pstm.setString(5, txtUf.getText());
            pstm.setString(6, txtEndereço.getText()); 
            pstm.setString(7, txtTelefone.getText());           
            pstm.setString(8, txtLogin.getText()); 
            pstm.setString(9, txtSenha.getText());
            pstm.setString(10, txtPerfil.getSelectedItem().toString());
            pstm.setString(11, txtId.getText());
            
               if ((txtNome.getText().isEmpty()) ||
               (txtCpf.getText().isEmpty()) ||
               (txtEndereço.getText().isEmpty()) ||
               (txtId.getText().isEmpty()) ||
               (txtIdade.getText().isEmpty())||
               (txtTelefone.getText().isEmpty())||
               (txtCidade.getText().isEmpty())||
               (txtUf.getText().isEmpty()) ||    
               (txtLogin.getText().isEmpty())  || 
               (txtSenha.getText().isEmpty()) 
                               )
                      
            
            {JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios , são os campos marcados com *");                    
              
            } else {                   
            int adicionado =   pstm.executeUpdate();                     
                     
          
            if (adicionado > 0) {
            JOptionPane.showMessageDialog(null,"Nutricionista Alterado Com Sucesso ");
             
           //Limpa os campos após cadastrar um usuário 
             txtCidade.setText(null);
             txtCpf.setText(null);
             txtEndereço.setText(null);
             txtId.setText(null);
             txtIdade.setText(null);
             txtNome.setText(null);
             txtTelefone.setText(null);
             txtUf.setText(null);
             txtLogin.setText(null); 
             txtSenha.setText(null); 
          
                             
           } 
            
                } 
        
            
        
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null,"Erro Metodo Alterar ");

    }








}
   
private void Excluir(){

 int confirma = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR ESSE PACIENTE?","atenção",JOptionPane.YES_NO_OPTION);
 
    
    if (confirma == JOptionPane.YES_OPTION){
    
         String sql = "delete from Nutricionista where idNutricionista = ? ";
        
 try {
        
        pstm = conn.prepareStatement(sql);
                               
            pstm.setString(1, txtId.getText());
            int apagado = pstm.executeUpdate();
            
            if (apagado > 0){
             
             JOptionPane.showMessageDialog(null,"Usuário Removido com sucesso");
             txtCidade.setText(null);
             txtCpf.setText(null);
             txtEndereço.setText(null);
             txtId.setText(null);
             txtIdade.setText(null);
             txtNome.setText(null);
             txtTelefone.setText(null);
             txtUf.setText(null);
             txtLogin.setText(null);
             txtSenha.setText(null);
            
            }
            


 }
    
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Excluir");
        }



    }}
    
   
    public TelaDeNutricionistas() {
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

        btnBuscar = new javax.swing.JButton();
        txtAlterar = new javax.swing.JButton();
        txtExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JToggleButton();
        txtEndereço = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPerfil = new javax.swing.JComboBox<>();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();

        setClosable(true);
        setForeground(new java.awt.Color(0, 0, 0));
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1269, 631));

        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("*NOME:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText(" *ID :");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("*IDADE:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("*CPF:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("*UF:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("*CIDADE :");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("*TELEFONE:");

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Cadastrar Novo Nutricionista");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("*LOGIN:");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("*SENHA:");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("*PERFIL:");

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

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("*ENDEREÇO");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Campos obrigatórios estão marcados com *");

        txtPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Usuario" }));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
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
                        .addGap(497, 497, 497)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtEndereço)
                                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtUf)
                                                .addComponent(txtCidade))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtIdade, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(txtAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGap(15, 15, 15)
                                .addComponent(txtExcluir))
                            .addComponent(jLabel10))))
                .addContainerGap(505, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnBuscar, txtAlterar, txtExcluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId)
                    .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEndereço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSenha))
                .addGap(4, 4, 4)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExcluir)
                    .addComponent(txtAlterar)
                    .addComponent(btnAdicionar)
                    .addComponent(btnBuscar))
                .addGap(441, 441, 441))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionar, btnBuscar, txtAlterar, txtExcluir});

        setBounds(0, 0, 1257, 631);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlterarActionPerformed
        Alterar();        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlterarActionPerformed

    private void txtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExcluirActionPerformed
        Excluir();        // TODO add your handling code here:
    }//GEN-LAST:event_txtExcluirActionPerformed

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        Adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton txtAlterar;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEndereço;
    private javax.swing.JButton txtExcluir;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JComboBox<String> txtPerfil;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}

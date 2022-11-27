
package telas;
import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class TelaDeMedidas extends javax.swing.JInternalFrame {
   
   Connection conn ;
   PreparedStatement pstm ;
   ResultSet rs ;
   
   private void getDateTime() {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
        DateFormat Mudarhora = DateFormat.getDateInstance(DateFormat.LONG );
	
        txtData.setText(Mudarhora.format(date));
        
}
   
   private void pesquisarPaciente(){
   
       String sql = "select idPaciente as ID , nome as Nome, cpf as Cpf from Paciente where nome like ?";

    try {
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,txtPesquisa.getText() + "%");
        rs = pstm.executeQuery();
        tlbTable.setModel(DbUtils.resultSetToTableModel(rs));
        

        
        
    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro Metodo Pesquisar");

    }
   
   }
        
    
   
   private void CadastrarMedidas(){
   String sql = "insert into Medidas (altura, peso, peitoral, quadril, barriga, bracoDir,bracoEsq, coxaDir, coxaEsq, panturrilhaDir, panturrilhaEsq, Paciente_idPaciente, DataDaMedição,atividade) values (?,?,?,?, ?,?,?, ?,?,?, ?,?,?,?)";
    
   try {     
                        
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, txtAltura.getText().replace(",","."));
            pstm.setString(2, txtPeso.getText().replace(",","."));        
            pstm.setString(3, txtPeitoral.getText().replace(",","."));
            pstm.setString(4, txtQuadril.getText().replace(",","."));
            pstm.setString(5, txtBarriga.getText().replace(",",".")); 
            pstm.setString(6, txtBraçoDir.getText().replace(",","."));
            pstm.setString(7, txtBraçoEsq.getText().replace(",","."));
            pstm.setString(8, txtCoxaDir.getText().replace(",","."));
            pstm.setString(9, txtCoxaEsq.getText().replace(",","."));
            pstm.setString(10, txtPanturrilhaDir.getText().replace(",","."));
            pstm.setString(11, txtPanturrilhaEsq.getText().replace(",","."));
            pstm.setString(12, txtIDPaciente.getText());
            pstm.setString(13, txtData.getText());
            pstm.setString(14, txtAtividade.getSelectedItem().toString());
                                          
               if ((txtIDPaciente.getText().isEmpty()) ||
               (txtPeso.getText().isEmpty()) ||
               (txtAltura.getText().isEmpty())               
                                )
                       
            
            {JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios , são os campos marcados com *");                    
              
            } else {                   
                 int adicionado =   pstm.executeUpdate();                     
                     
          
            if (adicionado > 0) {
            JOptionPane.showMessageDialog(null,"Medidas cadastradas com sucesso ");
             
           //Limpa os campos após cadastrar um usuário 
               limpar_campos();           
          
   
           } 
            
                } 
        }
        
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Adicionar ");
        }
       
   
   
   
     }
   
   private void pesquisarMedidas(){
   
       
       
    String sql ="select * from medidas where Paciente_idPaciente = ? "   ;
           
                       
            
    try {
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,txtPesquisaMedidas.getText() + "%");
        rs = pstm.executeQuery();
        tblMedidas.setModel(DbUtils.resultSetToTableModel(rs));
        

        
        
    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro Metodo Pesquisar");

    }
   
   
   
   
   
   
   }

   private void alterarMedidas(){
   
   String sql = "update Medidas set altura = ?, peso = ?, peitoral = ?, quadril = ?, barriga = ?, bracoDir = ?,bracoEsq = ?, coxaDir = ?, coxaEsq = ?, panturrilhaDir = ?, panturrilhaEsq = ?,DataDaMedição = ?, atividade = ? where idMedidas = ?" ; 
          
    try {
        
        pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, txtAltura.getText());
            pstm.setString(2, txtPeso.getText());
            pstm.setString(3, txtPeitoral.getText());
            pstm.setString(4, txtQuadril.getText());
            pstm.setString(5, txtBarriga.getText());
            pstm.setString(6, txtBraçoDir.getText());
            pstm.setString(7, txtBraçoEsq.getText()); 
            pstm.setString(8, txtCoxaDir.getText());
            pstm.setString(9, txtCoxaEsq.getText());
            pstm.setString(10, txtPanturrilhaDir.getText());
            pstm.setString(11, txtPanturrilhaEsq.getText());
            pstm.setString(12, txtDataPesq.getText());
            pstm.setString(13, txtAtividade.getSelectedItem().toString());            
            pstm.setString(14, txtIdMedida.getText());
            
                        
               if ((txtPeso.getText().isEmpty()) ||
               (txtAltura.getText().isEmpty()) ||
               (txtIDPaciente.getText().isEmpty()) 
               )
                      
            
            {JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios , são os campos marcados com *");                    
              
            } else {                   
            int adicionado =   pstm.executeUpdate();                     
                     
          
            if (adicionado > 0) {
            JOptionPane.showMessageDialog(null,"Medidas Alteradas Com Sucesso ");
             
           //Limpa os campos após cadastrar um usuário 
             limpar_campos();
                             
           } 
            
                } 
                    
        
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null,"Erro Metodo Alterar ");

    }


   }
   
     private void ExcluirMedidas(){

 int confirma = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR ESSAS MEDIDAS?","atenção",JOptionPane.YES_NO_OPTION);
 
    
    if (confirma == JOptionPane.YES_OPTION){
    
         String sql = "delete from Medidas where idMedidas = ? ";
        
 try {
        
        pstm = conn.prepareStatement(sql);
                               
            pstm.setString(1, txtIdMedida.getText());
            int apagado = pstm.executeUpdate();
            
            if (apagado > 0){
             
             JOptionPane.showMessageDialog(null,"Medidas Removidas com sucesso");
             limpar_campos();
             
            }
            


 }
    
            catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Excluir");
        }




}}
   
   
   
   private void setarCampos(){
   
   int setar = tlbTable.getSelectedRow();
   txtIDPaciente.setText(tlbTable.getModel().getValueAt(setar, 0).toString());
   txtPesquisaMedidas.setText(tlbTable.getModel().getValueAt(setar, 0).toString());
   txtNome.setText(tlbTable.getModel().getValueAt(setar, 1).toString());
   }
   
  private void setar_campos_Tabela_Medidas(){
  int setar = tblMedidas.getSelectedRow();
             
             txtIdMedida.setText(tblMedidas.getModel().getValueAt(setar,0 ).toString());
             txtPeso.setText(tblMedidas.getModel().getValueAt(setar,3 ).toString());
             txtAltura.setText(tblMedidas.getModel().getValueAt(setar,2 ).toString());
             txtPeitoral.setText(tblMedidas.getModel().getValueAt(setar,4 ).toString()); 
             txtQuadril.setText(tblMedidas.getModel().getValueAt(setar,5 ).toString());
             txtBarriga.setText(tblMedidas.getModel().getValueAt(setar,6 ).toString());
             txtBraçoDir.setText(tblMedidas.getModel().getValueAt(setar,7 ).toString());
             txtBraçoEsq.setText(tblMedidas.getModel().getValueAt(setar,8).toString());
             txtCoxaDir.setText(tblMedidas.getModel().getValueAt(setar,9 ).toString());
             txtCoxaEsq.setText(tblMedidas.getModel().getValueAt(setar,10 ).toString());
             txtPanturrilhaDir.setText(tblMedidas.getModel().getValueAt(setar,11 ).toString());
             txtPanturrilhaEsq.setText(tblMedidas.getModel().getValueAt(setar,12 ).toString());
             txtDataPesq.setText(tblMedidas.getModel().getValueAt(setar,1 ).toString());
    }
      
   private void limpar_campos(){
    
             txtAltura.setText("0");
             txtBarriga.setText("0");
             txtBraçoDir.setText("0");
             txtBraçoEsq.setText("0");
             txtCoxaDir.setText("0");
             txtCoxaEsq.setText("0");
             txtPanturrilhaDir.setText("0");
             txtPanturrilhaEsq.setText("0");
             txtPeitoral.setText("0");
             txtPeso.setText("0");
             txtQuadril.setText("0");
             txtCoxaEsq.setText("0");
             txtIDPaciente.setText(null);
             txtPesquisa.setText(null);
             txtIdMedida.setText(null);
             txtNome.setText(null);
             txtDataPesq.setText(null);
            
             ((DefaultTableModel)tlbTable.getModel()).setRowCount(0);
             ((DefaultTableModel)tblMedidas.getModel()).setRowCount(0);
   }
    
    
   
    public TelaDeMedidas() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMedidas = new javax.swing.JTable();
        txtPesquisaMedidas = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDataPesq = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIDPaciente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIdMedida = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtBraçoDir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBarriga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        txtPeitoral = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBraçoEsq = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtQuadril = new javax.swing.JTextField();
        txtCoxaEsq = new javax.swing.JTextField();
        txtPanturrilhaEsq = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCoxaDir = new javax.swing.JTextField();
        txtPanturrilhaDir = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtAtividade = new javax.swing.JComboBox<>();
        txtAdicionar = new javax.swing.JToggleButton();
        txtAlterar = new javax.swing.JToggleButton();
        txtExcluir = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1269, 654));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 0, 0)))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 153));

        jLabel1.setText("Pesquisar ");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        tlbTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tlbTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Cpf"
            }
        ));
        tlbTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlbTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlbTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        tblMedidas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblMedidas.setForeground(new java.awt.Color(0, 0, 0));
        tblMedidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idMedidas", "altura", "peso", "peitoral", "quadril", "barriga", "bracoDir", "bracoEsq", "coxaDir", "coxaEsq", " panturrilhaDir ", " panturrilhaEsq", "data", "Paciente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMedidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedidasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMedidas);
        if (tblMedidas.getColumnModel().getColumnCount() > 0) {
            tblMedidas.getColumnModel().getColumn(0).setResizable(false);
            tblMedidas.getColumnModel().getColumn(0).setHeaderValue("idMedidas");
            tblMedidas.getColumnModel().getColumn(1).setHeaderValue("altura");
            tblMedidas.getColumnModel().getColumn(2).setResizable(false);
            tblMedidas.getColumnModel().getColumn(2).setHeaderValue("peso");
            tblMedidas.getColumnModel().getColumn(3).setResizable(false);
            tblMedidas.getColumnModel().getColumn(3).setHeaderValue("peitoral");
            tblMedidas.getColumnModel().getColumn(4).setResizable(false);
            tblMedidas.getColumnModel().getColumn(4).setHeaderValue("quadril");
            tblMedidas.getColumnModel().getColumn(5).setResizable(false);
            tblMedidas.getColumnModel().getColumn(5).setHeaderValue("barriga");
            tblMedidas.getColumnModel().getColumn(6).setHeaderValue("bracoDir");
            tblMedidas.getColumnModel().getColumn(7).setResizable(false);
            tblMedidas.getColumnModel().getColumn(7).setHeaderValue("bracoEsq");
            tblMedidas.getColumnModel().getColumn(8).setResizable(false);
            tblMedidas.getColumnModel().getColumn(8).setHeaderValue("coxaDir");
            tblMedidas.getColumnModel().getColumn(9).setResizable(false);
            tblMedidas.getColumnModel().getColumn(9).setHeaderValue("coxaEsq");
            tblMedidas.getColumnModel().getColumn(10).setResizable(false);
            tblMedidas.getColumnModel().getColumn(10).setHeaderValue(" panturrilhaDir ");
            tblMedidas.getColumnModel().getColumn(11).setHeaderValue(" panturrilhaEsq");
            tblMedidas.getColumnModel().getColumn(12).setResizable(false);
            tblMedidas.getColumnModel().getColumn(12).setHeaderValue("data");
            tblMedidas.getColumnModel().getColumn(13).setResizable(false);
        }

        txtPesquisaMedidas.setEnabled(false);
        txtPesquisaMedidas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPesquisaMedidasCaretUpdate(evt);
            }
        });
        txtPesquisaMedidas.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtPesquisaMedidasInputMethodTextChanged(evt);
            }
        });
        txtPesquisaMedidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaMedidasKeyReleased(evt);
            }
        });

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Nome:");

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Data Da Medição:");

        txtNome.setEnabled(false);

        txtDataPesq.setText("...");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("*ID Paciente:");

        txtIDPaciente.setEnabled(false);
        txtIDPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPacienteActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("ID Medida:");

        txtIdMedida.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataPesq))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtDataPesq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        txtBraçoDir.setText("0");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("*Peso:");

        txtBarriga.setText("0");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("*Altura:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Peitoral:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Barriga:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("BraçoDir:");

        txtPeitoral.setText("0");
        txtPeitoral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeitoralActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("BraçoEsq:");

        txtBraçoEsq.setText("0");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CoxaDir:");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("CoxaEsq:");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("PanturrilhaDir:");

        txtQuadril.setText("0");

        txtCoxaEsq.setText("0");

        txtPanturrilhaEsq.setText("0");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Quadril:");

        txtCoxaDir.setText("0");
        txtCoxaDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoxaDirActionPerformed(evt);
            }
        });

        txtPanturrilhaDir.setText("0");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("PanturrilhaEsq:");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nivel de atividade fisica:");

        txtAtividade.setMaximumRowCount(5);
        txtAtividade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedentário", "Levemente ativo", "Moderadamente ativo", "Altamente ativo\t", "Extremamente ativo", " " }));
        txtAtividade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtAtividadeItemStateChanged(evt);
            }
        });
        txtAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtividadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtQuadril, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCoxaDir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtCoxaEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPanturrilhaDir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPanturrilhaEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBraçoDir, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtBraçoEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBarriga, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeitoral, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCoxaDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtPanturrilhaDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtBraçoDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCoxaEsq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14)
                                    .addComponent(txtPanturrilhaEsq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtBraçoEsq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtQuadril, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPeitoral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtBarriga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAltura, txtBarriga, txtPeitoral, txtPeso, txtQuadril});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        txtAdicionar.setForeground(new java.awt.Color(0, 0, 0));
        txtAdicionar.setText("Adicionar");
        txtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdicionarActionPerformed(evt);
            }
        });

        txtAlterar.setForeground(new java.awt.Color(0, 0, 0));
        txtAlterar.setText("Alterar");
        txtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlterarActionPerformed(evt);
            }
        });

        txtExcluir.setForeground(new java.awt.Color(255, 0, 0));
        txtExcluir.setText("Excluir");
        txtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(987, 987, 987)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAdicionar)
                                        .addGap(34, 34, 34)
                                        .addComponent(txtAlterar)
                                        .addGap(39, 39, 39)
                                        .addComponent(txtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAdicionar, txtAlterar, txtExcluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisaMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlterar)
                            .addComponent(txtAdicionar))
                        .addGap(0, 120, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPacienteActionPerformed

    private void txtPeitoralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeitoralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeitoralActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
pesquisarPaciente();        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void tlbTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbTableMouseClicked
     setarCampos();
     getDateTime();
    }//GEN-LAST:event_tlbTableMouseClicked

    private void txtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdicionarActionPerformed
CadastrarMedidas();    
 
    }//GEN-LAST:event_txtAdicionarActionPerformed

    private void txtCoxaDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoxaDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoxaDirActionPerformed

    private void txtPesquisaMedidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaMedidasKeyReleased
                // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaMedidasKeyReleased

    private void txtPesquisaMedidasInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPesquisaMedidasInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaMedidasInputMethodTextChanged

    private void txtPesquisaMedidasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPesquisaMedidasCaretUpdate
pesquisarMedidas();        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaMedidasCaretUpdate

    private void txtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlterarActionPerformed
alterarMedidas();        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlterarActionPerformed

    private void tblMedidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedidasMouseClicked
    setar_campos_Tabela_Medidas();    // TOsDO add your handling code here:
    }//GEN-LAST:event_tblMedidasMouseClicked

    private void txtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExcluirActionPerformed
ExcluirMedidas();        // TODO add your handling code here:
    }//GEN-LAST:event_txtExcluirActionPerformed

    private void txtAtividadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtAtividadeItemStateChanged
             // TODO add your handling code here:
    }//GEN-LAST:event_txtAtividadeItemStateChanged

    private void txtAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtividadeActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMedidas;
    private javax.swing.JTable tlbTable;
    private javax.swing.JToggleButton txtAdicionar;
    private javax.swing.JToggleButton txtAlterar;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JComboBox<String> txtAtividade;
    private javax.swing.JTextField txtBarriga;
    private javax.swing.JTextField txtBraçoDir;
    private javax.swing.JTextField txtBraçoEsq;
    private javax.swing.JTextField txtCoxaDir;
    private javax.swing.JTextField txtCoxaEsq;
    private javax.swing.JTextField txtData;
    private javax.swing.JLabel txtDataPesq;
    private javax.swing.JToggleButton txtExcluir;
    private javax.swing.JTextField txtIDPaciente;
    private javax.swing.JTextField txtIdMedida;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPanturrilhaDir;
    private javax.swing.JTextField txtPanturrilhaEsq;
    private javax.swing.JTextField txtPeitoral;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPesquisaMedidas;
    private javax.swing.JTextField txtQuadril;
    // End of variables declaration//GEN-END:variables
}

package telas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.Conexao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

  


public class RelatorioCliente extends javax.swing.JInternalFrame {
Connection conn ;
   PreparedStatement pstm ;
   ResultSet rs ;
   Date data = new Date();
   DateFormat Mudarhora = DateFormat.getDateInstance(DateFormat.LONG );
   
   
   

   
   
   
   
   
   
   private void pesquisarPaciente(){
   
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
     
   private void calcular(){
        float soma,n1,n2;
        
       // ALTURA
         n1 = Float.parseFloat(txtAltura.getText());
         n2 = Float.parseFloat(txtAltura2.getText());
         soma = n1 - n2;
         
         
         
         if (n2 == 0){
         CalcAltura1.setText("") ;
         }
         
         else if(n1 == n2){
         CalcAltura1.setText(" Mesma Altura");} 
         
         else  if (soma >=  1){
         Float.toString(soma);    
         CalcAltura1.setText(Math.abs(soma)+ " Ganhou ") ;}
            
         
         
         
         
         
         //PESO
         
         n1 = Float.parseFloat(txtPeso.getText());
         n2 = Float.parseFloat(txtPeso2.getText());
        
         soma = n1 - n2;
         
         
           if (n2 == 0){
         CalcPeso1.setText("") ;
         }
           else if(n1 == n2){
         CalcPeso1.setText(" Mesmo Peso");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcPeso1.setText("-" + Math.abs(soma)+ " Perdeu ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcPeso1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
         
           }
                         
         
         
         
         
         
         
         
         //PEITORAL
         
         n1 = Float.parseFloat(txtPeitoral.getText());
         n2 = Float.parseFloat(txtPeitoral2.getText());
         soma = n1 - n2;        
         if (n2 == 0){
         CalcPeitoral2.setText("") ;
         }
           else if(n1 == n2){
         CalcPeitoral2.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcPeitoral2.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcPeitoral2.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
         
           }
         
           
           
         //QUADRIL  
         n1 = Float.parseFloat(txtQuadril.getText());
         n2 = Float.parseFloat(txtQuadril2.getText());
         soma = n1 - n2;        
          if (n2 == 0){
         CalcQuadril1.setText("") ;
         }
           else if(n1 == n2){
         CalcQuadril1.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcQuadril1.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcQuadril1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
         
           }
         
          // BARRIGA
         n1 = Float.parseFloat(txtBarriga.getText());
         n2 = Float.parseFloat(txtBarriga2.getText());
         soma = n1 - n2;
         
          if (n2 == 0){
         CalcBarriga1.setText("") ;
         }
           else if(n1 == n2){
         CalcBarriga1.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcBarriga1.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcBarriga1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
         
           }
         
          // BRAÇO DIREITO
         n1 = Float.parseFloat(txtBraçoDir.getText());
         n2 = Float.parseFloat(txtBraçoDir2.getText());
         soma = n1 - n2;        
          if (n2 == 0){
         CalcBraDir1.setText("") ;
         }
           else if(n1 == n2){
         CalcBraDir1.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcBraDir1.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcBraDir1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
                    }
         
          
          //BRAÇO ESQUERDO
         n1 = Float.parseFloat(txtBraçoEsq.getText());
         n2 = Float.parseFloat(txtBraçoEsq2.getText());
         soma = n1 - n2;        
          if (n2 == 0){
         CalcBraEsq1.setText("") ;
         }
           else if(n1 == n2){
         CalcBraEsq1.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcBraEsq1.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcBraEsq1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
                    }
         
         // COXA DIREITA
         n1 = Float.parseFloat(txtCoxaDir.getText());
         n2 = Float.parseFloat(txtCoxaDir2.getText());
         soma = n1 - n2;        
           if (n2 == 0){
         CalcCoxaDir1.setText("") ;
         }
           else if(n1 == n2){
         CalcCoxaDir1.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcCoxaDir1.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcCoxaDir1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
                    }
         
           
         // COXA ESQUERDA  
         n1 = Float.parseFloat(txtCoxaEsq.getText());
         n2 = Float.parseFloat(txtCoxaEsq2.getText());
         soma = n1 - n2;        
           if (n2 == 0){
         CalcCoxaEsq1.setText("") ;
         }
           else if(n1 == n2){
         CalcCoxaEsq1.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcCoxaEsq1.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcCoxaEsq1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
                    }
         
           
         // PANTURRILHA DIREITA
         n1 = Float.parseFloat(txtPanturrilhaDir.getText());
         n2 = Float.parseFloat(txtPanturrilhaDir2.getText());
         soma = n1 - n2;        
           if (n2 == 0){
         CalcPantDir1.setText("") ;
         }
           else if(n1 == n2){
         CalcPantDir1.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcPantDir1.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcPantDir1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
                    }
         
         
         // PANTURRILHA ESQUERDA
         n1 = Float.parseFloat(txtPanturrilhaEsq.getText());
         n2 = Float.parseFloat(txtPanturrilhaEsq2.getText());
         soma = n1 - n2;        
          if (n2 == 0){
         CalcPantEsq1.setText("") ;
         }
           else if(n1 == n2){
         CalcPantEsq1.setText(" Mesma Medida");}  
         
         else{
             
         if (soma >  1){
         Float.toString(soma);    
         CalcPantEsq1.setText("-" + Math.abs(soma)+ " Perdeu  ") ;}
         
         else if(soma < 0){
         Float.toString(soma);    
         CalcPantEsq1.setText("+" + Math.abs(soma)+ " Ganhou ") ;}
                    }
        
        
         
         DecimalFormat deci = new DecimalFormat("#.##");
         DecimalFormat deci2 = new DecimalFormat("#.##");
         
// Primeiro Imc
         float n3 = Float.parseFloat(txtPeso.getText());
         float n4 = Float.parseFloat(txtAltura.getText());
         soma = (n3 / (n4 * n4)*100);
         
             
         if (soma < 0.1850 ){
          Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc1.setText(soma2);
         lblImc1.setText("Peso Abaixo do Normal");  }
        
         else{
                 
                
        if (soma >= 0.1850 && soma <= 0.2499){
          Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc1.setText(soma2);
         lblImc1.setText("Peso Normal");  }
        
        else{
            
         if(soma >= 0.2500 && soma <= 0.2999){
         Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc1.setText(soma2);
         lblImc1.setText("Pré Obesidade");}
         
         else{
         
             if(soma >= 0.3000 && soma <= 0.3499){
         Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc1.setText(soma2);
         lblImc1.setText("Obesidade Grau 1");}
        
         else{
         
                 if(soma >= 0.3500 && soma <= 0.3999){
         Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc1.setText(soma2);
         lblImc1.setText("Obesidade Grau 2");}
         
         else{
         if(soma >= 0.4000){
         Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc1.setText(soma2);
         lblImc1.setText("Obesidade Grau 3");}
         
         
             
                 }
        }
        }
      
        }
        
        
        }
 
//Segundo Imc
          n3 = Float.parseFloat(txtPeso2.getText());
          n4 = Float.parseFloat(txtAltura2.getText());
         soma = (n3 / (n4 * n4)*100);
         
             
         if (soma < 0.1850 ){
          Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc2.setText(soma2);
         lblImc2.setText("Peso Abaixo do Normal");  }
        
         else{
                 
                
        if (soma >= 0.1850 && soma <= 0.2499){
          Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc2.setText(soma2);
         lblImc2.setText("Peso Normal");  }
        
        else{
            
         if(soma >= 0.2500 && soma <= 0.2999){
         Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc2.setText(soma2);
         lblImc2.setText("Pré Obesidade");}
         
         else{
         
             if(soma >= 0.3000 && soma <= 0.3499){
         Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc2.setText(soma2);
         lblImc2.setText("Obesidade Grau 1");}
        
         else{
         
                 if(soma >= 0.3500 && soma <= 0.3999){
         Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc2.setText(soma2);
         lblImc2.setText("Obesidade Grau 2");}
         
         else{
         if(soma >= 0.4000){
         Float.toString(soma);
         String soma2 = deci.format(soma); 
         txtImc2.setText(soma2);
         lblImc2.setText("Obesidade Grau 3");}
}}}} }
       
         
         
 // Calculo da taxa basal Da primeira parte da tabela        
  
 float n5 , n6 , n7,n8,n9;
          n5 = Float.parseFloat(txtPeso.getText());
          n6 = Float.parseFloat(txtAltura.getText());
          n7 = Float.parseFloat(lblIdade.getText());


    String aux, aux2;
    aux  = (lblSexo).getText(); 
    aux2 = (txtAtividade).getText();
         
  if( aux.equals("Masculino")){
  
 //Masculino
  if (aux2.equals("Altamente ativo	")) {  
      double res =  1.725 *(66+((13.7*n5)+(5*n6))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}    
          
     else{if(aux2.equals("Sedentário")) {  
     double res =  1.2 *(66+((13.7*n5)+(5*n6))-(6.8*n7));    
     String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
     
     else{if(aux2.equals("Levemente ativo")) {  
     double res =  1.375 *(66+((13.7*n5)+(5*n6))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
     
     else{if(aux2.equals("Moderadamente ativo")) {  
     double res =  1.55 *(66+((13.7*n5)+(5*n6))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
          
    else{if(aux2.equals("Extremamente ativo")) {  
     double res =  1.9 *(66+((13.7*n5)+(5*n6))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
 }}}}}
  
   
  
  else{if( aux.equals("Feminino")){
  
      if (aux2.equals("Altamente ativo	")) {  
      double res =  1.725 *(655+((9.6*n5)+(1.8*n6))-(4.7*n7));
        String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
     
     else{if(aux2.equals("Sedentário")) {  
         double res =  1.2 *(655+((9.6*n5)+(1.8*n6))-(4.7*n7));
         String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
     
     
     else{if(aux2.equals("Levemente ativo")) {  
          double res =  1.375 *(655+((9.6*n5)+(1.8*n6))-(4.7*n7));
        String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
     
     else{if(aux2.equals("Moderadamente ativo")) {  
     double res =  1.55 *(655+((9.6*n5)+(1.8*n6))-(4.7*n7));
         String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
     
    else{if(aux2.equals("Extremamente ativo")) {  
     double res =  1.9 *(655+((9.6*n5)+(1.8*n6))-(4.7*n7));
          String mudadata = deci.format(res);
     txtBasal.setText(mudadata);}
 }}}}}}

    
                 
         
         
 
         
         
         
         
         
         
         
         
         
         
         
         
         
          n7 = Float.parseFloat(lblIdade.getText());
          n8 = Float.parseFloat(txtPeso2.getText());
          n9 = Float.parseFloat(txtAltura2.getText());

          
          
// Calculo da taxa basal Da Segunda parte da tabela
    
   
    aux  = (lblSexo).getText(); 
    aux2 = (txtAtividade1).getText();
    
  if( aux.equals("Masculino")){
  
 //Masculino
  if (aux2.equals("Altamente ativo	")) {  
      double res =  1.725 *(66+((13.7*n8)+(5*n9))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
     
     else{if(aux2.equals("Sedentário")) {  
     double res =  1.2 *(66+((13.7*n8)+(5*n9))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
     
     else{if(aux2.equals("Levemente ativo")) {  
     double res =  1.375 *(66+((13.7*n8)+(5*n9))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
     
     else{if(aux2.equals("Moderadamente ativo")) {  
     double res =  1.55 *(66+((13.7*n8)+(5*n9))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
          
    else{if(aux2.equals("Extremamente ativo")) {  
     double res =  1.9 *(66+((13.7*n8)+(5*n9))-(6.8*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
 }}}}}
  
   //Feminino
  
   
  else{if( aux.equals("Feminino")){
  
      if (aux2.equals("Altamente ativo	")) {  
      double res =  1.725 *(655+((9.6*n8)+(1.8*n9))-(4.7*n7));
      String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}        
     
     
     else{if(aux2.equals("Sedentário")) {  
         double res =  1.2 *(655+((9.6*n8)+(1.8*n9))-(4.7*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
     
     else{if(aux2.equals("Levemente ativo")) {  
          double res =  1.375  *(655+((9.6*n8)+(1.8*n9))-(4.7*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
     
     else{if(aux2.equals("Moderadamente ativo")) {  
     double res =  1.55  * (655+((9.6*n8)+(1.8*n9))-(4.7*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
          
    else{if(aux2.equals("Extremamente ativo")) {  
     double res =  1.9  * (655+((9.6*n8)+(1.8*n9))-(4.7*n7));
     String mudadata = deci.format(res);
     txtBasal2.setText(mudadata);}
 }}}}}}

    
          
          
          
          
          
   
   

   }

   private void Buscar1()   {
   



        
String sql = "select * from medidas where idMedidas = ?";
         
        try {     
                         
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,txtBuscarMedidas.getText());
           
            rs= pstm.executeQuery();
            
            if (rs.next()){
            pstm.setString(1,txtBuscarMedidas.getText());
            txtData.setText(rs.getString(2));
                        txtAltura.setText(rs.getString(3));
            txtPeso.setText(rs.getString(4));
            txtBarriga.setText(rs.getString(7));
            txtPeitoral.setText(rs.getString(5));
            txtQuadril.setText(rs.getString(6));
            txtBraçoDir.setText(rs.getString(8));
            txtBraçoEsq.setText(rs.getString(9));
            txtCoxaDir.setText(rs.getString(10));
            txtCoxaEsq.setText(rs.getString(11));
            txtPanturrilhaDir.setText(rs.getString(12));
            txtPanturrilhaEsq.setText(rs.getString(13));
            txtAtividade.setText(rs.getString(15));
                     
            
            
            
            }
            
           


        }
 catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Buscar ");
        }


}
   
     
   private void Buscar2()   {
        
String sql = "select * from medidas where idMedidas = ?";
         
        try {     
                         
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,txtBuscarMedidas1.getText());
           
            rs= pstm.executeQuery();
            
            if (rs.next()){
            pstm.setString(1,txtBuscarMedidas.getText());
            lblData1.setText((rs.getString(2)));  
            txtAltura2.setText(rs.getString(3));
            txtPeso2.setText(rs.getString(4));
            txtBarriga2.setText(rs.getString(7));
            txtPeitoral2.setText(rs.getString(5));
            txtQuadril2.setText(rs.getString(6));
            txtBraçoDir2.setText(rs.getString(8));
            txtBraçoEsq2.setText(rs.getString(9));
            txtCoxaDir2.setText(rs.getString(10));
            txtCoxaEsq2.setText(rs.getString(11));
            txtPanturrilhaDir2.setText(rs.getString(12));
            txtPanturrilhaEsq2.setText(rs.getString(13));
            txtAtividade1.setText(rs.getString(15));
          
            }
          


        }
 catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Buscar2 ");
        }


}
   
      private void Buscar3()   {

        
String sql = "select * from paciente where idPaciente = ?";
         
        try {     
                         
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,txtPesquisaMedidas.getText());
           
            rs= pstm.executeQuery();
            
            if (rs.next()){
            pstm.setString(1,txtPesquisaMedidas.getText());
            lblSexo.setText(rs.getString(9));
            lblIdade.setText(rs.getString(3));
          
            
            
            
            }
            
           


        }
 catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro Metodo Buscar 3 ");
        }


}
     
      
      
      
   private void setar_campos_Tabela_Medidas(){
  int setar = tblMedidas.getSelectedRow();
             
             txtBuscarMedidas.setText(tblMedidas.getModel().getValueAt(setar,0 ).toString());
             
           //  txtPeso.setText(tblMedidas.getModel().getValueAt(setar,3 ).toString());
           //  txtAltura.setText(tblMedidas.getModel().getValueAt(setar,2 ).toString());
           //  txtPeitoral.setText(tblMedidas.getModel().getValueAt(setar,4 ).toString()); 
           //  txtQuadril.setText(tblMedidas.getModel().getValueAt(setar,5 ).toString());
           //  txtBarriga.setText(tblMedidas.getModel().getValueAt(setar,6 ).toString());
           //  txtBraçoDir.setText(tblMedidas.getModel().getValueAt(setar,7 ).toString());
           //  txtBraçoEsq.setText(tblMedidas.getModel().getValueAt(setar,8).toString());
           //  txtCoxaDir.setText(tblMedidas.getModel().getValueAt(setar,9 ).toString());
           //  txtCoxaEsq.setText(tblMedidas.getModel().getValueAt(setar,10 ).toString());
           //  txtPanturrilhaDir.setText(tblMedidas.getModel().getValueAt(setar,11 ).toString());
           //  txtPanturrilhaEsq.setText(tblMedidas.getModel().getValueAt(setar,12 ).toString());
           //  txtData.setText(tblMedidas.getModel().getValueAt(setar,1 ).toString());
    }
  
   private void setar_campos_Tabela_Medidas2(){
  int setar = tblmedida2.getSelectedRow();
             
             txtBuscarMedidas1.setText(tblmedida2.getModel().getValueAt(setar,0 ).toString());
            // txtPeso1.setText(tblmedida2.getModel().getValueAt(setar,3 ).toString());
            // txtAltura1.setText(tblmedida2.getModel().getValueAt(setar,2 ).toString());
            // txtPeitoral1.setText(tblmedida2.getModel().getValueAt(setar,4 ).toString()); 
            // txtQuadril1.setText(tblmedida2.getModel().getValueAt(setar,5 ).toString());
            // txtBarriga1.setText(tblmedida2.getModel().getValueAt(setar,6 ).toString());
            // txtBraçoDir1.setText(tblmedida2.getModel().getValueAt(setar,7 ).toString());
            // txtBraçoEsq1.setText(tblmedida2.getModel().getValueAt(setar,8).toString());
            // txtCoxaDir1.setText(tblmedida2.getModel().getValueAt(setar,9 ).toString());
            // txtCoxaEsq1.setText(tblmedida2.getModel().getValueAt(setar,10 ).toString());
            // txtPanturrilhaDir1.setText(tblmedida2.getModel().getValueAt(setar,11 ).toString());
            // txtPanturrilhaEsq1.setText(tblmedida2.getModel().getValueAt(setar,12 ).toString());
             
    }
   
   private void pesquisarMedidas(){
   
       
       
    String sql ="select idMedidas as Id_Da_Medida, DataDaMedição as Data  from medidas where Paciente_idPaciente = ? "  ;
                                  
            
    try {
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,txtPesquisaMedidas.getText() + "%");
        rs = pstm.executeQuery();
        tblMedidas.setModel(DbUtils.resultSetToTableModel(rs));
        

        
        
    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro Metodo Pesquisar");

    }
   
   
   
   
   
   
   }
   
   private void pesquisarMedidas2(){
             
    String sql ="select idMedidas as Id_Da_Medida, DataDaMedição as Data  from medidas where Paciente_idPaciente = ? "  ;
                                          
    try {
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1,txtPesquisaMedidas.getText() + "%");
        rs = pstm.executeQuery();
        tblmedida2.setModel(DbUtils.resultSetToTableModel(rs));
             
       
    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro Metodo Pesquisar");

    } 
   }
   

  
    private void setarCampos(){
   
   int setar = tlbTable.getSelectedRow();
   txtPesquisaMedidas.setText(tlbTable.getModel().getValueAt(setar, 0).toString());
   txtNomeDoPaciente.setText(tlbTable.getModel().getValueAt(setar, 1).toString());

   }
    
    
       private void pdf(){
           
   String dia =(Mudarhora.format(data));
   String nome = txtNomeDoPaciente.getText();
   String sexo = lblSexo.getText();
   String idade =  lblIdade.getText();
     
   String Imc1 = txtImc1.getText();
   String Imc2 = txtImc2.getText();
   
   String grau1 = lblImc1.getText();
   String grau2 = lblImc2.getText();
   
   String data1 = txtData.getText();
   String data2 = lblData1.getText();
      
   String basal1 = txtBasal.getText();
   String basal2= txtBasal2.getText();
   
   String atv1 = txtAtividade.getText();
   String atv2 = txtAtividade1.getText();
   
    String altura1 = txtAltura.getText();
    String altura2 = txtAltura2.getText();
    String altura3 = CalcAltura1.getText();
    
    String Peso1 = txtPeso.getText();
    String Peso2 = txtPeso2.getText();
    String Peso3 = CalcPeso1.getText();
    
   String Peitoral1 = txtPeitoral.getText();
   String Peitoral2 = txtPeitoral2.getText();
   String Peitoral3 = CalcPeitoral2.getText();
   
   String quadril1 = txtQuadril.getText();
   String quadril2 = txtQuadril2.getText();
   String quadril3 = CalcQuadril1.getText();
    
   String barriga1 = txtBarriga.getText();
   String barriga2 = txtBarriga2.getText();
   String barriga3 = CalcBarriga1.getText();
   
   String bracodir1 = txtBraçoDir.getText();
   String bracodir2 = txtBraçoDir2.getText();
   String bracodir3 =  CalcBraDir1.getText();
     
   String bracoesq1 = txtBraçoEsq.getText();
   String bracoesq2 = txtBraçoEsq2.getText();
   String bracoesq3 = CalcBraEsq1.getText();
   
   String coxadir1  = txtCoxaDir.getText();
   String coxadir2  = txtCoxaDir2.getText();
   String coxadir3  = CalcCoxaDir1.getText();
   
   String coxaesq1 = txtCoxaEsq.getText();
   String coxaesq2 = txtCoxaEsq2.getText();
   String coxaesq3 = CalcCoxaEsq1.getText();
   
   String pantdir1 = txtPanturrilhaDir.getText();
   String pantdir2 = txtPanturrilhaDir2.getText();
   String pantdir3 = CalcPantDir1.getText();
   
   String pantesq1 = txtPanturrilhaEsq.getText();
   String pantesq2 = txtPanturrilhaEsq2.getText();
   String pantesq3 = CalcPantEsq1.getText();
   
   
   
   
Document documentoPDF = new Document();
    
  try{
    
    PdfWriter.getInstance(documentoPDF, new FileOutputStream("C:\\Users\\Pichau\\Desktop\\Relatório Pacientes\\RelatóriodoPaciente.pdf"));
    
    documentoPDF.open();    
    documentoPDF.setPageSize(PageSize.A4);
    documentoPDF.add(new Paragraph("Relatório de medidas",FontFactory.getFont(FontFactory.COURIER_BOLD,20,BaseColor.GREEN )));
         documentoPDF.add(new Paragraph(" "));
         documentoPDF.add(new Paragraph(dia,FontFactory.getFont(FontFactory.COURIER_BOLD,13,BaseColor.GRAY )));
         documentoPDF.add(new Paragraph(nome ,FontFactory.getFont(FontFactory.COURIER_BOLD,13,BaseColor.GRAY )));
         documentoPDF.add(new Paragraph( idade +" Anos   " +  "Gênero: " + sexo ,FontFactory.getFont(FontFactory.COURIER_BOLD,13,BaseColor.GRAY )));
         
          documentoPDF.add(new Paragraph(" "));
          documentoPDF.add(new Paragraph(" "));
    
    PdfPTable table = new PdfPTable(4);
    PdfPCell cell = new PdfPCell(new Paragraph("MEDIDAS"));
    cell.setColspan(4);
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell.setBackgroundColor(BaseColor.RED);
    table.addCell(cell);
    
  

   
     
     table.addCell(" ");
     table.addCell(data1);
     table.addCell(data2);
     table.addCell("Resultado");
     
     
     table.addCell("IMC: ");
     table.addCell(Imc1+" "+grau1);
     table.addCell(Imc2+" "+grau2);
     table.addCell(" ");
    
     table.addCell("Taxa Basal: ");
     table.addCell(basal1  );
     table.addCell(basal2 );
     table.addCell(" ");
     
     table.addCell("Nivel Atividade: ");
     table.addCell(atv1 );
     table.addCell(atv2 );
     table.addCell(" ");
     
     
     
     table.addCell("Altura");
     table.addCell(altura1);
     table.addCell(altura2);
     table.addCell(altura3);
     
     table.addCell("Peso:");
     table.addCell(Peso1);
     table.addCell(Peso2);
     table.addCell(Peso3); 
     
     table.addCell("Peitoral:");
     table.addCell(Peitoral1);
     table.addCell(Peitoral2);
     table.addCell(Peitoral3); 

     table.addCell("Quadril:");
     table.addCell(quadril1);
     table.addCell(quadril2);
     table.addCell(quadril3); 

     table.addCell("Barriga:");
     table.addCell(barriga1);
     table.addCell(barriga2);
     table.addCell(barriga3); 
     
     table.addCell("Braço Direito:");
     table.addCell( bracodir1);
     table.addCell( bracodir2);
     table.addCell( bracodir3); 
    
             
     table.addCell("Braço Esquerdo:");
     table.addCell(bracoesq1);
     table.addCell(bracoesq2);
     table.addCell(bracoesq3); 
     
     table.addCell("Coxa Direita:");
     table.addCell(coxadir1);
     table.addCell(coxadir2);
     table.addCell(coxadir3); 
     
     table.addCell("Coxa Esquerda:");
     table.addCell(coxaesq1);
     table.addCell(coxaesq2);
     table.addCell(coxaesq3); 
     
     table.addCell("Panturrilha Direita:");
     table.addCell(pantdir1);
     table.addCell(pantdir2);
     table.addCell(pantdir3); 
     
     table.addCell("Panturrilha Esquerda:");
     table.addCell(pantesq1);
     table.addCell(pantesq2);
     table.addCell(pantesq3); 
     
     
    documentoPDF.add(table);
    
   
} 
  catch(DocumentException de){ de.printStackTrace();} 
   
  catch(IOException ioe){    ioe.printStackTrace();}

    finally {
    documentoPDF.close();
}
    
    
    
}
   
   
    
    
    
    public RelatorioCliente() {
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        txtIDPaciente = new javax.swing.JTextField();
        txtIdMedida1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeDoPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisaMedidas = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMedidas = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblmedida2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtBasal2 = new javax.swing.JLabel();
        lblImc2 = new javax.swing.JLabel();
        txtImc2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtAtividade1 = new javax.swing.JLabel();
        txtBuscarMedidas1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lblData1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtAltura2 = new javax.swing.JLabel();
        txtPanturrilhaEsq2 = new javax.swing.JLabel();
        txtPanturrilhaDir2 = new javax.swing.JLabel();
        txtCoxaEsq2 = new javax.swing.JLabel();
        txtCoxaDir2 = new javax.swing.JLabel();
        txtBraçoEsq2 = new javax.swing.JLabel();
        txtBraçoDir2 = new javax.swing.JLabel();
        txtBarriga2 = new javax.swing.JLabel();
        txtQuadril2 = new javax.swing.JLabel();
        txtPeitoral2 = new javax.swing.JLabel();
        txtPeso2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        CalcAltura1 = new javax.swing.JLabel();
        CalcPeso1 = new javax.swing.JLabel();
        CalcPeitoral2 = new javax.swing.JLabel();
        CalcQuadril1 = new javax.swing.JLabel();
        CalcBarriga1 = new javax.swing.JLabel();
        CalcBraDir1 = new javax.swing.JLabel();
        CalcBraEsq1 = new javax.swing.JLabel();
        CalcCoxaDir1 = new javax.swing.JLabel();
        CalcCoxaEsq1 = new javax.swing.JLabel();
        CalcPantDir1 = new javax.swing.JLabel();
        CalcPantEsq1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lblImc1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtBasal = new javax.swing.JLabel();
        txtImc1 = new javax.swing.JLabel();
        txtAtividade = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtBuscarMedidas = new javax.swing.JTextField();
        txtData = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtAltura = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPanturrilhaEsq = new javax.swing.JLabel();
        txtPanturrilhaDir = new javax.swing.JLabel();
        txtCoxaEsq = new javax.swing.JLabel();
        txtCoxaDir = new javax.swing.JLabel();
        txtBraçoEsq = new javax.swing.JLabel();
        txtBraçoDir = new javax.swing.JLabel();
        txtBarriga = new javax.swing.JLabel();
        txtQuadril = new javax.swing.JLabel();
        txtPeitoral = new javax.swing.JLabel();
        txtPeso = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();

        setClosable(true);
        setForeground(new java.awt.Color(255, 102, 102));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Calculos");

        jPanel2.setForeground(new java.awt.Color(0, 102, 204));

        txtIDPaciente.setEnabled(false);
        txtIDPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPacienteActionPerformed(evt);
            }
        });

        txtIdMedida1.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nome:");

        txtNomeDoPaciente.setEnabled(false);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("*ID Paciente");

        txtPesquisaMedidas.setEnabled(false);
        txtPesquisaMedidas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPesquisaMedidasCaretUpdate(evt);
            }
        });
        txtPesquisaMedidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisaMedidasMouseClicked(evt);
            }
        });
        txtPesquisaMedidas.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtPesquisaMedidasCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtPesquisaMedidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaMedidasKeyReleased(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Idade:");

        lblIdade.setForeground(new java.awt.Color(0, 0, 0));
        lblIdade.setText("idade");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Sexo:");

        lblSexo.setText("...");

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

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selecione o Paciente:");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addComponent(txtNomeDoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel26)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdade)
                            .addComponent(txtPesquisaMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNomeDoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPesquisaMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(lblIdade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Selecione a primeira medida que deseja comparar:");

        tblMedidas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblMedidas.setBackground(new java.awt.Color(255, 255, 255));
        tblMedidas.setForeground(new java.awt.Color(0, 0, 255));
        tblMedidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Da_Medida", "DataDaMedição"
            }
        ));
        tblMedidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedidasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMedidas);

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Selecione a segunda medida que deseja comparar:");

        jScrollPane4.setMinimumSize(new java.awt.Dimension(265, 265));

        tblmedida2.setBackground(new java.awt.Color(255, 255, 255));
        tblmedida2.setForeground(new java.awt.Color(0, 0, 255));
        tblmedida2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Id_Da_Medida", "DataDaMedição"
            }
        ));
        tblmedida2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmedida2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblmedida2);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setForeground(new java.awt.Color(0, 51, 255));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Taxa Metabolica Basal:");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("IMC:");

        txtBasal2.setBackground(new java.awt.Color(0, 51, 255));
        txtBasal2.setForeground(new java.awt.Color(0, 51, 255));
        txtBasal2.setText("...");

        lblImc2.setBackground(new java.awt.Color(0, 51, 255));
        lblImc2.setForeground(new java.awt.Color(0, 51, 255));
        lblImc2.setText("Grau de obesidade:");

        txtImc2.setBackground(new java.awt.Color(0, 51, 255));
        txtImc2.setForeground(new java.awt.Color(0, 51, 255));
        txtImc2.setText("...");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nivel de Atividade:");

        txtAtividade1.setBackground(new java.awt.Color(0, 51, 255));
        txtAtividade1.setForeground(new java.awt.Color(0, 51, 255));
        txtAtividade1.setText("...");

        txtBuscarMedidas1.setBackground(new java.awt.Color(60, 63, 65));
        txtBuscarMedidas1.setEnabled(false);
        txtBuscarMedidas1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarMedidas1CaretUpdate(evt);
            }
        });
        txtBuscarMedidas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarMedidas1ActionPerformed(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ID da Medida");

        lblData1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblData1.setForeground(new java.awt.Color(0, 51, 255));
        lblData1.setText("Data");

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setForeground(new java.awt.Color(0, 0, 0));

        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("CoxaEsq:");

        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("BraçoDir:");

        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Quadril:");

        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("PanturrilhaEsq:");

        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("BraçoEsq:");

        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Barriga:");

        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Altura:");

        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Peso:");

        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("CoxaDir:");

        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Peitoral:");

        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("PanturrilhaDir:");

        txtAltura2.setText("0");

        txtPanturrilhaEsq2.setText("0");

        txtPanturrilhaDir2.setText("0");

        txtCoxaEsq2.setText("0");

        txtCoxaDir2.setText("0");

        txtBraçoEsq2.setText("0");

        txtBraçoDir2.setText("0");

        txtBarriga2.setText("0");

        txtQuadril2.setText("0");

        txtPeitoral2.setText("0");

        txtPeso2.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPeso2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAltura2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPeitoral2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtQuadril2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBarriga2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBraçoDir2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBraçoEsq2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCoxaDir2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCoxaEsq2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPanturrilhaDir2))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(txtPanturrilhaEsq2)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAltura2)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtPeso2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtPeitoral2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtQuadril2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtBarriga2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtBraçoDir2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtBraçoEsq2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtCoxaDir2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtCoxaEsq2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtPanturrilhaDir2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtPanturrilhaEsq2)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBasal2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtImc2)
                                .addGap(12, 12, 12)
                                .addComponent(lblImc2))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txtAtividade1))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarMedidas1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblData1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblData1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarMedidas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtBasal2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImc2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(txtImc2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtAtividade1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setForeground(new java.awt.Color(153, 153, 153));

        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("PanturrilhaEsq:");

        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("PanturrilhaDir:");

        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setText("CoxaEsq:");

        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("CoxaDir:");

        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("BraçoEsq:");

        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("BraçoDir:");

        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Barriga:");

        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("Quadril:");

        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Peitoral:");

        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Peso:");

        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Altura:");

        CalcAltura1.setText("-");

        CalcPeso1.setText("-");

        CalcPeitoral2.setText("-");

        CalcQuadril1.setText("-");

        CalcBarriga1.setText("-");

        CalcBraDir1.setText("-");

        CalcBraEsq1.setText("-");

        CalcCoxaDir1.setText("-");

        CalcCoxaEsq1.setText("-");

        CalcPantDir1.setText("-");

        CalcPantEsq1.setText("-");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel60)
                    .addComponent(jLabel59)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57)
                    .addComponent(jLabel56)
                    .addComponent(jLabel55)
                    .addComponent(jLabel54)
                    .addComponent(jLabel53)
                    .addComponent(jLabel52))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalcPeso1)
                            .addComponent(CalcAltura1)
                            .addComponent(CalcQuadril1)
                            .addComponent(CalcBarriga1)
                            .addComponent(CalcBraDir1)
                            .addComponent(CalcBraEsq1)
                            .addComponent(CalcCoxaDir1)
                            .addComponent(CalcCoxaEsq1)
                            .addComponent(CalcPeitoral2)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalcPantEsq1)
                            .addComponent(CalcPantDir1))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(CalcAltura1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(CalcPeso1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(CalcPeitoral2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(CalcQuadril1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(CalcBarriga1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(CalcBraDir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(CalcBraEsq1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(CalcCoxaDir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(CalcCoxaEsq1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(CalcPantDir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(CalcPantEsq1)))
        );

        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setText("Gerar Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("IMC:");

        lblImc1.setForeground(new java.awt.Color(255, 255, 255));
        lblImc1.setText("Grau de obesidade:");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Taxa Metabolica Basal:");

        txtBasal.setForeground(new java.awt.Color(0, 51, 255));
        txtBasal.setText("...");

        txtImc1.setForeground(new java.awt.Color(0, 102, 255));
        txtImc1.setText("...");

        txtAtividade.setForeground(new java.awt.Color(0, 51, 255));
        txtAtividade.setText("...");

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nivel de Atividade:");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ID da Medida");

        txtBuscarMedidas.setBackground(new java.awt.Color(60, 63, 65));
        txtBuscarMedidas.setEnabled(false);
        txtBuscarMedidas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarMedidasCaretUpdate(evt);
            }
        });
        txtBuscarMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarMedidasActionPerformed(evt);
            }
        });

        txtData.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        txtData.setForeground(new java.awt.Color(0, 51, 255));
        txtData.setText("Data");

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setForeground(new java.awt.Color(153, 153, 153));
        jPanel6.setMaximumSize(new java.awt.Dimension(315, 236));
        jPanel6.setMinimumSize(new java.awt.Dimension(315, 236));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Altura:");

        txtAltura.setText("0");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Peso:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Peitoral:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Quadril:");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Barriga:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("BraçoDir:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("BraçoEsq:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CoxaDir:");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("CoxaEsq:");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("PanturrilhaDir:");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("PanturrilhaEsq:");

        txtPanturrilhaEsq.setText("0");

        txtPanturrilhaDir.setText("0");

        txtCoxaEsq.setText("0");

        txtCoxaDir.setText("0");

        txtBraçoEsq.setText("0");

        txtBraçoDir.setText("0");

        txtBarriga.setText("0");

        txtQuadril.setText("0");

        txtPeitoral.setText("0");

        txtPeso.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPanturrilhaEsq))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAltura)
                                    .addComponent(txtQuadril)
                                    .addComponent(txtBarriga)
                                    .addComponent(txtBraçoDir)
                                    .addComponent(txtBraçoEsq)
                                    .addComponent(txtCoxaDir)
                                    .addComponent(txtCoxaEsq)
                                    .addComponent(txtPeitoral)
                                    .addComponent(txtPeso)
                                    .addComponent(txtPanturrilhaDir))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAltura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPeitoral))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQuadril))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtBarriga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBraçoDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBraçoEsq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCoxaDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCoxaEsq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPanturrilhaDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPanturrilhaEsq)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(txtBasal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(16, 16, 16)
                                .addComponent(txtImc1)
                                .addGap(18, 18, 18)
                                .addComponent(lblImc1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(txtAtividade))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtBuscarMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtBasal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblImc1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImc1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtAtividade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel63.setBackground(new java.awt.Color(255, 0, 0));
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Comparação entre os dois meses selecionados:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3006, Short.MAX_VALUE)
                .addComponent(txtIdMedida1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2754, 2754, 2754)
                .addComponent(txtIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2243, 2243, 2243))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(txtIdMedida1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 1033, Short.MAX_VALUE)
                .addComponent(txtIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(11, 11, 11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1223, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblmedida2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmedida2MouseClicked
        setar_campos_Tabela_Medidas2();        // TODO add your handling code here:
    }//GEN-LAST:event_tblmedida2MouseClicked

    private void tblMedidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedidasMouseClicked
        setar_campos_Tabela_Medidas();           // TOsDO add your handling code here:
    }//GEN-LAST:event_tblMedidasMouseClicked

    private void tlbTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbTableMouseClicked
        setarCampos();   // TODO add your handling code here:
    }//GEN-LAST:event_tlbTableMouseClicked

    private void txtPesquisaMedidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaMedidasKeyReleased
        pesquisarMedidas();
        pesquisarMedidas2();// TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaMedidasKeyReleased

    private void txtPesquisaMedidasCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPesquisaMedidasCaretPositionChanged

    }//GEN-LAST:event_txtPesquisaMedidasCaretPositionChanged

    private void txtPesquisaMedidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisaMedidasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaMedidasMouseClicked

    private void txtPesquisaMedidasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPesquisaMedidasCaretUpdate
        pesquisarMedidas();
        pesquisarMedidas2();
        Buscar3();// TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaMedidasCaretUpdate

    private void txtBuscarMedidas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarMedidas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMedidas1ActionPerformed

    private void txtBuscarMedidas1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarMedidas1CaretUpdate
        Buscar2();
        calcular();  // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMedidas1CaretUpdate

    private void txtBuscarMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarMedidasActionPerformed
       Buscar1();
       calcular();  
       
        
    }//GEN-LAST:event_txtBuscarMedidasActionPerformed

    private void txtBuscarMedidasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarMedidasCaretUpdate
        Buscar1();
        calcular();  
        
    }//GEN-LAST:event_txtBuscarMedidasCaretUpdate

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        pesquisarPaciente();        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtIDPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPacienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  pdf();      
  JOptionPane.showMessageDialog(null,"Relatório Gerado com sucesso");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CalcAltura1;
    private javax.swing.JLabel CalcBarriga1;
    private javax.swing.JLabel CalcBraDir1;
    private javax.swing.JLabel CalcBraEsq1;
    private javax.swing.JLabel CalcCoxaDir1;
    private javax.swing.JLabel CalcCoxaEsq1;
    private javax.swing.JLabel CalcPantDir1;
    private javax.swing.JLabel CalcPantEsq1;
    private javax.swing.JLabel CalcPeitoral2;
    private javax.swing.JLabel CalcPeso1;
    private javax.swing.JLabel CalcQuadril1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblImc1;
    private javax.swing.JLabel lblImc2;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JTable tblMedidas;
    private javax.swing.JTable tblmedida2;
    private javax.swing.JTable tlbTable;
    private javax.swing.JLabel txtAltura;
    private javax.swing.JLabel txtAltura2;
    private javax.swing.JLabel txtAtividade;
    private javax.swing.JLabel txtAtividade1;
    private javax.swing.JLabel txtBarriga;
    private javax.swing.JLabel txtBarriga2;
    private javax.swing.JLabel txtBasal;
    private javax.swing.JLabel txtBasal2;
    private javax.swing.JLabel txtBraçoDir;
    private javax.swing.JLabel txtBraçoDir2;
    private javax.swing.JLabel txtBraçoEsq;
    private javax.swing.JLabel txtBraçoEsq2;
    private javax.swing.JTextField txtBuscarMedidas;
    private javax.swing.JTextField txtBuscarMedidas1;
    private javax.swing.JLabel txtCoxaDir;
    private javax.swing.JLabel txtCoxaDir2;
    private javax.swing.JLabel txtCoxaEsq;
    private javax.swing.JLabel txtCoxaEsq2;
    private javax.swing.JLabel txtData;
    private javax.swing.JTextField txtIDPaciente;
    private javax.swing.JTextField txtIdMedida1;
    private javax.swing.JLabel txtImc1;
    private javax.swing.JLabel txtImc2;
    private javax.swing.JTextField txtNomeDoPaciente;
    private javax.swing.JLabel txtPanturrilhaDir;
    private javax.swing.JLabel txtPanturrilhaDir2;
    private javax.swing.JLabel txtPanturrilhaEsq;
    private javax.swing.JLabel txtPanturrilhaEsq2;
    private javax.swing.JLabel txtPeitoral;
    private javax.swing.JLabel txtPeitoral2;
    private javax.swing.JLabel txtPeso;
    private javax.swing.JLabel txtPeso2;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPesquisaMedidas;
    private javax.swing.JLabel txtQuadril;
    private javax.swing.JLabel txtQuadril2;
    // End of variables declaration//GEN-END:variables
}

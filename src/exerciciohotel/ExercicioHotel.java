package exerciciohotel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExercicioHotel extends JFrame implements ActionListener{
    JLabel L1,L2,L3,L4,L5;
    JTextField T1,T2,T3;
    JComboBox CB1;
    JPanel P1,P2, P3;
    JButton B1,B2;
    JTextArea TA1;
    ExercicioHotel()
    {
        //getContentPane().setLayout(new BorderLayout());
        L1 = new JLabel ("Nome do Hóspede:");
        L2 = new JLabel ("Tipo do Quarto:");
        L3 = new JLabel ("Número de diárias:");
        L4 = new JLabel ("Valor do consumo:");
        L5 = new JLabel();
        T1 = new JTextField();
        T2 = new JTextField();
        T3 = new JTextField();
        String[] items = {"TIPO A - R$ 150,00","TIPO B - R$ 100,00","TIPO C - R$ 75,00","TIPO D - R$ 50,00"};
        CB1 = new JComboBox(items);
        B1 = new JButton("Calcular conta"); B1.addActionListener(this);
        B2 = new JButton("Limpar"); B2.addActionListener(this);
        
        TA1 = new JTextArea("", 10,35);
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK);
        TA1.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        TA1.setEnabled(false);
        TA1.setDisabledTextColor(Color.BLACK);
     
        P1 = new JPanel();
        P1.setLayout(new GridLayout(6,2));
        P2 = new JPanel();
        P2.setLayout(new FlowLayout(FlowLayout.CENTER));
        P3 = new JPanel();
        P3.setLayout(new GridLayout(3,1));
        
        P1.add(L1);P1.add(T1);
        P1.add(L2);P1.add(CB1);
        P1.add(L3);P1.add(T2);
        P1.add(L4);P1.add(T3);
        //P1.add(B1);P1.add(B2);
        
        P2.add(TA1);
        
        P1.add(B1);
        P1.add(B2);
        
        getContentPane().add(P1);
        getContentPane().add(P2);

    }
    
    @Override
        public void actionPerformed(ActionEvent e)
    {
        
        
        String Nome, TipoQuarto,  Mostrar;
        int NumeroDiarias;
        double ValorConsumo, ValorUnitDiaria, ValorTotDiaria, SubTotal, TaxaServico, ValorFinal;
        try{   
        if(e.getSource() == B1){
        Nome = T1.getText();
        TipoQuarto = CB1.getSelectedItem().toString();
        NumeroDiarias = Integer.parseInt(T2.getText());
        ValorConsumo = Double.parseDouble(T3.getText());
        
        switch (CB1.getSelectedIndex()) 
           {
            case 0:
                ValorUnitDiaria = 150.00;
                break;
            case 1:
                ValorUnitDiaria = 100.00;
                break;
            case 2:
                ValorUnitDiaria = 75.00;
                break;
            default:
                ValorUnitDiaria = 50.00;
                break;
            }
            
        
        ValorTotDiaria = ValorUnitDiaria * NumeroDiarias;
        SubTotal = ValorTotDiaria + ValorConsumo;
        TaxaServico = (SubTotal * 10)/100;
        ValorFinal = SubTotal + TaxaServico;
        
        Mostrar = ("Nome: "+Nome+"\n Tipo do Apartamento: "+TipoQuarto+"\n Número de Diárias: "+NumeroDiarias+
          "\n Valor Total (Diárias): "+ValorTotDiaria+
          "\n Valor Total (Consumo Interno): "+ValorConsumo+
          "\n Subtotal: "+SubTotal+"\n Taxa de Serviço: "+TaxaServico+"\n Valor Final: "+ValorFinal); 
        TA1.setText(Mostrar);
        T1.setText("");
        T2.setText("");
        T3.setText("");
        CB1.setSelectedIndex(0);
        }
        }
        catch(NumberFormatException erro){
            JOptionPane.showMessageDialog(null, "Digite Valores Válidos!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        if(e.getSource() == B2) {
        TA1.setText("");
        T1.setText("");
        T2.setText("");
        T3.setText("");
        CB1.setSelectedIndex(0);
        }        
    }
        
    public static void main(String[] args) 
    {
        JFrame janela = new ExercicioHotel();
        
       janela.setUndecorated(true);
       janela.setSize(640, 460);
       janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
       janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       janela.setVisible(true); 
       janela.setTitle("Exercício Hotel");
       janela.setBounds(450,450,450,450);
       janela.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

    }   
}
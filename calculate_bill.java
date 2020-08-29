
package electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calculate_bill extends JFrame implements ActionListener{
   JLabel l1,l2,l3,l4,l5;
   JTextField t1;
   Choice c1 ,c2;
   JButton b1,b2;
   JPanel p;
   
   calculate_bill()
   {
       p = new JPanel();
       p.setLayout( new GridLayout(4,2,30,30));
       p.setBackground(Color.WHITE);
       
       l1= new JLabel ("Calculate Electricity bill");
       l2 = new JLabel("Month");
       l3 = new JLabel("Meter No");
       l5 = new JLabel("unit consumed");
       
       t1 = new JTextField();
       
       c1= new Choice();
       c1.add("January");
       c1.add("February");
       c1.add("March");
       c1.add("April");
       c1.add("May");
       c1.add("June");
       c1.add("July");
       c1.add("August");
       c1.add("September");
       c1.add("November");
       c1.add("December");
       
       c2= new Choice();
       
       c2.add("1001");
       c2.add("1002");
       c2.add("1003");
       c2.add("1004");
       c2.add("1005");
       c2.add("1006");
       c2.add("1007");
       c2.add("1008");
             
       
       b1= new JButton("Submit");
       b2= new JButton("Cancel");
       
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       
       ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("electricity/icon/hicon2.jpg"));
       Image i3 = ic3.getImage().getScaledInstance(180,270,Image.SCALE_DEFAULT);
       ImageIcon ic4 = new ImageIcon(i3);
       l4 = new JLabel(ic4); 
       
       l1.setFont(new Font("Senserif",Font.PLAIN,26));
       l1.setHorizontalAlignment(JLabel.CENTER);
       
       p.add(l2);
       p.add(c1);
       p.add(l3);
       p.add(c2);
       p.add(l5);
       p.add(t1);
       p.add(b1);
       p.add(b2);
       
       setLayout(new BorderLayout(30,30));
       
       add(l1,"North");
       add(p,"Center");
       add(l4,"West");

                   
       getContentPane().setBackground(Color.WHITE);
       setSize(650,500);
       setLocation(350,220);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
          String a = c2.getSelectedItem();
        String b = t1.getText();
        String c = c1.getSelectedItem();
        
        int p1 = Integer.parseInt(b);
        
        int p2 = p1*7;
        int p3 = p2+50+12+102+20+50;
        
        String q = "insert into bill values('"+a+"','"+c+"','"+b+"','"+p3+"')";
        
        try{
            conn c1 = new conn();
            c1.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Bill Updated");
        }catch(Exception aee){
            aee.printStackTrace();
        }        
    } 
    public static void main(String[] args) {
        new calculate_bill().setVisible(true);
    }
}

 
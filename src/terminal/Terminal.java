
package terminal;
import java.awt.*;
import static java.awt.Color.white;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.swing.*;

/**
 * Terminal program 
 * @Yash Srivastava 
 */
public class Terminal  {
    
    private JLabel machinename;
    private JTextField command;
    private JFrame frame; 
    private JPanel p;
    
    Terminal()
    {
        
        
        frame = new JFrame("Terminal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(500,300);
        p = new JPanel();
//frame.setLayout(new GridLayout());
        p.setBackground(Color.black);
        p.setLocation(0, 0);
        machinename = new JLabel("BA$H");
        machinename.setLocation(0, 0);
        machinename.setForeground(white);
        command = new JTextField(10);
        p.add(machinename);
        p.add(command);
        frame.add(p);
        frame.setVisible(true);
        command.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                        
               File file,file2;
               String s = command.getText().toString();             //getting the command 
               
               String[] str = s.split(" ");
               
               if(str[0].equals("mkdir"))
               {                
                   command.setText("");
                   file = new File("C:\\"+str[1]);
                   if (!file.exists()) {
                       if (file.mkdir()) {
                           System.out.println("Directory is created!");
                       }
                       else {
                           System.out.println("Failed to create directory!");
                       }   } 
                   else { System.out.println("Hello");
                    }
               }
               
               if(s.equals("touch"))
               {
                   command.setText("");
                   try {
                       file2 = new File("C:\\Users\\Dell\\Desktop\\olala.txt");
                       if(file2.createNewFile())
                       {
                           System.out.println(" file created");
                           String t = file2.getPath();
                           System.out.println("\n"+t);
                       }
                   } catch (IOException ex) {
                       Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
               if(s.equals("exit"))
               {
                   System.out.println("Hello its closing now");
                   frame.setVisible(false); 
                   frame.dispose();
               }
        
    }});
    
    }
    public static void main(String[] args) {
        
            Terminal t = new Terminal();
            

        
    }
    
}

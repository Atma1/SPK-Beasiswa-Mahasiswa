import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main extends JFrame implements ActionListener {
    
    JTextField tf = new JTextField();;
    
    main() {
        JFrame frame = new JFrame();
        
        tf.setBounds(50, 50, 150, 20);
 
        JButton button = new JButton(" GFG WebSite Click");
 
        button.setBounds(150, 200, 220, 50);
        
        button.addActionListener(this);
 
        frame.add(tf);
         
        frame.add(button);
 
        frame.setSize(500, 600);
 
        frame.setLayout(null);
 
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(tf.getText());
    }
    
}

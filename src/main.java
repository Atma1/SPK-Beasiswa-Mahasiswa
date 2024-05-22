import component_login_register.Login;
import javax.swing.WindowConstants;

public class main {
    
    
    public static void main(String args[]) {
        Login LoginForm = new Login();
        LoginForm.setVisible(true);
        LoginForm.pack();
        LoginForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}

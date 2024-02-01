import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
public class LOGIN {
    private static IOFile F;
    private void DrawCanvas() {
        ImageIcon img = new ImageIcon("H1.jpg");
        JFrame LoginFrame = new JFrame("Login");
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel Text = new JLabel("Please login your account!!");
        JButton RegisterButton;
        JLabel Login;
        JLabel PasswordLabel;
        JButton SummitButton;
        JScrollPane jScrollPane1;
        JLabel nameLabel;
        JPasswordField password;
        JTextArea username;
        Login = new JLabel();
        PasswordLabel = new JLabel();
        SummitButton = new JButton();
        jScrollPane1 = new JScrollPane();
        nameLabel = new JLabel();
        password = new JPasswordField();
        username = new JTextArea();
        RegisterButton = new JButton("Register");
        RegisterButton.setFont(new java.awt.Font("Harrington", 2, 18));
        RegisterButton.setForeground(new java.awt.Color(102, 51, 255));

        Login.setFont(new java.awt.Font("Harrington", 2, 18));
        Login.setForeground(new java.awt.Color(102, 51, 255));
        Login.setText("Login");

        PasswordLabel.setText("Password");
        PasswordLabel.setFont(new java.awt.Font("Harrington", 2, 18));
        PasswordLabel.setForeground(new java.awt.Color(102, 51, 255));

        nameLabel.setText("Username");
        nameLabel.setFont(new java.awt.Font("Harrington", 2, 18));
        nameLabel.setForeground(new java.awt.Color(102, 51, 255));

        password.setText("");
        username.setColumns(20);
        username.setRows(5);
        jScrollPane1.setViewportView(username);
        SummitButton.setText("Summit");
        SummitButton.setFont(new java.awt.Font("Harrington", 2, 18));
        SummitButton.setForeground(new java.awt.Color(102, 51, 255));
        
        
        password.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                password.setText("");
            }
        });
        SummitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = username.getText();
                String pass = new String(password.getPassword());
                    if(name.equals("")) {
                        System.out.println("Login Fail!!");
                        Text.setText("Pls input your username!!!");
                        Text.setFont(new java.awt.Font("Segoe UI", 1, 10));
                        Text.setForeground(new Color(255, 0, 0));
                        Text.setBounds(140, 60 + 22 + 26 + 30, 230, 20);
                    }
                    else if (pass.equals("")) {
                        System.out.println("Login Fail!!");
                        Text.setText("Pls input your password!!!");
                        Text.setFont(new java.awt.Font("Segoe UI", 1, 10));
                        Text.setForeground(new Color(255, 0, 0));
                        Text.setBounds(140, 60 + 22 + 26 + 30, 230, 20);
                    }
                    else if (F.Find(name, pass)) {
                        System.out.println("Login Success!!");
                        F.Print_Info();
                        LoginFrame.dispose();
                        StatusCanvas();
                    } else {
                        System.out.println("Login Fail!!");
                        Text.setText("Incorrect username or password!!!");
                        Text.setFont(new java.awt.Font("Segoe UI", 1, 10));
                        Text.setForeground(new Color(255, 0, 0));
                        Text.setBounds(110, 60 + 22 + 26 + 30, 230, 20);
                    }
            }
        });
        RegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame.dispose();
                RegisterCanvas();
            }
        });
        Text.setFont(new java.awt.Font("Segoe UI", 2, 10));
        Text.setBounds(140, 60 + 22 + 26 + 30, 230, 20);

        Login.setBounds(160, 40, 69, 22);
        PasswordLabel.setBounds(60, 60 + 22 + 26, 100, 16);
        nameLabel.setBounds(60, 60 + 22, 100, 16);

        password.setBounds(160, 60 + 22 + 26, 150, 20);
        username.setBounds(160, 60 + 22, 150, 20);
        SummitButton.setBounds(80, 60 + 22 + 26 + 40 + 20, 100, 20);
        RegisterButton.setBounds(180, 60 + 22 + 26 + 40 + 20 , 100, 20);

        LoginFrame.add(Login);
        LoginFrame.add(PasswordLabel);
        LoginFrame.add(SummitButton);
        LoginFrame.add(jScrollPane1);
        LoginFrame.add(nameLabel);
        LoginFrame.add(password);
        LoginFrame.add(username);
        LoginFrame.add(Text);
        LoginFrame.add(RegisterButton);
        LoginFrame.setResizable(false);
        LoginFrame.setSize(380, 300);
        LoginFrame.setLayout(null);
        LoginFrame.setVisible(true);
        LoginFrame.setLocation(600,250);
        LoginFrame.setIconImage(img.getImage());
    }

    //_______________________________________________________________________________________________________________________________________
    private void RegisterCanvas() {
        ImageIcon img = new ImageIcon("H1.jpg");
        JFrame  RegisterFrame = new JFrame("Register");
        JTextArea Description;
        JButton jButton1;
        JLabel jLabel1;
        JLabel jLabel2;
        JLabel jLabel3;
        JLabel jLabel4;
        JLabel jLabel5;
        JLabel jLabel6;
        JLabel jLabel7;
        JTextField name;
        JPasswordField password;
        JTextField phone;
        JTextField username;
        jLabel1     = new JLabel();
        jLabel2     = new JLabel();
        jLabel3     = new JLabel();
        jLabel4     = new JLabel();
        jLabel5     = new JLabel();
        jLabel6     = new JLabel();
        jLabel7     = new JLabel();
        username    = new JTextField();
        password    = new JPasswordField();
        name        = new JTextField();
        phone       = new JTextField();
        Description = new JTextArea();
        jButton1    = new JButton();
        //___________________________________________________________________________________________
        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 18));
        jLabel1.setForeground(new java.awt.Color(50, 25, 200));
        jLabel1.setText("Register");
        jLabel1.setBounds(140, 40, 100, 20);

        jLabel2.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setText("Username");
        jLabel2.setBounds(40, 70, 100, 20);
        
        username.setBounds(140, 70, 200, 20);

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Password");
        jLabel3.setBounds(40, 110, 100, 20);

        password.setBounds(140, 110, 200, 20);

        jLabel4.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Name");
        jLabel4.setBounds(40, 150, 100, 20);

        name.setBounds(140, 150, 200, 20);

        jLabel5.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Phone");
        jLabel5.setBounds(40, 190, 100, 20);

        phone.setBounds(140, 190, 200, 20);
        
        jLabel6.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Description");
        jLabel6.setBounds(40, 230, 100, 20);

        Description.setBounds(140, 230, 200, 40);
        Description.setColumns(20);
        Description.setRows(5);

        JScrollPane jScrollPane1 = new JScrollPane(Description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                                                              , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setBounds(140, 230, 200, 60);
        
        jButton1.setText("Register");
        jButton1.setBounds(140, 300, 100, 30);
        //___________________________________________________________________________________________
        //Summittion:

        //___________________________________________________________________________________________
        RegisterFrame.add(jLabel1);
        RegisterFrame.add(jLabel2);
        RegisterFrame.add(jLabel3);
        RegisterFrame.add(jLabel4);
        RegisterFrame.add(jLabel5);
        RegisterFrame.add(jLabel6);
        RegisterFrame.add(jLabel7);
        RegisterFrame.add(username);
        RegisterFrame.add(password);
        RegisterFrame.add(name);
        RegisterFrame.add(phone);
        RegisterFrame.add(jScrollPane1);
        //RegisterFrame.add(Description);
        RegisterFrame.add(jButton1);
        RegisterFrame.setSize(400, 400);
        RegisterFrame.setResizable(false);
        RegisterFrame.setLayout(null);
        RegisterFrame.setVisible(true);
        RegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RegisterFrame.setLocation(600, 200);
        RegisterFrame.setIconImage(img.getImage());
    }
    //_______________________________________________________________________________________________________________________________________
    private void StatusCanvas() {
        JFrame StatusFrame = new JFrame("Status");
        ImageIcon img = new ImageIcon("H1.jpg");
        
        JLabel jLabel1 = new JLabel("Name:");
        jLabel1.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel1.setForeground(new java.awt.Color(102, 51, 255));
        jLabel1.setBounds(40, 70, 92, 20);
        
        JLabel jLabel2 = new JLabel("Phone:");
        jLabel2.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel2.setForeground(new java.awt.Color(102, 51, 255));
        jLabel2.setBounds(40, 90 + 20, 92, 20);
        
        JLabel jLabel3 = new JLabel("Role:");
        jLabel3.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel3.setForeground(new java.awt.Color(102, 51, 255));
        jLabel3.setBounds(40, 110 + 40, 92, 20);
        
        JLabel jLabel4 = new JLabel("Description:");
        jLabel4.setFont(new java.awt.Font("SimSun", 1, 14));
        jLabel4.setForeground(new java.awt.Color(102, 51, 255));
        jLabel4.setBounds(40, 130 + 60, 92, 20);
        
        Container User = F.getUser();
        JLabel jLabel5 = new JLabel();
        jLabel5.setText(User.getName());
        jLabel5.setBounds(132, 70, 100, 20);

        JLabel jLabel6 = new JLabel();
        jLabel6.setText(User.getPhone());
        jLabel6.setBounds(132, 90 + 20, 100, 20);

        JLabel jLabel7 = new JLabel();
        jLabel7.setText(User.Role());
        jLabel7.setBounds(132, 110 + 40, 100, 20);

        JLabel jLabel8 = new JLabel();
        jLabel8.setText(User.Description());
        jLabel8.setBounds(132, 130 + 60, 100, 20);

        
        StatusFrame.add(jLabel1);
        StatusFrame.add(jLabel2);
        StatusFrame.add(jLabel3);
        StatusFrame.add(jLabel4);
        StatusFrame.add(jLabel5);
        StatusFrame.add(jLabel6);
        StatusFrame.add(jLabel7);
        StatusFrame.add(jLabel8);
        StatusFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        StatusFrame.setLayout(null);
        StatusFrame.setSize(300, 400);
        StatusFrame.setLocation(600,250);
        StatusFrame.setVisible(true);
        StatusFrame.setIconImage(img.getImage());
    }
    public static void main(String[] args) {
        F   = new IOFile();
        F.ImportData("C://Users//Ho Gia Thang//OneDrive//Desktop//JAVA//APP//DATA");
        new LOGIN().DrawCanvas();
    }
};
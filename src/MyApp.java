import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class MyApp extends JFrame{
    JButton b1, b2;
    JLabel l1, l2;
    JPanel p;
    JTextField t;
    JPasswordField pass;
    HashMap<String, String> users = new HashMap<>();


    public MyApp() {

        setSize(1000, 500);
        setTitle("logowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);


        p = new JPanel(null);
        p.setOpaque(true);
        p.setBackground(Color.GRAY);
        add(p);


        b1 = new JButton("login");
        add(b1);
        b1.setBounds(380,300,100,50);
        b1.addActionListener(e -> lgn());


        b2 = new JButton("cancel");
        add(b2);
        b2.setBounds(520,300,100,50);
        b2.addActionListener(e -> rst());


        l1 = new JLabel("       Login:");
        add(l1);
        l1.setBounds(300,150,100,25);


        l2 = new JLabel("Password:");
        add(l2);
        l2.setBounds(300,200,100,25);


        t = new JTextField("");
        add(t);
        t.setBounds(400, 150, 200, 25);


        pass = new JPasswordField("");
        add(pass);
        pass.setBounds(400,200, 200, 25);

        users.put("BaRtO123","12345678");
        users.put("TheLegend27","7653212");
        users.put("Jan","Kowalski");
        users.put("Andrzej","Nowak");

    }

    public void rst() {
        t.setText("");
        pass.setText("");
        p.setBackground(Color.GRAY);
    }

    public void lgn() {
        String x = t.getText();
        String y = String.valueOf(pass.getPassword());
        for(String login : users.keySet())
            if (login.equals(x)) {
                String check = users.get(login);
                if (check.equals(y)) {
                    System.out.println("użytkownik istnieje");
                    p.setBackground(Color.GREEN);
                    return;
                }
            }
        System.out.println("użytkownik nie istnieje");
        p.setBackground(Color.RED);
    }

    static public void main(String[] args) {
        EventQueue.invokeLater(MyApp::new);
    }
}

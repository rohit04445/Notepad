import javax.swing.*;
import java.awt.*;


public class About extends JFrame {
    About(){
        setBounds(500,160,700,600);

        ImageIcon imageIcon=new ImageIcon("src/windows.png");
        Image i=imageIcon.getImage().getScaledInstance(400,80,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(i);
        setLayout(null);

        JLabel jLabel=new JLabel(imageIcon);
        jLabel.setBounds(150,40,400,80);
        add(jLabel);

        ImageIcon imageIcon1=new ImageIcon("src/notepad.png");
        Image i1=imageIcon1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        imageIcon1=new ImageIcon(i1);
        setLayout(null);

        JLabel jLabel1=new JLabel(imageIcon1);
        jLabel1.setBounds(50,180,60,60);
        add(jLabel1);

        JLabel text=new JLabel("<html><b>By Rohit Mittal</b><br> Notepad is a generic text editor included with" +
                "all versions of Microsoft Windows that allows you to create, open, and read plaintext files.<br> " +
                "If the file contains special formatting or is not a plaintext file, it cannot be read in Notepad." +
                "</html>");
        text.setFont(new Font("San Serif",Font.PLAIN,20));
        text.setBounds(120,180,400,200);
        add(text);

        JButton ok=new JButton("OK");
        ok.setBounds(580,500,80,40);

        ok.setFont(new Font("San Serif",Font.PLAIN,20));
        ok.addActionListener(actionEvent -> this.setVisible(false));
         add(ok);
        setResizable(false);
        setVisible(true);
    }

}

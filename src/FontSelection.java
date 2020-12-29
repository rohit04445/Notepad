import javax.swing.*;
import java.awt.*;

public class FontSelection extends JFrame {
    FontSelection()
    {
        setLayout(null);
        JComboBox<String> j1=new JComboBox<>(font_types.font_ch);
        j1.setBounds(10,50,200,50);
        j1.setSelectedItem(font_types.Selected_font_ch);
        add(j1);

        JComboBox<String> j2=new JComboBox<>(font_types.font_size);
        j2.setBounds(210,50,200,50);
        j2.setSelectedItem(font_types.selected_font_size);
        add(j2);

        JComboBox<String> j3=new JComboBox<>(font_types.font_b);
        j3.setBounds(410,50,200,50);
        j3.setSelectedItem(font_types.selected_font_b);
        add(j3);

        JButton button=new JButton("OK");
        button.setFont(new Font("SanSerif",Font.BOLD,20));
        button.setBounds(450,150,150,50);
        button.addActionListener(actionEvent -> {
            font_types.setSelected_font_ch((String) j1.getSelectedItem());
            font_types.setSelected_font_size((String) j2.getSelectedItem());
            font_types.setSelected_font_b((String) j3.getSelectedItem());
            Notepad.textArea.setFont(new Font(font_types.getSelected_font_ch(),font_types.getSelected_font_b(),font_types.getSelected_font_size()));
            setVisible(false);
        });
        add(button);
        setBounds(500,160,700,400);
        setVisible(true);

    }

}

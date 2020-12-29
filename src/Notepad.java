import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.*;
import org.mariuszgromada.math.mxparser.*;

public class Notepad extends JFrame implements ActionListener {
  public static JTextArea textArea=new JTextArea();
    JScrollPane pane;
    UndoManager um=new UndoManager();
    Notepad()
    {
        JMenuBar bar=new JMenuBar();
        setJMenuBar(bar);
        JMenu File=new JMenu("File");
        bar.add(File);

        JMenuItem New=new JMenuItem("New");
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        File.add(New);
        New.addActionListener(this);

        JMenuItem Open=new JMenuItem("Open");
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        File.add(Open);
        Open.addActionListener(this);

        JMenuItem Save=new JMenuItem("Save");
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        File.add(Save);
        Save.addActionListener(this);

        JMenuItem Print=new JMenuItem("Print");
        Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        File.add(Print);
        Print.addActionListener(this);

        JMenuItem Exit=new JMenuItem("Exit");
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        File.add(Exit);
        Exit.addActionListener(this);

        JMenu Commands=new JMenu("Commands");
        bar.add(Commands);

        JMenuItem Copy=new JMenuItem("Copy");
        Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        Commands.add(Copy);
        Copy.addActionListener(this);

        JMenuItem Paste=new JMenuItem("Paste");
        Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        Commands.add(Paste);
        Paste.addActionListener(this);

        JMenuItem Cut=new JMenuItem("Cut");
        Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        Commands.add(Cut);
        Cut.addActionListener(this);

        JMenuItem SelectAll=new JMenuItem("Select All");
        SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        Commands.add(SelectAll);
        SelectAll.addActionListener(this);

        JMenuItem Undo=new JMenuItem("Undo");
        Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
        Commands.add(Undo);
        Undo.addActionListener(this);

        JMenuItem Redo=new JMenuItem("Redo");
        Redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        Commands.add(Redo);
        Redo.addActionListener(this);

        JMenuItem evaluate=new JMenuItem("Evaluate");
        evaluate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        Commands.add(evaluate);
        evaluate.addActionListener(this);

        JMenu Format=new JMenu("Format");
        bar.add(Format);

        JMenu BackgroundColor =new JMenu("BackgroundColor");
        Format.add(BackgroundColor);

        JMenuItem white=new JMenuItem("White");white.addActionListener(this);
        JMenuItem red=new JMenuItem("Red");red.addActionListener(this);
        JMenuItem blue=new JMenuItem("Blue");blue.addActionListener(this);
        JMenuItem pink=new JMenuItem("Pink");pink.addActionListener(this);
        JMenuItem green=new JMenuItem("Green");green.addActionListener(this);
        JMenuItem black=new JMenuItem("Black");black.addActionListener(this);
        BackgroundColor.add(white);
        BackgroundColor.add(red);BackgroundColor.add(blue);BackgroundColor.add(pink);BackgroundColor.add(green);
        BackgroundColor.add(black);


        JMenu TextColor =new JMenu("TextColor");
        Format.add(TextColor);

        JMenuItem white1=new JMenuItem("white");white1.addActionListener(this);
        JMenuItem red1=new JMenuItem("red");red1.addActionListener(this);
        JMenuItem blue1=new JMenuItem("blue");blue1.addActionListener(this);
        JMenuItem pink1=new JMenuItem("pink");pink1.addActionListener(this);
        JMenuItem green1=new JMenuItem("green");green1.addActionListener(this);
        JMenuItem black1=new JMenuItem("black");black1.addActionListener(this);
        TextColor.add(red1);TextColor.add(blue1);TextColor.add(pink1);TextColor.add(green1);
        TextColor.add(black1);TextColor.add(white1);



        JMenuItem font=new JMenuItem("Font");
        Format.add(font);
        font.addActionListener(this);


        JMenu Info=new JMenu("Info");
        bar.add(Info);

        JMenuItem Information=new JMenuItem("About It");
        Info.add(Information);
        Information.addActionListener(this);

        setTitle("Notepad");
        textArea.getDocument().addUndoableEditListener(uee -> um.addEdit(uee.getEdit()));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font(font_types.getSelected_font_ch(),font_types.getSelected_font_b(),font_types.getSelected_font_size()));
        pane=new JScrollPane(textArea);


        add(pane,BorderLayout.CENTER);
        setBounds(0,0,400,400);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "New":
                textArea.setText("");
                setTitle("Notepad");
                break;
            case "Open": {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("Open");
                fileChooser.setApproveButtonMnemonic(KeyEvent.VK_ENTER);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Only Text Files Allowed", "txt"));
                int action = fileChooser.showOpenDialog(this);
                if (action != JFileChooser.APPROVE_OPTION) {
                    return;
                }
                File file = new File(String.valueOf(fileChooser.getSelectedFile()));
                try {
                    setTitle("Notepad  " + fileChooser.getSelectedFile().getName());
                    BufferedReader buffered = new BufferedReader(new FileReader(file));
                    textArea.read(buffered, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            }
            case "Save": {
                File file;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("Save");
                fileChooser.setApproveButtonMnemonic(KeyEvent.VK_ENTER);
                int action = fileChooser.showOpenDialog(this);
                if (action != JFileChooser.APPROVE_OPTION) {
                    return;
                }
                if (fileChooser.getSelectedFile().getName().endsWith(".txt"))
                    file = new File(String.valueOf(fileChooser.getSelectedFile()));

                else
                    file = new File(fileChooser.getSelectedFile() + ".txt");

                try {
                    BufferedWriter buffered = new BufferedWriter(new FileWriter(file));
                    textArea.write(buffered);
                    setTitle("Notepad  " + file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "Print":
                try {
                    textArea.print();
                } catch (PrinterException e) {
                    e.printStackTrace();
                }
                break;
            case "Copy": {
                String selected = textArea.getSelectedText();
                StringSelection data = new StringSelection(selected);
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                cb.setContents(data, data);
                break;
            }
            case "Cut": {
             String  selected = textArea.getSelectedText();
                StringSelection data = new StringSelection(selected);
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                cb.setContents(data, data);
                textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
                break;
            }
            case "Paste":
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                textArea.insert(String.valueOf(cb.getContents(DataFlavor.stringFlavor)), textArea.getCaretPosition());
                break;
            case "Select All":
                textArea.selectAll();
                break;
            case "Evaluate":
                String temp = textArea.getSelectedText();
                Expression exp = new Expression(temp);
                textArea.replaceRange("" + exp.calculate(), textArea.getSelectionStart(), textArea.getSelectionEnd());
                break;

            case "Undo":
                try{ um.undo();}
                catch (Exception ignored) { }
                break;
            case "Redo":
                try{ um.redo();}
                catch (Exception ignored) { }
                break;

            case "Red":
                textArea.setBackground(Color.RED);break;
            case "Blue":
                textArea.setBackground(Color.BLUE);break;
            case "Pink":
                textArea.setBackground(Color.PINK);break;
            case "Black":
                textArea.setBackground(Color.BLACK);break;
            case "Green":
                textArea.setBackground(Color.GREEN);break;
            case "White":
                textArea.setBackground(Color.WHITE);break;

            case "red":
                textArea.setForeground(Color.RED);break;
            case "blue":
                textArea.setForeground(Color.BLUE);break;
            case "pink":
                textArea.setForeground(Color.PINK);break;
            case "black":
                textArea.setForeground(Color.BLACK);break;
            case "green":
                textArea.setForeground(Color.GREEN);break;
            case "white":
                textArea.setForeground(Color.WHITE);break;

            case "Font":
               FontSelection f= new FontSelection();
               f.setVisible(true);
                break;

            case "Exit":
                System.exit(0);

            case "About It":
                new About().setVisible(true);
                break;
        }

    }
}

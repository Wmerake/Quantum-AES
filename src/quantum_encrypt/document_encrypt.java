package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class document_encrypt extends JFrame {
    JButton jb_picture_encrypt;
    JButton jb_audio_encrypt;
    JLabel jl_picture_encrypt;
    JLabel jl_audio_encrypt;
    JButton jb_application_encrypt;
    JButton jb_other_document;
    JLabel jl_application_encrypt;
    JLabel jl_other_document;
    JButton jb_back, menu;

    JLabel jl;

    public document_encrypt() {
        setLayout(new GridBagLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getPreferredSize();
        this.setLocation((screenSize.width - frameSize.width) / 3, (screenSize.height - frameSize.height) / 8);
        this.setLayout(null);
        setSize(358, 583);

        jb_picture_encrypt = new JButton();
        jb_audio_encrypt = new JButton();
        jl_picture_encrypt = new JLabel("图片加密");
        jl_audio_encrypt = new JLabel("音频加密");
        jl_picture_encrypt.setForeground(Color.WHITE);
        jl_audio_encrypt.setForeground(Color.WHITE);
        jb_application_encrypt = new JButton();
        jb_other_document = new JButton();
        jl_application_encrypt = new JLabel("应用加密");
        jl_other_document = new JLabel("其他文件");
        jl_application_encrypt.setForeground(Color.WHITE);
        jl_other_document.setForeground(Color.WHITE);
        jb_back = new JButton();
        menu = new JButton();

        jb_back.setBorderPainted(false);
        menu.setBorderPainted(false);
        jb_picture_encrypt.setBorderPainted(false);
        jb_audio_encrypt.setBorderPainted(false);
        jb_application_encrypt.setBorderPainted(false);
        jb_other_document.setBorderPainted(false);

        jl = new JLabel();
        Icon icon = new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_221_1.png");
        jl.setBounds(0, 0, 358, 583);
        jl.setIcon(icon);
        jb_back.setBounds(3, 3, 55, 55);
        jb_back.setContentAreaFilled(false);
        menu.setBounds(294, 3, 55, 55);
        menu.setContentAreaFilled(false);

        jb_picture_encrypt.setBounds(53, 130, 98, 98);
        jb_audio_encrypt.setBounds(207, 130, 98, 98);
        jl_picture_encrypt.setBounds(65, 230, 80, 30);
        jl_audio_encrypt.setBounds(220, 230, 80, 30);
        jl_picture_encrypt.setFont(new Font("Dialog", Font.BOLD, 18));
        jl_audio_encrypt.setFont(new Font("Dialog", Font.BOLD, 18));
        jb_application_encrypt.setBounds(53, 342, 98, 98);
        jb_other_document.setBounds(207, 342, 98, 98);
        jl_application_encrypt.setBounds(65, 442, 80, 30);
        jl_other_document.setBounds(220, 442, 80, 30);
        jl_application_encrypt.setFont(new Font("Dialog", Font.BOLD, 18));
        jl_other_document.setFont(new Font("Dialog", Font.BOLD, 18));

        jb_back.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\back.png"));
        jb_picture_encrypt.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_320_1.png"));
        jb_audio_encrypt.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_320_2.png"));
        jb_application_encrypt.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_320_3.png"));
        jb_other_document.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_320_4.png"));

        jl.add(jb_picture_encrypt);
        jl.add(jb_audio_encrypt);
        jl.add(jl_picture_encrypt);
        jl.add(jl_audio_encrypt);
        jl.add(jb_application_encrypt);
        jl.add(jb_other_document);
        jl.add(jl_application_encrypt);
        jl.add(jl_other_document);
        jl.add(jb_back);
        jl.add(menu);

        //返回
        jb_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new main_interface();
                dispose();
            }
        });
        //应用加密
        jb_application_encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String path = GetFile();
                    OutputStream os = new FileOutputStream("D:\\Quantum\\Quantum\\bin\\path.txt");
                    PrintStream ps = new PrintStream(os);
                    ps.print(path);
                    ps.close();
                    os.close();
                    //调用dll**************************
                    Dll_Cplus obj = new Dll_Cplus();
                    obj.Encrypt(path);
                    JOptionPane.showConfirmDialog(null, "加密成功！！", "Confirmation Message",
                            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException | IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showConfirmDialog(null, "加密失败！！！", "Confirmation Message",
                            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
                //JOptionPane.showConfirmDialog(null, "敬请期待！！","Confirmation Message",
                //		JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //其他文件
        jb_other_document.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String path = GetFile();
                    //OutputStream os = new FileOutputStream("E:\\Quantum\\bin\\path.txt");
                    //PrintStream ps = new PrintStream(os);
                    //ps.print(path);
                    //ps.close();
                    //os.close();
                    //调用dll**************************
                    Dll_Cplus obj = new Dll_Cplus();
                    obj.Encrypt(path);
                    JOptionPane.showConfirmDialog(null, "加密成功！！！", "Confirmation Message",
                            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showConfirmDialog(null, "加密失败！！！", "Confirmation Message",
                            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
                //	JOptionPane.showConfirmDialog(null, "敬请期待！！","Confirmation Message",
                //			JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //图片加密  
        jb_picture_encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String path = GetFile();
                    OutputStream os = new FileOutputStream("D:\\Quantum\\Quantum\\bin\\path.txt");
                    PrintStream ps = new PrintStream(os);
                    ps.print(path);
                    ps.close();
                    os.close();
                    //调用dll**************************
                    Dll_Cplus obj = new Dll_Cplus();
                    obj.Encrypt(path);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException | IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showConfirmDialog(null, "加密失败！！！", "Confirmation Message",
                            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
                //JOptionPane.showConfirmDialog(null, "敬请期待！！","Confirmation Message",
                //		JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //音频加密
        jb_audio_encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String path = GetFile();
                    OutputStream os = new FileOutputStream("D:\\Quantum\\Quantum\\bin\\path.txt");
                    PrintStream ps = new PrintStream(os);
                    ps.print(path);
                    ps.close();
                    os.close();
                    //调用dll**************************
                    Dll_Cplus obj = new Dll_Cplus();
                    obj.Encrypt(path);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException | IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showConfirmDialog(null, "加密失败！！！", "Confirmation Message",
                            JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
                //JOptionPane.showConfirmDialog(null, "敬请期待！！","Confirmation Message",
                //		JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new menu("document_encrypt");
                dispose();
            }
        });

        add(jl);
        setTitle("Quantum Encrypt");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public String GetFile() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String path = null;
        //设置界面风格
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFileChooser jdir = new JFileChooser();
        //设置选择路径模式
        jdir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //过滤文件类型
        // FileNameExtensionFilter filter = new FileNameExtensionFilter(
        //          "Excel文件(*.xls;*.xlsx;)","xls","xlsx");
        // jdir.setFileFilter(filter);
        //设置对话框标题
        jdir.setDialogTitle("请选择需要加密的文件");
        if (JFileChooser.APPROVE_OPTION == jdir.showOpenDialog(null)) {//用户点击了确定
            path = jdir.getSelectedFile().getAbsolutePath();//取得路径选择
        }
        return path;
    }
}

package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Loging extends JFrame {
    JPasswordField jpf;
    JLabel jl;

    public Loging() {
        setLayout(new GridBagLayout());
        //设置窗体位置
        GridBagConstraints gc = new GridBagConstraints();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getPreferredSize();
        this.setLocation((screenSize.width - frameSize.width) / 3, (screenSize.height - frameSize.height) / 8);
        this.setLayout(null);
        setSize(364, 590);

        jl = new JLabel();
        jl.setLayout(null);
        Icon icon = new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_161_1.png");
        jl.setBounds(0, 0, 364, 590);
        jl.setIcon(icon);

        jpf = new JPasswordField();
        jpf.setBounds(105, 462, 165, 42);
        jpf.setOpaque(false);//透明设置
        jpf.setBorder(null);//去除边框
        jpf.setFont(new Font("Dialog", Font.BOLD, 18));//调整字体大小
        //添加控件
        jl.add(jpf);
        this.add(jl);
        //回车监控
        jpf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {//读取密码
                    InputStream is = new FileInputStream("D:\\Quantum\\Quantum\\bin\\password.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line = null;
                    StringBuffer buffer = new StringBuffer();
                    while ((line = br.readLine()) != null) {
                        buffer.append(line + "\n");
                    }
                    //如果密码匹配
                    if (jpf.getText().trim().equals(buffer.toString().trim())) {
                        new main_interface();
                        dispose();
                    } else {
                        JOptionPane.showConfirmDialog(null, "密码错误！！", "Confirmation Message",
                                JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showConfirmDialog(null, "系统错误！！", "Confirmation Message",
                            JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setTitle("Quantum Encrypt");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Loging obj = new Loging();
    }

}

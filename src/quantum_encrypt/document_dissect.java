package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class document_dissect extends JFrame {
	JButton jb_picture_dissect;JButton jb_audio_dissect;	
	JLabel jl_picture_dissect;JLabel jl_audio_dissect;
	JButton jb_application_dissect; JButton jb_other_document;	
	JLabel  jl_application_dissect;JLabel jl_other_document;
	JButton jb_back,menu;
	
	JLabel jl;
	public document_dissect(){
        setLayout(new GridBagLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getPreferredSize();
		this.setLocation((screenSize.width-frameSize.width)/3,(screenSize.height-frameSize.height)/8);
		this.setLayout(null);
		setSize(358,583);
		
		jb_picture_dissect = new JButton();jb_audio_dissect = new JButton();	
		jl_picture_dissect = new JLabel("图片解密");jl_audio_dissect = new JLabel("音频解密");
		jl_picture_dissect.setForeground(Color.WHITE);jl_audio_dissect.setForeground(Color.WHITE);
		jb_application_dissect = new JButton(); jb_other_document = new JButton();	
		jl_application_dissect = new JLabel("应用解密");jl_other_document = new JLabel("其他文件");
		jl_application_dissect.setForeground(Color.WHITE);jl_other_document.setForeground(Color.WHITE);
		jb_back = new JButton();menu = new JButton();
		
		jb_back.setBorderPainted(false);menu.setBorderPainted(false);
		jb_picture_dissect.setBorderPainted(false);jb_audio_dissect.setBorderPainted(false);
		jb_application_dissect.setBorderPainted(false);jb_other_document.setBorderPainted(false);
		
		jl = new JLabel();
		Icon icon=new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_221_1.png");
		jl.setBounds(0, 0, 358, 583);jl.setIcon(icon);
		jb_back.setBounds(3, 3, 55, 55);jb_back.setContentAreaFilled (false);
		menu.setBounds(294, 3, 55, 55);menu.setContentAreaFilled (false);
		
		jb_picture_dissect.setBounds(53, 130, 98,98);jb_audio_dissect.setBounds(207, 130, 98, 98);
		jl_picture_dissect.setBounds(65, 230, 80, 30);jl_audio_dissect.setBounds(220, 230, 80, 30);
		jl_picture_dissect.setFont(new Font("Dialog",Font.BOLD,18));jl_audio_dissect.setFont(new Font("Dialog",Font.BOLD,18));	
		jb_application_dissect.setBounds(53, 342, 98, 98);	jb_other_document.setBounds(207, 342, 98, 98);
		jl_application_dissect.setBounds(65, 442, 80, 30);jl_other_document.setBounds(220, 442, 80, 30);
		jl_application_dissect.setFont(new Font("Dialog",Font.BOLD,18));jl_other_document.setFont(new Font("Dialog",Font.BOLD,18));
		
		jb_back.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\back.png"));

		jb_picture_dissect.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_320_1.png"));
		jb_audio_dissect.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_320_2.png"));		
		jb_application_dissect.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_320_3.png"));
		jb_other_document.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_320_4.png"));
		
		jl.add(jb_picture_dissect);jl.add(jb_audio_dissect);
		jl.add(jl_picture_dissect);jl.add(jl_audio_dissect);
		jl.add(jb_application_dissect);jl.add(jb_other_document);
		jl.add(jl_application_dissect);jl.add(jl_other_document);
		jl.add(jb_back);jl.add(menu);

		//返回
        jb_back.addActionListener(e -> {
            new main_interface();
            dispose();
        });
		//应用解密
        jb_application_dissect.addActionListener(e -> {
            try {
                String path= GetFile();
                OutputStream os = new FileOutputStream("D:\\Quantum\\Quantum\\bin\\path.txt");
                PrintStream ps = new PrintStream(os);
                ps.print(path);
                ps.close();
                os.close();
                //调用dll   **************************
                Dll_Cplus obj = new Dll_Cplus();
                obj.Dissect(path);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException| IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                JOptionPane.showConfirmDialog(null, "解密失败！！！","Confirmation Message",
                        JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }
            //JOptionPane.showConfirmDialog(null, "敬请期待！！","Confirmation Message",
            //		JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
        });
		//其他文件
        jb_other_document.addActionListener(e -> {
            try {
                String path= GetFile();
                OutputStream os = new FileOutputStream("D:\\Quantum\\Quantum\\bin\\path.txt");
                PrintStream ps = new PrintStream(os);
                ps.print(path);
                ps.close();
                os.close();
                //调用dll**************************
                Dll_Cplus obj = new Dll_Cplus();
                obj.Dissect(path);
                JOptionPane.showConfirmDialog(null, "解密成功！！","Confirmation Message",
                        JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException| IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                JOptionPane.showConfirmDialog(null, "解密失败！！！","Confirmation Message",
                        JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }
            //JOptionPane.showConfirmDialog(null, "敬请期待！！","Confirmation Message",
            //		JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
        });
        //图片解密
        jb_picture_dissect.addActionListener(e -> {
            try {
                String path= GetFile();
                OutputStream os = new FileOutputStream("D:\\Quantum\\Quantum\\bin\\path.txt");
                PrintStream ps = new PrintStream(os);
                ps.print(path);
                ps.close();
                os.close();
                //调用dll**************************
                Dll_Cplus obj = new Dll_Cplus();
                obj.Dissect(path);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException| IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                JOptionPane.showConfirmDialog(null, "解密失败！！！","Confirmation Message",
                        JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }
            //JOptionPane.showConfirmDialog(null, "敬请期待！！","Confirmation Message",
            //		JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
        });
        //音频解密
        jb_audio_dissect.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
					String path= GetFile();
        			OutputStream os = new FileOutputStream("D:\\Quantum\\Quantum\\bin\\path.txt");
        			PrintStream ps = new PrintStream(os);
        			ps.print(path);
        			ps.close();
        			os.close();
        			//调用dll**************************
        			Dll_Cplus obj = new Dll_Cplus();
        			obj.Dissect(path);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException| IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showConfirmDialog(null, "解密失败！！！","Confirmation Message",
							JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
				}
        		//JOptionPane.showConfirmDialog(null, "敬请期待！！","Confirmation Message",
				//		JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        //菜单
        menu.addActionListener(e -> {
            new menu("document_dissect");
            dispose();
        });
        
		add(jl);
		setTitle("Quantum Encrypt");
		setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
	}
	//选择文件
	public String GetFile()throws ClassNotFoundException,InstantiationException,IllegalAccessException,UnsupportedLookAndFeelException{ 
		String path = null;  
		//设置界面风格  
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
		JFileChooser jdir = new JFileChooser();  
		jdir.setDialogTitle("请选择需要加密的文件");
		if (JFileChooser.APPROVE_OPTION == jdir.showOpenDialog(null)) {//用户点击了确定  
			path = jdir.getSelectedFile().getAbsolutePath();//取得路径选择  
		}  
		return path;
	}
}

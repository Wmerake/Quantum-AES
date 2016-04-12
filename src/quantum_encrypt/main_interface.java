package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_interface extends JFrame {	
	JButton jb_document_encrypt;JButton jb_document_dissect;	//文件加密解密
	JLabel jl_document_encrypt;JLabel jl_document_dissect;
	JButton jb_text_encrypt; JButton jb_text_dissect;	//文本加密解密
	JLabel  jl_text_encrypt;JLabel jl_text_dissect;
	JLabel back;JButton menu;
	JLabel jl;
	public main_interface(){
        setLayout(new GridBagLayout());
        //设置窗体位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getPreferredSize();
		this.setLocation((screenSize.width-frameSize.width)/3,(screenSize.height-frameSize.height)/8);
		this.setLayout(null);
		setSize(358,583);

		back = new JLabel();menu = new JButton();
		jb_document_encrypt = new JButton();jb_document_dissect = new JButton();	//文件加密解密
		jl_document_encrypt = new JLabel("文件加密");jl_document_dissect = new JLabel("文件解密");
		jl_document_encrypt.setForeground(Color.WHITE);jl_document_dissect.setForeground(Color.WHITE);
		jb_text_encrypt = new JButton(); jb_text_dissect = new JButton();	//文本加密解密
		jl_text_encrypt = new JLabel("实时文本加密");jl_text_dissect = new JLabel("实时文本解密");
		jl_text_encrypt.setForeground(Color.WHITE);jl_text_dissect.setForeground(Color.WHITE);
		
		jl = new JLabel();
		Icon icon=new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_221_1.png");
		jl.setBounds(0, 0, 358, 583);jl.setIcon(icon);
		
		menu.setBounds(295, 2, 55, 55);back.setBounds(5, 5, 55, 55);
		jb_document_encrypt.setBounds(53, 130, 98,98);jb_document_dissect.setBounds(207, 130, 98, 98);
		jl_document_encrypt.setBounds(63, 230, 80, 30);jl_document_dissect.setBounds(218, 230, 80, 30);
		jl_document_encrypt.setFont(new Font("Dialog",Font.BOLD,18));jl_document_dissect.setFont(new Font("Dialog",Font.BOLD,18));	
		jb_text_encrypt.setBounds(53, 342, 98, 98);	jb_text_dissect.setBounds(207, 342, 98, 98);
		jl_text_encrypt.setBounds(45, 442, 120, 30);jl_text_dissect.setBounds(200, 442, 120, 30);
		jl_text_encrypt.setFont(new Font("Dialog",Font.BOLD,18));jl_text_dissect.setFont(new Font("Dialog",Font.BOLD,18));

		
		//消除按钮边框
		jb_text_encrypt.setBorderPainted(false);jb_text_dissect.setBorderPainted(false);
		jb_document_encrypt.setBorderPainted(false);jb_document_dissect.setBorderPainted(false);
		jb_text_encrypt.setOpaque(false); menu.setBorderPainted(false);
		
		back.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\null.png"));
		menu.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\menu.png"));
		jb_document_encrypt.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_333_1.png"));
		jb_document_dissect.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_333_2.png"));		
		jb_text_encrypt.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_333_3.png"));
		jb_text_dissect.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_333_4.png"));

		jl.add(menu);jl.add(back);
		jl.add(jb_text_encrypt);jl.add(jb_text_dissect);
		jl.add(jl_text_encrypt);jl.add(jl_text_dissect);
		jl.add(jb_document_encrypt);jl.add(jb_document_dissect);
		jl.add(jl_document_encrypt);jl.add(jl_document_dissect);
		
		//文本加密
        jb_text_encrypt.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new text_encrypt();
        		dispose();
        	}  
        });
		//文本解密
        jb_text_dissect.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new text_dissect();
        		dispose();
        	}  
        });
        //文件加密
        jb_document_encrypt.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new document_encrypt();
        		dispose();
        	}  
        });
        //文件解密
        jb_document_dissect.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new document_dissect();
        		dispose();
        	}  
        });
        //菜单
        menu.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new menu("main_interface");
        		dispose();
        	}  
        });
        
		this.add(jl);
		setTitle("Quantum Encrypt");
		setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
	}
}

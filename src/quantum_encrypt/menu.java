package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame {	
	JLabel jl,menu;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,back;
	public menu(final String base){
        setLayout(new GridBagLayout());
        //设置窗体位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getPreferredSize();
		this.setLocation((screenSize.width-frameSize.width)/3,(screenSize.height-frameSize.height)/8);
		this.setLayout(null);
		setSize(358,600);
		
		jl = new JLabel();jl.setLayout(null);
		Icon icon=new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_65.png");
		jl.setBounds(0, 0, 358, 585);jl.setIcon(icon);
		
		b1 = new JButton();b2 = new JButton();b3 = new JButton();b4 = new JButton();b5 = new JButton();
		b6 = new JButton();b7 = new JButton();b8 = new JButton();b9 = new JButton();back = new JButton();menu = new JLabel();
		
		menu.setBounds(295, 3, 55, 55);menu.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\null.png"));
		back.setBounds(3, 3, 55, 55);
		b1.setBounds(0, 64, 150, 45);
		b2.setBounds(0, 114, 150, 45);
		b3.setBounds(0, 165, 150, 45);
		b4.setBounds(0, 216, 150, 45);
		b5.setBounds(0, 267, 150, 45);
		b6.setBounds(0, 318, 150, 45);
		b7.setBounds(0, 369, 150, 45);
		b8.setBounds(0, 420, 150, 45);
		b9.setBounds(0, 471, 150, 45);
		
		b1.setBorder(null);b2.setBorder(null);b3.setBorder(null);b4.setBorder(null);b5.setBorder(null);
		b6.setBorder(null);b7.setBorder(null);b8.setBorder(null);b9.setBorder(null);back.setBorder(null);
		
		b1.setContentAreaFilled (false);b2.setContentAreaFilled (false);b3.setContentAreaFilled (false);
		b4.setContentAreaFilled (false);b5.setContentAreaFilled (false);b6.setContentAreaFilled (false);
		b7.setContentAreaFilled (false);b8.setContentAreaFilled (false);b9.setContentAreaFilled (false);
		back.setContentAreaFilled (false);
		
		jl.add(b1);jl.add(b2);jl.add(b3);jl.add(b4);jl.add(b5);
		jl.add(b6);jl.add(b7);jl.add(b8);jl.add(b9);jl.add(back);	jl.add(menu);
		this.add(jl);
		//修改密码
        b1.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new modify_password(base);
        		dispose();
        	}  
        });
		//密钥设置
        b2.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new key_install(base);
        		dispose();
        	}  
        });
		//管理密钥
        b3.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new key_manage(base);
        		dispose();
        	}  
        });
        //云端加密
        b4.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
				JOptionPane.showConfirmDialog(null, "敬请期待！！！","Confirmation Message",
						JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
        	}  
        });
        //版本信息
        b5.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new version_information(base);
        		dispose();
        	}  
        });
        //检查更新
        b6.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new update(base);
        		dispose();
        	}  
        });
        //关于我们
        b7.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new contact_information(base);
        		dispose();
        	}  
        });
        //软件介绍
        b8.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new software_introduction(base);
        		dispose();
        	}  
        });
        //退出
        b9.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		dispose();
        	}  
        });
        back.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {
        		if(base=="document_encrypt")
        			new document_encrypt();
        		else if(base=="document_dissect")
        			new document_dissect();
        		else if(base=="text_encrypt")
        			new text_encrypt();
        		else if(base=="text_dissect")
        			new text_dissect();
        		else 
        			new main_interface();
        		dispose();
        	}  
        });
        
        
		setTitle("Quantum Encrypt");
		setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
	}
}

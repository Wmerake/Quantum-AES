package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class software_introduction extends JFrame {	
	JButton certain;
	JLabel jl,menu,txt,back;
	public software_introduction(final String base){
        setLayout(new GridBagLayout());
        //设置窗体位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getPreferredSize();
		this.setLocation((screenSize.width-frameSize.width)/3,(screenSize.height-frameSize.height)/8);
		this.setLayout(null);
		setSize(358,583);

		certain = new JButton("");jl = new JLabel();menu = new JLabel();txt = new JLabel();back = new JLabel();
		
		jl = new JLabel();
		Icon icon=new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_221_1.png");
		jl.setBounds(0, 0, 358, 583);jl.setIcon(icon);
		
		menu.setBounds(295, 3, 55, 55);menu.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\null.png"));
		certain.setBounds(119, 480, 120, 40);certain.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\certain.png"));
		txt.setBounds(10, 65, 338, 400);
		back.setBounds(5, 5, 55, 55);back.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\null.png"));
		
		txt.setFont(new Font("Dialog",Font.BOLD,15));
		txt.setForeground(Color.gray);
		txt.setText("<html>    我们设计出的软件是一款基于量子逻辑线路的云加密软件，该软件的底层完全采用量子逻辑线路实现，并结合目前主流的AES加密算法，设计出了可以在电脑和手机上实现同步的加密软件。软件的功能主要分为两大类，基础功能和高级功能，简单介绍如下：<br>基础功能：<br>    针对本地数据进行保护，可以实现对本地各种文件进行加解密，小到简单地对字符串、文本等进行加解密,大到对视频、应用程序等大容量文件的加解密。<br>高级功能：<br>对安全性要求较高数据的加密，我们采用传输到云端服务器进行相应处理，同时软件中我们还设置了密钥管理、密钥选择、云端加密等高级功能，用户可以自主的根据相应要求定制密钥，然后软件内部会自动给出相应的量子逻辑线路进行加解密。</html>");
		
		//消除按钮边框
		certain.setBorderPainted(false);
		

		jl.add(menu);jl.add(certain);jl.add(txt);jl.add(back);
		
        certain.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new menu(base);
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

package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class version_information extends JFrame {	
	JButton certain;
	JLabel jl,menu,txt,back;
	public version_information(final String base){
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
		txt.setBounds(10, 210, 338, 40);
		back.setBounds(5, 5, 55, 55);back.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\null.png"));
		
		txt.setFont(new Font("Dialog",Font.BOLD,31));
		txt.setForeground(Color.gray);
		txt.setText("当前版本为 :   16.2.20");
		
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

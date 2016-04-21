package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class key_manage extends JFrame {	
	JLabel jl,menu;
	JButton back;
	public key_manage(final String base){
        setLayout(new GridBagLayout());
        //…Ë÷√¥∞ÃÂŒª÷√
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getPreferredSize();
		this.setLocation((screenSize.width-frameSize.width)/3,(screenSize.height-frameSize.height)/8);
		this.setLayout(null);
		setSize(358,600);
		
		jl = new JLabel();jl.setLayout(null);
		Icon icon=new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_344.png");
		jl.setBounds(0, 0, 358, 583);jl.setIcon(icon);
		
		menu = new JLabel();back =new JButton();

		
		menu.setBounds(295, 3, 55, 55);menu.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\null.png"));
		back.setBounds(3, 3, 55, 55);
		
		back.setBorder(null);
		
		back.setContentAreaFilled (false);
		
		jl.add(back);jl.add(menu);
		this.add(jl);

        back.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {
        		/*
        		if(base=="document_encrypt")
        			new document_encrypt();
        		else if(base=="document_dissect")
        			new document_dissect();
        		else if(base=="text_encryp.")
        			new text_encrypt();
        		else if(base=="text_dissect")
        			new text_dissect();
        		else 
        			new main_interface();
        			*/
        		new menu(base);
        		dispose();
        	}  
        });
        
        
		setTitle("Quantum Encrypt");
		setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
	}
}

package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class key_install extends JFrame {	
	JLabel jl;
	JButton back;
	JRadioButton rank;
	public key_install(final String base){
        setLayout(new GridBagLayout());
        //…Ë÷√¥∞ÃÂŒª÷√
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getPreferredSize();
		this.setLocation((screenSize.width-frameSize.width)/3,(screenSize.height-frameSize.height)/8);
		this.setLayout(null);
		setSize(358,600);
		
		jl = new JLabel();jl.setLayout(null);
		Icon icon=new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_1088.png");
		jl.setBounds(0, 0, 358, 583);jl.setIcon(icon);

		back =new JButton();rank = new JRadioButton();	
		back.setBounds(3, 3, 55, 55);	rank.setBounds(87, 211, 15, 15);
		back.setBorder(null);rank.setBorder(null);
		back.setContentAreaFilled (false);rank.setContentAreaFilled (false);
		
		jl.add(back);jl.add(rank);
		this.add(jl);

        back.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {
        		/*
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

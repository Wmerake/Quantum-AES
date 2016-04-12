package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class modify_password extends JFrame {	
	JLabel jl;
	JButton b,back;
	JPasswordField jpf1,jpf2,jpf3;
	public modify_password(final String base){
        setLayout(new GridBagLayout());
        //设置窗体位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getPreferredSize();
		this.setLocation((screenSize.width-frameSize.width)/3,(screenSize.height-frameSize.height)/8);
		this.setLayout(null);
		setSize(358,600);
		
		jl = new JLabel();jl.setLayout(null);
		Icon icon=new ImageIcon("D:\\Quantum\\Quantum\\src\\XMLID_108.png");
		jl.setBounds(0, 0, 358, 585);jl.setIcon(icon);
		
		b = new JButton();back = new JButton();
		jpf1 = new JPasswordField();jpf2 = new JPasswordField();jpf3 = new JPasswordField();
		
		back.setBounds(4, 4, 54, 54);
		jpf1.setBounds(70, 169, 217, 48);
		jpf2.setBounds(70, 271, 217, 48);
		jpf3.setBounds(70, 382, 217, 48);
		b.setBounds(128, 485, 100, 35);
		
		b.setBorder(null);back.setBorder(null);jpf1.setBorder(null);jpf2.setBorder(null);jpf3.setBorder(null);
		
		b.setContentAreaFilled (false);
		jpf1.setOpaque(false);jpf1.setFont(new Font("Dialog",Font.BOLD,18));jpf1.setForeground(Color.WHITE);
		jpf2.setOpaque(false);jpf2.setFont(new Font("Dialog",Font.BOLD,18));jpf2.setForeground(Color.WHITE);
		jpf3.setOpaque(false);jpf3.setFont(new Font("Dialog",Font.BOLD,18));jpf3.setForeground(Color.WHITE);
		back.setContentAreaFilled (false);
		
		jl.add(back);jl.add(b);jl.add(jpf1);jl.add(jpf2);jl.add(jpf3);
		this.add(jl);

        b.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		try{//读取密码
        			InputStream is = new FileInputStream("D:\\Quantum\\Quantum\\bin\\password.txt");
        			BufferedReader br = new BufferedReader(new InputStreamReader(is));
        			String line=null;
        			StringBuffer buffer = new StringBuffer();
        			while((line=br.readLine())!=null){
        				buffer.append(line + "\n");
        			}
                	//如果旧密码匹配
                	if(jpf1.getText().trim().equals(buffer.toString().trim())){
                		br.close();
                		is.close();
                		//如果新密码匹配
                		if(jpf2.getText().trim().equals(jpf3.getText().trim())){
            				//修改密码的操作......
                			String msg = jpf3.getText();
                			OutputStream os = new FileOutputStream("D:\\Quantum\\Quantum\\bin\\password.txt");
                			PrintStream ps = new PrintStream(os);
                			ps.print(msg);
                			ps.close();
                			os.close();
                			JOptionPane.showConfirmDialog(null, "密码修改成功！！","Confirmation Message",
            						JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            			}
            			else{
                			JOptionPane.showConfirmDialog(null, "新密码不匹配！！","Confirmation Message",
            						JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
            			}
                	}
                	else{
            			JOptionPane.showConfirmDialog(null, "旧密码错误！！","Confirmation Message",
        						JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
            		}
        		}
        		catch(Exception ex){
           			JOptionPane.showConfirmDialog(null, "系统错误！！","Confirmation Message",
        						JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        		}
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
	
	public static void main(String[] args) {
		new modify_password("menu");
	}

}

package quantum_encrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class text_dissect extends JFrame {
	JButton jb_encrypt;
	JButton jb_back;
	
	JLabel jp1_jl;
	JLabel jl,jr,di;
	
	private static final long serialVersionUID = 4785452373598819719L;	 
	private JScrollPane sp = null; 
	private JTextArea text = null;	 
	private ImageIcon imageIcon = null;
	
	public text_dissect(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getPreferredSize();
		this.setLocation((screenSize.width-frameSize.width)/3,(screenSize.height-frameSize.height)/8);
		setLayout(null);
		//JFrame 格式
		
		
		jb_back = new JButton();
		jb_encrypt = new JButton();
		jp1_jl = new JLabel();jl = new JLabel(); jr = new JLabel();di = new JLabel();
		jp1_jl.setBounds(0, 0, 336, 50);
		jp1_jl.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\h.png"));
		jl.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\l.png"));
		jr.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\r.png"));
		di.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\di.png"));
		jb_back.setBounds(5, 5, 40, 40);
		jp1_jl.add(jb_back);
				
		imageIcon = new ImageIcon("D:\\Quantum\\Quantum\\src\\11.png");
		// 构造文本组件并使之透明
		text = new JTextArea();
		text.setOpaque(false);
		// 构造滚动组件并使之透明
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Dialog",Font.BOLD,31));
		text.setLineWrap(true);
		sp = new JScrollPane(text);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
			
		JPanel backdrop = new JPanel(){
		 private static final long serialVersionUID = 1957203784117943458L;
		   {
		    this.setOpaque(false);
		    this.setLayout(new BorderLayout());
		   }
		 
		   public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
		  };		
		
		sp.setForeground(Color.WHITE);
		backdrop.setBounds(56, 50, 226, 402);
		backdrop.add(sp);
		this.getContentPane().add(backdrop);
		
		jl.setBounds(0, 0, 56, 503);
		jr.setBounds(275, 0, 56, 503);
		di.setBounds(0, 445, 336, 80);
		jb_encrypt.setBounds(122, 23, 90, 30);
		di.add(jb_encrypt);
		jb_back.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\1_1.png"));
		jb_encrypt.setIcon(new ImageIcon("D:\\Quantum\\Quantum\\src\\10_1.png"));

        jb_back.setBorderPainted(false);
        jb_encrypt.setBorderPainted(false);
        //初始化解密文本
		try {
	        InputStream is = new FileInputStream("D:\\Quantum\\Quantum\\bin\\txtwork.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line=null;
			StringBuffer buffer = new StringBuffer();
			while((line=br.readLine())!=null){
				buffer.append(line + "\n");
			}
			text.setText(buffer.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		//返回
        jb_back.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		new main_interface();
        		dispose();
        	}  
        });
		//解密
        jb_encrypt.addActionListener(new ActionListener(){  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		String msg = null;
				//调用dll*****************************
				try{
					Dll_Cplus obj = new Dll_Cplus();
					msg = obj.txtDissect(text.getText());//调用函数
					//如果成功
					JOptionPane.showConfirmDialog(null, "解密成功！！","Confirmation Message",
    						JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
					//并且显示明文
					text.setText(msg);
					//try {
				     //   InputStream is = new FileInputStream("E:\\量子加密项目\\Quantum\\bin\\txtword.txt");
					//	BufferedReader br = new BufferedReader(new InputStreamReader(is));
					//	String line=null;
					//	StringBuffer buffer = new StringBuffer();
					//	while((line=br.readLine())!=null){
					//		buffer.append(line + "\n");
					//	}
					//	text.setText(buffer.toString());
					//} catch (IOException e1) {
						// TODO Auto-generated catch block
					//	e1.printStackTrace();
					//}
				}catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showConfirmDialog(null, "解密失败！！","Confirmation Message",
    						JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
				}
        	}  
        });
        
		add(jp1_jl);add(jl);add(jr);add(di);
		setTitle("Quantum Encrypt");
		setSize(336,550);
		setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

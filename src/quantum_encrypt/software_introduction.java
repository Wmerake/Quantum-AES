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
        //���ô���λ��
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
		txt.setText("<html>    ������Ƴ��������һ����������߼���·���Ƽ��������������ĵײ���ȫ���������߼���·ʵ�֣������Ŀǰ������AES�����㷨����Ƴ��˿����ڵ��Ժ��ֻ���ʵ��ͬ���ļ������������Ĺ�����Ҫ��Ϊ�����࣬�������ܺ͸߼����ܣ��򵥽������£�<br>�������ܣ�<br>    ��Ա������ݽ��б���������ʵ�ֶԱ��ظ����ļ����мӽ��ܣ�С���򵥵ض��ַ������ı��Ƚ��мӽ���,�󵽶���Ƶ��Ӧ�ó���ȴ������ļ��ļӽ��ܡ�<br>�߼����ܣ�<br>�԰�ȫ��Ҫ��ϸ����ݵļ��ܣ����ǲ��ô��䵽�ƶ˷�����������Ӧ����ͬʱ��������ǻ���������Կ������Կѡ���ƶ˼��ܵȸ߼����ܣ��û����������ĸ�����ӦҪ������Կ��Ȼ������ڲ����Զ�������Ӧ�������߼���·���мӽ��ܡ�</html>");
		
		//������ť�߿�
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

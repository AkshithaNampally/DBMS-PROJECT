import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HomePage extends JFrame{
	private JFrame frame= new JFrame(); 
	private JButton b1=new JButton("High_level_language");
	private JButton b2=new JButton("Medium_level_language");
	private JButton b3=new JButton("Low_level_language");
	//private JButton b4=new JButton("Severity Page");
	//private JLabel l1=new JLabel("DIRECT TO");
	private JMenuBar mBar;
    private JMenu mnuHelp;
    private JMenuItem abt;
	public HomePage(){       
        frame.setTitle("Home Page");
        frame.setLayout(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setBounds(100,150,1000,400); 
		Container c=frame.getContentPane(); 
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(b3);
		//frame.getContentPane().add(b4);
		//frame.getContentPane().add(l1);
		initializeMenuBar();
        frame.setJMenuBar(mBar);
		abt.addActionListener(new HelpMenuActionListener());
		JLabel label=new JLabel("DATATYPES AND THEIR SYNTAXES IN 3PL's");
		//JLabel label1=new JLabel();
        //label1.setIcon(new ImageIcon("C:/Users/sasid/Downloads/maize.jpg")); 
        //Dimension size = label1.getPreferredSize();
        label.setBounds(65,5,700,50);	
        label.setFont(new Font("Serif",Font.PLAIN,20));		
		//label.setForeground(Color.BLUE);
		//l1.setBounds(670,5,700,50);	
        //l1.setFont(new Font("Serif",Font.PLAIN,20));		
		//l1.setForeground(Color.BLUE);
        //label1.setBounds(200,60, size.width,size.height);
		b1.setBounds(640,60,170,40);
		b1.setFont(new Font("Times New Roman",Font.BOLD,17));
		b2.setBounds(640,110,170,40);
		b2.setFont(new Font("Times New Roman",Font.BOLD,17));
		b3.setBounds(640,160,170,40);
		b3.setFont(new Font("Times New Roman",Font.BOLD,17));
		//b4.setBounds(640,210,170,40);
		//b4.setFont(new Font("Times New Roman",Font.BOLD,17));	
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new High_level_language();
			}
		});
        b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new Medium_level_language();
			}
		});
        b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new Low_level_language();
			}
		});
		/* b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new Severity();
			}
		});	*/	
			c.add(label);
			//c.add(label1);			
			//frame.getContentPane().setBackground(Color.CYAN);		
			frame.setVisible(true); 
        }
		public void initializeMenuBar()
	    {
			mBar=new JMenuBar();
			mnuHelp=new JMenu("Help");
			abt=new JMenuItem("About");
			mnuHelp.add(abt);
			mBar.add(mnuHelp);
	    }	
		private class HelpMenuActionListener implements ActionListener {
			public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==abt)
			{
				String details;
				details = "This project is about recording the datatypes of different programming languages when selected any datatype it should display the description and syntax of thr database"+"\n"+
                          "It has 3 tables:"+"\n"+
                          "1.High_level_language table with rows containing python Id as P_ID,data type as DATA_TYPE ,its syntax as SYNTAX and its description as DESCRIPTION"+"\n"+
                          "2.Medium_level_language table with rows containing java Id as J_ID,data type as DATA_TYPE ,its syntax as SYNTAX and its description as DESCRIPTION"+"\n"+
                          "3.Low_level_language table with rows containing cId as C_ID,data type as DATA_TYPE, its syntax as SYNTAX and its description as DESCRIPTION ";
                       
				JOptionPane.showMessageDialog(null,details,"INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		  }
		}	
	public static void main(String args[]){
		new HomePage();
}
}
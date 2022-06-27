import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class High_level_language implements ActionListener{
	private JFrame f=new JFrame("High_level_language");
	private JLabel l=new JLabel("");
	private JLabel l1=new JLabel("Enter datatype to insert");
	private JLabel l2=new JLabel("Enter datatype to update");
	//private JLabel l3=new JLabel("Enter datatype to delete");
	//private JLabel l4=new JLabel("Result");
	//private JLabel l5=new JLabel("DEFICIENCY");
	private JButton b1=new JButton("Insert");
	private JButton b2=new JButton("Update");
	//private JButton b3=new JButton("Delete");
	//private JButton b4=new JButton("Retrieve");
	private JTextField t1=new JTextField();
	private JTextField t2=new JTextField();
	//private JTextField t3=new JTextField();
	private JTextField t=new JTextField();
	private JTextArea t4=new JTextArea();
	private JScrollPane scrollBar=new JScrollPane(t4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	public High_level_language() {
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.setBounds(100,150,1000,400);
		Container c=f.getContentPane();
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);
		//f.getContentPane().add(l3);
		//f.getContentPane().add(l4);
		//f.getContentPane().add(l5);
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		//f.getContentPane().add(b3);
		//f.getContentPane().add(b4);
		f.getContentPane().add(t1);
		f.getContentPane().add(t2);
		//f.getContentPane().add(t3);
		f.getContentPane().add(t);
		f.getContentPane().add(scrollBar);   
		scrollBar.setBounds(690,80,250,150);
		l.setBounds(20,30,50,50);
		l1.setBounds(60,80,250,30);
		l1.setOpaque(true);
		l1.setBackground(Color.WHITE);
		l2.setBounds(60,120,250,30);
		l2.setOpaque(true);
		l2.setBackground(Color.WHITE);
		//l3.setBounds(60,160,250,30);
		//l3.setOpaque(true);
		//l3.setBackground(Color.WHITE);
		//l4.setBounds(60,200,250,30);
		//l4.setOpaque(true);
		//l4.setBackground(Color.WHITE);
		//l5.setBounds(430,5,700,50);	
        //l5.setFont(new Font("Serif",Font.PLAIN,20));		
		//l5.setForeground(Color.BLUE);
		b1.setBounds(570,80,100,30);
		b1.setFont(new Font("Times New Roman",Font.BOLD,17));
		b2.setBounds(570,120,100,30);
		b2.setFont(new Font("Times New Roman",Font.BOLD,17));
		//b3.setBounds(570,160,100,30);
		//b3.setFont(new Font("Times New Roman",Font.BOLD,17));
		//b4.setBounds(570,200,100,30);
		//b4.setFont(new Font("Times New Roman",Font.BOLD,17));
		t1.setBounds(330,80,220,30);
		t2.setBounds(330,120,220,30);
		//t3.setBounds(330,160,220,30);
		t.setBounds(330,200,220,30);
		t4.setEditable(false);
		b1.addActionListener(this);
		b2.addActionListener(this);
		//b3.addActionListener(this);
		//b4.addActionListener(this);
		c.add(l);
		//f.getContentPane().setBackground(Color.ORANGE);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=new String(ae.getActionCommand());
		if((s).equals("Insert")){
			try{
				t.setText("1 row Inserted "+t1.getText());
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshitha","vasavi");
				//Statement stmt=con.createStatement();
				//StringTokenizer st=new StringTokenizer(t1.getText(),",");
                //String data_type=st.nextToken();
				//String syntax=st.nextToken();
				//String description=st.nextToken();
				//String sql = "select syntax, description from High_level_language where data_type='" + t1.getText() + "'";
				String sql = "select * from High_level_language where data_type='" + t1.getText() + "'";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					t4.append(rs.getString(1) + rs.getString(2) + rs.getString(3));
				}
				//stmt.executeUpdate("insert into High_level_languagevalues('"+data_type+"','"+syntax+"','"+description+"')");
				con.close();
		}
		catch (Exception e) {
			
			System.out.println(e);
			t.setText("Error Occured!!");
			
		}
			t2.setText("");
			//t3.setText("");
			t4.setText("");
		}
		else if((s).equals("Update")){
			try{
				t.setText("1 row Updated "+t2.getText());
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshitha","vasavi");
				Statement stmt=con.createStatement();
				StringTokenizer st=new StringTokenizer(t2.getText(),",");
				String data_type=st.nextToken();
				String syntax=st.nextToken();
				String description=st.nextToken();
            
				stmt.executeUpdate("Update High_level_language set data_type='"+data_type+"' where syntax='"+syntax+"' and description='"+description+"'");
				con.close();
			}
			catch(Exception e){
				System.out.println(e);
				t.setText("Error Occured!!");
			}
			t1.setText("");
			//t3.setText("");
			t4.setText("");
		}
		/*else if((s).equals("Delete")){
			try{
				t.setText("Deleted 1 row with pid "+t3.getText());
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshitha","vasavi");
				Statement stmt=con.createStatement();
				int p_id = Integer.parseInt(t3.getText());
				stmt.executeUpdate("delete from High_level_language where p_id="+p_id+"");
			    con.close();
			}
			catch(Exception e){
				System.out.println(e);
				t.setText("Error Occured!!");
			}
			t1.setText("");
			t2.setText("");
			t4.setText("");
	    }*/
		/*else if((s).equals("Retrieve")){
			try{
				t.setText("Retrieved rows from Deficiency table");
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","lalitha","vasavi");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from deficiency");
				String str=new String();
				while(rs.next())
				     str=str+(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"\n");
				t4.setText(str);
				con.close();
			}
			catch(Exception e){
				t.setText("Error Occured!!");
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");
	    }*/		
	}
	public static void main(String[] args){
		new High_level_language();
	}
}
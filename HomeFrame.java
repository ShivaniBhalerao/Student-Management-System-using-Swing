import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class HomeFrame extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;
HomeFrame()
{
c=getContentPane();
FlowLayout f=new FlowLayout();
//c.setLayout(new FlowLayout());
f.setHgap(40);
f.setVgap(40);
c.setLayout(f);
btnAdd=new JButton("Add");
btnView=new JButton("View");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");

btnAdd.setFont(new Font("Times New Roman", Font.ITALIC, 16));
btnView.setFont(new Font("Times New Roman", Font.ITALIC, 16));
btnUpdate.setFont(new Font("Times New Roman", Font.ITALIC, 16));
btnDelete.setFont(new Font("Times New Roman", Font.ITALIC, 16));

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);



btnAdd.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
AddFrame a=new AddFrame();
dispose();
}
}
);


btnView.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
ViewFrame a=new ViewFrame();
dispose();
}
}
);

btnUpdate.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
UpdateFrame a=new UpdateFrame();
dispose();
}
}
);


btnDelete.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
DeleteFrame a=new DeleteFrame();
dispose();
}
}
);


setSize(600,250);
setTitle("SMS");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
public static void main(String args[])
{
HomeFrame h=new HomeFrame();
}//end of constuctor
}//end of class

class DbHandler
{
static Connection c;
public static void getConn()
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","abc123");
}
catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
}//end of getConn()


public void addStudent(int rno,String name)
{
getConn();
try
{
String sql="insert into student values(?,?)";
PreparedStatement pst=c.prepareStatement(sql);
pst.setInt(1,rno);
pst.setString(2,name);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+" records inserted");
}
catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"Insert issue"+se);
}
}//end of addStudent()

public String viewStudent()
{
getConn();
StringBuffer sb=new StringBuffer();
try
{
String sql="select* from student order by rno";
Statement stmt=c.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next())
{
int rno=rs.getInt(1);
String name=rs.getString(2);
sb.append(rno+"---"+name+"\n");
}
rs.close();
}
catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"view issue"+se);
}
return sb.toString();
}//end of viewStudent()



public void updateStudent(int rno,String name)
{
getConn();
try
{
String sql="update student set name=? where rno=? ";
PreparedStatement pst=c.prepareStatement(sql);
pst.setInt(2,rno);
pst.setString(1,name);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+" records updated");
}
catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"Update issue"+se);
}
}//end of updateStudent()

public void deleteStudent(int rno)
{
getConn();
try
{
String sql="delete from student where rno=?";
PreparedStatement pst=c.prepareStatement(sql);
pst.setInt(1,rno);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+" records deleted");
}
catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"Delete issue"+se);
}
}//end of deleteStudent()
}//end of class
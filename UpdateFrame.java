import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UpdateFrame extends JFrame
{
Container c;
JLabel lblRno,lblName;
JTextField txtRno,txtName;
JButton btnSave,btnBack;
JPanel p1,p2;

UpdateFrame()
{
c=getContentPane();
p1=new JPanel(); 
lblRno=new JLabel("Rno");
txtRno=new JTextField(5);
lblName=new JLabel("Name");
txtName=new JTextField(10);

p1.add(lblRno);
p1.add(txtRno);
p1.add(lblName);
p1.add(txtName);
lblRno.setFont(new Font("Times New Roman", Font.ITALIC, 16));
txtRno.setFont(new Font("Times New Roman", Font.ITALIC, 16));

lblName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
txtName.setFont(new Font("Times New Roman", Font.ITALIC, 16));

c.add(p1);
p2=new JPanel();
btnSave=new JButton("Save");
btnBack=new JButton("Back");

p2.add(btnSave);
p2.add(btnBack);
btnSave.setFont(new Font("Times New Roman", Font.ITALIC, 16));
btnBack.setFont(new Font("Times New Roman", Font.ITALIC, 16));

c.add("South",p2);

btnSave.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
String rno=txtRno.getText();
String name=txtName.getText();

if(rno.length()==0)
{
JOptionPane.showMessageDialog(new JDialog(),"rno is empty");
txtRno.requestFocus();
return;
}

if(name.length()==0)
{
JOptionPane.showMessageDialog(new JDialog(),"name is empty");
txtName.requestFocus();
return;
}

DbHandler db=new DbHandler();
db.updateStudent(Integer.parseInt(rno),name);
txtRno.setText("");
txtName.setText("");
txtRno.requestFocus();
}
}
);


btnBack.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
HomeFrame a=new HomeFrame();
dispose();
}
}
);

setSize(400,150);
setTitle("Update Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String args[])
{
UpdateFrame h=new UpdateFrame();
}
}
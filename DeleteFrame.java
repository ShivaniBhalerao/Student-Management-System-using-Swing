import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DeleteFrame extends JFrame
{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave,btnBack;
JPanel p1,p2;

DeleteFrame()
{
c=getContentPane();
p1=new JPanel(); 
lblRno=new JLabel("Rno");
txtRno=new JTextField(5);

p1.add(lblRno);
p1.add(txtRno);
lblRno.setFont(new Font("Times New Roman", Font.ITALIC, 16));
txtRno.setFont(new Font("Times New Roman", Font.ITALIC, 16));

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

//if(rno.length()==0)
//{
//JOptionPane.showMessageDialog(new JDialog(),"rno is empty");
//txtRno.requestFocus();
//return;
//}

DbHandler db=new DbHandler();
db.deleteStudent(Integer.parseInt(rno));
txtRno.setText("");
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
setTitle("Delete Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}
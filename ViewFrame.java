import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewFrame extends JFrame
{
Container c;
JTextArea taData;
JScrollPane spData ;
JButton btnBack;
JPanel p1,p2;

ViewFrame()
{
c=getContentPane();

p1=new JPanel();
taData=new JTextArea(4,20);
spData=new JScrollPane(taData);
p1.add(spData);
taData.setEnabled(false);
taData.setFont(new Font("Times New Roman", Font.ITALIC, 16));

c.add(p1);

p2=new JPanel();
btnBack=new JButton("Back");
p2.add(btnBack);
btnBack.setFont(new Font("Times New Roman", Font.ITALIC, 16));


c.add("South",p2);

DbHandler db=new DbHandler();
String data=db.viewStudent();
taData.setText(data);

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
setTitle("View Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}
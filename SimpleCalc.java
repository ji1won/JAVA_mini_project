import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalc extends JFrame {
	private JTextField tf1 = new JTextField(10);
	private JTextField tf2 = new JTextField(10);
	private String [] operation = {"+","-","*","/"};
	JButton result = new JButton("���");
	JButton again = new JButton("�ٽ� �Է�");
	JLabel resultLabel = new JLabel("�����");
	private JTextField tf3 = new JTextField(25); 
	
	public SimpleCalc(){
		setTitle("������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JComboBox<String> operationCombo = new JComboBox<String>(operation);
		c.add(tf1);
		c.add(operationCombo);
		c.add(tf2);
		c.add(result);
		c.add(again);
		c.add(resultLabel);
		c.add(tf3);
		
		result.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				int num1 = Integer.parseInt(tf1.getText());
				int num2 = Integer.parseInt(tf2.getText());
				JButton b = (JButton)e.getSource();
				String op = (String)operationCombo.getSelectedItem();
				if(b.getText().equals("���")) {
					switch(op) {
					case "+":
					result = num1 + num2;
					break;
					case "-":
					result = num1 - num2;
					break;
					case"*":
					result = num1 * num2;
					break;
					case"/":
					result = num1/num2;
					break;
					default:
						result = 0;
						break;
						}
			    }
;				tf3.setText("�����" + result + "�Դϴ�.");
			}
		});
		again.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("�ٽ� �Է�")) {
					tf1.setText("");
					tf2.setText("");
					tf3.setText("�ٽ� �Է� ��ư�� �������ϴ�.");
				}
			}
		});
		
		setSize(450,200);
		setVisible(true);
	}
	public static void main(String [] args) {
		new SimpleCalc();
	}
}

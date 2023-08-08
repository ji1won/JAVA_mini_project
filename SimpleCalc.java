import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalc extends JFrame {
	private JTextField tf1 = new JTextField(10);
	private JTextField tf2 = new JTextField(10);
	private String [] operation = {"+","-","*","/"};
	JButton result = new JButton("계산");
	JButton again = new JButton("다시 입력");
	JLabel resultLabel = new JLabel("계산결과");
	private JTextField tf3 = new JTextField(25); 
	
	public SimpleCalc(){
		setTitle("간단한 계산기");
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
				if(b.getText().equals("계산")) {
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
;				tf3.setText("결과는" + result + "입니다.");
			}
		});
		again.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("다시 입력")) {
					tf1.setText("");
					tf2.setText("");
					tf3.setText("다시 입력 버튼을 눌렀습니다.");
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

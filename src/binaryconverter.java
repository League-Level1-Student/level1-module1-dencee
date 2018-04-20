import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class binaryconverter implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JTextField textField = new JTextField(20);
	JButton button = new JButton("Convert");
	
	public static void main(String[] args) {
		new binaryconverter().startBinaryConverter();
	}
	
	public void startBinaryConverter() {
		// TODO Auto-generated method stub
		
		frame.setVisible(true);
		
		label.setText("");
		button.addActionListener(this);
		
		frame.getContentPane().add(panel);
		panel.add(textField);
		panel.add(button);
		panel.add(label);
		
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String binaryStr = textField.getText();
		int binaryInt = binaryConvert(textField.getText());
		System.out.println(binaryStr + "; " + binaryStr.length() + "; " + binaryInt);
		
		label.setText("Result: " + binaryInt);
		panel.add(label);
		frame.pack();
	}
	
	private int binaryConvert(String binaryStr) {
		int binaryInt = 0;
		int strLength = binaryStr.length();

		for( int i=0; i < strLength; i++ ) {
			if( binaryStr.charAt(i) == '1' ) {
				binaryInt += Math.pow(2, (strLength - 1 - i));
			}
		}
		
		return binaryInt;
	}
}

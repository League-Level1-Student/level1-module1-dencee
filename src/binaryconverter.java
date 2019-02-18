import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class binaryconverter implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField hexResult = new JTextField(10);
	JTextField decimalResult = new JTextField(10);
	JTextField asciiResult = new JTextField(10);
	JTextField textField = new JTextField(20);
	JButton button = new JButton("Convert");
	
	public static void main(String[] args) {
		new binaryconverter().startBinaryConverter();
	}
	
	public void startBinaryConverter() {
		// TODO Auto-generated method stub
		JLabel hexLabel = new JLabel("Hexidecimal");
		JLabel decimalLabel = new JLabel("Decimal");
		JLabel asciiLabel = new JLabel("ASCII");
		
		frame.setVisible(true);
		frame.setTitle("Binary Converter");
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		button.addActionListener(this);
		hexResult.setText("");
		decimalResult.setText("");
		asciiResult.setText("");
		
		frame.getContentPane().add(panel);
		
		c.gridx = 0;
		c.gridy = 0;
		panel.add(textField, c);
		
		c.gridx = 1;
		c.gridy = 0;		
		panel.add(button, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel.add(asciiLabel, c);
		
		c.gridx = 1;
		c.gridy = 1;
		panel.add(asciiResult, c);
		
		c.gridx = 0;
		c.gridy = 2;
		panel.add(decimalLabel, c);
		
		c.gridx = 1;
		c.gridy = 2;
		panel.add(decimalResult, c);
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(hexLabel, c);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(hexResult, c);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String binaryStr = textField.getText();
		int binaryInt = binaryConvert(binaryStr);
		System.out.println(binaryStr + "; " + binaryStr.length() + "; " + binaryInt);
		
		label.setText("Result: " + binaryInt);
		panel.add(label);
		frame.pack();
	}
	
	private int mathPowerBase2(int exponent) {
		int result=1;
		
		for(int i=0; i < exponent; i++) {
			result = result * 2;
		}
		return result;
	}
	
	private int binaryConvert(String binaryStr) {
		int binaryInt = 0;
		int strLength = binaryStr.length();

		for( int i=0; i < strLength; i++ ) {
			if( binaryStr.charAt(i) == '1' ) {
				binaryInt += mathPowerBase2((strLength - 1 - i));
			}
		}
		
		return binaryInt;
	}
	
	String convert(String input) {
        if(input.length() != 8){
             JOptionPane.showMessageDialog(null, "Enter 8 bits, silly!!!");
             return "-";
        }
        String binary = "[0-1]+";    //must contain numbers in the given range
        if (!input.matches(binary)) {
             JOptionPane.showMessageDialog(null, "Binary can only contain 1s or 0s, silly!!!");
             return "-";
        }
        try {
             int asciiValue = Integer.parseInt(input, 2);
             char theLetter = (char) asciiValue;
             return "" + theLetter;
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Enter a binary, silly!!!");
             return "-";
        }
   }
}

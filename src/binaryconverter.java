import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
	JTextField hexResult = new JTextField(12);
	JTextField decimalResult = new JTextField(12);
	JTextField asciiResult = new JTextField(12);
	JTextField textField = new JTextField(20);
	JButton button = new JButton("Convert");
	
	public static void main(String[] args) {
		new binaryconverter().startBinaryConverter();
	}
	
	public void startBinaryConverter() {
		// TODO Auto-generated method stub
		JLabel hexLabel = new JLabel("Hexidecimal: ");
		JLabel decimalLabel = new JLabel("Decimal: ");
		JLabel asciiLabel = new JLabel("ASCII: ");
		
		frame.setVisible(true);
		frame.setTitle("Binary Converter");
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		button.addActionListener(this);
		hexResult.setText("");
		decimalResult.setText("");
		asciiResult.setText("");
		
		frame.getContentPane().add(panel);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.LINE_START;
		textField.setText("<Number To Convert>");
		panel.add(textField, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.LINE_START;
		panel.add(button, c);
		
		//c.insets = new Insets(0,20,0,0);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.LINE_START;
		panel.add(asciiLabel, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		panel.add(asciiResult, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		panel.add(decimalLabel, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		panel.add(decimalResult, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		panel.add(hexLabel, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		panel.add(hexResult, c);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String binaryStr = textField.getText();
		String intStr = String.valueOf( binaryToInt(binaryStr) );
		String asciiStr = binaryToAscii( binaryStr );
		String hexStr = binaryToHex( binaryStr );
		
		asciiResult.setText(asciiStr);
		decimalResult.setText(intStr);
		hexResult.setText( "0x" + hexStr);
		
		frame.pack();
	}
	
	private int mathPowerBase2(int exponent) {
		int result=1;
		
		for(int i=0; i < exponent; i++) {
			result = result * 2;
		}
		return result;
	}
	
	private int binaryToInt(String binaryStr) {
/*
		int binaryInt = 0;
		int strLength = binaryStr.length();

		// Assumes left-most bit is the HOb
		for( int i=0; i < strLength; i++ ) {
			if( binaryStr.charAt(i) == '1' ) {
				binaryInt += mathPowerBase2((strLength - 1 - i));
			}
		}

		return binaryInt;
*/
        try {
            int binaryInt = Integer.parseInt(binaryStr, 2);
            return binaryInt;
       } catch (Exception e) {
            return 0;
       }
	}
	
	private String binaryToHex(String binaryStr) {
		return Integer.toHexString( binaryToInt( binaryStr ) );
	}
	
	String binaryToAscii(String input) {
        if(input.length() != 8){
             return "-";
        }
        String binary = "[0-1]+";    //must contain numbers in the given range
        if (!input.matches(binary)) {
             return "-";
        }
        try {
             int asciiValue = Integer.parseInt(input, 2);
             char theLetter = (char) asciiValue;
             return "" + theLetter;
        } catch (Exception e) {
             return "-";
        }
   }
}
/*
private String hexConvertScratch(String binaryStr) {
	String hexStr = "";
	char[] hexCharArray = new char[15];
	int quotient;
	int strLength = binaryStr.length();
	int remainder;
	int Idx = 0;
	
	int decimalValue = binaryConvert( binaryStr );
	do {
		quotient = decimalValue / 16;
		remainder = decimalValue % 16;
		
		if( remainder >= 10 ) {
			hexCharArray[Idx] = (char)( (int)'A' + (remainder - 10) );
		} else {
			hexCharArray[Idx] = String.valueOf( decimalValue % 16 ).charAt(0);
		}

		decimalValue /= 16;
		Idx++;
	} while( quotient != 0 );
	
	for(int i = ( hexCharArray.length - 1 ); i >= 0; i-- ) {
		hexStr += hexCharArray[i];
	}

	// Assumes the right-most bit is the LOb
//	for( int i = strLength-1; i > 0; i -= 4 ) {
//		binaryStr.substring(i-4, i);
//	}

	return hexStr;
}
*/

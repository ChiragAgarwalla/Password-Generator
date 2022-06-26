import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.util.Random;
import java.awt.event.ActionEvent;

public class passgen {

	private JFrame frame;
	private JTextField textResult;
	private JCheckBox CB1;
	private JCheckBox CB2;
	private JCheckBox CB3;


	/**
	 * Launch the application.
	 */
	public void passGenerator(int len) {
		String validChar="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder st = new StringBuilder();
		Random rand = new Random();
		while(0<len--) {
			st.append(validChar.charAt(rand.nextInt(validChar.length())));
		}
		textResult.setText(st.toString());
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passgen window = new passgen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public passgen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PASSWORD GENERATOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(123, 52, 237, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(62, 115, 85, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		textResult = new JTextField();
		textResult.setBounds(179, 116, 143, 43);
		frame.getContentPane().add(textResult);
		textResult.setColumns(10);
		
		CB1 = new JCheckBox("6 Character");
		CB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CB1.isSelected()) {
					CB2.setSelected(false);
					CB3.setSelected(false);

				}
			}
		});
		CB1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CB1.setBounds(62, 184, 93, 21);
		frame.getContentPane().add(CB1);
		
		CB2 = new JCheckBox("10 Character");
		CB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CB2.isSelected()) {
					CB1.setSelected(false);
					CB3.setSelected(false);

				}
			}
		});
		CB2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CB2.setBounds(62, 233, 111, 21);
		frame.getContentPane().add(CB2);
		
		CB3 = new JCheckBox("12 Character");
		CB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CB3.isSelected()) {
					CB1.setSelected(false);
					CB2.setSelected(false);

				}
			}
		});
		CB3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CB3.setBounds(62, 282, 111, 21);
		frame.getContentPane().add(CB3);
		
		JButton btnNewButton = new JButton("Generate Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CB1.isSelected()) {
					passGenerator(6);
				}
				else if(CB2.isSelected()) {
					passGenerator(10);
				}
				else if(CB3.isSelected()) {
					passGenerator(12);
				}
				else {
					passGenerator(8);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(145, 336, 212, 34);
		frame.getContentPane().add(btnNewButton);
	}
}

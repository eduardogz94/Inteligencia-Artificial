package eagz.org;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(455, 60, 64, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(349, 60, 64, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("X2");
		lblNewLabel.setBounds(461, 35, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("X1");
		lblNewLabel_1.setBounds(353, 35, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnNewButton.setBounds(485, 324, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Entrenar");
		btnNewButton_1.setBounds(399, 251, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JTextPane txtpnHola = new JTextPane();
		txtpnHola.setText("X1");
		txtpnHola.setBounds(35, 60, 116, 78);
		contentPane.add(txtpnHola);
		
		JTextPane txtpnX = new JTextPane();
		txtpnX.setText("X2");
		txtpnX.setBounds(178, 60, 116, 78);
		contentPane.add(txtpnX);
		
		JTextPane txtpnY_1 = new JTextPane();
		txtpnY_1.setText("Y1");
		txtpnY_1.setBounds(35, 175, 116, 78);
		contentPane.add(txtpnY_1);
		
		JTextPane txtpnY = new JTextPane();
		txtpnY.setText("Y2");
		txtpnY.setBounds(178, 175, 116, 78);
		contentPane.add(txtpnY);
		
		JTextPane txtpnRespuesta = new JTextPane();
		txtpnRespuesta.setText("Respuesta");
		txtpnRespuesta.setBounds(380, 125, 116, 78);
		contentPane.add(txtpnRespuesta);
		
		JLabel lblNewLabel_2 = new JLabel("Test");
		lblNewLabel_2.setBounds(402, 11, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAprender = new JLabel("Aprender");
		lblAprender.setBounds(138, 11, 89, 14);
		contentPane.add(lblAprender);
		
		JLabel lblNewLabel_3 = new JLabel("Pesos:");
		lblNewLabel_3.setBounds(35, 290, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(91, 290, 46, 23);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(153, 290, 46, 23);
		contentPane.add(textPane_1);
	}
}
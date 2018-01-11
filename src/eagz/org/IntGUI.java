package eagz.org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class IntGUI {

	private JFrame frame;
	private JTextField textX1;
	private JTextField textX2;
	private JTextField textY1;
	private JTextField textY2;
	private JTextField textW1;
	private JTextField textW2;
	private JTextField textUmbral;
	private JTextField Resultado;
	private JTextField X1_prueba;
	private JTextField X2_prueba;
	
	int[][] tv = { { 1, 1, 1},
			   { 1,-1, 1},
			   {-1, 1, 1},
			   {-1,-1,-1} };
	double w1 = new Random().nextDouble();
	double w2 = new Random().nextDouble();
	double umbral = 0.7;
	double y = 0;
	double wx = 0;
	double error = 0;
	double x1;
	double x2;
	double valor_esperado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntGUI window = new IntGUI();
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
	public IntGUI() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("NEURONA OR");
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Learn = new JButton("ENTRENAR");
		Learn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textW1.setText(Double.toString(w1));
				textW2.setText(Double.toString(w2));
				textUmbral.setText(Double.toString(umbral));
				int i = 0;
				while(i<tv.length) {
					wx = (tv[i][0] * w1) + (tv[i][1] * w2) - umbral;
					y = (wx>umbral) ? 1 : -1;
					x1 = tv[i][0];
					x2 = tv[i][1];
					valor_esperado = tv[i][2];
					y = y;
					X1_prueba.setText(Double.toString(x1));
					X2_prueba.setText(Double.toString(x2));
					textY1.setText(Double.toString(y));
					textY2.setText(Double.toString(valor_esperado));
					if (y == tv[i][2]) {
						i++;
					} else {
						error = tv[i][2] - wx;
						w1 = w1 + error * tv[i][0];
						w2 = w2 + error * tv[i][1];
						umbral = umbral + error * (-1);
						i = 0;
					}
				}	
				
				JButton Test = new JButton("PROBAR");
				Test.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						x1 = Double.parseDouble(textX1.getText());
						x2 = Double.parseDouble(textX2.getText());
						y = (x1 * w1) + (x2 * w2) - umbral;
						y = (y >= umbral) ? 1 : -1;
						Resultado.setText(Double.toString(y));
					}
				});
				Test.setBounds(287, 152, 89, 23);
				frame.getContentPane().add(Test);
			}
		});
		Learn.setBounds(33, 216, 125, 23);
		frame.getContentPane().add(Learn);
		
		
		textX1 = new JTextField();
		textX1.setBounds(284, 68, 48, 20);
		frame.getContentPane().add(textX1);
		textX1.setColumns(10);
		
		JLabel X1 = new JLabel("X1:");
		X1.setBounds(299, 43, 26, 14);
		frame.getContentPane().add(X1);
		
		JLabel X2 = new JLabel("X2:");
		X2.setBounds(356, 43, 34, 14);
		frame.getContentPane().add(X2);
		
		JLabel Y1 = new JLabel("Y:");
		Y1.setBounds(80, 97, 34, 14);
		frame.getContentPane().add(Y1);
		
		JLabel Y2 = new JLabel("VALOR ESPERADO:");
		Y2.setBounds(104, 97, 149, 14);
		frame.getContentPane().add(Y2);
		
		textX2 = new JTextField();
		textX2.setColumns(10);
		textX2.setBounds(342, 68, 48, 20);
		frame.getContentPane().add(textX2);
		
		textY1 = new JTextField();
		textY1.setColumns(10);
		textY1.setBounds(64, 122, 44, 20);
		frame.getContentPane().add(textY1);
		
		textY2 = new JTextField();
		textY2.setColumns(10);
		textY2.setBounds(118, 122, 52, 20);
		frame.getContentPane().add(textY2);
		
		JLabel Pesos = new JLabel("PESOS:");
		Pesos.setBounds(10, 174, 44, 14);
		frame.getContentPane().add(Pesos);
		
		textW1 = new JTextField();
		textW1.setColumns(10);
		textW1.setBounds(56, 153, 149, 20);
		frame.getContentPane().add(textW1);
		
		textW2 = new JTextField();
		textW2.setColumns(10);
		textW2.setBounds(56, 185, 149, 20);
		frame.getContentPane().add(textW2);
		
		textUmbral = new JTextField();
		textUmbral.setColumns(10);
		textUmbral.setBounds(10, 123, 44, 20);
		frame.getContentPane().add(textUmbral);
		
		JLabel Umbral = new JLabel("UMBRAL:");
		Umbral.setBounds(10, 97, 54, 14);
		frame.getContentPane().add(Umbral);
		
		JLabel lblResultado = new JLabel("RESULTADO:");
		lblResultado.setBounds(221, 114, 91, 14);
		frame.getContentPane().add(lblResultado);
		
		Resultado = new JTextField();
		Resultado.setColumns(10);
		Resultado.setBounds(310, 111, 80, 20);
		frame.getContentPane().add(Resultado);
		
		JLabel x1_prueba = new JLabel("X1:");
		x1_prueba.setBounds(20, 29, 34, 14);
		frame.getContentPane().add(x1_prueba);
		
		JLabel x2_prueba = new JLabel("X2:");
		x2_prueba.setBounds(102, 29, 34, 14);
		frame.getContentPane().add(x2_prueba);
		
		X1_prueba = new JTextField();
		X1_prueba.setColumns(10);
		X1_prueba.setBounds(10, 54, 44, 20);
		frame.getContentPane().add(X1_prueba);
		
		X2_prueba = new JTextField();
		X2_prueba.setColumns(10);
		X2_prueba.setBounds(90, 54, 52, 20);
		frame.getContentPane().add(X2_prueba);
	}
}
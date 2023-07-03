package sdmcet.cse.oops;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Grading extends JFrame implements ActionListener {

	JFrame f;
	JButton b;
	Container contentPane;
	JPanel p;
	JLabel l, IA1, IA2, IA3, CTA, SEE, t, g;
	JTextField t1, t2, t3, t4, t5;

	Grading(String title) {
		super(title);

		b = new JButton("Calculate");
		b.setBackground(Color.YELLOW);
		b.addActionListener(this);

		IA1 = new JLabel("     Enter IA-1 Marks   :");
		IA2 = new JLabel("     Enter IA-2 Marks   :");
		IA3 = new JLabel("     Enter IA-3 Marks   :");
		CTA = new JLabel("     Enter CTA Marks    :");
		SEE = new JLabel("     Enter SEE Marks    :");
		t = new JLabel(" [Total marks will be displayed here] ");
		g = new JLabel(" [Grade will be displayed here] ");
		t.setForeground(Color.BLUE);
		g.setForeground(Color.BLUE);

		t1 = new JTextField(5);
		t2 = new JTextField(5);
		t3 = new JTextField(5);
		t4 = new JTextField(5);
		t5 = new JTextField(5);

		l = new JLabel();

		p = new JPanel();
		p.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		p.add(IA1);
		p.add(t1);
		p.add(IA2);
		p.add(t2);
		p.add(IA3);
		p.add(t3);
		p.add(CTA);
		p.add(t4);
		p.add(SEE);
		p.add(t5);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 4;
		p.add(b, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		p.add(t, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		p.add(l, gbc);

		gbc.gridx = 2;
		gbc.gridy = 7;
		p.add(g, gbc);

		contentPane = this.getContentPane();
		contentPane.add(p, BorderLayout.SOUTH);

		p.setLayout(new GridLayout(9, 1, 4, 4));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			double IA1 = Double.parseDouble(t1.getText());
			double IA2 = Double.parseDouble(t2.getText());
			double IA3 = Double.parseDouble(t3.getText());
			double CTA = Double.parseDouble(t4.getText());
			double SEE = Double.parseDouble(t5.getText());
			double Sum = 0;

			if (IA1 > 20 || IA1 < 0)
				JOptionPane.showMessageDialog(this, "IA1 marks is incorrect", "message", JOptionPane.PLAIN_MESSAGE);

			else if (IA2 > 20 || IA2 < 0)
				JOptionPane.showMessageDialog(this, "IA2 marks is incorrect", "message", JOptionPane.PLAIN_MESSAGE);

			else if (IA3 > 20 || IA3 < 0)
				JOptionPane.showMessageDialog(this, "IA3 marks is incorrect", "message", JOptionPane.PLAIN_MESSAGE);

			else if (CTA > 10 || CTA < 0)
				JOptionPane.showMessageDialog(this, "CTA marks is incorrect", "message", JOptionPane.PLAIN_MESSAGE);

			else if (SEE > 100 || SEE < 0)
				JOptionPane.showMessageDialog(this, "SEE marks is incorrect", "message", JOptionPane.PLAIN_MESSAGE);
			else {

				if (IA1 >= IA2 && IA1 >= IA3) {
					Sum = IA1 + (IA2 >= IA3 ? IA2 : IA3);
				} else if (IA2 >= IA1 && IA2 >= IA3) {
					Sum = IA2 + (IA1 >= IA3 ? IA1 : IA3);
				} else {
					Sum = IA3 + (IA1 >= IA2 ? IA1 : IA2);
				}

				double CIEMarks = Sum + CTA;

				if (CIEMarks < 20) {
					JOptionPane.showMessageDialog(this, "Student is Detained from taking SEE", "message",
							JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
					;
				}

				if (SEE < 38) {

					JOptionPane.showMessageDialog(this, "STUDENT HAS FAILED IN SEE AND OBTAINED GRADE IS F", "message",
							JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}

				if (SEE == 38 || SEE == 39)
					SEE = 40;

				double totalMarks = 0;
				if (SEE % 2 == 0) {
					totalMarks = CIEMarks + (SEE / 2);
				} else {
					totalMarks = CIEMarks + ((SEE + 1) / 2);
				}

				char Grade = 0;
				if (totalMarks <= 100 && totalMarks >= 90) {
					Grade = 'S';

				} else if (totalMarks <= 89 && totalMarks >= 80) {
					Grade = 'A';

				} else if (totalMarks <= 79 && totalMarks >= 70) {
					Grade = 'B';

				} else if (totalMarks <= 69 && totalMarks >= 60) {
					Grade = 'C';

				} else if (totalMarks <= 59 && totalMarks >= 50) {
					Grade = 'D';

				} else if (totalMarks <= 49 && totalMarks >= 40) {
					Grade = 'E';

				} else if (totalMarks <= 39 && totalMarks >= 0) {

					Grade = 'F';

				}

				t.setText("Total Marks : " + totalMarks + "   ");
				g.setText("Grade : " + Grade + "   ");
			}
		} catch (NumberFormatException nfe) {
			System.out.println(JOptionPane.ERROR_MESSAGE);

		}

	}
}

public class GradingSystemDemo {

	public static void main(String[] args) {

		JFrame f = new Grading("Students Grading System");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		f.setBounds(150, 150, 500, 500);

		JLabel l1 = new JLabel("GRADE CALCULATOR");
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setVerticalAlignment(JLabel.CENTER);
		f.add(l1);

		f.setResizable(false);
		f.setVisible(true);

	}

}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI implements ActionListener {
	
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel label, success;
	private JTextField input;
	private int number, clicked = 0;
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		label = new JLabel("Enter an integer range separated by a hyphen (Ex. 1-1000)");
		label.setBounds(50, 60, 500, 25);
		panel.add(label);
		
		button = new JButton("Go!");
		button.setBounds(320, 20, 50, 25);
		button.addActionListener(this);
		panel.add(button);
		
		
		input = new JTextField(20);
		input.setBounds(150, 20, 165, 25);
		panel.add(input);
		
		success = new JLabel("");
		success.setBounds(175, 80, 300, 25);
		panel.add(success);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();

	}

	public void actionPerformed(ActionEvent e) {
		if(clicked == 0) {
			String in = input.getText();
			String[] nums = in.split("-");
		
			int min = Integer.parseInt(nums[0]);
			int max = Integer.parseInt(nums[1]);
			Random random = new Random();
			number = random.nextInt(max - min) + min;
		
			label.setText("Guess the random number now!");
			label.setBounds(130, 60, 300, 25);
		}
		
		else {
			String in2 = input.getText();
			int guess = Integer.parseInt(in2);
			
			if(guess < number) {
				label.setText("Too low :(");
				label.setBounds(210, 60, 100, 25);
			}
			
			else if(guess > number) {
				label.setText("Too high :(");
				label.setBounds(200, 60, 100, 25);
			}
			
			else {
				label.setText("You got it!");
				label.setBounds(200, 60, 100, 25);
				
				if(clicked == 1) {
					success.setText("It took you " + (clicked) + " try!");
				}
				
				else {
					success.setText("It took you " + (clicked) + " tries!");
				}
			}			
		}
		
		input.setText("");
		clicked++;
		
	}

}

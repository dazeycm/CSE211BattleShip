import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Craig Dazey and Nora Husani
 * @course CSE 211
 * @professor Dr. Kiper
 * @date 05/07/15 BSAskName is a GUI interface that prompts each player to enter
 *       their name in order to begin a game of battle ship
 *
 */
public class BSAskName extends JPanel {
	private static final long serialVersionUID = 2575364361360064192L;
	private JFrame frame;
	private JTextField nameEntry;
	private JButton enterName;
	private JLabel enterNameText;
	public String name = null;
	@SuppressWarnings("unused")
	private BattleShipClient client;

	/**
	 * 
	 * @param client
	 *            a BattleShipClient object that represents one of the players
	 *            in the game Preconditions: client is not NULL Postconditions:
	 *            new BSAskName GUI is created Side Effects: this.client is set
	 *            to client and GUI is set up
	 */
	public BSAskName(final BattleShipClient client) {
		this.client = client;
		this.setLayout(null);
		this.setBackground(new Color(50, 200, 200));
		nameEntry = new JTextField();
		nameEntry.setBounds(25, 60, 350, 30);
		this.add(nameEntry);

		enterName = new JButton("Submit");
		enterName.setBounds(280, 110, 90, 30);
		enterName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = nameEntry.getText();
				frame.setVisible(false);
				frame.dispose();
				client.sendMessage(Protocol.SNAPE + name);
			}
		});
		this.add(enterName);

		enterNameText = new JLabel("Please enter your name:");
		enterNameText.setBounds(25, 40, 350, 20);
		this.add(enterNameText);

		initFrame();
	}

	void initFrame() {
		frame = new JFrame("Welcome to BattleShip!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setBounds(0, 0, 400, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}

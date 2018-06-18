// focusing only on design aspect
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

// required for Class XOButton
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TicTacToe extends JFrame {

	JPanel p = new JPanel();
	XOButton buttons[]  = new XOButton[9];

	public TicTacToe() {

		super("TicTacToe");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3,3));

		for(int i=0; i<9; i++) {
			buttons[i] = new XOButton();
			p.add(buttons[i]);
		}

		// add to frame
		add(p);

		setVisible(true);

	}

	public static void main(String[] args) {
		new TicTacToe();
	}
}

//
class XOButton extends JButton implements ActionListener {

	ImageIcon X;
	ImageIcon O;

	byte value = 0;

	// 0 : Available
	// 1 represent X
	// 2 represent O

	public XOButton() {
		X = new ImageIcon(this.getClass().getResource("icon/X.png"));
		O = new ImageIcon(this.getClass().getResource("icon/O.png"));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		value++;
		value%=3;
		switch(value) {
			case 0:
				setIcon(null);
				break;
			case 1:
				setIcon(this.X);
				break;
			case 2:
				setIcon(this.O);
				break;
			default: 
				break;
		}
	}
}
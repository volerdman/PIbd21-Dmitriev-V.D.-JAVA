import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FormBus {
	private JFrame frmDoublebus;
	private JPanel panel;
	private JButton buttonDown;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton buttonUp;
	private JButton buttonCreateBus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBus window = new FormBus();
					window.frmDoublebus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormBus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	frmDoublebus = new JFrame();
	frmDoublebus.setTitle("DoubleBus");
	frmDoublebus.setBounds(100, 100, 901, 500);
	frmDoublebus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmDoublebus.getContentPane().setLayout(null);
	panel = new PanelBus();
	panel.setBackground(new Color(128, 128, 128));
	panel.setBounds(21, 11, 864, 439);
	frmDoublebus.getContentPane().add(panel);
	panel.setLayout(null);
	
	buttonRight = new JButton("→");
	buttonRight.setBounds(814, 386, 50, 50);
	panel.add(buttonRight);
	buttonRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
	buttonRight.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (PanelBus.initialization) {
				PanelBus.bus.MoveTransport(Direction.Right);
			}
			RedrawUI();
		}
	});
	
	buttonDown = new JButton("↓");
	buttonDown.setBounds(751, 386, 50, 50);
	panel.add(buttonDown);
	buttonDown.setFont(new Font("Tahoma", Font.PLAIN, 14));
	buttonDown.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (PanelBus.initialization) {
				PanelBus.bus.MoveTransport(Direction.Down);
			}
			RedrawUI();
		}
	});
	
	buttonLeft = new JButton("←");
	buttonLeft.setBounds(689, 386, 50, 50);
	panel.add(buttonLeft);
	buttonLeft.setFont(new Font("Tahoma", Font.PLAIN, 14));
	buttonLeft.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (PanelBus.initialization) {
				PanelBus.bus.MoveTransport(Direction.Left);
			}
			RedrawUI();
		}
	});
	
	buttonUp = new JButton("↑");
	buttonUp.setBounds(751, 323, 50, 50);
	panel.add(buttonUp);
	buttonUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
	buttonUp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (PanelBus.initialization) {
				PanelBus.bus.MoveTransport(Direction.Up);
			}
			RedrawUI();
		}
	});
		
	buttonCreateBus = new JButton("Обычный автобус");
	buttonCreateBus.setBounds(511, 386, 168, 25);
	panel.add(buttonCreateBus);
	buttonCreateBus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Random rnd = new Random();
			PanelBus.bus = new Bus(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000, Color.RED);
			PanelBus.initialization = true;
			PanelBus.bus.SetPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10, panel.getWidth(), panel.getHeight());
			RedrawUI();
		}
	});
	
	JButton buttonCreateDoubleBus = new JButton("Двухэтажный автобус");
	buttonCreateDoubleBus.setBounds(511, 413, 168, 23);
	panel.add(buttonCreateDoubleBus);
	buttonCreateDoubleBus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Random rnd = new Random();
			PanelBus.bus = new DoubleBus(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000, Color.RED, Color.BLACK);
			PanelBus.initialization = true;
			PanelBus.bus.SetPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10, panel.getWidth(), panel.getHeight());
			RedrawUI();
		}
	});

}

	private void RedrawUI() {
		panel.updateUI();		
	}
}

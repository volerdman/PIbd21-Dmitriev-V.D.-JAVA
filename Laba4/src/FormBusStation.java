import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FormBusStation {

	private JFrame frame;
	private JList listBoxLevels;
    private DefaultListModel model;

	private JTextField maskedTextBox1;
	MultiLevelBusStation station;
	private int countLevel = 5;
    private PanelBus pictureBoxTakeBus;
    private PanelBusStation panelBusStation;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBusStation window = new FormBusStation();
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
	public FormBusStation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 938, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelBusStation= new PanelBusStation();
		panelBusStation.setBounds(0, 11, 777, 443);
		panelBusStation.setBackground(new Color(128, 128, 128));
		frame.getContentPane().add(panelBusStation);
		
		station = panelBusStation.getBusStation();
		
		JPanel pictureBoxBusStation = new JPanel();
		pictureBoxBusStation.setBounds(0, 0, 778, 466);
		frame.getContentPane().add(pictureBoxBusStation);
		
		JButton buttonSetSimpleBus = new JButton("Bus");
		buttonSetSimpleBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				Bus bus = new Bus(100, 1000, mainColor);
				int place = station.getBusStation(listBoxLevels.getSelectedIndex()).Plus(bus);
				panelBusStation.repaint();
			}
		});
		buttonSetSimpleBus.setBounds(790, 141,  118, 41);
		frame.getContentPane().add(buttonSetSimpleBus);
		
		JButton buttonSetBus = new JButton("DoubleBus");
		buttonSetBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				Color dopColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				DoubleBus bus = new DoubleBus(100, 1000, mainColor, dopColor);
				int place = station.getBusStation(listBoxLevels.getSelectedIndex()).Plus(bus);					
				panelBusStation.repaint();
			}
		});
		buttonSetBus.setBounds(790, 182, 118, 41);
		frame.getContentPane().add(buttonSetBus);
		
		JPanel panel = new JPanel();
		panel.setBounds(779, 226, 141, 230);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		pictureBoxTakeBus = new PanelBus();
		pictureBoxTakeBus.setBounds(12, 102, 118, 115);
		pictureBoxTakeBus.setBackground(new Color(128, 128, 128));
		panel.add(pictureBoxTakeBus);
		
		JLabel label = new JLabel("Забрать автобус");
		label.setBounds(12, 0, 118, 16);
		panel.add(label);
		
		maskedTextBox1 = new JTextField();
		maskedTextBox1.setBounds(68, 29, 70, 22);
		panel.add(maskedTextBox1);
		maskedTextBox1.setColumns(10);
		
		JLabel label_1 = new JLabel("Место:");
		label_1.setBounds(12, 32, 56, 16);
		panel.add(label_1);
		
		JButton buttonTakeBus = new JButton("Забрать");
		buttonTakeBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!maskedTextBox1.getText().equals("")) {
					ITransport bus = station.getBusStation(listBoxLevels.getSelectedIndex()).Minus(Integer.parseInt(maskedTextBox1.getText()));
                    if (bus != null) {
                        bus.SetPosition(5, 5, pictureBoxTakeBus.getWidth(), pictureBoxTakeBus.getHeight());
                        pictureBoxTakeBus.setBus(bus);
                        pictureBoxTakeBus.repaint();
                        panelBusStation.repaint();
                    } else {
                    	pictureBoxTakeBus.setBus(null);
                    	pictureBoxTakeBus.repaint();
				}
			}
			}
		});
		buttonTakeBus.setBounds(22, 64, 97, 25);
		panel.add(buttonTakeBus);
		
		listBoxLevels = new JList();
		listBoxLevels.setBounds(790, 11, 118, 118);
		frame.getContentPane().add(listBoxLevels);
        model = new DefaultListModel();
        for(int i = 0; i < countLevel; i++)
        {
        	model.addElement("Уровень " + (i + 1));
        }
        listBoxLevels.setModel(model);
        listBoxLevels.setSelectedIndex(0);
        panelBusStation.setListLevels(listBoxLevels);   
        listBoxLevels.addListSelectionListener(new ListSelectionListener() { 
			@Override 
			public void valueChanged(ListSelectionEvent e) { 
				panelBusStation.repaint(); 
			} 
		});
	}
	private void RedrawUI() {
		panelBusStation.updateUI();		
	}
}

package InterFace;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import InPut.LoadFile;
import OutPut.DrawPanel;
import Program.Main;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static boolean b = false;
	
	//*****�ŧi�ɭ�*****//
	Container cp = this.getContentPane();
	
	//*****�ŧi����*****//
	JLabel grid = new JLabel("����j�p:");
	JLabel quantity = new JLabel("�椺�K��:");
	public static JTextField grid_input = new JTextField("245");
	JTextField quantity_input = new JTextField("12");
	JButton loadfile = new JButton("Load File");
	JButton drawpanel = new JButton("Draw Panel");
	JButton start = new JButton("Starts");
	public static JPanel show = new JPanel();
	public static JFileChooser open = new JFileChooser();
	
	View()
	{
		//*****�]�w���*****//
		this.setSize(1000, 800);
		this.setLayout(null);
		this.setTitle("Grid");
		
		//*****�]�w�����m*****//
		grid.setBounds(700, 30, 100, 30);
		grid_input.setBounds(760, 30, 150, 30);
		quantity.setBounds(700, 80, 100, 30);
		quantity_input.setBounds(760, 80, 150, 30);
		loadfile.setBounds(700, 130, 200, 30);
		drawpanel.setBounds(700, 180, 200, 30);
		start.setBounds(700, 230, 200, 30);
		show.setBounds(20, 20, 650, 700);
		
		//*****�]�wJPanel���*****//
		show.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		//*****�s�W����ܤ���*****//
		cp.add(grid);
		cp.add(grid_input);
		cp.add(quantity);
		cp.add(quantity_input);
		cp.add(loadfile);
		cp.add(drawpanel);
		cp.add(start);
		cp.add(show);
		
		//*****�]�w����ݩ�*****//
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//*****���J�ɮ׫��s*****//
		loadfile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LoadFile.loadfile();
			}});
		
		//*****JPanel�W�e�I���s*****//
		drawpanel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(b)
				{
					DrawPanel.drawpanel();
				}
			}});
		
		//*****������s*****//
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(b && grid_input.getText() != "" && quantity_input.getText() != "")
				{
					Main.grid = Integer.parseInt(grid_input.getText());
					Main.quantity = Integer.parseInt(quantity_input.getText());
					Main.main();
				}
			}});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new View();
	}

}

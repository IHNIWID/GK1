import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Draw extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Shape> Lista;
	CheckboxGroup group;
	Checkbox line ;
    Checkbox rectangle;
    Checkbox oval;
	
	public Draw() {

		JFrame frame = new JFrame("Grafika1");
		Lista = new ArrayList<>();

		// all components for menu + menupanel
		JPanel menupanel = new JPanel();
		JPanel panel = new JPanel(new GridLayout(1, 9));
		
		
		group = new CheckboxGroup();
		line = new Checkbox("Linia");
        rectangle = new Checkbox("Kwadrat");
        oval = new Checkbox("Elipsa");
        line.setCheckboxGroup(group);
        rectangle.setCheckboxGroup(group);
        oval.setCheckboxGroup(group);       

		JTextField parametersX = new JTextField("");
		JTextField parametersY = new JTextField("");
		JTextField parametersX1 = new JTextField("");
		JTextField parametersY1 = new JTextField("");
		JLabel position_l = new JLabel("Podaj X0 Y0:");
		JLabel parameters_l = new JLabel("Podaj X1 Y1:");
		panel.setPreferredSize(new Dimension(980, 20));

		setBackground(Color.white);
		setPreferredSize(new Dimension(1000, 400));
		
		JButton paint = new JButton("Rysuj");
		paint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(group.getSelectedCheckbox()==line){
					System.out.println("Linia");
					Line2D temp = new Line2D.Double(Double.parseDouble(parametersX.getText()), Double.parseDouble(parametersY.getText()), Double.parseDouble(parametersX1.getText()), Double.parseDouble(parametersY1.getText()));
					Lista.add(temp);
				}
				if(group.getSelectedCheckbox()==rectangle){
					System.out.println("Rect");
					Rectangle2D temp = new Rectangle2D.Double(Double.parseDouble(parametersX.getText()), Double.parseDouble(parametersY.getText()), Double.parseDouble(parametersX1.getText()), Double.parseDouble(parametersY1.getText()));
					Lista.add(temp);
				}
				if(group.getSelectedCheckbox()==oval){
					System.out.println("Oval");					
					Ellipse2D temp = new Ellipse2D.Double(Double.parseDouble(parametersX.getText()), Double.parseDouble(parametersY.getText()), Double.parseDouble(parametersX1.getText()), Double.parseDouble(parametersY1.getText()));
					Lista.add(temp);
				}
				repaint();
			}
		});
		
		JButton delete = new JButton("Usun");
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleter();
				repaint();
			}
		});
		
		// adding to frame
		panel.add(position_l);
		panel.add(parametersX);
		panel.add(parametersY);
		panel.add(parameters_l);
		panel.add(parametersX1);
		panel.add(parametersY1);
		panel.add(line);
		panel.add(rectangle);
		panel.add(oval);
		panel.add(paint);
		panel.add(delete);

		// panel into panel
		menupanel.add(panel);
		// frame add
		frame.add(menupanel, BorderLayout.NORTH);
		frame.add(this, BorderLayout.CENTER);
		// frame customization
		frame.setSize(1000, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	private void deleter(){
			for(int i=Lista.size()-1;i>=0;i--){
				Lista.remove(i);
			}
		}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g; 
		
		if(Lista!=null){
			for(int i=0;i<Lista.size();i++){
				
				g2.draw(Lista.get(i));
				
				}
			}
		
	}
	
}


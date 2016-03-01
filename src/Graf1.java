import javax.swing.*;
public class Graf1 extends JFrame {
	JPanel p;
	JFrame f;
	JCheckBox triangle;
	JCheckBox rectangle;
	JCheckBox circle;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Graf1 f = new Graf1();
	}
	
	Graf1(){
		super();
		p = new JPanel();
		triangle = new JCheckBox("triangle");
	
		p.add(triangle);
		setSize(600,480);
		p.setVisible(true);
		add(p);
		setVisible(true);
		setTitle("HeHeHe");	
		//triangle = new JTextField();
		
		//JFrame.EXIT_ON_CLOSE();		
	}

}

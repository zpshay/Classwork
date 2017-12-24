
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
	import java.util.ArrayList;
	import java.util.Iterator;

   public class SimpleGUI extends JFrame  {
   	
   	//text fields   
      private JTextField stateField;
      private JTextField zipField;
      private JTextField activeField;
      private JTextField elevationField;
		private JTextField mapField;
		private JTextArea outputField;
   	
   	//buttons
      private JButton btnState;
      private JButton btnZip;
      private JButton btnActive;
      private JButton btnElevation; 
		private JButton btnMap; 
		
		private final static String newline = "\n";
		
   
      public SimpleGUI() {
         this.setDefaultCloseOperation( EXIT_ON_CLOSE );
         this.setSize(600,400);
         this.setTitle("Station Reader");
         this.setResizable(true);
         this.setLocation(250,150);
         Container contentPane = this.getContentPane();
         contentPane.setBackground( Color.white );
         contentPane.setLayout( new GridLayout(0,3));
			
      	         
      	//create labels
         JLabel stateLabel = new JLabel("Enter State");
         JLabel zipLabel = new JLabel("Enter Zip Code");
         JLabel displayActive = new JLabel("Enter a date YYYYMMDD");
         JLabel displayElevation = new JLabel("Enter an Elevation");
			JLabel outputLabel = new JLabel("Output:");
			outputLabel.setHorizontalAlignment(JLabel.CENTER);
			//JLabel displayMap = new JLabel("");
         
      	//create fields
         this.stateField = new JTextField("",20);
         this.zipField = new JTextField("",20);
         this.activeField = new JTextField("",20);
         this.elevationField = new JTextField("",20);
			this.outputField = new JTextArea();
			
         
      	//create buttons
         this.btnState = new JButton("Display States");
         this.btnZip = new JButton("Display by Zip");
         this.btnActive = new JButton("Display Active");
         this.btnElevation = new JButton("Display by Elevation");
			this.btnMap = new JButton("Show Ohio Map");
         
      	//update pane with state
         contentPane.add(stateLabel);
         contentPane.add(this.stateField);
         contentPane.add(this.btnState);
         this.btnState.addActionListener( new StateListener() );
      	
      	//update pane with zip
         contentPane.add(zipLabel);
         contentPane.add(this.zipField);
         contentPane.add(this.btnZip);
         this.btnZip.addActionListener( new ZipListener() );
      	
      	//update pane with active
         contentPane.add(displayActive);
         contentPane.add(this.activeField);
         contentPane.add(this.btnActive);
         this.btnActive.addActionListener( new ActiveListener() );
      	
      	//update pane with elevation
         contentPane.add(displayElevation);
         contentPane.add(this.elevationField);
         contentPane.add(this.btnElevation);
         this.btnElevation.addActionListener( new ElevationListener() );
      	
			//update pane with map
			contentPane.add(new JLabel(""));
			contentPane.add(this.btnMap);
			contentPane.add(new JLabel(""));
			this.btnMap.addActionListener( new MapListener() );
			
			//update pane with output box
			contentPane.add(new JLabel(""));
			contentPane.add(outputLabel);
			contentPane.add(new JLabel(""));
			contentPane.add(new JLabel(""));
			contentPane.add(outputField);
			JScrollPane scrollPane = new JScrollPane(outputField);
			contentPane.add(scrollPane, BorderLayout.CENTER);

			
			
			
      }
		
		private class StateListener implements ActionListener {
         public void actionPerformed(ActionEvent  e) {
				String originalText = stateField.getText();
				stationreader sreader = new stationreader();
				ArrayList<String> list = sreader.findState(originalText.toUpperCase());	
				
				for (String s : list) {
				outputField.append(s + newline);
				}
				
				JOptionPane pane = new JOptionPane();
				//JOptionPane.showMessageDialog(null, stateField);
				//JOptionPane.showMessageDialog(null, stateField, "States", JOptionPane.INFORMATION_MESSAGE);
				
         }  
	 
      }

   
		private class ZipListener implements ActionListener {
         public void actionPerformed(ActionEvent  e) {
            //String originalText = stateField.getText();
            //stateField.setText(originalText.toUpperCase());
				
				//methods added by Zack & Braeden
				JOptionPane pane = new JOptionPane();
				//JOptionPane.showMessageDialog(null, zipField, "Cloest Station", JOptionPane.INFORMATION_MESSAGE);
				outputField.setText(zipField.getText());

         }  
	 
      }
		
		private class ActiveListener implements ActionListener {
         public void actionPerformed(ActionEvent  e) {
            String originalText = activeField.getText();
				
				stationreader sreader = new stationreader();
				ArrayList<String> list = sreader.getActive(originalText);	
				
				for (String s : list) {
					outputField.append(s + newline);
				}
	
				JOptionPane pane = new JOptionPane();

         }  
	 
      }
		
		private class ElevationListener implements ActionListener {
         public void actionPerformed(ActionEvent  e) {
            
				String originalText = elevationField.getText();
				stationreader sreader = new stationreader();
				ArrayList<String> list = sreader.getElevation(originalText);	
				
				for (String s : list) {
				outputField.append(s + newline);
				}

				
				JOptionPane pane = new JOptionPane();
				//JOptionPane.showMessageDialog(null, elevationField, "Stations above Elevation", JOptionPane.INFORMATION_MESSAGE);
				outputField.setText(elevationField.getText());

         }  
	 
      }
		
		private class MapListener implements ActionListener {
         public void actionPerformed(ActionEvent  e) {
            //String originalText = stateField.getText();
            //stateField.setText(originalText.toUpperCase());
				
				//methods added by Zack & Braedon
				JOptionPane pane = new JOptionPane();
				//JOptionPane.showMessageDialog(null, mapField, "Ohio Stations", JOptionPane.INFORMATION_MESSAGE);
				outputField.setText(mapField.getText());

         }  
	 
      }

         	
      public static void main(String[] args) {
         SimpleGUI frame = new SimpleGUI();
         frame.setVisible(true);
			JPanel stateJPanel = new JPanel();
					
      }				
		
			
   
   }
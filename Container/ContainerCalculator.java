
import java.awt.event.*;
import javax.swing.*;

public class ContainerCalculator extends JFrame
{
  
  public static void main( String[] args ) {
    
    ContainerCalculator frame = new ContainerCalculator();
    
    frame.setTitle( "Inventory" );
    frame.setVisible( true );
    frame.setDefaultCloseOperation( ContainerCalculator.EXIT_ON_CLOSE );    
  }

   // Frame Size
   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 100;
   
   // I will convert the int to strings. These stay for
   // calulation purposes
   private static final int CARTONS_NUM = 0;
   private static final int ITEMS_NUM = 0; 
   private double total;
   
   // labels   
   private JLabel cartonsLabel;
   private JLabel itemsLabel;
   private JLabel totalLabel;
   
   // fields
   private JTextField cartonsField;
   private JTextField itemsField;
   private JTextField totalField;
   
   // button
   private JButton button;
  
   //This is the constructor I call in the main to create a frame
   public ContainerCalculator()
   {  
     // sets the title above it as the text
     super("Inventory - Cartons & Items");
     
     // size taken from above, set at final
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      
      // I don't want people to move use the srolls
      setResizable( false );

      //  double set privately in class
      total = 0;
   
      // add the constructers defined below
      createTextField();
      createButton();
      createPanel();
     
      // lays out the program I found this from a youtube tutorial
      // setLayout( new FlowLayout() );
   }
   
   private void createTextField()
   {
      // set parameter for the text field
      final int INPUT_WIDTH = 7;
      final int OUTPUT_FIELD_WIDTH = 12;
      
      // variable set in class above
      itemsLabel = new JLabel( "Items per carton: " );
      itemsField = new JTextField( INPUT_WIDTH );
      itemsField.setText( "" + ITEMS_NUM );
     
      cartonsLabel = new JLabel("Cartons per shipment: ");
      cartonsField = new JTextField( INPUT_WIDTH );
      cartonsField.setText("" + CARTONS_NUM);
      
     
     totalLabel= new JLabel("Total: ");
     totalField= new JTextField( OUTPUT_FIELD_WIDTH );     
     totalField.setEditable( false );
     
     // After getting help, I learned that you have to create construtor clear in class clear
     // this is at the bottom
     KeyListener part2 = new Clear( totalField );
     cartonsField.addKeyListener( part2 );
     itemsField.addKeyListener( part2 );
     
     
     // I can do the following and force the location
     // I can use ___.setLocation( x, y );
     // but there has to be a better way
   }
   
   class AddInterestListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         double cartons = Double.parseDouble( cartonsField.getText() );
         double items = Double.parseDouble( itemsField.getText() );
         total = cartons * items;
         
         totalField.setText( Double.toString(total) );
      }
   }

   private void createButton()
   {
      button = new JButton("Calculate Total");      
      
      ActionListener listener = new AddInterestListener();
      button.addActionListener( listener );
   }
   
   private void createPanel()
   {
      JPanel MyPanel = new JPanel();
      
      add( MyPanel );
      
      // taken from documentation...DOESN'T WORK
      // MyPanel.setLayout( new BoxLayout( MyPanel, BoxLayout.PAGE_AXIS ) );
      
      // these neet to have the right order for arrangement
      // left to right then they move down
      
      MyPanel.add( cartonsLabel );
      MyPanel.add( cartonsField );

      MyPanel.add( totalLabel );
      MyPanel.add( totalField );
      
      MyPanel.add( itemsLabel );
      MyPanel.add( itemsField );
      
      MyPanel.add( button );
      
      // for scrolling
      // JScrollPane scrollPane = new JScrollPane( resultArea );
      // panel.add( scrollPane );      
      
   }
}


class Clear implements KeyListener {
 
 private JTextField blank;
 
 // Sets the variable to the local variable for chaning
 Clear(JTextField needsClearing) {
   this.blank = needsClearing; 
 } 
 
 // this is the action of setting it to blank, once you press a key in the text box. 
 public void keyPressed(KeyEvent e) { blank.setText(""); }
 
 // These are required in implementing KeyListener
 public void keyReleased(KeyEvent e) {  }
 public void keyTyped(KeyEvent e) { }
}
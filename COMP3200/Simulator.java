import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Simulator extends JFrame {

   private JTextField txtLength, txtReportInt, txtAvgArr;
   private JButton btnFinish;

   public Simulator() {
      this.setDefaultCloseOperation( EXIT_ON_CLOSE );
      this.setSize(230,500);
      this.setTitle("Simulation App");
      this.setResizable(true);
      this.setLocation(450,250);
      Container contentPane = this.getContentPane();
      contentPane.setBackground ( Color.white );
      contentPane.setLayout( new FlowLayout() );
      JLabel lblPrompt = new JLabel("Length of Simulation: ");
      this.txtLength = new JTextField("",10);
      JLabel lblPrompt1 = new JLabel("Reporting Interval: ");
      this.txtReportInt = new JTextField("",10);
      JLabel lblPrompt2 = new JLabel("Average Time Between Arrivals: ");
      this.txtAvgArr = new JTextField("",10);

      contentPane.add(lblPrompt);
      contentPane.add(this.txtLength);
      contentPane.add(lblPrompt1);
      contentPane.add(this.txtReportInt);
      contentPane.add(lblPrompt2);
      contentPane.add(this.txtAvgArr);

   }

   public static void main(String[] args) {
      Simulator frame = new Simulator();
      frame.setVisible(true);
   }


}
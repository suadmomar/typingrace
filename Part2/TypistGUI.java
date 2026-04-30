import javax.swing.*;
import javax.xml.stream.FactoryConfigurationError;

public class TypistGUI 
{
    public static void main(String[] args) {

        JLabel l1 = new JLabel("How many Typists are taking part? (2-6)");
        l1.setBounds(100,50, 300,30);

        JTextField tf = new JTextField();
        tf.setBounds(100,90,200,30);

        String [] options = new String[]{"Short", "Medium", "Long", "Custom"};
        JLabel l2 = new JLabel("Passage Selection");
        l2.setBounds(100,120,300,30);

        JComboBox combo = new JComboBox<String>(options);
        combo.setBounds(100,150,200,30);
        combo.addActionListener(e -> {
            String x = combo.getSelectedItem().toString();
            System.out.println(x);
        });

        JLabel l3 = new JLabel("Difficulty Modifiers");
        l3.setBounds(100,180,300,30);

        JCheckBox cmode = new JCheckBox("Caffeine Mode");
        cmode.setBounds(100,210,200,30);
        cmode.addActionListener(e -> {
            boolean isCaffeine = cmode.isSelected();
            System.out.println(isCaffeine);

        });

        JCheckBox auto = new JCheckBox("Autocorrect Mode");
        auto.setBounds(100,240,200,30);
        auto.addActionListener(e -> {
            boolean isAuto = auto.isSelected();
            System.out.println(isAuto);
        });

        JCheckBox nsmode = new JCheckBox("Night Shift Mode");
        nsmode.setBounds(100,270,200,30);
        nsmode.addActionListener(e -> {
            boolean isNight = nsmode.isSelected();
            System.out.println(isNight);
        });

        JButton submit = new JButton("Start");
        submit.setBounds(100,300,200,30);

        JFrame frame = new JFrame("Typing Race Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(l1);
        frame.add(tf);
        frame.add(l2);
        frame.add(combo);
        frame.add(l3);
        frame.add(cmode);
        frame.add(auto);
        frame.add(nsmode);
        frame.add(submit);
        frame.setSize(500,500);
        frame.setVisible(true);

        submit.addActionListener(e -> {
            String x = tf.getText();
            int s = seatCount(frame, x);
            if(s != -1){
                JOptionPane.showMessageDialog(frame, "This race will have " + s + " Typists");
                JFrame race = new JFrame("Typing Race");
                race.setSize(500,500);
                race.setVisible(true);
                frame.setVisible(false);
                race.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }

    public static int seatCount(JFrame frame, String x){
        try{
            int y = Integer.parseInt(x.trim());

            if(y <= 6 && y >= 2){
                return y;
            }
            else{
                JOptionPane.showMessageDialog(frame, "Enter a number between 2 and 6");
                return -1;
            }
            
        }
        catch(NumberFormatException e ){
            JOptionPane.showMessageDialog(frame, "Enter a number between 2 and 6");
            return -1;
        }
        
    }

}

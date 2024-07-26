import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;


public class Currency extends JFrame {
    private final JTextField zlotyInput = new JTextField("", 8);
    private final JTextField euroInput = new JTextField("", 8);
    private final JButton submitButton = new JButton("Clear fields");

    public Currency() {
        // building the interface
        super("Currency converter");
        this.setBounds(200, 200, 350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border padding = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        JPanel panel = new JPanel();
        panel.setBorder(padding);
        panel.setLayout(new GridLayout(3, 2, 4, 4));
        setContentPane(panel);
        panel.add(new JLabel("Zloty"));
        panel.add(zlotyInput);
        panel.add(new JLabel("Euro"));
        panel.add(euroInput);
        panel.add(submitButton);
        // attaching event listeners
        zlotyInput.addActionListener(new ActionListener() {
            @Override public void actionPerformed (ActionEvent e){
                zte();
            }

        });
        euroInput.addActionListener(new ActionListener() {
            @Override public void actionPerformed (ActionEvent e){
                etz();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private void showError() {
        JOptionPane.showMessageDialog(
                null,
                "Incorrect number format",
                "Error occured",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void clearFields() {
        zlotyInput.setText("");
        euroInput.setText("");
    }


            private void zte() {
                try {
                    var rawText = zlotyInput.getText();
                    var zlotys = Double.parseDouble(rawText);
                    var euros = CurrencyConverter.zlotyToEuro(zlotys);
                    var euros1 = String.format("%.2f",euros);

                    euroInput.setText(euros1);

                } catch (NumberFormatException exception) {
                    System.out.println(exception.getMessage());
                    showError();
                }
            }


            private void etz() {
                try {
                    var rawText = euroInput.getText();
                    var euros = Double.parseDouble(rawText);
                    var zlotys = CurrencyConverter.euroToZloty(euros);
                    var zlotys1 = String.format("%.2f",zlotys);
                    zlotyInput.setText(zlotys1);
                } catch (NumberFormatException exception) {
                   System.out.println(exception.getMessage());
                    showError();
                }

    }
}

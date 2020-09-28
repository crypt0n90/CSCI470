
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    /********************************************************************
     *                                                                  *
     *  CSCI 470-1/502-1       In-Class Exercise 0         Summer 2019  *
     *                               Part 2                             *
     *                                                                  *
     *  Class Name:  Add2                                               *
     *                                                                  *
     *  Programmer:  Your name goes here.                               *
     *               (If you're working in a team, list                 *
     *               names of each team member here with                *
     *               Z-IDs and the team lead's name first.)             *
     *                                                                  *
     *  Purpose:     A Swing GUI program that adds two numbers and      *
     *               displays the result.                               *
     *                                                                  *
     ********************************************************************/

    public class Add2 extends JFrame implements ActionListener
    {

        // The following serialVersionUID use will be discussed later this
        // semester.

        private static final long serialVersionUID = 1L;

        private JButton addButton = new JButton("Add Numbers");
        private JButton clearButton = new JButton("Clear Numbers");
        private JTextField num1Field = new JTextField(10);
        private JTextField num2Field = new JTextField(10);
        private JLabel sumLabel = new JLabel();

        public static void main(String[] args)
        {
            EventQueue.invokeLater(() ->
            {
                Add2 frame = new Add2("Sum of Two Numbers");
                frame.createAndShowGUI();
            });
        }
        private Add2(String title)
        {
            super(title);
        }

        /****************************************************************
         *  Create the GUI and show it. For thread safety, this method  *
         *  method should be invoked from the event-dispatch thread.    *
         ****************************************************************/

        private void createAndShowGUI()
        {
            initComponents();

            // Add listeners for the buttons.

            addButton.addActionListener(this);
            clearButton.addActionListener(this);

            // Display the window.

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            pack();
            setVisible(true);
        }

        /****************************************************************
         *  Set the frame's layout, create the GUI components and add   *
         *  them to the layout.                                         *
         ****************************************************************/

        private void initComponents()
        {
            JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            panel.add(new JLabel("First number:"));
            panel.add(num1Field);
            panel.add(new JLabel("Second number:"));
            panel.add(num2Field);
            panel.add(new JLabel("Sum:"));
            panel.add(sumLabel);
            panel.add(addButton);
            panel.add(clearButton);

            add(panel, BorderLayout.CENTER);
        }

        /****************************************************************
         *  Handle ActionEvents from the buttons.                       *
         ****************************************************************/

        @Override
        public void actionPerformed(ActionEvent e)
        {
            double num1, num2;

            if (e.getSource() == clearButton)
            {
                num1Field.setText("");
                num2Field.setText("");
                sumLabel.setText("");
            }
            else
            {
                // Try to convert String to double for calculation.

                try
                {
                    num1 = Double.parseDouble(num1Field.getText());
                }
                catch (NumberFormatException nfe1)
                {
                    sumLabel.setText("1st number invalid.");
                    return;
                }

                // Try to convert String to double for calculation.

                try
                {
                    num2 = Double.parseDouble(num2Field.getText());
                }
                catch (NumberFormatException nfe1)
                {
                    sumLabel.setText("2nd number invalid.");
                    return;
                }

                // Compute and display the sum.

                sumLabel.setText(String.format("%.2f", num1 + num2));
            }
        }
    }



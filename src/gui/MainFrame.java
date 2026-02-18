package gui;

import core.GameManager;
import javax.swing.*;
import java.awt.*;

import static resources.GameMenuStrings.getErrorText;

public class MainFrame extends JFrame {
    private JTextArea display;
    private JTextField inputField;
    private GameManager gameManager;

    public MainFrame() {
        initGUI();
        gameManager = new GameManager(display);
    }

    private void initGUI() {
        Color darkBackground = new Color(30, 30, 30);
        setTitle("Rookie Revenge");

        setSize(325, 700);
        setResizable(false);
        Dimension fixedSize = new Dimension(325, 600);
        setPreferredSize(fixedSize);
        setMinimumSize(fixedSize);
        setMaximumSize(fixedSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextArea();
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.GREEN);
        display.setFont(new Font("Monospaced", Font.BOLD, 14));
        display.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(darkBackground);

        inputField = new JTextField();
        inputField.setBackground(new Color(20, 20, 20));
        inputField.setForeground(Color.WHITE);
        inputField.setCaretColor(Color.WHITE);
        inputField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 16));

        inputField.addActionListener(e -> {
            String input = inputField.getText().trim();

            if (input.isEmpty()) {
                gameManager.handleSelection("0");
            } else {
                try {
                    String choice = inputField.getText().trim();
                    gameManager.handleSelection(choice);
                } catch (NumberFormatException ex) {
                    display.append(getErrorText());
                }
            }
            inputField.setText("");
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(darkBackground);
        JLabel prompt = new JLabel(" Input > ");
        prompt.setForeground(Color.WHITE);
        inputPanel.add(prompt, BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(inputPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);
        getContentPane().setBackground(darkBackground);
        setLocationRelativeTo(null);

        this.setVisible(true);
    }
}
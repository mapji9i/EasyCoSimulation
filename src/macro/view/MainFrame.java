package macro.view;

import macro.ChainStepper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    ChainStepper stepper;
    public MainFrame(ChainStepper stepper) throws HeadlessException {
        this.stepper=stepper;
        init();
    }

    private void init(){
        this.setLayout(new FlowLayout());

        JButton startButton = new JButton("Start|>>");
        JButton stopButton = new JButton("Stop[]");
        stopButton.setEnabled(false);
        JButton stepButton = new JButton("Step|>");
        JButton exitButton = new JButton("Exit");
        this.add(startButton);
        this.add(stepButton);
        this.add(stopButton);
        this.add(exitButton);


        startButton.addActionListener(e -> {
            stepper.incrementLimit(Integer.MAX_VALUE);
            stopButton.setEnabled(true);
            stepButton.setEnabled(false);
            startButton.setEnabled(false);
        });

        stopButton.addActionListener(e -> {
            stepper.trimLimit();
            stopButton.setEnabled(false);
            stepButton.setEnabled(true);
            startButton.setEnabled(true);
        });


        stepButton.addActionListener(e -> {
            stepper.incrementLimit(1);
            stopButton.setEnabled(true);
            stepButton.setEnabled(false);
            startButton.setEnabled(false);
        });

        exitButton.addActionListener(e -> {
            stepper.trimLimit();
            stopButton.setEnabled(false);
            stepButton.setEnabled(false);
            startButton.setEnabled(false);
            stepper.stop();
            this.setVisible(false);
        });
        this.setSize(new Dimension(200,40));
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

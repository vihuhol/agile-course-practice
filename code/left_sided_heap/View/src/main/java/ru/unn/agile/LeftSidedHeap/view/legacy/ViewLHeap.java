package ru.unn.agile.LeftSidedHeap.view.legacy;

import ru.unn.agile.LeftSidedHeap.viewmodel.legacy.ViewModel;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class ViewLHeap {

    public static void main(final String[] args) {
        JFrame frame = new JFrame("Left Heap");

        frame.setContentPane(new ViewLHeap(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private ViewLHeap() {

    }

    private ViewLHeap(final ViewModel viewModel) {
        this.viewModel = viewModel;
        backBind();

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                ViewLHeap.this.viewModel.add();
                backBind();
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                bind();
                ViewLHeap.this.viewModel.remove();
                backBind();
            }
        });

        KeyAdapter keyListener = new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                bind();
                ViewLHeap.this.viewModel.processKeyInTextField();
                backBind();
            }
        };
        fieldAdd.addKeyListener(keyListener);
        fieldRemove.addKeyListener(keyListener);
    }

    private void bind() {
        viewModel.setTextAdd(fieldAdd.getText());
        viewModel.setTextRemove(fieldRemove.getText());
    }

    private void backBind() {
        fieldAdd.setText(viewModel.getTextAdd());
        fieldRemove.setText(viewModel.getTextRemove());
        buttonAdd.setEnabled(viewModel.isButtonAddEnabled());
        buttonRemove.setEnabled(viewModel.isButtonRemoveEnabled());

        textSizeHeap.setText(viewModel.getTextSizeHeap());
        textMinInHeap.setText(viewModel.getTextMinInHeap());
        textRemoveFromHeap.setText(viewModel.getTextRemoveFromHeap());
        textStatus.setText("Status: " + viewModel.getStatus());
    }

    private ViewModel viewModel;
    private JTextField fieldAdd;
    private JButton buttonAdd;
    private JTextField fieldRemove;
    private JButton buttonRemove;
    private JPanel mainPanel;
    private JTextField textStatus;
    private JTextField textSizeHeap;
    private JTextField textMinInHeap;
    private JTextField textRemoveFromHeap;

}

package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CompilerIDE extends JFrame{
	
	public static void main(String args[]){ new CompilerIDE(); }
	/**
	 * Woopsiedaisy
	 */
	private static final long serialVersionUID = -8308237598155075631L;
	private static final Dimension btnDimension = new Dimension(100, 30);
	private File fileToBeOpened;

	public CompilerIDE(){
		super("Javathon");
		setPreferredSize(new Dimension(230, 100));
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		InitializeComponents();
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void InitializeComponents() {
		add(new JLabel("Javathon! A friendly compiler."));
		JButton btnSelect = createButton("Select file");
		btnSelect.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("C:"));
				int returnVal = fc.showOpenDialog(CompilerIDE.this);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            fileToBeOpened = fc.getSelectedFile();
		        }
			}
		});
		add(btnSelect);
		
		JButton btnCompile = createButton("Compile");
		btnCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Compiler.Compile(fileToBeOpened);
				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
			}
		});
		add(btnCompile);
	}

	private JButton createButton(String string) {
		JButton button = new JButton(string);
		button.setPreferredSize(btnDimension);
		button.setFocusable(false);
		return button;
	}
}

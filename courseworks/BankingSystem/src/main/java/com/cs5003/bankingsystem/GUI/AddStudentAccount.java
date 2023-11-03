package com.cs5003.bankingsystem.GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.cs5003.bankingsystem.Data.FileIO;

public class AddStudentAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nametextField;
        private JTextField addresstextField;
        private JTextField opendatetextField;
	private JTextField balancetextField;
	private JTextField institutiontextField;

	/**
	 * Create the frame.
	 */
	public AddStudentAccount() {
		setTitle("Add Student Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCurrentAccount = new JLabel("Add Student Account ");
		lblAddCurrentAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddCurrentAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCurrentAccount.setBounds(10, 11, 414, 34);
		contentPane.add(lblAddCurrentAccount);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(10, 72, 124, 14);
		contentPane.add(lblName);
		
		nametextField = new JTextField();
		nametextField.setBounds(144, 69, 254, 20);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
                
                JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAddress.setBounds(10, 92, 124, 14);
		contentPane.add(lblAddress);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(144, 99, 254, 20);
		contentPane.add(addresstextField);
		addresstextField.setColumns(10);
                
                JLabel lblOpenDate = new JLabel("OpenDate:");
		lblOpenDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOpenDate.setBounds(10, 102, 124, 14);
		contentPane.add(lblOpenDate);
		
		opendatetextField = new JTextField();
		opendatetextField.setBounds(144, 119, 254, 20);
		contentPane.add(opendatetextField);
		opendatetextField.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBalance.setBounds(10, 128, 124, 14);
		contentPane.add(lblBalance);
		
		balancetextField = new JTextField();
		balancetextField.setColumns(10);
		balancetextField.setBounds(144, 135, 254, 20);
		contentPane.add(balancetextField);
		
		JLabel lblMaximumWithdrawLimit = new JLabel("Institution Name:");
		lblMaximumWithdrawLimit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaximumWithdrawLimit.setBounds(10, 163, 135, 14);
		contentPane.add(lblMaximumWithdrawLimit);
		
		institutiontextField = new JTextField();
		institutiontextField.setColumns(10);
		institutiontextField.setBounds(144, 160, 254, 20);
		contentPane.add(institutiontextField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				FileIO file=new FileIO();
				//Bank bank =file.Read();
				String name=nametextField.getText();
                                String address = addresstextField.getText();
                                String opendate = opendatetextField.getText();
				double bal=Double.parseDouble(balancetextField.getText());
				String insname=institutiontextField.getText();
				if(bal<100)
				{
					JOptionPane.showMessageDialog(getComponent(0), "Minimum Limit 5000", "Warning", 0);
					nametextField.setText(null);
                                        addresstextField.setText(null);
                                        opendatetextField.setText(null);
					balancetextField.setText(null);
					institutiontextField.setText(null);
				}
				else
				{
				if(name==null||bal<=0||insname==null)
				{
					JOptionPane.showMessageDialog(getComponent(0),"Typing Mismatch!! Try Again");
					nametextField.setText(null);
                                        addresstextField.setText(null);
                                        opendatetextField.setText(null);
					balancetextField.setText(null);
					institutiontextField.setText(null);
				}
				else
				{
				try {
					FileIO.bank.addAccount(name, address, opendate, bal, insname);
				} catch (Exception e1) {
					
				}
				int ch=JOptionPane.showConfirmDialog(getComponent(0), "Confirm?");
				if(ch==0)
				{
					int index = 0;
					try {
						index = FileIO.bank.addAccount(name, address, opendate, bal, insname);
					} catch (Exception e1) {
						
					}
					DisplayList.arr.addElement(FileIO.bank.getAccounts()[index].toString());
					//file.Write(FileIO.bank);
					JOptionPane.showMessageDialog(getComponent(0),"Added Successfully");
					dispose();
				}
				else 
				{
					JOptionPane.showMessageDialog(getComponent(0),"Failed");
					nametextField.setText(null);
                                        addresstextField.setText(null);
                                        opendatetextField.setText(null);
					balancetextField.setText(null);
					institutiontextField.setText(null);
				}
				
				}
				}
				
				
				
			}
		});
		btnAdd.setBounds(86, 209, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametextField.setText(null);
                                addresstextField.setText(null);
                                opendatetextField.setText(null);
				balancetextField.setText(null);
				institutiontextField.setText(null);
			
			}
		});
		btnReset.setBounds(309, 209, 89, 23);
		contentPane.add(btnReset);
	}
}

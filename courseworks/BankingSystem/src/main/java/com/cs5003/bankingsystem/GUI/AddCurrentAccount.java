package com.cs5003.bankingsystem.GUI;
import javax.swing.JFrame;
import com.cs5003.bankingsystem.Data.FileIO;
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
import java.awt.SystemColor;

public class AddCurrentAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nametextField;
        private JTextField addresstextField;
        private JTextField opendatetextField;
	private JTextField balancetextField;
	private JTextField tradetextField;

	/**
	 * Create the frame.
	 */
	public AddCurrentAccount() {
		setTitle("Add Current Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCurrentAccount = new JLabel("Add Current Account ");
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
		addresstextField.setBounds(144, 89, 254, 20);
		contentPane.add(addresstextField);
		addresstextField.setColumns(10);
                
                JLabel lblOpenDate = new JLabel("OpenDate:");
		lblOpenDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOpenDate.setBounds(10, 112, 124, 14);
		contentPane.add(lblOpenDate);
		
		opendatetextField = new JTextField();
		opendatetextField.setBounds(144, 109, 254, 20);
		contentPane.add(opendatetextField);
		opendatetextField.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBalance.setBounds(10, 132, 124, 14);
		contentPane.add(lblBalance);
		
		balancetextField = new JTextField();
		balancetextField.setColumns(10);
		balancetextField.setBounds(144, 129, 254, 20);
		contentPane.add(balancetextField);
		
		JLabel lblMaximumWithdrawLimit = new JLabel("Trade Licence Number:");
		lblMaximumWithdrawLimit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaximumWithdrawLimit.setBounds(10, 163, 135, 14);
		contentPane.add(lblMaximumWithdrawLimit);
		
		tradetextField = new JTextField();
		tradetextField.setColumns(10);
		tradetextField.setBounds(144, 160, 254, 20);
		contentPane.add(tradetextField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			//	FileIO file=new FileIO();
				//Bank bank=file.Read();
				String name=nametextField.getText();
                                String address = addresstextField.getText();
                                String opendate = opendatetextField.getText();
				double bal=Double.parseDouble(balancetextField.getText());
				String trlic=tradetextField.getText();
				if(bal<5000)
				{
					JOptionPane.showMessageDialog(getComponent(0), "Minimum Limit 5000", "Warning", 0);
					nametextField.setText(null);
                                        addresstextField.setText(null);
                                        opendatetextField.setText(null);
					balancetextField.setText(null);
					tradetextField.setText(null);
				}
				else
				{
				if(name==null||bal<=0||trlic==null)
				{
					JOptionPane.showMessageDialog(getComponent(0),"Typing Mismatch!! Try Again");
					nametextField.setText(null);
                                        addresstextField.setText(null);
                                        opendatetextField.setText(null);
					balancetextField.setText(null);
					tradetextField.setText(null);
				}
				else
				{
					
				int ch=JOptionPane.showConfirmDialog(getComponent(0), "Confirm?");
				if(ch==0)
				{
					int index = 0;
					try {
						index = FileIO.bank.addAccount(name, address, opendate, bal, trlic);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DisplayList.arr.addElement(FileIO.bank.getAccounts()[index].toString());
					//file.Write(bank);
					JOptionPane.showMessageDialog(getComponent(0),"Success");
					dispose();
				}
				else 
				{
					JOptionPane.showMessageDialog(getComponent(0),"Failed");
					nametextField.setText(null);
                                        addresstextField.setText(null);
                                        opendatetextField.setText(null);
					balancetextField.setText(null);
					tradetextField.setText(null);
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
				tradetextField.setText(null);
			
			}
		});
		btnReset.setBounds(309, 209, 89, 23);
		contentPane.add(btnReset);
	}
}

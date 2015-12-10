package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.rmi.dgc.Lease;
import java.text.DecimalFormat;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField tfTableSize;
	private JLabel lblRandomFileName;
	private JLabel lblAverage;
	private JLabel lblComparisons;
	private JLabel lblMissingFileName;
	private JLabel lblPresentFileName;
	private JButton btnSelectRandom;
	private JButton btnSelectMissing;
	private JButton btnSelectPresent;
	private JButton btnSearch;
	private JButton btnBuildHashTable;
	private JRadioButton rdbtnDivision;
	private JRadioButton rdbtnLinearProbing;
	private JRadioButton rdbtnQuadraticProbing;
	private JRadioButton rdbtnLinearQuotientProbing;
	private JRadioButton rdbtnPresentKeys;
	private JRadioButton rdbtnMissingKeys;
	private ButtonGroup groupHash, groupCollision, groupDataFile;
	private DecimalFormat myFormatter = new DecimalFormat("##.##");
	
	
	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][][][][][]"));
		
		JLabel lblRandomKeys = new JLabel("Random Keys:");
		contentPane.add(lblRandomKeys, "cell 0 0");
		
		lblRandomFileName = new JLabel("file name");
		contentPane.add(lblRandomFileName, "cell 1 0");
		
		btnSelectRandom = new JButton("Select");
		contentPane.add(btnSelectRandom, "cell 2 0");
		
		JLabel lblMissingKeys = new JLabel("Missing Keys:");
		contentPane.add(lblMissingKeys, "cell 0 1");
		
		lblMissingFileName = new JLabel("file name");
		contentPane.add(lblMissingFileName, "cell 1 1");
		
		btnSelectMissing = new JButton("Select");
		contentPane.add(btnSelectMissing, "cell 2 1");
		
		JLabel lblPresentKeys = new JLabel("Present Keys:");
		contentPane.add(lblPresentKeys, "cell 0 2");
		
		lblPresentFileName = new JLabel("file name");
		contentPane.add(lblPresentFileName, "cell 1 2");
		
		btnSelectPresent = new JButton("Select");
		contentPane.add(btnSelectPresent, "cell 2 2");
		
		JLabel lblHashingFunction = new JLabel("Hashing Function:");
		contentPane.add(lblHashingFunction, "cell 0 3");
		
		rdbtnDivision = new JRadioButton("Division");
		contentPane.add(rdbtnDivision, "cell 1 4");
		
		JLabel lblCollisionHandlers = new JLabel("Collision Handlers:");
		contentPane.add(lblCollisionHandlers, "cell 0 5");
		
		rdbtnLinearProbing = new JRadioButton("Linear Probing");
		contentPane.add(rdbtnLinearProbing, "cell 1 6");
		
		rdbtnQuadraticProbing = new JRadioButton("Quadratic Probing");
		contentPane.add(rdbtnQuadraticProbing, "cell 1 7");
		
		rdbtnLinearQuotientProbing = new JRadioButton("Linear Quotient Probing");
		contentPane.add(rdbtnLinearQuotientProbing, "cell 1 8");
		
		JLabel lblTableSize = new JLabel("Table Size:");
		contentPane.add(lblTableSize, "cell 0 9");
		
		tfTableSize = new JTextField();
		contentPane.add(tfTableSize, "cell 1 9");
		tfTableSize.setColumns(10);
		
		btnBuildHashTable = new JButton("Build Hash Table");
		contentPane.add(btnBuildHashTable, "cell 0 10");
		
		JLabel lblChoose = new JLabel("Choose:");
		contentPane.add(lblChoose, "cell 0 11");
		
		rdbtnMissingKeys = new JRadioButton("Missing Keys Table");
		contentPane.add(rdbtnMissingKeys, "cell 1 12");
		
		rdbtnPresentKeys = new JRadioButton("Present Keys Tabel");
		contentPane.add(rdbtnPresentKeys, "cell 1 13");
		
		btnSearch = new JButton("Search");
		contentPane.add(btnSearch, "cell 0 14");
		
		JLabel lblNumberOfComparisons = new JLabel("Number of comparisons:");
		contentPane.add(lblNumberOfComparisons, "cell 0 15");
		
		lblComparisons = new JLabel("###");
		contentPane.add(lblComparisons, "cell 1 15");
		
		JLabel lblAverageOfComparisons = new JLabel("Average of comparisons:");
		contentPane.add(lblAverageOfComparisons, "cell 0 16");
		
		lblAverage = new JLabel("###");
		contentPane.add(lblAverage, "cell 1 16");
		
		groupHash = new ButtonGroup();
		groupHash.add(rdbtnDivision);
		
		groupCollision = new ButtonGroup();
		groupCollision.add(rdbtnLinearProbing);
		groupCollision.add(rdbtnLinearQuotientProbing);
		groupCollision.add(rdbtnQuadraticProbing);
		
		groupDataFile = new ButtonGroup();
		groupDataFile.add(rdbtnMissingKeys);
		groupDataFile.add(rdbtnPresentKeys);
	}
	
	public void setRandomFileName(String name) {
		lblRandomFileName.setText(name);
	}
	
	public void setMissingFileName (String name) {
		lblMissingFileName.setText(name);
	}
	
	public void setPresentFileName (String name) {
		lblPresentFileName.setText(name);
	}
	
	public void setAverageComparison (double average) {
		lblAverage.setText(myFormatter.format(average));
	}
	
	public void setNumberOfComparison (int comparisons) {
		lblComparisons.setText("" + comparisons);
	}
	
	public void addListeners (ActionListener listener) {
		btnBuildHashTable.addActionListener(listener);
		btnSearch.addActionListener(listener);
		btnSelectMissing.addActionListener(listener);
		btnSelectPresent.addActionListener(listener);
		btnSelectRandom.addActionListener(listener);
	}
	
	private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	public String getSelectedValueOfGroupHash() {
		return getSelectedButtonText(groupHash);
	}
	
	public String getSelectedValueOfGroupCollision() {
		return getSelectedButtonText(groupCollision);
	}

	public String getSelectedValueOfGroupDataFile() {
		return getSelectedButtonText(groupDataFile);
	}
	
	public int getTableSize() {
		return Integer.parseInt(tfTableSize.getText());
	}
	
}

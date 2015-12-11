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

import Theme.QButton;
import Theme.QLabel;
import Theme.QRadioButton;
import Theme.QTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class View extends JFrame {

	private JPanel contentPane;
	private QTextField tfTableSize;
	private QLabel lblRandomFileName;
	private QLabel lblAverage;
	private QLabel lblComparisons;
	private QLabel lblMissingFileName;
	private QLabel lblPresentFileName;
	private QButton btnSelectRandom;
	private QButton btnSelectMissing;
	private QButton btnSelectPresent;
	private QButton btnSearch;
	private QButton btnBuildHashTable;
	private QRadioButton rdbtnDivision;
	private QRadioButton rdbtnLinearProbing;
	private QRadioButton rdbtnQuadraticProbing;
	private QRadioButton rdbtnLinearQuotientProbing;
	private QRadioButton rdbtnPresentKeys;
	private QRadioButton rdbtnMissingKeys;
	private ButtonGroup groupHash, groupCollision, groupDataFile;
	private DecimalFormat myFormatter = new DecimalFormat("##.##");
	
	
	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][][][][][][][][]"));
		
		QLabel lblRandomKeys = new QLabel("Random Keys:");
		contentPane.add(lblRandomKeys, "cell 0 0");
		
		lblRandomFileName = new QLabel("");
		contentPane.add(lblRandomFileName, "cell 1 0");
		
		btnSelectRandom = new QButton("Select");
		contentPane.add(btnSelectRandom, "cell 2 0");
		
		QLabel lblMissingKeys = new QLabel("Missing Keys:");
		contentPane.add(lblMissingKeys, "cell 0 1");
		
		lblMissingFileName = new QLabel("");
		contentPane.add(lblMissingFileName, "cell 1 1");
		
		btnSelectMissing = new QButton("Select");
		contentPane.add(btnSelectMissing, "cell 2 1");
		
		QLabel lblPresentKeys = new QLabel("Present Keys:");
		contentPane.add(lblPresentKeys, "cell 0 2");
		
		lblPresentFileName = new QLabel("");
		contentPane.add(lblPresentFileName, "cell 1 2");
		
		btnSelectPresent = new QButton("Select");
		contentPane.add(btnSelectPresent, "cell 2 2");
		
		QLabel lblHashingFunction = new QLabel("Hashing Function:");
		contentPane.add(lblHashingFunction, "cell 0 3");
		
		rdbtnDivision = new QRadioButton("Division");
		contentPane.add(rdbtnDivision, "cell 1 4");
		
		QLabel lblCollisionHandlers = new QLabel("Collision Handlers:");
		contentPane.add(lblCollisionHandlers, "cell 0 5");
		
		rdbtnLinearProbing = new QRadioButton("Linear Probing");
		contentPane.add(rdbtnLinearProbing, "cell 1 6");
		
		rdbtnQuadraticProbing = new QRadioButton("Quadratic Probing");
		contentPane.add(rdbtnQuadraticProbing, "cell 1 7");
		
		rdbtnLinearQuotientProbing = new QRadioButton("Linear Quotient Probing");
		contentPane.add(rdbtnLinearQuotientProbing, "cell 1 8");
		
		QLabel lblTableSize = new QLabel("Table Size:");
		contentPane.add(lblTableSize, "cell 0 9");
		
		tfTableSize = new QTextField();
		contentPane.add(tfTableSize, "cell 1 9");
		tfTableSize.setColumns(10);
		
		btnBuildHashTable = new QButton("Build Hash Table");
		contentPane.add(btnBuildHashTable, "cell 0 10");
		
		QLabel lblChoose = new QLabel("Choose:");
		contentPane.add(lblChoose, "cell 0 11");
		
		rdbtnMissingKeys = new QRadioButton("Missing Keys Table");
		contentPane.add(rdbtnMissingKeys, "cell 1 12");
		
		rdbtnPresentKeys = new QRadioButton("Present Keys Tabel");
		contentPane.add(rdbtnPresentKeys, "cell 1 13");
		
		btnSearch = new QButton("Search");
		contentPane.add(btnSearch, "cell 0 14");
		
		QLabel lblNumberOfComparisons = new QLabel("Number of comparisons:");
		contentPane.add(lblNumberOfComparisons, "cell 0 15");
		
		lblComparisons = new QLabel("###");
		contentPane.add(lblComparisons, "cell 1 15");
		
		QLabel lblAverageOfComparisons = new QLabel("Average of comparisons:");
		contentPane.add(lblAverageOfComparisons, "cell 0 16");
		
		lblAverage = new QLabel("###");
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
	
	public QButton getSelectRandomBtn() {
		return btnSelectRandom;
	}
	
	public QButton getSelectMissingBtn() {
		return btnSelectMissing;
	}

	public QButton getSelectPresentBtn() {
		return btnSelectPresent;
	}
	
	public QButton getSearchBtn() {
		return btnSearch;
	}

	public QButton getBuildHashTableBtn() {
		return btnBuildHashTable;
	}
}

package metricas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.io.File;
import java.io.FileFilter;
import java.text.Format;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileSystemView;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.Color;
import javax.swing.JTextField;

public class FormMetricas extends JFrame {
	private JPanel contentPane;
	private DefaultListModel<File> modelList;
	private JSplitPane splitPane1;
	private TableModelMetodo modelTable;
	private JSplitPane splitPane2;
	private JSplitPane splitPaneMetricas;
	private JScrollPane scrlMetodos;
	private JTable tblMetricas;
	private JScrollPane scrlCodigo;
	private JTextArea txtCodigo;
	private JPanel panel;
	private JScrollPane scrlArchivos;
	private JList<File> lstArchivos;
	private JLabel lblNewLabel;
	private JPanel scrlMetricas;
	private JLabel lineasReales;
	private JTextField lineasRealesTextField;
	private JLabel lineasCodigo;
	private JTextField lineasCodigoTextField;
	private JLabel lineasBlancas;
	private JTextField lineasBlancasTextField;
	private JLabel lineasComentarios;
	private JTextField lineasComentariosTextField;
	private JLabel porcentajeComentarios;
	private JTextField porcentajeComentariosTextField;
	private JLabel fanIn;
	private JTextField fanInTextField;
	private JLabel fanOut;
	private JTextField fanOutTextField;
	private JLabel complejidadCiclomatica;
	private JTextField complejidadCiclomaticaTextField;
	private JLabel halsteadLargo;
	private JTextField halsteadLargoTextField;
	private JLabel halsteadVolumen;
	private JTextField halsteadVolumenTextField;
	private JLabel operandos;
	private JTextField operandosTextField;
	private JLabel operadores;
	private JTextField operadoresTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.getDefaults().put("SplitPane.border", BorderFactory.createEmptyBorder());
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FormMetricas frame = new FormMetricas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormMetricas() {
		setResizable(false);
		setForeground(Color.ORANGE);
		setBackground(Color.ORANGE);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormMetricas.class.getResource("/images/iconoG9.png")));
		setTitle("Herramienta de Testing - GRUPO 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		splitPane1 = new JSplitPane();
		splitPane1.setResizeWeight(0.35);
		contentPane.add(splitPane1);

		splitPane2 = new JSplitPane();
		splitPane2.setResizeWeight(0.65);
		splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane1.setRightComponent(splitPane2);

		
		splitPaneMetricas = new JSplitPane();
		splitPaneMetricas.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		scrlMetodos = new JScrollPane();
		scrlMetodos.setToolTipText("Muestra todos los metodos del archivo .Java");
		scrlMetodos.setPreferredSize(new Dimension(150, 150));
		splitPane2.setLeftComponent(splitPaneMetricas);
		splitPaneMetricas.setLeftComponent(scrlMetodos);
		
		
		scrlMetricas = new JPanel();
		GridLayout gridLayout = new GridLayout(0,2);
		scrlMetricas.setLayout(gridLayout);
		scrlMetricas.setToolTipText("Muestra las metricas del metodo seleccionado");
		scrlMetricas.setPreferredSize(new Dimension(0, 0));
		splitPaneMetricas.setRightComponent(scrlMetricas);
		
		lineasReales = new JLabel("Lineas reales");
		lineasReales.setVerticalAlignment(SwingConstants.TOP);
		lineasReales.setHorizontalAlignment(SwingConstants.LEFT);
		scrlMetricas.add(lineasReales);
		
		lineasRealesTextField = new JTextField();
		lineasRealesTextField.setEditable(false);
		lineasRealesTextField.setHorizontalAlignment(SwingConstants.LEFT);
		scrlMetricas.add(lineasRealesTextField);
		lineasRealesTextField.setColumns(10);
		
		lineasCodigo = new JLabel("Lineas de codigo");
		scrlMetricas.add(lineasCodigo);
		
		lineasCodigoTextField = new JTextField();
		lineasCodigoTextField.setEditable(false);
		scrlMetricas.add(lineasCodigoTextField);
		lineasCodigoTextField.setColumns(10);
		
		lineasBlancas = new JLabel("Lineas blancas");
		scrlMetricas.add(lineasBlancas);
		
		lineasBlancasTextField = new JTextField();
		lineasBlancasTextField.setEditable(false);
		scrlMetricas.add(lineasBlancasTextField);
		lineasBlancasTextField.setColumns(10);
		
		lineasComentarios = new JLabel("Lineas de comentarios");
		scrlMetricas.add(lineasComentarios);
		
		lineasComentariosTextField = new JTextField();
		lineasComentariosTextField.setEditable(false);
		scrlMetricas.add(lineasComentariosTextField);
		lineasComentariosTextField.setColumns(10);
		
		porcentajeComentarios = new JLabel("Porcentaje comentarios");
		scrlMetricas.add(porcentajeComentarios);
		
		porcentajeComentariosTextField = new JTextField();
		porcentajeComentariosTextField.setEditable(false);
		scrlMetricas.add(porcentajeComentariosTextField);
		porcentajeComentariosTextField.setColumns(10);
		
		fanIn = new JLabel("Fan In");
		scrlMetricas.add(fanIn);
		
		fanInTextField = new JTextField();
		fanInTextField.setEditable(false);
		scrlMetricas.add(fanInTextField);
		fanInTextField.setColumns(10);
		
		fanOut = new JLabel("Fan Out");
		scrlMetricas.add(fanOut);
		
		fanOutTextField = new JTextField();
		fanOutTextField.setEditable(false);
		scrlMetricas.add(fanOutTextField);
		fanOutTextField.setColumns(10);
		
		complejidadCiclomatica = new JLabel("Complejidad Ciclomatica");
		scrlMetricas.add(complejidadCiclomatica);
		
		complejidadCiclomaticaTextField = new JTextField();
		complejidadCiclomaticaTextField.setEditable(false);
		scrlMetricas.add(complejidadCiclomaticaTextField);
		complejidadCiclomaticaTextField.setColumns(10);
		
		halsteadLargo = new JLabel("Halstead largo");
		scrlMetricas.add(halsteadLargo);
		
		halsteadLargoTextField = new JTextField();
		halsteadLargoTextField.setEditable(false);
		scrlMetricas.add(halsteadLargoTextField);
		halsteadLargoTextField.setColumns(10);
		
		halsteadVolumen = new JLabel("Halstead volumen");
		scrlMetricas.add(halsteadVolumen);
		
		halsteadVolumenTextField = new JTextField();
		halsteadVolumenTextField.setEditable(false);
		scrlMetricas.add(halsteadVolumenTextField);
		halsteadVolumenTextField.setColumns(10);
		
		operandos = new JLabel("Operandos");
		scrlMetricas.add(operandos);
		
		operandosTextField = new JTextField();
		operandosTextField.setEditable(false);
		scrlMetricas.add(operandosTextField);
		operandosTextField.setColumns(10);
		
		operadores = new JLabel("Operadores");
		scrlMetricas.add(operadores);
		
		operadoresTextField = new JTextField();
		operadoresTextField.setEditable(false);
		scrlMetricas.add(operadoresTextField);
		operadoresTextField.setColumns(10);
				

		modelTable = new TableModelMetodo(null);
		tblMetricas = new JTable(modelTable);
		tblMetricas.setFont(new Font("Courier New", Font.PLAIN, 12));
		tblMetricas.setGridColor(SystemColor.control);
		tblMetricas.setRowHeight(25);
		tblMetricas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iniciarTabla();
		
		tblMetricas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mostrarCodigo();
			}
		});

		scrlMetodos.setViewportView(tblMetricas);

		scrlCodigo = new JScrollPane();
		scrlCodigo.setPreferredSize(new Dimension(0, 0));
		splitPane2.setRightComponent(scrlCodigo);

		txtCodigo = new JTextArea();
		txtCodigo.setFont(new Font("Courier New", Font.PLAIN, 12));
		txtCodigo.setTabSize(2);
		txtCodigo.setEditable(false);
		txtCodigo.setLineWrap(true);
		scrlCodigo.setViewportView(txtCodigo);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 0));
		splitPane1.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 5));
		
				JButton btnSeleccionarCarpeta = new JButton("Seleccionar carpeta...");
				btnSeleccionarCarpeta.setBackground(Color.LIGHT_GRAY);
				btnSeleccionarCarpeta.setIcon(new ImageIcon(FormMetricas.class.getResource("/images/folder.png")));
				btnSeleccionarCarpeta.setPreferredSize(new Dimension(0, 30));
				panel.add(btnSeleccionarCarpeta, BorderLayout.NORTH);
				
						btnSeleccionarCarpeta.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								buscarCarpeta();
							}
						});

		scrlArchivos = new JScrollPane();
		scrlArchivos.setPreferredSize(new Dimension(0, 0));
		panel.add(scrlArchivos);

		modelList = new DefaultListModel<File>();
		lstArchivos = new JList<File>(modelList);
		lstArchivos.setToolTipText("Presione ");
		lstArchivos.setCellRenderer(new FileRenderer(true));
		
		lstArchivos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				File file = lstArchivos.getSelectedValue();
				
				if (file != null) {
					cargarMetodos(file.toString());
				}
			}
		});
		
		scrlArchivos.setViewportView(lstArchivos);
		
		lblNewLabel = new JLabel("Archivos");
		scrlArchivos.setColumnHeaderView(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void iniciarTabla() {
		TableColumnModel tcm = tblMetricas.getColumnModel();
		TableColumn tc;

		tc = tcm.getColumn(0);	
		tc.setPreferredWidth(90);
	}

	private void buscarCarpeta() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			modelList.clear();
			txtCodigo.setText("");
			
			cargarArchivos(fileChooser.getSelectedFile());
		}
	}
	
	private void cargarArchivos(File directory) {
		for (File file : directory.listFiles(new JavaFilter())) {
			/*
			if(file.isDirectory()) {
				cargarArchivos(file);
			} else {
				modelList.addElement(file);
			}
			*/
			if(!file.isDirectory()) {
				modelList.addElement(file);
			}
		}
	}
	
	public class JavaFilter implements FileFilter {
		public boolean accept(File file) {
			if(file.isDirectory()) {
				return true;
			}
			
			if (file.getName().toLowerCase().endsWith(".java")) {
				return true;
			}

			return false;
		}
	}

	class FileRenderer extends DefaultListCellRenderer {

	    private boolean pad;
	    private Border padBorder = new EmptyBorder(3,3,3,3);

	    FileRenderer(boolean pad) {
	        this.pad = pad;
	    }

	    @Override
	    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

	        Component c = super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
	        JLabel l = (JLabel)c;
	        File f = (File)value;
	        l.setText(f.getName());
	        l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
	        
	        if (pad) {
	            l.setBorder(padBorder);
	        }

	        return l;
	    }
	}
	
	private void cargarMetodos(String archivo) {
		List<Metodo> metodos = Parser.getMetodos(archivo);
		
		for(Metodo m: metodos) {
			m.calcular(metodos);
		}
		
		modelTable = new TableModelMetodo(metodos);
		tblMetricas.setModel(modelTable);
		txtCodigo.setText("");
		iniciarTabla();
	}

	private void mostrarCodigo() {
		int row = tblMetricas.getSelectedRow();
		
		if (row != -1) {
			Metodo m = (Metodo) tblMetricas.getValueAt(row, 0);
			txtCodigo.setText(m.getCodigo());
			txtCodigo.setCaretPosition(0);
			lineasRealesTextField.setText(""+m.getLineasReales());
			lineasCodigoTextField.setText(""+m.getLineasCodigo());
			lineasComentariosTextField.setText(""+m.getLineasComentario());
			lineasBlancasTextField.setText(""+m.getLineasBlancas());
			porcentajeComentariosTextField.setText(""+m.getPorcentajeComentarios());
			fanInTextField.setText(""+m.getFanIn());
			fanOutTextField.setText(""+m.getFanOut());
			complejidadCiclomaticaTextField.setText(""+m.getComplejidadCiclomatica());
			halsteadLargoTextField.setText(""+m.getHalsteadLargo());
			halsteadVolumenTextField.setText(""+m.getHalsteadVolumen());
			operadoresTextField.setText(""+m.getOperadores());
			operandosTextField.setText(""+m.getOperandos());
			operandosTextField.setToolTipText(""+m.getOperandos());
			
		}
	}
	
	public class NumberCellRenderer extends DefaultTableCellRenderer {
		Format nf = NumberFormat.getNumberInstance();
		
	    public NumberCellRenderer() {
	    	super();
	    	setHorizontalAlignment(JLabel.RIGHT);
	    }
	    
		public void setValue(Object value)
		{
			try
			{
				if (value != null)
					value = nf.format(value);
			}
			catch(IllegalArgumentException e) {}

			super.setValue(value);
		}
	}
	
	public class PercentCellRenderer extends DefaultTableCellRenderer {
		Format nf = NumberFormat.getPercentInstance();
		
	    public PercentCellRenderer() {
	    	super();
	    	setHorizontalAlignment(JLabel.RIGHT);
	    }
	    
		public void setValue(Object value)
		{
			try
			{
				if (value != null)
					value = nf.format(value);
			}
			catch(IllegalArgumentException e) {}

			super.setValue(value);
		}
	}
}

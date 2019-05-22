package metricas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelMetodo extends AbstractTableModel {
	private List<Metodo> data = null;
	
	protected TableModelMetodo() {
		super();
	}
	
	protected TableModelMetodo(List<Metodo> data) {
		super();
		this.data = data;
	}

	@Override
	public int getRowCount() {
		if (data != null)
			return data.size();
		
		return 0;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Método";
		case 1:
			return "LR";
		case 2:
			return "LC";
		case 3:
			return "LBlancas";
		case 4:
			return "Coment.";
		case 5: 
			return "%Coment.";
		case 6:
			return "Fan In";
		case 7:
			return "Fan Out";
		case 8:
			return "CC";
		case 9:
			return "Long";
		case 10:
			return "Vol";
		case 11:
			return "Esfuerzo";	
		case 12:
			return "Operandos";
		case 13:
			return "Operadores";
		}

		return "???";
	}

	@Override
	public int getColumnCount() {
		return 14;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Metodo m = data.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return m;
		case 1:
			return m.getLineasReales();
		case 2:
			return m.getLineasCodigo();
		case 3:
			return m.getLineasBlancas();
		case 4:
			return m.getLineasComentario();
		case 5:
			return m.getPorcentajeComentarios();
		case 6:
			return m.getFanIn();
		case 7:
			return m.getFanOut();
		case 8:
			return m.getComplejidadCiclomatica();
		case 9:
			return m.getHalsteadLargo();
		case 10:
			return m.getHalsteadVolumen();
		case 11:
			return m.getHalsteadEsfuerzo();
		case 12:
			return m.getOperandos();
		case 13:
			return m.getOperadores();
		}

		return null;
	}
}

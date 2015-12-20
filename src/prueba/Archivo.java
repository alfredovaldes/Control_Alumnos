package prueba;

import java.io.File;

import javax.swing.JFileChooser;

public class Archivo {
	
	public File getArchivo(File archivo){
	JFileChooser Seleccionador = new JFileChooser();
	Seleccionador.showOpenDialog(null);
	return archivo =Seleccionador.getSelectedFile();
	}
}

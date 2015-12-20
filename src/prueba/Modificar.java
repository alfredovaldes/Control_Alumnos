package prueba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Modificar {

	public void modificarAlumno(File archivo) throws IOException, InterruptedException{
		String busqueda = JOptionPane.showInputDialog("Ingrese matricula");
		File archivotemporal = new File("archivo.temp");
		if(busqueda.length()==8){
			FileReader reader = new FileReader(archivo);
			BufferedReader br = new BufferedReader(reader);
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(archivotemporal)));
			String linea = null;
			while ((linea = br.readLine()) != null)
			{
				if (busqueda.equals(linea)) {
					if (JOptionPane.showConfirmDialog(null, "Modificar Calificaciones?", "",
					    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					    int Fisica,Quimica,Matematicas,Programacion;
					    Fisica = Integer.parseInt(JOptionPane.showInputDialog("Calificacion de Fisica?"));
					    Quimica = Integer.parseInt(JOptionPane.showInputDialog("Calificacion de Quimica?"));
					    Matematicas = Integer.parseInt(JOptionPane.showInputDialog("Calificacion de Matematicas?"));
					    Programacion = Integer.parseInt(JOptionPane.showInputDialog("Calificacion de Programacion?"));
					    double Promedio = (Fisica+Quimica+Matematicas+Programacion)/4;
						writer.println(linea);
					    String nombre=br.readLine();
					    writer.println(nombre);
					    br.readLine();
						writer.println(Fisica);
						br.readLine();
						writer.println(Quimica);
						br.readLine();
						writer.println(Matematicas);
						br.readLine();
						writer.println(Programacion);
						br.readLine();
						writer.println(Promedio);
						br.readLine();
					    
					} else {
						//writer.println(linea);
					}
				}
				else{
					writer.println(linea);
				}
			}
			writer.close();
			br.close();
			reader.close();
			copiarArchivo(archivotemporal, archivo);
		}
		else{
			JOptionPane.showMessageDialog(null,"Inserta una matricula correcta","Matricula Incorrecta",JOptionPane.ERROR_MESSAGE);
		}
	}
	private static void copiarArchivo(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
}
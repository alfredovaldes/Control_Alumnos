package prueba;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class Consultar {
	public void getAlumno(File archivo) throws IOException, InterruptedException{
		String Busqueda = JOptionPane.showInputDialog("Ingrese matricula");
		String[] Alumno_Consultado =new String[7];
		Alumno_Consultado = consultaAlumno(Alumno_Consultado,Busqueda, archivo);
		String [] Informacion_Preparada = {"Matricula: "+Alumno_Consultado[0], 
				"Nombre: "+Alumno_Consultado[1],
				"Fisica: "+Alumno_Consultado[2],
				"Quimica: "+Alumno_Consultado[3],
				"Matematicas: "+Alumno_Consultado[4],
				"Programacion: "+Alumno_Consultado[5],
				"Promedio: "+Alumno_Consultado[6]};
		JOptionPane.showMessageDialog(null, new JList<Object>(Informacion_Preparada));
	}
	public String[] consultaAlumno(final String[] Alumno_Consultado, String busqueda, File archivo) throws IOException, InterruptedException{
		if(busqueda.length()==8){
			Scanner scanner = new Scanner(archivo);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				if(linea.contains(busqueda)) { 
					Alumno_Consultado[0]=linea;
					for(int i=1;i<7;i++){
						Alumno_Consultado[i]=scanner.nextLine();
					}
				}
			}
			scanner.close();
		}
		else{
			JOptionPane.showMessageDialog(null,"Inserta una matricula correcta","Matricula Incorrecta",JOptionPane.ERROR_MESSAGE);
			for(int i=0;i<7;i++){
				Alumno_Consultado[i]="INFORMACION INVALIDA";
			}
		}
		return Alumno_Consultado;
	}
}
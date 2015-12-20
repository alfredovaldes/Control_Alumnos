package prueba;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
public class Registrar {
	public void SetAlumno (File archivo) throws IOException {
		String[] Alumno = new String[7];
		int Fisica=0,Quimica=0,Matematicas=0, Programacion=0;
		String Nombre =null, Matricula =null;
		double Promedio=0.0;
		boolean FormatoDeMatricula=false;
		Matricula=SetMatricula(Matricula);
		FormatoDeMatricula=GetFormatoDeMatricula(Matricula);
		if(FormatoDeMatricula==true){
			Nombre=SetNombre(Nombre);
			Fisica=SetFisica(Fisica);
			Quimica=SetQuimica(Quimica);
			Matematicas=SetMatematicas(Matematicas);
			Programacion=SetProgramacion(Programacion);
			Promedio=SetPromedio(Fisica,Quimica,Matematicas,Programacion,Promedio);
			Alumno=ConstruirArreglo(Alumno,Matricula,Nombre,Fisica,Quimica,Matematicas,Programacion,Promedio);
		}
		else{
			JOptionPane.showMessageDialog(null,"Inserta una matricula correcta","Matricula Incorrecta",JOptionPane.ERROR_MESSAGE);
		}
		agregarObjeto(archivo, Alumno);
	}
	public boolean GetFormatoDeMatricula(String Matricula){
		boolean FormatoDeMatricula;
		if(Matricula.length()==8){
			FormatoDeMatricula=true;
		}
		else{
			FormatoDeMatricula=false;
		}
	return FormatoDeMatricula;
	}
	public String SetMatricula(String Matricula){
		Matricula = JOptionPane.showInputDialog("Ingrese matricula");
		return Matricula;
	}
	public String SetNombre(String Nombre){
		return Nombre = JOptionPane.showInputDialog("Ingrese nombre del alumno");
	}
	public int SetFisica(int Fisica){
		return Fisica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese calificacion de fisica"));
	}
	public int SetQuimica(int Quimica){
		return Quimica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese calificacion de quimica"));
	}
	public int SetMatematicas(int Matematicas){
		return Matematicas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese calificacion de matematicas"));
	}
	public int SetProgramacion(int Programacion){
		return Programacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese calificacion de programacion"));
	}
	public double SetPromedio(int Fisica, int Quimica, int Matematicas,int Programacion,double Promedio){
		return Promedio = ((Fisica+Quimica+Matematicas+Programacion)/4);
	}
	public String[] ConstruirArreglo(String[] Alumno, String Matricula,String Nombre,int Fisica,int Quimica,int Matematicas,int Programacion,double Promedio){
		return Alumno = new String[] {Matricula, Nombre, String.valueOf(Fisica),String.valueOf(Quimica),String.valueOf(Matematicas),String.valueOf(Programacion),String.valueOf(Promedio)};
	}

	public void agregarObjeto(File archivo, String[] Alumno) throws IOException
	{
		FileWriter F = new FileWriter(archivo,true);
		PrintWriter escritor = new PrintWriter(F);	
		for(int i=0;i<7;i++){
			escritor.println(Alumno[i]);
		}
		escritor.close();
	}
}

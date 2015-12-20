package prueba;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
@SuppressWarnings("serial")
public class botones extends JFrame implements ActionListener {
	JButton botonRegistrar,botonConsultar,botonSalir,botonBase,botonEliminar,botonModificar;
	JLabel texto;
	File archivo;
	public botones() {
		setLayout(null);
		texto=new JLabel("Seleccione la accion a realizar.");
		texto.setBounds(55,1,220,40);
		add(texto);
		botonBase=new JButton("Seleccionar Base de Datos");
		botonBase.setBounds(50,50,190,30);
		botonBase.addActionListener(this);
		add(botonBase);
		botonRegistrar=new JButton("Registrar Alumno");
		botonRegistrar.setBounds(50,80,190,30);
		botonRegistrar.addActionListener(this);
		add(botonRegistrar);
		botonConsultar=new JButton("Consultar");
		botonConsultar.setBounds(50,110,190,30);
		botonConsultar.addActionListener(this);
		add(botonConsultar);
		botonModificar=new JButton("Modificar Registro");
		botonModificar.setBounds(50,140,190,30);
		botonModificar.addActionListener(this);
		add(botonModificar);
		botonEliminar=new JButton("Eliminar Registro");
		botonEliminar.setBounds(50,170,190,30);
		botonEliminar.addActionListener(this);
		add(botonEliminar);
		botonSalir=new JButton("Salir");
		botonSalir.setBounds(50,200,190,30);
		botonSalir.addActionListener(this);
		add(botonSalir);
		setTitle("Control de Alumnos");

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonSalir) {
			try{
				System.exit(0);
			} catch(Exception excep) {
				System.exit(0);
			}
		}
		else{
			if (e.getSource()==botonConsultar) {
				setTitle("Modo de consulta");
				try{
					Consultar c = new Consultar();
					c.getAlumno(archivo);
					setTitle("Control de Alumnos");
				} catch(Exception excep) {
					System.exit(0);
				}
			}
			else{
				if (e.getSource()==botonRegistrar) {
					setTitle("Modo de Registro");
					try{
						Registrar r = new Registrar();
						r.SetAlumno(archivo);
						setTitle("Control de Alumnos");
					} catch(Exception excep) {
						System.exit(0);
					}
				}
				else{
					if (e.getSource()==botonBase) {
						setTitle("Modo de Seleccion");
						try{
							Archivo a = new Archivo();
							archivo=a.getArchivo(archivo);
							setTitle("Control de Alumnos");
						} catch(Exception excep) {
							System.exit(0);
						}
					}
					else{
						if(e.getSource()==botonEliminar) {
							setTitle("Eliminacion de Registros");
							try{
								Eliminar el = new Eliminar();
								el.eliminarAlumno(archivo);
								setTitle("Control de Alumnos");
							} catch(Exception excep) {
								System.exit(0);
							}
						}
							else{
								if(e.getSource()==botonModificar) {
									setTitle("Modificacion de Registros");
									try{
										Modificar m = new Modificar();
										m.modificarAlumno(archivo);
										setTitle("Control de Alumnos");
									} catch(Exception excep) {
										System.exit(0);
									}

								}
						}
					}
				}
			}
		}
	}
}

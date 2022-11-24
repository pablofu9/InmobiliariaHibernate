package pablo.ExamenPabloFuertesHibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



import pablo.ExamenPabloFuertesHibernate.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = HibernateUtil.getSession();
		
		Scanner entrada = new Scanner(System.in);
		int num;
		System.out.println("1-Insertar un piso");
		System.out.println("2-Reservar un piso");
		System.out.println("3-Eliminar un piso");

		num = entrada.nextInt();

		
		switch (num) {
		
		case 1:
			//METODO INSERTAR
			System.out.println("Vamos a insertar un piso...");
			
			System.out.println("Dime en que zona esta ");
			int id_zona = entrada.nextInt();
			
			System.out.println("Alquiler o comprar ");
			String tipo_operacion = entrada.next();
			
			System.out.println("Nombre del propietario ");
			String nombre_propietario = entrada.next();
			
			System.out.println("Metros cuadrados");
			int metros = entrada.nextInt();
			
			System.out.println("Telefono de contacto");
			String telefono_contacto = entrada.next();
			
			System.out.println("Precio");
			int precio = entrada.nextInt();
			
			System.out.println("Esta reservado");
			int reservado = entrada.nextInt();
			
			boolean reserved;
			if(reservado == 0 ) {
				reserved = false;
			}else {
				reserved = true;
			}
			//CREAMOS UN OBJETO ZONA CON EL ID QUE SELECCIONE EL USUARIO
			Zona zona = session.get(Zona.class,id_zona);
			Piso piso = new Piso(1,zona,tipo_operacion,nombre_propietario,metros,telefono_contacto,precio,reserved);
			session.beginTransaction();
			session.save(piso);
			
			session.getTransaction().commit();
			break;
		case 2:
			//RESERVAR PISO
			System.out.println("Introduce el id del piso que quieres reservar...");
			int idPiso = entrada.nextInt();
			
			Piso pisoReservar = (Piso) session.createQuery("FROM Piso WHERE Id_piso ="+idPiso).uniqueResult();
			
			
			if(pisoReservar==null) {
				System.out.println("El piso seleccionado no existe");
			}else {
				if(pisoReservar.isReservado()) {
					System.out.println("El piso seleccionado ya esta reservado");
				}else {
					System.out.println("Reservando el piso...");
					session.beginTransaction();
					pisoReservar.setReservado(true); //Reservamos el piso
					session.update(pisoReservar);
					session.getTransaction().commit();
					System.out.println("Piso "+idPiso+" reservado ");
				}
			}
			break;
		case 3:
			System.out.println("Introduce el id del piso que quieres eliminar...");
			int idPisoBorrar = entrada.nextInt();
			
			Piso pisoBorrar = (Piso) session.createQuery("FROM Piso WHERE Id_piso ="+idPisoBorrar).uniqueResult();
			
			if(pisoBorrar == null) {
				System.out.println("El piso no existe");
			}else {
				System.out.println("Borrando el piso...");
				session.beginTransaction();
				session.delete(pisoBorrar);
				System.out.println("Piso "+idPisoBorrar+" eliminado");
				
			}
			
			//Borrar un piso
			break;
		}

	}
}

package pablo.ExamenPabloFuertesHibernate;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;


@Entity
@Table(name="pisos")
public class Piso implements Serializable {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="Id_piso")
	private int id_piso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Zona",referencedColumnName="Id_zona")
	private Zona zona;
	
	@Column(name="Tipo_Operacion")
	private String tipo_operacion;
	
	@Column(name="Nombre_propietario")
	private String nombre_propietario;
	
	@Column(name="Metros")
	private int metros;
	
	@Column(name="Telefono_contacto")
	private String telefono_contacto;
	
	@Column(name="Precio")
	private int precio;
	
	@Column(name="Reservado")
	private boolean reservado;

	public Piso() {
		super();
	}

	public Piso(int id_piso, Zona zona, String tipo_operacion, String nombre_propietario, int metros,
			String telefono_contacto, int precio, boolean reservado) {
		super();
		this.id_piso = id_piso;
		this.zona = zona;
		this.tipo_operacion = tipo_operacion;
		this.nombre_propietario = nombre_propietario;
		this.metros = metros;
		this.telefono_contacto = telefono_contacto;
		this.precio = precio;
		this.reservado = reservado;
	}

	public int getId_piso() {
		return id_piso;
	}

	public void setId_piso(int id_piso) {
		this.id_piso = id_piso;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getTipo_operacion() {
		return tipo_operacion;
	}

	public void setTipo_operacion(String tipo_operacion) {
		this.tipo_operacion = tipo_operacion;
	}

	public String getNombre_propietario() {
		return nombre_propietario;
	}

	public void setNombre_propietario(String nombre_propietario) {
		this.nombre_propietario = nombre_propietario;
	}

	public int getMetros() {
		return metros;
	}

	public void setMetros(int metros) {
		this.metros = metros;
	}

	public String getTelefono_contacto() {
		return telefono_contacto;
	}

	public void setTelefono_contacto(String telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}
	
	
}

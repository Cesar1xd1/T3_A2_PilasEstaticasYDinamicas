import java.util.Scanner;
import java.util.Stack;

interface RentaPeliculas{
	public default void  rentarPelicula() {
		//Es como quitar
	}
	public default void  devolverPelicula() {
		//Es como añadir 
	}
	public default void cargarBD() {
		
	}
}


class Pelicula{
	String titulo;
	String genero;
	
	

	public Pelicula(String titulo, String genero) {
		super();
		this.titulo = titulo;
		this.genero = genero;
	}



	@Override
	public String toString() {
		return "\n titulo=" + titulo + ", genero=" + genero + "";
	}

	
	
	
}
class ImplementacionPilaEstatica implements RentaPeliculas{
	int pila[];
	int cima;
	
	
	public ImplementacionPilaEstatica(int n) {
		pila = new int[n];
		cima = -1;
	}
	
	public void devolverPelicula(int pelicula) {
		
	}
	
	
	
	
	
}
class ImplementacionPilaDinamica implements RentaPeliculas{
	Stack<Pelicula> pelis = new Stack<Pelicula>();
	Scanner entrada = new Scanner (System.in);
	
	
	
public String toString() {
		return "ImplementacionPilaDinamica [pelis=" + pelis + ", entrada=" + entrada + "]";
	}
	public void devolverPelicula() {
		System.out.println("Ingresa el nombre de la pelicula a añadir");
		String t = entrada.nextLine();
		System.out.println("Ingresa el genero de la pelicula");
		String g = entrada.nextLine();
		Pelicula p = new Pelicula(t, g);
		pelis.push(p);
	}
	public void rentarPelicula() {
		if(0==pelis.size()) {
			System.out.println("No hay peliculas para rentar...");
			System.out.println("LLene primero el catalogo");
			cargarBD();
		}else {
			if(!pelis.empty()) {
				pelis.pop();
				System.out.println("Se rento la pelicula de la pila");
			}else {
				System.out.println("No hay peliculas para rentar");
			}
		}
		
		
	}
	
	public void cargarBD() {
		
				for (int i = 0; i < 5; i++) {
			devolverPelicula();
		}
		
	}
	public void mostrarCatalogo() {
		System.out.println("==== Peliculas disponibles =====");
		System.out.println(pelis.toString());
	}
	
	
}


public class PruebaPilas {

	public static void main(String[] args) {
		ImplementacionPilaDinamica ipd = new ImplementacionPilaDinamica();
		
		
	}

}

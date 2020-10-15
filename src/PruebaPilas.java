import java.awt.Menu;
import java.util.Scanner;
import java.util.Stack;
interface correccion{
	Scanner entrada = new Scanner(System.in);
	public static int validacion() {
		int r = 0;
		boolean e = false;
		
		do {
			try {
				
				
				r = entrada.nextInt();
				
				
			} catch (java.util.InputMismatchException x) {
				System.out.println("Ups! el dato que intentas ingresar no es valido");
				entrada.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Ingresa porfavor solo numeros mayores a 0");
				e=true;
			}
		}while(e);
		return r;
	}
}




interface RentaPeliculas extends correccion  {
	public default void  rentarPelicula() {
		//Es como quitar
	}
	public default void  devolverPelicula() {
		//Es como añadir 
	}
	public default void cargarBD() {
		
	}
	public default int menu() {
		System.out.println("====MENU de renta de peliculas====");
		System.out.println("Digite 1, para gargar el catalogo de peliculas ");
		System.out.println("Digite 2 para devolver/añadir una pelicula");
		System.out.println("Digite 3 para rentar/eliminar una pelicual de la cima");
		System.out.println("Digite 4 para mostrar la Base de Datos de las peliculas");
		System.out.println("Digite 5 para ***SALIR***");
		int e = correccion.validacion();
		return e;
	}
	public default void mostrarCatalogo() {
		
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
	Pelicula pila[];
	int cima;
	Pelicula peliVacia = new Pelicula("N/E", "N/E");
	
	//Creacion 0
	public ImplementacionPilaEstatica(int n) {
		pila = new Pelicula[n];
		cima = -1;
	}
	//3) Verificar Si vacia
		public boolean verificarPilaLlena() {
			return(cima == pila.length-1); 
				
		}
		//4) Verificar si pila Llena
		public boolean verificarPilaVacia() {
			return (cima == -1);
		}
	
	//1
	public void devolverPelicula(Pelicula p) {
		if(verificarPilaLlena()==true) {
			System.out.println("La pila ya esta llena, no puede añadir otra pelicual");
		}else {
			cima = cima +1;
			pila[cima]= p;
		
		}
		
	}
	
	public void rentarPelicula() {
		if(verificarPilaVacia()==true) {
			System.out.println("La Pila esta vacia!");
			System.out.println("Cargue peliculas primero!");
			//metodo de carga de peliculas
		}else {
			System.out.println(cima);
			pila[cima]=peliVacia;
		}
	}
	
	public void mostrarCatalogo() {
		if(verificarPilaVacia()){
			for (int i = 0; i < pila.length; i++) {
				pila[i]=peliVacia;
			}
		}
		System.out.println("==== Las peliculas del catalogo ===");
		for (int i = 0; i < pila.length; i++) {
			System.out.println(pila[i]);
		}
	}
	public void cargarBD() {
		for (int i = 0; i < pila.length; i++) {
			System.out.println("Ingresa el nombre de la pelicula:");
			String t = entrada.nextLine();
			t = entrada.nextLine();
			System.out.println("Ingresa el genero de la pelicula:");
			String g = entrada.next();
			Pelicula n = new Pelicula(t, g);
			pila[i]= n;
		}
	}
	
	
	
}
class ImplementacionPilaDinamica implements RentaPeliculas , correccion{
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
		Scanner entrada = new Scanner(System.in);
		int x ;
		int op;
		
		do {
			
		
		System.out.println("=== MENU de tipo de pilas ===");		
		System.out.println("Digite 1 para usar Pila ESTATICA");
		System.out.println("Digite 2 para usar Pila DINAMICA");
		x = correccion.validacion();
		switch (x) {
		case 1:
			System.out.println("Ingrese el tamaño de la pila");
			int b = correccion.validacion();
			ImplementacionPilaEstatica ipe = new ImplementacionPilaEstatica(b);
			do {
				op = ipe.menu();
				switch (op) {
				case 1:ipe.cargarBD();break;
				case 2:
					System.out.println("Ingrese el titulo de la pelicula a devolver/añadir");
					String t = entrada.nextLine();
					String g = entrada.nextLine();
					Pelicula p = new Pelicula(t, g);
					ipe.devolverPelicula(p);break;
				case 3: ipe.rentarPelicula();break;
				case 4: ipe.mostrarCatalogo();break;
				case 5:System.out.println("Ha salido del menu de la pila Estatica"); break;
				
				}
			}while(op!=5);
			
		case 2:
			ImplementacionPilaDinamica ipd = new ImplementacionPilaDinamica();
			
			do {
				op = ipd.menu();
				switch (op) {
				case 1:ipd.cargarBD();break;
				case 2: ipd.devolverPelicula();break;
				case 3: ipd.rentarPelicula();break;
				case 4: ipd.mostrarCatalogo();break;
				case 5:System.out.println("Ha salido del menu de la pila Dinamica"); break;
				
				}
			}while(op!=5);
		
		}
		
		
		}while(x!=3);
		System.out.println("Ah salido del menu General... Gracias por usar el programa!!!");
		
		
		
		
		
		
		//		
		
	}

}

import java.util.Scanner;

class MetodosOrdenamiento {
	
	int aux=0;
	
	public void ordenamientoBurbuja1(int[] numeros) {
		int contRecorrido=0, contComparaciones=0, contIntercambios=0;
		long tiempoFinal=0;
		
		//tiempo inicial
		long tiempoInicio = System.nanoTime();
		
		for(int i=2; i <= numeros.length; i++) {
			for(int j=0; j <= numeros.length-i; j++) {
				
				contComparaciones++;
				if(numeros[j] > numeros[j+1]) {
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
					contIntercambios++;
				}
				contRecorrido++;
			}
		}
		
		mostrarVector(numeros);
		//tiempo final
		tiempoFinal = System.nanoTime() - tiempoInicio;
		
		mostrarDatosEficiencia(contRecorrido, contComparaciones, contIntercambios, tiempoFinal);
		
	}
	
	public void ordenamientoBurbuja2(int[] numeros) {
		int contRecorrido2=0, contComparaciones2=0, contIntercambios2=0;
		long tiempoFinal=0;
		
		int i=1;
		boolean ordenado = false;
		
		long tiempoInicio = System.nanoTime();
		
		while( (i < numeros.length) && (ordenado == false)) {
			i=i+1;
			ordenado=true;
			for(int j=0; j <= numeros.length -i; j++) {
				contComparaciones2++;
				if(numeros[j] > numeros[j+1]) {
					ordenado = false;
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
					contIntercambios2++;
				}
				contRecorrido2++;
			}
		}
		mostrarVector(numeros);
		
		tiempoFinal = System.nanoTime() - tiempoInicio;
	
		mostrarDatosEficiencia(contRecorrido2, contComparaciones2, contIntercambios2, tiempoFinal);
	}
	
	public void ordenamientoBurbuja3(int[] numeros) {
		
		int contRecorrido3=0, contComparaciones3=0, contIntercambios3=0;
		long tiempoFinal=0;
		
		int i=1;
		boolean ordenado;
		
		long tiempoInicial = System.nanoTime();
		
		do {
			i=i+1;
			ordenado = true;
			
			for(int j=0; j <= numeros.length-i; j++) {
				contComparaciones3++;
				if(numeros[j] > numeros[j+1]) {
					contIntercambios3++;
					//ordenado = false;
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
				}
				contRecorrido3++;
			}
		} while( (i < numeros.length) && (ordenado == true) );
		
		mostrarVector(numeros);
		
		tiempoFinal = System.nanoTime() - tiempoInicial;
		
		mostrarDatosEficiencia(contRecorrido3, contComparaciones3, contIntercambios3, tiempoFinal);
		
	}

	public void ordenamientoPorSeleccion(int[] numeros) {
		
		int contRecorrido4=0, contComparaciones4=0, contIntercambios4=0;
		long tiempoFinal=0;
		
		long tiempoInicial = System.nanoTime();
		
		for(int i=0; i<numeros.length; i++) {
			int minimo=i;
			for(int j=i+1; j < numeros.length; j++) {
				contComparaciones4++;
				if(numeros[j] < numeros[minimo]) {
					minimo = j;
				}
				contRecorrido4++;
			}
			int aux = numeros[i];
			numeros[i] = numeros[minimo];
			numeros[minimo] = aux;
			contIntercambios4++;
		}
		
		mostrarVector(numeros);
		tiempoFinal = System.nanoTime() - tiempoInicial;
		
		mostrarDatosEficiencia(contRecorrido4, contComparaciones4, contIntercambios4, tiempoFinal);
		
	}
	
	public void ordenamientoPorInsercion(int[] numeros) {
		
		int contRecorrido5=0, contComparaciones5=0, contIntercambios5=0;
		long tiempoFinal=0;
		int i, j, aux;
		
		long tiempoInicial = System.nanoTime();
		
		for(i=1; i < numeros.length; i++) {
			aux = numeros[i];
			j = i-1;
			while( (j>=0) && (aux < numeros[j]) ) {
				numeros[j+1] = numeros[j];
				j--;
				contRecorrido5++;
			}
			numeros[j+1] = aux;	
			contIntercambios5++;
		}
		
		mostrarVector(numeros);
		tiempoFinal = System.nanoTime() - tiempoInicial;
		
		mostrarDatosEficiencia(contRecorrido5, contComparaciones5, contIntercambios5, tiempoFinal);
		
	}
	
	public void ordenamientoShellSort(int[] numeros) {
		
		int contRecorrido6=0, contComparaciones6=0, contIntercambios6=0;
		long tiempoFinal=0;
		
		int salto, aux, i;
		boolean cambios;
		
		long tiempoInicial = System.nanoTime();
		
		for(salto=numeros.length/2; salto != 0; salto/=2) {
			cambios = true;
			while(cambios) {
				cambios = false;
				for(i = salto; i<numeros.length; i++) {
					contComparaciones6++;
					if(numeros[i-salto] > numeros[i]) {
						aux = numeros[i];
						numeros[i] = numeros[i-salto];
						numeros[i-salto] = aux;
						cambios = true;
						contIntercambios6++;
					}
					contRecorrido6++;
				}
			}
		}
		
		mostrarVector(numeros);
		tiempoFinal = System.nanoTime() - tiempoInicial;
		
		mostrarDatosEficiencia(contRecorrido6, contComparaciones6, contIntercambios6, tiempoFinal);
		
	}
	
	public void mostrarVector(int[] vector) {
		
		long contador = 0;
		for(int i=0; i<vector.length; i++) {
			if(contador == 20) {
				System.out.println("["+vector[i]+"] -- ");
				contador=0;
			} else {
				System.out.print("["+vector[i]+"] -- ");
			}
			contador++;
		}
		
	}
	
	public void mostrarDatosEficiencia(int contRecorrido, int contComparaciones, int contIntercambios, long tiempoFinal) {
		
		System.out.println("\n");
		System.out.println("================ Datos de eficiencia del algoritmo. ================");
		System.out.println();
		System.out.println("RECORRIDOS O PASADAS: "+contRecorrido);
		System.out.println("COMPARACIONES: "+contComparaciones);
		System.out.println("INTERCAMBIOS: "+contIntercambios);
		System.out.println("TIEMPO DE EJECUCION: "+(tiempoFinal/1e6)+" ms");
		
	}
	
	public int[] vector1000() {
		int[] vector = new int[1000];
		int numeroAleatorio = 0;
		for(int i=0; i<vector.length; i++) {
			numeroAleatorio = (int)(Math.random() * 100) + 1;
			vector[i] = numeroAleatorio;
		}
		return vector;
	}
	
	public int[] vector10000() {
		int[] vector = new int[10000];
		int numeroAleatorio = 0;
		for(int i=0; i<vector.length; i++) {
			numeroAleatorio = (int)(Math.random() * 10) + 1;
			vector[i] = numeroAleatorio;
		}
		return vector;
	}
	
	public int[] vector100000() {
		int[] vector = new int[100000];
		int numeroAleatorio = 0;
		for(int i=0; i<vector.length; i++) {
			numeroAleatorio = (int)(Math.random() * 100) + 1;
			vector[i] = numeroAleatorio;
		}
		return vector;
	}
	
	public int[] vector1000000() {
		int[] vector = new int[1000000];
		int numeroAleatorio = 0;
		for(int i=0; i<vector.length; i++) {
			numeroAleatorio = (int)(Math.random() * 100) + 1;
			vector[i] = numeroAleatorio;
		}
		return vector;
	}
	
}


public class EjemploMetodosOrdenamiento {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		MetodosOrdenamiento mo = new MetodosOrdenamiento();
		int[] edades = {34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
		
		int opcion=0;
		
		do {
			System.out.println("                         M E N Ú");
			System.out.println();
			System.out.println("1) Ordenamiento Burbuja.");
			System.out.println("2) Ordenamiento Por Selección.");
			System.out.println("3) Ordenamiento Por Inserción.");
			System.out.println("4) Ordenamiento ShellSort.");
			System.out.println("0) Salir.");
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("Elija una opción: ");
			opcion = entrada.nextInt();
			
			switch(opcion) {
				case 1:
					System.out.println("\n");
					System.out.println("=========== ORDENAMIENTO CON BURBUJA 1 ===========\n");
					mo.ordenamientoBurbuja1(mo.vector1000().clone());
					mo.ordenamientoBurbuja1(mo.vector10000().clone());
					mo.ordenamientoBurbuja1(mo.vector100000().clone());
					mo.ordenamientoBurbuja1(mo.vector1000000().clone());
					//mo.ordenamientoBurbuja1(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
				
					System.out.println("=========== ORDENAMIENTO CON BURBUJA 2 ===========\n");
					mo.ordenamientoBurbuja2(mo.vector1000().clone());
					mo.ordenamientoBurbuja2(mo.vector10000().clone());
					mo.ordenamientoBurbuja2(mo.vector100000().clone());
					mo.ordenamientoBurbuja2(mo.vector1000000().clone());
					//mo.ordenamientoBurbuja2(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== ORDENAMIENTO CON BURBUJA 3 ===========\n"); //ESTÁ MAL
					mo.ordenamientoBurbuja3(mo.vector1000().clone());
					mo.ordenamientoBurbuja3(mo.vector10000().clone());
					mo.ordenamientoBurbuja3(mo.vector100000().clone());
					mo.ordenamientoBurbuja3(mo.vector1000000().clone());
					//mo.ordenamientoBurbuja3(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					break;
				case 2:
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== ORDENAMIENTO POR SELECCION ===========\n");
					mo.ordenamientoPorSeleccion(mo.vector1000().clone());
					mo.ordenamientoPorSeleccion(mo.vector10000().clone());
					mo.ordenamientoPorSeleccion(mo.vector100000().clone());
					mo.ordenamientoPorSeleccion(mo.vector1000000().clone());
					//mo.ordenamientoPorSeleccion(edades);

					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					break;
				case 3:
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== ORDENAMIENTO POR INSERCION ===========\n");
					mo.ordenamientoPorInsercion(mo.vector1000().clone());
					mo.ordenamientoPorSeleccion(mo.vector10000().clone());
					mo.ordenamientoPorSeleccion(mo.vector100000().clone());
					mo.ordenamientoPorSeleccion(mo.vector1000000().clone());
					//mo.ordenamientoPorInsercion(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					break;
				case 4:
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== ORDENAMIENTO SHELLSORT ===========\n");
					mo.ordenamientoShellSort(mo.vector1000().clone());
					mo.ordenamientoShellSort(mo.vector10000().clone());
					mo.ordenamientoShellSort(mo.vector100000().clone());
					mo.ordenamientoShellSort(mo.vector1000000().clone());
					//mo.ordenamientoShellSort(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					break;
				case 0:
					System.out.println("S A L I E N D O . . .");
					break;
			}
		
		}while(opcion != 0);
		
	}

}


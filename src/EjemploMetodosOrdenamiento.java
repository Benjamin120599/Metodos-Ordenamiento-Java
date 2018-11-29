import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class MezclaNatural {
	
	public static Integer[] lectura() {
		
		File archivo1 = new File("./src/Archivo1.txt");
		FileReader frA1 = null;
		BufferedReader brA1;
		Integer[] arr1 = new Integer[0];
		
		try {
			frA1 = new FileReader(archivo1);
			brA1 = new BufferedReader(frA1);
			String lineaArchivo1;
			
			try {
				lineaArchivo1 = brA1.readLine();
				String[] numeros = lineaArchivo1.split(",");
				arr1 = new Integer[numeros.length];
				for(int i=0; i < numeros.length-1; i++) {
					Integer intObj = new Integer(numeros[i]);
					arr1[i] = intObj;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo.");
			e.printStackTrace();
		} try {
			frA1.close();			
		} catch(IOException e) {
			System.out.println("Error al cerrar el archivo.");
		}
		return arr1;
	}
	
	private static Comparable[] aux;
	
	public static void ordenamientoMezclaNatural(Comparable[] a) {
		
		aux = new Comparable[a.length];
		ordenamientoMezclaNatural(a, 0, a.length -1);
	}
	
	public static boolean estaOrdenado(Comparable[] a) {
		
		for(int i=1; i < a.length; i++) {
			if(a[i-1].compareTo(a[i]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void ordenamientoMezclaNatural(Comparable[] a, int primero, int ultimo) {
		
		int i = primero;
		int j = 0;
		int medio = 0;
		int az = 0;
		
		while(true) {
			i=0;
			while(i < a.length) {
				if(i == a.length - 1) {
					break;
				} else if(a[i].compareTo(i+1) > 0) {
					break;
				}
				i++;
			}
			j = i+1;
			while(j < a.length) {
				if(j == a.length-1) {
					break;
				} else if(a[j].compareTo(a[j+1]) > 0) {
					break;
				}
				j++;
			}
			
			Mezcla(a, primero, i, j);
			primero = 0;
			
			if(estaOrdenado(a)) {
				break;
			}			
		}
	}
	
	public static void Mezcla(Comparable[] a, int primero, int medio, int ultimo) {
		
		int i = primero;
		int j = medio + 1;
		
		for(int k=primero; k <= ultimo; k++) {
			aux[k] = a[k];
		}
		for(int k=primero; k <= ultimo; k++) {
			if(i > medio) {
				a[k] = aux[j++];
			} else if (j > ultimo) {
				a[k] = aux[i++];
			} else if(aux[i].compareTo(aux[j]) > 0) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
	
}


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

	public void ordenamientoQuickSort(int[] vector, int izquierda, int derecha) {
		
		int contRecorrido7=0, contComparaciones7=0, contIntercambios7=0;
		long tiempoFinal=0;
		
		long tiempoInicial = System.nanoTime();
		
		int pivote = vector[izquierda];
        int i = izquierda;
        int j = derecha;
        int auxIntercambio;
        while (i < j) {
            while (vector[i] <= pivote && i < j) {
                i++;
            }
            while (vector[j] > pivote) {
                j--;
            }
            if (i < j) {
                auxIntercambio = vector[i];
                vector[i] = vector[j];
                vector[j] = auxIntercambio;
            }
        }
        vector[izquierda] = vector[j];
        vector[j] = pivote;
        if (izquierda < j - 1) {
            ordenamientoQuickSort(vector, izquierda, j - 1);
        }
        if (j + 1 < derecha) {
        	ordenamientoQuickSort(vector, j + 1, derecha);
        }
		
		mostrarVector(vector);
		tiempoFinal = System.nanoTime() - tiempoInicial;
		
		mostrarDatosEficiencia(contRecorrido7, contComparaciones7, contIntercambios7, tiempoFinal); 		
	
	}

	public void ordenamientoRadixSort(int[] numeros) {
	
		int contRecorrido8=0, contComparaciones8=0, contIntercambios8=0;
		long tiempoFinal=0;
		
		long tiempoInicial = System.nanoTime();
		
		if(numeros.length == 0)
			return;
		
		int[][] np = new int[numeros.length][2];
		int[] q = new int[0x100];
		int i, j, k, l, f = 0;
	
		for(k=0; k<4; k++) {
			
			for(i=0; i<np.length-1; i++) 
				np[i][1] = i+1;
			np[i][1] = -1;
			for(i=0; i < q.length; i++)
				q[i] = -1;
			for(f=i=0; i<numeros.length; i++){
				j = ((0xFF<<(k<<3))&numeros[i])>>(k<<3);
				if(q[j] == -1)
					l = q[j] = f;
				else {
					l = q[j];
					while(np[l][1] != -1)
						l = np[l][1];
					np[l][1] = f;
					l = np[l][1];
				}
				
				f = np[f][1];
				np[l][0] = numeros[i];
				np[l][1] = -1;
			}
			for(l=q[i=j=0]; i<0x100; i++)
				for(l=q[i]; l!=-1; l=np[l][1])
					numeros[j++] = np[l][0];
			
		}
		
		mostrarVector(numeros);
		tiempoFinal = System.nanoTime() - tiempoInicial;
		
		mostrarDatosEficiencia(contRecorrido8, contComparaciones8, contIntercambios8, tiempoFinal);   
		
		
	}
	
	public void ordenamientoMezclaDirecta(Integer[] array, int lo, int n) {
		
		int low = lo;
        int high = n;
        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;
        ordenamientoMezclaDirecta(array, low, middle);
        ordenamientoMezclaDirecta(array, middle + 1, high);
        int end_low = middle;
        int start_high = middle + 1;
        while ((lo <= end_low) && (start_high <= high)) {
            if (array[low] < array[start_high]) {
                low++;
            } else {
                int Temp = array[start_high];
                for (int k = start_high - 1; k >= low; k--) {
                    array[k + 1] = array[k];
                }
                array[low] = Temp;
                low++;
                end_low++;
                start_high++;
            }
        }
		
		
		
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
		
		int[] arreglo1 = mo.vector1000();
		int[] arreglo2 = mo.vector10000();
		int[] arreglo3 = mo.vector100000();
		int[] arreglo4 = mo.vector1000000();
		
		
		int opcion=0;
		
		do {
			System.out.println("                         M E N Ú");
			System.out.println();
			System.out.println("1) Ordenamiento Burbuja.");
			System.out.println("2) Ordenamiento Por Selección.");
			System.out.println("3) Ordenamiento Por Inserción.");
			System.out.println("4) Ordenamiento ShellSort.");
			System.out.println("5) Ordenamiento QuickSort.");
			System.out.println("6) Ordenamiento RadixSort.");
			System.out.println("7) Ordenamiento Intercalacion de archivos.");
			System.out.println("0) Salir.");
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("Elija una opción: ");
			opcion = entrada.nextInt();
			
			switch(opcion) {
				case 1:
					System.out.println("\n");
					System.out.println("=========== ORDENAMIENTO CON BURBUJA 1 ===========\n");
					mo.ordenamientoBurbuja1(arreglo1.clone());
					mo.ordenamientoBurbuja1(arreglo2.clone());
					mo.ordenamientoBurbuja1(arreglo3.clone());
					mo.ordenamientoBurbuja1(arreglo4.clone());
					//mo.ordenamientoBurbuja1(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
				
					System.out.println("=========== ORDENAMIENTO CON BURBUJA 2 ===========\n");
					mo.ordenamientoBurbuja2(arreglo1.clone());
					mo.ordenamientoBurbuja2(arreglo2.clone());
					mo.ordenamientoBurbuja2(arreglo3.clone());
					mo.ordenamientoBurbuja2(arreglo4.clone());
					//mo.ordenamientoBurbuja2(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== ORDENAMIENTO CON BURBUJA 3 ===========\n"); //ESTÁ MAL
					mo.ordenamientoBurbuja3(arreglo1.clone());
					mo.ordenamientoBurbuja3(arreglo2.clone());
					mo.ordenamientoBurbuja3(arreglo3.clone());
					mo.ordenamientoBurbuja3(arreglo4.clone());
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
					mo.ordenamientoPorSeleccion(arreglo1.clone());
					mo.ordenamientoPorSeleccion(arreglo2.clone());
					mo.ordenamientoPorSeleccion(arreglo3.clone());
					mo.ordenamientoPorSeleccion(arreglo4.clone());
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
					mo.ordenamientoPorInsercion(arreglo1.clone());
					mo.ordenamientoPorSeleccion(arreglo2.clone());
					mo.ordenamientoPorSeleccion(arreglo3.clone());
					mo.ordenamientoPorSeleccion(arreglo4.clone());
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
					mo.ordenamientoShellSort(arreglo1.clone());
					mo.ordenamientoShellSort(arreglo2.clone());
					mo.ordenamientoShellSort(arreglo3.clone());
					mo.ordenamientoShellSort(arreglo4.clone());
					//mo.ordenamientoShellSort(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					break;
				case 5:
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== ORDENAMIENTO QUICKSORT ===========\n");
					mo.ordenamientoQuickSort(arreglo1.clone(), 0, arreglo1.clone().length-1);
					mo.ordenamientoQuickSort(arreglo2.clone(), 0, arreglo2.clone().length-1);
					mo.ordenamientoQuickSort(arreglo3.clone(), 0, arreglo3.clone().length-1);
					mo.ordenamientoQuickSort(arreglo4.clone(), 0, arreglo4.clone().length-1);
					//mo.ordenamientoQuickSort(edades, 0, edades[edades.length-1]);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					break;
				
				case 6:
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== ORDENAMIENTO RADIXSORT ===========\n");
					mo.ordenamientoRadixSort(arreglo1.clone());
					mo.ordenamientoRadixSort(arreglo2.clone());
					mo.ordenamientoRadixSort(arreglo3.clone());
					mo.ordenamientoRadixSort(arreglo4.clone());
					//mo.ordenamientoRadixSort(edades);
					
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					break;
					
				case 7:
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------");
					System.out.println();
					
					System.out.println("=========== INTERCALACIÓN DE ARCHIVOS ===========\n");
					System.out.println();
					
					File archivo1 = new File("./src/Archivo1.txt");//Archivos a leer
					File archivo2 = new File("./src/Archivo2.txt");//Archivos a leer
							
					int arreglo1 = mo.vector1000();
					
					FileReader frA1 = null;
					BufferedReader brA1;
					FileReader frA2 = null;
					BufferedReader brA2;
					
					FileWriter archivo3=null;
					PrintWriter pr=null;
					
					try{//Apertura del archivo de salida para escritura
						archivo3=new FileWriter("./src/ArchivoSalida.txt", false);
						pr=new PrintWriter(archivo3);
						
						try {//Apertura del archivo1 para lectura
							frA1=new FileReader(archivo1);
							brA1=new BufferedReader(frA1);
							String lineaArchivo1;
							
							try {//Apertura del archivo2 para lectura
								frA2=new FileReader(archivo2);
								brA2=new BufferedReader(frA2);
								String lineaArchivo2;
								boolean repetir=true;
								
								lineaArchivo1=brA1.readLine();
								lineaArchivo2=brA2.readLine();
													
								do{//Se realizan comparaciones mientras la bandera no cambie
									if(Integer.parseInt(lineaArchivo1)<Integer.parseInt(lineaArchivo2)){
										pr.println(lineaArchivo1);
										if((lineaArchivo1=brA1.readLine())==null){
											pr.println(lineaArchivo2);
											while((lineaArchivo2=brA2.readLine())!=null){
												pr.println(lineaArchivo2);
											}
											repetir=false;
										}
									}
									else if(Integer.parseInt(lineaArchivo1)>Integer.parseInt(lineaArchivo2)){
										pr.println(lineaArchivo2);
										if((lineaArchivo2=brA2.readLine())==null){
											pr.println(lineaArchivo1);
											while((lineaArchivo1=brA1.readLine())!=null){
												pr.println(lineaArchivo1);
											}
											repetir=false;
										}
									}
									else{
										pr.println(lineaArchivo1);
										pr.println(lineaArchivo2);
										if((lineaArchivo1=brA1.readLine())==null){
											pr.println(lineaArchivo2);
											while((lineaArchivo2=brA2.readLine())!=null){
												pr.println(lineaArchivo2);
											}
											repetir=false;
										}
										if((lineaArchivo2=brA2.readLine())==null){
											pr.println(lineaArchivo1);
											while((lineaArchivo1=brA1.readLine())!=null){
												pr.println(lineaArchivo1);
											}
											repetir=false;
										}
									}
								}while(repetir);
							} catch (FileNotFoundException e) {
								System.out.println("Error al abrir el archivo");
								//e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}finally{
								try {
									frA2.close();
								} catch (IOException e) {
									System.out.println("Error al cerrar el archivo");
								}	
							}//Final del archivo2
						} catch (FileNotFoundException e) {
							System.out.println("Error al abrir el archivo");
							//e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}finally{
							try {
								frA1.close();
							} catch (IOException e) {
								System.out.println("Error al cerrar el archivo");
							}
						}//Final del archivo1
						System.out.println("Archivos combinados y ordenados correctamente");
					}catch (IOException e){
						System.out.println("Error al abrir o crear el archivo");
					}finally{
						try{
							archivo3.close();
						}catch(IOException e){
							System.out.println("Error al cerrar el archivo");
						}
					}//Final del archivo3	
					break;
				case 0:
					System.out.println("S A L I E N D O . . .");
					break;
			}
		
		}while(opcion != 0);
		
	}

}


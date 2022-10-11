package ServiosProcesos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Practica1FORMA2 {
	private final static int N=1000;
	static punto[] primerhilo=new punto[N];
	static punto[] segundohilo=new punto[N];
	public static void main(String[] args) throws InterruptedException {
		final punto[] a=createArray(N);
		punto[] resultado=new punto[N];
		long startTime=0;
		long timeNanos=0;
		
		
				//forma iterativa
				startTime=System.nanoTime();	
				resultado=quitarRepetidosITERATIVO(a);
				timeNanos=System.nanoTime()-startTime;
				printResult("Algoritmo iterativo:",timeNanos,resultado);
				System.out.println("");
				System.out.println("");
				
				//Forma con dos hilos
				startTime=System.nanoTime();
				resultado=quitarRepetidosHILOS(a);		
				timeNanos=System.nanoTime()-startTime;
				printResult("Algoritmo iterativo con 2 hilos:",timeNanos,resultado);

	}
	
	// Creación del array
	private static punto[] createArray(final int N) {
		final punto[] input=new punto[N];
		final Random rand=new Random(100);
		for (int i=0; i<N; i++) {
			int X=rand.nextInt(100);
			int Y=rand.nextInt(100);
			input[i]=new punto(X,Y);
		}		
		return input; 
	}
	
	//Forma iterativa
	public static punto[] quitarRepetidosITERATIVO(punto[] a) {
		HashSet<punto> has= new HashSet<punto>(Arrays.asList(a));
		punto[] result= new punto[has.size()];
		return  has.toArray(result);
	}
	
	
	//CON DOS HILOS
	public static punto[] quitarRepetidosHILOS(punto[] a) throws InterruptedException {
		Thread primerHILO=new Thread(){
			public void run() {
				 punto[] input=new punto[a.length/2];
				input=Arrays.copyOfRange(a, 0, a.length/2);
				HashSet<punto> has= new HashSet<punto>(Arrays.asList(input));
				punto[] result= new punto[has.size()];
				result= has.toArray(result);
				primerhilo=result;
			}
		};
		Thread segundoHILO=new Thread(){
			public void run() {
				 punto[] input=new punto[a.length/2];
				input=Arrays.copyOfRange(a, a.length/2, a.length);
				HashSet<punto> has= new HashSet<punto>(Arrays.asList(input));
				punto[] result= new punto[has.size()];
				result= has.toArray(result);
				segundohilo=result;
			}
		};
		
		primerHILO.start();
		segundoHILO.start();
		
		primerHILO.join();
		segundoHILO.join();
		
		return unirPuntos(primerhilo,segundohilo);
	}
	
	public static punto[] unirPuntos(punto[] a,punto[]b){
		HashSet<punto> has= new HashSet<punto>(Arrays.asList(a));
		has.addAll(Arrays.asList(b));
		punto[] result= new punto[has.size()];
		return  has.toArray(result);
	}
	
	private static void printResult(String name, 
			long timeNanos, punto[] resultado) {
			System.out.printf(" %s completado en %8.3f milisegundos con RESULTADO(%s) \n",
				name,timeNanos/1e6,Arrays.toString(resultado));			
	}

}

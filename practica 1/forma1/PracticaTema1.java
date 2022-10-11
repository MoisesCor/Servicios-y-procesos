package ServiosProcesos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class PracticaTema1 extends Thread {
	private final static int A=50;
	static HashSet<punto> primerhilo = new HashSet<punto>();
	static HashSet<punto> segundohilo = new HashSet<punto>();

	public static void main(String[] args) throws InterruptedException {
		long startTime=0;
		long timeNanos=0;
		HashSet<punto> resultado = new HashSet<punto>();
		// TODO Auto-generated method stub
		
		//forma iterativa
		startTime=System.nanoTime();	
		resultado=createArrayHashSet(A);
		timeNanos=System.nanoTime()-startTime;
		printResult("Algoritmo iterativo:",timeNanos,resultado);
		System.out.println("");
		System.out.println("");
		
		//Forma con dos hilos
		startTime=System.nanoTime();
		resultado=createArrayHashSetHILO(A);		
		timeNanos=System.nanoTime()-startTime;
		printResult("Algoritmo iterativo con 3 hilos:",timeNanos,resultado);
	}
	
	private static HashSet<punto> createArrayHashSet(final int A) {
		final punto[] input=new punto[A];
		HashSet<punto> has=new HashSet<punto>();
		final Random rand=new Random(100);
		for (int i=0; i<A; i++) {
			int X=rand.nextInt(100);
			int Y=rand.nextInt(100);
			input[i]=new punto(X,Y);
			has.add(input[i]);
			
			
			}
		System.out.println(input.length);
		System.out.println(Arrays.toString(input));
		System.out.println(has.size());
		return has;

}
	
	
	private static HashSet<punto> createArrayHashSetHILO(final int A) throws InterruptedException{
		Thread primerHILO=new Thread(){
			public void run() {
				final punto[] input=new punto[A];
				final Random rand=new Random(100);
				for (int i=0; i<A/2; i++) {
					int X=rand.nextInt(100);
					int Y=rand.nextInt(100);
					input[i]=new punto(X,Y);
					primerhilo.add(input[i]);
					
					
					}
			}
		};
		Thread segundoHILO=new Thread(){
			public void run() {
				final punto[] input=new punto[A];
				
				final Random rand=new Random(100);
				for (int i=0; i<A/2; i++) {
					int X=rand.nextInt(100);
					int Y=rand.nextInt(100);
					input[i]=new punto(X,Y);
					segundohilo.add(input[i]);
					
					
					}
			}
		};
		
		primerHILO.start();
		segundoHILO.start();
		
		primerHILO.join();
		segundoHILO.join();
		
		return unirPuntos(primerhilo,segundohilo);
	}
	
	public static HashSet<punto> unirPuntos(HashSet<punto> a,HashSet<punto>b){
		HashSet<punto> fi= new HashSet<punto>(a);
		fi.addAll(b);
		return fi;
	}
	
	private static void printResult(String name, 
			long timeNanos, HashSet<punto> result) {
			System.out.printf(" %s completado en %8.3f milisegundos con resultado\n",
				name,timeNanos/1e6);	
			System.out.print(" "+result);
	}
}
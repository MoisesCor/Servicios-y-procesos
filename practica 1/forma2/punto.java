package ServiosProcesos;

import java.util.Objects;

public class punto {
	
	// calcular distancia
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	// Calculamos la distancia entre puntos
	public double distancia( punto param1) {
		int distancia= (this.x -param1.x) * (this.x -param1.x) +(this.y-param1.y) * (this.y-param1.y);
		double resultado = Math.sqrt(distancia);// esto hace el raiz  cuadrado
		return resultado;
		
	}
	@Override
	public String toString() {
		return "punto [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		punto other = (punto) obj;
		return x == other.x && y == other.y;
	}
	
	
	
	
	
}

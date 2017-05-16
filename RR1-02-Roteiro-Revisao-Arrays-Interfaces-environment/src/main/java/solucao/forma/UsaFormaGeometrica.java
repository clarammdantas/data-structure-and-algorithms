package solucao.forma;

public class UsaFormaGeometrica {
	
	public static void main(String[] args) {
		Forma circle = new Circulo(3.0);
		Forma triangle = new Triangulo(3, 6);
		Forma square = new Quadrado(3.0);
		
		System.out.println("Área do círculo = " + circle.area());
		System.out.println("Área do triangulo = " + triangle.area());
		System.out.println("Área do quadrado = " + square.area());
	}
}

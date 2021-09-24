package fr.htc.cours.exemples.expl1;

public class Ellipse {
	public double r1, r2;

	public Ellipse(double r1, double r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	public double area() {
		return r1 * r2 * Math.PI;
	}
}

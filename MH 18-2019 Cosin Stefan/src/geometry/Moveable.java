package geometry;

public interface Moveable {
	//podrazumeva se da ispred njih pise abstract
	//final kod promenljive = konstana, kod klase da ne mozes da je nasledis, ispred metode znaci da tu metodu ne mozes da redefinises
	//int Broj = 20; podrazumeva se da je ispred static final
	void moveTo(int x, int y);
	void moveBy(int byX, int byY);
}

package controller;

public class DistroController {
	public DistroController() {
		super();
	}
	public void chamador() {
		os();
		exibeDistro();
	}
	private  void os() {
		String OS = System.getProperty("os.name");
		System.out.println(OS);
		
	}
	public void exibeDistro() {
		String os =System.getProperty("os.name");
		String L = "Linux";
		if (os.contains(L)) {
			String vr = System.getProperty("os.version");
			System.out.println("sistema op: "+ os +" versao: "+ vr);			
			
		}else {
			System.out.println("o Sistema operacional desta maquina nao e Linux");
		}
	}
	
	
}

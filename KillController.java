package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KillController {
	public KillController() {
		super();
	}
	public void chamador() {
		os();
		listaProcessos();
		mataPid();
		mataNome();
	}
	private void os() {
		String OS = System.getProperty("os.name");
		System.out.println("sistema operacional: "+OS);
	}
	
	public void listaProcessos() {

		String OS=System.getProperty("os.name");
		String L = "Linux";
		String W = "Windows";
		String comando = "";
		if (OS.contains(L)) {
			comando="ps";
		}else {
			if(OS.contains(W)) {
				comando="TASKLIST /FO TABLE";
			}else {
				System.out.println("OS nao compativel com o programa");
			}
		}
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		}catch(Exception e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
		
	}
	
	public void mataPid() {
		Scanner sc = new Scanner(System.in);
	System.out.println("digite o PID do programa q sera finalizado");
		int ID= sc.nextInt();
		StringBuffer buffer = new StringBuffer();
		
		String OS=System.getProperty("os.name");
		String L = "Linux";
		String W = "Windows";
		String comando = "";
		
		if (OS.contains(L)) {
			comando="kill -9 ";
		}else {
			if(OS.contains(W)) {
				comando="TASKKILL /PID";
			}else {
				System.out.println("OS nao compativel com o programa");
			}
		}
		try {
			buffer.append(comando);
			buffer.append( " ");
			buffer.append(ID);
			
			Runtime.getRuntime().exec(buffer.toString() );
		}catch(Exception e){
			
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
	}
	
	public void mataNome() {
		Scanner sc = new Scanner(System.in);
	System.out.println("digite o nome do programa q sera finalizado");
		String nome= sc.next();
		StringBuffer buffer = new StringBuffer();
		
		String OS=System.getProperty("os.name");
		String L = "Linux";
		String W = "Windows";
		String comando = "";
		
		if (OS.contains(L)) {
			comando="pkill -f ";
		}else {
			if(OS.contains(W)) {
				comando="TASKKILL /IM";
			}else {
				System.out.println("OS nao compativel com o programa");
			}
		}
		try {
			buffer.append(comando);
			buffer.append( " ");
			buffer.append(nome);
			
			Runtime.getRuntime().exec(buffer.toString() );
		}catch(Exception e){
			
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
	}
	
}

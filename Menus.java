import java.util.*;
import java.io.*;

public class Menus implements Serializable {

	public static void menu(){
        System.out.println("--------------------MENU PRINCIPAL--------------------");
        System.out.println("1-Login");
        System.out.println("2-Registar Utilizador");
        System.out.println("3-Gravar/Carrregar");
        System.out.println("4-Administrador App");
        System.out.println("0-Sair");
    }

    public static void submenu_administrador(){
        System.out.println("--------------------MENU ADMINISTRADOR--------------------");
        System.out.println("1-Consultar Encomendas Aceites");
        System.out.println("2-Consultar Encomendas");
        System.out.println("3-Consultar Lojas");
        System.out.println("4-Consultar Clientes");
        System.out.println("5-Consultar Empresas");
        System.out.println("0-Sair");
    }

    public static void submenu_login(){
        System.out.println("--------------------MENU LOGIN--------------------");
        System.out.println("1-Login Cliente");
        System.out.println("2-Login Loja");
        System.out.println("3-Login Empresa");
        System.out.println("4-Login Voluntario");
        System.out.println("0-Sair");
    }

     public static void submenu_cliente(){
        System.out.println("--------------------MENU CLIENTE--------------------");
        System.out.println("1-Solicitar entrega de encomenda");
        System.out.println("2-Responder a serviços de entrega propostos");
        System.out.println("3-Histórico de encomendas");
        System.out.println("4-Classificar serviços");
        System.out.println("0-Sair");
    }

    public static void submenu_Empresa(){
        System.out.println("--------------------MENU EMPRESA--------------------");
        System.out.println("1-Sinalizar disposição para recolher encomendas");
        System.out.println("2-Determirnar preços de transporte");
        System.out.println("3-Realizar transporte de encomenda");
        System.out.println("0-Sair");
    }

    public static void submenu_Loja(){
        System.out.println("--------------------MENU LOJA--------------------");
        System.out.println("1-Sinalizar que existe uma encomenda de um Cliente para ser entregue");
        System.out.println("2-Indicar quantidade de pessoas que existem na fila");
        System.out.println("0-Sair");
    }

    public static void submenu_RegistarUtilizador(){
        System.out.println("--------------------MENU REGISTAR UTILIZADOR--------------------");
        System.out.println("1-Registar Cliente");
        System.out.println("2-Registar Loja");
        System.out.println("3-Registar Empresa");
        System.out.println("4-Registar Voluntario");
        System.out.println("0-Sair");
    }

    public static void submenu_HistoricoEncomendas(){
    	System.out.println("--------------------MENU HISTORICO DE ENCOMENDAS--------------------");
    	System.out.println("1-Consultar encomendas entregues por voluntario");
    	System.out.println("2-Consultar encomenda entregues por empresa");
    	System.out.println("3-Consultar encomendas por um período");
    	System.out.println("0-Sair");
    }

    public static void submenu_gravar(){
        System.out.println("--------------------MENU GRAVAR/CARREGAR--------------------");
        System.out.println("1-Gravar");
        System.out.println("2-Carregar");
        System.out.println("0-Sair");
    }
}
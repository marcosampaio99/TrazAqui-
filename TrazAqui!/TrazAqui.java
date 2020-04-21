import java.awt.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;
/**
 * Escreva a descrição da classe TrazAqui aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TrazAqui implements Serializable
{
  
    public static void main(String[] args){
         
        GestaoGeral g= new GestaoGeral();
        
        int opt;
        
        do {
            Menus.menu();
            opt=Scanners.leituraInt("Escolha uma opção:");
            
            switch(opt){
                case 1:{
                    int optLogin;
                    do {
                        Menus.submenu_login();
                        optLogin = Scanners.leituraInt("Escolha uma opção");
                        switch (optLogin) {
                            case 1: {
                                String email = Scanners.leituraString("Email:");
                                String password = Scanners.leituraString("Password:");
                                try {
                                    g.loginCliente(email, password);
                    
                                } catch (GestaoGeralException e) {
                                    System.out.println("Dados incorretos para esta conta: " + e.getMessage());
                                }
                                break;          
                            }
                            case 2:{
                                String email = Scanners.leituraString("Email:");
                                String password = Scanners.leituraString("Password:");
                                try {
                                    g.loginLoja(email, password);
                    
                                } catch (GestaoGeralException e) {
                                    System.out.println("Dados incorretos para esta conta: " + e.getMessage());
                                }
                                break; 
                            }
                            case 3:{
                                String email = Scanners.leituraString("Email:");
                                String password = Scanners.leituraString("Password:");
                                try {
                                    g.loginEmpresa(email, password);
                    
                                } catch (GestaoGeralException e) {
                                    System.out.println("Dados incorretos para esta conta: " + e.getMessage());
                                }
                                break; 
                            }
                            case 4:{
                                String email = Scanners.leituraString("Email:");
                                String password = Scanners.leituraString("Password:");
                                try {
                                    g.loginVoluntario(email, password);
                    
                                } catch (GestaoGeralException e) {
                                    System.out.println("Dados incorretos para esta conta: " + e.getMessage());
                                }
                                break; 
                            }
                            case 0:{
                                break;
                            }
                            default :{
                                break;
                            }
                          }
                        }while (optLogin!=0);
                    }
                case 2:{
                    int optRegUtilizador;
                    do {
                        Menus.submenu_RegistarUtilizador();
                        optRegUtilizador=Scanners.leituraInt("Escolha uma opção");
                        switch(optRegUtilizador){
                            case 1:{
                                String email = Scanners.leituraString("Email:");
                                String nome = Scanners.leituraString("Nome:");
                                String password = Scanners.leituraString("Password:");
                                double n = Scanners.leituraDouble("Coordenada N:");
                                double l = Scanners.leituraDouble("Coordenada L:");
                                Localizacao lAux=new Localizacao(n,l);
                                
                                try {
                                    g.registaCliente(email, nome, password,lAux);
                                    System.out.println("Registo de cliente com sucesso!");
                                } catch (GestaoGeralException e) {
                                    System.out.println("Este email já tem conta associada " + e.getMessage());
                                }
                                break;
                            }
                            case 2:{
                                String email = Scanners.leituraString("Email:");
                                String nome = Scanners.leituraString("Nome:");
                                String password = Scanners.leituraString("Password:");
                                double n = Scanners.leituraDouble("Coordenada N:");
                                double l = Scanners.leituraDouble("Coordenada L:");
                                Localizacao lAux=new Localizacao(n,l);
                                double tempoEspera = Scanners.leituraDouble("Tempo de Espera:");
                                
                                try {
                                    g.registaLoja(email, nome, password,lAux,tempoEspera);
                                    System.out.println("Registo de loja com sucesso!");
                                } catch (GestaoGeralException e) {
                                    System.out.println("Este email já tem conta associada " + e.getMessage());
                                }
                                break;
                            }
                            case 3:{
                                String email = Scanners.leituraString("Email:");
                                String nome = Scanners.leituraString("Nome:");
                                String password = Scanners.leituraString("Password:");
                                double n = Scanners.leituraDouble("Coordenada N:");
                                double l = Scanners.leituraDouble("Coordenada L:");
                                Localizacao lAux=new Localizacao(n,l);
                                int NIF = Scanners.leituraInt("NIF:");
                                double raiogeografico = Scanners.leituraDouble("Raio geografico:");
                                int velocidade = Scanners.leituraInt("Velocidade:");
                                double taxa = Scanners.leituraDouble("Taxa:");
                                int multitasking = Scanners.leituraInt("Multitasking? (0-N 1-S):");
                                int capacidade = Scanners.leituraInt("Capacidade:");
                                
                                try {
                                    g.registaEmpresa(email, nome, password,lAux,NIF,raiogeografico,velocidade,0,taxa,multitasking,0,capacidade);
                                    System.out.println("Registo de empresa com sucesso!");
                                } catch (GestaoGeralException e) {
                                    System.out.println("Este email já tem conta associada " + e.getMessage());
                                }
                                break;
                            }
                            case 4:{
                                String email = Scanners.leituraString("Email:");
                                String nome = Scanners.leituraString("Nome:");
                                String password = Scanners.leituraString("Password:");
                                double n = Scanners.leituraDouble("Coordenada N:");
                                double l = Scanners.leituraDouble("Coordenada L:");
                                Localizacao lAux=new Localizacao(n,l);
                                double raiogeografico = Scanners.leituraDouble("Raio geografico:");
                                int velocidade = Scanners.leituraInt("Velocidade:");
                                
                                try {
                                    g.registaVoluntario(email, nome, password,lAux,raiogeografico,velocidade,0,0);
                                    System.out.println("Registo de voluntario com sucesso!");
                                } catch (GestaoGeralException e) {
                                    System.out.println("Este email já tem conta associada " + e.getMessage());
                                }
                                break;
                            }
                            case 0:{
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }while (optRegUtilizador!=0);
                }
                case 3:{
                    int optGravarCarregar;
                    do{
                        Menus.submenu_gravar();
                        optGravarCarregar=Scanners.leituraInt("Escolha uma opção");
                        switch(optGravarCarregar){
                            case 1:{
                                
                            }
                            case 2:{
                                
                                Leitura l = new Leitura();
                                l.ler();
                                System.out.println("Carregamento realizado com sucesso");
                                
                            }
                            case 0:{
                                break;
                            }
                            default:{
                                break;
                            }
                        }
                    }while(optGravarCarregar!=0);
                }
                case 4:{
                }
                case 0: {
                    break;
                }
                default: {
                    break;
                }    
              }
            }while (opt != 0);
        }
}
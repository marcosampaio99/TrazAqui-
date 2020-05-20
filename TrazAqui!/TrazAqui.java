import java.awt.*;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;


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
                                    Cliente cliente =  g.getClientes().get(email);
                                    int optLoginCliente;
                                    do{
                                        Menus.submenu_cliente();
                                        optLoginCliente = Scanners.leituraInt("Escolha uma opção");
                                        switch(optLoginCliente){
                                        case 1:{
                                             Encomenda e = new Encomenda();
                                             e.setCliente(cliente);
                                             String id=String.valueOf(g.listagemClientes().size())+10;
                                             e.setId(id);
                                             int medical= Scanners.leituraInt("A encomenda é médica?");
                                             if(medical==0){
                                                 e.setState(false);
                                                } else if(medical==1){
                                                    e.setState(true);
                                                }
                                                System.out.println("Introduza os produtos");
                                                ArrayList <LinhaEncomenda> l=new ArrayList<>();

                                                int completo=1;
                                                while(completo==1){
                                                    String ref=Scanners.leituraString("Insira a referencia do produto");
                                                    String descricao=Scanners.leituraString("Insira a descricao do produto");
                                                    Double preco=Scanners.leituraDouble("Insira o preco do produto");
                                                    Double quantidade=Scanners.leituraDouble("Insira a quantidade");
                                                    LinhaEncomenda li= new LinhaEncomenda(ref,descricao,preco,quantidade);
                                                    l.add(li);
                                                    completo=Scanners.leituraInt("Deseja adicionar mais algum produto(Sim:1;Não:0");
                                                }
        
                                                e.setLinhas(l);
                                                String idLoja=Scanners.leituraString("Insira o email da loja");
                                                try{
                                                    Loja loja=g.getLojas().get(idLoja);
                                                    e.setLoja(loja);
                                                    e.setPeso(e.calculapeso());
                                                    g.criaEncomenda(cliente,e,idLoja);
                                                    System.out.println("Encomenda feita com sucesso");
                                                } catch(LojaNaoExisteException a){
                                                    System.out.println("Loja" + a.getMessage()+ "nao existe");
                                                }
                                                break;
                                        }
                                        case 2:{
                                             ArrayList<Pronta> list = (ArrayList) g.listagemEncomendasProntas(cliente);
                                                for (Pronta p : list)
                                                    System.out.println(p.toString());
                                             String id = Scanners.leituraString("Escolha id do aluguer que pretende aceitar:");
                                              try {
                                                    g.AceitaPedido(id, cliente); 
                                                    System.out.println("Pedido aceite");
                                                } catch (GestaoGeralException e) {
                                                    System.out.println("Não podes aceitar o seguinte pedido" + e.getMessage());
                                                }
                                                break;
                                        }
                                        case 3:{
                                            int optHistorico;
                                            do{
                                               Menus.submenu_HistoricoEncomendas();
                                               optHistorico=Scanners.leituraInt("Escolha uma opção");
                                               switch(optHistorico){
                                                case 1:{
                                                    int dia1 = Scanners.leituraInt("Dia Inicial:");
                                                    int mes1 = Scanners.leituraInt("Mês Inicial");
                                                    int ano1 = Scanners.leituraInt("Ano Inicial:");
                                                    int dia2 = Scanners.leituraInt("Dia Final:");
                                                    int mes2 = Scanners.leituraInt("Mês Final");
                                                    int ano2 = Scanners.leituraInt("Ano Final:");
                                                    LocalDate d1 = LocalDate.of(ano1,mes1,dia1);
                                                    LocalDate d2 = LocalDate.of(ano2,mes2,dia2);
                                                    Date auxD1 = java.sql.Date.valueOf(d1);
                                                    Date auxD2 = java.sql.Date.valueOf(d2);
                                                    List<RealizadaEmpresa> l = new ArrayList<>(g.getEncEmpPorPeriodo(cliente,auxD1,auxD2));
                                                    for (RealizadaEmpresa r : l)
                                                        System.out.println(r.toString());
                                                break;
                                                }
                                                case 2:{
                                                    int dia1 = Scanners.leituraInt("Dia Inicial:");
                                                    int mes1 = Scanners.leituraInt("Mês Inicial");
                                                    int ano1 = Scanners.leituraInt("Ano Inicial:");
                                                    int dia2 = Scanners.leituraInt("Dia Final:");
                                                    int mes2 = Scanners.leituraInt("Mês Final");
                                                    int ano2 = Scanners.leituraInt("Ano Final:");
                                                    LocalDate d1 = LocalDate.of(ano1,mes1,dia1);
                                                    LocalDate d2 = LocalDate.of(ano2,mes2,dia2);
                                                    Date auxD1 = java.sql.Date.valueOf(d1);
                                                    Date auxD2 = java.sql.Date.valueOf(d2);
                                                    List<RealizadaVoluntario> aux = new ArrayList<>(g.getEncVolPorPeriodo(cliente,auxD1,auxD2));
                                                    for (RealizadaVoluntario r : aux)
                                                        System.out.println(r.toString());
                                                break;
                                                }
                                                default:{
                                                break;
                                                }
                                               }
                                            }while(optHistorico!=0);
                                        }
                                        case 4:{
                                            int optClassi;
                                            do{
                                                Menus.submenu_Classificar();
                                                optClassi=Scanners.leituraInt("Escolha uma opção");
                                                switch(optClassi){
                                                    case 1:{
                                                          List<RealizadaVoluntario> l = new ArrayList<>(g.listaClassificarVoluntario(cliente));
                                                            for (RealizadaVoluntario r : l)
                                                        System.out.println(r.toString());
                                                          String id = Scanners.leituraString("Escolha da lista acima o id do aluguer que quer classificar(apenas numero)");
                                                          double c= Scanners.leituraDouble("Qual a classificação que quer atribuir a entrega (0.0-10.0)");
                                                          if (c > 10.0) c = 10.0;
                                                          if(c==0.0) break;
                                                         try{
                                                             RealizadaVoluntario aux = (RealizadaVoluntario) g.getEncomendas().get(id);
                                                              Voluntario a=aux.getVoluntario();
                                                              g.registaClassVoluntario(id,c,cliente,a); 
                                                              System.out.println("Classificação realizada com sucesso");
                                                            }
                                                            catch (GestaoGeralException e){
                                                                System.out.println("Não pode classificar o seguinte aluguer" + e.getMessage());
                                                            }
                                                            break;
                                                    
                                                    }
                                                    case 2: {
                                                         List<RealizadaEmpresa> l = new ArrayList<>(g.listaClassificarEmpresa(cliente));
                                                            for (RealizadaEmpresa r : l)
                                                        System.out.println(r.toString());
                                                          String id = Scanners.leituraString("Escolha da lista acima o id do aluguer que quer classificar");
                                                          double c= Scanners.leituraDouble("Qual a classificação que quer atribuir a entrega (0.0-10.0)");
                                                          if (c > 10.0) c = 10.0;
                                                          if(c==0.0) break;
                                                          try{
                                                              RealizadaEmpresa aux = (RealizadaEmpresa) g.getEncomendas().get(id);
                                                              Empresa a=aux.getEmpresa();  
                                                              g.registaClassEmpresa(id,c,cliente,a);
                                                              System.out.println("Classificação realizada com sucesso");
                                                            }
                                                            catch (GestaoGeralException e){
                                                                System.out.println("Não pode classificar o seguinte aluguer" + e.getMessage());
                                                            }
                                                            break;
                                                    }
                                                    default :{
                                                    break;
                                                    }
                                                }
                                        }while(optClassi!=0);
                                        }
                                        default:{
                                        break;
                                        }
                                       }
                                    }while(optLoginCliente!=0);
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
                                    Loja loja =  g.getLojas().get(email);
                                    int optLoginLoja;
                                    do{
                                        optLoginLoja= Scanners.leituraInt("Escolha uma opção");
                                        switch(optLoginLoja){
                                            case 1:{
                                                List<Encomenda> l = new ArrayList<>(g.listagemEncomendasNaoRespondidas(loja));
                                                            for (Encomenda enc : l)
                                                            System.out.println(enc.toString());
                                                String id = Scanners.leituraString("Escolha da lista acima o id da encomenda que está pronta para entregar");
                                                
                                                try{
                                                     g.registaEncomendaLoja(id,loja);
                                                     System.out.println("Encomenda pronta a ser entregue");
                                                     }
                                                     catch (GestaoGeralException e){
                                                      System.out.println("Não pode tornar pronta a seguinte encomenda" + e.getMessage());
                                                  }
                                            break;
                                        }
                                            case 2 : {
                                               double qntdPessoas= Scanners.leituraDouble("Indique quantas pessoas estão em fial de espera");
                                                g.registarFilaDeEspera(qntdPessoas, loja );
                                            break;
                                        }
                                            default :{
                                            break;
                                        }
                                      }
                                    }while(optLoginLoja!=0);
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
                                    Empresa empresa=g.getEmpresas().get(email);
                                    int optLoginEmpresa;
                                    do{
                                        optLoginEmpresa= Scanners.leituraInt("Escolha uma opção");
                                        switch(optLoginEmpresa){
                                            case 1:{
                                                //Sinalizar disposição para entregar encomendas (fazer funcao na gestao geral que verifica as encomendas
                                                // que podem ser entregues e passar a ser do tipo Pronta com um preço )
                                            break;
                                        }
                                            case 2 : {
                                                 int dia1 = Scanners.leituraInt("Dia Inicial:");
                                                    int mes1 = Scanners.leituraInt("Mês Inicial");
                                                    int ano1 = Scanners.leituraInt("Ano Inicial:");
                                                    int dia2 = Scanners.leituraInt("Dia Final:");
                                                    int mes2 = Scanners.leituraInt("Mês Final");
                                                    int ano2 = Scanners.leituraInt("Ano Final:");
                                                    LocalDate d1 = LocalDate.of(ano1,mes1,dia1);
                                                    LocalDate d2 = LocalDate.of(ano2,mes2,dia2);
                                                    Date auxD1 = java.sql.Date.valueOf(d1);
                                                    Date auxD2 = java.sql.Date.valueOf(d2);
                                                    List<RealizadaEmpresa> l = new ArrayList<>(g.getEncEPorPeriodo(empresa,auxD1,auxD2));
                                                    for (RealizadaEmpresa r : l)
                                                        System.out.println(r.toString());
                                            break;
                                        }
                                            default :{
                                            break;
                                        }
                                      }
                                    }while(optLoginEmpresa!=0);
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
                                    Voluntario voluntario=g.getVoluntarios().get(email);
                                    int optLoginVoluntario;
                                    do{
                                        optLoginVoluntario= Scanners.leituraInt("Escolha uma opção");
                                        switch(optLoginVoluntario){
                                            case 1:{
                                                //Entregar encomenda(fazer funcao na gestao geral que verifique se as encomendas prontas para ser
                                                // entregues e passar essa cena para realizadaVoluntario)
                                            break;
                                        }
                                            case 2 : {
                                                int dia1 = Scanners.leituraInt("Dia Inicial:");
                                                    int mes1 = Scanners.leituraInt("Mês Inicial");
                                                    int ano1 = Scanners.leituraInt("Ano Inicial:");
                                                    int dia2 = Scanners.leituraInt("Dia Final:");
                                                    int mes2 = Scanners.leituraInt("Mês Final");
                                                    int ano2 = Scanners.leituraInt("Ano Final:");
                                                    LocalDate d1 = LocalDate.of(ano1,mes1,dia1);
                                                    LocalDate d2 = LocalDate.of(ano2,mes2,dia2);
                                                    Date auxD1 = java.sql.Date.valueOf(d1);
                                                    Date auxD2 = java.sql.Date.valueOf(d2);
                                                    List<RealizadaVoluntario> aux = new ArrayList<>(g.getEncVPorPeriodo(voluntario,auxD1,auxD2));
                                                    for (RealizadaVoluntario r : aux)
                                                        System.out.println(r.toString());
                                            break;
                                        }
                                            default :{
                                            break;
                                        }
                                      }
                                    }while(optLoginVoluntario!=0);
                                } catch (GestaoGeralException e) {
                                    System.out.println("Dados incorretos para esta conta: " + e.getMessage());
                                }
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
                                double n = Scanners.leituraDouble("Coordenada N(usar virgula):");
                                double l = Scanners.leituraDouble("Coordenada L(usar virgula):");
                                Localizacao lAux=new Localizacao(n,l);
                                List<RealizadaEmpresa> re = new ArrayList<RealizadaEmpresa>();
                                List<RealizadaVoluntario> rv = new ArrayList<RealizadaVoluntario>();
                                try {
                                    g.registaCliente(email, nome, password,lAux,re,rv);
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
                                double n = Scanners.leituraDouble("Coordenada N(usar virgula):");
                                double l = Scanners.leituraDouble("Coordenada L(usar virgula):");
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
                                double n = Scanners.leituraDouble("Coordenada N(usar virgula):");
                                double l = Scanners.leituraDouble("Coordenada L(usar virgula):");
                                Localizacao lAux=new Localizacao(n,l);
                                int NIF = Scanners.leituraInt("NIF:");
                                double raiogeografico = Scanners.leituraDouble("Raio geografico:");
                                int velocidade = Scanners.leituraInt("Velocidade:");
                                double taxa = Scanners.leituraDouble("Taxa:");
                                int multitasking = Scanners.leituraInt("Multitasking? (0-N 1-S):");
                                int capacidade = Scanners.leituraInt("Capacidade:");
                                List<RealizadaEmpresa> re = new ArrayList<RealizadaEmpresa>();
                                try {
                                    g.registaEmpresa(email,nome, password,lAux,NIF,raiogeografico,velocidade,0.0,0,taxa,multitasking,0,capacidade,re);
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
                                double n = Scanners.leituraDouble("Coordenada N(usar virgula):");
                                double l = Scanners.leituraDouble("Coordenada L(usar virgula):");
                                Localizacao lAux=new Localizacao(n,l);
                                double raiogeografico = Scanners.leituraDouble("Raio geografico:");
                                int velocidade = Scanners.leituraInt("Velocidade:");
                                List<RealizadaVoluntario> rv = new ArrayList<RealizadaVoluntario>();
                                try {
                                    g.registaVoluntario(email,nome, password,lAux,raiogeografico,velocidade,0.0,0,0,rv);
                                    System.out.println("Registo de voluntario com sucesso!");
                                } catch (GestaoGeralException e) {
                                    System.out.println("Este email já tem conta associada " + e.getMessage());
                                }
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
                                try {
                                    g.guardaEstado();
                                    System.out.println("Gravação realizada com sucesso");
                                }
                                catch(IOException i){
                                    System.out.println(i);

                                }
                                break;
                            }
                            case 2:{
                                try {
                                    g.carregaEstado();
                                    System.out.println("Carregamento realizado com sucesso");
                                }
                                catch(IOException i){
                                    System.out.println(i);

                                }
                                catch (ClassNotFoundException c){
                                    System.out.println(c);
                                }
                              break; 
                            }
                            case 3:{
                                
                                Leitura l = new Leitura();
                                l.ler();
                                g.addListaClientes(l.listagemClientes());
                                g.addListaEmpresas(l.listagemEmpresas());
                                g.addListaLojas(l.listagemLojas());
                                g.addListaVoluntarios(l.listagemVoluntarios());
                                g.addListaEncomendas(l.listagemEncomendas());
                                System.out.println("Carregamento realizado com sucesso");
                                
                            }
                            default:{
                                break;
                            }
                        }
                    }while(optGravarCarregar!=0);
                }
                case 4:{
                    int optAdmin;
                    do{
                        Menus.submenu_administrador();
                        optAdmin=Scanners.leituraInt("Escolha uma opção");
                        switch(optAdmin){
                            case 1:{
                                ArrayList<RealizadaEmpresa> result = new ArrayList<RealizadaEmpresa>();
                                    result = (ArrayList) g.listagemEncomendasRealizadasEmpresas();
                                    for (RealizadaEmpresa r : result)
                                        System.out.println(r.toString());
                                    break;
                            }
                            case 2:{
                                ArrayList<RealizadaVoluntario> result = new ArrayList<RealizadaVoluntario>();
                                    result = (ArrayList) g.listagemEncomendasRealizadasVoluntarios();
                                    for (RealizadaVoluntario r : result)
                                        System.out.println(r.toString());
                                    break;
                            }
                            case 3: {
                                ArrayList<Encomenda> result = new ArrayList<Encomenda>();
                                    result = (ArrayList) g.listagemEncomendas();
                                    for (Encomenda r : result)
                                        System.out.println(r.toString());
                                    break;
                            }
                            case 4 :{
                                ArrayList<Loja> result = new ArrayList<Loja>();
                                    result = (ArrayList) g.listagemLojas();
                                    for (Loja r : result)
                                        System.out.println(r.toString());
                                    break;
                            }
                            case 5 : {
                                ArrayList<Cliente> result = new ArrayList<Cliente>();
                                    result = (ArrayList) g.listagemClientes();
                                    for (Cliente c : result)
                                        System.out.println(c.toString());
                                    break;
                            }
                            case 6:{
                                ArrayList<Empresa> result = new ArrayList<Empresa>();
                                    result = (ArrayList) g.listagemEmpresas();
                                    for (Empresa c : result)
                                        System.out.println(c.toString());
                                    break;
                            }
                            case 7 :{
                                ArrayList<Pronta> result = new ArrayList<Pronta>();
                                    result = (ArrayList) g.listagemPedidos();
                                    for (Pronta c : result)
                                        System.out.println(c.toString());
                                    break;
                            }
                            default:{
                                break;
                            }
                        }
                    }while(optAdmin!=0);
                    
                }
                case 5:{
                    int optRank;
                    do{
                        Menus.submenu_rankings();
                        optRank=Scanners.leituraInt("Escolha uma opção");
                        switch(optRank){
                            case 1:{
                                //top10 users
                            }
                            case 2:{
                                //top10 empresas
                            }
                            default: {
                            break;
                            }
                        }
                    }while(optRank!=0);
                }
                default: {
                    break;
                }    
              }
            }while (opt != 0);
        }
}

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

//Definicao da classe Cliente junto com seus atributos e métodos
class Cliente{
  private String nome,endereco;
  private int telefone;
  public String getNome(){
    return this.nome;
  }
  //definicao de gets e sets para a manipulação de atributos
  public void setNome(String nome){
    this.nome=nome;
  }
  public int getTelefone(){
    return this.telefone;
  }
  public void setTelefone(int telefone){
    this.telefone=telefone;
  }
  public String getEndereco(){
    return this.endereco;
  }
  public void setnome(String endereco){
    this.endereco=endereco;
  }
  //construtor que inicia a classe usando 3 parâmetros
  public Cliente(String nome,String endereco,int telefone){
    this.nome=nome;
    this.endereco=endereco;
    this.telefone=telefone;
  }
  //construtor padrão para objetos criados sem nenhum parâmetro
  public Cliente(){}
}
//Definicao da classe Pedido junto com seus atributos e métodos
class Pedido{
  private boolean Expresso=false;
  private int numero;
  private double preco;
  private GregorianCalendar realizacaoData=new GregorianCalendar();
  private GregorianCalendar entregaData=new GregorianCalendar();
  private Cliente cliente=new Cliente();

  //definicao de gets e sets para a manipulação de atributos
  public void setExpresso(boolean expresso){
    this.Expresso=expresso;
  }
  public boolean getExpresso(){
    return this.Expresso;
  }
  public double getPreco(){
    return this.preco;
  }
  public void setPreco(double preco){
    this.preco=preco;
  }
  public int getNumero(){
    return this.numero;
  }
  public void setNumero(int numero){
    this.numero=numero;
  }
  public void setRealizacaoData(GregorianCalendar temp){
    this.realizacaoData=temp;
  }
  public GregorianCalendar getRealizacaoData(){
    return this.realizacaoData;
  }
  public void setEntregaData(GregorianCalendar temp){
    this.entregaData=temp;
  }
  public GregorianCalendar getEntregaData(){
    return this.entregaData;
  }
  public void setCliente(Cliente cliente){
    this.cliente=cliente;
  }
  public Cliente getCliente(){
    return this.cliente;
  }
  //método que define o objeto criado como um pedido expresso
  public void PedidoExpresso(){
    this.Expresso=true;
    this.preco=this.preco*1.2;
  }
  //método que verifica se o pedido foi entregue dentro do prazo
  public boolean VerificaPrazo(){
    if(this.getEntregaAno()==this.getRealizacaoAno() && this.getEntregaMes()==this.getRealizacaoMes() && this.getEntregaDia()==this.getRealizacaoDia())
      return true;
    else
      return false;
  }
  //gets que serão usados quando for fazer a comparação entre as datas do metodo anterior
  public int getEntregaAno(){
    return this.entregaData.get(Calendar.YEAR);
  }
  public int getEntregaMes(){
    return this.entregaData.get(Calendar.MONTH);
  }
  public int getEntregaDia(){
    return this.entregaData.get(Calendar.DATE);
  }
  public int getRealizacaoAno(){
    return this.realizacaoData.get(Calendar.YEAR);
  }
  public int getRealizacaoMes(){
    return this.realizacaoData.get(Calendar.MONTH);
  }
  public int getRealizacaoDia(){
    return this.realizacaoData.get(Calendar.DATE);
  }
  //construtor que possibilita iniciar a classe Pedido e Cliente de forma simultânea
  public Pedido(double preco,String nome,String endereco,int telefone){
    Cliente aux=new Cliente(nome,endereco,telefone);
    Random numeroAleato= new Random();
    this.numero=numeroAleato.nextInt(1000);
    this.preco=preco;
    this.setCliente(aux);
  }
  //construtor que inicia a classe Pedido usando um preço e Cliente passado por parâmetro
  public Pedido(float preco,Cliente cliente){
    Random numeroAleato= new Random();
    this.numero=numeroAleato.nextInt(1000);
    this.preco=preco;
    this.setCliente(cliente);
  }
  //método retorna uma string que informa se o objeto foi entregue ou não no prazo
  public String toString(){
    if(VerificaPrazo()==true){
      return "Nome: "+this.cliente.getNome()+" Preco: "+this.preco+" Entregue no prazo";
    }else{
      return "Nome: "+this.cliente.getNome()+" Preco: "+this.preco+" Entregue depois do prazo";
    }
  }
}

class Main {
  public static void main(String[] args) {
    //corpo do programa que contém todas as instruções da questão
    Cliente cliente1=new Cliente("Fulano","Rua A",9999);
    Cliente cliente2=new Cliente("Ciclano", "Rua B",8888);
    Pedido pedido1=new Pedido(500, cliente1);
    Pedido pedido2=new Pedido(500, cliente2);
    pedido2.PedidoExpresso();
    System.out.println(pedido1.toString());
    System.out.println(pedido2.toString());
    System.out.println(pedido1.getEntregaDia()+" "+pedido1.getRealizacaoDia());
  }
}

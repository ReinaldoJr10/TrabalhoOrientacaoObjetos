import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

class Cliente{
  private String nome,endereco;
  private int telefone;
  public String getNome(){
    return this.nome;
  }
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
  public Cliente(String nome,String endereco,int telefone){
    this.nome=nome;
    this.endereco=endereco;
    this.telefone=telefone;
  }
  public Cliente(){}
}

class Pedido{
  private boolean Expresso=false;
  private int numero;
  private double preco;
  private GregorianCalendar realizacaoData=new GregorianCalendar();
  private GregorianCalendar entregaData=new GregorianCalendar();
  private Cliente cliente=new Cliente();

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
  public void PedidoExpresso(){
    this.Expresso=true;
    this.preco=this.preco*1.2;
  }
  public boolean VerificaPrazo(){
    if(this.getEntregaAno()==this.getRealizacaoAno() && this.getEntregaMes()==this.getRealizacaoMes() && this.getEntregaDia()==this.getRealizacaoDia())
      return true;
    else
      return false;
  }
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

  public Pedido(double preco,String nome,String endereco,int telefone){
    Cliente aux=new Cliente(nome,endereco,telefone);
    Random numeroAleato= new Random();
    this.numero=numeroAleato.nextInt(1000);
    this.preco=preco;
    this.setCliente(aux);
  }
  public Pedido(float preco,Cliente cliente){
    Random numeroAleato= new Random();
    this.numero=numeroAleato.nextInt(1000);
    this.preco=preco;
    this.setCliente(cliente);
  }

  public void setCliente(Cliente cliente){
    this.cliente=cliente;
  }
  public Cliente getCliente(){
    return this.cliente;
  }
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
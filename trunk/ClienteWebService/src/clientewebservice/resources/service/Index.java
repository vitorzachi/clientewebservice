package clientewebservice.resources.service;

import javax.swing.JOptionPane;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Index{
public static void main(String[] args) throws Exception{


//Endereço, local onde encontra-se o Web Service
String local="http://localhost:8080/axis/Servico.jws";

//Criando e configurando o serviço
Call call = (Call) new Service().createCall();

//Configurando o endereço.
call.setTargetEndpointAddress(local);

//Marcando o método a ser chamado
call.setOperationName("sumMethod");

//Captura os valores das variáveis
int Num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o Primeiro Número"));
int Num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o Segundo Número"));

//Parâmetros da função soma
Object[] param = new Object[]{Num1,Num2};

//Retorno da função
Integer ret = (Integer)call.invoke(param);

//Converte o tipo da variável
String result = Integer.toString(ret);

//lança o resultado na tela
JOptionPane.showMessageDialog(null, result);
}
}

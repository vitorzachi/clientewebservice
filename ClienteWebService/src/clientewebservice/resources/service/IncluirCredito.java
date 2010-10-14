package clientewebservice.resources.service;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 *
 * @author leandro
 */
public class IncluirCredito {

    public IncluirCredito() {
        
    }


    public void Incluir() throws ServiceException, RemoteException {
        //Endereço, local onde encontra-se o Web Service
        String local = "http://localhost:8080/axis/TransacaoWS";

//Criando e configurando o serviço
        Call call = (Call) new Service().createCall();

//Configurando o endereço.
        call.setTargetEndpointAddress(local);

//Marcando o método a ser chamado
        call.setOperationName("incluirCredito");

//Captura os valores das variáveis
        Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id"));
        Integer notFiscal = Integer.parseInt(JOptionPane.showInputDialog("Digite o N. nota fiscal"));
        String serieNotaFiscal = JOptionPane.showInputDialog("Série nota fiscal");
        //   Produtor produtor
        //  Empresa empresaGeradora

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(new Date());
        Float quantidade = Float.parseFloat(JOptionPane.showInputDialog("Quantidade"));
        //  Cereal cereal
        //Parâmetros da função do WebService
        Object[] param = new Object[]{id, notFiscal,serieNotaFiscal,data,quantidade};

//Retorno da função
        Integer ret = (Integer) call.invoke(param);

//Converte o tipo da variável
        String result = Integer.toString(ret);

//lança o resultado na tela
        JOptionPane.showMessageDialog(null, result);
    }
}

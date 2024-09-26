package com.redes.app;

public class EtherCATMaster {

    private EtherCATSlave firstSlave;

    public EtherCATMaster(EtherCATSlave firstSlave) {
        this.firstSlave = firstSlave;
    }

    // Executa o ciclo de comunicação
    public void sendFrame(String initialData) {
        System.out.println("Mestre envia quadro: " + initialData);
        
        // Envia o quadro inicial para o primeiro escravo e recebe o resultado final
        String processedData = firstSlave.processFrame(initialData);
        
        System.out.println("Mestre recebe quadro final: " + processedData + "\n");
    }
}

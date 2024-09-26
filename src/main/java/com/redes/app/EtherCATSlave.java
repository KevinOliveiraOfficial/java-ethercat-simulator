package com.redes.app;

public class EtherCATSlave {

    private String id;
    private EtherCATSlave nextSlave;

    public EtherCATSlave(String id) {
        this.id = id;
    }

    public void setNextSlave(EtherCATSlave nextSlave) {
        this.nextSlave = nextSlave;
    }

    // Processa a solicitação do mestre
    public String processFrame(String frame) {
        System.out.println("Escravo " + id + " processando quadro...");

        // Simulação de processamento: adiciona o ID do escravo aos dados do quadro
        frame = frame + " -> Processado por " + id;

        // Se houver próximo escravo, encaminha o quadro; caso contrário, devolve ao mestre
        if (nextSlave != null) {
            return nextSlave.processFrame(frame);
        } else {
            // Último escravo da cadeia retorna o quadro processado
            return frame;
        }
    }

    public String getId() {
        return id;
    }
}

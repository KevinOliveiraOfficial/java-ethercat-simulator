package com.redes.app;

public class Main {

    public static void main(String[] args)
    {

        // Criar dois escravos EtherCAT
        EtherCATSlave slave1 = new EtherCATSlave("Escravo 1");
        EtherCATSlave slave2 = new EtherCATSlave("Escravo 2");
        EtherCATSlave slave3 = new EtherCATSlave("Escravo 3");

        slave1.setNextSlave(slave2);
        slave2.setNextSlave(slave3);

        // Adicionar escravos ao mestre
        EtherCATMaster master = new EtherCATMaster(slave1);

        // Simulação de envio de quadros (ciclos de comunicação)
        for (int i = 0; i < 3; i++) {
            String frame = "Quadro inicial " + (i + 1);
            master.sendFrame(frame);

            try {
                Thread.sleep(1000);  // Simula um intervalo de tempo entre os ciclos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

package controller;

import model.ModelCurrentBank;
import view.ViewCountCurrentBank;
import view.ViewFunctionBank;

public class ControllerCountCurrentBank {
    ViewCountCurrentBank viewCountCurrentBank = new ViewCountCurrentBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    // Instancia localmente para evitar dependência circular global

    public void displayCountCurrent(ModelCurrentBank modelCurrentBank) {
        int choose = 0;

        // 🔥 O laço DO-WHILE controla o menu sem empilhar memória RAM
        do {
            choose = viewCountCurrentBank.displayCountCurrent(modelCurrentBank);

            switch (choose) {
                case 1:
                    viewCountCurrentBank.displayCountCurrentBalance(modelCurrentBank);
                    // REMOVIDO: displayCountCurrent(modelCurrentBank);
                    break;

                case 2:
                    viewCountCurrentBank.displayCountCurrentExtract(modelCurrentBank);
                    break;

                case 3:
                    // Cria a instância no momento do clique para não dar loop na inicialização das classes
                    ControllerCountCurrentPIX controllerCountCurrentPIX = new ControllerCountCurrentPIX();
                    controllerCountCurrentPIX.startCurrentPix(modelCurrentBank);
                    // Quando o PIX terminar, o laço WHILE automaticamente mostrará o menu de volta!
                    break;

                case 7:
                    viewFunctionBank.displayExitApp();
                    break;

                default:
                    viewFunctionBank.displayChooseError();
                    break;
            }
        } while (choose != 7); // Repete o menu até o usuário digitar 7
    }
}
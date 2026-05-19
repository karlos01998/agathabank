package model;

import java.util.ArrayList;

public class ModelCurrentBank extends ModelBank {
    public ModelCurrentBank(int cpf, String name, int year, int month, int day) {
        super(cpf, name, year, month, day); // Substitua o vazio por isso
    }

    public ModelCurrentBank(int cpf, String name, int year, int month, int day, int password) {
        super(cpf, name, year, month, day); // Inicializa a mãe com os 5 parâmetros
        // Se precisar repassar a senha para a classe mãe e ela tiver um setter:
        this.setPassword(password);
    }

    ArrayList<ModelCurrentBank> currentCount = new ArrayList<>();

    public ModelCurrentBank() {
        super(0, "Sem Nome", 2000, 1, 1); // Valores padrão para não quebrar a regra da mãe
    }

    public boolean getCurrentCountCPF(int cpf) {
        for (ModelCurrentBank currentBank : currentCount) {
            if (currentBank.getNumberCPF() == cpf) {
                return true;
            }
        }
        return false;
    }

    public boolean getCurrentCountPassword(int password) {
        for (ModelCurrentBank currentBank : currentCount) {
            if (currentBank.getPassword() == password) {
                return true;
            }
        }
        return false;
    }
}

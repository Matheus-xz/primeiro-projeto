

public class Metodos {
    private Fila[] fila;
    private int contador;
    private int proximaSenha = 1;
    private int contadorPrioritariosAtendidos = 0;


    public Metodos(int tamanho) {
        fila = new Fila[tamanho];
        contador = 0;
    }

    public int gerarSenha() {
        return proximaSenha++;
    }

    public boolean adicionarCliente(Fila cliente) {
        if (contador >= fila.length) {
            return false;
        }
        fila[contador++] = cliente;
        return true;
    }

    public Fila[] listarFila() {
        Fila[] lista = new Fila[contador];
        for (int i = 0; i < contador; i++) {
            lista[i] = fila[i];
        }
        return lista;
    }

    public Fila proximoCliente() {
    if (contador == 0) {
        return null;
    }
    if (contadorPrioritariosAtendidos < 3) {
        for (int i = 0; i < contador; i++) {
            if (fila[i].isPrioridade()) {
                Fila cliente = fila[i];
                removerClientePorIndice(i);
                contadorPrioritariosAtendidos++;
                return cliente;
            }
        }
        Fila cliente = fila[0];
        removerClientePorIndice(0);
        contadorPrioritariosAtendidos = 0;
        return cliente;
    } else {
        for (int i = 0; i < contador; i++) {
            if (!fila[i].isPrioridade()) {
                Fila cliente = fila[i];
                removerClientePorIndice(i);
                contadorPrioritariosAtendidos = 0;
                return cliente;
            }
        }
        Fila cliente = fila[0];
        removerClientePorIndice(0);
        return cliente;
    }
}

        private void removerClientePorIndice(int i) {
        for (int j = i + 1; j < contador; j++) {
            fila[j - 1] = fila[j];
        }
    fila[--contador] = null;
    }
            public boolean removerClientePorSenha(int senha) {
            for (int i = 0; i < contador; i++) {
            if (fila[i].getSenha() == senha) {
                for (int j = i + 1; j < contador; j++) {
                    fila[j - 1] = fila[j];
                }
                fila[--contador] = null;
                return true;
            }
        }
        return false;
    }
            public Fila espiarProximo() {
        if (contador == 0) {
            return null;
        }
        if (contadorPrioritariosAtendidos < 3) {
            for (int i = 0; i < contador; i++) {
            if (fila[i].isPrioridade()) {
                return fila[i];
            }
        }
        return fila[0];
    } else {
        for (int i = 0; i < contador; i++) {
            if (!fila[i].isPrioridade()) {
                return fila[i];
            }
        }
        return fila[0];
    }
}

}

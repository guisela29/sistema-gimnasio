package model;

public class Maquina {
    // Atributos privados - Encapsulación
    private String nombre;
    private String categoria;
    private boolean funcionando;
    private boolean enUso;
    private int tiempoUsoTotal;
    private String clienteUsandola;
    private double peso;

    // Constructor

    public  Maquina() {}

    public Maquina(String nombre, String categoria, boolean funcionando, boolean enUso, int tiempoUsoTotal, String clienteUsandola, double peso) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.funcionando = funcionando;
        this.enUso = enUso;
        this.tiempoUsoTotal = tiempoUsoTotal;
        this.clienteUsandola = clienteUsandola;
        this.peso = peso;
    }

    //Gettres y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    public int getTiempoUsoTotal() {
        return tiempoUsoTotal;
    }

    public void setTiempoUsoTotal(int tiempoUsoTotal) {
        if (tiempoUsoTotal >= 0) {  // No puede ser negativo
            this.tiempoUsoTotal = tiempoUsoTotal;
        }
    }

    public String getClienteUsandola() {
        return clienteUsandola;
    }

    public void setClienteUsandola(String clienteUsandola) {
        this.clienteUsandola = clienteUsandola;
    }

    public double getPeso() {
        return peso;
    }
    // El peso no  puede ser negativo
    public void setPeso(double peso) {
        if (peso >= 0) {
            this.peso = peso;
        } else {
            System.out.println("El peso no puede ser negativo");
        }
    }
    // Método para iniciar uso de máquina
    public boolean iniciarUso(String nombreCliente) {
        if (funcionando && !enUso) {
            this.enUso = true;
            this.clienteUsandola = nombreCliente;
            System.out.println("Máquina " + nombre + " en uso por " + nombreCliente);
            return true;
        } else if (!funcionando) {
            System.out.println("La máquina " + nombre + " está fuera de servicio");
        } else {
            System.out.println("La máquina " + nombre + " ya está en uso por " + clienteUsandola);
        }
        return false;
    }

    // Método para finalizar uso
    public void finalizarUso(int minutosUsados) {
        if (enUso) {
            this.enUso = false;
            this.tiempoUsoTotal += minutosUsados;
            System.out.println("Uso finalizado. Cliente " + clienteUsandola +
                    " usó la máquina por " + minutosUsados + " minutos");
            this.clienteUsandola = null;
        } else {
            System.out.println("La máquina no estaba en uso");
        }
    }

    // Método para reportar avería
    public void reportarAveria() {
        this.funcionando = false;
        if (enUso) {
            System.out.println("Máquina " + nombre + " fuera de servicio. " +
                    "Cliente " + clienteUsandola + " debe cambiar de máquina");
            this.enUso = false;
            this.clienteUsandola = null;
        }
        System.out.println("Máquina " + nombre + " reportada como averiada");
    }

    // Método para reparar máquina
    public void repararMaquina() {
        this.funcionando = true;
        System.out.println("Máquina " + nombre + " reparada y lista para usar");
    }

    // Método para mostrar estado
    public void mostrarEstado() {
        System.out.println("=== ESTADO DE MÁQUINA ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Funcionando: " + (funcionando ? "SÍ" : "NO - FUERA DE SERVICIO"));
        System.out.println("En uso: " + (enUso ? "SÍ - Por " + clienteUsandola : "NO - DISPONIBLE"));
        System.out.println("Tiempo total de uso: " + tiempoUsoTotal + " minutos");
        if (peso > 0) {
            System.out.println("Peso configurado: " + peso + " kg");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return nombre + " [" + categoria + "] - " +
                (funcionando ? (enUso ? "EN USO" : "DISPONIBLE") : "FUERA DE SERVICIO");
    }

    // Método para verificar disponibilidad
    public boolean estaDisponible() {
        return funcionando && !enUso;
    }
}



package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Instructor extends Persona {
    private String especialidad;
    private double salarioBase;
    private int horasTrabajadas;
    private ArrayList<String> certificaciones;
    private ArrayList<Cliente> clientesAsignados;
    private boolean disponible;

    //
    public Instructor() {
        super();
        this.certificaciones = new ArrayList<>();
        this.clientesAsignados = new ArrayList<>();
        this.disponible = true;
    }

    public Instructor(Long id, String tipoDocumento, String documentoIdentidad, String nombres,
                      String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento,
                      String email, String celular, String especialidad, double salarioBase,
                      int horasTrabajadas, ArrayList<String> certificaciones,
                      ArrayList<Cliente> clientesAsignados, boolean disponible) {
        super(id, tipoDocumento, documentoIdentidad, nombres, apellidoPaterno, apellidoMaterno,
                fechaNacimiento, email, celular);
        this.especialidad= especialidad;
        this.salarioBase=salarioBase;
        this.horasTrabajadas=horasTrabajadas;
        this.certificaciones = certificaciones != null ? certificaciones : new ArrayList<>();
        this.clientesAsignados = clientesAsignados != null ? clientesAsignados : new ArrayList<>();
        this.disponible = disponible;
    }
// getters y setters

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public ArrayList<String> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(ArrayList<String> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public ArrayList<Cliente> getClientesAsignados() {
        return clientesAsignados;
    }

    public void setClientesAsignados(ArrayList<Cliente> clientesAsignados) {
        this.clientesAsignados = clientesAsignados;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL INSTRUCTOR ===");
        System.out.println("Nombre: " + getNombres() + " " + getApellidoPaterno());
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Salario Base: S/ " + salarioBase);
        System.out.println("Horas Trabajadas: " + horasTrabajadas);
        System.out.println("Estado: " + (disponible ? "DISPONIBLE" : "NO DISPONIBLE"));
        System.out.println("Clientes Asignados: " + clientesAsignados.size());
        System.out.println("Certificaciones: " + certificaciones.size());
    }
    // Método para asignar cliente
    public boolean asignarCliente(Cliente cliente) {
        if (disponible && clientesAsignados.size() < 10) { // máximo 10 clientes
            clientesAsignados.add(cliente);
            System.out.println("Cliente " + cliente.getNombres() + " asignado exitosamente");
            return true;
        } else {
            System.out.println("No se puede asignar más clientes");
            return false;
        }
    }

    // Método para remover cliente
    public boolean removerCliente(Long clienteId) {
        for (Cliente cliente : clientesAsignados) {
            if (cliente.getId().equals(clienteId)) {
                clientesAsignados.remove(cliente);
                System.out.println("Cliente removido exitosamente");
                return true;
            }
        }
        System.out.println("Cliente no encontrado");
        return false;
    }

    // Método para agregar certificación
    public void agregarCertificacion(String certificacion) {
        if (!certificaciones.contains(certificacion)) {
            certificaciones.add(certificacion);
            System.out.println("Certificación agregada: " + certificacion);
        } else {
            System.out.println("La certificación ya existe");
        }
    }

    // Método para calcular salario total
    public double calcularSalarioTotal() {
        double bonoPorCliente = clientesAsignados.size() * 50.0; // S/50 por cliente
        return salarioBase + bonoPorCliente;
    }

    // Método para listar clientes
    public void listarClientes() {
        if (clientesAsignados.isEmpty()) {
            System.out.println("No hay clientes asignados");
        } else {
            System.out.println("=== CLIENTES ASIGNADOS ===");
            for (Cliente cliente : clientesAsignados) {
                System.out.println("- " + cliente.toString());
            }
        }
    }

    // Método toString sobrescrito (Polimorfismo)
    @Override
    public String toString() {
        return super.toString() + " [" + especialidad + "]";
    }
}

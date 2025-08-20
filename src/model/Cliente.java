package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente extends Persona {
    private String codigoMembresia;
    private String planSuscripcion;
    private double costoMensual;
    private boolean estadoActivo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int mesesSuscrito;
    private String objetivo;

    // Constructor vacío
    public Cliente() {
        super();
    }
    // Constructor completo
    public Cliente(Long id, String tipoDocumento, String documentoIdentidad, String nombres,
                   String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento,
                   String email, String celular, String codigoMembresia, String planSuscripcion,
                   double costoMensual, boolean estadoActivo, LocalDateTime fechaInicio,
                   LocalDateTime fechaFin, int mesesSuscrito, String objetivo) {
        super(id, tipoDocumento, documentoIdentidad, nombres, apellidoPaterno, apellidoMaterno,
                fechaNacimiento, email, celular);
        this.codigoMembresia = codigoMembresia;
        this.planSuscripcion = planSuscripcion;
        this.costoMensual=costoMensual;
        this.estadoActivo = estadoActivo;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.mesesSuscrito = mesesSuscrito;
        this.objetivo = objetivo;
    }

    //

    public String getCodigoMembresia() {
        return codigoMembresia;
    }

    public void setCodigoMembresia(String codigoMembresia) {
        this.codigoMembresia = codigoMembresia;
    }

    public String getPlanSuscripcion() {
        return planSuscripcion;
    }

    public void setPlanSuscripcion(String planSuscripcion) {
        this.planSuscripcion = planSuscripcion;
    }

    public double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(double costoMensual) {
        this.costoMensual = costoMensual;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getMesesSuscrito() {
        return mesesSuscrito;
    }

    public void setMesesSuscrito(int mesesSuscrito) {
        this.mesesSuscrito = mesesSuscrito;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    // Metodo
    @Override
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL CLIENTE ===");
        System.out.println("Nombre: " + getNombres() + " " + getApellidoPaterno());
        System.out.println("Documento: " + getDocumentoIdentidad());
        System.out.println("Membresía: " + codigoMembresia);
        System.out.println("Plan: " + planSuscripcion);
        System.out.println("Costo: S/ " + costoMensual);
        System.out.println("Estado: " + (estadoActivo ? "ACTIVO" : "INACTIVO"));
        System.out.println("Objetivo: " + objetivo);
    }
    // Método para calcular el costo total
    public double calcularCostoTotal() {
        return costoMensual * mesesSuscrito;
    }

    // Método para verificar si la membresía está vigente
    public boolean esMembresiaVigente() {
        return estadoActivo && fechaFin.isAfter(LocalDateTime.now());
    }

    // Método para renovar membresía
    public void renovarMembresia(int mesesAdicionales) {
        if (estadoActivo) {
            this.fechaFin = this.fechaFin.plusMonths(mesesAdicionales);
            this.mesesSuscrito += mesesAdicionales;
            System.out.println("Membresía renovada por " + mesesAdicionales + " meses");
        } else {
            System.out.println("No se puede renovar una membresía inactiva");
        }
    }

    // Método toString sobrescrito (Polimorfismo)
    @Override
    public String toString() {
        return super.toString() + " [" + codigoMembresia + "]";
    }
}

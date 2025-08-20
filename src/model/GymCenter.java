package model;

import java.util.ArrayList;

public class GymCenter {
    // Atributos del gimnasio
        private String nombreGimnasio;
        private String direccion;
        private ArrayList<Cliente> clientes;
        private ArrayList<Instructor> instructores;
        private ArrayList<Maquina> maquinas;
        private ArrayList<String> planesDisponibles;
        private double ingresosTotales;

        // Constructor
    public GymCenter() {
        this.clientes = new ArrayList<>();
        this.instructores = new ArrayList<>();
        this.maquinas = new ArrayList<>();
        this.planesDisponibles = new ArrayList<>();
        this.ingresosTotales = 0.0;
        inicializarPlanesBasicos();
    }

    public GymCenter(String nombreGimnasio, String direccion, ArrayList<Cliente> clientes, ArrayList<Instructor> instructores, ArrayList<Maquina> maquinas, ArrayList<String> planesDisponibles, double ingresosTotales) {
        this.nombreGimnasio = nombreGimnasio;
        this.direccion = direccion;
        this.clientes = clientes;
        this.instructores = instructores;
        this.maquinas = maquinas;
        this.planesDisponibles = planesDisponibles;
        this.ingresosTotales = ingresosTotales;
    }
    // Getters y Setters


    public String getNombreGimnasio() {
        return nombreGimnasio;
    }

    public void setNombreGimnasio(String nombreGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Instructor> getInstructores() {
        return instructores;
    }

    public void setInstructores(ArrayList<Instructor> instructores) {
        this.instructores = instructores;
    }

    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public ArrayList<String> getPlanesDisponibles() {
        return planesDisponibles;
    }

    public void setPlanesDisponibles(ArrayList<String> planesDisponibles) {
        this.planesDisponibles = planesDisponibles;
    }

    public double getIngresosTotales() {
        return ingresosTotales;
    }

    public void setIngresosTotales(double ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }
    private void inicializarPlanesBasicos() {
        planesDisponibles.add("Básico - S/80");
        planesDisponibles.add("Premium - S/120");
        planesDisponibles.add("VIP - S/180");
        planesDisponibles.add("Estudiante - S/60");
    }
    // Agregar cliente
    public boolean agregarCliente(Cliente cliente) {
        if (cliente != null && !existeCliente(cliente.getId())) {
            clientes.add(cliente);
            ingresosTotales += cliente.getCostoMensual();
            System.out.println("Cliente agregado exitosamente");
            return true;
        }
        System.out.println("Error: Cliente ya existe o datos inválidos");
        return false;
    }

    // Buscar cliente por ID
    public Cliente buscarCliente(Long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    // Verificar si existe cliente
    private boolean existeCliente(Long id) {
        return buscarCliente(id) != null;
    }

    // Eliminar cliente
    public boolean eliminarCliente(Long id) {
        Cliente cliente = buscarCliente(id);
        if (cliente != null) {
            clientes.remove(cliente);
            ingresosTotales -= cliente.getCostoMensual();
            System.out.println("Cliente eliminado exitosamente");
            return true;
        }
        System.out.println("Cliente no encontrado");
        return false;
    }

    // Listar todos los clientes
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            System.out.println("=== LISTA DE CLIENTES ===");
            for (Cliente cliente : clientes) {
                cliente.mostrarInformacion();
                System.out.println("------------------------");
            }
        }
    }
    // Agregar instructor
    public boolean agregarInstructor(Instructor instructor) {
        if (instructor != null && !existeInstructor(instructor.getId())) {
            instructores.add(instructor);
            System.out.println("Instructor agregado exitosamente");
            return true;
        }
        System.out.println("Error: Instructor ya existe o datos inválidos");
        return false;
    }

    // Buscar instructor por ID
    public Instructor buscarInstructor(Long id) {
        for (Instructor instructor : instructores) {
            if (instructor.getId().equals(id)) {
                return instructor;
            }
        }
        return null;
    }

    // Verificar si existe instructor
    private boolean existeInstructor(Long id) {
        return buscarInstructor(id) != null;
    }

    // Listar instructores
    public void listarInstructores() {
        if (instructores.isEmpty()) {
            System.out.println("No hay instructores registrados");
        } else {
            System.out.println("=== LISTA DE INSTRUCTORES ===");
            for (Instructor instructor : instructores) {
                instructor.mostrarInformacion();
                System.out.println("------------------------");
            }
        }
    }
    // Mostrar información del gimnasio
    public void mostrarInformacionGimnasio() {
        System.out.println("=== " + nombreGimnasio + " ===");
        System.out.println("Dirección: " + direccion);
        System.out.println("Total Clientes: " + clientes.size());
        System.out.println("Total Instructores: " + instructores.size());
        System.out.println("Ingresos Totales: S/ " + ingresosTotales);
        System.out.println("Planes Disponibles:");
        for (String plan : planesDisponibles) {
            System.out.println("- " + plan);
        }
    }

    // Asignar cliente a instructor
    public boolean asignarClienteAInstructor(Long clienteId, Long instructorId) {
        Cliente cliente = buscarCliente(clienteId);
        Instructor instructor = buscarInstructor(instructorId);

        if (cliente != null && instructor != null) {
            return instructor.asignarCliente(cliente);
        }
        System.out.println("Cliente o instructor no encontrado");
        return false;
    }

    // Contar clientes activos
    public int contarClientesActivos() {
        int activos = 0;
        for (Cliente cliente : clientes) {
            if (cliente.isEstadoActivo()) {
                activos++;
            }
        }
        return activos;
    }

    // Agregar máquina
    public boolean agregarMaquina(Maquina maquina) {
        if (maquina != null) {
            maquinas.add(maquina);
            System.out.println("Máquina agregada exitosamente");
            return true;
        }
        return false;
    }

    // Buscar máquina por nombre
    public Maquina buscarMaquina(String nombre) {
        for (Maquina maquina : maquinas) {
            if (maquina.getNombre().equalsIgnoreCase(nombre)) {
                return maquina;
            }
        }
        return null;
    }

    // Listar máquinas disponibles
    public void listarMaquinasDisponibles() {
        System.out.println("=== MÁQUINAS DISPONIBLES ===");
        boolean hayDisponibles = false;
        for (Maquina maquina : maquinas) {
            if (maquina.estaDisponible()) {
                System.out.println("- " + maquina.toString());
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay máquinas disponibles");
        }
    }

    // Listar todas las máquinas
    public void listarTodasLasMaquinas() {
        if (maquinas.isEmpty()) {
            System.out.println("No hay máquinas registradas");
        } else {
            System.out.println("=== TODAS LAS MÁQUINAS ===");
            for (Maquina maquina : maquinas) {
                maquina.mostrarEstado();
                System.out.println("------------------------");
            }
        }
    }
    // Buscar cliente
    public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumentoIdentidad().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

    // Buscar instructor
    public Instructor buscarInstructorPorDocumento(String documento) {
        for (Instructor instructor : instructores) {
            if (instructor.getDocumentoIdentidad().equals(documento)) {
                return instructor;
            }
        }
        return null;
    }
    // Buscar máquina por coincidencia parcial (primeras letras)
    public Maquina buscarMaquinaPorCoincidencia(String nombreParcial) {
        for (Maquina maquina : maquinas) {
            if (maquina.getNombre().toLowerCase().startsWith(nombreParcial.toLowerCase())) {
                return maquina;
            }
        }
        return null;
    }

    // Listar todas las máquinas que coincidan
    public ArrayList<Maquina> buscarMaquinasCoincidentes(String nombreParcial) {
        ArrayList<Maquina> coincidencias = new ArrayList<>();
        for (Maquina maquina : maquinas) {
            if (maquina.getNombre().toLowerCase().contains(nombreParcial.toLowerCase())) {
                coincidencias.add(maquina);
            }
        }
        return coincidencias;
    }
}

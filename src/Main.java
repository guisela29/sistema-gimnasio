import model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GymCenter gimnasio = new GymCenter();

    public static void main(String[] args) {
        // Inicializar gimnasio
        gimnasio.setNombreGimnasio("Guiss'Fit Gym");
        gimnasio.setDireccion("Jr. Alcides Carrion, Ayacucho");

        // Datos de prueba
        cargarDatosPrueba();

        System.out.println("🏋️ Bienvenido al Sistema de Gestión de Gimnasio 🏋️");
        System.out.println("=================================================");

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuInstructores();
                    break;
                case 3:
                    menuMaquinas();
                    break;
                case 4:
                    menuReportes();
                    break;
                case 5:
                    gimnasio.mostrarInformacionGimnasio();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar nuestro sistema! 👋");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }

            if (opcion != 0) {
                pausar();
            }

        } while (opcion != 0);

        scanner.close();
    }

    // MENÚ PRINCIPAL
    private static void mostrarMenuPrincipal() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("            MENÚ PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1. 👥 Gestión de Clientes");
        System.out.println("2. 🏃 Gestión de Instructores");
        System.out.println("3. 🏋️ Gestión de Máquinas");
        System.out.println("4. 📊 Reportes y Estadísticas");
        System.out.println("5. 🏢 Información del Gimnasio");
        System.out.println("0. 🚪 Salir");
        System.out.println("=".repeat(50));
    }

    // MENÚ CLIENTES
    private static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("        GESTIÓN DE CLIENTES");
            System.out.println("=".repeat(40));
            System.out.println("1. ➕ Agregar Cliente");
            System.out.println("2. 🔍 Buscar Cliente");
            System.out.println("3. 📋 Listar Todos los Clientes");
            System.out.println("4. ❌ Eliminar Cliente");
            System.out.println("5. 🔄 Renovar Membresía");
            System.out.println("0. ⬅️ Volver al Menú Principal");
            System.out.println("=".repeat(40));

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    gimnasio.listarClientes();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    renovarMembresia();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
            if (opcion != 0) pausar();
        } while (opcion != 0);
    }

    // MENÚ INSTRUCTORES
    private static void menuInstructores() {
        int opcion;
        do {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("      GESTIÓN DE INSTRUCTORES");
            System.out.println("=".repeat(40));
            System.out.println("1. ➕ Agregar Instructor");
            System.out.println("2. 🔍 Buscar Instructor");
            System.out.println("3. 📋 Listar Instructores");
            System.out.println("4. 👥 Asignar Cliente a Instructor");
            System.out.println("5. 📜 Ver Clientes de Instructor");
            System.out.println("0. ⬅️ Volver al Menú Principal");
            System.out.println("=".repeat(40));

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarInstructor();
                    break;
                case 2:
                    buscarInstructor();
                    break;
                case 3:
                    gimnasio.listarInstructores();
                    break;
                case 4:
                    asignarClienteAInstructor();
                    break;
                case 5:
                    verClientesDeInstructor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
            if (opcion != 0) pausar();
        } while (opcion != 0);
    }

    // MENÚ MÁQUINAS
    private static void menuMaquinas() {
        int opcion;
        do {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("       GESTIÓN DE MÁQUINAS");
            System.out.println("=".repeat(40));
            System.out.println("1. ➕ Agregar Máquina");
            System.out.println("2. 🔍 Buscar Máquina");
            System.out.println("3. 📋 Listar Todas las Máquinas");
            System.out.println("4. ✅ Máquinas Disponibles");
            System.out.println("5. 🏃 Iniciar Uso de Máquina");
            System.out.println("6. ⏹️ Finalizar Uso de Máquina");
            System.out.println("7. ⚠️ Reportar Avería");
            System.out.println("0. ⬅️ Volver al Menú Principal");
            System.out.println("=".repeat(40));

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarMaquina();
                    break;
                case 2:
                    buscarMaquina();
                    break;
                case 3:
                    gimnasio.listarTodasLasMaquinas();
                    break;
                case 4:
                    gimnasio.listarMaquinasDisponibles();
                    break;
                case 5:
                    iniciarUsoMaquina();
                    break;
                case 6:
                    finalizarUsoMaquina();
                    break;
                case 7:
                    reportarAveria();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
            if (opcion != 0) pausar();
        } while (opcion != 0);
    }

    // MENÚ REPORTES
    private static void menuReportes() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("      REPORTES Y ESTADÍSTICAS");
        System.out.println("=".repeat(40));

        System.out.println("📊 Total de Clientes: " + gimnasio.getClientes().size());
        System.out.println("✅ Clientes Activos: " + gimnasio.contarClientesActivos());
        System.out.println("🏃 Total de Instructores: " + gimnasio.getInstructores().size());
        System.out.println("🏋️ Total de Máquinas: " + gimnasio.getMaquinas().size());
        System.out.println("💰 Ingresos Totales: S/ " + gimnasio.getIngresosTotales());

        // Máquinas disponibles vs en uso
        int disponibles = 0;
        int enUso = 0;
        for (Maquina maquina : gimnasio.getMaquinas()) {
            if (maquina.estaDisponible()) {
                disponibles++;
            } else if (maquina.isEnUso()) {
                enUso++;
            }
        }
        System.out.println("🟢 Máquinas Disponibles: " + disponibles);
        System.out.println("🔴 Máquinas en Uso: " + enUso);
    }

    // MÉTODOS PARA CLIENTES
    private static void agregarCliente() {
        System.out.println("\n--- AGREGAR NUEVO CLIENTE ---");

        Long id = (long) leerEntero("ID del cliente: ");
        String tipoDoc = leerTexto("Tipo de documento (DNI/CE): ");
        String documento = leerTexto("Número de documento: ");
        String nombres = leerTexto("Nombres: ");
        String apellidoP = leerTexto("Apellido paterno: ");
        String apellidoM = leerTexto("Apellido materno: ");

        System.out.println("Fecha de nacimiento:");
        int dia = leerEntero("Día: ");
        int mes = leerEntero("Mes: ");
        int anio = leerEntero("Año: ");
        LocalDate fechaNac = LocalDate.of(anio, mes, dia);

        String email = leerTexto("Email: ");
        String celular = leerTexto("Celular: ");

        String codigoMembresia = "MEM" + id;

        System.out.println("\nPlanes disponibles:");
        for (int i = 0; i < gimnasio.getPlanesDisponibles().size(); i++) {
            System.out.println((i + 1) + ". " + gimnasio.getPlanesDisponibles().get(i));
        }
        int planIndex = leerEntero("Seleccione plan (1-" + gimnasio.getPlanesDisponibles().size() + "): ") - 1;
        String plan = gimnasio.getPlanesDisponibles().get(planIndex);

        double costo = extraerCostoPlan(plan);
        int meses = leerEntero("Meses de suscripción: ");
        String objetivo = leerTexto("Objetivo del cliente: ");

        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaFin = fechaInicio.plusMonths(meses);

        Cliente cliente = new Cliente(id, tipoDoc, documento, nombres, apellidoP, apellidoM,
                fechaNac, email, celular, codigoMembresia, plan, costo, true,
                fechaInicio, fechaFin, meses, objetivo);

        if (gimnasio.agregarCliente(cliente)) {
            System.out.println("✅ Cliente agregado exitosamente!");
        }
    }

    private static void buscarCliente() {
        String documento = leerTexto("Ingrese documento de identidad del cliente: ");
        Cliente cliente = gimnasio.buscarClientePorDocumento(documento);

        if (cliente != null) {
            cliente.mostrarInformacion();
        } else {
            System.out.println("❌ Cliente no encontrado.");
        }
    }

    private static void eliminarCliente() {
        String documento = leerTexto("Ingrese documento del cliente a eliminar: ");
        Cliente cliente = gimnasio.buscarClientePorDocumento(documento);

        if (cliente != null) {
            if (gimnasio.eliminarCliente(cliente.getId())) {
                System.out.println("✅ Cliente eliminado exitosamente!");
            }
        } else {
            System.out.println("❌ Cliente no encontrado.");
        }
    }

    private static void renovarMembresia() {
        String documento = leerTexto("Ingrese documento del cliente: ");
        Cliente cliente = gimnasio.buscarClientePorDocumento(documento);

        if (cliente != null) {
            int mesesAdicionales = leerEntero("Meses adicionales: ");
            cliente.renovarMembresia(mesesAdicionales);
        } else {
            System.out.println("❌ Cliente no encontrado.");
        }
    }

    // MÉTODOS PARA INSTRUCTORES
    private static void agregarInstructor() {
        System.out.println("\n--- AGREGAR NUEVO INSTRUCTOR ---");

        Long id = (long) leerEntero("ID del instructor: ");
        String tipoDoc = leerTexto("Tipo de documento: ");
        String documento = leerTexto("Número de documento: ");
        String nombres = leerTexto("Nombres: ");
        String apellidoP = leerTexto("Apellido paterno: ");
        String apellidoM = leerTexto("Apellido materno: ");

        System.out.println("Fecha de nacimiento:");
        int dia = leerEntero("Día: ");
        int mes = leerEntero("Mes: ");
        int anio = leerEntero("Año: ");
        LocalDate fechaNac = LocalDate.of(anio, mes, dia);

        String email = leerTexto("Email: ");
        String celular = leerTexto("Celular: ");
        String especialidad = leerTexto("Especialidad: ");
        double salario = leerDouble("Salario base: ");
        int horas = leerEntero("Horas trabajadas: ");

        Instructor instructor = new Instructor(id, tipoDoc, documento, nombres, apellidoP, apellidoM,
                fechaNac, email, celular, especialidad, salario, horas,
                new ArrayList<>(), new ArrayList<>(), true);

        if (gimnasio.agregarInstructor(instructor)) {
            System.out.println("✅ Instructor agregado exitosamente!");
        }
    }

    private static void buscarInstructor() {
        String documento = leerTexto("Ingrese documento del instructor: ");
        Instructor instructor = gimnasio.buscarInstructorPorDocumento(documento);

        if (instructor != null) {
            instructor.mostrarInformacion();
        } else {
            System.out.println("❌ Instructor no encontrado.");
        }
    }

    private static void asignarClienteAInstructor() {
        String documentoCliente = leerTexto("Documento del cliente: ");
        String documentoInstructor = leerTexto("Documento del instructor: ");

        Cliente cliente = gimnasio.buscarClientePorDocumento(documentoCliente);
        Instructor instructor = gimnasio.buscarInstructorPorDocumento(documentoInstructor);

        if (cliente != null && instructor != null) {
            if (gimnasio.asignarClienteAInstructor(cliente.getId(), instructor.getId())) {
                System.out.println("✅ Cliente asignado exitosamente!");
            }
        } else {
            if (cliente == null) System.out.println("❌ Cliente no encontrado.");
            if (instructor == null) System.out.println("❌ Instructor no encontrado.");
        }
    }

    private static void verClientesDeInstructor() {
        String documento = leerTexto("Ingrese documento del instructor: ");
        Instructor instructor = gimnasio.buscarInstructorPorDocumento(documento);

        if (instructor != null) {
            instructor.listarClientes();
        } else {
            System.out.println("❌ Instructor no encontrado.");
        }
    }

    // MÉTODOS PARA MÁQUINAS - CON BÚSQUEDA DINÁMICA
    private static void agregarMaquina() {
        System.out.println("\n--- AGREGAR NUEVA MÁQUINA ---");

        String nombre = leerTexto("Nombre de la máquina: ");
        String categoria = leerTexto("Categoría (Cardio/Fuerza/Funcional): ");
        double peso = leerDouble("Peso (kg) - opcional, 0 si no aplica: ");

        Maquina maquina = new Maquina(nombre, categoria, true, false, 0, null, peso);

        if (gimnasio.agregarMaquina(maquina)) {
            System.out.println("✅ Máquina agregada exitosamente!");
        }
    }

    private static void buscarMaquina() {
        String nombreParcial = leerTexto("Ingrese nombre o primeras letras de la máquina: ");

        // Buscar coincidencias múltiples primero
        ArrayList<Maquina> coincidencias = gimnasio.buscarMaquinasCoincidentes(nombreParcial);

        if (coincidencias.isEmpty()) {
            System.out.println("❌ No se encontraron máquinas con ese nombre.");
            System.out.println("💡 Intente con las primeras letras (ej: 'Cint' para Cinta de Correr)");
            return;
        }

        if (coincidencias.size() == 1) {
            // Solo una coincidencia, mostrar directamente
            System.out.println("✅ Máquina encontrada:");
            coincidencias.get(0).mostrarEstado();
        } else {
            // Múltiples coincidencias, mostrar opciones
            System.out.println("🔍 Se encontraron " + coincidencias.size() + " máquinas:");
            for (int i = 0; i < coincidencias.size(); i++) {
                System.out.println((i + 1) + ". " + coincidencias.get(i).toString());
            }

            int seleccion = leerEntero("Seleccione una máquina (1-" + coincidencias.size() + "): ");
            if (seleccion >= 1 && seleccion <= coincidencias.size()) {
                System.out.println("✅ Información de la máquina seleccionada:");
                coincidencias.get(seleccion - 1).mostrarEstado();
            } else {
                System.out.println("❌ Selección inválida.");
            }
        }
    }

    private static void iniciarUsoMaquina() {
        String nombreParcial = leerTexto("Ingrese nombre o primeras letras de la máquina: ");
        Maquina maquina = gimnasio.buscarMaquinaPorCoincidencia(nombreParcial);

        if (maquina != null) {
            System.out.println("✅ Máquina encontrada: " + maquina.getNombre());

            String dniCliente = leerTexto("DNI del cliente: ");
            Cliente cliente = gimnasio.buscarClientePorDocumento(dniCliente);

            if (cliente != null) {
                String nombreCompleto = cliente.getNombres() + " " + cliente.getApellidoPaterno();
                maquina.iniciarUso(nombreCompleto);
                System.out.println("🏃 Cliente: " + nombreCompleto + " (" + dniCliente + ")");
            } else {
                System.out.println("❌ Cliente con DNI " + dniCliente + " no encontrado.");
                System.out.println("💡 Verifique que el cliente esté registrado en el sistema.");
            }
        } else {
            System.out.println("❌ Máquina no encontrada.");
            System.out.println("💡 Intente con las primeras letras (ej: 'Cint' para Cinta de Correr)");
        }
    }

    private static void finalizarUsoMaquina() {
        String nombreParcial = leerTexto("Ingrese nombre o primeras letras de la máquina: ");
        Maquina maquina = gimnasio.buscarMaquinaPorCoincidencia(nombreParcial);

        if (maquina != null) {
            System.out.println("✅ Máquina encontrada: " + maquina.getNombre());
            int minutos = leerEntero("Minutos de uso: ");
            maquina.finalizarUso(minutos);
        } else {
            System.out.println("❌ Máquina no encontrada.");
            System.out.println("💡 Intente con las primeras letras (ej: 'Cint' para Cinta de Correr)");
        }
    }

    private static void reportarAveria() {
        String nombreParcial = leerTexto("Ingrese nombre o primeras letras de la máquina: ");
        Maquina maquina = gimnasio.buscarMaquinaPorCoincidencia(nombreParcial);

        if (maquina != null) {
            System.out.println("✅ Máquina encontrada: " + maquina.getNombre());
            maquina.reportarAveria();
        } else {
            System.out.println("❌ Máquina no encontrada.");
            System.out.println("💡 Intente con las primeras letras (ej: 'Cint' para Cinta de Correr)");
        }
    }

    // MÉTODOS AUXILIARES
    private static void cargarDatosPrueba() {
        // ===== CLIENTES DE PRUEBA =====
        Cliente cliente1 = new Cliente(1L, "DNI", "66666666", "Juan", "Pérez", "García",
                LocalDate.of(1990, 5, 15), "juan@email.com", "987654321",
                "MEM001", "Premium - S/120", 120.0, true,
                LocalDateTime.now(), LocalDateTime.now().plusMonths(3), 3, "Perder peso");
        gimnasio.agregarCliente(cliente1);

        Cliente cliente2 = new Cliente(2L, "DNI", "23456789", "Ana", "Martínez", "Silva",
                LocalDate.of(1995, 3, 22), "ana@email.com", "976543210",
                "MEM002", "Básico - S/80", 80.0, true,
                LocalDateTime.now(), LocalDateTime.now().plusMonths(1), 1, "Ganar masa muscular");
        gimnasio.agregarCliente(cliente2);

        Cliente cliente3 = new Cliente(3L, "DNI", "34567890", "Carlos", "Rodríguez", "Torres",
                LocalDate.of(1988, 11, 8), "carlos@email.com", "965432109",
                "MEM003", "Estudiante - S/60", 60.0, true,
                LocalDateTime.now(), LocalDateTime.now().plusMonths(6), 6, "Mejorar resistencia");
        gimnasio.agregarCliente(cliente3);

        Cliente cliente4 = new Cliente(4L, "DNI", "45678901", "Lucía", "Fernández", "Morales",
                LocalDate.of(1992, 7, 30), "lucia@email.com", "954321098",
                "MEM004", "Premium - S/120", 120.0, false,
                LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(10).plusMonths(3), 3, "Tonificar cuerpo");
        gimnasio.agregarCliente(cliente4);

        Cliente cliente5 = new Cliente(5L, "DNI", "56789012", "Miguel", "González", "Vargas",
                LocalDate.of(1985, 12, 12), "miguel@email.com", "943210987",
                "MEM005", "Básico - S/80", 80.0, true,
                LocalDateTime.now(), LocalDateTime.now().plusMonths(2), 2, "Mantener forma física");
        gimnasio.agregarCliente(cliente5);

        // ===== INSTRUCTORES DE PRUEBA =====
        Instructor instructor1 = new Instructor(1L, "DNI", "87654321", "María", "López", "Ruiz",
                LocalDate.of(1985, 8, 20), "maria@email.com", "912345678",
                "Entrenamiento Funcional", 2500.0, 40, new ArrayList<>(), new ArrayList<>(), true);
        gimnasio.agregarInstructor(instructor1);

        Instructor instructor2 = new Instructor(2L, "DNI", "78901234", "Roberto", "Sánchez", "Castro",
                LocalDate.of(1982, 4, 14), "roberto@email.com", "901234567",
                "Musculación y Fuerza", 2800.0, 45, new ArrayList<>(), new ArrayList<>(), true);
        gimnasio.agregarInstructor(instructor2);

        Instructor instructor3 = new Instructor(3L, "DNI", "89012345", "Carmen", "Jiménez", "Herrera",
                LocalDate.of(1990, 9, 3), "carmen@email.com", "890123456",
                "Yoga y Pilates", 2200.0, 35, new ArrayList<>(), new ArrayList<>(), true);
        gimnasio.agregarInstructor(instructor3);

        Instructor instructor4 = new Instructor(4L, "DNI", "90123456", "Diego", "Ramírez", "Ortega",
                LocalDate.of(1987, 1, 25), "diego@email.com", "879012345",
                "Crossfit", 2600.0, 42, new ArrayList<>(), new ArrayList<>(), false);
        gimnasio.agregarInstructor(instructor4);

        Instructor instructor5 = new Instructor(5L, "DNI", "01234567", "Elena", "Torres", "Mendoza",
                LocalDate.of(1993, 6, 18), "elena@email.com", "868901234",
                "Cardio y Spinning", 2300.0, 38, new ArrayList<>(), new ArrayList<>(), true);
        gimnasio.agregarInstructor(instructor5);

        // ===== MÁQUINAS DE PRUEBA =====
        gimnasio.agregarMaquina(new Maquina("Cinta de Correr 1", "Cardio", true, false, 0, null, 0));
        gimnasio.agregarMaquina(new Maquina("Press de Banca", "Fuerza", true, false, 0, null, 100));
        gimnasio.agregarMaquina(new Maquina("Bicicleta Estática 1", "Cardio", true, false, 0, null, 0));
        gimnasio.agregarMaquina(new Maquina("Máquina de Remo", "Cardio", true, false, 0, null, 0));
        gimnasio.agregarMaquina(new Maquina("Prensa de Piernas", "Fuerza", true, false, 0, null, 150));
    }

    private static double extraerCostoPlan(String plan) {
        // Extrae el costo del string "Plan - S/XX"
        String[] partes = plan.split("S/");
        return Double.parseDouble(partes[1]);
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Ingrese un número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("❌ Ingrese un número válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private static void pausar() {
        System.out.print("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
}
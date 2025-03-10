package com.lukalopez.lib;

public class Random {

    public enum Generar{
        NOMBRES, APELLIDOS, MARCAS, CORREOS, TELEFONOS
    }

    private final static String[] nombres = new String[]{"Lucas", "Mateo", "Sofía", "Valentina", "Diego", "Andrés", "Camila", "Sebastián", "Martina", "Emilia", "Javier", "Alejandro", "Mariana", "Isabella", "Samuel", "Tomás", "Gabriela", "Fernando", "Lucía", "Daniel", "Carlos", "Adriana", "Elena", "Hugo", "Pablo", "Andrea", "Marcos", "Raúl", "Paula", "Joaquín", "Clara", "Iván", "Ricardo", "Manuel", "Victoria", "Gabriel", "Nicolás", "Carmen", "Esteban", "Beatriz", "Julia", "Roberto", "Cristina", "Alberto", "Eduardo", "Rafael", "Álvaro", "Silvia", "Francisco", "Lorena"};
    private final static String[] apellidos = new String[]{"García", "Fernández", "González", "Rodríguez", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Díaz", "Vásquez", "Torres", "Ramírez", "Cruz", "Ortiz", "Morales", "Ruiz", "Hernández", "Jiménez", "Castro", "Rojas", "Navarro", "Delgado", "Mendoza", "Álvarez", "Romero", "Iglesias", "Silva", "Reyes", "Guerrero", "Ríos", "Suárez", "Molina", "Aguilar", "Núñez", "Herrera", "Cortés", "Paredes", "Soto", "Espinoza", "Chávez", "Peña", "Montes", "León", "Cabrera", "Campos", "Lara", "Salazar", "Ramos", "Miranda", "Vega", "Rosales", "Fuentes", "Bravo", "Villarreal", "Acosta", "Valencia", "Mejía", "Pacheco", "Valdez", "Figueroa", "Carrillo", "Escobar", "Peralta", "Solís", "Bermúdez", "Maldonado", "Orozco", "Estrada", "Tapia", "Palacios", "Serna", "Cordero", "Bautista", "Velázquez", "Padilla", "Zamora", "Cuevas", "Correa", "Huerta", "Salinas", "Arroyo", "Estévez", "Ponce", "Medina", "Quintero", "Vargas", "Barrera", "Villanueva", "Macías", "Beltrán", "Serrano", "Galarza", "Del Valle", "Izquierdo", "Cedillo", "Bustamante", "Calderón", "Arellano", "Sandoval"};
    private final static String[] marcas = new String[]{"Apple", "Samsung", "Sony", "Microsoft", "Google", "Amazon", "Tesla", "Nike", "Adidas", "Puma", "Honda", "Toyota", "Ford", "Chevrolet", "BMW", "Mercedes-Benz", "Audi", "Lamborghini", "Ferrari", "Porsche", "Coca-Cola", "Pepsi", "Nestlé", "Unilever", "Procter & Gamble", "McDonald's", "Burger King", "KFC", "Starbucks", "Domino's", "Netflix", "Disney", "HBO", "Paramount", "Spotify", "PlayStation", "Xbox", "Nintendo", "Intel", "AMD", "NVIDIA", "Dell", "HP", "Lenovo", "Huawei", "Xiaomi", "OnePlus", "Asus", "Razer", "Logitech"};
    private final static String[] correos = new String[]{"usuario1@gmail.com", "test123@yahoo.com", "ejemplo@outlook.com", "random_user@hotmail.com", "persona01@mail.com", "juan.perez@gmail.com", "maria.lopez@yahoo.es", "carlos123@outlook.com", "sofia.garcia@live.com", "test.email@example.com", "developer.dev@gmail.com", "admin@company.com", "contacto@empresa.com", "soporte@techsupport.com", "info@website.org", "marketing@business.net", "ventas@store.com", "empleado001@corporate.com", "freelancer@workplace.com", "personal.mail@webmail.com", "notificaciones@service.com", "alerts@security.net", "noreply@system.org", "reservas@hotel.com", "pedidos@shop.com", "cliente01@ecommerce.com", "envios@logistics.net", "estudiante2024@university.edu", "profesor@faculty.edu", "admin@school.edu", "usuario.demo@test.com", "project.manager@startup.com", "ceo@company.co", "developer@opensource.org", "techlead@innovation.net", "anonymous@anonymous.com", "beta.tester@testing.org", "robot@ai.net", "support.agent@helpdesk.com", "it.admin@network.net", "analyst@data.com", "research@science.org", "finance@banking.com", "hr@humanresources.net", "jobs@careers.org", "music.lover@streaming.com", "gamer@esports.net", "travel@explorer.com", "movie.fan@cinema.org", "reader@library.net"};
    private final static String[] telefonos = new String[]{"612345678", "698765432", "654321987", "689123456", "677889900", "634567890", "622334455", "699112233", "678999111", "645556677", "663344556", "612223344", "657890123", "676543210", "644123789", "633222111", "655678999", "611987654", "690123456", "688777666", "644555888", "677666555", "699444333", "655222999", "622555111", "633666888", "611444777", "688999555", "644123987", "678333222", "622999888", "677555444", "655123456", "690987654", "699777111", "633999222", "644666555", "622888999", "655333111", "677123789", "688456123", "611678999", "690222333", "633111444", "699987321", "655789456", "644321654", "622567890", "677654321", "688321987"};

    private static final java.util.Random random = new java.util.Random();

    /**
     * Generar un 'double' de forma aleatoria.
     * @param minimo Valor mínimo que puede valer.
     * @param maximo Valor máximo que puede valer.
     * @return Devuelve el 'double' randomizado dentro del rango.
     */
    public static double randomDouble(double minimo, double maximo){
        return random.nextDouble()*(maximo-minimo)+minimo;
    }

    /**
     * Generar un 'int' de forma aleatoria.
     * @param minimo Valor mínimo que puede valer.
     * @param maximo Valor máximo que puede valer.
     * @return Devuelve el 'int' randomizado dentro del rango.
     */
    public static int randomInt(int minimo, int maximo) {
        return random.nextInt(maximo - minimo + 1) + minimo;
    }

    /**
     * Generar un dato aleatorio tipo 'Generar'.
     * @param dato Es el tipo de dato que se desea randomizar.
     * @return Devuelve el dato aleatorio.
     */
    public static String randomDato(Generar dato){
        switch (dato){
            case NOMBRES -> {
                return nombres[randomInt(0,nombres.length-1)];
            }
            case APELLIDOS -> {
                return apellidos[randomInt(0,apellidos.length-1)];
            }
            case MARCAS -> {
                return marcas[randomInt(0,apellidos.length-1)];
            }
            case CORREOS -> {
                return correos[randomInt(0, correos.length)-1];
            }
            case TELEFONOS -> {
                return telefonos[randomInt(0, telefonos.length)-1];
            }
        }
        return null;
    }
}

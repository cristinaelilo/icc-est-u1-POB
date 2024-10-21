import views.View;
import controllers.*;

public class App {
    public static void main(String[] args) {
        // Crear la vista
        View vista = new View();

        // Crear clases con los métodos de ordenamiento y búsqueda
        SortingMethods sortingMethods = new SortingMethods();
        SearchMethods searchMethods = new SearchMethods();

        // Controlador
        Controller controller = new Controller(vista, sortingMethods, searchMethods);

        // Iniciar la aplicación
        controller.start();
    }
}

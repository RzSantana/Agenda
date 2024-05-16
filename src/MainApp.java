public class MainApp {
    public static void main(String[] args) {
        try {
            Agenda app = new Agenda();
            app.setVisible(true);

        } catch (Exception exception) {
            System.out.println("[ERROR] No se ha podido ejecutar correctamente la aplicación.");
        }
    }
}

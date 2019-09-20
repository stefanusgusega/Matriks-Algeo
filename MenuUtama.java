class MenuUtama {
    public static void main (String[] args) {
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        clearScreen();
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();

    }
}
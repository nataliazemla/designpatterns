public class SupaDatabase { 

    private SupaDatabase() {
        // Private constructor to prevent instantiation
    }

    /* Java loads static classes lazily (only when needed)
    * new SupaDatabaseHolder() is not called until getInstance() is called
    * also it is called only once during loading of the class
    * in antother place getInstance() is called SupaBaseHolder is already loaded
    */
    private static class SupaDatabaseHolder {
        private static final SupaDatabase INSTANCE = new SupaDatabase();
    }

    public static SupaDatabase getInstance() {
        return SupaDatabaseHolder.INSTANCE;
    }

    // Other methods for database operations can be added here
}
class SupaDatabase private constructor() { // no one can create an instance directly

    init { // runs only once
        // Initialize the database connection or any other setup
    }

    companion object {
        @Volatile // ensures visibility of changes to the instance across threads
        private var instance: SupaDatabase? = null

        fun getInstance(): SupaDatabase {
            return instance ?: synchronized(this) { // makes it thread-safe during creation
                instance ?: SupaDatabase().also { instance = it }
            }
        }
    }
}
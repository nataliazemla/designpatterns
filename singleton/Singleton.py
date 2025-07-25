class SupaDatabaseMeta(type):
    _instances = {}
    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            instance = super().__call__(*args, **kwargs)
            cls._instances[cls] = instance
        return cls._instances[cls]
    
class SupaDatabase(metaclass=SupaDatabaseMeta):
    def __init__(self, db_url):
        self.db_url = db_url
        self.connection = None
namespace _26_Manejo_Datos {

    class Globals {

        private static string? _sessionId = null, _sessionName = null;
        private static bool _sessionStatus = false;

        public static string sessionId {
            get => _sessionId;
            set => _sessionId = value;
        }
        
        public static string sessionName {
            get => _sessionName;
            set => _sessionName = value;
        }

        public static bool sessionStatus {
            get => _sessionStatus;
            set => _sessionStatus = value;
        }
    }
}
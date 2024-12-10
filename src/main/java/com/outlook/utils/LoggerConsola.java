package com.outlook.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerConsola {

    // Instancia de SLF4J Logger para el registro de mensajes
    private static final Logger logger = LoggerFactory.getLogger(LoggerConsola.class);

    /*
     * @LoggerConsola
     */
    /**
     * Constructor privado para prevenir instancias de esta clase utilidad.
     * Lanza una excepción IllegalStateException si se intenta instanciar la clase.
     */
    private LoggerConsola() {
        throw new IllegalStateException("Utility class");
    }

    /*
     * @imprimirInformacionLogger
     *
    /**
     * Registra un mensaje informativo.
     * Este método registra un mensaje a nivel INFO usando el registrador SLF4J.
     *
     * @param mensaje el mensaje para ser registrado
     */
    public static void imprimirInformacionLogger(String mensaje){
        logger.info(mensaje);
    }

    /*
     * @imprimirInformacionLogger
     *
     */
    /**
     * Registra un mensaje informativo con parámetros opcionales.
     * Este método registra un mensaje a nivel INFO usando el registrador SLF4J,
     * permitiendo adoptar mensajes parametrizados.
     *
     * @param mensaje el mensaje para ser registrado
     * @param params  parámetros opcionales para ser incluidos en el mensaje
     */
    public static void imprimirInformacionLogger(String mensaje, Object... params){
        logger.info(mensaje, params);
    }

}

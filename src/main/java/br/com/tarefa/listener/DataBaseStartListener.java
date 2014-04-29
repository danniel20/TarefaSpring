package br.com.tarefa.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.hsqldb.server.Server;
import org.springframework.web.WebApplicationInitializer;

public class DataBaseStartListener implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext arg0) throws ServletException {
        Server hsqlServer = new Server();
        hsqlServer.setDatabaseName(0, "tarefa");
        hsqlServer.setDatabasePath(0, "file:target/data/tarefa");
        hsqlServer.setLogWriter(null);
        hsqlServer.setSilent(true);
        hsqlServer.start();
    }
}

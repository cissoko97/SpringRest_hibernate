package org.centaurus.app;

import org.apache.catalina.LifecycleException;
import org.centaurus.app.config.appserverconfig.IAppServer;
import org.centaurus.app.config.appserverconfig.appserver.TomcatServer;

import javax.servlet.ServletException;

public class Main {

    public static void main(String[] args) throws ServletException, LifecycleException {

        IAppServer tomcatServer = new TomcatServer();

        tomcatServer.create();
        tomcatServer.configure();
        tomcatServer.start();
    }
}

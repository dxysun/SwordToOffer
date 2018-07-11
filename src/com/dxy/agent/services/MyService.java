package com.dxy.agent.services;


import myTest.rmi.Params;

import java.rmi.Remote;

public interface MyService  extends Remote {
    int getHashResult(Params params) throws Exception;
}

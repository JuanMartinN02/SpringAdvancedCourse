package com.jcmn.Section7GettingStarted;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperMarioGameQualifier")
public class SuperMario extends Game{
    public SuperMario() {
        super("Switch 2", "Super Mario");
    }
}

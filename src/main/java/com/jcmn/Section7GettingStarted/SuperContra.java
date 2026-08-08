package com.jcmn.Section7GettingStarted;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// Making it the primary component for Game Subclass in case there are many (like SuperMario)
// @Primary
public class SuperContra extends Game{
    public SuperContra() {
        super("PS5", "Super Contra");
    }
}

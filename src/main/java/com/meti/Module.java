package com.meti;

public abstract class Module {
    private final String name;

    public Module(String name){
        this.name = name;

        ModuleRegistry.put(getClass(), this);
    }

    public String getName() {
        return name;
    }

    public abstract void openDisplay();
    public abstract Library getLibrary();
}

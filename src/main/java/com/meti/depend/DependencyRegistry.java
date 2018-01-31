package com.meti.depend;

import javafx.scene.control.ListView;

import java.util.HashSet;
import java.util.Set;

public class DependencyRegistry {
    private final Set<Dependency> dependencies = new HashSet<>();
    private final ListView<String> dependencyView;

    public DependencyRegistry(ListView<String> dependencyView) {
        this.dependencyView = dependencyView;
    }

    public boolean add(Dependency dependency){
        if (dependency != null) {
            dependencies.add(dependency);
            dependencyView.getItems().add(dependency.toString());
            return true;
        }
        else{
            return false;
        }
    }

    public boolean remove(Dependency dependency){
        if(dependency != null){
            dependencies.remove(dependency);
            return dependencyView.getItems().remove(dependency);
        }
        return false;
    }

    public boolean clear(){
        if(dependencies.isEmpty()){
            return false;
        }
        else{
            dependencies.clear();
            dependencyView.getItems().clear();
            return true;
        }
    }
}
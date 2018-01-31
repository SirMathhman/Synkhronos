package com.meti.depend;

public class Dependency {
    private final String type;
    private final String name;

    public Dependency(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dependency that = (Dependency) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

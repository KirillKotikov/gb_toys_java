package ru.kotikov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Toy implements Comparable<Toy>{
    private long id;
    private String name;

    @Override
    public String toString() {
        return id + " " + name + "\n";
    }

    @Override
    public int compareTo(Toy o) {
        if (o.getId() > getId()) return -1;
        else if (o.getId() < getId()) return 1;
        return 0;
    }
}

package edu.testing.part2_hashing;

import java.util.Objects;

import static edu.testing.part2_hashing.Node.NodesState.*;

public class Node<K> {
    private NodesState nodesState;

    private K value;

    public static enum NodesState {
        EMPTY,
        DELETED,
        PRESENT
    };

    public Node() {
        this.nodesState = EMPTY;
        this.value = null;
    }

    public Node(K value) {
        if (Objects.equals(value, null)) {
            this.nodesState = EMPTY;
        } else {
            this.nodesState = PRESENT;
        }
        this.value = value;
    }

    public K getValue() {
        return value;
    }

    public NodesState getNodesState() {
        return nodesState;
    }

    public void setValue(K value) {
        if (Objects.equals(value, null)) {
            this.nodesState = DELETED;
        } else {
            this.nodesState = PRESENT;
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodesState=" + nodesState +
                ", value=" + value +
                "}";
    }
}

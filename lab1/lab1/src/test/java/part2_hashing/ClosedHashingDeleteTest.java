package part2_hashing;

import edu.testing.part2_hashing.ClosedHashingTable;
import edu.testing.part2_hashing.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClosedHashingDeleteTest {
    protected final static int tableSize = 29;

    @Test
    public void testDeleteKeysWithLinearProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getLinearProbing());
        table.insert(15);
        table.insert(15);
        table.insert(16);
        table.delete(15);
        Assertions.assertEquals(table.getTable().get(15).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(15).getValue());
        table.insert(15);
        Assertions.assertEquals(table.getTable().get(15).getValue(), 15);
        table.delete(16);
        Assertions.assertEquals(table.getTable().get(16).getValue(), 15);
        Assertions.assertEquals(table.getTable().get(16).getNodesState(), Node.NodesState.PRESENT);
        Assertions.assertEquals(table.getTable().get(17).getNodesState(), Node.NodesState.DELETED);
    }

    @Test
    public void testDeleteKeysWithQuadraticProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getQuadraticProbing());
        table.insert(15);
        table.insert(15);
        table.insert(15);
        table.insert(19);
        table.delete(15);
        Assertions.assertEquals(table.getTable().get(15).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(15).getValue());
        table.delete(15);
        Assertions.assertEquals(table.getTable().get(15).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(15).getValue());
        Assertions.assertEquals(table.getTable().get(16).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(16).getValue());
        table.delete(15);
        Assertions.assertEquals(table.getTable().get(19).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(19).getValue());
        table.delete(19);
        Assertions.assertEquals(table.getTable().get(19).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(19).getValue());
        Assertions.assertEquals(table.getTable().get(20).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(20).getValue());
    }

    @Test
    public void testDeleteKeysWithDoubleProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getDoubleProbing(ClosedHashingTable.sampleHash2()));
        table.insert(11);
        table.insert(11);
        table.insert(11);
        table.delete(11);
        Assertions.assertEquals(table.getTable().get(11).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(11).getValue());
        table.delete(11);
        Assertions.assertEquals(table.getTable().get(11).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(11).getValue());
        Assertions.assertEquals(table.getTable().get(14).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(14).getValue());
        table.delete(11);
        Assertions.assertEquals(table.getTable().get(11).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(11).getValue());
        Assertions.assertEquals(table.getTable().get(14).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(14).getValue());
        Assertions.assertEquals(table.getTable().get(17).getNodesState(), Node.NodesState.DELETED);
        Assertions.assertNull(table.getTable().get(17).getValue());
    }
}

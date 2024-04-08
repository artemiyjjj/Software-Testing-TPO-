package part2_hashing;

import edu.testing.part2_hashing.ClosedHashingTable;
import edu.testing.part2_hashing.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClosedHashingCreationTest {

    @Test
    public void testCreateClosedHashTable() {
        int tableSize = 29;
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getLinearProbing());
        var tableContents = table.getTable();
        for (int i = 0; i < table.getTableSize(); i++) {
            var node = tableContents.get(i);
            Assertions.assertNull(node.getValue());
            Assertions.assertEquals(node.getNodesState(), Node.NodesState.EMPTY);
        }
    }
}

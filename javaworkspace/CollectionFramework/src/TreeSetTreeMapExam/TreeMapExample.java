package TreeSetTreeMapExam;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		// TreeMap �÷��� ����
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		// ��Ʈ�� ����
		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 80);
		treeMap.put("base", 20);
		treeMap.put("guess", 70);
		treeMap.put("cherry", 30);

		// ���ĵ� ��Ʈ���� �ϳ��� ��������
		Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		System.out.println();

		// Ư�� Ű�� ���� �� ��������
		Entry<String, Integer> entry = null;
		entry = treeMap.firstEntry();
		System.out.println("���� �� �ܾ�: " + entry.getKey() + "-" + entry.getValue());

		entry = treeMap.lastEntry();
		System.out.println("���� �� �ܾ�: " + entry.getKey() + "-" + entry.getValue());

		entry = treeMap.lowerEntry("ever");
		System.out.println("ever �� �ܾ�: " + entry.getKey() + "-" + entry.getValue());

		entry = treeMap.lowerEntry("ever");
		System.out.println("ever �� �ܾ�: " + entry.getKey() + "-" + entry.getValue() + "\n");
		
		// �����ڼ����� �����ϱ�
		NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
		Set<Entry<String, Integer>> descendingEntrySet = descendingMap.entrySet();
				
		for (Entry<String, Integer> e : descendingEntrySet ) {
			System.out.println(e.getKey() + "e.getValue()");
		}
		System.out.println();
		
		// ���� �˻�
		System.out.println("c-h ������ �ܾ� �˻�");
		NavigableMap<String, Integer> rangMap = treeMap.subMap("c", true, "h", false);
		
		for (Entry<String, Integer> e : rangMap.entrySet()) {
			System.out.println("-" + e.getKey() + "-" +e.getValue());;
			
		}
		
		
	}

}
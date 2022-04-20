// Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TopoSort {

	public static void main(String[] args) throws IOException {
		DListGraph dagListGraph = buildDListGraph(args[0]); // Creates list representation of DAG
		String result = DFS(dagListGraph); // Performs DFS operations on the DAG, returns result as a String
		System.out.println(stringFormatter(result)); // Formats the String and then prints it
	}
	
	public static String DFS(final DListGraph graph) {
		String result = ""; // Empty String for storing the result
		
		for(LinkedDListGraph i : graph.getList()) { // For each index in the list (For every Node in the graph)
			if((i.getNodeColor()).equals("WHITE")) { // If the list has not been visited (If the current Node hasn't been visited)
				result = graphDFS(graph, i, result); // DFS of that Node
			}
		}
		
		return result;
	}
	
	public static String graphDFS(final DListGraph graph, final LinkedDListGraph curNodeList, final String res) {
		String tempRes = res + Integer.toString(curNodeList.getNodeIndex()) + " ";
		curNodeList.setNodeColor(); // Changes Node's color to be GRAY
		DNode cur = curNodeList.getHead(); // Assigns the lists head to local variable (Current Node's next hop)
		
		while(cur != null) { // Iterates the list (Checks ALL of the Node's next hop neighbors)
			if((graph.getNodeList(cur.getnextNodeIndex())).getNodeColor().equals("WHITE")) { // Checks if lists visited color has been set (Checks if Node's next hop has been visited)
				tempRes = graphDFS(graph, graph.getNodeList(cur.getnextNodeIndex()), tempRes); // (Searches Node's next hop)
			}
			cur = cur.getNext(); // Iterates to next node in the list (Checks the current Node's other next hops)
		}
		
		curNodeList.setNodeColor(); // Changes Node's color to be BLACK
		return tempRes;
	}
	
	public static DListGraph buildDListGraph(final String fileName) throws IOException {
		Scanner fileReader = new Scanner(new File(fileName));
		
		int totalLines = 0; // Stores number of lines in the file
		while(fileReader.hasNext()) { // Counts the number of lines in the file
			fileReader.nextLine();
			totalLines++;
		}
		fileReader.close();
		
		fileReader = new Scanner(new File(fileName)); // Re-opens the file
		
		DListGraph tempDagListGraph = new DListGraph(totalLines);
		
		String sLine; // Stores read line and that has been stripped from all punctuation	
		while(fileReader.hasNext()) { // While the file still has lines to read from
			
			sLine = (fileReader.nextLine()).replaceAll("\\p{Punct}", ""); // Reads a single line from the file and strips all punctuation, storing to variable			
			for(int i = sLine.length() - 1; i > 0; i--) { // Add from last char from string to first (Pushing from Head on Linked List)
				tempDagListGraph.insert(Integer.parseInt(String.valueOf(sLine.charAt(0))) // Reads first character of the stripped String as the index to store elements
						, Integer.parseInt(String.valueOf(sLine.charAt(i)))); // index i represents the element to be stored			
			}
		}
		fileReader.close();
		
		return tempDagListGraph; 
	}
	
	public static String stringFormatter(final String res) {
		return (res.trim()).replaceAll(" ", ", "); // Formats result string, stripping the whitespace and replaces it with a comma and whitespace
	}

}

class DListGraph {
	protected LinkedDListGraph[] list;
	protected int size;
	protected int totalDNodes;
	
	public DListGraph(final int listSize) {
		this.size = 0;
		this.list = new LinkedDListGraph[listSize];
		this.totalDNodes = listSize;
		for(int i = 0; i < listSize; i++) {
			this.list[i] = new LinkedDListGraph(i);
		}
	}
	
	public void insert(final int index, final int element) {
		this.list[index].insert(element);
		this.size++;
	}
	
	public LinkedDListGraph[] getList() {
		return this.list;
	}
	
	public LinkedDListGraph getNodeList(final int listNodeIndex) {
		return this.list[listNodeIndex];
	}
}

class LinkedDListGraph { // Linked List representation of a Node's next hops
	protected DNode head; // The current Node's first next hop
	protected int size;
	protected String nodeColor; // Node's color
	protected int listDNodeIndex; // The current Node's Index (Element) value
	
	public LinkedDListGraph(final int listDNodeIndex) {
		this.head = null;
		this.size = 0;
		this.nodeColor = "WHITE"; // Default Node color is WHITE
		this.listDNodeIndex = listDNodeIndex;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public DNode getHead() {
		return this.head;
	}
	
	public int getNodeIndex() {
		return this.listDNodeIndex;
	}

	public String getNodeColor() {
		return this.nodeColor;
	}
	
	public void add(final DNode v) {
		if(v == null) {
			return;
		}
		
		v.setNext(head);
		this.head = v;
		this.size++;
	}
	
	public void insert(final int element) {
		DNode DNode = new DNode(element);
		add(DNode);
	}
	
	public void setNodeColor() {
		if((this.getNodeColor()).equals("WHITE")) { // If the Node is WHITE, change it to GRAY
			this.nodeColor = "GRAY";
		} else {  // If the Node is not WHITE but GRAY, change it to BLACK
			this.nodeColor = "BLACK";
		}
	}
	
}

class DNode {
	private int nextNodeIndex;
	private DNode next;
	
	public DNode(final int nextNodeIndex) {
		this(nextNodeIndex, null);
	}
	
	public DNode(final int nextNodeIndex, final DNode next) {
		this.nextNodeIndex = nextNodeIndex;
		this.next = next;
	}
	
	public int getnextNodeIndex() {
		return this.nextNodeIndex;
	}
	
	public DNode getNext() {
		return this.next;
	}
	
	public void setElement(final int nextNodeIndex) {
		this.nextNodeIndex = nextNodeIndex;
	}
	
	public void setNext(final DNode next) {
		this.next = next;
	}

}

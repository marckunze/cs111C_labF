import java.util.*;

/**
 * @author Karen Feng
 * @author Marc Kunze
 * @author Victor Ramirez
 */
public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
    implements SearchTreeInterface<T>, java.io.Serializable {

  public BinarySearchTreeWithDups() {
    super();
  }

  public BinarySearchTreeWithDups(T rootEntry) {
    super(rootEntry);
    setRootNode(new BinaryNode<T>(rootEntry));
  }

  @Override
  public T add(T newEntry) {
    T result = null;
    if (isEmpty()) {
      setRootNode(new BinaryNode<T>(newEntry));
    } else {
      result = addEntryHelperIterative(newEntry);
    }
    return result;
  }

  // ??? IMPLEMENT THIS METHOD
  private T addEntryHelperIterative(T newEntry) {
    // IMPORTANT: METHOD MUST BE ITERATIVE!!
    BinaryNodeInterface<T> currentNode = getRootNode();
    BinaryNodeInterface<T> newNode = new BinaryNode(newEntry);
    assert currentNode != null;
    T result = null;
    boolean found = false;

    while (!found) {
      T currentEntry = currentNode.getData();
      int comparison = newEntry.compareTo(currentEntry);

      if (comparison == 0) {
        //newEntry matches currentEntry
        //go into right subtree and add as normal
        //for BST
        if (currentNode.hasRightChild()) {
          currentNode = currentNode.getRightChild();
        } else {
          //newEntry already exists in BST (duplicate), add to right
          currentNode.setRightChild(newNode);
          found = true;
          result = currentNode.getData();
        }

      } else if (comparison < 0) {
        //New entry is less than current
        if (currentNode.hasLeftChild()) {
          //if current has a left child then go to that node, loop will repeat on that node
          currentNode = currentNode.getLeftChild();
        } else {
          found = true;
          currentNode.setLeftChild(new BinaryNode<T>(newEntry));
        } // end if
      } else {
        assert comparison > 0;

        if (currentNode.hasRightChild()) {
          currentNode = currentNode.getRightChild();
        } else {
          found = true;
          currentNode.setRightChild(new BinaryNode<T>(newEntry));
        }
      }
    }

    return result;
  }

  // ??? IMPLEMENT THIS METHOD
  public ArrayList<T> getAllEntriesIterative(T searchVal) {
		StackInterface<BinaryNodeInterface<T>> nodeStack = new LinkedStack<>();
		BinaryNodeInterface<T> currentNode = getRootNode();
		ArrayList<T> entryList = new ArrayList<T>();
		
		while (!nodeStack.isEmpty() || (currentNode != null)) {
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			if (!nodeStack.isEmpty()) {
				BinaryNodeInterface<T> nextNode = nodeStack.pop();
				assert nextNode != null;
				T currentEntry = nextNode.getData();
				int comparison = searchVal.compareTo(currentEntry);
				if (comparison == 0) {
					entryList.add(nextNode.getData());
					}
				currentNode = nextNode.getRightChild();
			} // end if

		} // end while

		return entryList;

	}
  

  // ??? IMPLEMENT THIS METHOD
  public ArrayList<T> getAllEntriesRecursive(T searchVal) {
    BinaryNodeInterface<T> rootNode = getRootNode(); //initialize with root node of tree
    ArrayList<T> entryList = new ArrayList<T>(); //initialize entry list.
    entryList = getAllEntriesHelper(searchVal, rootNode, entryList);
    return entryList;
  }

  private ArrayList<T> getAllEntriesHelper(T searchVal,BinaryNodeInterface<T> rootNode, ArrayList<T> entryList){
    ArrayList<T>result = new ArrayList<>();
    T foo = rootNode.getData();
    if (searchVal.equals(foo)){
      result.add(rootNode.getData());
    }
    if(rootNode.hasLeftChild()){
      result.addAll(getAllEntriesHelper(searchVal,rootNode.getLeftChild(),entryList));
    }
    if(rootNode.hasRightChild()){
      result.addAll(getAllEntriesHelper(searchVal,rootNode.getRightChild(),entryList));
    }

    return result;
  }

  // ??? IMPLEMENT THIS METHOD
  public ArrayList<T> getAllEntriesLessThanIterative(T searchVal) {
    // this initial code is meant as a suggestion to get your started- feel
    // free to use it or delete it!
    ArrayList<T> entryList = new ArrayList<T>();

    // Hint: consider using a stack to mimic recursion!
    // Stack<BinaryNodeInterface<T>> nodeStack = new
    // Stack<BinaryNodeInterface<T>>();
    // nodeStack.push(getRootNode());

    // while(!nodeStack.isEmpty()) {
    // }

    return entryList;
  }

  // ??? IMPLEMENT THIS METHOD
  public ArrayList<T> getAllEntriesLessThanRecursive(T searchVal) {
    BinaryNodeInterface<T> rootNode = getRootNode();
    ArrayList<T> entryList = new ArrayList<T>();
    entryList = getAllEntriesLessThanHelper(searchVal, rootNode, entryList);
    Collections.sort(entryList) ;
    return entryList;
  }

  private ArrayList<T> getAllEntriesLessThanHelper(T searchVal, BinaryNodeInterface<T> rootNode,
                                                   ArrayList<T> entryList){
    ArrayList<T>result = new ArrayList<>();
    T foo = rootNode.getData();
    if (searchVal.compareTo(foo) > 0){
      result.add(foo);
    }
    if(rootNode.hasLeftChild()){
      result.addAll(getAllEntriesLessThanHelper(searchVal,rootNode.getLeftChild(),entryList));
    }
    if(rootNode.hasRightChild()){
      result.addAll(getAllEntriesLessThanHelper(searchVal,rootNode.getRightChild(),entryList));
    }

    return result;

  }
}

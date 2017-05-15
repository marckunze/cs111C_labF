import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

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
    // this initial code is meant as a suggestion to get your started- feel
    // free to use it or delete it!
    BinaryNodeInterface<T> currentNode = getRootNode();
    ArrayList<T> entryList = new ArrayList<T>();

    // while(currentNode!=null) {
    // }

    return entryList;
  }

  // ??? IMPLEMENT THIS METHOD
  public ArrayList<T> getAllEntriesRecursive(T searchVal) {
    // this initial code is meant as a suggestion to get your started- feel
    // free to use it or delete it!
    BinaryNodeInterface<T> rootNode = getRootNode();
    ArrayList<T> entryList = new ArrayList<T>();
    // getAllEntriesHelper(searchVal, rootNode, entryList);

    return entryList;
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
    // this initial code is meant as a suggestion to get your started- feel
    // free to use it or delete it!
    BinaryNodeInterface<T> rootNode = getRootNode();
    ArrayList<T> entryList = new ArrayList<T>();
    // getAllEntriesLessThanHelper(searchVal, rootNode, entryList);

    return entryList;
  }
}

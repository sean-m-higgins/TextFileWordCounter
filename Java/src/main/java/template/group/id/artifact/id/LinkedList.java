//package template.group.id.artifact.id;

import java.util.Map;

class LinkedList	{

    LinkedList() {

    }
    
	Node head = null;
      
    private Node sortedMerge(Node left, Node right)  {
        Node result;
        // Base cases 
        if (left == null) 
            return right; 
        if (right == null) 
            return left; 
  
        // Pick either right or left, and recur
        if (left.val.getValue() <= right.val.getValue())
        {
			result = right;
			result.next = sortedMerge(left, right.next);
		}
        else 
        {
			result = left;
			result.next = sortedMerge(left.next, right);

        } 
        return result; 
    } 
  
    Node mergeSort(Node h)  { 
        // Base case : if head is null 
        if (h == null || h.next == null) { 
            return h; 
        } 
  
        // get the middle of the list 
        Node middle = getMiddle(h); 
        Node nextToMiddle = middle.next; 
  
        // set the next of middle Node to null 
        middle.next = null; 
  
        // Apply mergeSort on left list 
        Node left = mergeSort(h); 
  
        // Apply mergeSort on right list 
        Node right = mergeSort(nextToMiddle);
  
        // Merge the left and right lists
        return sortedMerge(left, right);
    } 
  
    // Utility function to get the middle of the linked list 
    private Node getMiddle(Node h)
    { 
        //Base case 
        if (h == null) 
            return h; 
        Node fastptr = h.next; 
        Node slowptr = h; 
          
        // Move fastptr by two and slowptr by one
        // Finally slowptr will point to middle Node 
        while (fastptr != null) 
        { 
            fastptr = fastptr.next; 
            if(fastptr!=null) 
            { 
                slowptr = slowptr.next; 
                fastptr=fastptr.next; 
            } 
        } 
        return slowptr; 
    } 
  
    void push(Map.Entry<String,Integer> new_data)  
    { 
        /* allocate Node */
        Node new_Node = new Node(new_data); 
  
        // link the old list off the new Node
        new_Node.next = head; 
  
        // move the head to point to the new Node
        head = new_Node; 
    } 
  
    // Utility function to print the linked list 
    void printList(Node headref)  
    { 
        while (headref != null)
        { 
            System.out.print(headref.val + " "); 
            headref = headref.next; 
        } 
    }

	void printTopTen(Node headref)
	{
		for (int i = 1; i < 11; i++)
		{
			System.out.print("\nThe #" + i + " word is: \""+ headref.val.getKey() 
				+ "\" with a count of: " + headref.val.getValue() + "\n");
			headref = headref.next;
		}
	}
}



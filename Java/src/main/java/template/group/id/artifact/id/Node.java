//package template.group.id.artifact.id;

import java.util.Map;

class Node  {
    Map.Entry<String,Integer> val; 
    Node next; 

    Node(Map.Entry<String,Integer> val)  {
        this.val = val; 
    }
} 
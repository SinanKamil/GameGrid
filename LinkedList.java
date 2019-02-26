public class LinkedList {
    private Node headNode;


    public void addNode(String sAirportID){

        //1. Create new node and fill in date.
        Node oNewNode = new Node();

        //2. Assign the head node to new node's nextnode variable.
        oNewNode.nextNode = headNode;

        //3. Set Headnode to new node.
        headNode = oNewNode;
    }

    public Node removeHeadNode(){

        //1. Set temp node to head node.
        Node oReturnNode  = headNode;
        //2. Set headNode to head node's next node.
        if(headNode != null){ headNode = headNode.nextNode;}
        //3. Return temp node.
        return oReturnNode;
    }
    public void addHeadNode(int x, int y){
        //1. Create new node
        Node city = new Node();
        //2. Set x and y on this new node
        city.xPosition = x;
        city.yPosition = y;
        //3. Set next node on this new node to head node
        city.nextNode = headNode;
        //4. Set head node to this new node
        headNode = city;
    }
}
